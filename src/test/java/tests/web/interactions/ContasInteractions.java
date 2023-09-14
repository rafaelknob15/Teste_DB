package tests.web.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import tests.web.pages.ContaPages;
import Framework.Utils.FilesOperation;
import java.io.IOException;

public class ContasInteractions {

    private WebDriver driver;
    protected  ContaPages contaPages;
    private String urlDoBanco; // Adicione um campo para armazenar a URL

    private String saldoContaAtualizado2;

    public ContasInteractions(WebDriver driver) {
        this.driver = driver;
        this.contaPages = new ContaPages(driver);
    }

    public void acessarPaginaDoBanco(String url) {
        urlDoBanco = url; // Armazene a URL no campo de classe
        driver.get(url);
    }

    public void realizaCadastro1() {
        // Implemente as ações necessárias para realizar o cadastro aqui
        contaPages.acessarPaginaDoBanco(urlDoBanco); // Acesse a página usando a URL armazenada
        contaPages.btnRegistrar().click();
        contaPages.getemail().sendKeys("teste@gmail.com");
        contaPages.getNome().sendKeys("Primeira Conta");
        contaPages.getSenha().sendKeys("1234");
        contaPages.getconfirmaSenha().sendKeys("1234");
        contaPages.getSaldo().click();
        contaPages.btnCadastrar().click();
        contaPages.numeroDaConta().getText();
        contaPages.digitoDaConta().getText();

        String numeroDaConta = contaPages.numeroDaConta().getText();
        String[] splitNumeroDaConta = numeroDaConta.split("-");

        String numeroDaContaFormatado = splitNumeroDaConta[0].replaceAll("[^0-9]", "");
        String digitoDaConta = splitNumeroDaConta[1].replaceAll("[^0-9]", "");
        try {
            FilesOperation.setProperty("conta", "numeroConta", numeroDaContaFormatado);
            FilesOperation.setProperty("conta", "digitoConta", digitoDaConta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        contaPages.btnFechar().click();
    }

    public void realizarLogin1() {
        contaPages.getEmailLogin().sendKeys("teste@gmail.com");
        contaPages.getSenhaLogin().sendKeys("1234");
        contaPages.btnAcessar().click();

        WebElement saldoElement = contaPages.getSaldoDaConta();
        String saldo = saldoElement.getText();

        try {
            FilesOperation.setSaldo("1", saldo); // Para a primeira conta
            // Ou FilesOperation.setSaldo("2", saldo); para a segunda conta.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saldo da primeira conta:" + saldo);
        contaPages.getBntSair().click();
    }

    public void realizaCadastro2() {
        contaPages.btnRegistrar().click();
        contaPages.getemail().sendKeys("teste2@gmail.com");
        contaPages.getNome().sendKeys("segundaConta");
        contaPages.getSenha().sendKeys("1234");
        contaPages.getconfirmaSenha().sendKeys("1234");
        contaPages.getSaldo().click();
        contaPages.btnCadastrar().click();
        contaPages.btnFechar().click();
    }

    public void realizarLogin2() {
        contaPages.getEmailLogin().sendKeys("teste2@gmail.com");
        contaPages.getSenhaLogin().sendKeys("1234");
        contaPages.btnAcessar().click();

        WebElement saldoElement = contaPages.getSaldoDaConta();
        String saldo = saldoElement.getText();

        try {
            FilesOperation.setSaldo("2", saldo); //para a segunda conta.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saldo da segunda conta:" + saldo);
    }

    public void clicarEmTransferencia() {
        contaPages.getBntTransferencia().click();
    }

    public void digitarContaEDigito(String conta, String digito) {
        contaPages.digitarConta(conta);
        contaPages.digitarDigito(digito);
    }

    public void ValorDaTransferencia(String valor) {
        WebElement transferenciaElement = contaPages.getDigitarTransferencia();
        transferenciaElement.sendKeys(valor);
    }

    public void digitarDescricao(String descricao) {
        contaPages.digitarDescricao(descricao);
    }

    public void ClicarTransferir() {
        contaPages.BtnTransferir().click();
    }

    public String obterMensagemDeTransferencia() {
        WebElement mensagemTransferencia = contaPages.getMensagemTransferencia();
        return mensagemTransferencia.getText();
    }

    public void clicarEmFecharModal() {
        contaPages.btnFecharModal().click();
    }

    public void clicarEmVoltar() {
        contaPages.btnVoltar().click();

        WebElement saldoElement = contaPages.getSaldoDaConta();
        String saldo = saldoElement.getText();

        try {
            FilesOperation.setSaldo("2", saldo); // Atualize o saldo no arquivo "saldo.properties"
            saldoContaAtualizado2 = saldo; // Armazene o saldo atualizado na classe
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saldo atualizado apos a transferencia da segunda conta:" + saldo);
    }

    public String getSaldoContaAtualizado2() {
        return saldoContaAtualizado2;
    }

    public void clicarEmSair() {
        contaPages.getBntSair().click();
    }

    public void realizarLogin1B() {
        contaPages.getEmailLogin().sendKeys("teste@gmail.com");
        contaPages.getSenhaLogin().sendKeys("1234");
        contaPages.btnAcessar().click();
        WebElement saldoElement = contaPages.getSaldoDaConta();
        String saldo = saldoElement.getText();


        try {
            FilesOperation.setSaldo("1", saldo); // Atualize o saldo no arquivo "saldo.properties"
            saldoContaAtualizado2 = saldo; // Armazene o saldo atualizado na classe
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saldo atualizado apos a transferencia da primeira conta:" + saldo);
    }

    public void clicoEmSair(){
        contaPages.getBntSair().click();
    }


}
