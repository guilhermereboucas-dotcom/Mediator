package Participantes;

import Mediator.MediadorClinica;
import Mediator.Participante;

public class Laboratorio extends Participante {

    public Laboratorio(MediadorClinica mediador, String nome) {
        super(mediador, nome);
    }

    @Override
    public void enviar(String mensagem) {
        System.out.println(nome + " envia: " + mensagem);
        mediador.enviarMensagem(mensagem, this);
    }

    @Override
    public void receber(String mensagem) {
        System.out.println(nome + " recebeu: " + mensagem);
    }
}