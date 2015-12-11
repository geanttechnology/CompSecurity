// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import com.shazam.b.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            ConfigElements, AvailableUpdateDetails, UpgradeDetails

public class OrbitConfig
    implements Serializable
{
    public static class Builder
    {

        private AvailableUpdateDetails availableUpdateDetails;
        private ConfigElements configElements;
        private List orbitDialogs;
        private UpgradeDetails upgradeDetails;

        public static Builder anOrbitConfig()
        {
            return new Builder();
        }

        public OrbitConfig build()
        {
            return new OrbitConfig(this);
        }

        public Builder withAvailableUpdateDetails(AvailableUpdateDetails availableupdatedetails)
        {
            availableUpdateDetails = availableupdatedetails;
            return this;
        }

        public Builder withConfigElements(ConfigElements configelements)
        {
            configElements = configelements;
            return this;
        }

        public Builder withOrbitDialogs(List list)
        {
            orbitDialogs = list;
            return this;
        }

        public Builder withUpgradeDetails(UpgradeDetails upgradedetails)
        {
            upgradeDetails = upgradedetails;
            return this;
        }





        public Builder()
        {
        }
    }


    private AvailableUpdateDetails availableUpdateDetails;
    private ConfigElements configElements;
    private List orbitDialogs;
    private UpgradeDetails upgradeDetails;

    private OrbitConfig()
    {
    }

    private OrbitConfig(Builder builder)
    {
        configElements = builder.configElements;
        upgradeDetails = builder.upgradeDetails;
        orbitDialogs = builder.orbitDialogs;
        availableUpdateDetails = builder.availableUpdateDetails;
    }


    public AvailableUpdateDetails getAvailableUpdateDetails()
    {
        return availableUpdateDetails;
    }

    public boolean getBooleanConfigEntry(String s, boolean flag)
    {
        s = getStringConfigEntry(s);
        if (s != null)
        {
            flag = Boolean.parseBoolean(s);
        }
        return flag;
    }

    public ConfigElements getConfigElements()
    {
        if (configElements != null)
        {
            return configElements;
        } else
        {
            return ConfigElements.Builder.configElements().build();
        }
    }

    public Integer getIntegerConfigEntry(String s)
    {
        return getIntegerConfigEntry(s, null);
    }

    public Integer getIntegerConfigEntry(String s, Integer integer)
    {
        s = getStringConfigEntry(s);
        if (a.b(s))
        {
            integer = Integer.valueOf(Integer.parseInt(s));
        }
        return integer;
    }

    public List getOrbitDialogs()
    {
        if (orbitDialogs != null)
        {
            return orbitDialogs;
        } else
        {
            return new ArrayList();
        }
    }

    public String getStringConfigEntry(String s)
    {
        if (configElements == null)
        {
            return null;
        } else
        {
            return (String)configElements.getValues().get(s);
        }
    }

    public String getStringConfigEntry(String s, String s1)
    {
        s = getStringConfigEntry(s);
        if (a.b(s))
        {
            s1 = s;
        }
        return s1;
    }

    public UpgradeDetails getUpgradeDetails()
    {
        return upgradeDetails;
    }
}
