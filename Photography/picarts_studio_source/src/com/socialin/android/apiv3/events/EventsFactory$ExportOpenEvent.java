// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, boolean flag, boolean flag1)
    {
        super("export_open");
        addParam(EventParam.SOURCE, s);
        addParam(EventParam.OWNER, Boolean.valueOf(flag));
        addParam(EventParam.FREE_TO_EDIT, Boolean.valueOf(flag1));
    }
}
