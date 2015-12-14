// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, String s1, boolean flag)
    {
        super("contest_submit");
        addParam(EventParam.CONTEST_NAME, s);
        addParam(EventParam.ORIGIN, s1);
        addParam(EventParam.HASHTAG_SUBMISSION, Boolean.valueOf(flag));
    }
}
