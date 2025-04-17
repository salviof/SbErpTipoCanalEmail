/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.apache.logging.log4j.LogManager;
import org.coletivojava.fw.api.objetoNativo.log.LogPadraoSB;
import org.junit.Test;
import testes.geradorCodigo.erp.GeradorERPImplementacaoContexto;
import testesFW.ConfigCoreJunitPadraoDevAcaoPermissao;
import testesFW.ConfigCoreJunitPadraoDevLib;

/**
 *
 * @author desenvolvedor
 */
public class CriarImplementacao {

    @Test
    public void criarImplementaca() {

        try {
            SBCore.configurar(new ConfigCoreJunitPadraoDevLib(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
            new GeradorERPImplementacaoContexto(ERPTipoCanalComunicacao.EMAIL).salvarEmDiretorioPadraCASO_NAO_EXISTA();

        } catch (Throwable t) {
            LogManager.getLogger(LogPadraoSB.class).error("Erro Criando anotações", t);
        }
    }

}
