(function(){
  'use strict';

  angular.module('app')
    .controller('MaterialFormController', MaterialFormController);

  MaterialFormController.$inject = ['MaterialService', '$state', '$stateParams', 'DialogBuilder'];

  function MaterialFormController(MaterialService, $state, $stateParams, DialogBuilder) {
    
    var vm = this;
    vm.registro = {};
    vm.error = {};
    
    vm.titulo = 'Novo Material';    
    vm.salvar = salvar; 

    if ($stateParams.id) {
      MaterialService.findById($stateParams.id)
        .then(function (data) {
          vm.registro = data;
          vm.titulo = 'Editando Material';
        });
  }
function salvar() {
    if (!vm.registro.id) {
      MaterialService.insert(vm.registro)
        .then(function (dado) {
          DialogBuilder.message('Material inserido com sucesso!');
          $state.go("materialList");
        })
        .catch(function (error) {
          vm.error = error.data;
        });
    } else {
      MaterialService.update(vm.registro)
        .then(function(dado){
          DialogBuilder.message('Material alterado com sucesso!');
          $state.go("material");
        })
        .catch(function (error) {
          vm.error = error.data;
        });
    }
  }
}
})();