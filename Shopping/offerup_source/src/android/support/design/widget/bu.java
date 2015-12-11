// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.design.widget:
//            bx, bw, bv

final class bu
{

    private static final bv a;

    static void a(ViewGroup viewgroup, View view, Rect rect)
    {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        a.a(viewgroup, view, rect);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new bx((byte)0);
        } else
        {
            a = new bw((byte)0);
        }
    }
}
