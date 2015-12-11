// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.account;


public class FacebookAuthenticationRequest
{

    public final String facebookToken;
    public final String inid;

    private FacebookAuthenticationRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        inid = Builder.access._mth000(builder);
        facebookToken = Builder.access._mth100(builder);
    }

    FacebookAuthenticationRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
