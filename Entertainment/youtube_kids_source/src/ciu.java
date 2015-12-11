// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

abstract class ciu
    implements Runnable
{

    private static final String i = ciu.getSimpleName();
    public final URL a;
    public final ciz b;
    public final int c;
    public final cin d;
    public final cio e;
    public int f;
    public IOException g;
    volatile boolean h;

    public ciu(URL url, ciz ciz, int j, cin cin, cio cio1)
    {
        f = 0;
        a = url;
        d = cin;
        b = ciz;
        c = j;
        e = cio1;
    }

    protected static String a(cix cix1)
    {
        if (cix1 == null)
        {
            return null;
        } else
        {
            long l = cix1.a;
            long l1 = cix1.b;
            return (new StringBuilder(47)).append("bytes=").append(l).append("-").append(l1).toString();
        }
    }

    protected final HttpURLConnection a(URL url, String s, ciz ciz)
    {
        Object obj1 = null;
        url.toString();
        int j = 0;
        Object obj = url;
        url = ((URL) (obj1));
        do
        {
            obj1 = url;
            if (j > 20)
            {
                break;
            }
            url = ((URL) (obj)).getHost();
            obj1 = i;
            obj1 = String.valueOf(ciz);
            (new StringBuilder(String.valueOf(url).length() + 37 + String.valueOf(obj1).length())).append("requestRouteForHostnameAndNetwork: ").append(url).append("; ").append(((String) (obj1)));
            if (!ciy.a().a(url, ciz))
            {
                obj1 = i;
                String s1 = String.valueOf(ciz);
                Log.e(((String) (obj1)), (new StringBuilder(String.valueOf(url).length() + 87 + String.valueOf(s1).length())).append("Failed to request route for hostName = ").append(url).append(" for networkType = ").append(s1).append(".  Continue as a best effort.").toString());
            }
            url = (HttpURLConnection)((URL) (obj)).openConnection();
            url.setConnectTimeout(e.d.a.d);
            url.setReadTimeout(e.d.a.e);
            obj = e.i;
            if (obj != null)
            {
                url.setRequestProperty("User-Agent", ((String) (obj)));
            }
            if (s != null)
            {
                url.setRequestProperty("Range", s);
            }
            url.setInstanceFollowRedirects(false);
            obj1 = url;
            if (url.getResponseCode() != 302)
            {
                break;
            }
            obj = new URL(url.getHeaderField("Location"));
            obj1 = i;
            obj1 = String.valueOf(obj);
            (new StringBuilder(String.valueOf(obj1).length() + 16)).append("redirected to : ").append(((String) (obj1)));
            j++;
        } while (true);
        if (j > 20)
        {
            throw new IOException("Exceeded maximum allowed redirects: MAX_REDIRECTS: 20");
        } else
        {
            return ((HttpURLConnection) (obj1));
        }
    }

    final void a(long l)
    {
        try
        {
            Thread.sleep(((long)f * l) / 4096L);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
    }

}
