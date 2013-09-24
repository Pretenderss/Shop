package coffeeshop.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import coffeeshop.entity.Message;
import coffeeshop.model.Data;

@Path("message")
public class MessageResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getAllMessages() {
        List<Message> messages = Data.getData();
        if (messages == null) {
            throw new RuntimeException("Can't load all messages");
        }
        return messages;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessageById(@PathParam("id") long id) {
        Message message = Data.findMessageById(id);
        if (message == null) {
            throw new RuntimeException("can't find mesage with id = " + id);
        }
        return message;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void addMessage(JAXBElement<Message> message) {
        if (Data.addMesage(message.getValue()) != true) {
            throw new RuntimeException("can't add mesage with id = "
                    + message.getValue().getMessageId());
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteMessage(@PathParam("id") long id) {
        if (Data.deleteMessageById(id) != true) {
            throw new RuntimeException("can't delete mesage with id = " + id);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void updateMessage(JAXBElement<Message> message) {
        if (Data.updateMessage(message.getValue()) != true) {
            throw new RuntimeException("can't update mesage with id = "
                    + message.getValue().getMessageId());
        }
    }

}
