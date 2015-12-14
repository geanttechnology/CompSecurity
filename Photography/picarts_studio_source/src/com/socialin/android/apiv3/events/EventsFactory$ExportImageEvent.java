// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setDestSection(String s)
    {
        addParam(EventParam.DEST_SECTION, s);
        return this;
    }

    public addParam setFreeToEdit(boolean flag)
    {
        addParam(EventParam.FREE_TO_EDIT, Boolean.valueOf(flag));
        return this;
    }

    public addParam setOwner(boolean flag)
    {
        addParam(EventParam.OWNER, Boolean.valueOf(flag));
        return this;
    }

    public addParam setPicsArtPlus(boolean flag)
    {
        addParam(EventParam.PICSART_PLUS, Boolean.valueOf(flag));
        return this;
    }

    public (String s, String s1)
    {
        super("export_img");
        addParam(EventParam.DESTINATION, s);
        addParam(EventParam.TYPE, s1);
    }
}
