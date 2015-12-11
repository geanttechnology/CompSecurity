// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

// Referenced classes of package android.support.v7.widget:
//            bi

public class av extends android.view.ViewGroup.MarginLayoutParams
{

    bi c;
    final Rect d;
    boolean e;
    boolean f;

    public av(int i, int j)
    {
        super(i, j);
        d = new Rect();
        e = true;
        f = false;
    }

    public av(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = new Rect();
        e = true;
        f = false;
    }

    public av(av av1)
    {
        super(av1);
        d = new Rect();
        e = true;
        f = false;
    }

    public av(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        d = new Rect();
        e = true;
        f = false;
    }

    public av(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        d = new Rect();
        e = true;
        f = false;
    }
}
