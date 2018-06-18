package BarrosPedro.negocio;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
public class Escrever {
	private File arquivo;
	public Escrever() {
		arquivo = new File("arquivo.txt");
	}
	public void escreveTexto(String texto) throws IOException{
            
                        FileWriter inserindo = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(inserindo);
			Date data = new Date();
			bw.append(data.toString() + ": " +texto+ "\n");
			bw.close();
			inserindo.close();
	}
}