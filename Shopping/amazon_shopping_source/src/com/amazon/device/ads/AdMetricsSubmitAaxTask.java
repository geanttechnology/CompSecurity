// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.AsyncTask;

// Referenced classes of package com.amazon.device.ads:
//            WebRequest, Log

class AdMetricsSubmitAaxTask extends AsyncTask
{

    private static final String LOG_TAG = "AdMetricsSubmitTask";

    AdMetricsSubmitAaxTask()
    {
    }

    public volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((WebRequest[])aobj);
    }

    public transient Void doInBackground(WebRequest awebrequest[])
    {
        int i;
        int j;
        j = awebrequest.length;
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        WebRequest webrequest = awebrequest[i];
        try
        {
            webrequest.makeCall();
        }
        catch (WebRequest.WebRequestException webrequestexception)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[];

                static 
                {
                    $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus = new int[WebRequest.WebRequestStatus.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.INVALID_CLIENT_PROTOCOL.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.NETWORK_FAILURE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.MALFORMED_URL.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[WebRequest.WebRequestStatus.UNSUPPORTED_ENCODING.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.amazon.device.ads.WebRequest.WebRequestStatus[webrequestexception.getStatus().ordinal()])
            {
            case 1: // '\001'
                Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                break;

            case 2: // '\002'
                Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                break;

            case 3: // '\003'
                Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                // fall through

            case 4: // '\004'
                Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[] {
                    webrequestexception.getMessage()
                });
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
