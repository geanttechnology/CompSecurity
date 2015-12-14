// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam setDelay(double d)
    {
        addParam(EventParam.DELAY, Double.valueOf(d));
        return this;
    }

    public addParam setDest(String s)
    {
        addParam(EventParam.DESTINATION, s);
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

    public addParam setType(String s)
    {
        addParam(EventParam.TYPE, s);
        return this;
    }

    public (String s)
    {
        super("draw_export_gif");
        addParam(EventParam.UID, s);
    }
}
