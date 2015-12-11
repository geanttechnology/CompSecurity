// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            Advertising, AmpApis, AmpNtp, AmpPlayWith, 
//            AmpProMode, AmpShare, AmpStyles, Charts, 
//            AmpNcm, AmpSettings, Stores, Wear

public class AmpConfig
    implements Serializable
{
    public static class Builder
    {

        private Advertising advertising;
        private AmpApis ampApis;
        private AmpNtp ampNtp;
        private AmpPlayWith ampPlayWith;
        private AmpProMode ampProMode;
        private AmpShare ampShare;
        private AmpStyles ampStyles;
        private Charts charts;
        private AmpNcm ncm;
        private AmpSettings settings;
        private Stores stores;
        private Wear wear;

        public static Builder ampConfig()
        {
            return new Builder();
        }

        public static Builder ampConfig(AmpConfig ampconfig)
        {
            Builder builder = ampConfig();
            builder.advertising = ampconfig.advertising;
            builder.settings = ampconfig.settings;
            builder.ampShare = ampconfig.ampShare;
            builder.ampPlayWith = ampconfig.ampPlayWith;
            builder.ampNtp = ampconfig.ampNtp;
            builder.ncm = ampconfig.ncm;
            builder.stores = ampconfig.stores;
            builder.charts = ampconfig.charts;
            builder.wear = ampconfig.wear;
            builder.ampApis = ampconfig.ampApis;
            builder.ampStyles = ampconfig.ampStyles;
            builder.ampProMode = ampconfig.ampProMode;
            return builder;
        }

        public AmpConfig build()
        {
            return new AmpConfig(this);
        }

        public Builder withAdvertising(Advertising advertising1)
        {
            advertising = advertising1;
            return this;
        }

        public Builder withAmpApis(AmpApis ampapis)
        {
            ampApis = ampapis;
            return this;
        }

        public Builder withAmpProMode(AmpProMode amppromode)
        {
            ampProMode = amppromode;
            return this;
        }

        public Builder withAmpShare(AmpShare ampshare)
        {
            ampShare = ampshare;
            return this;
        }

        public Builder withAmpStyles(AmpStyles ampstyles)
        {
            ampStyles = ampstyles;
            return this;
        }

        public Builder withCharts(Charts charts1)
        {
            charts = charts1;
            return this;
        }

        public Builder withNcm(AmpNcm ampncm)
        {
            ncm = ampncm;
            return this;
        }

        public Builder withNtp(AmpNtp ampntp)
        {
            ampNtp = ampntp;
            return this;
        }

        public Builder withPlayWith(AmpPlayWith ampplaywith)
        {
            ampPlayWith = ampplaywith;
            return this;
        }

        public Builder withSettings(AmpSettings ampsettings)
        {
            settings = ampsettings;
            return this;
        }

        public Builder withStores(Stores stores1)
        {
            stores = stores1;
            return this;
        }

        public Builder withWear(Wear wear1)
        {
            wear = wear1;
            return this;
        }













        public Builder()
        {
        }
    }


    private Advertising advertising;
    private AmpApis ampApis;
    private AmpNtp ampNtp;
    private AmpPlayWith ampPlayWith;
    private AmpProMode ampProMode;
    private AmpShare ampShare;
    private AmpStyles ampStyles;
    private Charts charts;
    private AmpNcm ncm;
    private AmpSettings settings;
    private Stores stores;
    private Wear wear;

    private AmpConfig()
    {
    }

    public AmpConfig(Builder builder)
    {
        advertising = builder.advertising;
        settings = builder.settings;
        ampShare = builder.ampShare;
        ampPlayWith = builder.ampPlayWith;
        ampNtp = builder.ampNtp;
        ncm = builder.ncm;
        stores = builder.stores;
        charts = builder.charts;
        wear = builder.wear;
        ampApis = builder.ampApis;
        ampStyles = builder.ampStyles;
        ampProMode = builder.ampProMode;
    }

    public Advertising getAdvertising()
    {
        if (advertising != null)
        {
            return advertising;
        } else
        {
            return Advertising.Builder.advertising().build();
        }
    }

    public AmpApis getAmpApis()
    {
        if (ampApis != null)
        {
            return ampApis;
        } else
        {
            return AmpApis.Builder.ampApis().build();
        }
    }

    public AmpNtp getAmpNtp()
    {
        if (ampNtp != null)
        {
            return ampNtp;
        } else
        {
            return AmpNtp.Builder.ampNtp().build();
        }
    }

    public AmpPlayWith getAmpPlayWith()
    {
        if (ampPlayWith != null)
        {
            return ampPlayWith;
        } else
        {
            return AmpPlayWith.Builder.ampPlayWith().build();
        }
    }

    public AmpProMode getAmpProMode()
    {
        if (ampProMode != null)
        {
            return ampProMode;
        } else
        {
            return AmpProMode.Builder.ampProMode().build();
        }
    }

    public AmpShare getAmpShare()
    {
        if (ampShare != null)
        {
            return ampShare;
        } else
        {
            return AmpShare.Builder.ampShare().build();
        }
    }

    public AmpStyles getAmpStyles()
    {
        if (ampStyles != null)
        {
            return ampStyles;
        } else
        {
            return AmpStyles.Builder.ampStyles().build();
        }
    }

    public Charts getCharts()
    {
        if (charts != null)
        {
            return charts;
        } else
        {
            return Charts.Builder.charts().build();
        }
    }

    public AmpNcm getNcm()
    {
        if (ncm != null)
        {
            return ncm;
        } else
        {
            return AmpNcm.Builder.ampNcm().build();
        }
    }

    public AmpSettings getSettings()
    {
        if (settings != null)
        {
            return settings;
        } else
        {
            return AmpSettings.Builder.ampSettings().build();
        }
    }

    public Stores getStores()
    {
        if (stores != null)
        {
            return stores;
        } else
        {
            return Stores.Builder.stores().build();
        }
    }

    public Wear getWear()
    {
        if (wear != null)
        {
            return wear;
        } else
        {
            return Wear.Builder.wear().build();
        }
    }

    public boolean isEmpty()
    {
        return advertising == null && settings == null && ampShare == null && ampPlayWith == null && ampNtp == null && ncm == null && stores == null && charts == null && wear == null && ampApis == null && ampStyles == null && ampProMode == null;
    }












}
