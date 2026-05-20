package Mediator;

public abstract class Participante {

    protected MediadorClinica mediador;
    protected String nome;

    public Participante(MediadorClinica mediador, String nome) {
        this.mediador = mediador;
        this.nome = nome;
    }

    public abstract void enviar(String mensagem);

    public abstract void receber(String mensagem);
}