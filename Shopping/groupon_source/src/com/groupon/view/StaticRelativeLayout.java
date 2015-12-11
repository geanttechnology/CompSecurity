// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

public class StaticRelativeLayout extends RelativeLayout
{

    private android.view.ViewTreeObserver.OnPreDrawListener preDrawListener;
    private float yFraction;

    public StaticRelativeLayout(Context context)
    {
        this(context, null);
    }

    public StaticRelativeLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public StaticRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        yFraction = 0.0F;
        preDrawListener = null;
    }

    public float getYFraction()
    {
        return yFraction;
    }

    public void setYFraction(float f)
    {
        yFraction = f;
        if (getHeight() == 0)
        {
            if (preDrawListener == null)
            {
                preDrawListener = new android.view.ViewTreeObserver.OnPreDrawListener() {

                    final StaticRelativeLayout this$0;

                    public boolean onPreDraw()
                    {
                        getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                        setYFraction(yFraction);
                        return true;
                    }

            
            {
                this$0 = StaticRelativeLayout.this;
                super();
            }
                };
                getViewTreeObserver().addOnPreDrawListener(preDrawListener);
            }
            return;
        } else
        {
            setTranslationY((float)getHeight() * f);
            return;
        }
    }


}
