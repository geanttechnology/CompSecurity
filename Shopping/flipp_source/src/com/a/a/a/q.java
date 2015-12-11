// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.a.a.a:
//            p, m, r

final class q extends p
{

    private final Method a;
    private final Method b;
    private final Class c;
    private final Class d;

    public q(Method method, Method method1, Method method2, Class class1, Class class2)
    {
        super(method, (byte)0);
        b = method1;
        a = method2;
        c = class1;
        d = class2;
    }

    public final void a(SSLSocket sslsocket, byte abyte0[])
    {
        int i = 0;
        Object obj = new ArrayList();
        while (i < abyte0.length) 
        {
            int j = i + 1;
            i = abyte0[i];
            Class class1;
            Class class2;
            try
            {
                ((List) (obj)).add(new String(abyte0, j, i, "US-ASCII"));
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            // Misplaced declaration of an exception variable
            catch (SSLSocket sslsocket)
            {
                throw new AssertionError(sslsocket);
            }
            i += j;
        }
        abyte0 = com/a/a/a/m.getClassLoader();
        class1 = c;
        class2 = d;
        obj = new r(((List) (obj)));
        abyte0 = ((byte []) (Proxy.newProxyInstance(abyte0, new Class[] {
            class1, class2
        }, ((java.lang.reflect.InvocationHandler) (obj)))));
        b.invoke(null, new Object[] {
            sslsocket, abyte0
        });
        return;
    }

    public final byte[] b(SSLSocket sslsocket)
    {
        sslsocket = (r)Proxy.getInvocationHandler(a.invoke(null, new Object[] {
            sslsocket
        }));
        if (r.a(sslsocket) || r.b(sslsocket) != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
        return null;
        if (r.a(sslsocket))
        {
            return null;
        }
        try
        {
            sslsocket = r.b(sslsocket).getBytes("US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new AssertionError();
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket)
        {
            throw new AssertionError();
        }
        return sslsocket;
    }
}
