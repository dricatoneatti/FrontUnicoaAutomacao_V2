package ConsultasFrontUnico;

import org.junit.Before;
import org.junit.Test;

public class ConsultaDadosCadastrais {
    FacilitadorFuncoes facilit = new FacilitadorFuncoes();

    @Before
    public void setUp (){
        facilit.getChrome("http://10.113.75.9/FUN/Principal.mvc/");
        facilit.efetuarLogin("44786992836","Cog2018@");
        facilit.selecaoHierarquias();
    }

    @Test
    public void realizarConsultaCadastral() throws Exception{
        facilit.pesquisarCartoesDadosCadastrais();
    }
}
