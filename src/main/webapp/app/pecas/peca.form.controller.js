(function(){
  'use strict';

  angular.module('app')
    .controller('PecaFormController', PecaFormController);

  PecaFormController.$inject = ['PecaService', '$state', '$stateParams', 'DialogBuilder'];

  function PecaFormController(PecaService, $state, $stateParams, DialogBuilder) {
    
    var vm = this;
    vm.registro = {};
    vm.error = {};
    
    vm.titulo = 'Nova Peça';    
    vm.salvar = salvar; 

    if ($stateParams.id) {
      PecaService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
          vm.titulo = 'Editando Peça';
        });
  }
function salvar() {
    if (!vm.registro.id) {
      PecaService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Peça inserida com sucesso!');
          $state.go("pecasList");
        })
        .catch(function (error) {
          vm.error = error.data;
        });
    } else {
      PecaService.update(vm.registro)
        .then(function(dado){
          DialogBuilder.message('Peça alterada com sucesso!');
          $state.go("pecas");
        })
        .catch(function (error) {
          vm.error = error.data;
        });
    }
  }
}
})();