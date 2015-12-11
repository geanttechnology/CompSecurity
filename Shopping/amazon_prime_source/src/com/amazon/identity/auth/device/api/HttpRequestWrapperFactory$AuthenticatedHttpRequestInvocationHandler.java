// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            HttpRequestWrapperFactory, AuthenticationMethod

private static class mDummyAuthHttpRequest
    implements InvocationHandler
{

    private final mDummyAuthHttpRequest mDummyAuthHttpRequest;
    private final Object mHttpRequestToWrap;

    private boolean containsMethod(Class class1, Method method)
    {
        try
        {
            class1.getMethod(method.getName(), method.getParameterTypes());
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return false;
        }
        return true;
    }

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        if (containsMethod(mHttpRequestToWrap.getClass(), method))
        {
            return method.invoke(mHttpRequestToWrap, aobj);
        } else
        {
            return method.invoke(mDummyAuthHttpRequest, aobj);
        }
    }

    public (Object obj, AuthenticationMethod authenticationmethod)
    {
        mHttpRequestToWrap = obj;
        mDummyAuthHttpRequest = new mDummyAuthHttpRequest(authenticationmethod);
    }
}
