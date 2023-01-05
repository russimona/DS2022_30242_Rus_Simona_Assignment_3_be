package ro.tuc.ds2020.controllers.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String senderEmail;
    private String receiverEmail;
    private String message;
}
