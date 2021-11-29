package model.bean;

public class Onibus {
	
	private String idOnibus;
	private int horario_s;
	private String origem;
	private int horario_c;
	private String destino;
	private String tipo_onibus;
	
	
	
	public int getIdOnibus() {
		return idOnibus;
	}
	public void setIdOnibus(String string) {
		this.idOnibus = string;
	}
	public int getHorario_s() {
		return horario_s;
	}
	public void setHorario_s(int horario_s) {
		this.horario_s = horario_s;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public int getHorario_c() {
		return horario_c;
	}
	public void setHorario_c(int horario_c) {
		this.horario_c = horario_c;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getTipo_onibus() {
		return tipo_onibus;
	}
	public void setTipo_onibus(String tipo_onibus) {
		this.tipo_onibus = tipo_onibus;
	}
	
	
	
	
	
}
