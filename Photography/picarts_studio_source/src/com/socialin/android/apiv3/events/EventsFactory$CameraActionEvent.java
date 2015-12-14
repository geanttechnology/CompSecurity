// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setEffectName(String s)
    {
        addParam(EventParam.EFFECT_NAME, s);
        return this;
    }

    public addParam setMaskName(String s)
    {
        addParam(EventParam.MASK_NAME, s);
        return this;
    }

    public (String s, String s1)
    {
        super("camera_action");
        addParam(EventParam.SESSION_ID, s);
        addParam(EventParam.ACTION, s1);
    }
}
