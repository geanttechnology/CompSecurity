// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class LayoutConfiguration
{

    private boolean debugDraw;
    private int gravity;
    private int layoutDirection;
    private int orientation;
    private float weightDefault;

    public LayoutConfiguration(Context context, AttributeSet attributeset)
    {
        orientation = 0;
        debugDraw = false;
        weightDefault = 0.0F;
        gravity = 51;
        layoutDirection = 0;
        context = context.obtainStyledAttributes(attributeset, R.styleable.FlowLayout);
        setOrientation(context.getInteger(R.styleable.FlowLayout_android_orientation, 0));
        setDebugDraw(context.getBoolean(R.styleable.FlowLayout_debugDraw, false));
        setWeightDefault(context.getFloat(R.styleable.FlowLayout_weightDefault, 0.0F));
        setGravity(context.getInteger(R.styleable.FlowLayout_android_gravity, 0));
        setLayoutDirection(context.getInteger(R.styleable.FlowLayout_layoutDirection, 0));
        context.recycle();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public int getGravity()
    {
        return gravity;
    }

    public int getLayoutDirection()
    {
        return layoutDirection;
    }

    public int getOrientation()
    {
        return orientation;
    }

    public float getWeightDefault()
    {
        return weightDefault;
    }

    public boolean isDebugDraw()
    {
        return debugDraw;
    }

    public void setDebugDraw(boolean flag)
    {
        debugDraw = flag;
    }

    public void setGravity(int i)
    {
        int j = i;
        if ((i & 7) == 0)
        {
            j = i | 3;
        }
        i = j;
        if ((j & 0x70) == 0)
        {
            i = j | 0x30;
        }
        gravity = i;
    }

    public void setLayoutDirection(int i)
    {
        if (i == 1)
        {
            layoutDirection = i;
            return;
        } else
        {
            layoutDirection = 0;
            return;
        }
    }

    public void setOrientation(int i)
    {
        if (i == 1)
        {
            orientation = i;
            return;
        } else
        {
            orientation = 0;
            return;
        }
    }

    public void setWeightDefault(float f)
    {
        weightDefault = Math.max(0.0F, f);
    }
}
