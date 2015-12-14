// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import ab;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class h extends android.view.LayoutParams
{

    public float g;
    public int h;

    public (int i, int j)
    {
        super(i, j);
        h = -1;
        g = 0.0F;
    }

    public g(int i, int j, float f)
    {
        super(i, j);
        h = -1;
        g = f;
    }

    public g(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h = -1;
        context = context.obtainStyledAttributes(attributeset, ab.LinearLayoutCompat_Layout);
        g = context.getFloat(ab.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
        h = context.getInt(ab.LinearLayoutCompat_Layout_android_layout_gravity, -1);
        context.recycle();
    }

    public h(android.view.LayoutParams layoutparams)
    {
        super(layoutparams);
        h = -1;
    }
}
