// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.auth;


public class EmailValidationRequest
{

    public final String inid;
    public final String vkey;

    private EmailValidationRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        inid = Builder.access._mth000(builder);
        vkey = Builder.access._mth100(builder);
    }

    EmailValidationRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
