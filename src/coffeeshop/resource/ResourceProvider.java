/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.resource;

import coffeeshop.entities.POS_List;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import coffeeshop.entities.PointOfService;
import connectionpool.ConnectionPool;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Artyom
 */

@Path("rest")
public class ResourceProvider {
//    static ConnectionPool cp = ConnectionPool.getConnPool();
    
    @GET
    @Path("pos")
    @Produces(MediaType.APPLICATION_XML)
    public List<PointOfService> getPOS() {
        POS_List pos_list = new POS_List();
        List<PointOfService> pOS = pos_list.getPOS();

        return pOS;
        
    }
    
    @POST
    @Path("auth")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_XML)
    
    public String authorize(@QueryParam ("name") String name,
                            @QueryParam ("passwd") String passwd){
        String authorized = "Написать авторизацию!!!\nИмя: " + name + "\nПароль: " + passwd + "\n";
        
        return authorized;
    }
   
            
    
}
