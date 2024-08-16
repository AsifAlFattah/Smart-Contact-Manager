package com.codeprophet.scm2.helpers;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String message;
    @Builder.Default
    private MessageType type = MessageType.blue;

}
