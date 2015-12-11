// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


public class CoverArt
{

    private String data;
    private String encoding;
    private String expiryDateTime;
    private String type;

    private CoverArt()
    {
    }

    private CoverArt(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        encoding = Builder.access._mth000(builder);
        expiryDateTime = Builder.access._mth100(builder);
        type = Builder.access._mth200(builder);
        data = Builder.access._mth300(builder);
    }

    CoverArt(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getData()
    {
        return data;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public String getExpiryDateTime()
    {
        return expiryDateTime;
    }

    public String getType()
    {
        return type;
    }
}
