// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public I(String s, String s1, String s2, String s3, int i, int j, int k, 
            boolean flag)
    {
        super("tilt_shift_close");
        addParam(EventParam.UID, s);
        addParam(EventParam.METHOD, s1);
        addParam(EventParam.TYPE, s2);
        addParam(EventParam.BLUR_SLIDER_VALUE, s3);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(j));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(k));
        addParam(EventParam.INVERSE_SELECTED, Boolean.valueOf(flag));
    }
}
