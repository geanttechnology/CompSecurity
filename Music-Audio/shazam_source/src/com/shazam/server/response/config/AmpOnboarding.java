// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class AmpOnboarding
    implements Serializable
{

    private String emailRegistration;

    public AmpOnboarding()
    {
    }

    private AmpOnboarding(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        emailRegistration = Builder.access._mth000(builder);
    }

    AmpOnboarding(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getEmailRegistration()
    {
        return emailRegistration;
    }
}
