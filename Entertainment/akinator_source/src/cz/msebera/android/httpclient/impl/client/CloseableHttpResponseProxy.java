// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class CloseableHttpResponseProxy
    implements InvocationHandler
{

    private static final Constructor CONSTRUCTOR;
    private final HttpResponse original;

    CloseableHttpResponseProxy(HttpResponse httpresponse)
    {
        original = httpresponse;
    }

    public static CloseableHttpResponse newProxy(HttpResponse httpresponse)
    {
        try
        {
            httpresponse = (CloseableHttpResponse)CONSTRUCTOR.newInstance(new Object[] {
                new CloseableHttpResponseProxy(httpresponse)
            });
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new IllegalStateException(httpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new IllegalStateException(httpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new IllegalStateException(httpresponse);
        }
        return httpresponse;
    }

    public void close()
        throws IOException
    {
        EntityUtils.consume(original.getEntity());
    }

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        if (method.getName().equals("close"))
        {
            close();
            return null;
        }
        try
        {
            obj = method.invoke(original, aobj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            method = ((InvocationTargetException) (obj)).getCause();
            if (method != null)
            {
                throw method;
            } else
            {
                throw obj;
            }
        }
        return obj;
    }

    static 
    {
        try
        {
            CONSTRUCTOR = Proxy.getProxyClass(cz/msebera/android/httpclient/impl/client/CloseableHttpResponseProxy.getClassLoader(), new Class[] {
                cz/msebera/android/httpclient/client/methods/CloseableHttpResponse
            }).getConstructor(new Class[] {
                java/lang/reflect/InvocationHandler
            });
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new IllegalStateException(nosuchmethodexception);
        }
    }
}
