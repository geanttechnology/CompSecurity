// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

public class MyBBYCertView extends FrameLayout
    implements android.view.animation.Animation.AnimationListener
{

    private View a;
    private View b;
    private Context c;
    private Animation d;
    private Animation e;
    private boolean f;

    public MyBBYCertView(Context context)
    {
        super(context);
        f = true;
        c = context;
    }

    public MyBBYCertView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = true;
    }

    public MyBBYCertView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        f = true;
    }

    public void onAnimationEnd(Animation animation)
    {
        if (animation == d)
        {
            removeAllViews();
            if (f)
            {
                addView(b);
            } else
            {
                addView(a);
            }
            clearAnimation();
            setAnimation(e);
            startAnimation(e);
            return;
        }
        boolean flag;
        if (!f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    public void setViews(View view, View view1)
    {
        a = view;
        b = view1;
        addView(view);
        d = AnimationUtils.loadAnimation(c, 0x7f04000f);
        d.setAnimationListener(this);
        e = AnimationUtils.loadAnimation(c, 0x7f040004);
        e.setAnimationListener(this);
    }
}
