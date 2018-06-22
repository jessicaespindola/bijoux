(function(){
    
    angular.module('app', [
      'ui.router'
  ]);

    angular.module('app').config(AppConfig);
    
    AppConfig.$inject = ['$stateProvider'];

    function AppConfig($stateProvider) {

        $stateProvider
            .state({
            name: 'inicio',
            url: '/inicio',
            templateUrl: '/view/inicio/list.html',
            controllerAs: 'vm'
            })
          .state({
            name: 'clientes',
            url: '/clientes',
            templateUrl: '/view/clientes/list.html',
            controller: 'ClienteListController',
            controllerAs: 'vm'
          })
          .state({
            name: 'clientesNovo',
            url: '/clientes/novo',
            templateUrl: '/view/clientes/form.html',
            controller: 'ClienteFormController',
            controllerAs: 'vm'
          })
          
          .state({
            name: 'clientesEditar',
            url: '/clientes/{id}',
            templateUrl: '/view/clientes/form.html',
            controller: 'ClienteFormController',
            controllerAs: 'vm'
          })
          .state({
            name: 'pecasList',
            url: '/pecas',
            templateUrl: '/view/pecas/list.html',
            controller: 'PecaListController',
            controllerAs: 'vm'
          })
          .state({
            name: 'pecasNovo',
            url: '/pecas/novo',
            templateUrl: '/view/pecas/form.html',
            controller: 'PecaFormController',
            controllerAs: 'vm'
          })

          .state({
            name: 'pecasEditar',
            url: '/pecas/{id}',
            templateUrl: '/view/pecas/form.html',
            controller: 'PecaFormController',
            controllerAs: 'vm'
          })
          .state({
            name: 'carrinhoList',
            url: '/carrinho',
            templateUrl: '/view/carrinho/list.html',
            controller: 'CarrinhoListController',
            controllerAs: 'vm'
          })
          .state({
            name: 'carrinhoNovo',
            url: '/carrinho/novo',
            templateUrl: '/view/carrinho/form.html',
            controller: 'CarrinhoFormController',
            controllerAs: 'vm'
          })

          .state({
            name: 'carrinhoEditar',
            url: '/carrinho/{id}',
            templateUrl: '/view/carrinho/form.html',
            controller: 'CarrinhoFormController',
            controllerAs: 'vm'
          })
          .state({
            name: 'materialList',
            url: '/material',
            templateUrl: '/view/material/list.html',
            controller: 'MaterialListController',
            controllerAs: 'vm'
          })
          
          .state({
            name: 'materialNovo',
            url: '/material/novo',
            templateUrl: '/view/material/form.html',
            controller: 'MaterialFormController',
            controllerAs: 'vm'
          })

          .state({
            name: 'materialEditar',
            url: '/material/{id}',
            templateUrl: '/view/material/form.html',
            controller: 'MaterialFormController',
            controllerAs: 'vm'
          })
           .state({
            name: 'servicos',
            url: '/servicos',
            templateUrl: '/view/servicos/list.html',
            controller: 'ClienteListController',
            controllerAs: 'vm'
            });
    }
})();

