// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (long l, long l1)
    {
        super("card_click_reposted_by");
        addParam(EventParam.USER_ID, Long.valueOf(l));
        addParam(EventParam.REPOSTED_BY_ID, Long.valueOf(l1));
    }
}
