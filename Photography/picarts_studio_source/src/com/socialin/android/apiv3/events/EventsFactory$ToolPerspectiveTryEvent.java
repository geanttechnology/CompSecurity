// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, String s1, int i, float f, float f1, int j, int k)
    {
        super("tool_perspective_try");
        addParam(EventParam.UID, s);
        addParam(EventParam.ACTION, s1);
        addParam(EventParam.ACTION_COUNT, Integer.valueOf(i));
        addParam(EventParam.ANGLE_VERTICAL, Float.valueOf(f));
        addParam(EventParam.ANGLE_HORIZONTAL, Float.valueOf(f1));
        addParam(EventParam.SOURCE_HEIGHT, Integer.valueOf(k));
        addParam(EventParam.SOURCE_WIDTH, Integer.valueOf(j));
    }
}
