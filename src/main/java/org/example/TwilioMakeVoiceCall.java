package org.example;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;

public class TwilioMakeVoiceCall {

    public static void main(String[] args) {

        Twilio.init(
            System.getenv("TWILIO_ACCOUNT_SID"),
            System.getenv("TWILIO_AUTH_TOKEN"));

        String helloTwiml = new VoiceResponse.Builder()
            .say(new Say.Builder("Hello from Twilio")
                .voice(Say.Voice.POLLY_MATTHEW).build())
            .build().toXml();

        Call call = Call.creator(
                new PhoneNumber("<TO - your cellphone number>"),
                new PhoneNumber("<FROM - your Twilio number>"),
                new Twiml(helloTwiml))
            .create();

        System.out.println(call.getSid());

    }
}
