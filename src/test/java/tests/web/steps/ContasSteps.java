package tests.web.steps;

import org.junit.Assert;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import java.io.IOException;
import java.util.Properties;
import Framework.Utils.FilesOperation;
import tests.web.interactions.ContasInteractions;
import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;
import org.openqa.selenium.WebDriver;

public class ContasSteps {

    private ContasInteractions contasInteractions;
    private Properties properties; // Adicione uma variável para armazenar as propriedades

    public ContasSteps() {
        try {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.FIREFOX);
            contasInteractions = new ContasInteractions(driver);
        } catch (Exception e) {
            WebDriver driver = DriverManager.getDriver(TypeBrowser.CHROME);
            contasInteractions = new ContasInteractions(driver);
        }
        properties = new Properties(); // Inicialize a variável properties
    }

    @Dado("ao realizar o cadastro da primeira conta")
    public void ao_realizar_o_cadastro_da_primeira_conta() {
        String urlDoBanco = "https://bugbank.netlify.app/";
        contasInteractions.acessarPaginaDoBanco(urlDoBanco);
        contasInteractions.realizaCadastro1();
    }

    @Entao("realizo o login e armazeno o saldo da primeira conta")
    public void realizo_o_login_e_armazeno_o_saldo_da_primeira_conta() {
        contasInteractions.realizarLogin1();
    }

    @Dado("ao realizar o cadastro da segunda conta")
    public void ao_realizar_o_cadastro_da_segunda_conta() {
        contasInteractions.realizaCadastro2();
    }

    @Entao("realizo o login e armazeno o saldo da segunda conta")
    public void realizo_o_login_e_armazeno_o_saldo_da_segunda_conta() {
        contasInteractions.realizarLogin2();
    }

    @Dado("que estou logado na segunda conta e clico em transferência")
    public void que_estou_logado_na_segunda_conta_e_clico_em_transferência() {
        contasInteractions.clicarEmTransferencia();
    }

    @Dado("digito o numero da conta e o digito")
    public void digito_o_numero_da_conta_e_o_digito() {
        try {
            // Obtenha os valores do arquivo conta.properties
            properties = FilesOperation.getProperties("conta");
            String numeroConta = properties.getProperty("numeroConta");
            String digitoConta = properties.getProperty("digitoConta");

            // Execute ações para preencher os campos com os valores obtidos
            contasInteractions.digitarContaEDigito(numeroConta, digitoConta);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler conta.properties: " + e.getMessage());
        }
    }

    @Dado("digito o valor a ser transferido no campo valor da transferencia")
    public void digito_o_valor_a_ser_transferido_no_campo_valor_da_transferência() {
        contasInteractions.ValorDaTransferencia("200");
    }

    @Dado("digito um texto no campo descrição")
    public void digito_um_texto_no_campo_descrição() {
        contasInteractions.digitarDescricao("Texto da descrição");
    }

    @Dado("clico em transferir")
    public void clico_em_transferir() {
        contasInteractions.ClicarTransferir();
    }

    @Dado("verifico a mensagem de transferencia")
    public void verifico_a_mensagem_de_transferencia() {
        String textoEsperado = "Transferencia realizada com sucesso";
        String textoAtual = contasInteractions.obterMensagemDeTransferencia();

        Assert.assertEquals(textoEsperado, textoAtual);
    }

    @Dado("clico em fechar apos a transferencia")
    public void clico_em_fechar_apos_a_transferencia(){
        contasInteractions.clicarEmFecharModal();
    }

    @Entao("clico no botao voltar")
    public void clico_no_botao_voltar(){
        contasInteractions.clicarEmVoltar();
    }

    @Entao("clico em sair")
    public void clico_em_sair(){
        contasInteractions.clicarEmSair();
    }

    @Dado("que ao retornar a pagina inicial e realizar o login novamente na primeira conta e armazenar o saldo")
    public void que_ao_retornar_a_pagina_inicial_e_realizar_o_login_novamente_na_primeira_conta_e_armazenar_o_saldo(){
        contasInteractions.realizarLogin1B();
    }

    @Entao("clico em sair fim")
    public void clico_em_sair_fim(){
        contasInteractions.clicoEmSair();
    }



}
