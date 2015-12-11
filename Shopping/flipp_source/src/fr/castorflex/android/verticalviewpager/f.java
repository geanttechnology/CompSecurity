// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.verticalviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package fr.castorflex.android.verticalviewpager:
//            VerticalViewPager

public final class f extends android.view.ViewGroup.LayoutParams
{

    public boolean a;
    public int b;
    float c;
    boolean d;
    int e;
    int f;

    public f()
    {
        super(-1, -1);
        c = 0.0F;
    }

    public f(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.0F;
        context = context.obtainStyledAttributes(attributeset, VerticalViewPager.c());
        b = context.getInteger(0, 48);
        context.recycle();
    }
}
