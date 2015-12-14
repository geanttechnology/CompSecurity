// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, int i, int j, long l)
    {
        super("effect_try");
        addParam(EventParam.EFFECT_NAME, s);
        addParam(EventParam.WIDTH, Integer.valueOf(i));
        addParam(EventParam.HEIGHT, Integer.valueOf(j));
        addParam(EventParam.PROCESSING_TIME, Long.valueOf(l));
    }
}
