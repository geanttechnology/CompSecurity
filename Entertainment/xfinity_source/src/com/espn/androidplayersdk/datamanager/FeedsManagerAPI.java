// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsServerCom, EPSDKPrefs, ESPNPlayerSdk, EPSport, 
//            FeedsCommListener

class FeedsManagerAPI
{

    private static String BASE_CONFIG_URL = "";
    private static String BASE_ESPN_URL = "";
    protected static final String BASE_SUBCATEGORY_URL_EXT = "/listings?subcategories=";
    private static String BASE_VOD_URL = "";
    protected static final String SportId = "sportId";
    protected static final String eventMetaRelationType = "relationType";
    protected static final String eventType = "eventType";
    protected static final String eventTypeVOD = "VOD";
    protected static final String featuredCategoryEventType = "featuredCatEventType";
    protected static final String featuredTopSportEventType = "featuredTopSportEventType";
    protected static final String featuredType = "featuredType";
    protected static final String network = "network";
    private final String app;
    private final String format;
    FeedsCommListener mListener;
    private final String platform;
    FeedsServerCom serverCom;

    protected FeedsManagerAPI()
    {
        platform = "android";
        app = "ios_tablet";
        format = "json";
        serverCom = new FeedsServerCom();
        BASE_ESPN_URL = (new StringBuilder(String.valueOf(EPSDKPrefs.getApiUrl()))).append("/").toString();
        BASE_VOD_URL = EPSDKPrefs.getVODApiUrl();
        if (ESPNPlayerSdk.IS_QA)
        {
            BASE_CONFIG_URL = "http://broadband-qa.espn.go.com/";
            return;
        } else
        {
            BASE_CONFIG_URL = "http://espn.go.com/espn360/";
            return;
        }
    }

    protected FeedsManagerAPI(FeedsCommListener feedscommlistener)
    {
        this();
        mListener = feedscommlistener;
    }

    protected void getBestOfFeturedEvents(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_VOD_URL))).append("best-of?").append(EPSDKPrefs.getDeviceTypeParam()).append("&").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(14));
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getChannelFeed()
    {
        try
        {
            String s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("networks?").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Error: ", 5, exception);
        }
    }

    protected void getConfigFeed()
    {
        try
        {
            String s = (new StringBuilder(String.valueOf(BASE_CONFIG_URL))).append("configs/sdk?version=").append(ESPNPlayerSdk.SDK_VERSION_FOR_API).append("&platform=").append("android").append("&partner=").append(EPSDKPrefs.getApiPartnerName()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("Error: ", 5, exception);
        }
    }

    protected void getEventByGameId(String s)
    {
        String s1 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        if (Utils.isEmpty(s))
        {
            return;
        }
        try
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s1))).append("eventId=").append(s).toString()))).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getEventById(String s)
    {
        String s1 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        if (Utils.isEmpty(s))
        {
            return;
        }
        try
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s1))).append("id=").append(s).toString()))).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getEventsByChannelFeed(String s, String s1, String s2, String s3, String s4, String s5, HashMap hashmap)
    {
        HashMap hashmap1;
        String s6;
        try
        {
            s6 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        hashmap1 = new HashMap();
        hashmap = s6;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        hashmap = s6;
        if (!Utils.isEmpty(s))
        {
            hashmap = (new StringBuilder(String.valueOf(s6))).append("networks=").append(s).toString();
            hashmap1.put("network", s);
        }
        s = hashmap;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s = hashmap;
        if (!Utils.isEmpty(s1))
        {
            s = (new StringBuilder(String.valueOf(hashmap))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        s1 = s;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        s1 = s;
        if (!Utils.isEmpty(s2))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("&limit=").append(s2).toString();
        }
        s = s1;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        s = s1;
        if (!Utils.isEmpty(s3))
        {
            s = (new StringBuilder(String.valueOf(s1))).append("&offset=").append(s3).toString();
        }
        s1 = s;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (Utils.isEmpty(s4))
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (!Utils.isEmpty(s5))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("&dates=").append(s4).append("-").append(s5).toString();
        }
        s = (new StringBuilder(String.valueOf(s1))).append("&").append(EPSDKPrefs.getApiKey()).toString();
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getEventsByChannelSortedByLeagueFeed(String s, String s1, String s2, String s3, String s4, String s5, HashMap hashmap)
    {
        HashMap hashmap1;
        String s6;
        try
        {
            s6 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("categories/listings?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        hashmap1 = new HashMap();
        hashmap = s6;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        hashmap = s6;
        if (!Utils.isEmpty(s))
        {
            hashmap = (new StringBuilder(String.valueOf(s6))).append("networks=").append(s).toString();
            hashmap1.put("network", s);
        }
        s = hashmap;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s = hashmap;
        if (!Utils.isEmpty(s1))
        {
            s = (new StringBuilder(String.valueOf(hashmap))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        s1 = s;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        s1 = s;
        if (!Utils.isEmpty(s2))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("&limit=").append(s2).toString();
        }
        s = s1;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        s = s1;
        if (!Utils.isEmpty(s3))
        {
            s = (new StringBuilder(String.valueOf(s1))).append("&offset=").append(s3).toString();
        }
        s1 = s;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (Utils.isEmpty(s4))
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        s1 = s;
        if (!Utils.isEmpty(s5))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("&dates=").append(s4).append("-").append(s5).toString();
        }
        s = (new StringBuilder(String.valueOf(s1))).append("&").append(EPSDKPrefs.getApiKey()).toString();
        hashmap1.put("relationType", "8");
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getEventsBySportFeed(String s, String s1, String s2, String s3, String s4, String s5, HashMap hashmap)
    {
        Object obj;
        HashMap hashmap1;
        try
        {
            obj = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        hashmap1 = new HashMap();
        hashmap = ((HashMap) (obj));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        hashmap = ((HashMap) (obj));
        if (!Utils.isEmpty(s))
        {
            hashmap = (new StringBuilder(String.valueOf(obj))).append("categories=").append(s).toString();
        }
        obj = hashmap;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj = hashmap;
        if (!Utils.isEmpty(s1))
        {
            obj = (new StringBuilder(String.valueOf(hashmap))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        s1 = ((String) (obj));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        s1 = ((String) (obj));
        if (!Utils.isEmpty(s2))
        {
            s1 = (new StringBuilder(String.valueOf(obj))).append("&limit=").append(s2).toString();
        }
        s2 = s1;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        s2 = s1;
        if (!Utils.isEmpty(s3))
        {
            s2 = (new StringBuilder(String.valueOf(s1))).append("&offset=").append(s3).toString();
        }
        s2 = (new StringBuilder(String.valueOf(s2))).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        s1 = s2;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        s1 = s2;
        if (Utils.isEmpty(s4))
        {
            break MISSING_BLOCK_LABEL_330;
        }
        s1 = s2;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        s1 = s2;
        if (!Utils.isEmpty(s5))
        {
            s1 = (new StringBuilder(String.valueOf(s2))).append("&dates=").append(s4).append("-").append(s5).toString();
        }
        hashmap1.put("sportId", s);
        serverCom.execTask(s1, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getEventsBySportSortedByLeagueFeed(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            HashMap hashmap)
    {
        HashMap hashmap1;
        String s7;
        try
        {
            s7 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("categories/").append(s2).append("/listings?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        hashmap1 = new HashMap();
        s2 = s7;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s2 = s7;
        if (!Utils.isEmpty(s1))
        {
            s2 = (new StringBuilder(String.valueOf(s7))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        s1 = s2;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        s1 = s2;
        if (!Utils.isEmpty(s3))
        {
            s1 = (new StringBuilder(String.valueOf(s2))).append("&limit=").append(s3).toString();
        }
        s2 = s1;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        s2 = s1;
        if (!Utils.isEmpty(s4))
        {
            s2 = (new StringBuilder(String.valueOf(s1))).append("&offset=").append(s4).toString();
        }
        s2 = (new StringBuilder(String.valueOf(s2))).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        s1 = s2;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        s1 = s2;
        if (Utils.isEmpty(s5))
        {
            break MISSING_BLOCK_LABEL_291;
        }
        s1 = s2;
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        s1 = s2;
        if (!Utils.isEmpty(s6))
        {
            s1 = (new StringBuilder(String.valueOf(s2))).append("&dates=").append(s5).append("-").append(s6).toString();
        }
        hashmap1.put("sportId", s);
        hashmap1.put("relationType", "7");
        serverCom.execTask(s1, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getEventsForFeaturedCategory(String s, HashMap hashmap, String s1, String s2, String s3, String s4, String s5)
    {
        HashMap hashmap1;
        String s6;
        try
        {
            s6 = (new StringBuilder(String.valueOf(s))).append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(31));
        s = s6;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        s = s6;
        if (!Utils.isEmpty(s1))
        {
            s = (new StringBuilder(String.valueOf(s6))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        hashmap = s;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        hashmap = s;
        if (!Utils.isEmpty(s5))
        {
            hashmap = (new StringBuilder(String.valueOf(s))).append("&limit=").append(s5).toString();
        }
        s = hashmap;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        s = hashmap;
        if (!Utils.isEmpty(s4))
        {
            s = (new StringBuilder(String.valueOf(hashmap))).append("&offset=").append(s4).toString();
        }
        hashmap = s;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        hashmap = s;
        if (Utils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_266;
        }
        hashmap = s;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        hashmap = s;
        if (!Utils.isEmpty(s3))
        {
            hashmap = (new StringBuilder(String.valueOf(s))).append("&dates=").append(s2).append("-").append(s3).toString();
        }
        serverCom.execTask(hashmap, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getEventsForTopSport(String s, HashMap hashmap, String s1, String s2, String s3, String s4, String s5, 
            boolean flag)
    {
        {
            if (flag)
            {
                break MISSING_BLOCK_LABEL_290;
            }
            HashMap hashmap1;
            try
            {
                s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append(s).append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Error: ", 5, s);
                return;
            }
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(32));
        hashmap = s;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        hashmap = s;
        if (!Utils.isEmpty(s1))
        {
            hashmap = (new StringBuilder(String.valueOf(s))).append("&types=").append(s1).toString();
            hashmap1.put("eventType", s1);
        }
        s = hashmap;
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        s = hashmap;
        if (!Utils.isEmpty(s5))
        {
            s = (new StringBuilder(String.valueOf(hashmap))).append("&limit=").append(s5).toString();
        }
        hashmap = s;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        hashmap = s;
        if (!Utils.isEmpty(s4))
        {
            hashmap = (new StringBuilder(String.valueOf(s))).append("&offset=").append(s4).toString();
        }
        s = hashmap;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        s = hashmap;
        if (Utils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_273;
        }
        s = hashmap;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        s = hashmap;
        if (!Utils.isEmpty(s3))
        {
            s = (new StringBuilder(String.valueOf(hashmap))).append("&dates=").append(s2).append("-").append(s3).toString();
        }
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
        s = (new StringBuilder(String.valueOf(s))).append(EPSDKPrefs.getApiKey()).toString();
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_43;
        }
    }

    protected void getFeturedCategories(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("features?").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        hashmap1 = new HashMap();
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getFeturedEventsFeed(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings/top?").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(11));
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getFeturedEventsForCatagoryFeed(EPSport epsport, HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("/categories/").append(epsport.getAbbreviation()).append("/listings/top?").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (EPSport epsport)
        {
            Utils.sdkLog("Error: ", 5, epsport);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(16));
        hashmap1.put("sportId", epsport.getId());
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getFeturedEventsForE3Feed(int i, String s, HashMap hashmap)
    {
        String s1;
        try
        {
            s1 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings/top?networks=").append(s).append("&").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
        s = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = new HashMap();
        s.put("featuredType", Integer.valueOf(i));
        serverCom.execTask(s1, 1, 5, mListener, s);
        return;
    }

    protected void getLiveEventByNetworkId(String s)
    {
        String s1 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (Utils.isEmpty(s))
        {
            return;
        }
        try
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s1))).append("networks=").append(s).toString()))).append("&types=live").toString()))).append("&").append(EPSDKPrefs.getApiKey()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getLiveEventForLinearNetwork(String s)
    {
        String s1 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (Utils.isEmpty(s))
        {
            return;
        }
        try
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s1))).append("networks=").append(s).toString()))).append("&types=live").toString()))).append("&").append(EPSDKPrefs.getApiKey()).toString();
            serverCom.execTask(s, 1, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getLiveEventsFeed(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?types=live&enable=networksort&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        hashmap1 = new HashMap();
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getMaintianSessionResponse(String s)
    {
        try
        {
            serverCom.execTask(s, 2, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getMustSeeFeturedEvents(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_VOD_URL))).append("must-see?").append(EPSDKPrefs.getDeviceTypeParam()).append("&").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(13));
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getProgramingChangeResponse(String s)
    {
        try
        {
            serverCom.execTask(s, 2, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getSportsFeed(String s)
    {
        if (!s.equals("101"))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("categories?").append(EPSDKPrefs.getApiKey()).toString();
_L1:
        serverCom.execTask(s, 1, 5, mListener, null);
        return;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("categories/top?").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            return;
        }
          goto _L1
    }

    protected void getStartSessionResponse(String s)
    {
        try
        {
            serverCom.execTask(s, 2, 5, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void getTopVODFeturedEvents(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_VOD_URL))).append("top?").append(EPSDKPrefs.getDeviceTypeParam()).append("&").append(EPSDKPrefs.getApiKey()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(15));
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getTrendingFeturedEvents(HashMap hashmap)
    {
        HashMap hashmap1;
        String s;
        try
        {
            s = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("trending?").append(EPSDKPrefs.getDeviceTypeParam()).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            Utils.sdkLog("Error: ", 5, hashmap);
            return;
        }
        hashmap1 = hashmap;
        if (hashmap != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        hashmap1 = new HashMap();
        hashmap1.put("featuredType", Integer.valueOf(17));
        serverCom.execTask(s, 1, 5, mListener, hashmap1);
        return;
    }

    protected void getUserDataFeed(String s)
    {
        String s1;
        String s2 = "http://broadband.espn.go.com/espn3/auth/mobile/userData?app=ios_tablet&format=json";
        s1 = s2;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s1 = s2;
        if (!Utils.isEmpty(s))
        {
            s1 = (new StringBuilder(String.valueOf("http://broadband.espn.go.com/espn3/auth/mobile/userData?app=ios_tablet&format=json"))).append("&udid=").append(s).toString();
        }
        serverCom.execTask(s1, 1, 5, mListener, null);
        return;
        s;
        Utils.sdkLog("Error: ", 5, s);
        return;
    }

    protected void getXMLFeed(String s)
    {
        try
        {
            serverCom.execTask(s, 1, 6, mListener, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
        }
    }

    protected void searchFeed(String s, String s1, int i, int j, String s2, String s3)
    {
        String s4;
        String s5;
        try
        {
            s5 = (new StringBuilder(String.valueOf(BASE_ESPN_URL))).append("listings?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Utils.sdkLog("Error: ", 5, s);
            mListener.handleError(1);
            return;
        }
        s4 = s5;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        s4 = s5;
        if (!Utils.isEmpty(s))
        {
            s4 = (new StringBuilder(String.valueOf(s5))).append("keywords=").append(s).toString();
        }
        s = s4;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = s4;
        if (!Utils.isEmpty(s1))
        {
            s = (new StringBuilder(String.valueOf(s4))).append("&types=").append(s1).toString();
        }
        s1 = s;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        s1 = s;
        if (Utils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_180;
        }
        s1 = s;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        s1 = s;
        if (!Utils.isEmpty(s3))
        {
            s1 = (new StringBuilder(String.valueOf(s))).append("&dates=").append(s2).append("-").append(s3).toString();
        }
        s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(s1))).append("&limit=").append(i).toString()))).append("&offset=").append(j).toString()))).append("&").append(EPSDKPrefs.getApiKey()).append("&").append(EPSDKPrefs.getApinetworks()).toString();
        serverCom.execTask(s, 1, 5, mListener, null);
        return;
    }

}
