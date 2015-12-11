// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package a.a:
//            fj, fo, en, eq, 
//            ds

public final class fl extends fj
{

    private static final String f[] = {
        "libcore.net.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnectionImpl", "org.apache.harmony.luni.internal.net.www.protocol.http.HttpURLConnection"
    };

    public fl(eq eq, ds ds)
    {
        super(eq, ds, f);
    }

    protected final String a()
    {
        return "http";
    }

    protected final int getDefaultPort()
    {
        return 80;
    }

    protected final URLConnection openConnection(URL url)
    {
        url = (HttpURLConnection)super.openConnection(url);
        fo fo1;
        try
        {
            fo1 = new fo(url, super.c, super.d);
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
        return fo1;
    }

    protected final URLConnection openConnection(URL url, Proxy proxy)
    {
        url = (HttpURLConnection)super.openConnection(url, proxy);
        try
        {
            proxy = new fo(url, super.c, super.d);
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
