// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.IntensityNativeFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;

public class BorderFilter extends IntensityNativeFilter
{

    private double mFrameDefaultSize;

    BorderFilter()
    {
        super("imageborders");
    }

    public double getSize()
    {
        return ((Double)mActions.get(0).getValue("bordersize", Double.valueOf(0.0D))).doubleValue();
    }

    public void setHiRes(boolean flag)
    {
        mActions.get(0).setValue("large", flag);
    }

    public void setIdentifier(CharSequence charsequence)
    {
        mActions.get(0).setValue("bordername", charsequence);
    }

    public void setIntensity(double d)
    {
        super.setIntensity(d);
        if (mFrameDefaultSize > 0.0D)
        {
            mActions.get(0).setValue("bordersize", mFrameDefaultSize * d);
        }
    }

    public void setSize(double d)
    {
        mFrameDefaultSize = d;
        mActions.get(0).setValue("bordersize", d);
    }

    public void setSourceDir(CharSequence charsequence)
    {
        mActions.get(0).setValue("source", charsequence);
    }
}
