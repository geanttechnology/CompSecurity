// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public final class cvd extends android.widget.FrameLayout.LayoutParams
{

    public cvd(int i, int j)
    {
        super(i, j);
    }

    public cvd(int i, int j, boolean flag)
    {
        super(i, j);
    }

    public cvd(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, crv.a);
        context.getBoolean(0, false);
        context.recycle();
    }

    public cvd(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
    }
}
