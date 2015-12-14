// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.idunnololz.widgets:
//            d

class c extends Animation
{

    private int a;
    private int b;
    private View c;
    private d d;

    private c(View view, int i, int j, d d1)
    {
        a = i;
        b = j - i;
        c = view;
        d = d1;
        c.getLayoutParams().height = i;
        c.requestLayout();
    }

    c(View view, int i, int j, d d1, AnimatedExpandableListView._cls1 _pcls1)
    {
        this(view, i, j, d1);
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        super.applyTransformation(f, transformation);
        if (f < 1.0F)
        {
            int i = a + (int)((float)b * f);
            c.getLayoutParams().height = i;
            d.d = i;
            c.requestLayout();
            return;
        } else
        {
            int j = a + b;
            c.getLayoutParams().height = j;
            d.d = j;
            c.requestLayout();
            return;
        }
    }
}
