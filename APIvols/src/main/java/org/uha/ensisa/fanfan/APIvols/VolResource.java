package org.uha.ensisa.fanfan.APIvols;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import jakarta.ws.rs.core.MediaType;

@Path("/vols")
public class VolResource {
	
	List<Vol> vols;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("APIvols");
	EntityManager entitymanager = emfactory.createEntityManager();
	Query query = entitymanager.createQuery("from Vol v", Vol.class);
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getVols() {
		List<Vol> vols = query.getResultList();
		String result = "";
		for (Vol vol : vols) {
			result += "{" + "numVol: " + vol.getNumVol() + ", " + "villeDepart: " + vol.getVilleDepart() + ", "
					+ "villeArrivee: " + vol.getVilleArrivee() + ", " + "heureDepart: " + vol.getHeureDepart() + "}";
		}
		return result;
	}

	@GET
	@Path("/numVol-{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVolById(@PathParam("id") String id) {
		List<Vol> vols = query.getResultList();
		String result = "";
		for (Vol vol : vols) {
			if (vol.getNumVol().equals(id))
				result += "{" + "numVol: " + vol.getNumVol() + ", " + "villeDepart: " + vol.getVilleDepart() + ", "
						+ "villeArrivee: " + vol.getVilleArrivee() + ", " + "heureDepart: " + vol.getHeureDepart()
						+ "}";
		}
		return result;
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public String getVolByParam(@QueryParam("departure") String departure, @QueryParam("arrival") String arrival,
			@QueryParam("departureTime") int departureTime) {
		List<Vol> vols = query.getResultList();
		String result = "";
		for (Vol vol : vols) {
			if (vol.getVilleDepart().equals(departure) || vol.getVilleArrivee().equals(arrival)
					|| vol.getHeureDepart() == departureTime)
				result += "{" + "numVol: " + vol.getNumVol() + ", " + "villeDepart: " + vol.getVilleDepart() + ", "
						+ "villeArrivee: " + vol.getVilleArrivee() + ", " + "heureDepart: " + vol.getHeureDepart()
						+ "}";
		}
		return result;
	}

}
