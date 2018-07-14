package server;

import com.google.gson.*;

public class Mensaje {
	public void setDestino(String destino) {
		this.destino = destino;
	}

	public final static int LOGGEAR = 0;
	public final static int ACTUALIZAR = 1;
	public final static int ACTUALIZAR_SALAS = 2;
	public final static int MENSAJE_PRIVADO = 3;
	public final static int BROADCAST = 4;
	public final static int DESCONECTAR = 5;
	public final static int NUEVA_SALA = 6;
	public final static int USUARIO_EN_USO = 7;
	public final static int MENSAJE_SALA = 8;
	public final static int NUEVO_INTEGRANTE_SALA = 9;
	


	private int tipoMensaje;
	private String sala;
	private String destino;
	private String contenido;
	private String origen;
	
	public Mensaje(String mensaje) {
		System.out.println(mensaje);
		Gson gson = new Gson();
		copy((Mensaje)gson.fromJson(mensaje, Mensaje.class));
	}
	
	public Mensaje() { };
	
	public Mensaje(String contenido, int tipo) {
		if(tipo == ACTUALIZAR) {
			this.origen = "server";
			this.contenido = contenido;
			this.tipoMensaje = tipo;
			this.destino = null;
			this.sala = "";
		}
		if(tipo == ACTUALIZAR_SALAS) {
			this.origen = "server";
			this.contenido = contenido;
			this.tipoMensaje = tipo;
			this.destino = null;
			this.sala = "";
		}
//		if(tipo == NUEVA_SALA) {
//			this.origen = "user";
//			this.contenido = contenido;
//			this.tipoMensaje = tipo;
//			this.destino = null;
//			this.sala = -1;
//		}
	};

	private void copy(Mensaje mensaje) {
		this.tipoMensaje = mensaje.tipoMensaje;
		this.destino = mensaje.destino;
		this.contenido = mensaje.contenido;
		this.sala = mensaje.sala;
		this.origen = mensaje.origen;
	}

	public void setOrigen(String usuario) {
		this.origen = usuario;
	}
	
	public String getDestino() {
		return this.destino;
	}
	
	public void setTipo(int tipo) {
		this.tipoMensaje = tipo;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public int getTipo() {
		return this.tipoMensaje;
	}
	
	public String getOrigen() {
		return this.origen;
	}
	
	public String getContenido() {
		return this.contenido;
	}
	
	public String getSala() {
		return sala;
	}
	
	public static int getMensajeSala() {
		return MENSAJE_SALA;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	@Override
	public String toString() {
		return this.origen + this.destino + this.sala + this.contenido + this.tipoMensaje;
	}
}
