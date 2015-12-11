// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.config;

import android.content.SharedPreferences;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.config:
//            PlayerConfiguration

public class DeveloperConfiguration extends PlayerConfiguration
{

    private List availableConfigurations;
    private PlayerConfiguration defaultConfiguration;
    private PlayerConfiguration _flddelegate;
    private final SharedPreferences sharedPreferences;

    public DeveloperConfiguration(List list, PlayerConfiguration playerconfiguration, SharedPreferences sharedpreferences)
    {
        sharedPreferences = sharedpreferences;
        defaultConfiguration = playerconfiguration;
        availableConfigurations = list;
        updateConfiguration();
    }

    private void updateConfiguration()
    {
        if (!isDeveloperModeEnabled()) goto _L2; else goto _L1
_L1:
label0:
        {
            String s = sharedPreferences.getString("configName", null);
            if (s == null)
            {
                break label0;
            }
            Iterator iterator = availableConfigurations.iterator();
            PlayerConfiguration playerconfiguration;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                playerconfiguration = (PlayerConfiguration)iterator.next();
            } while (!playerconfiguration.getClass().getSimpleName().equals(s));
            _flddelegate = playerconfiguration;
        }
_L4:
        if (_flddelegate == null)
        {
            _flddelegate = defaultConfiguration;
        }
        return;
_L2:
        _flddelegate = defaultConfiguration;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getConsumablesHypermediaUrl()
    {
        return _flddelegate.getConsumablesHypermediaUrl();
    }

    public long getDataRevalidationIntervalInMillis()
    {
        return _flddelegate.getDataRevalidationIntervalInMillis();
    }

    public PlayerConfiguration getDeveloperConfiguration()
    {
        PlayerConfiguration playerconfiguration = null;
        if (sharedPreferences.getString("configName", null) != null)
        {
            playerconfiguration = _flddelegate;
        }
        return playerconfiguration;
    }

    public URI getEditorialCoversUri()
    {
        return _flddelegate.getEditorialCoversUri();
    }

    public URI getEditorialVideoUri()
    {
        return _flddelegate.getEditorialVideoUri();
    }

    public String getEntityThumbnailUri()
    {
        return _flddelegate.getEntityThumbnailUri();
    }

    public List getFlyinMenuOptions()
    {
        return _flddelegate.getFlyinMenuOptions();
    }

    public int getHypermediaRevalidationInterval()
    {
        return _flddelegate.getHypermediaRevalidationInterval();
    }

    public long getMinVersionCheckRevalidationIntervalInMillis()
    {
        return _flddelegate.getMinVersionCheckRevalidationIntervalInMillis();
    }

    public String getRobotoFamilyName()
    {
        return _flddelegate.getRobotoFamilyName();
    }

    public String getSplunkAppName()
    {
        return _flddelegate.getSplunkAppName();
    }

    public long getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()
    {
        if (isDeveloperModeEnabled())
        {
            return 0x493e0L;
        } else
        {
            return _flddelegate.getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt();
        }
    }

    public String getTveHypermediaUrl()
    {
        return _flddelegate.getTveHypermediaUrl();
    }

    public String getUserAgentPrefix()
    {
        return _flddelegate.getUserAgentPrefix();
    }

    public String getXfinitySansFamilyName()
    {
        return _flddelegate.getXfinitySansFamilyName();
    }

    public String getXipUri()
    {
        return _flddelegate.getXipUri();
    }

    public boolean isDarkStreamsEnabled()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (isDeveloperModeEnabled())
        {
            flag = flag1;
            if (sharedPreferences.getBoolean("darkStreamsEnabled", false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isDeveloperModeAllowed()
    {
        return true;
    }

    public boolean isDeveloperModeEnabled()
    {
        return sharedPreferences.getBoolean("inDevMode", false);
    }

    public void setDarkStreamsEnabled(Boolean boolean1)
    {
        if (isDeveloperModeEnabled())
        {
            android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("darkStreamsEnabled", boolean1.booleanValue());
            editor.commit();
        }
    }

    public void setDeveloperConfiguration(PlayerConfiguration playerconfiguration)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        if (playerconfiguration != null)
        {
            editor.putString("configName", playerconfiguration.getClass().getSimpleName());
        } else
        {
            editor.remove("configName");
        }
        editor.commit();
        if (playerconfiguration == null)
        {
            playerconfiguration = defaultConfiguration;
        }
        _flddelegate = playerconfiguration;
    }

    public void setDeveloperModeEnabled(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("inDevMode", flag);
        editor.commit();
        updateConfiguration();
    }

    public boolean shouldSuppressNetworkLogos()
    {
        return _flddelegate.shouldSuppressNetworkLogos();
    }
}
