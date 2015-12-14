// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.events;

import com.socialin.android.constants.EventParam;

public class addParam extends addParam
{

    public addParam addDestinatonSection(String s)
    {
        addParam(EventParam.DEST_SECTION, s);
        return this;
    }

    public addParam setDest(String s)
    {
        addParam(EventParam.DESTINATION, s);
        return this;
    }

    public addParam setType(String s)
    {
        addParam(EventParam.TYPE, s);
        return this;
    }

    public (long l, String s)
    {
        super("draw_export_video");
        addParam(EventParam.DURATION, Long.valueOf(l));
        addParam(EventParam.UID, s);
    }
}
