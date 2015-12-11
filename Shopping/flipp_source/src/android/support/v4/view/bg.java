// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewConfiguration;

// Referenced classes of package android.support.v4.view:
//            bk, bj, bi, bh, 
//            bl

public final class bg
{

    static final bl a;

    public static int a(ViewConfiguration viewconfiguration)
    {
        return a.a(viewconfiguration);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new bk();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new bj();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            a = new bi();
        } else
        {
            a = new bh();
        }
    }
}
