// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, int i, float f, String s1, boolean flag, int j, int k, 
            int l, int i1, long l1, String s2)
    {
        super("tool_crop_close");
        addParam(EventParam.UID, s);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.ANGLE, Float.valueOf(f));
        addParam(EventParam.ASPECT_RATIO, s1);
        addParam(EventParam.LOCKED, Boolean.valueOf(flag));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(j));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(k));
        addParam(EventParam.CROP_HEIGHT, Integer.valueOf(l));
        addParam(EventParam.CROP_WIDTH, Integer.valueOf(i1));
        addParam(EventParam.TIME_SPENT, Long.valueOf(l1));
        addParam(EventParam.METHOD, s2);
    }
}
