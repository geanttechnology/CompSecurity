// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.util.client.b;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.b:
//            bw, bz

public final class cd extends bw
{

    private final String a;
    private final Context b;
    private final String c;
    private String d;

    public cd(Context context, String s, String s1)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
    }

    public cd(Context context, String s, String s1, String s2)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
        d = s2;
    }

    public void a()
    {
        HttpURLConnection httpurlconnection;
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("Pinging URL: ").append(c).toString());
        httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(c)).openConnection());
        if (!TextUtils.isEmpty(d))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        com.google.android.gms.ads.internal.c.c().a(b, a, true, httpurlconnection);
_L1:
        int i = httpurlconnection.getResponseCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Received non-success response code ").append(i).append(" from pinging URL: ").append(c).toString());
        Exception exception;
        try
        {
            httpurlconnection.disconnect();
            return;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Error while parsing ping URL: ").append(c).append(". ").append(indexoutofboundsexception.getMessage()).toString());
            return;
        }
        catch (IOException ioexception)
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Error while pinging URL: ").append(c).append(". ").append(ioexception.getMessage()).toString());
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("Error while pinging URL: ").append(c).append(". ").append(runtimeexception.getMessage()).toString());
        }
        break MISSING_BLOCK_LABEL_276;
        com.google.android.gms.ads.internal.c.c().a(b, a, true, httpurlconnection, d);
          goto _L1
        exception;
        httpurlconnection.disconnect();
        throw exception;
    }
}
