// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.GpsHelper;

public class PlayServicesUrlRewriter
    implements com.mopub.volley.toolbox.HurlStack.UrlRewriter
{

    public static final String DO_NOT_TRACK_TEMPLATE = "mp_tmpl_do_not_track";
    private static final String IFA_PREFIX = "ifa:";
    public static final String UDID_TEMPLATE = "mp_tmpl_advertising_id";
    private final Context applicationContext;
    private final String deviceIdentifier;

    public PlayServicesUrlRewriter(String s, Context context)
    {
        deviceIdentifier = s;
        applicationContext = context.getApplicationContext();
    }

    public String rewriteUrl(String s)
    {
        if (!s.contains("mp_tmpl_advertising_id") && !s.contains("mp_tmpl_do_not_track"))
        {
            return s;
        }
        String s2 = "";
        com.mopub.common.GpsHelper.AdvertisingInfo advertisinginfo2 = new com.mopub.common.GpsHelper.AdvertisingInfo(deviceIdentifier, false);
        com.mopub.common.GpsHelper.AdvertisingInfo advertisinginfo = advertisinginfo2;
        String s1 = s2;
        if (GpsHelper.isPlayServicesAvailable(applicationContext))
        {
            com.mopub.common.GpsHelper.AdvertisingInfo advertisinginfo1 = GpsHelper.fetchAdvertisingInfoSync(applicationContext);
            advertisinginfo = advertisinginfo2;
            s1 = s2;
            if (advertisinginfo1 != null)
            {
                s1 = "ifa:";
                advertisinginfo = advertisinginfo1;
            }
        }
        s1 = s.replace("mp_tmpl_advertising_id", Uri.encode((new StringBuilder()).append(s1).append(advertisinginfo.advertisingId).toString()));
        if (advertisinginfo.limitAdTracking)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        return s1.replace("mp_tmpl_do_not_track", s);
    }
}
