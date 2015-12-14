// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

// Referenced classes of package com.livemixtapes:
//            App

public static class  extends StateListDrawable
{

    public float bottomLeftRadius;
    public float bottomRightRadius;
    public float radius;
    public float topLeftRadius;
    public float topRightRadius;

    private void scaleGradient(GradientDrawable gradientdrawable)
    {
    }

    protected boolean onStateChange(int ai[])
    {
        ai = Boolean.valueOf(super.onStateChange(ai));
        if (ai.booleanValue())
        {
            scale();
        }
        return ai.booleanValue();
    }

    public void scale()
    {
        android.graphics.drawable.Drawable drawable = getCurrent();
        if (drawable instanceof GradientDrawable)
        {
            scaleGradient((GradientDrawable)drawable);
        }
    }

    public ()
    {
    }
}
