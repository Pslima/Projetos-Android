package entity;

/**
 * Created by Paulo on 30/09/2016.
 */
public class Usuario {
    private String tipoSangue;
    private String doencaDronica;
    private String alergia;
    private String cirurgia;
    private boolean peso;
    private double altura;
    private double imc;

    public String getTipoSangue() {
        return tipoSangue;
    }
    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }
    public String getDoencaDronica() {
        return doencaDronica;
    }
    public void setDoencaDronica(String doencaDronica) {
        this.doencaDronica = doencaDronica;
    }
    public String getAlergia() {
        return alergia;
    }
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    public String getCirurgia() {
        return cirurgia;
    }
    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }
    public boolean isPeso() {
        return peso;
    }
    public void setPeso(boolean peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getImc() {
        return imc;
    }
    public void setImc(double imc) {
        this.imc = imc;
    }
}
