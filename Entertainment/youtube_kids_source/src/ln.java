// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.util.AttributeSet;

public final class ln extends fw
{

    public int b;

    public ln(int i, int j)
    {
        super(-2, -2);
        b = 0;
        a = 0x800013;
    }

    public ln(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = 0;
    }

    public ln(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        b = 0;
    }

    public ln(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        b = 0;
        leftMargin = marginlayoutparams.leftMargin;
        topMargin = marginlayoutparams.topMargin;
        rightMargin = marginlayoutparams.rightMargin;
        bottomMargin = marginlayoutparams.bottomMargin;
    }

    public ln(fw fw1)
    {
        super(fw1);
        b = 0;
    }

    public ln(ln ln1)
    {
        super(ln1);
        b = 0;
        b = ln1.b;
    }
}
