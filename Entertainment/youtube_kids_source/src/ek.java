// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ViewConfiguration;

public final class ek
{

    private static eo a;

    public static boolean a(ViewConfiguration viewconfiguration)
    {
        return a.a(viewconfiguration);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new en();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new em();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            a = new el();
        } else
        {
            a = new eo();
        }
    }
}
