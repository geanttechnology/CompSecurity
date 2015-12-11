// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advertising
    implements Serializable
{
    public static class Builder
    {

        private final List providers = new ArrayList();

        public static Builder advertising()
        {
            return new Builder();
        }

        public Advertising build()
        {
            return new Advertising(this, null);
        }

        public Builder withProviders(List list)
        {
            providers.clear();
            providers.addAll(list);
            return this;
        }


        public Builder()
        {
        }
    }


    private List providers;

    private Advertising()
    {
    }

    private Advertising(Builder builder)
    {
        providers = builder.providers;
    }

    Advertising(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getProviders()
    {
        if (providers != null)
        {
            return providers;
        } else
        {
            return Collections.emptyList();
        }
    }
}
