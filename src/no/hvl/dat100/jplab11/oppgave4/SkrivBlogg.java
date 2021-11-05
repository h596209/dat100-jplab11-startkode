package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) throws FileNotFoundException {
		
		boolean written = false;
		PrintWriter writer = null;
		
		try {
			
			writer = new PrintWriter(mappe + filnavn);
			writer.print(samling.toString());
			written = true;
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} finally {
			if (writer!=null)
				writer.close();
		}
		
		return written;
	}
}
