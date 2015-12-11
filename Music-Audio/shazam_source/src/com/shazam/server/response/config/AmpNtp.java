// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class AmpNtp
    implements Serializable
{
    public static class Builder
    {

        private List servers;

        public static Builder ampNtp()
        {
            return new Builder();
        }

        public AmpNtp build()
        {
            return new AmpNtp(this, null);
        }

        public Builder withServers(List list)
        {
            servers = list;
            return this;
        }


        public Builder()
        {
        }
    }


    private List servers;

    private AmpNtp()
    {
    }

    private AmpNtp(Builder builder)
    {
        servers = builder.servers;
    }

    AmpNtp(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getServers()
    {
        if (servers != null)
        {
            return servers;
        } else
        {
            return Collections.emptyList();
        }
    }
}
