// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class anf
{

    private static Context a;
    private static akw b;

    public anf()
    {
    }

    public static akw a(Context context)
    {
        ady.a(context);
        if (b != null)
        {
            return b;
        }
        b(context);
        b = c(context);
        try
        {
            b.a(sb.a(d(context).getResources()), 0x648278);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new anl(context);
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
            classloader = ((ClassLoader) (a(((ClassLoader)ady.a(classloader)).loadClass(s))));
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

    private static void b(Context context)
    {
        int i = pu.a(context);
        switch (i)
        {
        default:
            throw new ps(i);

        case 0: // '\0'
            return;
        }
    }

    private static akw c(Context context)
    {
        if (a())
        {
            Log.i(anf.getSimpleName(), "Making Creator statically");
            return (akw)a(b());
        } else
        {
            Log.i(anf.getSimpleName(), "Making Creator dynamically");
            return akx.a((IBinder)a(d(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
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
                a = pu.d(context);
            }
        }
        return a;
    }
}
