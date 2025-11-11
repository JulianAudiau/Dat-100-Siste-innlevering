package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] tabell;
    private int nesteledig;

	public Blogg(){
       tabell = new Innlegg[20];
       nesteledig = 0;
	}

	public Blogg(int lengde) {
        tabell = new Innlegg[lengde];
        nesteledig = 0;

    }
	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return tabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

        for (int i = 0; i < nesteledig; i++) {
            if (tabell[i].erLik(innlegg)) {
                return i;
            }

        }
        return -1;

    }
	public boolean finnes(Innlegg innlegg) {

       if(finnInnlegg(innlegg) != -1){
           return true;

       }
       return false;

	}

	public boolean ledigPlass() {
        return nesteledig < tabell.length;

    }
	
	public boolean leggTil(Innlegg innlegg) {

        if(!ledigPlass()){
            return false;
        }


        if(!finnes(innlegg) ){
        tabell[nesteledig] = innlegg;
        nesteledig++;
        return true;

    }
	return false;
    }
	
	public String toString() {

        String resultatet = nesteledig + "\n";


        for(int i = 0; i < nesteledig; i++){
            resultatet += tabell[i].toString();
        }
        return resultatet;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
	Innlegg[] nyTabell = new Innlegg[40];
    for(int i = 0; i < nesteledig; i++){
        nyTabell[i] = tabell[i];
    }
    tabell = nyTabell;

	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)){
            return false;
        }


	if(leggTil(innlegg)){

        return true;
    } else {
        utvid();
        leggTil(innlegg);
        return true;

    }

        }
	
	public boolean slett(Innlegg innlegg) {
        throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}