(function () {
    'use strict';

    angular.module('app')
        .controller('CarrinhoFormController', CarrinhoFormController);

    CarrinhoFormController.$inject = [
        'CarrinhoService',
        '$state',
        '$stateParams',
        'DialogBuilder',
        'ClienteService',
        'PecaService'
    ];

    function CarrinhoFormController(CarrinhoService, $state, $stateParams, DialogBuilder, ClienteService, PecaService) {

        var vm = this;
        vm.registro = {
            envio: new Date(),
            valorTotal: 0,
            itens: []

        };
        vm.error = {};
        vm.titulo = 'Novo Carrinho';

        vm.clientes = [];
        vm.pecas = [];

        vm.salvar = salvar;

        vm.itemOriginal = null;
        vm.registroItem = {};

        vm.excluirItem = excluirItem;
        vm.editarItem = editarItem;
        vm.salvarItem = salvarItem;
        vm.novoItem = novoItem;

        ClienteService.findAllOver()
            .then(function (data) {
                vm.clientes = data;
            });

        PecaService.findAllOver()
            .then(function (data) {
                vm.pecas = data;
            });

        if ($stateParams.id) {
            CarrinhoService.findById($stateParams.id)
                .then(function (data) {
                    vm.registro = data;
                    vm.registro.itens = vm.registro.itens || [];
                    vm.titulo = 'Editando Carrinho';
                });
        }

        function salvar() {
            if (!vm.registro.id) {
                CarrinhoService.insert(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Carrinho incluído com sucesso!');
                        $state.go('carrinhoList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            } else {
                CarrinhoService.update(vm.registro)
                    .then(function (dado) {
                        DialogBuilder.message('Carrinho alterado com sucesso!');
                        $state.go('carrinhoList');
                    })
                    .catch(function (error) {
                        vm.error = error.data;
                    });
            }
        }

        function novoItem() {
            vm.itemOriginal = null;
            vm.registroItem = {};
        }

        function editarItem(selecionado) {
            vm.itemOriginal = selecionado;
            angular.copy(selecionado, vm.registroItem);
        }

        function salvarItem() {
            // calcula o total do item
            vm.registroItem.valorTotal = vm.registroItem.quantidade * vm.registroItem.valorUnitario;

            var index = vm.registro.itens.indexOf(vm.itemOriginal);
            if (index !== -1) {
                vm.registro.itens[index] = vm.registroItem;
            } else {
                vm.registro.itens.push(vm.registroItem);
            }
            vm.itemOriginal = null;
            vm.registroItem = {};

            // calcula o total do pedido
            vm.registro.valorTotal = 0;
            vm.registro.itens.forEach(function (item) {
                vm.registro.valorTotal += item.valorTotal;
            });
        }
        function excluirItem(selecionado) {
            var index = vm.registro.itens.indexOf(selecionado);
            vm.registro.itens.splice(index, 1);

            // calcula o total do pedido
            vm.registro.valorTotal = 0;
            vm.registro.itens.forEach(function (item) {
                vm.registro.valorTotal += item.valorTotal;
            });

        }
    }


})();