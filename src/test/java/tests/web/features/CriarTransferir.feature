#language: pt

Funcionalidade: Criar conta e realizar tranferencia


Cenário: Criar a primeira conta
Dado ao realizar o cadastro da primeira conta
Entao realizo o login e armazeno o saldo da primeira conta


Dado ao realizar o cadastro da segunda conta
Entao realizo o login e armazeno o saldo da segunda conta

Dado que estou logado na segunda conta e clico em transferência
E digito o numero da conta e o digito
E digito o valor a ser transferido no campo valor da transferencia
E digito um texto no campo descrição
E clico em transferir
E verifico a mensagem de transferencia
E clico em fechar apos a transferencia
E clico no botao voltar
Entao clico em sair

Dado que ao retornar a pagina inicial e realizar o login novamente na primeira conta e armazenar o saldo
Entao clico em sair fim
