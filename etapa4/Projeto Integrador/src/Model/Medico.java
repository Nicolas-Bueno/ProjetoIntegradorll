/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Nicolas
 */
public class Medico {

    private int id;
    private String nome;
    private String crm;
    private int especialidadeId;
    private Especialidade especialidade;
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the crm
     */
    public String getCrm() {
        return crm;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

      
    @Override
    public String toString() {
        return this.getNome();
    }

    /**
     * @return the especialidadeId
     */
    public int getEspecialidadeId() {
        return especialidadeId;
    }

    /**
     * @param especialidadeId the especialidadeId to set
     */
    public void setEspecialidadeId(int especialidadeId) {
        this.especialidadeId = especialidadeId;
    }
    
  

}
