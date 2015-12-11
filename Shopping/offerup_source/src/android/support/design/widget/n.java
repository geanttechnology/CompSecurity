// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.util.AttributeSet;

public final class n extends android.widget.FrameLayout.LayoutParams
{

    int a;
    float b;

    public n(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        b = 0.5F;
        context = context.obtainStyledAttributes(attributeset, a.h);
        a = context.getInt(a.i, 0);
        b = context.getFloat(a.j, 0.5F);
        context.recycle();
    }

    public n(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 0;
        b = 0.5F;
    }

    public n(android.widget.FrameLayout.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 0;
        b = 0.5F;
    }
}
