// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.espn.androidplayersdk.listenerinterface.EPPlayerTrackingCallBack;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPSDKPrefs, ESPNPlayerSdk, EPAdTrackingManager, EPEvents, 
//            Omniture

public class EPPlayerTrackingManager
{
    private class Milestoneping extends TimerTask
    {

        final EPPlayerTrackingManager this$0;

        public void run()
        {
            try
            {
                milestone();
                return;
            }
            catch (Exception exception)
            {
                Utils.sdkLog("Unable to send tracking ping", 2, exception);
            }
        }

        private Milestoneping()
        {
            this$0 = EPPlayerTrackingManager.this;
            super();
        }

        Milestoneping(Milestoneping milestoneping)
        {
            this();
        }
    }

    private class SendTrackingTask extends AsyncTask
    {

        private static int $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType[];
        EPEvents epEvents;
        TrackingType mTrackingType;
        final EPPlayerTrackingManager this$0;

        static int[] $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()
        {
            int ai[] = $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[TrackingType.values().length];
            try
            {
                ai[TrackingType.AD_COMPLETE.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror16) { }
            try
            {
                ai[TrackingType.AD_START.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror15) { }
            try
            {
                ai[TrackingType.AUTH_ATTEMPT.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                ai[TrackingType.AUTH_SUCCESS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                ai[TrackingType.EVENT_CONCLUDED.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                ai[TrackingType.MAP_AFFILIATE.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                ai[TrackingType.MILESTONE.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                ai[TrackingType.MUTE.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                ai[TrackingType.UNMUTE.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                ai[TrackingType.VIDEO_PAUSE.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                ai[TrackingType.VIDEO_PLAY_FROM_PAUSE.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                ai[TrackingType.VIDEO_SCRUBBED.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                ai[TrackingType.VIDEO_START.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[TrackingType.VIDEO_STOP.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[TrackingType.VOD_END.ordinal()] = 17;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[TrackingType.VOD_MID.ordinal()] = 16;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[TrackingType.VOD_START.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType = ai;
            return ai;
        }

        private void sendPingsToServer(String s)
        {
            String s1;
            String s2;
            String s3;
            s3 = null;
            s1 = null;
            s2 = null;
            s = (HttpURLConnection)(new URL(s)).openConnection();
            s2 = s;
            s3 = s;
            s1 = s;
            if (s.getResponseCode() != 200)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            s2 = s;
            s3 = s;
            s1 = s;
            Utils.sdkLog("Tracking ping sent", 2, null);
            if (s != null)
            {
                s.disconnect();
            }
_L2:
            return;
            s;
            s1 = s2;
            Utils.sdkLog("unable to send traking ping", 5, s);
            if (s2 == null) goto _L2; else goto _L1
_L1:
            s2.disconnect();
            return;
            s;
            s1 = s3;
            Utils.sdkLog("unable to send traking ping", 5, s);
            if (s3 == null) goto _L2; else goto _L3
_L3:
            s3.disconnect();
            return;
            s;
            if (s1 != null)
            {
                s1.disconnect();
            }
            throw s;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()[mTrackingType.ordinal()];
            JVM INSTR tableswitch 3 17: default 238
        //                       3 84
        //                       4 103
        //                       5 109
        //                       6 115
        //                       7 124
        //                       8 135
        //                       9 146
        //                       10 157
        //                       11 168
        //                       12 179
        //                       13 192
        //                       14 205
        //                       15 214
        //                       16 230
        //                       17 222;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L2:
            videoStartParams(as[0]);
            return null;
_L3:
            try
            {
                milestoneParam();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Utils.sdkLog("player tracking ping failed ", 5, as);
                return null;
            }
            return null;
_L4:
            eventConcluded();
            return null;
_L5:
            videoStop(as[0]);
            return null;
_L6:
            videoEventParams("watchespn_pause", "event78", null);
            return null;
_L7:
            videoEventParams("watchespn_scrub", "event79", null);
            return null;
_L8:
            videoEventParams("watchespn_play", "event80", null);
            return null;
_L9:
            videoEventParams("watchespn_mute", "event81", null);
            return null;
_L10:
            videoEventParams("watchespn_unmute", "event81", null);
            return null;
_L11:
            videoEventParams("adStart", "event39", as[0]);
            return null;
_L12:
            videoEventParams("adComplete", "event40", as[0]);
            return null;
_L13:
            setAffiliateCode();
            return null;
_L14:
            vodTrackingParam("event1");
            return null;
_L16:
            vodTrackingParam("event11");
            return null;
_L15:
            vodTrackingParam("event9");
            return null;
_L1:
            return null;
        }

        void eventConcluded()
        {
            Omniture omniture = getCommonOmniValues(callback.trackingParam());
            omniture.pev2 = "watchespn:end program";
            omniture.events = "event10,event23,event11";
            omniture.products = (new StringBuilder(";;;;event10=")).append(getMinsPastSinceBeaconFired()).toString();
            omniture.prop58 = omniture.eVar58;
            omniture.eVar30 = "400";
            sendPingsToServer(urlbuilder(omniture));
        }

        Omniture getCommonOmniValues(String s)
        {
            Omniture omniture = new Omniture();
            omniture.eVar2 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            String s1;
            if (EPPlayerTrackingManager.srcApp != null)
            {
                s1 = EPPlayerTrackingManager.srcApp;
            } else
            {
                s1 = null;
            }
            omniture.eVar3 = s1;
            omniture.eVar11 = "watchespn Player";
            omniture.eVar17 = partnerName;
            omniture.eVar19 = epEvents.getSport();
            omniture.eVar21 = "no league set";
            if ("live".equalsIgnoreCase(epEvents.getType()))
            {
                omniture.eVar31 = "live";
            } else
            {
                omniture.eVar31 = "replay";
            }
            omniture.eVar32 = EPSDKPrefs.getAffiliateID();
            omniture.eVar33 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).append(":").append(s).toString();
            omniture.eVar34 = epEvents.getNetworkId();
            omniture.eVar37 = "";
            omniture.eVar39 = (new StringBuilder("watchespn:")).append(epEvents.getSportCode()).append(epEvents.getprogramingCode()).toString();
            omniture.eVar45 = epEvents.getShowName();
            omniture.eVar47 = (new StringBuilder(String.valueOf(epEvents.getStartTime().replaceFirst("T", "|")))).append("|").append(epEvents.getSport()).append("|").append(epEvents.getLeagueName()).append("|").append(epEvents.getSportCode()).append("|").append(epEvents.getprogramingCode()).append("|").append(epEvents.getType()).append("|").append(epEvents.getShowName()).append("|").append(epEvents.getNetworkId()).toString();
            omniture.eVar52 = "watchespn Player";
            omniture.eVar53 = (new StringBuilder("watchespn Player:")).append(partnerName).toString();
            omniture.eVar54 = (new StringBuilder("watchespn Player:")).append(partnerName).append(":").append("na").toString();
            omniture.eVar55 = (new StringBuilder("watchespn Player:")).append(EPSDKPrefs.getAffiliateID()).toString();
            omniture.eVar56 = (new StringBuilder("watchespn Player:")).append(partnerName).append(":").append(EPSDKPrefs.getAffiliateID()).toString();
            omniture.eVar57 = "watchespn Player:no league set";
            omniture.eVar58 = (new StringBuilder("watchespn Player:")).append(partnerName).append(":").append("no league set").toString();
            omniture.eVar59 = (new StringBuilder("watchespn Player:")).append(epEvents.eventId).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            omniture.eVar60 = (new StringBuilder("watchespn Player:")).append(partnerName).append(":").append(epEvents.eventId).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            omniture.eVar68 = (new StringBuilder(String.valueOf(EPSDKPrefs.getAffiliateID()))).append(":authenticated").toString();
            omniture.eVar71 = (new StringBuilder(String.valueOf(epEvents.getAiringId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            omniture.prop2 = swid;
            omniture.prop3 = omniture.eVar2;
            omniture.prop4 = omniture.eVar11;
            omniture.prop5 = (new StringBuilder("watchespn:watchespn Player:")).append(partnerName).toString();
            omniture.prop25 = omniture.eVar19;
            omniture.prop26 = omniture.eVar21;
            omniture.prop28 = omniture.eVar45;
            omniture.eVar37 = omniture.eVar39;
            omniture.prop25 = omniture.eVar19;
            omniture.prop42 = omniture.eVar17;
            omniture.prop43 = omniture.eVar32;
            omniture.prop45 = omniture.eVar34;
            omniture.prop51 = omniture.eVar39;
            omniture.prop52 = omniture.eVar52;
            omniture.prop53 = omniture.eVar53;
            omniture.prop54 = omniture.eVar54;
            omniture.prop55 = omniture.eVar55;
            omniture.prop56 = omniture.eVar56;
            omniture.prop57 = omniture.eVar57;
            omniture.prop59 = omniture.eVar59;
            omniture.prop60 = omniture.eVar60;
            omniture.prop68 = omniture.eVar68;
            omniture.prop71 = omniture.eVar71;
            return omniture;
        }

        String getMinsPastSinceBeaconFired()
        {
            String s;
            if (beaconFiredTime == null)
            {
                break MISSING_BLOCK_LABEL_62;
            }
            s = (new DecimalFormat("#.####")).format(((double)(new Date()).getTime() - (double)beaconFiredTime.getTime()) / 60000D);
            return s;
            Exception exception;
            exception;
            Utils.sdkLog("Unable to calculate beacon fired time", 5, exception);
            return "0";
        }

        void milestoneParam()
        {
            Omniture omniture = getCommonOmniValues(callback.trackingParam());
            omniture.pe = "m_i";
            omniture.pev2 = "watchespn:5min";
            omniture.events = "event10,event23";
            omniture.products = ";;;;event10=5";
            omniture.prop58 = omniture.eVar58;
            setBeaconFiredTimeStamp();
            sendPingsToServer(urlbuilder(omniture));
        }

        void setBeaconFiredTimeStamp()
        {
            beaconFiredTime = new Date();
        }

        String urlbuilder(Omniture omniture)
        {
            String s2 = EPPlayerTrackingManager.BASE_URL;
            String s1 = "";
            String s;
            try
            {
                if (!TextUtils.isEmpty(omniture.pe))
                {
                    s1 = (new StringBuilder(String.valueOf(""))).append("&pe=").append(URLEncoder.encode(omniture.pe, "UTF-8")).toString();
                }
            }
            // Misplaced declaration of an exception variable
            catch (Omniture omniture)
            {
                Utils.sdkLog("Tracking ping failed", 5, omniture);
                return s2;
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.ch))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&ch=").append(URLEncoder.encode(omniture.ch, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.pev2))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&pev2=").append(URLEncoder.encode(omniture.pev2, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.linkID))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c9=").append(URLEncoder.encode(omniture.linkID, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar2))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v2=").append(URLEncoder.encode(omniture.eVar2, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar3))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v3=").append(URLEncoder.encode(omniture.eVar3, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar9))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v9=").append(URLEncoder.encode(omniture.eVar9, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar11))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v11=").append(URLEncoder.encode(omniture.eVar11, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar16))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v16=").append(URLEncoder.encode(omniture.eVar16, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar17))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v17=").append(URLEncoder.encode(omniture.eVar17, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar19))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v19=").append(URLEncoder.encode(omniture.eVar19, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar20))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v20=").append(URLEncoder.encode(omniture.eVar20, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar21))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v21=").append(URLEncoder.encode(omniture.eVar21, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar29))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v29=").append(URLEncoder.encode(omniture.eVar29, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar30))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v30=").append(URLEncoder.encode(omniture.eVar30, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar31))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v31=").append(URLEncoder.encode(omniture.eVar31, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar32))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v32=").append(URLEncoder.encode(omniture.eVar32, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar33))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v33=").append(URLEncoder.encode(omniture.eVar33, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar34))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v34=").append(URLEncoder.encode(omniture.eVar34, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar37))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v37=").append(URLEncoder.encode(omniture.eVar37, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar39))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v39=").append(URLEncoder.encode(omniture.eVar39, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar45))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v45=").append(URLEncoder.encode(omniture.eVar45, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar47))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v47=").append(URLEncoder.encode(omniture.eVar47, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar52))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v52=").append(URLEncoder.encode(omniture.eVar52, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar53))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v53=").append(URLEncoder.encode(omniture.eVar53, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar54))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v54=").append(URLEncoder.encode(omniture.eVar54, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar55))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v55=").append(URLEncoder.encode(omniture.eVar55, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar56))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v56=").append(URLEncoder.encode(omniture.eVar56, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar57))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v57=").append(URLEncoder.encode(omniture.eVar57, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar58))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v58=").append(URLEncoder.encode(omniture.eVar58, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar59))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v59=").append(URLEncoder.encode(omniture.eVar59, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar60))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v60=").append(URLEncoder.encode(omniture.eVar60, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar61))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v61=").append(URLEncoder.encode(omniture.eVar61, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar62))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v62=").append(URLEncoder.encode(omniture.eVar62, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar63))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v63=").append(URLEncoder.encode(omniture.eVar63, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar64))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v64=").append(URLEncoder.encode(omniture.eVar64, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar65))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v65=").append(URLEncoder.encode(omniture.eVar65, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar66))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v66=").append(URLEncoder.encode(omniture.eVar66, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar67))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v67=").append(URLEncoder.encode(omniture.eVar67, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.eVar68))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&v68=").append(URLEncoder.encode(omniture.eVar68, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.eVar71))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&v71=").append(URLEncoder.encode(omniture.eVar71, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.events))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&events=").append(URLEncoder.encode(omniture.events, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.products))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&products=").append(URLEncoder.encode(omniture.products, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop1))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c1=").append(URLEncoder.encode(omniture.prop1, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop2))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c2=").append(URLEncoder.encode(omniture.prop2, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop3))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c3=").append(URLEncoder.encode(omniture.prop3, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop4))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c4=").append(URLEncoder.encode(omniture.prop4, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop5))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c5=").append(URLEncoder.encode(omniture.prop5, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop9))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c9=").append(URLEncoder.encode(omniture.prop9, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop17))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c17=").append(URLEncoder.encode(omniture.prop17, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop25))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c25=").append(URLEncoder.encode(omniture.prop25, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop26))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c26=").append(URLEncoder.encode(omniture.prop26, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop28))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c28=").append(URLEncoder.encode(omniture.prop28, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop35))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c35=").append(URLEncoder.encode(omniture.prop35, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop42))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c42=").append(URLEncoder.encode(omniture.prop42, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop43))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c43=").append(URLEncoder.encode(omniture.prop43, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop45))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c45=").append(URLEncoder.encode(omniture.prop45, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop47))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c47=").append(URLEncoder.encode(omniture.prop47, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop48))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c48=").append(URLEncoder.encode(omniture.prop48, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop51))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c51=").append(URLEncoder.encode(omniture.prop51, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop52))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c52=").append(URLEncoder.encode(omniture.prop52, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop53))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c53=").append(URLEncoder.encode(omniture.prop53, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop54))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c54=").append(URLEncoder.encode(omniture.prop54, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop55))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c55=").append(URLEncoder.encode(omniture.prop55, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop56))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c56=").append(URLEncoder.encode(omniture.prop56, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop57))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c57=").append(URLEncoder.encode(omniture.prop57, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop58))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c58=").append(URLEncoder.encode(omniture.prop58, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop59))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c59=").append(URLEncoder.encode(omniture.prop59, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop60))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c60=").append(URLEncoder.encode(omniture.prop60, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop61))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c61=").append(URLEncoder.encode(omniture.prop61, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop62))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c62=").append(URLEncoder.encode(omniture.prop62, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop63))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c63=").append(URLEncoder.encode(omniture.prop63, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop64))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c64=").append(URLEncoder.encode(omniture.prop64, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop65))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c65=").append(URLEncoder.encode(omniture.prop65, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop66))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c66=").append(URLEncoder.encode(omniture.prop66, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop67))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c67=").append(URLEncoder.encode(omniture.prop67, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop68))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c68=").append(URLEncoder.encode(omniture.prop68, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop71))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c71=").append(URLEncoder.encode(omniture.prop71, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop72))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c72=").append(URLEncoder.encode(omniture.prop72, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop73))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c73=").append(URLEncoder.encode(omniture.prop73, "UTF-8")).toString();
            }
            s1 = s;
            if (!TextUtils.isEmpty(omniture.prop74))
            {
                s1 = (new StringBuilder(String.valueOf(s))).append("&c74=").append(URLEncoder.encode(omniture.prop74, "UTF-8")).toString();
            }
            s = s1;
            if (!TextUtils.isEmpty(omniture.prop75))
            {
                s = (new StringBuilder(String.valueOf(s1))).append("&c75=").append(URLEncoder.encode(omniture.prop75, "UTF-8")).toString();
            }
            omniture = (new StringBuilder(String.valueOf(s2))).append("AQB=1&ndh=1&vid=").append(URLEncoder.encode(EPSDKPrefs.getUUID(), "UTF-8")).append("&t=").append(URLEncoder.encode(getTimeForOmniture(), "UTF-8")).append(s).append(endOfUrl()).toString();
            return omniture;
        }

        void videoEventParams(String s, String s1, String s2)
        {
            Omniture omniture = new Omniture();
            omniture.pe = "lnk_o";
            omniture.pev2 = s;
            omniture.linkID = s;
            omniture.eVar2 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            if (EPPlayerTrackingManager.srcApp != null)
            {
                s = EPPlayerTrackingManager.srcApp;
            } else
            {
                s = null;
            }
            omniture.eVar3 = s;
            omniture.events = s1;
            omniture.prop3 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
            if (s2 != null && !s2.trim().isEmpty())
            {
                omniture.eVar29 = s2;
            }
            sendPingsToServer(urlbuilder(omniture));
        }

        void videoStartParams(String s)
        {
            s = getCommonOmniValues(s);
            s.pe = "m_s";
            s.pev2 = "watchespn:streamstart";
            s.events = "event10,event23,event1";
            s.products = ";;;;event10=0";
            s.prop58 = ((Omniture) (s)).eVar58;
            sendPingsToServer(urlbuilder(s));
            setBeaconFiredTimeStamp();
        }

        void videoStop(String s)
        {
            s = getCommonOmniValues(s);
            s.pe = "m_i";
            s.events = "event10,event23";
            s.pev2 = "watchespn:videostopped";
            s.products = (new StringBuilder(";;;;event10=")).append(getMinsPastSinceBeaconFired()).toString();
            s.prop58 = ((Omniture) (s)).eVar58;
            sendPingsToServer(urlbuilder(s));
        }

        void vodTrackingParam(String s)
        {
            if (epEvents == null || videoStartType == null)
            {
                return;
            }
            Omniture omniture = new Omniture();
            omniture.pev2 = (new StringBuilder("watchespn:")).append(platform).append(":video:start").toString();
            omniture.events = s;
            omniture.ch = (new StringBuilder("watchespn:")).append(platform).toString();
            omniture.prop1 = "watchespn";
            omniture.eVar11 = (new StringBuilder("video:")).append(epEvents.getcoverageType()).toString();
            omniture.prop35 = "vod";
            omniture.prop4 = (new StringBuilder("video:")).append(epEvents.getcoverageType()).toString();
            omniture.eVar19 = (new StringBuilder("watchespn:")).append(platform).append(":").append(epEvents.getSport()).toString();
            omniture.prop25 = (new StringBuilder("watchespn:")).append(platform).append(":").append(epEvents.getSport()).toString();
            omniture.eVar21 = (new StringBuilder("watchespn:")).append(platform).append(":").append(epEvents.getLeagueName()).toString();
            omniture.prop26 = (new StringBuilder("watchespn:")).append(platform).append(":").append(epEvents.getLeagueName()).toString();
            omniture.prop2 = swid;
            omniture.prop17 = "en";
            omniture.eVar9 = "en";
            omniture.prop47 = (new StringBuilder("watchespn:")).append(platform).append(":").append(appVersion).toString();
            omniture.prop48 = Integer.toString(android.os.Build.VERSION.SDK_INT);
            if (isAuthenticated)
            {
                omniture.prop42 = EPSDKPrefs.getAffiliateID();
                omniture.eVar17 = EPSDKPrefs.getAffiliateID();
                omniture.prop43 = EPSDKPrefs.getAffiliateID();
                omniture.eVar32 = EPSDKPrefs.getAffiliateID();
                omniture.eVar68 = (new StringBuilder(String.valueOf(EPSDKPrefs.getAffiliateID()))).append(":authenticated:vod").toString();
            } else
            {
                omniture.prop42 = "vod:not auth";
                omniture.eVar17 = "vod:not auth";
                omniture.prop43 = "vod:not auth";
                omniture.eVar32 = "vod:not auth";
                omniture.eVar68 = "vod:not auth";
            }
            omniture.eVar2 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getEventName()).toString();
            if (EPPlayerTrackingManager.srcApp != null)
            {
                s = EPPlayerTrackingManager.srcApp;
            } else
            {
                s = null;
            }
            omniture.eVar3 = s;
            omniture.prop3 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getEventName()).toString();
            omniture.eVar16 = videoStartType;
            omniture.eVar20 = "";
            omniture.prop52 = (new StringBuilder(String.valueOf(platform))).append(":VOD").toString();
            omniture.eVar52 = (new StringBuilder(String.valueOf(platform))).append(":VOD").toString();
            omniture.prop45 = "VOD";
            omniture.eVar34 = "VOD";
            omniture.prop68 = omniture.eVar68;
            sendPingsToServer(urlbuilder(omniture));
        }

        private SendTrackingTask(TrackingType trackingtype, EPEvents epevents)
        {
            this$0 = EPPlayerTrackingManager.this;
            super();
            mTrackingType = trackingtype;
            epEvents = epevents;
        }

        SendTrackingTask(TrackingType trackingtype, EPEvents epevents, SendTrackingTask sendtrackingtask)
        {
            this(trackingtype, epevents);
        }
    }

    private static final class TrackingType extends Enum
    {

        public static final TrackingType AD_COMPLETE;
        public static final TrackingType AD_START;
        public static final TrackingType AUTH_ATTEMPT;
        public static final TrackingType AUTH_SUCCESS;
        private static final TrackingType ENUM$VALUES[];
        public static final TrackingType EVENT_CONCLUDED;
        public static final TrackingType MAP_AFFILIATE;
        public static final TrackingType MILESTONE;
        public static final TrackingType MUTE;
        public static final TrackingType UNMUTE;
        public static final TrackingType VIDEO_PAUSE;
        public static final TrackingType VIDEO_PLAY_FROM_PAUSE;
        public static final TrackingType VIDEO_SCRUBBED;
        public static final TrackingType VIDEO_START;
        public static final TrackingType VIDEO_STOP;
        public static final TrackingType VOD_END;
        public static final TrackingType VOD_MID;
        public static final TrackingType VOD_START;

        public static TrackingType valueOf(String s)
        {
            return (TrackingType)Enum.valueOf(com/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType, s);
        }

        public static TrackingType[] values()
        {
            TrackingType atrackingtype[] = ENUM$VALUES;
            int i = atrackingtype.length;
            TrackingType atrackingtype1[] = new TrackingType[i];
            System.arraycopy(atrackingtype, 0, atrackingtype1, 0, i);
            return atrackingtype1;
        }

        static 
        {
            AUTH_ATTEMPT = new TrackingType("AUTH_ATTEMPT", 0);
            AUTH_SUCCESS = new TrackingType("AUTH_SUCCESS", 1);
            VIDEO_START = new TrackingType("VIDEO_START", 2);
            MILESTONE = new TrackingType("MILESTONE", 3);
            EVENT_CONCLUDED = new TrackingType("EVENT_CONCLUDED", 4);
            VIDEO_STOP = new TrackingType("VIDEO_STOP", 5);
            VIDEO_PAUSE = new TrackingType("VIDEO_PAUSE", 6);
            VIDEO_SCRUBBED = new TrackingType("VIDEO_SCRUBBED", 7);
            VIDEO_PLAY_FROM_PAUSE = new TrackingType("VIDEO_PLAY_FROM_PAUSE", 8);
            MUTE = new TrackingType("MUTE", 9);
            UNMUTE = new TrackingType("UNMUTE", 10);
            AD_START = new TrackingType("AD_START", 11);
            AD_COMPLETE = new TrackingType("AD_COMPLETE", 12);
            MAP_AFFILIATE = new TrackingType("MAP_AFFILIATE", 13);
            VOD_START = new TrackingType("VOD_START", 14);
            VOD_MID = new TrackingType("VOD_MID", 15);
            VOD_END = new TrackingType("VOD_END", 16);
            ENUM$VALUES = (new TrackingType[] {
                AUTH_ATTEMPT, AUTH_SUCCESS, VIDEO_START, MILESTONE, EVENT_CONCLUDED, VIDEO_STOP, VIDEO_PAUSE, VIDEO_SCRUBBED, VIDEO_PLAY_FROM_PAUSE, MUTE, 
                UNMUTE, AD_START, AD_COMPLETE, MAP_AFFILIATE, VOD_START, VOD_MID, VOD_END
            });
        }

        private TrackingType(String s, int i)
        {
            super(s, i);
        }
    }


    private static String BASE_URL = "";
    private static final String TIME_FORMATT = "d/M/yyyy H:mm:ss";
    private static EPEvents mEPEvents;
    private static EPPlayerTrackingManager mEPPlayerTrackingManager = null;
    private static String srcApp = null;
    private String affiliateID;
    private String appVersion;
    private Date beaconFiredTime;
    private EPPlayerTrackingCallBack callback;
    private boolean isAuthenticated;
    private final String noLeague = "no league set";
    private final String partnerLocation = "na";
    private String partnerName;
    private long pingTime;
    private String platform;
    private String swid;
    Timer timer;
    private String videoStartType;
    private final String watchEspn = "watchespn";
    private final String watchEspnPlayer = "watchespn Player";

    public EPPlayerTrackingManager()
    {
        isAuthenticated = false;
        videoStartType = null;
        partnerName = "";
        affiliateID = "";
        swid = "";
        beaconFiredTime = null;
        platform = "";
        appVersion = "";
        pingTime = 0x493e0L;
    }

    private final String endOfUrl()
    {
        return "&AQE=1";
    }

    public static String getAffiliateUrl()
    {
        return (new EPSDKPrefs()).getField("analytics", "affiliateUrl");
    }

    public static EPPlayerTrackingManager getInstance()
    {
        if (mEPPlayerTrackingManager == null)
        {
            mEPPlayerTrackingManager = new EPPlayerTrackingManager();
            String s = EPSDKPrefs.getApiPartnerName();
            mEPPlayerTrackingManager.getClass();
            if (s.equalsIgnoreCase("watchespn"))
            {
                mEPPlayerTrackingManager.partnerName = "na";
            } else
            {
                mEPPlayerTrackingManager.partnerName = EPSDKPrefs.getApiPartnerName();
            }
            mEPPlayerTrackingManager.prepareURL();
        }
        return mEPPlayerTrackingManager;
    }

    public static String getStreamLimitingConfig()
    {
        return (new EPSDKPrefs()).getField("config", "streamLimiting");
    }

    private String getTimeForOmniture()
    {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        int i = calendar.get(7);
        int j = -(calendar.get(15) + calendar.get(16)) / 60000;
        return (new StringBuilder(String.valueOf((new SimpleDateFormat("d/M/yyyy H:mm:ss", Locale.US)).format(date)))).append(" ").append(i).append(" ").append(j).toString();
    }

    public static String getVID()
    {
        return EPSDKPrefs.getUUID();
    }

    private void milestone()
    {
        try
        {
            (new SendTrackingTask(TrackingType.MILESTONE, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed milestone ping", 5, exception);
        }
    }

    private final String prepareURL()
    {
        Object obj = new Random(0x12ac60bL);
        BASE_URL = "http://";
        try
        {
            obj = (new StringBuilder(String.valueOf(BASE_URL))).append(EPSDKPrefs.getOmnitureTrackingServer()).append("/b/ss/").append(EPSDKPrefs.getOmnitureSuiteID()).append("/0/OIP-2.1/s").append(((Random) (obj)).nextInt()).append("?").toString();
            BASE_URL = ((String) (obj));
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Tracking URL failed. Player Tracking wont be sent", 5, exception);
            return "";
        }
        return ((String) (obj));
    }

    private void sendBroadcast(String s)
    {
        try
        {
            Intent intent = new Intent();
            intent.setAction(s);
            ESPNPlayerSdk.mCtx.sendBroadcast(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error Sending Broadcast", 5, s);
        }
    }

    protected static void setEventObj(EPEvents epevents)
    {
        mEPEvents = epevents;
    }

    public static void setReferringAppPram(String s)
    {
        srcApp = s;
    }

    protected void cancelMilestoneping()
    {
        String s;
        try
        {
            if (timer != null)
            {
                timer.cancel();
                timer.purge();
            }
            return;
        }
        catch (Exception exception)
        {
            if ((new StringBuilder("Video Milestone ping canceled : ")).append(exception.getMessage()).toString() != null)
            {
                s = exception.getMessage();
            } else
            {
                s = "";
            }
        }
        Utils.sdkLog(s, 5, exception);
    }

    public void resetVODParam()
    {
        mEPEvents = null;
        isAuthenticated = false;
        videoStartType = null;
    }

    public void setAffiliate(String s)
    {
        if (s != null)
        {
            affiliateID = s;
            if (!s.trim().isEmpty())
            {
                s = mEPPlayerTrackingManager;
                s.getClass();
                (s. new SendTrackingTask(TrackingType.MAP_AFFILIATE, mEPEvents, null)).execute(new String[0]);
                return;
            }
        }
    }

    void setAffiliateCode()
    {
        Object obj;
        InputStream inputstream;
        Object obj1;
        InputStream inputstream1;
        Object obj2;
        InputStream inputstream2;
        Object obj4;
        String s;
        Object obj3;
        if (ESPNPlayerSdk.IS_QA)
        {
            obj = (new StringBuilder(String.valueOf(""))).append(" http://broadband-qa.espn.go.com/espn360/apis/v1/clients").toString();
        } else
        {
            obj = (new StringBuilder(String.valueOf(""))).append("http://api.espn.com/v1/watch/clients").toString();
        }
        obj2 = (new StringBuilder(String.valueOf(obj))).append("/watchespn-android/providers/").append(affiliateID).append("?").append(EPSDKPrefs.getApiKey()).toString();
        obj3 = null;
        inputstream2 = null;
        obj1 = null;
        obj = null;
        inputstream = inputstream2;
        inputstream1 = ((InputStream) (obj3));
        obj2 = (HttpURLConnection)(new URL(((String) (obj2)))).openConnection();
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = ((InputStream) (obj3));
        inputstream2 = ((HttpURLConnection) (obj2)).getInputStream();
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = new BufferedReader(new InputStreamReader(inputstream2));
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj4 = new StringBuilder();
_L19:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        s = ((BufferedReader) (obj3)).readLine();
        if (s != null) goto _L2; else goto _L1
_L1:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = new JSONObject(((StringBuilder) (obj4)).toString());
        if (obj3 == null) goto _L4; else goto _L3
_L3:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj3)).has("clients")) goto _L4; else goto _L5
_L5:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = ((JSONObject) (obj3)).getJSONArray("clients");
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (((JSONArray) (obj3)).length() <= 0) goto _L4; else goto _L6
_L6:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = ((JSONArray) (obj3)).getJSONObject(0);
        if (obj3 == null) goto _L4; else goto _L7
_L7:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj3)).has("providers")) goto _L4; else goto _L8
_L8:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = ((JSONObject) (obj3)).getJSONArray("providers");
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (((JSONArray) (obj3)).length() <= 0) goto _L10; else goto _L9
_L9:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = ((JSONArray) (obj3)).getJSONObject(0);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj3)).has("analytics"))
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj4 = ((JSONObject) (obj3)).getJSONObject("analytics");
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj4)).has("id"))
        {
            break MISSING_BLOCK_LABEL_560;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        (new EPSDKPrefs()).putField("analytics", "affiliateId", ((JSONObject) (obj4)).getString("id"));
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        (new EPSDKPrefs()).putBooleanField("analytics", "overwriteaffiliateID", false);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj3)).has("links"))
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj4 = ((JSONObject) (obj3)).getJSONObject("links");
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj4)).has("web"))
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj4 = ((JSONObject) (obj4)).getJSONObject("web");
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj4)).has("href"))
        {
            break MISSING_BLOCK_LABEL_728;
        }
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        (new EPSDKPrefs()).putField("analytics", "affiliateUrl", ((JSONObject) (obj4)).getString("href"));
        if (obj3 == null) goto _L12; else goto _L11
_L11:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        if (!((JSONObject) (obj3)).has("streamLimiting")) goto _L12; else goto _L13
_L13:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        obj3 = ((JSONObject) (obj3)).getJSONObject("streamLimiting");
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        (new EPSDKPrefs()).putField("config", "streamLimiting", ((JSONObject) (obj3)).toString());
_L4:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        sendBroadcast("com.espn.action.CONFIG_AFFILIATE_UPDATE");
        if (inputstream2 == null)
        {
            break MISSING_BLOCK_LABEL_840;
        }
        inputstream2.close();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_850;
        }
        ((HttpURLConnection) (obj2)).disconnect();
_L15:
        return;
_L2:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        ((StringBuilder) (obj4)).append((new StringBuilder(String.valueOf(s))).append("\n").toString());
        continue; /* Loop/switch isn't completed */
_L16:
        Utils.sdkLog("unable to map affiliate code", 5, ((Exception) (obj2)));
        obj1 = obj;
        inputstream1 = inputstream;
        sendBroadcast("com.espn.action.CONFIG_AFFILIATE_UPDATE_ERROR");
        if (inputstream == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inputstream.close();
        if (obj == null) goto _L15; else goto _L14
_L14:
        try
        {
            ((HttpURLConnection) (obj)).disconnect();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Utils.sdkLog("unable to map affiliate code", 5, ((Exception) (obj)));
        }
        return;
_L12:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        try
        {
            (new EPSDKPrefs()).putField("config", "streamLimiting", "");
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            obj1 = obj;
            inputstream1 = inputstream;
        }
        finally
        {
            if (inputstream1 == null) goto _L0; else goto _L0
        }
          goto _L16
        inputstream1.close();
        if (obj1 != null)
        {
            try
            {
                ((HttpURLConnection) (obj1)).disconnect();
            }
            catch (IOException ioexception1)
            {
                Utils.sdkLog("unable to map affiliate code", 5, ioexception1);
            }
        }
        throw obj;
_L10:
        obj = obj2;
        inputstream = inputstream2;
        obj1 = obj2;
        inputstream1 = inputstream2;
        (new EPSDKPrefs()).putField("analytics", "affiliateUrl", "");
        if (true) goto _L4; else goto _L17
_L17:
        IOException ioexception;
        ioexception;
        Utils.sdkLog("unable to map affiliate code", 5, ioexception);
        return;
        if (true) goto _L19; else goto _L18
_L18:
    }

    public void setMyEspnSWID(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            swid = s;
            return;
        }
    }

    public void setPlatformAndAppVersion(String s, String s1)
    {
        platform = s;
        appVersion = s1;
    }

    public void setPresspass(String s)
    {
        (new EPSDKPrefs()).putField("analytics", "affiliateId", s);
        (new EPSDKPrefs()).putBooleanField("analytics", "overwriteaffiliateID", false);
    }

    public void trackAdComplete(String s)
    {
        try
        {
            if (s.contains("TIT2"))
            {
                s = s.replace("ID3", "").split("\r");
                (new SendTrackingTask(TrackingType.AD_COMPLETE, mEPEvents, null)).execute(new String[] {
                    s[1]
                });
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Player tracking manager failed on Ad complete", 5, s);
        }
    }

    public void trackAdStart(byte abyte0[])
    {
        try
        {
            if ((new String(abyte0)).contains("TIT2"))
            {
                abyte0 = EPAdTrackingManager.extractTIT2Frame(abyte0, "TIT2");
                (new SendTrackingTask(TrackingType.AD_START, mEPEvents, null)).execute(new String[] {
                    abyte0
                });
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Utils.sdkLog("Player tracking manager failed on Ad start", 5, abyte0);
        }
    }

    protected void trackEventConcluded()
    {
        try
        {
            (new SendTrackingTask(TrackingType.EVENT_CONCLUDED, mEPEvents, null)).execute(new String[0]);
            cancelMilestoneping();
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on event concluded", 5, exception);
        }
    }

    public void trackMuteUnmute(boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        SendTrackingTask sendtrackingtask = new SendTrackingTask(TrackingType.MUTE, mEPEvents, null);
_L1:
        sendtrackingtask.execute(new String[0]);
        return;
        try
        {
            sendtrackingtask = new SendTrackingTask(TrackingType.UNMUTE, mEPEvents, null);
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on mute toggle", 5, exception);
            return;
        }
          goto _L1
    }

    public void trackVideoPause()
    {
        try
        {
            (new SendTrackingTask(TrackingType.VIDEO_PAUSE, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on video pause", 5, exception);
        }
    }

    public void trackVideoPlayFromPause()
    {
        try
        {
            (new SendTrackingTask(TrackingType.VIDEO_PLAY_FROM_PAUSE, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on video play from pause", 5, exception);
        }
    }

    public void trackVideoScrubbed()
    {
        try
        {
            (new SendTrackingTask(TrackingType.VIDEO_SCRUBBED, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on video scrubbed", 5, exception);
        }
    }

    protected void trackVideoStart()
    {
        try
        {
            if (callback != null)
            {
                trackVideoStart(callback.trackingParam(), null);
            }
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed trackVideoStart ping on programing change", 5, exception);
        }
    }

    public void trackVideoStart(String s, EPPlayerTrackingCallBack epplayertrackingcallback)
    {
        if (epplayertrackingcallback == null)
        {
            break MISSING_BLOCK_LABEL_9;
        }
        callback = epplayertrackingcallback;
        (new SendTrackingTask(TrackingType.VIDEO_START, mEPEvents, null)).execute(new String[] {
            s
        });
        mEPPlayerTrackingManager.timer = new Timer();
        timer.schedule(new Milestoneping(null), pingTime, pingTime);
        return;
        s;
        Utils.sdkLog("Player tracking manager failed on video start", 5, s);
        return;
    }

    public void trackVideoStop(String s)
    {
        try
        {
            (new SendTrackingTask(TrackingType.VIDEO_STOP, mEPEvents, null)).execute(new String[] {
                s
            });
            cancelMilestoneping();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Player tracking manager failed on video stop", 5, s);
        }
    }

    public void trackVodEnd()
    {
        try
        {
            (new SendTrackingTask(TrackingType.VOD_END, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on VOD end", 5, exception);
        }
    }

    public void trackVodMid()
    {
        try
        {
            (new SendTrackingTask(TrackingType.VOD_MID, mEPEvents, null)).execute(new String[0]);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Player tracking manager failed on VOD end", 5, exception);
        }
    }

    public void trackVodStart(EPEvents epevents, boolean flag, String s)
        throws Exception
    {
        if (epevents == null || s == null || s.trim().isEmpty())
        {
            throw new RuntimeException("Incorrect paramenter set");
        }
        try
        {
            setEventObj(epevents);
            isAuthenticated = flag;
            videoStartType = s;
            (new SendTrackingTask(TrackingType.VOD_START, mEPEvents, null)).execute(new String[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EPEvents epevents)
        {
            Utils.sdkLog("Player tracking manager failed on VOD start", 5, epevents);
        }
    }















}
