// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UiInvocationHandler
    implements InvocationHandler
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/client/UiInvocationHandler);
    RetailSearchAndroidPlatform platform;
    private final WeakReference resourceRef;

    public UiInvocationHandler(Object obj)
    {
        resourceRef = new WeakReference(obj);
        RetailSearchDaggerGraphController.inject(this);
    }

    public static Object createUiProxy(Object obj, Class class1)
    {
        ClassLoader classloader = class1.getClassLoader();
        obj = new UiInvocationHandler(obj);
        return class1.cast(Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, ((InvocationHandler) (obj))));
    }

    public Object invoke(Object obj, final Method method, final Object args[])
    {
        if (resourceRef.get() == null)
        {
            return null;
        } else
        {
            platform.invokeLater(new Runnable() {

                final UiInvocationHandler this$0;
                final Object val$args[];
                final Method val$method;

                public void run()
                {
                    Object obj1 = resourceRef.get();
                    if (obj1 == null)
                    {
                        return;
                    }
                    try
                    {
                        method.invoke(obj1, args);
                        return;
                    }
                    catch (Exception exception)
                    {
                        UiInvocationHandler.log.error((new StringBuilder()).append("Failed to invoke method ").append(method.getName()).toString(), exception);
                    }
                }

            
            {
                this$0 = UiInvocationHandler.this;
                method = method1;
                args = aobj;
                super();
            }
            });
            return null;
        }
    }



}
