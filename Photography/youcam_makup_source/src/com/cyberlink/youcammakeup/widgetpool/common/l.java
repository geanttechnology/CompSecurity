// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.cyberlink.youcammakeup.j;

public class l extends android.widget.FrameLayout.LayoutParams
{

    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public l(int i, int k, int i1, int j1, int k1, int l1, int i2)
    {
        this(i, k, i1, j1, false, false, k1, l1, i2);
    }

    public l(int i, int k, int i1, int j1, boolean flag, boolean flag1, int k1, 
            int l1, int i2)
    {
        super(k1, l1, i2);
        a = i;
        b = k;
        c = i1;
        d = j1;
        e = flag;
        f = flag1;
    }

    public l(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, j.ChildProportionLayoutArgs);
        a = typedarray.getInteger(6, -1);
        b = typedarray.getInteger(7, -1);
        c = typedarray.getInteger(4, -1);
        d = typedarray.getInteger(5, -1);
        typedarray.recycle();
        typedarray = context.obtainStyledAttributes(attributeset, j.ChildPosAndSizeLayoutArgs);
        if (a == -1)
        {
            a = typedarray.getInteger(2, -1);
        }
        if (b == -1)
        {
            b = typedarray.getInteger(3, -1);
        }
        if (c == -1)
        {
            c = typedarray.getInteger(0, -1);
        }
        if (d == -1)
        {
            d = typedarray.getInteger(1, -1);
        }
        typedarray.recycle();
        context = context.obtainStyledAttributes(attributeset, j.ChildProportionLayoutArgs);
        e = context.getBoolean(8, false);
        f = context.getBoolean(9, false);
        context.recycle();
    }

    public l(android.view.ViewGroup.LayoutParams layoutparams)
    {
        this(-1, -1, -1, -1, layoutparams.width, layoutparams.height, 51);
    }
}
