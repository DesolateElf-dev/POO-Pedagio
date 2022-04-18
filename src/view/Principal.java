package view;

import java.util.concurrent.Semaphore;

import controller.ExibirThread;

public class Principal {

	public static void main(String[] args) {
		
		int numCarros = 10;

		Semaphore cabine1 = new Semaphore(1);
		Semaphore cabine2 = new Semaphore(1);
		
		for(int idCarro=0;idCarro<numCarros;idCarro++) {
			
			Thread tCarro = new ExibirThread(idCarro, cabine1, cabine2);
			tCarro.start();
		}

	}

}
