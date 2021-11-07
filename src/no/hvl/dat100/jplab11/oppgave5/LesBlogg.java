package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		BufferedReader br = null;
		Blogg blogg = null;

		try {
			br = new BufferedReader(new FileReader(mappe + filnavn));
			
			int antall = Integer.parseInt(br.readLine());
			blogg = new Blogg(antall);
			
			for (int i = 0; i < antall; i++) {

				String type = br.readLine();

				if (type.equals(TEKST)) {
					int id = Integer.parseInt(br.readLine());
					String bruker = br.readLine();
					String dato = br.readLine();
					int likes = Integer.parseInt(br.readLine());
					String tekst = br.readLine();
					Innlegg tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
					blogg.leggTil(tekstInnlegg);
				} else if (type.equals(BILDE)) {
					int id = Integer.parseInt(br.readLine());
					String bruker = br.readLine();
					String dato = br.readLine();
					int likes = Integer.parseInt(br.readLine());
					String tekst = br.readLine();
					String url = br.readLine();
					Innlegg bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(bildeInnlegg);
				}

			}

			return blogg;

		} catch(FileNotFoundException fnf) {
			fnf.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch(IOException io) {
					io.getStackTrace();
				}
			}
				
		}
		return blogg;
	}
}
