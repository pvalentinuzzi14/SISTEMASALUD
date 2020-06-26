package clases;

public class KitReactivo {
	
	private int numeroKit;
	
	public KitReactivo() {
		
		numeroKit=-1;
	}

	public KitReactivo(int numeroKit) {

		this.numeroKit = numeroKit;
	}
		

	public int getNumeroKit() {
		return numeroKit;
	}

	public void setNumeroKit(int numeroKit) {
		this.numeroKit = numeroKit;
	}

	@Override
	public String toString() {
		return "KitReactivo=" + numeroKit;
	}
	
	
	
}
