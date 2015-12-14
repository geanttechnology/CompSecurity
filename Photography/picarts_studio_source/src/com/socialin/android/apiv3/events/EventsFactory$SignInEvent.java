// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setErrMessage(String s)
    {
        addParam(EventParam.ERR, s);
        return this;
    }

    public A(String s, boolean flag, boolean flag1)
    {
        super("signin");
        addParam(EventParam.PROVIDER, s);
        addParam(EventParam.SUCCESS, Boolean.valueOf(flag));
        addParam(EventParam.CREATE, Boolean.valueOf(flag1));
    }
}
