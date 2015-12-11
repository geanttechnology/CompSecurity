// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class AmpHome
    implements Serializable
{

    private Float tooltippingPoint;

    public AmpHome()
    {
    }

    private AmpHome(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        tooltippingPoint = Builder.access._mth000(builder);
    }

    AmpHome(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Float getTooltippingPoint()
    {
        return tooltippingPoint;
    }
}
