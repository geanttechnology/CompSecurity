// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ke extends Exception
{

    private static final Method a;
    private IOException b;

    public ke(IOException ioexception)
    {
        super(ioexception);
        b = ioexception;
    }

    public final IOException a()
    {
        return b;
    }

    public final void a(IOException ioexception)
    {
        IOException ioexception1 = b;
        if (a != null)
        {
            try
            {
                a.invoke(ioexception, new Object[] {
                    ioexception1
                });
            }
            catch (InvocationTargetException invocationtargetexception) { }
            catch (IllegalAccessException illegalaccessexception) { }
        }
        b = ioexception;
    }

    static 
    {
        Method method;
        try
        {
            method = java/lang/Throwable.getDeclaredMethod("addSuppressed", new Class[] {
                java/lang/Throwable
            });
        }
        catch (Exception exception)
        {
            exception = null;
        }
        a = method;
    }
}
