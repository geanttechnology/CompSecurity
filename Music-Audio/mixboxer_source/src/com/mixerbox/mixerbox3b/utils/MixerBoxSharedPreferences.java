// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MixerBoxSharedPreferences
{

    private static final String DEFAULT_AUTHLOGINRESPONSE = "";
    private static final String DEFAULT_DEFAULTADDEDPLAYLISTID = "";
    private static final String DEFAULT_DEFAULTADDEDPLAYLISTNAME = "";
    private static final String DEFAULT_DISCOVERSYSTEMLISTRESPONSE = "";
    private static final String DEFAULT_DJSRESPONSE = "";
    private static final boolean DEFAULT_ENABLEBACKGROUNDPLAY = false;
    private static final String DEFAULT_FACEBOOKID = "";
    private static final String DEFAULT_FACEBOOKTOKEN = "";
    private static final String DEFAULT_FAQURL = "";
    private static final long DEFAULT_FIRSTLAUNCHTIME = 0L;
    private static final String DEFAULT_GCMID = "";
    private static final boolean DEFAULT_HASADDFROMDB = false;
    private static final boolean DEFAULT_HASDAYONE = true;
    private static final boolean DEFAULT_HASRATED = false;
    private static final boolean DEFAULT_HASSETLOCALNOTIFICATION = false;
    private static final boolean DEFAULT_HASSHOWNFAQ = false;
    private static final boolean DEFAULT_HIGHQUALITY = false;
    private static final String DEFAULT_LASTAD = "";
    private static final String DEFAULT_LOCALE = "";
    private static final String DEFAULT_MOBILEBUILDNUMBER = "";
    private static final int DEFAULT_NEWSFEEDREQUESTCOUNT = 0;
    private static final boolean DEFAULT_ONBOARDINGFINISH = false;
    private static final long DEFAULT_ONBOARDINGPLAYLISTID = 0L;
    private static final int DEFAULT_OPENTIMECOUNT = -1;
    private static final String DEFAULT_PACKAGENAME = "com.mixerbox.mixerbox3b";
    private static final int DEFAULT_PLAYERTYPE = 0;
    private static final int DEFAULT_PLAYSONGCOUNT = 0;
    private static final boolean DEFAULT_POSTFB = false;
    private static final int DEFAULT_PREVERSION = -1;
    private static final String DEFAULT_PREVIOUSADID = "";
    private static final int DEFAULT_SEARCHREQUESTCOUNT = 0;
    private static final boolean DEFAULT_SHOULDASKSYSTEMUPDATE = true;
    private static final boolean DEFAULT_SHOULDSENDLOCALNOTIFICATION = true;
    private static final boolean DEFAULT_SHOULDSENDSERVERNOTIFICATION = true;
    private static final boolean DEFAULT_SHOULDSHOWAD = false;
    private static final boolean DEFAULT_SHOULDSHOWONBOARDINGFINISH = false;
    private static final boolean DEFAULT_TIPFIRSTADDMUSIC = false;
    private static final boolean DEFAULT_TIPFIRSTARTIST = false;
    private static final boolean DEFAULT_TIPFIRSTDISCOVER = false;
    private static final boolean DEFAULT_TIPFIRSTEMPTYPLAYLIST = false;
    private static final boolean DEFAULT_TIPFIRSTNEWSFEED = false;
    private static final boolean DEFAULT_TIPFIRSTNONEMPTYPLAYLIST = false;
    private static final boolean DEFAULT_TIPFIRSTOTHERSPLAYLIST = false;
    private static final boolean DEFAULT_TIPFIRSTPLAY = false;
    private static final boolean DEFAULT_TIPFIRSTREORDER = false;
    private static final boolean DEFAULT_TIPFIRSTSEARCH = false;
    private static final boolean DEFAULT_TIPFIRSTSUBSCRIBE = false;
    private static final boolean DEFAULT_TIPSECONDPLAY = false;
    private static final boolean DEFAULT_TIPSECONDPLAYLIST = false;
    private static final boolean DEFAULT_TIPTHIRDPLAY = false;
    private static final String DEFAULT_USERID = "";
    private static final String DEFAULT_USERNAME = "";
    private static final int DEFAULT_USERTYPE = 0;
    private static final String DEFAULT_UUID = "";
    public static final String FILE_SETTING = "MY_SETTING";
    private static final String KEY_AUTHLOGINRESPONSE = "authloginresponse";
    private static final String KEY_DEFAULTADDEDPLAYLISTID = "defaultaddedplaylistid";
    private static final String KEY_DEFAULTADDEDPLAYLISTNAME = "defaultaddedplaylistname";
    private static final String KEY_DISCOVERSYSTEMLISTRESPONSE = "discoversystemlistresponse";
    private static final String KEY_DJSRESPONSE = "djsresponse";
    private static final String KEY_ENABLEBACKGROUNDPLAY = "enablebackgroundplay";
    private static final String KEY_FACEBOOKID = "facebookid";
    private static final String KEY_FACEBOOKTOKEN = "facebooktoken";
    private static final String KEY_FAQURL = "faqurl";
    private static final String KEY_FIRSTLAUNCHTIME = "firstlaunchtime";
    private static final String KEY_GCMID = "gcmid";
    private static final String KEY_HASADDFROMDB = "hasaddfromdb";
    private static final String KEY_HASDAYONE = "hasdayone";
    private static final String KEY_HASRATED = "hasrated";
    private static final String KEY_HASSETLOCALNOTIFICATION = "hassetlocalnotification";
    private static final String KEY_HASSHOWNFAQ = "hasshownfaq";
    private static final String KEY_HIGHQUALITY = "highquality";
    private static final String KEY_LASTAD = "lastad";
    private static final String KEY_LOCALE = "locale";
    private static final String KEY_MOBILEBUILDNUMBER = "mobilebuildnumber";
    private static final String KEY_NEWSFEEDREQUESTCOUNT = "newsfeedrequestcount";
    private static final String KEY_ONBOARDINGFINISH = "onboardingfinish";
    private static final String KEY_ONBOARDINGPLAYLISTID = "onboardingplaylistid";
    private static final String KEY_OPENTIMECOUNT = "opentimecount";
    private static final String KEY_PACKAGENAME = "packagename";
    private static final String KEY_PLAYERTYPE = "playertype";
    private static final String KEY_PLAYSONGCOUNT = "playsongcount";
    private static final String KEY_POSTFB = "postfb";
    private static final String KEY_PREVERSION = "preversion";
    private static final String KEY_PREVIOUSADID = "previousadid";
    private static final String KEY_SEARCHREQUESTCOUNT = "searchrequestcount";
    private static final String KEY_SHOULDASKSYSTEMUPDATE = "shouldasksystemupdate";
    private static final String KEY_SHOULDSENDLOCALNOTIFICATION = "shouldsendlocalnotification";
    private static final String KEY_SHOULDSENDSERVERNOTIFICATION = "shouldsendservernotification";
    private static final String KEY_SHOULDSHOWAD = "shouldshowad";
    private static final String KEY_SHOULDSHOWONBOARDINGFINISH = "shouldshowonboardingfinish";
    private static final String KEY_TIPFIRSTADDMUSIC = "tipfirstaddmusic";
    private static final String KEY_TIPFIRSTARTIST = "tipfirstartist";
    private static final String KEY_TIPFIRSTDISCOVER = "tipfirstdiscover";
    private static final String KEY_TIPFIRSTEMPTYPLAYLIST = "tipfirstemptyplaylist";
    private static final String KEY_TIPFIRSTNEWSFEED = "tipfirstnewsfeed";
    private static final String KEY_TIPFIRSTNONEMPTYPLAYLIST = "tipfirstnonemptyplaylist";
    private static final String KEY_TIPFIRSTOTHERSPLAYLIST = "tipfirstothersplaylist";
    private static final String KEY_TIPFIRSTPLAY = "tipfirstplay";
    private static final String KEY_TIPFIRSTPLAYHD = "tipfirstplayhd";
    private static final String KEY_TIPFIRSTPLAYLIST = "tipfirstplaylist";
    private static final String KEY_TIPFIRSTREORDER = "tipfirstreorder";
    private static final String KEY_TIPFIRSTSEARCH = "tipfirstsearch";
    private static final String KEY_TIPFIRSTSUBSCRIBE = "tipfirstsubscribe";
    private static final String KEY_TIPSECONDPLAY = "tipsecondplay";
    private static final String KEY_TIPSECONDPLAYLIST = "tipsecondplaylist";
    private static final String KEY_TIPTHIRDPLAY = "tipthirdplay";
    private static final String KEY_USERID = "userid";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USERTYPE = "usertype";
    private static final String KEY_UUID = "uuid";

    public MixerBoxSharedPreferences()
    {
    }

    public static void clearSharedPreferences(Context context)
    {
        Object obj = context.getSharedPreferences("MY_SETTING", 0);
        int i = ((SharedPreferences) (obj)).getInt("playertype", 0);
        context = ((SharedPreferences) (obj)).getString("mobilebuildnumber", "");
        String s = ((SharedPreferences) (obj)).getString("uuid", "");
        String s1 = ((SharedPreferences) (obj)).getString("gcmid", "");
        String s2 = ((SharedPreferences) (obj)).getString("packagename", "com.mixerbox.mixerbox3b");
        long l = ((SharedPreferences) (obj)).getLong("firstlaunchtime", 0L);
        int j = ((SharedPreferences) (obj)).getInt("preversion", -1);
        boolean flag = ((SharedPreferences) (obj)).getBoolean("hassetlocalnotification", false);
        boolean flag1 = ((SharedPreferences) (obj)).getBoolean("shouldshowad", false);
        boolean flag2 = ((SharedPreferences) (obj)).getBoolean("enablebackgroundplay", false);
        boolean flag3 = ((SharedPreferences) (obj)).getBoolean("hasdayone", true);
        boolean flag4 = ((SharedPreferences) (obj)).getBoolean("shouldsendlocalnotification", true);
        boolean flag5 = ((SharedPreferences) (obj)).getBoolean("shouldsendservernotification", true);
        int k = ((SharedPreferences) (obj)).getInt("usertype", 0);
        ((SharedPreferences) (obj)).edit().clear().commit();
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("playertype", i);
        ((android.content.SharedPreferences.Editor) (obj)).putString("mobilebuildnumber", context);
        ((android.content.SharedPreferences.Editor) (obj)).putInt("opentimecount", 0);
        ((android.content.SharedPreferences.Editor) (obj)).putString("uuid", s);
        ((android.content.SharedPreferences.Editor) (obj)).putString("gcmid", s1);
        ((android.content.SharedPreferences.Editor) (obj)).putString("packagename", s2);
        ((android.content.SharedPreferences.Editor) (obj)).putLong("firstlaunchtime", l);
        ((android.content.SharedPreferences.Editor) (obj)).putInt("preversion", j);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("hassetlocalnotification", flag);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("shouldshowad", flag1);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("enablebackgroundplay", flag2);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("onboardingfinish", true);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("hasdayone", flag3);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("shouldsendlocalnotification", flag4);
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("shouldsendservernotification", flag5);
        ((android.content.SharedPreferences.Editor) (obj)).putInt("usertype", k);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }

    public static String getAuthLoginResponse(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("authloginresponse", "");
    }

    public static String getDJsResponse(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("djsresponse", "");
    }

    public static String getDefaultAddedPlaylistId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("defaultaddedplaylistid", "");
    }

    public static String getDefaultAddedPlaylistName(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("defaultaddedplaylistname", "");
    }

    public static String getDiscoverSystemListResponse(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("discoversystemlistresponse", "");
    }

    public static boolean getEnableBackgroundPlay(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("enablebackgroundplay", false);
    }

    public static String getFAQUrl(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("faqurl", "");
    }

    public static String getFacebookId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("facebookid", "");
    }

    public static String getFacebookToken(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("facebooktoken", "");
    }

    public static long getFirstLaunchTime(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getLong("firstlaunchtime", 0L);
    }

    public static String getGCMId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("gcmid", "");
    }

    public static boolean getHasAddFromDB(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("hasaddfromdb", false);
    }

    public static boolean getHasDayOne(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("hasdayone", true);
    }

    public static boolean getHasRated(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("hasrated", false);
    }

    public static boolean getHasSetLocalNotification(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("hassetlocalnotification", false);
    }

    public static boolean getHasShownFAQ(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("hasshownfaq", false);
    }

    public static boolean getHighQuality(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("highquality", false);
    }

    public static String getLastAd(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("lastad", "");
    }

    public static String getLocale(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("locale", "");
    }

    public static String getMobileBuildNumber(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("mobilebuildnumber", "");
    }

    public static int getNewsfeedRequestCount(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("newsfeedrequestcount", 0);
    }

    public static boolean getOnboardingFinish(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("onboardingfinish", false);
    }

    public static long getOnboardingPlaylistId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getLong("onboardingplaylistid", 0L);
    }

    public static int getOpenTimeCount(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("opentimecount", -1);
    }

    public static String getPackageName(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("packagename", "com.mixerbox.mixerbox3b");
    }

    public static int getPlaySongCount(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("playsongcount", 0);
    }

    public static int getPlayerType(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("playertype", 0);
    }

    public static boolean getPostFB(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("postfb", false);
    }

    public static int getPreVersion(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("preversion", -1);
    }

    public static String getPreviousAdId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("previousadid", "");
    }

    public static int getSearchRequestCount(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("searchrequestcount", 0);
    }

    public static boolean getShouldAskSystemUpdate(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("shouldasksystemupdate", true);
    }

    public static boolean getShouldSendLocalNotification(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("shouldsendlocalnotification", true);
    }

    public static boolean getShouldSendServerNotification(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("shouldsendservernotification", true);
    }

    public static boolean getShouldShowAd(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("shouldshowad", false);
    }

    public static boolean getShouldShowOnboardingFinish(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("shouldshowonboardingfinish", false);
    }

    public static boolean getTipFirstAddMusic(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstaddmusic", false);
    }

    public static boolean getTipFirstArtist(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstartist", false);
    }

    public static boolean getTipFirstDiscover(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstdiscover", false);
    }

    public static boolean getTipFirstEmptyPlaylist(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstemptyplaylist", false);
    }

    public static boolean getTipFirstNewsfeed(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstnewsfeed", false);
    }

    public static boolean getTipFirstNonEmptyPlaylist(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstnonemptyplaylist", false);
    }

    public static boolean getTipFirstOthersPlaylist(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstothersplaylist", false);
    }

    public static boolean getTipFirstPlay(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstplay", false);
    }

    public static boolean getTipFirstReorder(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstreorder", false);
    }

    public static boolean getTipFirstSearch(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstsearch", false);
    }

    public static boolean getTipFirstSubscribe(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipfirstsubscribe", false);
    }

    public static boolean getTipSecondPlay(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipsecondplay", false);
    }

    public static boolean getTipSecondPlaylist(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipsecondplaylist", false);
    }

    public static boolean getTipThirdPlay(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getBoolean("tipthirdplay", false);
    }

    public static String getUUID(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("uuid", "");
    }

    public static String getUserId(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("userid", "");
    }

    public static String getUserName(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getString("username", "");
    }

    public static int getUserType(Context context)
    {
        return context.getSharedPreferences("MY_SETTING", 0).getInt("usertype", 0);
    }

    public static void putAuthLoginInfo(Context context, String s, String s1, String s2, String s3)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("userid", s);
        context.putString("facebookid", s3);
        context.putString("username", s1);
        context.putString("locale", s2);
        context.commit();
    }

    public static void putAuthLoginResponse(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("authloginresponse", s);
        context.commit();
    }

    public static void putDJsResponse(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("djsresponse", s);
        context.commit();
    }

    public static void putDefaultAddedPlaylist(Context context, String s, String s1)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("defaultaddedplaylistid", s);
        context.putString("defaultaddedplaylistname", s1);
        context.commit();
    }

    public static void putDiscoverSystemListResponse(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("discoversystemlistresponse", s);
        context.commit();
    }

    public static void putEnableBackgroundPlay(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("enablebackgroundplay", flag);
        context.commit();
    }

    public static void putFAQUrl(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("faqurl", s);
        context.commit();
    }

    public static void putFacebookToken(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("facebooktoken", s);
        context.commit();
    }

    public static void putFirstLaunchTime(Context context, long l)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putLong("firstlaunchtime", l);
        context.commit();
    }

    public static void putGCMId(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("gcmid", s);
        context.commit();
    }

    public static void putHasAddFromDB(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("hasaddfromdb", true);
        context.commit();
    }

    public static void putHasDayOne(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("hasdayone", flag);
        context.commit();
    }

    public static void putHasRated(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("hasrated", flag);
        context.commit();
    }

    public static void putHasSetLocalNotification(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("hassetlocalnotification", flag);
        context.commit();
    }

    public static void putHasShownFAQ(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("hasshownfaq", true);
        context.commit();
    }

    public static void putHighQuality(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("highquality", flag);
        context.commit();
    }

    public static void putLastAd(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("lastad", s);
        context.commit();
    }

    public static void putLocale(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("locale", s);
        context.commit();
    }

    public static void putMobileBuildNumber(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("mobilebuildnumber", s);
        context.commit();
    }

    public static void putNewsfeedRequestCount(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("newsfeedrequestcount", i);
        context.commit();
    }

    public static void putOnboardingFinish(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("onboardingfinish", flag);
        context.commit();
    }

    public static void putOnboardingPlaylistId(Context context, long l)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putLong("onboardingplaylistid", l);
        context.commit();
    }

    public static void putOpenTimeCount(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("opentimecount", i);
        context.commit();
    }

    public static void putPackageName(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("packagename", s);
        context.commit();
    }

    public static void putPlaySongCount(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("playsongcount", i);
        context.commit();
    }

    public static void putPlayerType(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("playertype", i);
        context.commit();
    }

    public static void putPostFB(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("postfb", flag);
        context.commit();
    }

    public static void putPreVersion(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("preversion", i);
        context.commit();
    }

    public static void putPreviousAdId(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("previousadid", s);
        context.commit();
    }

    public static void putSearchRequestCount(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("searchrequestcount", i);
        context.commit();
    }

    public static void putShouldAskSystemUpdate(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("shouldasksystemupdate", flag);
        context.commit();
    }

    public static void putShouldSendLocalNotification(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("shouldsendlocalnotification", flag);
        context.commit();
    }

    public static void putShouldSendServerNotification(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("shouldsendservernotification", flag);
        context.commit();
    }

    public static void putShouldShowAd(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("shouldshowad", flag);
        context.commit();
    }

    public static void putShouldShowOnboardingFinish(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("shouldshowonboardingfinish", flag);
        context.commit();
    }

    public static void putTipFirstAddMusic(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstaddmusic", flag);
        context.commit();
    }

    public static void putTipFirstArtist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstartist", flag);
        context.commit();
    }

    public static void putTipFirstDiscover(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstdiscover", flag);
        context.commit();
    }

    public static void putTipFirstEmptyPlaylist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstemptyplaylist", flag);
        context.commit();
    }

    public static void putTipFirstNewsfeed(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstnewsfeed", flag);
        context.commit();
    }

    public static void putTipFirstNonEmptyPlaylist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstnonemptyplaylist", flag);
        context.commit();
    }

    public static void putTipFirstOthersPlaylist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstothersplaylist", flag);
        context.commit();
    }

    public static void putTipFirstPlay(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstplay", flag);
        context.commit();
    }

    public static void putTipFirstPlayHD(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstplayhd", true);
        context.commit();
    }

    public static void putTipFirstPlaylist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstplaylist", flag);
        context.commit();
    }

    public static void putTipFirstReorder(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstreorder", true);
        context.commit();
    }

    public static void putTipFirstSearch(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstsearch", flag);
        context.commit();
    }

    public static void putTipFirstSubscribe(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipfirstsubscribe", flag);
        context.commit();
    }

    public static void putTipSecondPlay(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipsecondplay", true);
        context.commit();
    }

    public static void putTipSecondPlaylist(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipsecondplaylist", flag);
        context.commit();
    }

    public static void putTipThirdPlay(Context context, boolean flag)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("tipthirdplay", flag);
        context.commit();
    }

    public static void putUUID(Context context, String s)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putString("uuid", s);
        context.commit();
    }

    public static void putUserType(Context context, int i)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putInt("usertype", i);
        context.commit();
    }

    public static void setAllOnboardingFinish(Context context)
    {
        context = context.getSharedPreferences("MY_SETTING", 0).edit();
        context.putBoolean("onboardingfinish", true);
        context.putBoolean("tipfirstnewsfeed", true);
        context.putBoolean("tipfirstdiscover", true);
        context.putBoolean("tipsecondplaylist", true);
        context.putBoolean("tipfirstemptyplaylist", true);
        context.putBoolean("tipfirstothersplaylist", true);
        context.putBoolean("tipfirstsubscribe", true);
        context.putBoolean("tipfirstaddmusic", true);
        context.putBoolean("tipfirstnonemptyplaylist", true);
        context.putBoolean("tipfirstsearch", true);
        context.putBoolean("tipfirstartist", true);
        context.putBoolean("tipfirstplay", true);
        context.putBoolean("tipsecondplay", true);
        context.putBoolean("tipthirdplay", true);
        context.commit();
    }
}
