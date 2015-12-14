// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setBlurSliderValue(int i)
    {
        addParam(EventParam.BLUR_SLIDER_VALUE, Integer.valueOf(i));
        return this;
    }

    public (String s, String s1, int i, int j, int k, boolean flag)
    {
        super("tilt_shift_try");
        addParam(EventParam.UID, s);
        addParam(EventParam.ACTION, s1);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(j));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(k));
        addParam(EventParam.CONTROLS_VISIBLE, Boolean.valueOf(flag));
    }
}
