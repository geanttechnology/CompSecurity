// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.appspeed;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.AsBeacon;
import com.ebay.nautilus.kernel.net.AsBeaconManager;
import com.ebay.nautilus.kernel.net.AsMark;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.ArrayList;

public class AppSpeedShim extends ActivityShim
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/mobile/appspeed/AppSpeedShim.getSimpleName(), 3, "debug logger for app speed shim");
    AsBeacon beacon;
    AsBeaconManager mgr;
    String trackingName;

    public AppSpeedShim()
    {
    }

    public static ArrayList deriveBeaconTags(Context context)
    {
        ArrayList arraylist = null;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            arraylist = new ArrayList();
            arraylist.add(com.ebay.nautilus.kernel.net.AsBeacon.AsTagName.landscape);
        }
        context = arraylist;
        if (!MyApp.getPrefs().isSignedIn())
        {
            context = arraylist;
            if (arraylist == null)
            {
                context = new ArrayList();
            }
            context.add(com.ebay.nautilus.kernel.net.AsBeacon.AsTagName.signedout);
        }
        return context;
    }

    private String getBeaconName(TrackingSupport trackingsupport)
    {
        String s = trackingsupport.getTrackingEventName();
        trackingsupport = s;
        if ("HomePage".equals(s))
        {
            trackingsupport = "HomePageVQ";
        }
        return trackingsupport;
    }

    public void atfRendered()
    {
        if (beacon == null)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("no beacon, no atf mark");
            }
            return;
        } else
        {
            mgr.addMark(beacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_atf_render));
            return;
        }
    }

    public void init()
    {
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Nautilus.B.appSpeed)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        obj = getActivity();
        if (obj instanceof TrackingSupport)
        {
            break; /* Loop/switch isn't completed */
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log("tracking event name not available: not instance of TrackingSupport");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        trackingName = getBeaconName((TrackingSupport)obj);
        if (!TextUtils.isEmpty(trackingName))
        {
            break; /* Loop/switch isn't completed */
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log("tracking event name not available");
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("tracking event name ").append(trackingName).toString());
        }
        mgr = (AsBeaconManager)getFwActivity().getEbayContext().getExtension(com/ebay/nautilus/kernel/net/AsBeaconManager);
        if (mgr == null)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("beacon manager not available");
                return;
            }
        } else
        {
            String s = MyApp.getPrefs().getCurrentCountry().getCountryCode();
            obj = deriveBeaconTags(((Context) (obj)));
            beacon = mgr.createCurrentBeacon(trackingName, s, ((java.util.List) (obj)), 0L);
            mgr.addMark(beacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_start));
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        if (beacon == null)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("no beacon, not reporting first render");
            }
            return;
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append(beacon.activityName).append(" beacon, reporting first render").toString());
        }
        mgr.addMark(beacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_first_render));
    }

    protected void onPause()
    {
        if (beacon == null)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("no beacon, no retire");
            }
            return;
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append(beacon.activityName).append(" beacon, retiring").toString());
        }
        mgr.addMark(beacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_closed));
        mgr.retireBeacon(beacon);
        beacon = null;
    }

    protected void preOnCreate(Bundle bundle)
    {
        init();
    }

    public void reload()
    {
        if (beacon == null)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("no beacon, no refresh mark");
            }
            return;
        } else
        {
            mgr.addMark(beacon, new AsMark(com.ebay.nautilus.kernel.net.AsMark.AsMarkName.activity_reloaded));
            return;
        }
    }

}
