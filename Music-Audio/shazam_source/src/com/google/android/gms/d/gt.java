// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.d:
//            gi, gm

public final class gt extends gi
{

    private final String a;
    private final Context b;
    private final String c;
    private String d;

    public gt(Context context, String s, String s1)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
    }

    public gt(Context context, String s, String s1, String s2)
    {
        d = null;
        b = context;
        a = s;
        c = s1;
        d = s2;
    }

    public final void a()
    {
        HttpURLConnection httpurlconnection;
        (new StringBuilder("Pinging URL: ")).append(c);
        com.google.android.gms.ads.internal.util.client.b.a(2);
        httpurlconnection = (HttpURLConnection)(new URL(c)).openConnection();
        if (!TextUtils.isEmpty(d))
        {
            break MISSING_BLOCK_LABEL_121;
        }
        p.e().a(b, a, true, httpurlconnection);
_L1:
        int i = httpurlconnection.getResponseCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        (new StringBuilder("Received non-success response code ")).append(i).append(" from pinging URL: ").append(c);
        com.google.android.gms.ads.internal.util.client.b.a(5);
        Exception exception;
        try
        {
            httpurlconnection.disconnect();
            return;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            (new StringBuilder("Error while parsing ping URL: ")).append(c).append(". ").append(indexoutofboundsexception.getMessage());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        catch (IOException ioexception)
        {
            (new StringBuilder("Error while pinging URL: ")).append(c).append(". ").append(ioexception.getMessage());
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            (new StringBuilder("Error while pinging URL: ")).append(c).append(". ").append(runtimeexception.getMessage());
        }
        break MISSING_BLOCK_LABEL_245;
        p.e();
        gm.a(httpurlconnection, d);
          goto _L1
        exception;
        httpurlconnection.disconnect();
        throw exception;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final void b()
    {
    }
}
