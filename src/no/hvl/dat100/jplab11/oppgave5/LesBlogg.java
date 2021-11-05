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

	public static Blogg les(String mappe, String filnavn) throws NumberFormatException, IOException {

		BufferedReader br = null;
		Blogg blogg = null;
		String line;
		
		try {
			br = new BufferedReader(new FileReader(mappe + filnavn));
			int lineCount = 1;
			
			if (lineCount == 1) {
				int antall = Integer.parseInt(br.readLine());
				blogg = new Blogg(antall);
				lineCount++;
			}
			
			while ((line = br.readLine()) != null) {
				if (line.equals(TEKST)) {
					do {
						
					} while (!line.equals(TEKST) || !line.equals(BILDE));
				}
			}
			
			
		} catch(FileNotFoundException fnf) {
			fnf.getStackTrace();
		} catch (IOException ioe) {
			ioe.getStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		
		return blogg;
	}
}
