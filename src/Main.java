import Mediator.CentralAtendimentoClinica;
import Participantes.Enfermagem;
import Participantes.Laboratorio;
import Participantes.Medico;
import Participantes.Paciente;
import Participantes.Recepcao;

public class Main {

    public static void main(String[] args) {

        CentralAtendimentoClinica central = new CentralAtendimentoClinica();

        Recepcao recepcao = new Recepcao(central, "Recepção");
        Medico medico = new Medico(central, "Médico");
        Enfermagem enfermagem = new Enfermagem(central, "Enfermagem");
        Laboratorio laboratorio = new Laboratorio(central, "Laboratório");
        Paciente paciente = new Paciente(central, "Paciente");

        central.setRecepcao(recepcao);
        central.setMedico(medico);
        central.setEnfermagem(enfermagem);
        central.setLaboratorio(laboratorio);
        central.setPaciente(paciente);

        System.out.println("PACIENTE CHEGA À CLÍNICA");
        paciente.enviar("Cheguei para atendimento.");

        System.out.println("\nRECEPÇÃO INICIA O ATENDIMENTO");
        recepcao.enviar("Encaminhando paciente ao médico.");

        System.out.println("\nMÉDICO SOLICITA EXAME");
        medico.enviar("Solicitando exame do paciente.");

        System.out.println("\nLABORATÓRIO RESPONDE");
        laboratorio.enviar("Exame concluído.");

        System.out.println("\nENFERMAGEM FINALIZA PREPARAÇÃO");
        enfermagem.enviar("Paciente preparado.");

        System.out.println("\nATENDIMENTO FINALIZADO");
        recepcao.receber("Atendimento encerrado com sucesso.");
    }
}