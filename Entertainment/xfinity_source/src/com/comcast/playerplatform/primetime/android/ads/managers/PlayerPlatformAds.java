// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import android.app.Activity;
import android.content.Context;
import com.adobe.mediacore.metadata.Metadata;
import com.adobe.mediacore.metadata.MetadataNode;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.primetime.android.asset.AdData;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.AssetInfo;
import com.comcast.playerplatform.primetime.android.enums.AdType;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.util.ConfigurationHelper;
import com.comcast.playerplatform.util.android.MoneyTrace;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            AuditudeAdManager, C3Manager, BaseAdManager, FreewheelManager, 
//            ManafestManipulatorManager

public class PlayerPlatformAds
{

    public PlayerPlatformAds()
    {
    }

    public static BaseAdManager getAdManager(PlayerSettings playersettings, Asset asset, HttpClient httpclient, Activity activity, Context context)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType = new int[AdType.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType[AdType.AUDITUDE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType[AdType.MANIFEST_MANIPULATOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType[AdType.C3.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$enums$AdType[AdType.FREEWHEEL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        AdType adtype;
        AdData addata;
        try
        {
            addata = asset.getAdData();
        }
        // Misplaced declaration of an exception variable
        catch (PlayerSettings playersettings)
        {
            return null;
        }
        if (addata == null) goto _L2; else goto _L1
_L1:
        adtype = addata.getAdType();
_L8:
        _cls1..SwitchMap.com.comcast.playerplatform.primetime.android.enums.AdType[adtype.ordinal()];
        JVM INSTR tableswitch 1 4: default 102
    //                   1 65
    //                   2 75
    //                   3 85
    //                   4 92;
           goto _L3 _L4 _L5 _L6 _L7
_L2:
        adtype = playersettings.getAdType();
          goto _L8
_L4:
        return getAuditudeAdManager(asset, context, playersettings, addata);
_L5:
        return getManafestManipulatorManager(playersettings, httpclient, asset.getMoneyTrace());
_L6:
        return getC3Manager(playersettings, addata);
_L7:
        playersettings = getFreeWheelManager(activity);
        return playersettings;
_L3:
        return null;
    }

    private static BaseAdManager getAuditudeAdManager(Asset asset, Context context, PlayerSettings playersettings, AdData addata)
    {
        String s;
        String s1;
        context = new ConfigurationHelper(context);
        s = context.getAuditudeZone();
        s1 = context.getAuditudeDomain();
        playersettings = getAuditudeParameters(playersettings, addata, context);
        context = "";
        if (addata == null || addata.getMediaId() == null) goto _L2; else goto _L1
_L1:
        context = addata.getMediaId();
_L4:
        return new AuditudeAdManager(s, s1, playersettings, context);
_L2:
        if (asset.getAssetInfo() != null)
        {
            context = asset.getAssetInfo().getMediaId();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static Metadata getAuditudeParameters(PlayerSettings playersettings, AdData addata, ConfigurationHelper configurationhelper)
    {
        configurationhelper = configurationhelper.getAuditudeParameters();
        Object obj;
        if (addata != null)
        {
            addata = addata.getTargetingParameters();
        } else
        {
            addata = playersettings.getTargetingParameters();
        }
        obj = configurationhelper;
        if (addata != null)
        {
            playersettings = configurationhelper;
            if (configurationhelper == null)
            {
                playersettings = new MetadataNode();
            }
            configurationhelper = addata.keySet().iterator();
            do
            {
                obj = playersettings;
                if (!configurationhelper.hasNext())
                {
                    break;
                }
                obj = (String)configurationhelper.next();
                playersettings.setValue(((String) (obj)), (String)addata.get(obj));
            } while (true);
        }
        return ((Metadata) (obj));
    }

    private static BaseAdManager getC3Manager(PlayerSettings playersettings, AdData addata)
    {
        if (addata != null)
        {
            playersettings = addata.getAdBreaks();
        } else
        {
            playersettings = playersettings.getC3Ads();
        }
        addata = new C3Manager(playersettings);
        addata.setAdList(playersettings);
        return addata;
    }

    private static BaseAdManager getFreeWheelManager(Activity activity)
    {
        return new FreewheelManager(activity);
    }

    private static BaseAdManager getManafestManipulatorManager(PlayerSettings playersettings, HttpClient httpclient, MoneyTrace moneytrace)
    {
        return new ManafestManipulatorManager(playersettings.getDeviceId(), httpclient, moneytrace);
    }
}
