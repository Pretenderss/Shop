package coffeeshop.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private long messageId;
    private String messageTitle;
    private String messageText;

    public Message() {

    }

    public Message(long messageId, String messageTitle, String messageText) {

        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageText = messageText;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Message [messageId=" + messageId + ", messageTitle="
                + messageTitle + ", messageText=" + messageText + "]";
    }

}