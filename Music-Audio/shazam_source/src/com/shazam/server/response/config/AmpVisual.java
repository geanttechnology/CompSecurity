// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AmpVisual
    implements Serializable
{

    private List barText;

    public AmpVisual()
    {
    }

    private AmpVisual(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        barText = Builder.access._mth000(builder);
    }

    AmpVisual(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getBarText()
    {
        if (barText != null)
        {
            return barText;
        } else
        {
            return Collections.emptyList();
        }
    }
}
