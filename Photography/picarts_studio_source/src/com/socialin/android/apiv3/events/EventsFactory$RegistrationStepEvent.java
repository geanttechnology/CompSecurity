// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        super("registration_step");
        addParam(EventParam.STEP, s);
        addParam(EventParam.PASSWORD, Boolean.valueOf(flag));
        addParam(EventParam.DISPLAY_NAME, Boolean.valueOf(flag1));
        addParam(EventParam.USERNAME, Boolean.valueOf(flag2));
        addParam(EventParam.EMAIL, Boolean.valueOf(flag3));
        addParam(EventParam.ABOUT, Boolean.valueOf(flag4));
    }
}
