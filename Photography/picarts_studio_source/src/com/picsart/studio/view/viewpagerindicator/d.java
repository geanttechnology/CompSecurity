// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.content.Context;
import android.widget.TextView;

// Referenced classes of package com.picsart.studio.view.viewpagerindicator:
//            TabPageIndicator

final class d extends TextView
{

    int a;
    private TabPageIndicator b;

    public d(TabPageIndicator tabpageindicator, Context context)
    {
        b = tabpageindicator;
        super(context, null, 0x7f01015f);
    }

    static int a(d d1, int i)
    {
        d1.a = i;
        return i;
    }

    public final void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (TabPageIndicator.c(b) > 0 && getMeasuredWidth() > TabPageIndicator.c(b))
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(TabPageIndicator.c(b), 0x40000000), j);
        }
    }
}
