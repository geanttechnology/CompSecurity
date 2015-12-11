// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AmpNcmPresence
    implements Serializable
{

    List ranges;

    private AmpNcmPresence()
    {
    }

    private AmpNcmPresence(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        ranges = Builder.access._mth000(builder);
    }

    AmpNcmPresence(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getRanges()
    {
        if (ranges != null)
        {
            return ranges;
        } else
        {
            return Collections.emptyList();
        }
    }
}
