// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.eg;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps.internal:
//            c

public class q
{

    private static Context Ci;
    private static com.google.android.gms.maps.internal.c Cj;

    public q()
    {
    }

    private static Object a(ClassLoader classloader, String s)
    {
        try
        {
            classloader = ((ClassLoader) (c(((ClassLoader)eg.f(classloader)).loadClass(s))));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to find dynamic class ").append(s).toString());
        }
        return classloader;
    }

    private static Object c(Class class1)
    {
        Object obj;
        try
        {
            obj = class1.newInstance();
        }
        catch (InstantiationException instantiationexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to instantiate the dynamic class ").append(class1.getName()).toString());
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to call the default constructor of ").append(class1.getName()).toString());
        }
        return obj;
    }

    private static boolean eB()
    {
        return false;
    }

    private static Class eC()
    {
        Class class1;
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 15)
            {
                return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
            }
            class1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException(classnotfoundexception);
        }
        return class1;
    }

    private static Context getRemoteContext(Context context)
    {
        if (Ci == null)
        {
            if (eB())
            {
                Ci = context;
            } else
            {
                Ci = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return Ci;
    }

    public static com.google.android.gms.maps.internal.c u(Context context)
        throws GooglePlayServicesNotAvailableException
    {
        eg.f(context);
        if (Cj != null)
        {
            return Cj;
        }
        v(context);
        Cj = w(context);
        try
        {
            Cj.a(com.google.android.gms.dynamic.c.h(getRemoteContext(context).getResources()), 0x40ba50);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeRemoteException(context);
        }
        return Cj;
    }

    private static void v(Context context)
        throws GooglePlayServicesNotAvailableException
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (i)
        {
        default:
            throw new GooglePlayServicesNotAvailableException(i);

        case 0: // '\0'
            return;
        }
    }

    private static com.google.android.gms.maps.internal.c w(Context context)
    {
        if (eB())
        {
            Log.i(com/google/android/gms/maps/internal/q.getSimpleName(), "Making Creator statically");
            return (com.google.android.gms.maps.internal.c)c(eC());
        } else
        {
            return com.google.android.gms.maps.internal.c.a.Q((IBinder)a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
    }
}
