/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao.dados.UsuarioTestesComunicacao;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioSistemaRoot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testesFW.TesteJUnitBasicoSemAcoes;
import testesFW.TesteJUnitBasicoSemPersistencia;
import testesFW.TesteJunitSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroAcessandoCanalComunicacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public class MsgDisparoEmailimplTest extends TesteJUnitBasicoSemAcoes {

    public MsgDisparoEmailimplTest() {
    }

    /**
     * Test of dispararInicioComunicacao method, of class MsgDisparoEmailimpl.
     */
    @Test
    public void testDispararInicioComunicacao() {

        UsuarioTestesComunicacao usuarionotificacao = new UsuarioTestesComunicacao();
        ItfDialogo dialogo = SBCore.getServicoComunicacao().gerarComunicacaoSistema_Usuario(FabTipoComunicacao.NOTIFICAR,
                usuarionotificacao, "Apenas teste", "Mensagem do teste de notificação via email");
        try {
            SBCore.getServicoComunicacao().dispararComunicacao(dialogo, ERPTipoCanalComunicacao.EMAIL);
        } catch (ErroAcessandoCanalComunicacao ex) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha disparando comunicado pelo canal de email", ex);
        }
    }

    /**
     * Test of dispararRespostaComunicacao method, of class MsgDisparoEmailimpl.
     */
    @Test
    public void testDispararRespostaComunicacao() {

    }

}
