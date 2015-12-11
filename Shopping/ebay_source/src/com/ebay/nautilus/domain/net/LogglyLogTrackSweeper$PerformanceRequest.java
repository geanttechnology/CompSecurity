// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackPerf;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            LogglyLogTrackSweeper

public static final class setOperationName extends Request
{

    private static URL LOGGLY_URL;
    private static final int TIMEOUT = 10000;
    private final LogTrackPerf _tracker;

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.setOperationName
    {
        byte abyte0[];
        try
        {
            abyte0 = LogglyLogTrackSweeper.buildData(getContext(), _tracker).toString().getBytes();
        }
        catch (JSONException jsonexception)
        {
            throw com.ebay.nautilus.kernel.net.e(jsonexception);
        }
        return abyte0;
    }

    public URL getRequestUrl()
    {
        return LOGGLY_URL;
    }

    public  getResponse()
    {
        return new ();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public String getUserAgent()
    {
        return null;
    }

    public boolean isErrorReportable()
    {
        return false;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        iheaders.setHeader("Content-Type", "application/json");
    }

    static 
    {
        try
        {
            LOGGLY_URL = new URL("https://logs.loggly.com/inputs/402b7be9-7480-4a8b-9103-1fe77ef48703");
        }
        catch (MalformedURLException malformedurlexception)
        {
            LogglyLogTrackSweeper.access$000().OGGLY_URL("Unable to initialize LOGGLY_URL");
        }
    }

    public (LogTrackPerf logtrackperf)
    {
        _tracker = logtrackperf;
        setTimeout(10000);
        setServiceName("Logging");
        setOperationName("loggly");
    }
}
