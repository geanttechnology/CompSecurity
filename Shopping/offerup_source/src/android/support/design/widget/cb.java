// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            bn, ce, cd, cc, 
//            bk

final class cb
{

    private static bn a = new bn();
    private static final cc b;

    static bk a()
    {
        return a.a();
    }

    static void a(View view)
    {
        b.a(view);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            b = new ce((byte)0);
        } else
        {
            b = new cd((byte)0);
        }
    }
}
