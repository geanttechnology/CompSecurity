// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;

public class EdgeEffectCompat
{

    private static final EdgeEffectImpl IMPL;
    private Object mEdgeEffect;

    public EdgeEffectCompat(Context context)
    {
        mEdgeEffect = IMPL.newEdgeEffect(context);
    }

    public boolean draw(Canvas canvas)
    {
        return IMPL.draw(mEdgeEffect, canvas);
    }

    public void finish()
    {
        IMPL.finish(mEdgeEffect);
    }

    public boolean isFinished()
    {
        return IMPL.isFinished(mEdgeEffect);
    }

    public boolean onAbsorb(int i)
    {
        return IMPL.onAbsorb(mEdgeEffect, i);
    }

    public boolean onPull(float f)
    {
        return IMPL.onPull(mEdgeEffect, f);
    }

    public boolean onPull(float f, float f1)
    {
        return IMPL.onPull(mEdgeEffect, f, f1);
    }

    public boolean onRelease()
    {
        return IMPL.onRelease(mEdgeEffect);
    }

    public void setSize(int i, int j)
    {
        IMPL.setSize(mEdgeEffect, i, j);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            IMPL = new EdgeEffectLollipopImpl();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            IMPL = new EdgeEffectIcsImpl();
        } else
        {
            IMPL = new BaseEdgeEffectImpl();
        }
    }

    /* member class not found */
    class EdgeEffectImpl {}


    /* member class not found */
    class EdgeEffectLollipopImpl {}


    /* member class not found */
    class EdgeEffectIcsImpl {}


    /* member class not found */
    class BaseEdgeEffectImpl {}

}
