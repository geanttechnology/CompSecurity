// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class kw extends android.view.ViewGroup.MarginLayoutParams
{

    public float g;
    public int h;

    public kw(int i, int j)
    {
        super(i, j);
        h = -1;
        g = 0.0F;
    }

    public kw(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h = -1;
        context = context.obtainStyledAttributes(attributeset, gl.h);
        g = context.getFloat(3, 0.0F);
        h = context.getInt(0, -1);
        context.recycle();
    }

    public kw(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        h = -1;
    }
}
