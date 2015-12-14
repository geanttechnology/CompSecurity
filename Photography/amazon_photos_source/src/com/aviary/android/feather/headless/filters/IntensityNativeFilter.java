// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeFilter

public abstract class IntensityNativeFilter extends NativeFilter
{

    public IntensityNativeFilter(String s)
    {
        super(s);
    }

    public double getIntensity()
    {
        return ((Double)mActions.get(0).getValue("intensity", Double.valueOf(1.0D))).doubleValue();
    }

    public void setIntensity(double d)
    {
        mActions.get(0).setValue("intensity", d);
    }
}
