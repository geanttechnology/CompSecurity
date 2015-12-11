// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow;

import android.content.pm.ApplicationInfo;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.config.CALConfiguration;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.config.DeveloperConfiguration;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playnow.config.DenverStagingConfiguration;
import com.xfinity.playnow.config.MrQaConfiguration;
import com.xfinity.playnow.config.ProductionConfiguration;
import com.xfinity.playnow.config.SprintQaConfiguration;
import com.xfinity.playnow.config.StagingConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playnow:
//            PlayNowAppUpgradHelper

public class PlayNowContainer extends PlayerContainer
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playnow/PlayNowContainer);
    private static String configVersion = "";
    private PlayerConfiguration configuration;

    public PlayNowContainer(PlayerApplication playerapplication)
    {
        super(playerapplication);
    }

    public static void initialize(PlayerApplication playerapplication)
    {
        com/xfinity/playnow/PlayNowContainer;
        JVM INSTR monitorenter ;
        instance = new PlayNowContainer(playerapplication);
        CALContainer.setInstance(instance);
        com/xfinity/playnow/PlayNowContainer;
        JVM INSTR monitorexit ;
        return;
        playerapplication;
        throw playerapplication;
    }

    public AppUpgradeHelper createAppUpgradeHelper()
    {
        return new PlayNowAppUpgradHelper(getApplication(), userManager, getSharedPreferences(), downloadsManager, getPersistentEntityCache(), getPersistentCaptionsCache(), getVideoBookmarkDAO());
    }

    public List getAvailableConfigurations()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new ProductionConfiguration());
        arraylist.add(new StagingConfiguration());
        arraylist.add(new DenverStagingConfiguration());
        arraylist.add(new SprintQaConfiguration());
        arraylist.add(new MrQaConfiguration());
        return arraylist;
    }

    public volatile CALConfiguration getConfiguration()
    {
        return getConfiguration();
    }

    public PlayerConfiguration getConfiguration()
    {
        if (configuration == null)
        {
            if ((getApplication().getApplicationInfo().flags & 2) != 0)
            {
                configuration = new DeveloperConfiguration(getAvailableConfigurations(), new ProductionConfiguration(), getSharedPreferences());
            } else
            {
                configuration = new ProductionConfiguration();
            }
        }
        return configuration;
    }

    public String getConfigurationVersion()
    {
        return configVersion;
    }

}
