// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.os.IBinder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class x
{
    public static final class a extends Exception
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


    private static IBinder a(Class class1, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, boolean flag)
    {
        try
        {
            ibinder = (IBinder)class1.getConstructor(new Class[] {
                android/os/IBinder, android/os/IBinder, android/os/IBinder, Boolean.TYPE
            }).newInstance(new Object[] {
                ibinder, ibinder1, ibinder2, Boolean.valueOf(flag)
            });
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            class1 = String.valueOf(class1.getName());
            if (class1.length() != 0)
            {
                class1 = "Could not find the right constructor for ".concat(class1);
            } else
            {
                class1 = new String("Could not find the right constructor for ");
            }
            throw new a(class1, ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            class1 = String.valueOf(class1.getName());
            if (class1.length() != 0)
            {
                class1 = "Exception thrown by invoked constructor in ".concat(class1);
            } else
            {
                class1 = new String("Exception thrown by invoked constructor in ");
            }
            throw new a(class1, ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            class1 = String.valueOf(class1.getName());
            if (class1.length() != 0)
            {
                class1 = "Unable to instantiate the dynamic class ".concat(class1);
            } else
            {
                class1 = new String("Unable to instantiate the dynamic class ");
            }
            throw new a(class1, ibinder);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            class1 = String.valueOf(class1.getName());
            if (class1.length() != 0)
            {
                class1 = "Unable to call the default constructor of ".concat(class1);
            } else
            {
                class1 = new String("Unable to call the default constructor of ");
            }
            throw new a(class1, ibinder);
        }
        return ibinder;
    }

    static IBinder a(ClassLoader classloader, String s, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, boolean flag)
    {
        try
        {
            classloader = a(classloader.loadClass(s), ibinder, ibinder1, ibinder2, flag);
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            classloader = String.valueOf(s);
            if (classloader.length() != 0)
            {
                classloader = "Unable to find dynamic class ".concat(classloader);
            } else
            {
                classloader = new String("Unable to find dynamic class ");
            }
            throw new a(classloader, ibinder);
        }
        return classloader;
    }
}
