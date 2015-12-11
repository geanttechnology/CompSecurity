// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package android.support.v7.widget:
//            av

public final class u extends av
{

    int a;
    int b;

    public u()
    {
        super(-2, -2);
        a = -1;
        b = 0;
    }

    public u(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        b = 0;
    }

    public u(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = -1;
        b = 0;
    }

    public u(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        a = -1;
        b = 0;
    }

    static int a(u u1)
    {
        return u1.a;
    }

    static int a(u u1, int i)
    {
        u1.b = i;
        return i;
    }

    static int b(u u1)
    {
        return u1.b;
    }

    static int b(u u1, int i)
    {
        u1.a = i;
        return i;
    }
}
