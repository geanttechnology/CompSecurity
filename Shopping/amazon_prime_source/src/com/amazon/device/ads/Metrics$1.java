// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Metrics, WebRequest, MobileAdsLogger

class 
    implements Runnable
{

    final Metrics this$0;
    final WebRequest val$webRequest;

    public void run()
    {
        val$webRequest.enableLog(true);
        try
        {
            val$webRequest.makeCall();
            return;
        }
        catch (.WebRequestException webrequestexception)
        {
            switch (.SwitchMap.com.amazon.device.ads.WebRequest.WebRequestStatus[webrequestexception.getStatus().ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                Metrics.access$000(Metrics.this).e("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                return;

            case 2: // '\002'
                Metrics.access$000(Metrics.this).e("Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                return;

            case 3: // '\003'
                Metrics.access$000(Metrics.this).e("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                // fall through

            case 4: // '\004'
                Metrics.access$000(Metrics.this).e("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                break;
            }
        }
    }

    ()
    {
        this$0 = final_metrics;
        val$webRequest = WebRequest.this;
        super();
    }
}
