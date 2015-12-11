// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.server.response.config.Provider;

public class AvailableProviders
{

    public final Provider adColony;
    public final Provider facebook;
    public final Provider primary;

    private AvailableProviders(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        primary = Builder.a(builder);
        facebook = Builder.b(builder);
        adColony = Builder.c(builder);
    }

    public AvailableProviders(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
