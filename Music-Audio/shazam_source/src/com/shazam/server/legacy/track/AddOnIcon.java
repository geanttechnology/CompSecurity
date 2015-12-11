// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


public class AddOnIcon
{

    private String encoding;
    private String focus;
    private String plain;
    private String type;
    private String version;

    private AddOnIcon()
    {
    }

    private AddOnIcon(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        encoding = Builder.access._mth000(builder);
        type = Builder.access._mth100(builder);
        version = Builder.access._mth200(builder);
        plain = Builder.access._mth300(builder);
        focus = Builder.access._mth400(builder);
    }

    AddOnIcon(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getEncoding()
    {
        return encoding;
    }

    public String getFocus()
    {
        return focus;
    }

    public String getPlain()
    {
        return plain;
    }

    public String getType()
    {
        return type;
    }

    public String getVersion()
    {
        return version;
    }
}
