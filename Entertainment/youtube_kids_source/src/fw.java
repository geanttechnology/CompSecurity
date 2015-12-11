// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class fw extends android.view.ViewGroup.MarginLayoutParams
{

    public int a;

    public fw(int i, int j)
    {
        super(i, j);
        a = 0;
        a = 0x800013;
    }

    public fw(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = 0;
        context = context.obtainStyledAttributes(attributeset, gl.b);
        a = context.getInt(0, 0);
        context.recycle();
    }

    public fw(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        a = 0;
    }

    public fw(fw fw1)
    {
        super(fw1);
        a = 0;
        a = fw1.a;
    }
}
