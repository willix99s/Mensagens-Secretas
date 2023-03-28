import java.util.ArrayList;
import java.util.List;

public class Comunicacao {
    private List<Emissor> emissores;
    private List<Receptor> receptores;

    public Comunicacao() {
        emissores = new ArrayList<>();
        receptores = new ArrayList<>();
    }

    public void adicionarEmissor(Emissor emissor) {
        emissores.add(emissor);
    }

    public void adicionarReceptor(Receptor receptor) {
        receptores.add(receptor);
    }

    public void enviarMensagemVi(String mensagemCriptografada, int idRemetente, int idDestinatario) {
        for (Receptor receptor : receptores) {
            if (receptor.getId() == idDestinatario) {
                receptor.receberMensagemVi(mensagemCriptografada, idRemetente);
                break;
            }
        }
    }

    public void enviarMensagemVe(String mensagemCriptografada, int idRemetente, int idDestinatario) {
        for (Receptor receptor : receptores) {
            if (receptor.getId() == idDestinatario) {
                receptor.receberMensagemVe(mensagemCriptografada, idRemetente);
                break;
            }
        }
    }

    public void enviarMensagemBroadcastVi(String mensagemCriptografada, int idRemetente) {
        for (Receptor receptor : receptores) {
            if (receptor.getId() != idRemetente) {
                receptor.receberMensagemVi(mensagemCriptografada, idRemetente);
            }
        }
    }

    public void enviarMensagemBroadcastVe(String mensagemCriptografada, int idRemetente) {
        for (Receptor receptor : receptores) {
            if (receptor.getId() != idRemetente) {
                receptor.receberMensagemVe(mensagemCriptografada, idRemetente);
            }
        }
    }
}
