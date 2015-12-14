// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public (String s, String s1, int i)
    {
        super("tool_stretch_close");
        addParam(EventParam.UID, s);
        addParam(EventParam.METHOD, s1);
        addParam(EventParam.TIME_SPENT, Integer.valueOf(i));
    }
}
