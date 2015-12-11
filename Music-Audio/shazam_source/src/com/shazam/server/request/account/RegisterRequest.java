// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.account;


public class RegisterRequest
{

    public final String inid;

    private RegisterRequest(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        inid = Builder.access._mth000(builder);
    }

    RegisterRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
