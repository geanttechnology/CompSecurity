// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common;

import android.util.Log;

// Referenced classes of package com.pf.common:
//            b

public final class a
{

    private final boolean a;

    private a()
    {
        a = a("perfect", 6);
    }


    public static boolean a()
    {
        return com.pf.common.b.a().a;
    }

    private static boolean a(String s, int i)
    {
        try
        {
            System.loadLibrary(s);
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            Log.println(i, "JNILoader", (new StringBuilder()).append("Could not load lib").append(s).toString());
            return false;
        }
        return true;
    }

    public static void b()
    {
        if (!a())
        {
            throw new UnsatisfiedLinkError("Could not load the native engine libraries.");
        } else
        {
            return;
        }
    }
}
