// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import rf;

public class SAutoBgFrameLayout extends FrameLayout
{

    public SAutoBgFrameLayout(Context context)
    {
        super(context);
    }

    public SAutoBgFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SAutoBgFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        super.setBackgroundDrawable(new rf(this, drawable));
    }
}
