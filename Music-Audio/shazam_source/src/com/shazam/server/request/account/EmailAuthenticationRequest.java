// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.account;


public class EmailAuthenticationRequest
{

    public final String callback;
    public final String email;
    public final String inid;
    public final String locale;
    public final String userAgent;

    private EmailAuthenticationRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        inid = Builder.access._mth000(builder);
        email = Builder.access._mth100(builder);
        callback = Builder.access._mth200(builder);
        locale = Builder.access._mth300(builder);
        userAgent = Builder.access._mth400(builder);
    }

    EmailAuthenticationRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
