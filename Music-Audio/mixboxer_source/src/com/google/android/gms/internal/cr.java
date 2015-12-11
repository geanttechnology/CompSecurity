// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.internal:
//            cm, ct, co

public final class cr extends cm
{

    private final String iG;
    private final String iH;
    private final Context mContext;

    public cr(Context context, String s, String s1)
    {
        mContext = context;
        iG = s;
        iH = s1;
    }

    public void ai()
    {
        HttpURLConnection httpurlconnection;
        ct.u((new StringBuilder()).append("Pinging URL: ").append(iH).toString());
        httpurlconnection = (HttpURLConnection)Instrumentation.openConnection((new URL(iH)).openConnection());
        int i;
        co.a(mContext, iG, true, httpurlconnection);
        i = httpurlconnection.getResponseCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        ct.v((new StringBuilder()).append("Received non-success response code ").append(i).append(" from pinging URL: ").append(iH).toString());
        Exception exception;
        try
        {
            httpurlconnection.disconnect();
            return;
        }
        catch (IOException ioexception)
        {
            ct.v((new StringBuilder()).append("Error while pinging URL: ").append(iH).append(". ").append(ioexception.getMessage()).toString());
        }
        break MISSING_BLOCK_LABEL_162;
        exception;
        httpurlconnection.disconnect();
        throw exception;
    }

    public void onStop()
    {
    }
}
