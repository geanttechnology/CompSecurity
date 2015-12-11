// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class au extends e
{

    private HttpURLConnection a;

    public au()
    {
    }

    private HttpURLConnection i()
    {
        this;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = (HttpURLConnection)a().openConnection();
            a.setReadTimeout(c());
            a.setConnectTimeout(b());
            a.setRequestMethod(e());
            for (Iterator iterator = d().entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Iterator iterator1 = ((List)entry.getValue()).iterator();
                while (iterator1.hasNext()) 
                {
                    String s = (String)iterator1.next();
                    a.addRequestProperty((String)entry.getKey(), s);
                }
            }

        }
        break MISSING_BLOCK_LABEL_151;
        Exception exception;
        exception;
        throw exception;
        HttpURLConnection httpurlconnection = a;
        this;
        JVM INSTR monitorexit ;
        return httpurlconnection;
    }

    public final OutputStream f()
    {
        HttpURLConnection httpurlconnection = i();
        httpurlconnection.setDoOutput(true);
        return httpurlconnection.getOutputStream();
    }

    public final InputStream g()
    {
        return i().getInputStream();
    }

    public final int h()
    {
        return i().getResponseCode();
    }
}
