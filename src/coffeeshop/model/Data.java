package coffeeshop.model;

import java.util.ArrayList;
import java.util.List;

import coffeeshop.entity.Message;

public class Data {
    private static List<Message> data;
    private static long count = 5;

    static {
        data = new ArrayList<Message>();
        data.add(new Message(1L, "Hello", "Hello! I'm first entry!"));
        data.add(new Message(2L, "2nd", "second messages"));
        data.add(new Message(3L, "here again!", "some text"));
        data.add(new Message(4L, "HI!", "pam param"));
    }

    public static List<Message> getData() {
        return data;
    }

    public static Message findMessageById(long id) {
        for (Message message : data) {
            if (message.getMessageId() == id) {
                return message;
            }
        }
        return null;
    }

    public static boolean deleteMessageById(long id) {
        boolean result = false;
        for (Message message : data) {
            if (message.getMessageId() == id) {
                result = data.remove(message);
                return result;
            }
        }
        return result;
    }

    public static boolean updateMessage(Message message) {
        boolean result = false;
        for (Message temp: data) {
            if (temp.getMessageId() == message.getMessageId()) {
                temp.setMessageText(message.getMessageText());
                temp.setMessageTitle(message.getMessageTitle());
                result = true;
            }
        }
        return result;
    }

    public static boolean addMesage(Message message) {
        message.setMessageId(count);
        count++;
        return data.add(message);
    }

}