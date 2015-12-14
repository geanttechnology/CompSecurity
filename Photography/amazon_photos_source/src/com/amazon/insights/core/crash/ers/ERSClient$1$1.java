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

class .getCode
    implements InsightsError
{

    private final String message;
    final message this$1;
    final com.amazon.insights.core.http.ponse val$response;

    public String getMessage()
    {
        return message;
    }

    ()
    {
        this$1 = final_;
        val$response = com.amazon.insights.core.http.ponse.this;
        super();
        message = String.format("Failed to submit events to EventService: %d", new Object[] {
            Integer.valueOf(val$response.getCode())
        });
    }

    // Unreferenced inner class com/amazon/insights/core/crash/ers/ERSClient$1

/* anonymous class */
    class ERSClient._cls1
        implements Runnable
    {

        final ERSClient this$0;
        final JSONArray val$eventsArray;
        final DefaultInsightsHandler val$handler;

        public void run()
        {
            Object obj;
            try
            {
                obj = ERSClient.access$000(ERSClient.this).createHttpRequest(eventsArray);
                obj = ERSClient.access$100(ERSClient.this).execute(((com.amazon.insights.core.http.HttpClient.Request) (obj)), Integer.valueOf(0));
                if (((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode() / 100 == 2)
                {
                    ERSClient.access$200().d(String.format("Success from EventService: %d", new Object[] {
                        Integer.valueOf(((com.amazon.insights.core.http.HttpClient.Response) (obj)).getCode())
                    }));
                    handler.onComplete(Boolean.TRUE);
                    return;
                }
            }
            catch (Exception exception)
            {
                ERSClient.access$200().e("Unable to send ers request", exception);
                handler.onError(new UnexpectedError("Failed to submit events to EventService", exception));
                return;
            }
            handler.onError(((ERSClient._cls1._cls1) (obj)). new ERSClient._cls1._cls1());
            return;
        }

            
            {
                this$0 = final_ersclient;
                eventsArray = jsonarray;
                handler = DefaultInsightsHandler.this;
                super();
            }
    }

}
