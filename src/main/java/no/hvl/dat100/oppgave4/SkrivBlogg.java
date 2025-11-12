package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.oppgave3.Blogg;
import no.hvl.dat100.oppgave1.Innlegg;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        String filsti = mappe + "/" + filnavn;

        try (PrintWriter writer = new PrintWriter(filsti)) {
            writer.println(samling.getAntall());

            for (int i = 0; i < samling.getAntall(); i++) {
                Innlegg innlegg = samling.getInnlegg(i);
                writer.print(innlegg.toString());
            }

            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
