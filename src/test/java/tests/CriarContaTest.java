import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class CriarContaTest {
    @Test
    public void testCriarContaeRealizarTransferencia() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafael.knob\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.get("https://bugbank.netlify.app/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botaoRegistrar = navegador.findElement(By.xpath("//button[@type='button' and contains(@class, 'style__ContainerButton-sc-1wsixal-0') and text()='Registrar']"));
        botaoRegistrar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement campoEmail = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input"));
        campoEmail.click();
        campoEmail.clear();
        campoEmail.sendKeys("teste@gmail.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperar até que o campo de nome seja visível
        WebElement campoNome = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input"));

        campoNome.click();
        campoNome.clear();
        campoNome.sendKeys("Nome do Teste");  // Substitua pelo nome desejado

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperar até que o campo de senha seja visível
        WebElement campoSenha = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input"));

        campoSenha.click();
        campoSenha.clear();
        campoSenha.sendKeys("1234");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperar até que o campo de confirmação de senha seja visível
        WebElement campoConfirmacaoSenha = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input"));

        campoConfirmacaoSenha.click();
        campoConfirmacaoSenha.clear();
        campoConfirmacaoSenha.sendKeys("1234");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no botão "Adicionar Saldo" usando XPath
        WebElement botaoAdicionarSaldo = navegador.findElement(By.xpath("//label[@id='toggleAddBalance']"));

        // Clicando no botão "Adicionar Saldo"
        botaoAdicionarSaldo.click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botaoCadastrar = navegador.findElement(By.xpath("//button[@type='submit' and contains(@class, 'style__ContainerButton-sc-1wsixal-0') and text()='Cadastrar']"));
        botaoCadastrar.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botaoFechar = navegador.findElement(By.xpath("//*[@id='btnCloseModal']"));
        botaoFechar.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fazer login na primeira conta
        WebElement campoEmailS = navegador.findElement(By.xpath("//input[@type='email' and @name='email']"));
        campoEmailS.sendKeys("teste@gmail.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement campoSenhaS = navegador.findElement(By.xpath("//input[@name='password']"));
        campoSenhaS.sendKeys("1234");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement botaoAcessar = navegador.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[1]"));
        botaoAcessar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Obter e armazenar o número da conta
        WebElement numeroConta = navegador.findElement(By.xpath("//*[@id='textAccountNumber']/span"));
        String numeroContaTexto = numeroConta.getText();

// Extrair os números antes do sinal "-"
        String[] partesNumeroConta = numeroContaTexto.split("-");
        String numerosAntesDoHifen = partesNumeroConta[0];
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obter e armazenar o saldo da conta
        WebElement saldoConta = navegador.findElement(By.xpath("//*[@id='textBalance']/span"));
        String saldoContaTexto = saldoConta.getText();
        // Filtrar e armazenar apenas os dígitos numéricos e a vírgula do saldo
        // String saldoNumerico2 = saldoContaTexto2.replaceAll("[^0-9,]", "");

        // Filtrar e armazenar apenas os dígitos numéricos do saldo

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibir o saldo da conta no console
        System.out.println("Primeira conta criada, saldo: " + saldoContaTexto);
        System.out.println();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Clicar no botão "Sair"
        WebElement botaoSair = navegador.findElement(By.xpath("//*[@id='btnExit']"));
        botaoSair.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Localizar novamente o botão "Registrar"
        botaoRegistrar = navegador.findElement(By.xpath("//button[@type='button' and contains(@class, 'style__ContainerButton-sc-1wsixal-0') and text()='Registrar']"));
        botaoRegistrar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Clicar no campo email
        campoEmail = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input"));
        campoEmail.click();
        campoEmail.clear();
        campoEmail.sendKeys("teste2@gmail.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Clicar no campo nome
        campoNome = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input"));
        campoNome.click();
        campoNome.clear();
        campoNome.sendKeys("Nome do Teste2");  // Substitua pelo nome desejado

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperar até que o campo de senha seja visível
        campoSenha = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input"));
        campoSenha.click();
        campoSenha.clear();
        campoSenha.sendKeys("1234");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Esperar até que o campo de confirmação de senha seja visível
        campoConfirmacaoSenha = navegador.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input"));
        campoConfirmacaoSenha.click();
        campoConfirmacaoSenha.clear();
        campoConfirmacaoSenha.sendKeys("1234");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no botão "Adicionar Saldo" usando XPath
        botaoAdicionarSaldo = navegador.findElement(By.xpath("//label[@id='toggleAddBalance']"));

        // Clicando no botão "Adicionar Saldo"
        botaoAdicionarSaldo.click();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        botaoCadastrar = navegador.findElement(By.xpath("//button[@type='submit' and contains(@class, 'style__ContainerButton-sc-1wsixal-0') and text()='Cadastrar']"));
        botaoCadastrar.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        botaoFechar = navegador.findElement(By.xpath("//*[@id='btnCloseModal']"));
        botaoFechar.click();

        // Fazer login na segunda conta
        campoEmailS = navegador.findElement(By.xpath("//input[@type='email' and @name='email']"));
        campoEmailS.sendKeys("teste2@gmail.com");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        campoSenhaS = navegador.findElement(By.xpath("//input[@name='password']"));
        campoSenhaS.sendKeys("1234");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        botaoAcessar = navegador.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[1]"));
        botaoAcessar.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obter e armazenar o número da segunda conta
        numeroConta = navegador.findElement(By.xpath("//*[@id='textAccountNumber']/span"));
        //String tresPrimeirosDigitos2 = numeroContaTexto.substring(0, 3);  // Extrair os 3 primeiros dígitos

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obter e armazenar o saldo da conta
        saldoConta = navegador.findElement(By.xpath("//*[@id='textBalance']/span"));
        String saldoContaTexto2 = saldoConta.getText();

        // Filtrar e armazenar apenas os dígitos numéricos e a vírgula do saldo
        String saldoNumerico2 = saldoContaTexto2.replaceAll("[^0-9,]", "");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibir o saldo da segunda conta no console
        System.out.println("Segunda conta criada, saldo: " + saldoNumerico2);
        System.out.println();

        // Exibir o saldo da conta no console
        //System.out.println("Primeira conta criada, saldo: " + saldoContaTexto);
        //System.out.println();

        // Clicar no botão de transferência
        WebElement botaoTransferencia = navegador.findElement(By.xpath("//*[@id='btn-TRANSFERÊNCIA']/span/img"));
        botaoTransferencia.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Digitar os números antes do sinal "-" da conta no campo de destino da transferência
        WebElement campoNumeroContaDestino = navegador.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[1]/input"));
        campoNumeroContaDestino.sendKeys(numerosAntesDoHifen);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Digitar apenas o último dígito da conta no campo "Dígito"
        WebElement campoDigito = navegador.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[2]/input"));
        campoDigito.sendKeys(numeroContaTexto.substring(numeroContaTexto.length() - 1));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no campo de valor da transferência e inserir um valor desejado
        WebElement campoValorTransferencia = navegador.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[2]/input"));
        campoValorTransferencia.click();
        campoValorTransferencia.clear();
        campoValorTransferencia.sendKeys("350"); // Substitua pelo valor desejado

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no campo de descrição e inserir a descrição desejada
        WebElement campoDescricao = navegador.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[3]/input"));
        campoDescricao.click();
        campoDescricao.clear();
        campoDescricao.sendKeys("Transferência de teste"); // Substitua pela descrição desejada

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no botão de transferir
        WebElement botaoTransferir = navegador.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/button"));
        botaoTransferir.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar em fechar apos a transferencia
        WebElement botaoFecharTransferencia = navegador.findElement(By.xpath("//*[@id='btnCloseModal']"));
        botaoFecharTransferencia.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar em voltar
        WebElement botaoVoltar = navegador.findElement(By.xpath("//*[@id='btnBack']"));
        botaoVoltar.click();

        try {
            Thread.sleep(2000);  // Espera de 2 segundos após clicar em voltar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obter e armazenar o saldo da conta após a transferência
        saldoConta = navegador.findElement(By.xpath("//*[@id='textBalance']/span"));
        String saldoContaTextoAposTransferencia = saldoConta.getText();

        // Filtrar e armazenar apenas os dígitos numéricos e a vírgula do saldo
        String saldoNumericoAposTransferencia = saldoContaTextoAposTransferencia.replaceAll("[^0-9,]", "");

        // Converter os saldos para valores numéricos para comparação
        double saldoAntesTransferencia = Double.parseDouble(saldoNumerico2.replace(",", "").replace(".", ""));
        double saldoAposTransferencia = Double.parseDouble(saldoNumericoAposTransferencia.replace(",", "").replace(".", ""));

        // Verificar se o saldo após a transferência é menor que o saldo antes da transferência
        if (saldoAposTransferencia < saldoAntesTransferencia) {
            System.out.println("A segunda conta realizou uma Transferência, Saldo atualizado corretamente.");
            System.out.println();
        } else {
            System.out.println("Erro na transferência. Saldo não foi atualizado corretamente.");
            System.out.println();
        }

        // Exibir o saldo da segunda conta após a transferência no console
        System.out.println("Saldo da segunda conta atualizado: " + saldoNumericoAposTransferencia);
        System.out.println();

        try {
            Thread.sleep(2000);  // Aguardar após clicar em sair
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no botão "Sair"
        WebElement botaoSairFinal = navegador.findElement(By.xpath("//*[@id='btnExit']"));
        botaoSairFinal.click();

        try {
            Thread.sleep(2000);  // Aguardar após clicar em sair
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no campo de e-mail e preencher com o e-mail da primeira conta
        WebElement campoEmailLogin = navegador.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[1]/input"));
        campoEmailLogin.click();
        campoEmailLogin.clear();
        campoEmailLogin.sendKeys("teste@gmail.com");  // Substitua pelo e-mail da primeira conta

        try {
            Thread.sleep(2000);  // Aguardar após preencher o e-mail
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no campo de senha e preencher com a senha da primeira conta
        WebElement campoSenhaLogin = navegador.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[2]/div/input"));
        campoSenhaLogin.click();
        campoSenhaLogin.clear();
        campoSenhaLogin.sendKeys("1234");  // Substitua pela senha da primeira conta

        try {
            Thread.sleep(2000);  // Aguardar após preencher a senha
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clicar no botão "Acessar"
        WebElement botaoAcessarLogin = navegador.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[1]"));
        botaoAcessarLogin.click();

        try {
            Thread.sleep(4000);  // Aguardar após clicar em "Acessar"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibir o saldo da primeira conta após a transferência no console
        WebElement saldoContaAposTransferencia = navegador.findElement(By.xpath("//*[@id='textBalance']/span"));
        String saldoContaAposTransferenciaTexto = saldoContaAposTransferencia.getText();

        // Filtrar e armazenar apenas os dígitos numéricos do saldo
        saldoNumericoAposTransferencia = saldoContaAposTransferenciaTexto.replaceAll("[^0-9]", "");
        double saldoNumericoDouble = Double.parseDouble(saldoNumericoAposTransferencia);

        System.out.println("Saldo da primeira conta atualizado. Saldo atualizado: " + saldoContaAposTransferenciaTexto);
        System.out.println();

        // Calcular o valor da transferência recebida
        double valorTransferenciaRecebida = saldoNumericoDouble - saldoAntesTransferencia;

        // Exibir o valor da transferência recebida
        System.out.println("Valor da transferência recebida pela primeira conta: " + String.format("R$ %.2f", valorTransferenciaRecebida / 100.0));

        navegador.quit();
    }

}