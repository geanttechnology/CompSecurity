// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public final class g extends android.widget.LinearLayout.LayoutParams
{

    int a;
    Interpolator b;

    public g(int i, int j)
    {
        super(-1, -2);
        a = 1;
    }

    public g(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 1;
        attributeset = context.obtainStyledAttributes(attributeset, a.b);
        a = attributeset.getInt(a.c, 0);
        if (attributeset.hasValue(a.d))
        {
            b = AnimationUtils.loadInterpolator(context, attributeset.getResourceId(a.d, 0));
        }
        attributeset.recycle();
    }

    public g(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 1;
    }

    public g(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        a = 1;
    }

    public g(android.widget.LinearLayout.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 1;
    }
}
