/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.Assets;
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
@Path("assets")
public class AssetsFacadeREST extends AbstractFacade<Assets> {

    @PersistenceContext(unitName = "fourthPU")
    private EntityManager em;

    public AssetsFacadeREST() {
        super(Assets.class);
    }

    @POST
    @Override
    @Consumes({ MediaType.APPLICATION_JSON})                            
    public void create(Assets entity) {                                                             //create if there is no previous account
       int a=0;        
       for( Assets each : super.findAll()){
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
    public void edit(@PathParam("id") Integer id, Assets entity) {                                      //edit the 
        System.out.println(entity.getName());
       int a=0;        
       for( Assets each : super.findAll()){
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
       for( Assets each : super.findAll()){
            allName.add(each.getName());
           }          
    return allName;
    }
    
    
    @GET
    @Path("name/{name}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Assets getByName(@PathParam("name") String name) {                                      //get By Name
                     
       for( Assets each : super.findAll()){
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
    public Assets find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Assets> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Assets> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
