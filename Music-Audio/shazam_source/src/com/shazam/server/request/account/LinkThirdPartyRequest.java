// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.account;


public class LinkThirdPartyRequest
{

    public final String token;
    public final String type;

    private LinkThirdPartyRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        token = Builder.access._mth100(builder);
        type = Builder.access._mth200(builder);
    }

    LinkThirdPartyRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
