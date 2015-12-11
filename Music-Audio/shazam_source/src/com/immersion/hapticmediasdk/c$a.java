// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import com.immersion.hapticmediasdk.b.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.immersion.hapticmediasdk:
//            c

private final class a
    implements Runnable
{

    public static int b = 24;
    public static int c = 1;
    public static int d = 2;
    public final c a;
    private URL e;

    private void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        com.immersion.hapticmediasdk.c.a(a, i);
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void run()
    {
        HttpURLConnection httpurlconnection;
        httpurlconnection = (HttpURLConnection)e.openConnection();
        httpurlconnection.setConnectTimeout(10000);
        httpurlconnection.setReadTimeout(10000);
        httpurlconnection.setUseCaches(false);
        int i = b;
        switch ((i * (c + i)) % d)
        {
        default:
            b = 0;
            c = 6;
            break;

        case 0: // '\0'
            break;
        }
        int j;
        httpurlconnection.setRequestMethod("HEAD");
        j = httpurlconnection.getResponseCode();
        Object obj;
        try
        {
            a(j);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
        obj;
        com.immersion.hapticmediasdk.b.b.a("ValidateURL", ((IOException) (obj)).getMessage());
        try
        {
            a(500);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        obj;
        a(500);
        throw obj;
    }

    public (c c1)
    {
        a = c1;
        do
        {
        } while (true);
    }
}
