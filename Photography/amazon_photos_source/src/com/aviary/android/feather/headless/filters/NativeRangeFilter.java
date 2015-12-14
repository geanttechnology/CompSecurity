// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaFloatParameter;

// Referenced classes of package com.aviary.android.feather.headless.filters:
//            NativeFilter, INativeRangeFilter

public class NativeRangeFilter extends NativeFilter
    implements INativeRangeFilter
{

    protected MoaFloatParameter defaultParam;
    protected String mKey;

    public NativeRangeFilter(String s, String s1)
    {
        super(s);
        defaultParam = new MoaFloatParameter(0.0F);
        mKey = s1;
    }

    public MoaFloatParameter getValue()
    {
        return (MoaFloatParameter)mActions.get(0).getValue(mKey, defaultParam);
    }

    public void setValue(Float float1)
    {
        mActions.get(0).setValue(mKey, new MoaFloatParameter(float1.floatValue()));
    }
}
