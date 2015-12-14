// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, AuthenticationMethod

public final class HttpRequestWrapperFactory
{
    private static class AuthenticatedHttpRequestInvocationHandler
        implements InvocationHandler
    {

        private final DummyAuthenticatedHttpRequest mDummyAuthHttpRequest;
        private final Object mHttpRequestToWrap;

        private boolean containsMethod(Class class1, Method method)
        {
            boolean flag = false;
            try
            {
                class1 = class1.getMethod(method.getName(), method.getParameterTypes());
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
            if (class1 != null)
            {
                flag = true;
            }
            return flag;
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

        public AuthenticatedHttpRequestInvocationHandler(Object obj, AuthenticationMethod authenticationmethod)
        {
            mHttpRequestToWrap = obj;
            mDummyAuthHttpRequest = new DummyAuthenticatedHttpRequest(authenticationmethod);
        }
    }

    private static class DummyAuthenticatedHttpRequest
        implements AuthenticatedHttpRequest
    {

        private final AuthenticationMethod mAuthMethod;

        public AuthenticationMethod getAuthenticationMethod()
        {
            return mAuthMethod;
        }

        public DummyAuthenticatedHttpRequest(AuthenticationMethod authenticationmethod)
        {
            mAuthMethod = authenticationmethod;
        }
    }


    private HttpRequestWrapperFactory()
    {
    }

    public static HttpRequest createAuthenticatedHttpRequestWrapper(Context context, HttpRequest httprequest, AuthenticationMethod authenticationmethod)
    {
        return (HttpRequest)createDynamicProxyForHttpRequestClass(context, httprequest, authenticationmethod);
    }

    public static HttpUriRequest createAuthenticatedHttpRequestWrapper(Context context, HttpUriRequest httpurirequest, AuthenticationMethod authenticationmethod)
    {
        return (HttpUriRequest)createDynamicProxyForHttpRequestClass(context, httpurirequest, authenticationmethod);
    }

    private static Object createDynamicProxyForHttpRequestClass(Context context, Object obj, AuthenticationMethod authenticationmethod)
    {
        HashSet hashset = new HashSet();
        hashset.addAll(getAllInterfacesImplementedByClass(obj.getClass()));
        hashset.add(com/amazon/identity/auth/device/api/AuthenticatedHttpRequest);
        obj = new AuthenticatedHttpRequestInvocationHandler(obj, authenticationmethod);
        return Proxy.newProxyInstance(context.getClassLoader(), (Class[])hashset.toArray(new Class[0]), ((InvocationHandler) (obj)));
    }

    private static Set getAllInterfacesImplementedByClass(Class class1)
    {
        HashSet hashset = new HashSet();
        for (; !java/lang/Object.equals(class1); class1 = class1.getSuperclass())
        {
            hashset.addAll(Arrays.asList(class1.getInterfaces()));
        }

        return hashset;
    }
}
