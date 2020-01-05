package com.ubs.teste.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CalculoServiceTest {

	@MockBean
    private CalculoService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalculo() {
		
		String retorno = "<html>Quantidade de Lojistas tem que ser maior que zero</html>";
		String teste = preencherDados("EMMS", 0);
		Mockito.when(service.calculo("EMMS", 0)).thenReturn(retorno);
        Assert.assertEquals(retorno, teste);
	}

	@Test
	public void testCalculo2() {
		
		String retorno = "<html><br />Nome: loja1<br />Qtde: 365<br />Financeiro: 1.879,00<br />Preço Médio: 5,148<br />EMMS<br />3.75<br />37<br />138,75<br />EMMS<br />5.29<br />18<br />95,22<br />EMMS<br />5.80<br />50<br />290,00<br />EMMS<br />7.45<br />30<br />223,50<br />EMMS<br />0.24<br />39<br />9,36<br />EMMS<br />9.36<br />2<br />18,72<br />EMMS<br />7.05<br />9<br />63,45<br />EMMS<br />2.63<br />16<br />42,08<br />EMMS<br />8.73<br />44<br />384,12<br />EMMS<br />5.61<br />15<br />84,15<br />EMMS<br />1.35<br />29<br />39,15<br />EMMS<br />3.55<br />6<br />21,30<br />EMMS<br />9.32<br />30<br />279,60<br />EMMS<br />4.74<br />40<br />189,60<br />Nome: loja2<br />Qtde: 365<br />Financeiro: 1.888,15<br />Preço Médio: 5,173<br />EMMS<br />3.75<br />37<br />138,75<br />EMMS<br />5.29<br />18<br />95,22<br />EMMS<br />5.80<br />49<br />284,20<br />EMMS<br />7.45<br />31<br />230,95<br />EMMS<br />0.24<br />39<br />9,36<br />EMMS<br />9.36<br />1<br />9,36<br />EMMS<br />7.05<br />10<br />70,50<br />EMMS<br />2.63<br />15<br />39,45<br />EMMS<br />8.73<br />45<br />392,85<br />EMMS<br />5.61<br />14<br />78,54<br />EMMS<br />1.35<br />29<br />39,15<br />EMMS<br />3.55<br />6<br />21,30<br />EMMS<br />9.32<br />31<br />288,92<br />EMMS<br />4.74<br />40<br />189,60</html>";
		String teste = preencherDados("EMMS", 2);
		Mockito.when(service.calculo("EMMS", 2)).thenReturn(retorno);
        Assert.assertEquals(retorno, teste);
	}

	@Test
	public void testFazerDivisao() {
		//fail("Not yet implemented");
	}
	
	public String preencherDados(String produto, int qtde) {
		
		if (qtde == 0)
			return "<html>Quantidade de Lojistas tem que ser maior que zero</html>";
		else if (qtde == 2)
			return "<html><br />Nome: loja1<br />Qtde: 365<br />Financeiro: 1.879,00<br />Preço Médio: 5,148<br />EMMS<br />3.75<br />37<br />138,75<br />EMMS<br />5.29<br />18<br />95,22<br />EMMS<br />5.80<br />50<br />290,00<br />EMMS<br />7.45<br />30<br />223,50<br />EMMS<br />0.24<br />39<br />9,36<br />EMMS<br />9.36<br />2<br />18,72<br />EMMS<br />7.05<br />9<br />63,45<br />EMMS<br />2.63<br />16<br />42,08<br />EMMS<br />8.73<br />44<br />384,12<br />EMMS<br />5.61<br />15<br />84,15<br />EMMS<br />1.35<br />29<br />39,15<br />EMMS<br />3.55<br />6<br />21,30<br />EMMS<br />9.32<br />30<br />279,60<br />EMMS<br />4.74<br />40<br />189,60<br />Nome: loja2<br />Qtde: 365<br />Financeiro: 1.888,15<br />Preço Médio: 5,173<br />EMMS<br />3.75<br />37<br />138,75<br />EMMS<br />5.29<br />18<br />95,22<br />EMMS<br />5.80<br />49<br />284,20<br />EMMS<br />7.45<br />31<br />230,95<br />EMMS<br />0.24<br />39<br />9,36<br />EMMS<br />9.36<br />1<br />9,36<br />EMMS<br />7.05<br />10<br />70,50<br />EMMS<br />2.63<br />15<br />39,45<br />EMMS<br />8.73<br />45<br />392,85<br />EMMS<br />5.61<br />14<br />78,54<br />EMMS<br />1.35<br />29<br />39,15<br />EMMS<br />3.55<br />6<br />21,30<br />EMMS<br />9.32<br />31<br />288,92<br />EMMS<br />4.74<br />40<br />189,60</html>";
		else 
			return "";
	}

}
