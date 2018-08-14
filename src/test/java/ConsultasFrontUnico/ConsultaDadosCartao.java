package ConsultasFrontUnico;

import org.junit.Before;
import org.junit.Test;

public class ConsultaDadosCartao {
    FacilitadorFuncoes facilit = new FacilitadorFuncoes();

    @Before
    public void setUp(){
        facilit.getChrome("http://10.113.75.9/FUN/Login.mvc/");
        facilit.efetuarLogin("44786992836","Cog2018@");
        facilit.selecaoHierarquias();
    }
    @Test
    public void realizarPesquisa() throws Exception {
        facilit.pesquisarCartoesDadosCartao();
    }

    }







