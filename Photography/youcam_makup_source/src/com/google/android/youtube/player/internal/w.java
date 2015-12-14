// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.google.android.youtube.player.internal:
//            ac, z, aa, v, 
//            u, d

public final class w
{

    private static IBinder a(Class class1, IBinder ibinder, IBinder ibinder1)
    {
        try
        {
            ibinder = (IBinder)class1.getConstructor(new Class[] {
                android/os/IBinder, android/os/IBinder
            }).newInstance(new Object[] {
                ibinder, ibinder1
            });
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            throw new a((new StringBuilder("Could not find the right constructor for ")).append(class1.getName()).toString(), ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            throw new a((new StringBuilder("Exception thrown by invoked constructor in ")).append(class1.getName()).toString(), ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            throw new a((new StringBuilder("Unable to instantiate the dynamic class ")).append(class1.getName()).toString(), ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            throw new a((new StringBuilder("Unable to call the default constructor of ")).append(class1.getName()).toString(), ibinder);
        }
        return ibinder;
    }

    private static IBinder a(ClassLoader classloader, String s, IBinder ibinder, IBinder ibinder1)
    {
        try
        {
            classloader = a(classloader.loadClass(s), ibinder, ibinder1);
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new a((new StringBuilder("Unable to find dynamic class ")).append(s).toString(), classloader);
        }
        return classloader;
    }

    public static d a(Activity activity, IBinder ibinder)
    {
        ac.a(activity, "activity cannot be null");
        ac.a(ibinder, "serviceBinder cannot be null");
        Context context = z.b(activity);
        if (context == null)
        {
            throw new a("Could not create remote context");
        } else
        {
            activity = new aa(activity, context.getResources(), context.getClassLoader(), z.a(activity, context));
            return d.a.a(a(context.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", v.a(activity).asBinder(), ibinder));
        }
    }

    private class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }

        public a(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }

}
