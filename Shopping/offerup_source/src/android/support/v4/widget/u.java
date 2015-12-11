// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package android.support.v4.widget:
//            DrawerLayout

public final class u extends android.view.ViewGroup.MarginLayoutParams
{

    public int a;
    float b;
    boolean c;
    boolean d;

    public u(int i, int j)
    {
        super(-1, -1);
        a = 0;
    }

    public u(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        context = context.obtainStyledAttributes(attributeset, DrawerLayout.c());
        a = context.getInt(0, 0);
        context.recycle();
    }

    public u(u u1)
    {
        super(u1);
        a = 0;
        a = u1.a;
    }

    public u(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 0;
    }

    public u(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        a = 0;
    }
}
