// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package a.a:
//            fj, fp, en, eq, 
//            ds

public final class fn extends fj
{

    private static final String f[] = {
        "libcore.net.http.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.https.HttpsURLConnection"
    };

    public fn(eq eq, ds ds)
    {
        super(eq, ds, f);
    }

    protected final String a()
    {
        return "https";
    }

    protected final int getDefaultPort()
    {
        return 443;
    }

    protected final URLConnection openConnection(URL url)
    {
        url = (HttpsURLConnection)super.openConnection(url);
        fp fp1;
        try
        {
            fp1 = new fp(url, super.c, super.d);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw url;
        }
        catch (Throwable throwable)
        {
            en.a(throwable);
            return url;
        }
        return fp1;
    }

    protected final URLConnection openConnection(URL url, Proxy proxy)
    {
        url = (HttpsURLConnection)super.openConnection(url, proxy);
        try
        {
            proxy = new fp(url, super.c, super.d);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            throw url;
        }
        // Misplaced declaration of an exception variable
        catch (Proxy proxy)
        {
            en.a(proxy);
            return url;
        }
        return proxy;
    }

}
