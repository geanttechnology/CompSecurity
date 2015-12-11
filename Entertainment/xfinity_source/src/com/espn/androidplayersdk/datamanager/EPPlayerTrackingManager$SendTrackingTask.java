// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.espn.androidplayersdk.listenerinterface.EPPlayerTrackingCallBack;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPPlayerTrackingManager, Omniture, EPEvents, EPSDKPrefs

private class <init> extends AsyncTask
{

    private static int $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType[];
    EPEvents epEvents;
    ckingType mTrackingType;
    final EPPlayerTrackingManager this$0;

    static int[] $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()
    {
        int ai[] = $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[es().length];
        try
        {
            ai[OMPLETE.nal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            ai[TART.nal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            ai[_ATTEMPT.nal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            ai[_SUCCESS.nal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            ai[T_CONCLUDED.nal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            ai[AFFILIATE.nal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            ai[STONE.nal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            ai[.nal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            ai[TE.nal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            ai[O_PAUSE.nal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            ai[O_PLAY_FROM_PAUSE.nal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            ai[O_SCRUBBED.nal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            ai[O_START.nal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            ai[O_STOP.nal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            ai[END.nal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai[MID.nal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[START.nal()] = 15;
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
        $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()[mTrackingType.nal()];
        JVM INSTR tableswitch 3 17: default 238
    //                   3 84
    //                   4 103
    //                   5 109
    //                   6 115
    //                   7 124
    //                   8 135
    //                   9 146
    //                   10 157
    //                   11 168
    //                   12 179
    //                   13 192
    //                   14 205
    //                   15 214
    //                   16 230
    //                   17 222;
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
        Omniture omniture = getCommonOmniValues(EPPlayerTrackingManager.access$8(EPPlayerTrackingManager.this).trackingParam());
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
        if (EPPlayerTrackingManager.access$5() != null)
        {
            s1 = EPPlayerTrackingManager.access$5();
        } else
        {
            s1 = null;
        }
        omniture.eVar3 = s1;
        omniture.eVar11 = "watchespn Player";
        omniture.eVar17 = EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this);
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
        omniture.eVar53 = (new StringBuilder("watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).toString();
        omniture.eVar54 = (new StringBuilder("watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).append(":").append("na").toString();
        omniture.eVar55 = (new StringBuilder("watchespn Player:")).append(EPSDKPrefs.getAffiliateID()).toString();
        omniture.eVar56 = (new StringBuilder("watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).append(":").append(EPSDKPrefs.getAffiliateID()).toString();
        omniture.eVar57 = "watchespn Player:no league set";
        omniture.eVar58 = (new StringBuilder("watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).append(":").append("no league set").toString();
        omniture.eVar59 = (new StringBuilder("watchespn Player:")).append(epEvents.eventId).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
        omniture.eVar60 = (new StringBuilder("watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).append(":").append(epEvents.eventId).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
        omniture.eVar68 = (new StringBuilder(String.valueOf(EPSDKPrefs.getAffiliateID()))).append(":authenticated").toString();
        omniture.eVar71 = (new StringBuilder(String.valueOf(epEvents.getAiringId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
        omniture.prop2 = EPPlayerTrackingManager.access$2(EPPlayerTrackingManager.this);
        omniture.prop3 = omniture.eVar2;
        omniture.prop4 = omniture.eVar11;
        omniture.prop5 = (new StringBuilder("watchespn:watchespn Player:")).append(EPPlayerTrackingManager.access$9(EPPlayerTrackingManager.this)).toString();
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
        if (EPPlayerTrackingManager.access$7(EPPlayerTrackingManager.this) == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        s = (new DecimalFormat("#.####")).format(((double)(new Date()).getTime() - (double)EPPlayerTrackingManager.access$7(EPPlayerTrackingManager.this).getTime()) / 60000D);
        return s;
        Exception exception;
        exception;
        Utils.sdkLog("Unable to calculate beacon fired time", 5, exception);
        return "0";
    }

    void milestoneParam()
    {
        Omniture omniture = getCommonOmniValues(EPPlayerTrackingManager.access$8(EPPlayerTrackingManager.this).trackingParam());
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
        EPPlayerTrackingManager.access$6(EPPlayerTrackingManager.this, new Date());
    }

    String urlbuilder(Omniture omniture)
    {
        String s2 = EPPlayerTrackingManager.access$10();
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
        omniture = (new StringBuilder(String.valueOf(s2))).append("AQB=1&ndh=1&vid=").append(URLEncoder.encode(EPSDKPrefs.getUUID(), "UTF-8")).append("&t=").append(URLEncoder.encode(EPPlayerTrackingManager.access$11(EPPlayerTrackingManager.this), "UTF-8")).append(s).append(EPPlayerTrackingManager.access$12(EPPlayerTrackingManager.this)).toString();
        return omniture;
    }

    void videoEventParams(String s, String s1, String s2)
    {
        Omniture omniture = new Omniture();
        omniture.pe = "lnk_o";
        omniture.pev2 = s;
        omniture.linkID = s;
        omniture.eVar2 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getShowName()).append(":").append(epEvents.getType()).toString();
        if (EPPlayerTrackingManager.access$5() != null)
        {
            s = EPPlayerTrackingManager.access$5();
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
        if (epEvents == null || EPPlayerTrackingManager.access$0(EPPlayerTrackingManager.this) == null)
        {
            return;
        }
        Omniture omniture = new Omniture();
        omniture.pev2 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":video:start").toString();
        omniture.events = s;
        omniture.ch = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).toString();
        omniture.prop1 = "watchespn";
        omniture.eVar11 = (new StringBuilder("video:")).append(epEvents.getcoverageType()).toString();
        omniture.prop35 = "vod";
        omniture.prop4 = (new StringBuilder("video:")).append(epEvents.getcoverageType()).toString();
        omniture.eVar19 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":").append(epEvents.getSport()).toString();
        omniture.prop25 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":").append(epEvents.getSport()).toString();
        omniture.eVar21 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":").append(epEvents.getLeagueName()).toString();
        omniture.prop26 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":").append(epEvents.getLeagueName()).toString();
        omniture.prop2 = EPPlayerTrackingManager.access$2(EPPlayerTrackingManager.this);
        omniture.prop17 = "en";
        omniture.eVar9 = "en";
        omniture.prop47 = (new StringBuilder("watchespn:")).append(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)).append(":").append(EPPlayerTrackingManager.access$3(EPPlayerTrackingManager.this)).toString();
        omniture.prop48 = Integer.toString(android.os._fld8);
        if (EPPlayerTrackingManager.access$4(EPPlayerTrackingManager.this))
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
        if (EPPlayerTrackingManager.access$5() != null)
        {
            s = EPPlayerTrackingManager.access$5();
        } else
        {
            s = null;
        }
        omniture.eVar3 = s;
        omniture.prop3 = (new StringBuilder(String.valueOf(epEvents.getEventId()))).append(":").append(epEvents.getEventName()).toString();
        omniture.eVar16 = EPPlayerTrackingManager.access$0(EPPlayerTrackingManager.this);
        omniture.eVar20 = "";
        omniture.prop52 = (new StringBuilder(String.valueOf(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)))).append(":VOD").toString();
        omniture.eVar52 = (new StringBuilder(String.valueOf(EPPlayerTrackingManager.access$1(EPPlayerTrackingManager.this)))).append(":VOD").toString();
        omniture.prop45 = "VOD";
        omniture.eVar34 = "VOD";
        omniture.prop68 = omniture.eVar68;
        sendPingsToServer(urlbuilder(omniture));
    }

    private ( , EPEvents epevents)
    {
        this$0 = EPPlayerTrackingManager.this;
        super();
        mTrackingType = ;
        epEvents = epevents;
    }

    epEvents(epEvents epevents, EPEvents epevents1, epEvents epevents2)
    {
        this(epevents, epevents1);
    }
}
