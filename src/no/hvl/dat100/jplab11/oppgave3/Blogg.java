package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledige;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		nesteledige = 0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteledige = 0;
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		return innleggstabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int funnet = -1;
		for (int i = 0; i < nesteledige; i++) {
			
			if (innleggstabell[i].erLik(innlegg)) {
				funnet = i;
			}
			
		}
		return funnet;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) >= 0;
	}

	public boolean ledigPlass() {
		return nesteledige < innleggstabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		if (!finnes(innlegg)) {
			innleggstabell[nesteledige] = innlegg;
			nesteledige++;
			lagtTil = true;
		}
		return lagtTil;
	}
	
	public String toString() {
		String tekst = nesteledige + "\n";
		for (int i = 0; i < nesteledige; i++) {
			
			tekst += innleggstabell[i].toString();
		}
		return tekst;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] utvidet = new Innlegg[innleggstabell.length*2];
		for (int i = 0; i < nesteledige; i++) {
			utvidet[i] = innleggstabell[i];
		}
		innleggstabell = utvidet;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean lagtTil = false;
		if (finnes(innlegg)) {
			if (nesteledige <= innleggstabell.length) {
				leggTil(innlegg);
			} else {
				utvid();
				leggTil(innlegg);
			}
			lagtTil = true;
		}
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int index = finnInnlegg(innlegg);
		if (index >= 0) {
			innleggstabell[index] = null;
			for (int i = index; i < nesteledige-1; i++) {
				innleggstabell[index] = innleggstabell[index+1];
			}
			nesteledige -= 1;
			return true;
		} else {
			return false;
		}
		
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}