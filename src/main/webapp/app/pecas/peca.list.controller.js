(function(){
  'use strict';

    angular.module('app')
        .controller('PecaListController', PecaListController);
  
    PecaListController.$inject = ['PecaService', 'DialogBuilder'];
  
  function PecaListController(PecaService, DialogBuilder) {
  
        var vm = this;
        vm.data = {};
        vm.filtro = '';
        vm.page = {
            number: 1,
            size: '15'
        };
  
        vm.atualizar = load;
        vm.resetFiltro = function () {
            vm.filtro = '';
            load();
        };

        vm.goToPage = function (page) {
            vm.page.number = page;
            load();
        };

        function load() {
            PecaService.findAll(vm.filtro, vm.page)
              .then(function (dados) {
                vm.data = dados;
              });
        }
  
        vm.excluir = function(item) {
            DialogBuilder.confirm('Tem certeza que deseja remover a peca?')
                .then(function (result) {
                    if (result.value) {
                      PecaService.remove(item.id)
                            .then(function () {
                                load();
                                DialogBuilder.message('Peca excluída com sucesso!');
                            });
                    } else {
                        DialogBuilder.message({
                            title: 'Exclusão cancelada pelo usuário!',
                            type: 'error'
                        });
                    }
                });
        };
        load();
    }
})();