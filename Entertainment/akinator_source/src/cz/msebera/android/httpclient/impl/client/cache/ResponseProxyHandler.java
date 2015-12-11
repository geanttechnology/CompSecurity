// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpResponse;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package cz.msebera.android.httpclient.impl.client.cache:
//            IOUtils

class ResponseProxyHandler
    implements InvocationHandler
{

    private static final Method CLOSE_METHOD;
    private final HttpResponse original;

    ResponseProxyHandler(HttpResponse httpresponse)
    {
        original = httpresponse;
    }

    public void close()
        throws IOException
    {
        IOUtils.consume(original.getEntity());
    }

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        if (method.equals(CLOSE_METHOD))
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
            CLOSE_METHOD = java/io/Closeable.getMethod("close", new Class[0]);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            throw new Error(nosuchmethodexception);
        }
    }
}
