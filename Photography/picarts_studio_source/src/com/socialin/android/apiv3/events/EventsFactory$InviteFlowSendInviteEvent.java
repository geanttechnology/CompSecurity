// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, String s1, int i)
    {
        super("invite_flow_send_invite");
        addParam(EventParam.TYPE, s1);
        addParam(EventParam.COUNT, Integer.valueOf(i));
        addParam(EventParam.CAMPAIGN, s);
    }
}
