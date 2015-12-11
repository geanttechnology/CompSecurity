// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.HttpURLConnection;
import java.net.URL;

public class czp
{

    final egf a;

    public czp()
    {
        this(null);
    }

    public czp(egf egf1)
    {
        a = egf1;
    }

    public HttpURLConnection a(eyk eyk1, URL url)
    {
        url = (HttpURLConnection)url.openConnection();
        url.setReadTimeout(eyk1.f);
        url.setConnectTimeout(eyk1.e);
        if (a != null)
        {
            url.addRequestProperty("User-Agent", (String)a.get());
        }
        if (eyk1.g)
        {
            url.setChunkedStreamingMode(eyk1.h);
        } else
        {
            url.setChunkedStreamingMode(1024);
        }
        if (android.os.Build.VERSION.SDK_INT <= 14)
        {
            url.addRequestProperty("Transfer-Encoding", "chunked");
        }
        return url;
    }
}
