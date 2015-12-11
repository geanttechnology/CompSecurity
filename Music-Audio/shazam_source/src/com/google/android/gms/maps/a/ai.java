// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.a;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.w;

// Referenced classes of package com.google.android.gms.maps.a:
//            n

public class ai
{

    private static Context a;
    private static n b;

    public ai()
    {
    }

    public static n a(Context context)
    {
        w.a(context);
        if (b != null)
        {
            return b;
        }
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (i)
        {
        default:
            throw new c(i);

        case 0: // '\0'
            com/google/android/gms/maps/a/ai.getSimpleName();
            break;
        }
        b = n.a.a((IBinder)a(b(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        try
        {
            b.a(d.a(b(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new com.google.android.gms.maps.model.d(context);
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
            throw new IllegalStateException((new StringBuilder("Unable to instantiate the dynamic class ")).append(class1.getName()).toString());
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new IllegalStateException((new StringBuilder("Unable to call the default constructor of ")).append(class1.getName()).toString());
        }
        return obj;
    }

    private static Object a(ClassLoader classloader, String s)
    {
        try
        {
            classloader = ((ClassLoader) (a(((ClassLoader)w.a(classloader)).loadClass(s))));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new IllegalStateException((new StringBuilder("Unable to find dynamic class ")).append(s).toString());
        }
        return classloader;
    }

    private static Context b(Context context)
    {
        if (a == null)
        {
            a = GooglePlayServicesUtil.getRemoteContext(context);
        }
        return a;
    }
}
