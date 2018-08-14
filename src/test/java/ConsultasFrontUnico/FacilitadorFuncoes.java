package ConsultasFrontUnico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FacilitadorFuncoes extends DriverPage {
    //Nessa classe, será armazenado os métodos para serem chamados da classe que será realizado o teste

    public WebElement getElement(String id) {
        return driver.findElement((By.id(id)));
    }

    public WebElement getElementXpath(String xpath) {
        return driver.findElement((By.xpath(xpath)));
    }

    public void efetuarLogin(String usuario, String senha) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginModel_Usuario")));
        getElement("LoginModel_Usuario").click();
        getElement("LoginModel_Usuario").sendKeys(usuario);
        getElement("LoginModel_Senha").sendKeys(senha);
        getElement("rdDominio").click();
        getElement("btnEfetuarLogin").click();

    }

    public void selecaoHierarquias() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("LoginModel.Hierarquia")));
        getElementXpath("//div[@id='tableLogin']//*[@id='LoginModel_Hierarquia']").click();
        WebElement campoUnidade = driver.findElement(By.xpath("//div[@id='tableLogin']//*[@id='LoginModel_Hierarquia']"));
        new Select(campoUnidade).selectByVisibleText("Lojas > SP1 > 2SPP - Pinheiros");

        getElement("btnConcluirAutenticacao").click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void pesquisarCartoesDadosCartao() throws Exception {
        // Inicio do Teste, onde esta identificando o cliente por pesquisa do numero de cartao
        getElementXpath("//a[@id='icl_IdentificaCliente']").click();

        // Criar um Array List que receba os dados da planilha do Excel em que é enviad para a classe "LerExcel" a
        // PRIMEIRA COLUNA com os dados (0).

        ArrayList<String> lista = LerExcel.leituraCartao(0);

        //Laço de repetição que insere os números dos cartões do Excel um a um.
        for (int i = 1; i < lista.size(); i++) {
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            getElementXpath("//input[@id='icl_filtroNumeroCartao']").sendKeys(lista.get(i));
            getElementXpath("//*[contains(text(), 'OK')]").click();

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            // Acessando no menu da tabela, os dados do cartão
            getElementXpath("//a[contains(@id,'tabDadosCartao')]").click();
            getElementXpath("//a[contains(@id,'tabDadosCartao')]").click();
            //Finaliza
            getElementXpath("//a[@id='icl_FinalizarCliente']").click();
            getElementXpath("//button[@type='button' and span='Sim']").click();

            //Iniciar o atendimento do proximo cartao da lista
            driver.findElement(By.xpath("//a[@id='icl_IdentificaCliente']")).click();

        }
    }
        public void pesquisarCartoesDadosCadastrais() throws Exception {
            // Inicio do Teste, onde esta identificando o cliente por pesquisa do numero de cartao
            getElementXpath("//a[@id='icl_IdentificaCliente']").click();
            ArrayList<String> lista2 = LerExcel.leituraCartao(0);

            for (int i = 1; i < lista2.size(); i++) {
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                getElementXpath("//input[@id='icl_filtroNumeroCartao']").sendKeys(lista2.get(i));
                getElementXpath("//*[contains(text(), 'OK')]").click();

                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                // Acessando no menu da tabela, os dados do cartão
                getElementXpath("//a[contains(@id,'tabDadosCadastrais')]").click();
                getElementXpath("//a[contains(@id,'tabDadosCadastrais')]").click();

                //Finaliza
                getElementXpath("//a[@id='icl_FinalizarCliente']").click();
                getElementXpath("//button[@type='button' and span='Sim']").click();

                //Iniciar o atendimento do proximo cartao da lista
                driver.findElement(By.xpath("//a[@id='icl_IdentificaCliente']")).click();

            }

        }
    }

