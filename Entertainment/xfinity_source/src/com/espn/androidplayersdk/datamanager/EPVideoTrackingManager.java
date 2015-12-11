// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.text.TextUtils;
import com.conviva.ConvivaContentInfo;
import com.conviva.LivePass;
import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPEvents, EPStream, EPSDKPrefs, ESPNPlayerSdk

public class EPVideoTrackingManager
{

    private static String CUSTOMER_KEY = "";
    private static String mAffiliate = "";
    private static EPEvents mEPEvents;
    private static EPStream mEPStream;
    private static String mPartner = "";
    private static String playerName = "WatchESPN-Android";
    private static int sessionId = -1;

    public EPVideoTrackingManager()
    {
    }

    public static void attachMediaPlayer(Object obj)
        throws Exception
    {
        LivePass.attachStreamer(sessionId, obj);
    }

    public static void cleanUpSesstion()
    {
        LivePass.cleanupSession(sessionId);
    }

    public static void creatMonitoringSession(Object obj, String s)
        throws Exception
    {
        if (mEPEvents == null || mEPStream == null)
        {
            throw new RuntimeException("No Video asset found");
        }
        String s1;
        HashMap hashmap;
        try
        {
            hashmap = new HashMap();
            if (!mAffiliate.trim().isEmpty())
            {
                hashmap.put("affiliate", mAffiliate);
            }
            if (!TextUtils.isEmpty(mEPEvents.getEventId()))
            {
                hashmap.put("eventId", mEPEvents.getEventId());
            }
            if (!TextUtils.isEmpty(mEPEvents.getEventName()))
            {
                hashmap.put("eventName", mEPEvents.getEventName());
            }
            if (!TextUtils.isEmpty(mEPEvents.getType()))
            {
                hashmap.put("eventType", mEPEvents.getType());
            }
            if (!TextUtils.isEmpty(mEPEvents.getLeagueName()))
            {
                hashmap.put("league", mEPEvents.getLeagueName());
            }
            if (!TextUtils.isEmpty(mEPEvents.getNetworkId()))
            {
                hashmap.put("network", mEPEvents.getNetworkId());
            }
            if (!TextUtils.isEmpty(mEPEvents.getSport()))
            {
                hashmap.put("sport", mEPEvents.getSport());
            }
            if (!TextUtils.isEmpty(mPartner))
            {
                hashmap.put("partner", mPartner);
            }
            hashmap.put("streamType", "hls");
            hashmap.put("connectionType", Utils.getConnectionType());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.sdkLog("Conviva error:", 5, ((Exception) (obj)));
            throw new RuntimeException("Unable to create session for tracking");
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        hashmap.put("playerVersion", s);
        s = "";
        if (!TextUtils.isEmpty(mEPEvents.getLeagueName()))
        {
            s = (new StringBuilder(String.valueOf(""))).append(mEPEvents.getLeagueName()).append(" : ").toString();
        }
        s1 = s;
        if (!TextUtils.isEmpty(mEPEvents.getShowName()))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append(mEPEvents.getShowName()).append(" - ").toString();
        }
        s = (new StringBuilder(String.valueOf(s1))).append(mEPEvents.getEventId()).toString();
        Utils.sdkLog(s, 2, null);
        s = new ConvivaContentInfo(s, hashmap);
        if (!"AKAMAI".equalsIgnoreCase(mEPStream.getCdn())) goto _L2; else goto _L1
_L1:
        s.defaultReportingCdnName = "AKAMAI";
_L3:
        s.defaultReportingResource = mEPStream.getCdnResource();
        s.viewerId = EPSDKPrefs.getUUID();
        s.streamUrl = mEPStream.getPlaybackUrl();
        s.playerName = playerName;
        if (!"live".equalsIgnoreCase(mEPEvents.getType()))
        {
            break MISSING_BLOCK_LABEL_514;
        }
        s.isLive = Boolean.valueOf(true);
_L4:
        sessionId = LivePass.createSession(obj, s);
        return;
_L2:
        s.defaultReportingCdnName = "LEVEL3";
          goto _L3
        s.isLive = Boolean.valueOf(false);
          goto _L4
    }

    public static int getSessionID()
    {
        return sessionId;
    }

    public static void init()
    {
        try
        {
            CUSTOMER_KEY = EPSDKPrefs.getApiConfigConvivaCustomerKey();
            playerName = EPSDKPrefs.getApiConfigConvivPlayerName();
            LivePass.init(CUSTOMER_KEY, ESPNPlayerSdk.mCtx);
            mPartner = EPSDKPrefs.getApiPartnerName();
            mAffiliate = EPSDKPrefs.getApiPartnerName();
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog(" Unable to init conviva", 5, exception);
        }
    }

    public static void pauseSessionMonitor()
        throws Exception
    {
        LivePass.pauseMonitor(sessionId);
    }

    public static void reportError(String s)
        throws Exception
    {
        if (sessionId == -1)
        {
            throw new RuntimeException("Create Monitoring session before reporting errors ");
        } else
        {
            LivePass.reportError(sessionId, s, 1);
            return;
        }
    }

    public static void resetSessionID()
    {
        sessionId = -1;
    }

    public static void setAffiliate(String s)
    {
        mAffiliate = s;
    }

    protected static void setEventObj(EPEvents epevents)
    {
        mEPEvents = epevents;
    }

    protected static void setStreamObj(EPStream epstream)
    {
        mEPStream = epstream;
    }

}
