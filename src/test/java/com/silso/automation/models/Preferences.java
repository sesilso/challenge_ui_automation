package com.silso.automation.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Preferences {
    private Boolean signUpNewsletter;
    private Boolean receiveOffers;
}
