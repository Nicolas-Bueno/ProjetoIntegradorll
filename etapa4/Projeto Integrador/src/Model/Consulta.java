/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author Nicolas
 */
public class Consulta {

    private int id;
    private Long pacienteId;
    private int medicoId;
    private int atendenteId;
    private String dataConsulta;
    private String observacoes;

    private String paciente;
    private String medico;
    private String atendente;
    
    public Consulta(int id, String paciente, String medico, String atendente, String dataConsulta, String observacoes) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.atendente = atendente;
        this.dataConsulta = dataConsulta;
        this.observacoes = observacoes;
    }

    public Consulta(int id, Long pacienteId, int medicoId, int atendenteId, String dataConsulta, String observacoes) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.atendenteId = atendenteId;
        this.dataConsulta = dataConsulta;
        this.observacoes = observacoes;
    }

    public Consulta() {

    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(int atendenteId) {
        this.atendenteId = atendenteId;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the paciente
     */
    public String getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the medico
     */
    public String getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     * @return the atendente
     */
    public String getAtendente() {
        return atendente;
    }

    /**
     * @param atendente the atendente to set
     */
    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

}
