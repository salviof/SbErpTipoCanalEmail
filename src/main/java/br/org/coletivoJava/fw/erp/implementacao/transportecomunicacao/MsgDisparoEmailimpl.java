package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.modulos.erp.ItfServicoLinkDeEntidadesERP;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoEmailPadrao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoEmail;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreEmail;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;

@MsgDisparoEmail
public class MsgDisparoEmailimpl extends RepositorioLinkEntidadesGenerico
        implements
        com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao {

    @Override
    public String dispararInicioComunicacao(ItfDialogo pComunicacao) {
        String codigo = UtilSBCoreEmail.enviarPorServidorPadraoV2(pComunicacao.getDestinatario().getEmailsConcatenados(), pComunicacao.getMensagem(),
                pComunicacao.getAssunto());
        return codigo;

    }

    @Override
    public void dispararRespostaComunicacao(
            com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo pComunicacao) {
        SBCore.getServicoComunicacao().getArmazenamento().getDialogoByCodigoSelo(pComunicacao.getCodigoSelo());
    }
}
