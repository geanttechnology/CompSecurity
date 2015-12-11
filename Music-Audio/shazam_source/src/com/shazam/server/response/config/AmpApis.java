// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            AmpAccount, AmpBeacon, AmpSearch, AmpSocial, 
//            AmpTagCount

public class AmpApis
    implements Serializable
{
    public static class Builder
    {

        private AmpAccount ampAccount;
        private AmpBeacon ampBeacon;
        private AmpSearch ampSearch;
        private AmpSocial ampSocial;
        private AmpTagCount ampTagCount;

        public static Builder ampApis()
        {
            return new Builder();
        }

        public AmpApis build()
        {
            return new AmpApis(this, null);
        }

        public Builder withAmpAccount(AmpAccount ampaccount)
        {
            ampAccount = ampaccount;
            return this;
        }

        public Builder withAmpBeacon(AmpBeacon ampbeacon)
        {
            ampBeacon = ampbeacon;
            return this;
        }

        public Builder withAmpSearch(AmpSearch ampsearch)
        {
            ampSearch = ampsearch;
            return this;
        }

        public Builder withAmpSocial(AmpSocial ampsocial)
        {
            ampSocial = ampsocial;
            return this;
        }

        public Builder withAmpTagCount(AmpTagCount amptagcount)
        {
            ampTagCount = amptagcount;
            return this;
        }






        public Builder()
        {
        }
    }


    private AmpAccount ampAccount;
    private AmpBeacon ampBeacon;
    private AmpSearch ampSearch;
    private AmpSocial ampSocial;
    private AmpTagCount ampTagCount;

    private AmpApis()
    {
    }

    private AmpApis(Builder builder)
    {
        ampAccount = builder.ampAccount;
        ampBeacon = builder.ampBeacon;
        ampSocial = builder.ampSocial;
        ampTagCount = builder.ampTagCount;
        ampSearch = builder.ampSearch;
    }

    AmpApis(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public AmpAccount getAmpAccount()
    {
        if (ampAccount != null)
        {
            return ampAccount;
        } else
        {
            return AmpAccount.Builder.ampAccount().build();
        }
    }

    public AmpBeacon getAmpBeacon()
    {
        if (ampBeacon != null)
        {
            return ampBeacon;
        } else
        {
            return AmpBeacon.Builder.ampBeacon().build();
        }
    }

    public AmpSearch getAmpSearch()
    {
        if (ampSearch != null)
        {
            return ampSearch;
        } else
        {
            return AmpSearch.Builder.ampSearch().build();
        }
    }

    public AmpTagCount getAmpTagCount()
    {
        if (ampTagCount != null)
        {
            return ampTagCount;
        } else
        {
            return AmpTagCount.Builder.ampTagCount().build();
        }
    }

    public AmpSocial getSocial()
    {
        if (ampSocial != null)
        {
            return ampSocial;
        } else
        {
            return AmpSocial.Builder.ampSocial().build();
        }
    }
}
