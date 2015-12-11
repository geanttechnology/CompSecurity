// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.rdio.android.api.models.Ad;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.VolleyOAuth2RdioService;
import com.rdio.android.core.events.ads.AdCompletedEvent;
import com.rdio.android.core.util.Logging;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.core.reporting:
//            TrackPlayEvent, PlayEventType, PlayEvent

public class AdEventReporter
{

    private static final String TAG = "AdEventReporter";
    private int deviceType;
    private Logging logging;
    private String playbackToken;
    private VolleyOAuth2RdioService service;

    public AdEventReporter(VolleyOAuth2RdioService volleyoauth2rdioservice, Logging logging1)
    {
        logging = logging1;
        service = volleyoauth2rdioservice;
    }

    protected void handleAdPlayResponse(final String adKey, RdioApiResponse rdioapiresponse)
    {
        if (!rdioapiresponse.isSuccess())
        {
            logging.log(6, "AdEventReporter", (new StringBuilder("There was an error reporting the ad start event ")).append(rdioapiresponse.getErrorMessage()).toString());
            return;
        }
        Object obj;
        VolleyOAuth2RdioService volleyoauth2rdioservice;
        try
        {
            obj = (String)((JSONObject)rdioapiresponse.getResult()).get("txid");
        }
        // Misplaced declaration of an exception variable
        catch (final String adKey)
        {
            logging.log(6, "AdEventReporter", "Unable to retrieve txid when reporting ad start event");
            return;
        }
        rdioapiresponse = new RdioApiRequestArg("method", "addFinishEvent");
        obj = new RdioApiRequestArg("txid", obj);
        volleyoauth2rdioservice = service;
        adKey = new com.rdio.android.core.RdioService_Api.ResponseListener() {

            final AdEventReporter this$0;
            final String val$adKey;

            public void onResponse(RdioApiResponse rdioapiresponse1)
            {
                if (rdioapiresponse1.isSuccess())
                {
                    logging.log(4, "AdEventReporter", (new StringBuilder("Reporting ad play & finish for ")).append(adKey).toString());
                    return;
                } else
                {
                    logging.log(6, "AdEventReporter", (new StringBuilder("There was an error reporting the ad finish event ")).append(rdioapiresponse1.getErrorMessage()).toString());
                    return;
                }
            }

            
            {
                this$0 = AdEventReporter.this;
                adKey = s;
                super();
            }
        };
        volleyoauth2rdioservice.postRequest(new RdioApiRequestArg[] {
            rdioapiresponse, obj
        }, adKey);
    }

    public void onAdCompleted(final AdCompletedEvent event)
    {
        if (!event.playedAudio)
        {
            logging.log(3, "AdEventReporter", "Skipping over a non-playedAudio AdCompletedEvent");
            return;
        } else
        {
            RdioApiRequestArg rdioapirequestarg = new RdioApiRequestArg("method", "addStartEvent");
            RdioApiRequestArg rdioapirequestarg1 = new RdioApiRequestArg("key", event.ad.key);
            RdioApiRequestArg rdioapirequestarg2 = new RdioApiRequestArg("source", event.ad.key);
            RdioApiRequestArg rdioapirequestarg3 = new RdioApiRequestArg("playbackToken", playbackToken);
            VolleyOAuth2RdioService volleyoauth2rdioservice = service;
            com.rdio.android.core.RdioService_Api.ResponseListener responselistener = new com.rdio.android.core.RdioService_Api.ResponseListener() {

                final AdEventReporter this$0;
                final AdCompletedEvent val$event;

                public void onResponse(RdioApiResponse rdioapiresponse)
                {
                    handleAdPlayResponse(event.ad.key, rdioapiresponse);
                }

            
            {
                this$0 = AdEventReporter.this;
                event = adcompletedevent;
                super();
            }
            };
            volleyoauth2rdioservice.postRequest(new RdioApiRequestArg[] {
                rdioapirequestarg, rdioapirequestarg1, rdioapirequestarg2, rdioapirequestarg3
            }, responselistener);
            (new TrackPlayEvent(deviceType, event.ad.key, PlayEventType.Play)).addSubEvent(new PlayEvent(PlayEventType.Finish));
            return;
        }
    }

    public void setPlaybackToken(String s)
    {
        playbackToken = s;
    }

}
