// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.graphics.Rect;
import android.location.Location;
import android.os.SystemClock;
import android.util.Log;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.TSAudioBitrate;
import com.targetspot.android.sdk.TSAudioFormat;
import com.targetspot.android.sdk.TSContentSize;
import com.targetspot.android.sdk.TSGender;
import com.targetspot.android.sdk.TSLocationType;
import com.targetspot.android.sdk.util.Base64;
import com.targetspot.android.sdk.util.HttpUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdLog, AdSegment, AdData, AdLink, 
//            WebException, AdBreak

public class WebService
{

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String ON_DEMAND_URI = "http://%s/tod.php?station=%s&userId=%s&companionWidth=%d&companionHeight=%d&mobile=1&flashEnabled=0&deliveryMethod=5&gender=%d&age=%d&adType=audio&preRoll=%d&logUnfilled=0&cacheBuster=%d&sdkVersion=%s&version=%s";
    private static final String PRODUCTION_HOST = "api.targetspot.com";
    private static final String SDK_VERSION = "1.1.89.03";
    private static final String TEST_HOST = "demo.targetspot.com";
    private static final String TOD_VERSION = "1.1";
    private static HashMap UNFILLEDAVAILS = new HashMap();
    private static final String UNFILLED_DATA = "USER=%s&STATION=%s&ADTYPE=audio&LENGTH=%d&FLASHENABLED=0&TSANALYTICS=0&MOBILE=1&METHOD=5";
    private static final String UNFILLED_URI = "http://%s/unfilled_log.php?data=%s&format=json";

    public WebService()
    {
    }

    public static String buildUnfilledUri(AdSettings adsettings, String s, int i, Location location, boolean flag, boolean flag1)
    {
        Object obj;
        if (flag1)
        {
            obj = "1";
        } else
        {
            obj = (new StringBuilder()).append("0").append(i).toString();
        }
        obj = (AdLog)UNFILLEDAVAILS.get(obj);
        if (obj != null)
        {
            adsettings = ((AdLog) (obj)).logUrl;
            Log.d("WebService", (new StringBuilder()).append("Unfilled Log url: ").append(adsettings).toString());
            return adsettings;
        }
        obj = String.format(Locale.US, "USER=%s&STATION=%s&ADTYPE=audio&LENGTH=%d&FLASHENABLED=0&TSANALYTICS=0&MOBILE=1&METHOD=5", new Object[] {
            s, adsettings.getTargetSpotStation(), Integer.valueOf(i)
        });
        static class _cls1
        {

            static final int $SwitchMap$com$targetspot$android$sdk$TSContentSize[];
            static final int $SwitchMap$com$targetspot$android$sdk$TSLocationType[];

            static 
            {
                $SwitchMap$com$targetspot$android$sdk$TSContentSize = new int[TSContentSize.values().length];
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeLarge.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeMedium.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSContentSize[TSContentSize.TSContentSizeSmall.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$targetspot$android$sdk$TSLocationType = new int[TSLocationType.values().length];
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationBestAvailable.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUseNetowrk.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationLastKnown.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationPostalCode.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$targetspot$android$sdk$TSLocationType[TSLocationType.TSLocationUnknown.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.targetspot.android.sdk.TSLocationType[adsettings.getLocationType().ordinal()];
        JVM INSTR tableswitch 1 4: default 156
    //                   1 291
    //                   2 291
    //                   3 291
    //                   4 356;
           goto _L1 _L2 _L2 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_356;
_L1:
        s = ((String) (obj));
_L4:
        location = s;
        if (!flag)
        {
            location = (new StringBuilder()).append(s).append("&IGNOREGEOIP=1").toString();
        }
        s = location;
        if ("1.1.89.03" != null)
        {
            s = location;
            if ("1.1.89.03".length() > 0)
            {
                s = (new StringBuilder()).append(location).append("&sdkVersion=1.1.89.03").toString();
            }
        }
        s = Base64.encodeBytes(s.getBytes());
        location = Locale.US;
        if (adsettings.isProductionMode())
        {
            adsettings = "api.targetspot.com";
        } else
        {
            adsettings = "demo.targetspot.com";
        }
        adsettings = String.format(location, "http://%s/unfilled_log.php?data=%s&format=json", new Object[] {
            adsettings, s
        });
        Log.d("WebService", (new StringBuilder()).append("Built Unfilled url: ").append(adsettings).toString());
        return adsettings;
_L2:
        s = ((String) (obj));
        if (location != null)
        {
            s = (new StringBuilder()).append(((String) (obj))).append("&LAT=").append(location.getLatitude()).toString();
            s = (new StringBuilder()).append(s).append("&LON=").append(location.getLongitude()).toString();
        }
          goto _L4
        s = ((String) (obj));
        if (adsettings.getPostalCode().length() > 0)
        {
            s = (new StringBuilder()).append(((String) (obj))).append("&ZIP=").append(adsettings.getPostalCode()).toString();
        }
          goto _L4
    }

    private static Rect getContentSize(TSContentSize tscontentsize)
    {
        _cls1..SwitchMap.com.targetspot.android.sdk.TSContentSize[tscontentsize.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 52
    //                   2 63;
           goto _L1 _L2 _L3
_L1:
        char c;
        char c1;
        c1 = '\264';
        c = '\226';
_L5:
        return new Rect(0, 0, c1, c);
_L2:
        c1 = '\u0168';
        c = '\u012C';
        continue; /* Loop/switch isn't completed */
_L3:
        c1 = '\u012C';
        c = '\372';
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static AdSegment parseAd(JSONObject jsonobject)
        throws JSONException, ParseException
    {
        String s2 = jsonobject.getString("id");
        String s3 = jsonobject.getString("acc");
        int j = jsonobject.getInt("order");
        String s4 = jsonobject.getString("duration");
        Log.d("WebService", (new StringBuilder()).append("TOD Response includes: Ad ").append(s2).append(" Duration ").append(s4).toString());
        String s = "";
        String s1 = "";
        Date date = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)).parse(jsonobject.getString("lastModified"));
        AdData addata = parseFile(jsonobject, "MediaFile");
        AdData addata1 = parseFile(jsonobject.getJSONObject("CompanionVisual").getJSONArray("MediaFile").getJSONObject(0), null);
        AdLink adlink = parseLink(jsonobject, "ClickThrough", "clickThroughLink");
        AdLink adlink1 = parseLink(jsonobject, "ClickDownload", "clickDownloadLink");
        JSONArray jsonarray = jsonobject.getJSONObject("Impression").getJSONArray("Log");
        AdLog aadlog[] = new AdLog[jsonarray.length()];
        for (int i = 0; i < jsonarray.length(); i++)
        {
            aadlog[i] = parseLog(jsonarray.getJSONObject(i), null);
        }

        if (jsonobject.has("MetaData"))
        {
            s = jsonobject.getJSONObject("MetaData").getString("CompanyName");
            s1 = jsonobject.getJSONObject("MetaData").getString("AdditionalInfo");
        }
        return new AdSegment(s2, s3, j, Integer.parseInt(s4), date, addata, addata1, adlink, adlink1, aadlog, s, s1);
    }

    private static AdData parseFile(JSONObject jsonobject, String s)
        throws JSONException
    {
        JSONObject jsonobject1 = jsonobject;
        if (s != null)
        {
            jsonobject1 = jsonobject.getJSONObject(s);
        }
        return new AdData(jsonobject1.getString("uri"), jsonobject1.getString("type"));
    }

    private static AdLink parseLink(JSONObject jsonobject, String s, String s1)
        throws JSONException
    {
        jsonobject = jsonobject.optJSONObject(s);
        if (jsonobject != null)
        {
            return new AdLink(jsonobject.getString(s1), parseLog(jsonobject, "Log"));
        } else
        {
            return null;
        }
    }

    private static AdLog parseLog(JSONObject jsonobject, String s)
        throws JSONException
    {
        JSONObject jsonobject1 = jsonobject;
        if (s != null)
        {
            jsonobject1 = jsonobject.getJSONObject(s);
        }
        return new AdLog(jsonobject1.getString("uri"), jsonobject1.getString("source"), jsonobject1.getString("event"));
    }

    private static List parseResponse(JSONObject jsonobject, boolean flag)
        throws WebException
    {
        Object obj;
        int ai[];
        Object obj1;
        Object obj2;
        Object obj3;
        int i;
        int j;
        try
        {
            obj = jsonobject.getJSONObject("TOD");
            obj1 = ((JSONObject) (obj)).optJSONArray("UnfilledAvails");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw jsonobject;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new WebException("Unable to parse ad data", jsonobject);
        }
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        i = 0;
_L3:
        if (i >= ((JSONArray) (obj1)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = ((JSONArray) (obj1)).getJSONObject(i);
        j = jsonobject.getInt("duration");
        obj2 = parseLog(jsonobject.getJSONObject("Log"), null);
        Log.d("WebService", (new StringBuilder()).append("UnfilledAvail - Duration: ").append(j).toString());
        obj3 = new StringBuilder();
        if (flag)
        {
            jsonobject = "1";
        } else
        {
            jsonobject = "0";
        }
        jsonobject = ((StringBuilder) (obj3)).append(jsonobject).append("").append(j).toString();
        UNFILLEDAVAILS.put(jsonobject, obj2);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        jsonobject = ((JSONObject) (obj)).optJSONObject("Error");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        i = jsonobject.getInt("errorCode");
        jsonobject = jsonobject.getString("description");
        Log.e("WebService", (new StringBuilder()).append("TOD error: ").append(jsonobject).append(" [").append(i).append("]").toString());
        throw new WebException((new StringBuilder()).append("Request ads error: ").append(jsonobject).toString(), i);
        obj1 = new ArrayList();
        obj2 = ((JSONObject) (obj)).getJSONObject("AdBreaks").getJSONArray("AdBreak");
        i = 0;
_L13:
        if (i >= ((JSONArray) (obj2)).length()) goto _L5; else goto _L4
_L4:
        jsonobject = new int[1];
        jsonobject[0] = -1;
        obj3 = ((JSONArray) (obj2)).getJSONObject(i).optJSONArray("Hours");
        if (obj3 == null) goto _L7; else goto _L6
_L6:
        ai = new int[((JSONArray) (obj3)).length()];
        j = 0;
_L9:
        if (j >= ((JSONArray) (obj3)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ai[j] = ((Integer)((JSONArray) (obj3)).get(j)).intValue();
        j++;
        if (true) goto _L9; else goto _L8
_L10:
        if (j >= ai.length)
        {
            break MISSING_BLOCK_LABEL_402;
        }
        jsonobject = (new StringBuilder()).append(jsonobject).append(ai[j]).append(" ").toString();
        j++;
          goto _L10
        jsonobject = jsonobject.trim();
        Log.d("WebService", (new StringBuilder()).append("Ad break ").append(i + 1).append(" (of ").append(((JSONArray) (obj2)).length()).append(")").append(" is valid during ").append(jsonobject).toString());
        jsonobject = ai;
_L7:
        jsonobject = new AdBreak(((JSONArray) (obj2)).getJSONObject(i).getInt("duration"), jsonobject);
        ai = ((JSONArray) (obj2)).getJSONObject(i).getJSONArray("Ad");
        j = 0;
_L12:
        if (j >= ai.length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject.addSegment(parseAd(ai.getJSONObject(j)));
        j++;
        if (true) goto _L12; else goto _L11
_L11:
        ((List) (obj1)).add(jsonobject);
        i++;
          goto _L13
_L5:
        return ((List) (obj1));
_L8:
        jsonobject = "";
        j = 0;
          goto _L10
    }

    public static List requestAds(AdSettings adsettings, String s, int i, boolean flag, TSContentSize tscontentsize, Location location, boolean flag1, String as[])
        throws WebException
    {
        Object obj = getContentSize(tscontentsize);
        Locale locale = Locale.US;
        String s1;
        int j;
        int l;
        int j1;
        int k1;
        int l1;
        if (adsettings.isProductionMode())
        {
            tscontentsize = "api.targetspot.com";
        } else
        {
            tscontentsize = "demo.targetspot.com";
        }
        s1 = adsettings.getTargetSpotStation();
        l = ((Rect) (obj)).width();
        j1 = ((Rect) (obj)).height();
        k1 = adsettings.getUserGender().getGender();
        l1 = adsettings.getUserAge();
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        obj = String.format(locale, "http://%s/tod.php?station=%s&userId=%s&companionWidth=%d&companionHeight=%d&mobile=1&flashEnabled=0&deliveryMethod=5&gender=%d&age=%d&adType=audio&preRoll=%d&logUnfilled=0&cacheBuster=%d&sdkVersion=%s&version=%s", new Object[] {
            tscontentsize, s1, s, Integer.valueOf(l), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf(l1), Integer.valueOf(j), Long.valueOf(SystemClock.uptimeMillis()), "1.1.89.03", 
            "1.1"
        });
        s = ((String) (obj));
        if (!adsettings.isManagedMode())
        {
            tscontentsize = ((TSContentSize) (obj));
            if (!adsettings.getAudioFormat().equals(TSAudioFormat.TSAudioDefault))
            {
                tscontentsize = (new StringBuilder()).append(((String) (obj))).append("&audioFormat=").append(adsettings.getAudioFormat()).toString();
            }
            s = tscontentsize;
            if (!adsettings.getAudioBitrate().equals(TSAudioBitrate.TSAudioBitrateDefault))
            {
                s = (new StringBuilder()).append(tscontentsize).append("&bitRate=").append(adsettings.getAudioBitrate().getAudioBitrate()).toString();
            }
        }
        if (i <= 0) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s).append("&length=").append(i).toString();
_L7:
        tscontentsize = s;
        if (!adsettings.isManagedMode())
        {
            tscontentsize = (new StringBuilder()).append(s).append("&metaData=1").toString();
        }
        s = tscontentsize;
        if (adsettings.isBackToBackMode())
        {
            s = (new StringBuilder()).append(tscontentsize).append("&b2b=1").toString();
        }
        tscontentsize = s;
        if (adsettings.getMaxNumAds() != -1)
        {
            tscontentsize = (new StringBuilder()).append(s).append("&maxNumAds=").append(adsettings.getMaxNumAds()).toString();
        }
        _cls1..SwitchMap.com.targetspot.android.sdk.TSLocationType[adsettings.getLocationType().ordinal()];
        JVM INSTR tableswitch 1 4: default 436
    //                   1 605
    //                   2 605
    //                   3 605
    //                   4 675;
           goto _L3 _L4 _L4 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_675;
_L3:
        s = tscontentsize;
_L9:
        tscontentsize = s;
        if (!flag1)
        {
            tscontentsize = (new StringBuilder()).append(s).append("&ignoreGeoIp=1").toString();
        }
        s = tscontentsize;
        if (as != null)
        {
            i = 0;
            do
            {
                s = tscontentsize;
                if (i >= as.length)
                {
                    break;
                }
                tscontentsize = (new StringBuilder()).append(tscontentsize).append("&fid[]=").append(as[i]).toString();
                i++;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_720;
_L2:
        int ai[];
        int k;
        ai = adsettings.getPlaybackLengths();
        k = ai.length;
        i = 0;
        tscontentsize = s;
_L8:
        s = tscontentsize;
        if (i >= k) goto _L7; else goto _L6
_L6:
        int i1 = ai[i];
        tscontentsize = (new StringBuilder()).append(tscontentsize).append("&length[]=").append(i1).toString();
        i++;
          goto _L8
_L4:
        s = tscontentsize;
        if (location != null)
        {
            s = (new StringBuilder()).append(tscontentsize).append("&lat=").append(location.getLatitude()).toString();
            s = (new StringBuilder()).append(s).append("&lon=").append(location.getLongitude()).toString();
        }
          goto _L9
        s = tscontentsize;
        if (adsettings.getPostalCode().length() > 0)
        {
            s = (new StringBuilder()).append(tscontentsize).append("&zip=").append(adsettings.getPostalCode()).toString();
        }
          goto _L9
        tscontentsize = s;
        if ((new Date()).getMinutes() >= 30)
        {
            tscontentsize = (new StringBuilder()).append(s).append("&nextHour=1").toString();
        }
        Log.d("WebService", (new StringBuilder()).append("Fetching ").append(tscontentsize).toString());
        try
        {
            s = HttpUtil.readJSONObject(tscontentsize);
        }
        // Misplaced declaration of an exception variable
        catch (AdSettings adsettings)
        {
            Log.d("WebService", (new StringBuilder()).append("Unable to download ad info: ").append(adsettings.getMessage()).toString());
            throw new WebException("Request ads failed", adsettings);
        }
        s = parseResponse(s, flag);
        Log.d("WebService", (new StringBuilder()).append("Ad info refreshed (Ad Breaks: ").append(s.size()).append(")").toString());
        location = s.iterator();
        do
        {
            if (!location.hasNext())
            {
                break;
            }
            as = (AdBreak)location.next();
            if (adsettings.getTestMode())
            {
                as.setTOD(tscontentsize);
            }
        } while (true);
        return s;
    }

    public static void submitImpressionLog(AdBreak adbreak)
        throws WebException
    {
        for (adbreak = adbreak.getSegments().iterator(); adbreak.hasNext();)
        {
            AdLog aadlog[] = ((AdSegment)adbreak.next()).getImpressionLog();
            int j = aadlog.length;
            int i = 0;
            while (i < j) 
            {
                submitImpressionLog(aadlog[i].getLogUrl());
                i++;
            }
        }

    }

    public static void submitImpressionLog(String s)
        throws WebException
    {
        Log.d("WebService", (new StringBuilder()).append("Logging ").append(s).toString());
        try
        {
            HttpUtil.readUrl(s, false);
            Log.d("WebService", "Logging request completed");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WebService", (new StringBuilder()).append("ClientProtocolException Unable to submit log: ").append(s.getMessage()).toString());
            throw new WebException("ClientProtocolException Log request failed", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WebService", (new StringBuilder()).append("IOException Unable to submit log: ").append(s.getMessage()).toString());
            throw new WebException("IOException Log request failed", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WebService", (new StringBuilder()).append("Unable to submit log: ").append(s.getMessage()).toString());
        }
        throw new WebException("Log request failed", s);
    }

    public static void submitUnfilledLog(String s)
        throws WebException
    {
        Log.d("WebService", (new StringBuilder()).append("Submitting ").append(s).toString());
        Object obj;
        int i;
        try
        {
            s = HttpUtil.readJSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.d("WebService", (new StringBuilder()).append("Unable to submit unfilled: ").append(s.getMessage()).toString());
            throw new WebException("Unfilled request failed", s);
        }
        obj = s.getJSONObject("UnfilledLogRequest");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        i = ((JSONObject) (obj)).getInt("ResultCode");
        s = ((JSONObject) (obj)).getString("Result");
        obj = ((JSONObject) (obj)).getString("ResultDescription");
        if (!s.equals("ERROR"))
        {
            break MISSING_BLOCK_LABEL_165;
        }
        Log.e("WebService", (new StringBuilder()).append("Unfilled error: ").append(((String) (obj))).append(" [").append(Integer.toString(i)).append("]").toString());
        return;
        try
        {
            Log.d("WebService", (new StringBuilder()).append("Unfilled result: ").append(s).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WebService", "Unable to parse unfilled result");
        }
        return;
    }

}
