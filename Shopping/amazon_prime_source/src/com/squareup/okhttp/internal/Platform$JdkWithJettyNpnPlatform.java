// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.okio.ByteString;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.squareup.okhttp.internal:
//            Platform

private static class serverProviderClass extends Platform
{

    private final Class clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Class serverProviderClass;

    public ByteString getNpnSelectedProtocol(SSLSocket sslsocket)
    {
        sslsocket = (serverProviderClass)Proxy.getInvocationHandler(getMethod.invoke(null, new Object[] {
            sslsocket
        }));
        if (_mth100(sslsocket) || _mth200(sslsocket) != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN callback dropped so SPDY is disabled. Is npn-boot on the boot class path?");
        return null;
label0:
        {
            try
            {
                if (_mth100(sslsocket))
                {
                    break label0;
                }
                sslsocket = ByteString.encodeUtf8(_mth200(sslsocket));
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
        return null;
    }

    public void setNpnProtocols(SSLSocket sslsocket, List list)
    {
        Object obj;
        Class class1;
        Class class2;
        int i;
        int j;
        try
        {
            obj = new ArrayList(list.size());
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
        i = 0;
        j = list.size();
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((List) (obj)).add(((Protocol)list.get(i)).name.utf8());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        list = com/squareup/okhttp/internal/Platform.getClassLoader();
        class1 = clientProviderClass;
        class2 = serverProviderClass;
        obj = new serverProviderClass(((List) (obj)));
        list = ((List) (Proxy.newProxyInstance(list, new Class[] {
            class1, class2
        }, ((java.lang.reflect.InvocationHandler) (obj)))));
        putMethod.invoke(null, new Object[] {
            sslsocket, list
        });
        return;
    }

    public (Method method, Method method1, Class class1, Class class2)
    {
        putMethod = method;
        getMethod = method1;
        clientProviderClass = class1;
        serverProviderClass = class2;
    }
}
