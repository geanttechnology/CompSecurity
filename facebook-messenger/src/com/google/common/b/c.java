// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.b;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c
{

    private static final Logger a = Logger.getLogger(com/google/common/b/c.getName());

    private c()
    {
    }

    public static void a(Closeable closeable)
    {
        try
        {
            a(closeable, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            a.log(Level.SEVERE, "IOException should not have been thrown.", closeable);
        }
    }

    public static void a(Closeable closeable, boolean flag)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable) { }
        if (flag)
        {
            a.log(Level.WARNING, "IOException thrown while closing Closeable.", closeable);
            return;
        } else
        {
            throw closeable;
        }
    }

}
