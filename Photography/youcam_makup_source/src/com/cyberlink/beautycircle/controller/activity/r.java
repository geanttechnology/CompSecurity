// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            q

public class r extends Animation
{

    final q a;
    private int b;
    private int c;
    private View d;

    public r(q q, View view, int i)
    {
        a = q;
        super();
        d = view;
        b = i;
        c = view.getWidth();
    }

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i = c;
        int j = (int)((float)(b - c) * f);
        d.getLayoutParams().width = i + j;
        d.requestLayout();
    }

    public void initialize(int i, int j, int k, int l)
    {
        super.initialize(i, j, k, l);
    }

    public boolean willChangeBounds()
    {
        return true;
    }
}
