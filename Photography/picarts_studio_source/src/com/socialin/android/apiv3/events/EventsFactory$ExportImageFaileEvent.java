// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setPicsArtPlus(boolean flag)
    {
        addParam(EventParam.PICSART_PLUS, Boolean.valueOf(flag));
        return this;
    }

    public (String s, String s1)
    {
        super("export_img_fail");
        addParam(EventParam.DESTINATION, s);
        addParam(EventParam.TYPE, s1);
    }
}
