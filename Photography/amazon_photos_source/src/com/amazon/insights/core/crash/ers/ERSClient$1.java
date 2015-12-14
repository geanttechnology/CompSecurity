// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.crash.ers;

import com.amazon.insights.core.DefaultInsightsHandler;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.delivery.ERSRequestBuilder;
import com.amazon.insights.error.InsightsError;
import com.amazon.insights.error.UnexpectedError;
import org.json.JSONArray;

// Referenced classes of package com.amazon.insights.core.crash.ers:
//            ERSClient

class 
    implements Runnable
{

    final ERSClient this$0;
    final JSONArray val$eventsArray;
    final DefaultInsightsHandler val$handler;

    public void run()
    {
        final com.amazon.insights.core.http.esponse response;
        try
        {
            response = ERSClient.access$000(ERSClient.this).createHttpRequest(val$eventsArray);
            response = ERSClient.access$100(ERSClient.this).execute(response, Integer.valueOf(0));
            if (response.getCode() / 100 == 2)
            {
                ERSClient.access$200().d(String.format("Success from EventService: %d", new Object[] {
                    Integer.valueOf(response.getCode())
                }));
                val$handler.onComplete(Boolean.TRUE);
                return;
            }
        }
        catch (Exception exception)
        {
            ERSClient.access$200().e("Unable to send ers request", exception);
            val$handler.onError(new UnexpectedError("Failed to submit events to EventService", exception));
            return;
        }
        val$handler.onError(new InsightsError() {

            private final String message;
            final ERSClient._cls1 this$1;
            final com.amazon.insights.core.http.HttpClient.Response val$response;

            public String getMessage()
            {
                return message;
            }

            
            {
                this$1 = ERSClient._cls1.this;
                response = response1;
                super();
                message = String.format("Failed to submit events to EventService: %d", new Object[] {
                    Integer.valueOf(response.getCode())
                });
            }
        });
        return;
    }

    ()
    {
        this$0 = final_ersclient;
        val$eventsArray = jsonarray;
        val$handler = DefaultInsightsHandler.this;
        super();
    }
}
