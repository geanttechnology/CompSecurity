// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import java.io.IOException;
import java.lang.reflect.Method;

public final class o extends Exception
{

    static final Method a;
    public IOException b;

    public o(IOException ioexception)
    {
        super(ioexception);
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
