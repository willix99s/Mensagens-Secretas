public class Emissor {
    private int id;
    private Comunicacao comunicacao;
    private CifraSimetrica cifra;

    public Emissor(int id, Comunicacao comunicacao, CifraSimetrica cifra) {
        this.id = id;
        this.comunicacao = comunicacao;
        this.cifra = cifra;
        this.comunicacao.adicionarEmissor(this);
    }

    public void enviarMensagemVi(String mensagem, int idDestinatario) {
        String mensagemCriptografada = cifra.criptografarVigenere(mensagem);
        comunicacao.enviarMensagemVi(mensagemCriptografada, this.id, idDestinatario);
    }

    public void enviarMensagemVe(String mensagem, int idDestinatario) {
        String mensagemCriptografada = cifra.criptografarVernam(mensagem);
        comunicacao.enviarMensagemVe(mensagemCriptografada, this.id, idDestinatario);
    }

    public void enviarMensagemBroadcastVi(String mensagem) {
        String mensagemCriptografada = cifra.criptografarVigenere(mensagem);
        comunicacao.enviarMensagemBroadcastVe(mensagemCriptografada, this.id);
    }

    public void enviarMensagemBroadcastVe(String mensagem) {
        String mensagemCriptografada = cifra.criptografarVernam(mensagem);
        comunicacao.enviarMensagemBroadcastVe(mensagemCriptografada, this.id);
    }

    public int getId() {
        return id;
    }
}

