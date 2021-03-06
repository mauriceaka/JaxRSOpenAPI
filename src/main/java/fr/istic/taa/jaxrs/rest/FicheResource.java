package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.specific.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fiches")
@Produces({"application/json", "application/xml"})
public class FicheResource {

    private final FicheDao ficheDao = new FicheDao();
    private final TagFicheDao tagFicheDao = new TagFicheDao();

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId) {
        // return fiche
        return ficheDao.findOne(ficheId);
    }

    @GET
    @Path("")
    public List<Fiche> getFiches() {

        // return list of fiches
        return ficheDao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Fiche addFiche(
            @Parameter(description = "Fiche object that needs to be added to the store", required = true) Fiche fiche) {
        // add fiche
        ficheDao.save(fiche);
        tagFicheDao.findAll().forEach(tagFiche -> {
            System.out.println(tagFiche.getFiche_id() + " " + tagFiche.getTag_id());
        });
        System.out.println(tagFicheDao.findAll().size());
        return fiche;
    }

    @PUT
    @Consumes("application/json")
    public Fiche editFiche(
            @Parameter(description = "Fiche object that needs to be edited to the store", required = true) Fiche fiche) {
        // edit fiche
        Fiche newfiche = getFicheById(fiche.getId());
        newfiche.setUrl(fiche.getUrl());
        newfiche.setTag(fiche.getTag());
        newfiche.setSection(fiche.getSection());
        newfiche.setNote(fiche.getNote());
        newfiche.setLibelle(fiche.getLibelle());
        newfiche.setLieu(fiche.getLieu());
        newfiche.setDatebutoire(fiche.getDatebutoire());
        ficheDao.update(fiche);
        return fiche;
    }

    @DELETE
    @Path("/{ficheId}")
    public Response deleteFicheById(@PathParam("ficheId") Long ficheId) {
        // return fiche
        ficheDao.deleteById(ficheId);
        return Response.ok().entity("DELETE SUCCESSFUL").build();
    }
}
