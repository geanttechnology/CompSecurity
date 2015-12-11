// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AmpShare
    implements Serializable
{
    public static class Builder
    {

        private List options;

        public static Builder ampShare()
        {
            return new Builder();
        }

        public AmpShare build()
        {
            return new AmpShare(this, null);
        }

        public Builder withOptions(List list)
        {
            options = list;
            return this;
        }


        public Builder()
        {
        }
    }


    private List options;

    private AmpShare()
    {
    }

    private AmpShare(Builder builder)
    {
        options = builder.options;
    }

    AmpShare(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getOptions()
    {
        if (options != null)
        {
            return options;
        } else
        {
            return Collections.emptyList();
        }
    }
}
