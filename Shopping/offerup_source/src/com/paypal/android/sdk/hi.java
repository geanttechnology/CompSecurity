// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.paypal.android.sdk:
//            hg, gp, hj, ha

final class hi extends hg
{

    private final Method a;
    private final Method b;
    private final Method c;
    private final Class d;
    private final Class e;

    public hi(Method method, Method method1, Method method2, Class class1, Class class2)
    {
        a = method;
        b = method1;
        c = method2;
        d = class1;
        e = class2;
    }

    public final void a(SSLSocket sslsocket)
    {
        try
        {
            c.invoke(null, new Object[] {
                sslsocket
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket) { }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket) { }
        throw new AssertionError();
    }

    public final void a(SSLSocket sslsocket, String s, List list)
    {
        s = new ArrayList(list.size());
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            gp gp1 = (gp)list.get(i);
            if (gp1 != gp.a)
            {
                s.add(gp1.toString());
            }
        }

        try
        {
            list = com/paypal/android/sdk/hg.getClassLoader();
            Class class1 = d;
            Class class2 = e;
            s = new hj(s);
            s = ((String) (Proxy.newProxyInstance(list, new Class[] {
                class1, class2
            }, s)));
            a.invoke(null, new Object[] {
                sslsocket, s
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket) { }
        // Misplaced declaration of an exception variable
        catch (SSLSocket sslsocket) { }
        throw new AssertionError(sslsocket);
    }

    public final String b(SSLSocket sslsocket)
    {
        sslsocket = (hj)Proxy.getInvocationHandler(b.invoke(null, new Object[] {
            sslsocket
        }));
        if (hj.a(sslsocket) || hj.b(sslsocket) != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        ha.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
        return null;
        if (hj.a(sslsocket))
        {
            return null;
        }
        sslsocket = hj.b(sslsocket);
        return sslsocket;
        sslsocket;
_L2:
        throw new AssertionError();
        sslsocket;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
