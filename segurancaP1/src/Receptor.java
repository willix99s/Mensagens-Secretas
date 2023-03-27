public class Receptor {
    private int id;
    private Comunicacao comunicacao;
    private CifraSimetrica cifra;

    public Receptor(int id, Comunicacao comunicacao, CifraSimetrica cifra) {
        this.id = id;
        this.comunicacao = comunicacao;
        this.cifra = cifra;
        this.comunicacao.adicionarReceptor(this);
    }

    public void receberMensagemVi(String mensagemCriptografada, int idRemetente) {
        String mensagemDescriptografada = cifra.descriptografarVigenere(mensagemCriptografada);
        System.out.println("Receptor " + id + " recebeu mensagem de " + idRemetente + ": " + mensagemDescriptografada);
    }

    public void receberMensagemVe(String mensagemCriptografada, int idRemetente) {
        String mensagemDescriptografada = cifra.descriptografarVernam(mensagemCriptografada);
        System.out.println("Receptor " + id + " recebeu mensagem de " + idRemetente + ": " + mensagemDescriptografada);
    }

    public int getId() {
        return id;
    }
}
