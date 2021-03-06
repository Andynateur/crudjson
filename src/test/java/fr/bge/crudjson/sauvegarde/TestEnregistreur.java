package fr.bge.crudjson.sauvegarde;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.bge.crudjson.entites.Chaussure;
import fr.bge.crudjson.entites.Fabricant;
import fr.bge.crudjson.entites.Vetement;
	
public class TestEnregistreur {
	@Test
	public void testFonctionnementClassique() throws Exception {
		Enregistreur enregistreur = new Enregistreur();
		//on charge la liste actuelle de v�tements
		List < Vetement> dressing1 = enregistreur.lireTous();
        
	    //on instancie un nouveau v�tement
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille("42");
		chaussure.setCouleur("Rouge");
		chaussure.setLongueurLacet(25);
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
	        
	    // on sauvegarde ce nouveau v�tement
		enregistreur.enregistrer(chaussure);
	        
	    // on v�rifie que la liste � pris en compte ce v�tement
		List < Vetement > dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouveau dressing a un �l�ment de plus", dressing1.size() +1, dressing2.size());
	        
	    //on modifie ce v�tement et on le sauvegarde
		chaussure.setTaille("38");
		enregistreur.enregistrer(chaussure);
	        
	    //on v�rifie que la liste a pris en compte cette modification
		//???
		
		//On supprime le v�tement
		enregistreur.supprimer(chaussure);
		
		 //on v�rifie que la liste a pris en compte cette suppression
		List < Vetement > dressing3 = enregistreur.lireTous();
		Assert.assertEquals("Les deux dressing doivent avoir le m�me nombre d'�lements", dressing1.size(), dressing3.size());//Class Assert avec m�thode statique
	}

}
