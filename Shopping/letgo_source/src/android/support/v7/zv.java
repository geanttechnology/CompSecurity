// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.e;

// Referenced classes of package android.support.v7:
//            ll, yz

public class zv
{

    private static Context a;
    private static yz b;

    public zv()
    {
    }

    public static yz a(Context context)
        throws c
    {
        x.a(context);
        if (b != null)
        {
            return b;
        }
        b(context);
        b = c(context);
        try
        {
            b.a(ll.a(d(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new e(context);
        }
        return b;
    }

    private static Object a(Class class1)
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

    private static Object a(ClassLoader classloader, String s)
    {
        try
        {
            classloader = ((ClassLoader) (a(((ClassLoader)x.a(classloader)).loadClass(s))));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to find dynamic class ").append(s).toString());
        }
        return classloader;
    }

    public static boolean a()
    {
        return false;
    }

    private static Class b()
    {
        Class class1;
        try
        {
            class1 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RuntimeException(classnotfoundexception);
        }
        return class1;
    }

    private static void b(Context context)
        throws c
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (i)
        {
        default:
            throw new c(i);

        case 0: // '\0'
            return;
        }
    }

    private static yz c(Context context)
    {
        if (a())
        {
            Log.i(android/support/v7/zv.getSimpleName(), "Making Creator statically");
            return (yz)a(b());
        } else
        {
            Log.i(android/support/v7/zv.getSimpleName(), "Making Creator dynamically");
            return yz.a.a((IBinder)a(d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
    }

    private static Context d(Context context)
    {
        if (a == null)
        {
            if (a())
            {
                a = context.getApplicationContext();
            } else
            {
                a = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return a;
    }
}
