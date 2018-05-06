/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.Liabilities;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dhiraj
 */
@Stateless
@Path("model.liabilities")
public class LiabilitiesFacadeREST extends AbstractFacade<Liabilities> {

    @PersistenceContext(unitName = "fourthPU")
    private EntityManager em;

    public LiabilitiesFacadeREST() {
        super(Liabilities.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(Liabilities entity) {
        int a=0;        
       for( Liabilities each : super.findAll()){
           if(each.getName().equals(entity.getName())){
              each.setAmount(each.getAmount()+entity.getAmount());
              each.setDate(entity.getDate());
              a++;
              super.edit(each);               
           }
           System.out.println(each.getName());
           
       }
       if(a==0){
            super.create(entity);
        }
        
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Liabilities entity) {
       System.out.println(entity.getName());
       int a=0;        
       for(Liabilities each : super.findAll()){
           if(each.getID()==id){
              each.setAmount(entity.getAmount());
              each.setDate(entity.getDate());
              each.setName(entity.getName());
              each.setParticular(entity.getParticular());
              a++;
              super.edit(each);               
           }          
           
       }
         if(a==0){
                System.out.println("a : "+ a);
            super.create(entity);
        }
        
    }
    
    @GET
    @Path("allName")                                                            //get all name of assets
    @Produces({ MediaType.APPLICATION_JSON})
    public List<String> getallName() {    
        List<String> allName=new ArrayList<String>();
       for( Liabilities each : super.findAll()){
            allName.add(each.getName());
           }          
    return allName;
    }
    
    @GET
    @Path("name/{name}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Liabilities getByName(@PathParam("name") String name) {                                      //get By Name
                     
       for( Liabilities each : super.findAll()){
           if(each.getName().equals(name))
           return  each;
           
       }          
          
      return null;
        
    }
    
    

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Liabilities find(@PathParam("id") Integer id) {
        return super.find(id);
    }
   

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Liabilities> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Liabilities> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
