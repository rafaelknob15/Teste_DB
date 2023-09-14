    package tests.web.pages;

    import Framework.Browser.Waits;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;

    public class ContaPages {

        private WebDriver driver;
        private Waits waits; // Adicione a variável waits



        public ContaPages(WebDriver driver) {
            this.driver = driver;
            waits = new Waits(driver); // Inicialize waits com o driver
        }

        public void acessarPaginaDoBanco(String url) {
            driver.get(url);
        }

        public WebElement btnRegistrar() {
            return waits.visibilityOfElement(By.xpath("//button[contains(text(), 'Registrar') and contains(@class, 'style__ContainerButton')]"));
        }

        public WebElement getemail() {
            return waits.visibilityOfElement(By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']//input[@type='email' and @class='input__default' and @name='email']"));
        }

        public WebElement getNome() {
            return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe seu Nome']"));
        }

        public WebElement getSenha() {
            return waits.visibilityOfElement(By.xpath("//form[@class='styles__ContainerFormRegister-sc-7fhc7g-0 keVbpY']//input[@placeholder='Informe sua senha']"));
        }

        public WebElement getconfirmaSenha() {
            return waits.visibilityOfElement(By.xpath("//input[@placeholder='Informe a confirmação da senha']"));
        }

        public WebElement getSaldo() {
            return driver.findElement(By.xpath("//label[@id='toggleAddBalance']"));
        }

        public WebElement btnCadastrar() {
            return waits.visibilityOfElement(By.xpath("//button[normalize-space()='Cadastrar']"));
        }

        public WebElement numeroDaConta() {
            return waits.visibilityOfElement(By.id("modalText"));
        }

        public WebElement digitoDaConta() {
            return waits.visibilityOfElement(By.id("modalText"));
        }

        public WebElement btnFechar() {
            return waits.visibilityOfElement(By.xpath("//a[@id='btnCloseModal' and @class='styles__Button-sc-8zteav-5 gyHUvN']"));
        }

        public WebElement getEmailLogin(){
            return waits.visibilityOfElement(By.name("email"));
        }

        public WebElement getSenhaLogin(){
            return waits.visibilityOfElement(By.xpath("(//input[@type='password' and @class='input__default'])[1]"));}

        public WebElement btnAcessar(){
            return waits.visibilityOfElement(By.xpath("//button[@type='submit' and @class='style__ContainerButton-sc-1wsixal-0 otUnI button__child']"));
        }

        public WebElement getSaldoDaConta() {
            return waits.visibilityOfElement(By.xpath("//*[@id='textBalance']/span"));
        }

        public WebElement getBntSair(){
            return waits.visibilityOfElement(By.xpath("//*[@id='btnExit']"));
        }

        public WebElement getBntTransferencia(){
            return waits.visibilityOfElement(By.xpath("//*[@id='btn-TRANSFERÊNCIA']/span/img"));
        }

        public void digitarConta(String conta) {
            WebElement contaElement = waits.visibilityOfElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[1]/input"));
            contaElement.sendKeys(conta);
        }

        public void digitarDigito(String digito) {
            WebElement digitoElement = waits.visibilityOfElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[2]/input"));
            digitoElement.sendKeys(digito);
        }

        public WebElement getDigitarTransferencia() {
            return waits.visibilityOfElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[2]/input"));
        }

        public void digitarDescricao(String descricao) {
            WebElement descricaoElement = driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[3]/input"));
            descricaoElement.sendKeys(descricao);
        }

        public WebElement BtnTransferir() {
            WebElement transferirElement = waits.visibilityOfElement(By.xpath("//*[@id='__next']/div/div[3]/form/button"));
            return transferirElement;
        }

        public WebElement getMensagemTransferencia() {
            return waits.visibilityOfElement(By.xpath("//*[@id='modalText']"));
        }

        public WebElement btnFecharModal() {
            return waits.visibilityOfElement(By.xpath("//*[@id='btnCloseModal']"));
        }

        public WebElement btnVoltar() {
            return waits.visibilityOfElement(By.xpath("//*[@id='btnBack']"));
        }


    }
