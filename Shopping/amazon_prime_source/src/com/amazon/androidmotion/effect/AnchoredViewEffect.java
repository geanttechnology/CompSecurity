// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.androidmotion.effect;

import android.animation.TimeInterpolator;
import android.view.View;

// Referenced classes of package com.amazon.androidmotion.effect:
//            AnchoredEffect

public abstract class AnchoredViewEffect extends AnchoredEffect
{

    private int mControlPointX;
    private int mControlPointY;
    private boolean mUseSpecifiedControlPoint;
    private final View mView;

    public AnchoredViewEffect(View view, int i, int j, float f, float f1)
    {
        super(i, j, f, f1);
        mUseSpecifiedControlPoint = false;
        mView = view;
    }

    public AnchoredViewEffect(View view, int i, int j, int k, int l, float f, float f1)
    {
        this(view, k, l, f, f1);
        setControlPoint(i, j);
    }

    public int getControlPointX()
    {
        if (mUseSpecifiedControlPoint)
        {
            return mControlPointX;
        } else
        {
            return Math.round(mView.getPivotX());
        }
    }

    public int getControlPointY()
    {
        if (mUseSpecifiedControlPoint)
        {
            return mControlPointY;
        } else
        {
            return Math.round(mView.getPivotY());
        }
    }

    protected void getCurrentScreenPosition(int ai[])
    {
        mView.getLocationOnScreen(ai);
        ai[0] = ai[0] + getControlPointX();
        ai[1] = ai[1] + getControlPointY();
    }

    public abstract TimeInterpolator getInterpolator();

    public View getView()
    {
        return mView;
    }

    public void setControlPoint(int i, int j)
    {
        mControlPointX = i;
        mControlPointY = j;
        mUseSpecifiedControlPoint = true;
    }

    public abstract void update(float f);
}
