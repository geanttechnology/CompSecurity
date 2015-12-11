// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            AmpNcmPresence

public class AmpNcm
    implements Serializable
{
    public static class Builder
    {

        private AmpNcmPresence presence;

        public static Builder ampNcm()
        {
            return new Builder();
        }

        public AmpNcm build()
        {
            return new AmpNcm(this, null);
        }

        public Builder withPresence(AmpNcmPresence ampncmpresence)
        {
            presence = ampncmpresence;
            return this;
        }


        public Builder()
        {
        }
    }


    private AmpNcmPresence presence;

    private AmpNcm()
    {
    }

    private AmpNcm(Builder builder)
    {
        presence = builder.presence;
    }

    AmpNcm(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public AmpNcmPresence getPresence()
    {
        if (presence != null)
        {
            return presence;
        } else
        {
            return AmpNcmPresence.Builder.ampNcmPresence().build();
        }
    }
}
