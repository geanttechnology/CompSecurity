// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

// Referenced classes of package a.a:
//            fi, et, fs, en, 
//            eq, ds

public abstract class fj extends URLStreamHandler
{

    public static final String a[] = {
        "java.net.URL", "int", "java.net.Proxy"
    };
    public static final String b[] = {
        "java.net.URL", "int"
    };
    eq c;
    ds d;
    boolean e;
    private Constructor f;
    private Constructor g;

    public fj(eq eq, ds ds, String as[])
    {
        this(eq, ds, as, a, b);
    }

    private fj(eq eq, ds ds, String as[], String as1[], String as2[])
    {
        int i;
        f = null;
        g = null;
        c = eq;
        d = ds;
        e = true;
        i = 0;
_L2:
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        f = fi.a(as[i], as2);
        g = fi.a(as[i], as1);
        f.setAccessible(true);
        g.setAccessible(true);
        if (f == null || g == null)
        {
            throw new ClassNotFoundException("Couldn't find suitable connection implementations");
        }
        break; /* Loop/switch isn't completed */
        eq;
        f = null;
        f = null;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!b())
        {
            throw new ClassNotFoundException("Unable to open test connections");
        } else
        {
            return;
        }
    }

    private URLConnection a(URL url, Proxy proxy)
    {
        Proxy proxy1;
        String s;
        proxy1 = null;
        s = (new StringBuilder("Unable to setup network statistics on a ")).append(a()).append(" connection due to ").toString();
        et et1 = et.e;
        if (proxy != null) goto _L2; else goto _L1
_L1:
        proxy = (URLConnection)f.newInstance(new Object[] {
            url, Integer.valueOf(getDefaultPort())
        });
        proxy1 = proxy;
        proxy = null;
_L3:
        if (proxy != null)
        {
            if (e)
            {
                e = false;
                proxy = fs.a();
                boolean flag;
                if (proxy != null)
                {
                    flag = proxy.c();
                } else
                {
                    flag = false;
                }
                en.b("Stopping network statistics monitoring");
                if (flag)
                {
                    return (new URL(url.toExternalForm())).openConnection();
                }
            } else
            {
                throw proxy;
            }
        }
        break MISSING_BLOCK_LABEL_315;
_L2:
        proxy = (URLConnection)g.newInstance(new Object[] {
            url, Integer.valueOf(getDefaultPort()), proxy
        });
        proxy1 = proxy;
        proxy = null;
          goto _L3
        proxy;
        (new StringBuilder()).append(s).append("bad arguments");
        en.b();
        proxy = new IOException(proxy.getMessage());
          goto _L3
        proxy;
        (new StringBuilder()).append(s).append("an instantiation problem");
        en.b();
        proxy = new IOException(proxy.getMessage());
          goto _L3
        proxy;
        (new StringBuilder()).append(s).append("security restrictions");
        en.b();
        proxy = new IOException(proxy.getMessage());
          goto _L3
        proxy;
        (new StringBuilder()).append(s).append("an invocation problem");
        en.b();
        proxy = new IOException(proxy.getMessage());
          goto _L3
        return proxy1;
    }

    private boolean b()
    {
        Exception exception;
        e = false;
        try
        {
            openConnection(new URL("http://www.google.com"));
        }
        catch (IOException ioexception)
        {
            e = true;
            return false;
        }
        finally
        {
            e = true;
        }
        e = true;
        return true;
        throw exception;
    }

    protected abstract String a();

    protected abstract int getDefaultPort();

    protected URLConnection openConnection(URL url)
    {
        return a(url, null);
    }

    protected URLConnection openConnection(URL url, Proxy proxy)
    {
        if (url == null || proxy == null)
        {
            throw new IllegalArgumentException("url == null || proxy == null");
        } else
        {
            return a(url, proxy);
        }
    }

}
