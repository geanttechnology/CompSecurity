// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            AmpHome, AmpOnboarding, AmpVisual

public class AmpStyles
    implements Serializable
{
    public static class Builder
    {

        private AmpHome ampHome;
        private AmpOnboarding ampOnboarding;
        private AmpVisual ampVisual;
        private String caption;

        public static Builder ampStyles()
        {
            return new Builder();
        }

        public AmpStyles build()
        {
            return new AmpStyles(this, null);
        }

        public Builder withAmpHome(AmpHome amphome)
        {
            ampHome = amphome;
            return this;
        }

        public Builder withAmpOnboarding(AmpOnboarding amponboarding)
        {
            ampOnboarding = amponboarding;
            return this;
        }

        public Builder withAmpVisual(AmpVisual ampvisual)
        {
            ampVisual = ampvisual;
            return this;
        }

        public Builder withCaption(String s)
        {
            caption = s;
            return this;
        }





        public Builder()
        {
        }
    }


    private AmpHome ampHome;
    private AmpOnboarding ampOnboarding;
    private AmpVisual ampVisual;
    private String caption;

    public AmpStyles()
    {
    }

    private AmpStyles(Builder builder)
    {
        ampOnboarding = builder.ampOnboarding;
        ampHome = builder.ampHome;
        ampVisual = builder.ampVisual;
        caption = builder.caption;
    }

    AmpStyles(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public AmpHome getAmpHome()
    {
        if (ampHome != null)
        {
            return ampHome;
        } else
        {
            return AmpHome.Builder.ampHome().build();
        }
    }

    public AmpOnboarding getAmpOnboarding()
    {
        if (ampOnboarding != null)
        {
            return ampOnboarding;
        } else
        {
            return AmpOnboarding.Builder.ampOnboarding().build();
        }
    }

    public AmpVisual getAmpVisual()
    {
        if (ampVisual != null)
        {
            return ampVisual;
        } else
        {
            return AmpVisual.Builder.ampVisual().build();
        }
    }

    public String getCaption()
    {
        return caption;
    }
}
