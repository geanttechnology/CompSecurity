// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


public class ErrorBean
{

    private String code;
    private String message;
    private String reference;

    private ErrorBean()
    {
    }

    private ErrorBean(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        code = Builder.access._mth000(builder);
        message = Builder.access._mth100(builder);
        reference = Builder.access._mth200(builder);
    }

    ErrorBean(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getCode()
    {
        return code;
    }

    public String getMessage()
    {
        return message;
    }

    public String getReference()
    {
        return reference;
    }
}
