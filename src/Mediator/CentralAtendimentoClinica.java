package Mediator;

import Participantes.Enfermagem;
import Participantes.Laboratorio;
import Participantes.Medico;
import Participantes.Paciente;
import Participantes.Recepcao;

public class CentralAtendimentoClinica implements MediadorClinica {

    private Recepcao recepcao;
    private Medico medico;
    private Enfermagem enfermagem;
    private Laboratorio laboratorio;
    private Paciente paciente;

    public void setRecepcao(Recepcao recepcao) {
        this.recepcao = recepcao;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setEnfermagem(Enfermagem enfermagem) {
        this.enfermagem = enfermagem;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public void enviarMensagem(String mensagem, Participante participante) {

        System.out.println("\n[CENTRAL] Encaminhando mensagem: " + mensagem);

        if (participante instanceof Paciente) {
            recepcao.receber("Paciente chegou para atendimento.");
        }

        else if (participante instanceof Recepcao) {
            medico.receber("Paciente encaminhado para consulta.");
        }

        else if (participante instanceof Medico) {
            enfermagem.receber("Preparar paciente para exame.");
            laboratorio.receber("Realizar exame solicitado pelo médico.");
        }

        else if (participante instanceof Laboratorio) {
            medico.receber("Resultado do exame disponível.");
        }

        else if (participante instanceof Enfermagem) {
            recepcao.receber("Paciente preparado com sucesso.");
        }
    }
}