package controller;

import java.util.concurrent.Semaphore;

public class ExibirThread extends Thread{
	
	private int idCarro;
	private Semaphore cabine1;
	private Semaphore cabine2;
	private int fatorTempo = 500;

	public ExibirThread(int idCarro, Semaphore cabine1, Semaphore cabine2) {
		this.idCarro = idCarro;
		this.cabine1 = cabine1;
		this.cabine2 = cabine2;
	}
	
	@Override
	public void run() {
		
		try {

			int cabine = aleatorioEntre(1,2);
			
			if(cabine ==1) {
				cabine1.acquire();
				carroNoPedagio(cabine);
				
				cabine1.release();
				System.out.println("O carro " + idCarro + " saiu da cabine " + cabine);
				
			} else if(cabine == 2) {
				
				cabine2.acquire();
				carroNoPedagio(cabine);
				
				cabine2.release();
				System.out.println("O carro " + idCarro + " saiu da cabine " + cabine);
				
			} else {
				System.out.println("O carro " + idCarro + " saiu da pista");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private void carroNoPedagio(int cabine) {
		
		System.out.println("O carro " + idCarro + " entrou na cabine " + cabine);
		
		int tempo = aleatorioEntre(0,7)*fatorTempo;
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		
	}
	
	private int aleatorioEntre(int inicio, int fim) {
		
		fim = fim-inicio;
		fim++;

		int numero = (int)((Math.random()*fim)+inicio);
		
		return numero;
	}

}
