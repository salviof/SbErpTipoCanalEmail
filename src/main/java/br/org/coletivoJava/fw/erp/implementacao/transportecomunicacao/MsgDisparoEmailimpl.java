package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoEmail;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCEmail;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;

@MsgDisparoEmail
public class MsgDisparoEmailimpl extends RepositorioLinkEntidadesGenerico
        implements
        com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao {

    @Override
    public String dispararInicioComunicacao(ComoDialogo pComunicacao) {

        String codigo = UtilCRCEmail.enviarPorServidorPadraoV2(pComunicacao.getDestinatario().getEmailsConcatenados(), pComunicacao.getMensagem(),
                pComunicacao.getAssunto());

        return codigo;

    }

    @Override
    public boolean validarDadosDisparo(ComoDialogo dialogo) {
        try {
            if (dialogo.getDestinatario().getEmailsConcatenados() == null) {
                return false;
            }
            if (dialogo.getMensagem() == null) {
                return false;

            }
            if (dialogo.getAssunto() == null) {
                return false;
            }
        } catch (Throwable t) {
            return false;
        }

        return true;
    }
}
