// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewGroup;

// Referenced classes of package android.support.v4.view:
//            cf, ce, cc, cb, 
//            cd

public final class ca
{

    private static cd a;

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        a.a(viewgroup, false);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new cf();
        } else
        if (i >= 18)
        {
            a = new ce();
        } else
        if (i >= 14)
        {
            a = new cc();
        } else
        if (i >= 11)
        {
            a = new cb();
        } else
        {
            a = new cd();
        }
    }
}
