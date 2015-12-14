// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class h
{

    private static final String a = com/inmobi/signals/h.getSimpleName();

    public h()
    {
    }

    public static Object a(Context context, InvocationHandler invocationhandler, InvocationHandler invocationhandler1, String s)
    {
        Object obj1;
        Object obj2;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Build object for GoogleApiClient");
        obj1 = null;
        obj2 = null;
        Object obj3 = Class.forName("com.google.android.gms.common.api.GoogleApiClient");
        Object obj = null;
        Class aclass[];
        int j;
        aclass = ((Class) (obj3)).getDeclaredClasses();
        j = aclass.length;
        int i = 0;
_L10:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Class class1 = aclass[i];
        if (!class1.getSimpleName().equalsIgnoreCase("ConnectionCallbacks")) goto _L4; else goto _L3
_L3:
        obj3 = Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
            class1
        }, invocationhandler);
        obj1 = obj2;
        obj2 = obj3;
          goto _L5
_L4:
        if (!class1.getSimpleName().equalsIgnoreCase("OnConnectionFailedListener")) goto _L7; else goto _L6
_L6:
        obj3 = Proxy.newProxyInstance(class1.getClassLoader(), new Class[] {
            class1
        }, invocationhandler1);
        obj2 = obj1;
        obj1 = obj3;
          goto _L5
_L7:
        if (class1.getSimpleName().equalsIgnoreCase("Builder"))
        {
            Object obj4 = obj1;
            obj = class1;
            obj1 = obj2;
            obj2 = obj4;
        } else
        {
            Object obj6 = obj2;
            obj2 = obj1;
            obj1 = obj6;
        }
          goto _L5
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        context = ((Context) (((Class) (obj)).getDeclaredConstructor(new Class[] {
            android/content/Context
        }).newInstance(new Object[] {
            context
        })));
        invocationhandler = Class.forName("com.google.android.gms.common.api.Api");
        Object obj5 = Class.forName("com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks");
        invocationhandler1 = Class.forName("com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener");
        invocationhandler = ((Class) (obj)).getMethod("addApi", new Class[] {
            invocationhandler
        });
        obj5 = ((Class) (obj)).getMethod("addConnectionCallbacks", new Class[] {
            obj5
        });
        invocationhandler1 = ((Class) (obj)).getMethod("addOnConnectionFailedListener", new Class[] {
            invocationhandler1
        });
        obj = ((Class) (obj)).getMethod("build", (Class[])null);
        invocationhandler.invoke(context, new Object[] {
            Class.forName(s).getDeclaredField("API").get(null)
        });
        ((Method) (obj5)).invoke(context, new Object[] {
            obj1
        });
        invocationhandler1.invoke(context, new Object[] {
            obj2
        });
        context = ((Context) (((Method) (obj)).invoke(context, (Object[])null)));
        return context;
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
_L8:
        return null;
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        continue; /* Loop/switch isn't completed */
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        continue; /* Loop/switch isn't completed */
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        continue; /* Loop/switch isn't completed */
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        continue; /* Loop/switch isn't completed */
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        continue; /* Loop/switch isn't completed */
        context;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Cannot build Google API client object", context);
        if (true) goto _L8; else goto _L5
_L5:
        i++;
        Object obj7 = obj2;
        obj2 = obj1;
        obj1 = obj7;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void a(Object obj)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Connecting Google API client.");
        if (obj == null)
        {
            return;
        }
        try
        {
            Class.forName("com.google.android.gms.common.api.GoogleApiClient").getMethod("connect", (Class[])null).invoke(obj, (Object[])null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call connect on GoogleApiClient", ((Throwable) (obj)));
        }
    }

    public static boolean a()
    {
        boolean flag = false;
        int i;
        try
        {
            i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(com.inmobi.commons.a.a.b());
        }
        catch (NoClassDefFoundError noclassdeffounderror)
        {
            noclassdeffounderror.printStackTrace();
            return false;
        }
        if (i == 0)
        {
            flag = true;
        }
        return flag;
    }

    public static void b(Object obj)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Disconnecting Google API client.");
        if (obj == null)
        {
            return;
        }
        try
        {
            Class.forName("com.google.android.gms.common.api.GoogleApiClient").getMethod("disconnect", (Class[])null).invoke(obj, (Object[])null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", ((Throwable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to call disconnect on GoogleApiClient", ((Throwable) (obj)));
        }
    }

}
