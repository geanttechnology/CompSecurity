// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.content.SharedPreferences;
import com.flurry.android.FlurryAgent;
import if;
import java.util.HashMap;
import java.util.Map;

public class StaticFlurryEvent
{

    public static String AdMobNativeAD = "AdMobNativeAD";
    public static String AdMobNativeAD_Click = "AdMobNativeAD_Click";
    public static String FBNativeAD = "FBNativeAD";
    public static String FBNativeAD_Click = "FBNativeAD_Click";
    public static String FBNativeIconAD = "FBNativeIconAD";
    public static String FBNativeIconAD_Click = "FBNativeIconAD_Click";
    public static String GDTNativeAD = "GDTNativeAD";
    public static String GDTNativeAD_Click = "GDTNativeAD_Click";
    public static String GDTNativeIconAD = "GDTNativeIconAD";
    public static String GDTNativeIconAD_Click = "GDTNativeIconAD_Click";
    public static final String PushMsgClickNotify = "PushMsgClickNotify";
    public static final String PushMsgClickNotify_Unique = "PushMsgClickNotify_Unique";
    public static final String PushMsgReceived = "push_message_received";
    public static final String PushMsgReceived_Unique = "push_message_received_Unique";
    public static final String PushMsgRegisteredSuccess = "push_registered_success";
    public static final String PushMsgRegisteredSuccess_Unique = "push_registered_success_Unique";
    public static final String PushMsgTryRegistered = "push_try_register";
    public static final String PushMsgTryRegistered_Unique = "push_try_register_Unique";
    public static final String PushMsgUploadSuccess_Unique = "push_upload_success_Unique";
    public static final String PushMsgUploadToken = "push_upload_token";
    public static final String PushMsgUploadTokenSuccess = "push_upload_token_success";
    public static final String PushMsgUploadToken_Unique = "push_upload_token_Unique";
    public static final String Push_Key = "pushkey";
    public static final String Push_Key_Unique = "pushkey_Unique";
    public static String SharePrefFlurryEvent = "SharePrefFlurryEvent";
    public static String TBNativeAD = "TBNativeAD";
    public static String TBNativeAD_Click = "TBNativeAD_Click";
    public static String TBNativeIconAD = "TBNativeIconAD";
    public static String TBNativeIconAD_Click = "TBNativeIconAD_Click";
    public static String adClicked = "adClicked";
    public static String adLoaded = "adLoadSucceed";
    public static String adLoadedFailed = "adLoadFailed";
    public static String adRequest = "adRequest";
    public static String adShown = "adShown";
    public static String key_ad_icon_click = "fotoableAdIconClick";
    public static String key_ad_icon_data = "fotoableAdIconData";
    public static String key_ad_icon_show = "fotoableAdIconShow";
    public static String key_ad_icon_show_unfilter = "fotoableAdIconShowUnFilter";
    public static String key_ad_imageLoadTimeCN = "fotoableAdImageLoadtimeCN";
    public static String key_ad_imageLoadTimeEN = "fotoableAdImageLoadtimeEN";
    public static String key_ad_imageRequest = "fotoableAdImageRequest";
    public static String key_ad_request = "fotoableAdRequest";
    public static String key_ad_wall_click = "fotoableAdWallClick";
    public static String key_ad_wall_data = "fotoableAdWallData";
    public static String key_ad_wall_show = "fotoableAdWallShow";

    public StaticFlurryEvent()
    {
    }

    private static boolean isEventExist(Context context, String s)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getSharedPreferences(SharePrefFlurryEvent, 0).getBoolean(s, false);
        }
    }

    public static void logADClickedEvent(Context context, String s)
    {
        context = if.a(if.g(context));
        HashMap hashmap = new HashMap();
        hashmap.put(s, context);
        FlurryAgent.logEvent("HomeNativeAD", hashmap);
    }

    public static void logADEventWithKV(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("HomeNativeAD", hashmap);
    }

    public static void logBannerEventWithKV(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("FotoBanner", hashmap);
    }

    public static void logEvent(String s)
    {
        FlurryAgent.logEvent(s);
    }

    public static void logEventKV(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent(s, hashmap);
    }

    public static void logEventWithParams(String s, Map map)
    {
        FlurryAgent.logEvent(s, map);
    }

    public static void logFotoableADEvent(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("FotoableAd", hashmap);
    }

    public static void logGCMEventUnique(Context context, String s, String s1)
    {
        while (context == null || isEventExist(context, s1)) 
        {
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("GCMEvent", hashmap);
        setEventExist(context, s1);
    }

    public static void logGCMEventWithKV(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(s, s1);
        FlurryAgent.logEvent("GCMEvent", hashmap);
    }

    public static String logNativeAdRequestTimes(Context context, String s)
    {
        try
        {
            context = context.getSharedPreferences("nativeadrequesttime", 0);
            int i = context.getInt("iconnative", 0);
            int j = context.getInt("wallnative", 0);
            context = (new StringBuilder()).append("wall ").append(j).append(" icon ").append(i).toString();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "log error";
        }
        return context;
    }

    public static void recordNativeAdRequestTimes(Context context, boolean flag, boolean flag1)
    {
        int i;
        int j;
        try
        {
            context = context.getSharedPreferences("nativeadrequesttime", 0);
            i = context.getInt("iconnative", 0);
            j = context.getInt("wallnative", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        context.edit().putInt("iconnative", i + 1).apply();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        context.edit().putInt("wallnative", j + 1).apply();
    }

    private static void setEventExist(Context context, String s)
    {
        if (context == null)
        {
            return;
        } else
        {
            context = context.getSharedPreferences(SharePrefFlurryEvent, 0).edit();
            context.putBoolean(s, true);
            context.apply();
            return;
        }
    }

}
