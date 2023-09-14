package tests.web.validations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.web.interactions.ContasInteractions;

public class ContaValidations extends ContasInteractions {

    public ContaValidations(WebDriver driver) {
        super(driver);
    }

    @Override
    public void ClicarTransferir() {
        // Obtém o saldo antes da transferência
        String saldoAntes = obterSaldoDaConta();
        System.out.println("Saldo antes da transferência: " + saldoAntes);

        // Chama o método ClicarTransferir da classe pai (superclasse)
        super.ClicarTransferir();

        // Espera um tempo após a transferência (você pode ajustar esse tempo conforme necessário)
        try {
            Thread.sleep(5000); // Espera 5 segundos após a transferência
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtém o saldo após a transferência
        String saldoDepois = obterSaldoDaConta();
        System.out.println("Saldo depois da transferência: " + saldoDepois);

        // Valida o saldo após a transferência
        validarSaldoAposTransferencia(saldoAntes, saldoDepois);
    }

    // ... outros métodos e validações

    // Método para validar o saldo após a transferência
    private void validarSaldoAposTransferencia(String saldoAntes, String saldoDepois) {
        // Implemente sua lógica de validação aqui
        // Por exemplo, compare os saldos e emita mensagens de erro ou sucesso
        // Se o saldoDepois for diferente do esperado, você pode lançar uma exceção ou imprimir uma mensagem de erro
        if (!saldoAntes.equals(saldoDepois)) {
            throw new AssertionError("Erro: O saldo após a transferência não está correto.");
        } else {
            System.out.println("A transferência foi realizada com sucesso. Saldo atualizado corretamente.");
        }
    }

    // Método para obter o saldo da conta
    private String obterSaldoDaConta() {
        WebElement saldoElement = contaPages.getSaldoDaConta();
        return saldoElement.getText();
    }
}
