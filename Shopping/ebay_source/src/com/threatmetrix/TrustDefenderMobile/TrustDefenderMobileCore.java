// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.util.TimingLogger;
import android.view.WindowManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.threatmetrix.TrustDefenderMobile:
//            InternalStatusCode, BrowserInfo, InfoGatherer, TDID, 
//            DisplayWrapper, HttpParameterMap, TDConfiguration, StringUtils

class TrustDefenderMobileCore
{

    private static final String TAG = com/threatmetrix/TrustDefenderMobile/TrustDefenderMobileCore.getSimpleName();
    public static String version = "2.2-82";
    ArrayList customAttributes;
    String m_HTML5Cookie;
    private String m_api_key;
    private String m_browserStringFromJS;
    private BrowserInfo m_browser_info;
    private volatile AtomicBoolean m_cancel;
    TDConfiguration m_config;
    private Context m_context;
    String m_cookie;
    String m_deviceFingerprint;
    String m_deviceState;
    int m_dstDiff;
    String m_flashCookie;
    private String m_fontCount;
    private String m_fontHash;
    String m_fp_server;
    int m_gmtOffset;
    private String m_imei;
    Location m_location;
    int m_options;
    String m_org_id;
    String m_referrerURL;
    int m_screenHeight;
    int m_screenWidth;
    String m_session_id;
    private volatile InternalStatusCode m_status;
    private TimingLogger m_timings;
    String m_url;

    TrustDefenderMobileCore()
    {
        m_session_id = null;
        m_flashCookie = null;
        m_HTML5Cookie = null;
        m_cookie = null;
        m_gmtOffset = 0;
        m_dstDiff = 0;
        m_screenWidth = 0;
        m_screenHeight = 0;
        m_url = null;
        m_imei = null;
        m_fontHash = null;
        m_fontCount = null;
        m_referrerURL = null;
        m_deviceFingerprint = null;
        m_deviceState = null;
        m_options = 0;
        m_org_id = null;
        m_fp_server = null;
        m_location = null;
        customAttributes = null;
        m_config = null;
        m_context = null;
        m_api_key = null;
        m_timings = null;
        m_cancel = null;
        m_status = InternalStatusCode.THM_OK;
        m_browser_info = new BrowserInfo();
        m_browserStringFromJS = null;
    }

    void gatherInfo()
        throws InterruptedException
    {
        Log.d(TAG, "Getting timezone info");
        if ((m_options & 8) != 0)
        {
            InfoGatherer.TZInfo tzinfo = new InfoGatherer.TZInfo();
            if (InfoGatherer.getTimeZoneInfo(tzinfo))
            {
                m_dstDiff = tzinfo.dstDiff;
                m_gmtOffset = tzinfo.gmtOffset;
            }
            if (m_timings != null)
            {
                m_timings.addSplit("get time zone");
            }
        }
        if (m_cookie == null || m_flashCookie == null || m_HTML5Cookie == null)
        {
            String s;
            String s1;
            Object obj;
            Object obj1;
            boolean flag;
            if ((m_options & 0x200) != 0 && TDID.isDodgySerial())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s = null;
            obj1 = null;
            s1 = null;
            obj = null;
            if (m_cookie == null)
            {
                s = obj1;
                if (true)
                {
                    s = TDID.getAndroidID(m_context);
                }
                m_cookie = TDID.getCookie(s, flag);
            }
            if (m_timings != null)
            {
                m_timings.addSplit("cookie");
            }
            if (m_HTML5Cookie == null)
            {
                s1 = obj;
                if (true)
                {
                    s1 = TDID.getPref(m_context);
                }
                if (m_cancel != null && m_cancel.get())
                {
                    throw new InterruptedException();
                }
                m_HTML5Cookie = TDID.getHTML5Cookie(s1, flag);
            }
            if (m_timings != null)
            {
                m_timings.addSplit("LSC");
            }
            if (m_imei == null)
            {
                m_imei = TDID.getIMEI(m_context);
                if (m_timings != null)
                {
                    m_timings.addSplit("imei");
                }
            }
            if (m_flashCookie == null)
            {
                String s2 = s;
                if (s == null)
                {
                    s2 = TDID.getAndroidID(m_context);
                }
                s = s1;
                if (s1 == null)
                {
                    s = TDID.getPref(m_context);
                }
                if (m_cancel != null && m_cancel.get())
                {
                    throw new InterruptedException();
                }
                m_flashCookie = TDID.getFlashCookie(m_context, s2, s, m_imei, flag);
            }
            if (m_timings != null)
            {
                m_timings.addSplit("Flash");
            }
        }
        if (m_cancel != null && m_cancel.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if ((m_options & 0x10) != 0 && (m_screenHeight == 0 || m_screenWidth == 0))
        {
            DisplayWrapper displaywrapper = new DisplayWrapper(((WindowManager)m_context.getSystemService("window")).getDefaultDisplay());
            m_screenWidth = displaywrapper.getWidth();
            m_screenHeight = displaywrapper.getHeight();
        }
        if (m_timings != null)
        {
            m_timings.addSplit("get screen dimensions");
        }
        if (m_cancel != null && m_cancel.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        m_deviceState = InfoGatherer.getDeviceState();
        if (m_timings != null)
        {
            m_timings.addSplit("get device state");
        }
        if (m_cancel != null && m_cancel.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if (m_deviceFingerprint == null)
        {
            m_deviceFingerprint = InfoGatherer.getDeviceFingerprint(m_context, m_context);
        }
        if (m_timings != null)
        {
            m_timings.addSplit("get device fingerprint");
        }
    }

    TDConfiguration getConfig()
    {
        return m_config;
    }

    Map getConfigurationHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("User-Agent", m_browserStringFromJS);
        return hashmap;
    }

    HttpParameterMap getConfigurationParams()
    {
        HttpParameterMap httpparametermap = new HttpParameterMap();
        httpparametermap.add("org_id", m_org_id);
        httpparametermap.add("session_id", m_session_id);
        httpparametermap.add("os", "android");
        httpparametermap.add("osVersion", android.os.Build.VERSION.RELEASE);
        if (m_api_key != null && !m_api_key.isEmpty())
        {
            httpparametermap.add("api_key", m_api_key);
        }
        return httpparametermap;
    }

    String getConfigurationPath()
    {
        return (new StringBuilder()).append("https://").append(m_fp_server).append("/fp/mobile/conf").toString();
    }

    String getFPServer()
    {
        return m_fp_server;
    }

    HttpParameterMap getRiskBodyParameterMap()
        throws InterruptedException
    {
        Object obj;
        String s2;
        HttpParameterMap httpparametermap;
        int k;
        obj = InfoGatherer.checkURLs(m_context, m_config.jb_paths);
        k = ((List) (obj)).size();
        s2 = StringUtils.ListToSeperatedString(((List) (obj)), ";");
        if (m_timings != null)
        {
            m_timings.addSplit("Check URLs");
        }
        obj = "";
        if ((m_config.options & 0x100) != 0)
        {
            String s = InfoGatherer.getURLs(m_config.ex_paths);
            obj = s;
            if (m_timings != null)
            {
                m_timings.addSplit("get URLs");
                obj = s;
            }
        }
        if (m_fontCount == null || m_fontHash == null)
        {
            List list = InfoGatherer.getFontList();
            StringBuilder stringbuilder = new StringBuilder();
            for (Iterator iterator1 = list.iterator(); iterator1.hasNext(); stringbuilder.append((String)iterator1.next())) { }
            m_fontCount = String.valueOf(list.size());
            m_fontHash = StringUtils.MD5(stringbuilder.toString());
        }
        if (m_timings != null)
        {
            m_timings.addSplit("Get Fontlist");
        }
        httpparametermap = new HttpParameterMap();
        httpparametermap.setPostValueLengthLimit(255);
        httpparametermap.add("w", m_config.w);
        httpparametermap.add("c", String.valueOf(m_gmtOffset));
        httpparametermap.add("z", String.valueOf(m_dstDiff));
        httpparametermap.add("f", (new StringBuilder()).append(m_screenWidth).append("x").append(m_screenHeight).toString());
        httpparametermap.add("lh", m_url, true);
        httpparametermap.add("dr", m_referrerURL, true);
        if (!m_browser_info.getBrowserPluginCount().equals("0"))
        {
            httpparametermap.add("p", m_browser_info.getBrowserPlugins(), true);
            httpparametermap.add("pl", m_browser_info.getBrowserPluginCount(), true);
            httpparametermap.add("ph", m_browser_info.getBrowserPluginsFromJSHash(), true);
        }
        httpparametermap.add("hh", StringUtils.MD5((new StringBuilder()).append(m_org_id).append(m_session_id).toString()));
        if (m_browser_info.getMimeTypeCount() > 0)
        {
            httpparametermap.add("mt", m_browser_info.getMimeTypesHash());
            httpparametermap.add("mn", String.valueOf(m_browser_info.getMimeTypeCount()));
        }
        httpparametermap.add("mdf", m_deviceFingerprint, true);
        httpparametermap.add("mds", m_deviceState, true);
        httpparametermap.add("imei", m_imei, true);
        if (m_location != null)
        {
            httpparametermap.add("tdlat", String.valueOf(m_location.getLatitude()));
            httpparametermap.add("tdlon", String.valueOf(m_location.getLongitude()));
            httpparametermap.add("tdlacc", String.valueOf(m_location.getAccuracy()));
        }
        if (customAttributes == null || customAttributes.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        int i;
        i = 0;
        iterator = customAttributes.iterator();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        int j;
        String s3 = (String)iterator.next();
        StringBuilder stringbuilder1 = (new StringBuilder()).append("aca");
        j = i + 1;
        httpparametermap.add(stringbuilder1.append(i).toString(), s3, true);
        if (j < 5) goto _L4; else goto _L2
_L2:
        httpparametermap.add("la", (new StringBuilder()).append(m_config.w).append(m_HTML5Cookie).toString());
        httpparametermap.add("lq", m_browserStringFromJS);
        String s1 = Integer.toString((new Random()).nextInt(10000) + 10000);
        httpparametermap.add("nu", s1.substring(s1.length() - 4));
        httpparametermap.add("fc", (new StringBuilder()).append(m_config.w).append(m_flashCookie).toString());
        httpparametermap.add("ftsn", m_fontCount);
        httpparametermap.add("fts", m_fontHash, true);
        httpparametermap.add("v", android.os.Build.VERSION.RELEASE, true);
        httpparametermap.add("o", Build.BRAND, true);
        httpparametermap.add("mf", Build.MODEL, true);
        httpparametermap.add("l", Locale.getDefault().getLanguage(), true);
        httpparametermap.add("fg", m_flashCookie);
        httpparametermap.add("ls", m_HTML5Cookie);
        if (m_config.jb_paths.size() == 0)
        {
            s1 = "";
        } else
        {
            s1 = String.valueOf(k);
        }
        httpparametermap.add("gr", s1);
        httpparametermap.add("grr", s2);
        httpparametermap.add("at", "agent_mobile");
        httpparametermap.add("av", version);
        httpparametermap.add("ex3", ((String) (obj)));
        obj = new HttpParameterMap();
        ((HttpParameterMap) (obj)).add("org_id", m_org_id);
        ((HttpParameterMap) (obj)).add("session_id", m_session_id);
        if (m_timings != null)
        {
            m_timings.addSplit("params without xor");
        }
        s1 = httpparametermap.getUrlEncodedParamString();
        if (m_timings != null)
        {
            m_timings.addSplit("url encoding");
        }
        ((HttpParameterMap) (obj)).add("ja", StringUtils.xor(s1, m_session_id));
        ((HttpParameterMap) (obj)).add("h", "0").add("m", "2");
        if (m_timings != null)
        {
            m_timings.addSplit("Params xor'd");
        }
        return ((HttpParameterMap) (obj));
_L4:
        i = j;
        if (true) goto _L6; else goto _L5
_L5:
    }

    Map getRiskDataHeaders()
    {
        HashMap hashmap = new HashMap();
        if (m_browserStringFromJS != null && !m_browserStringFromJS.isEmpty())
        {
            Log.d(TAG, (new StringBuilder()).append("Setting User-Agent to ").append(m_browserStringFromJS).toString());
            hashmap.put("User-Agent", m_browserStringFromJS);
        }
        if (m_cookie == null)
        {
            hashmap.put("Cookie", "thx_guid=");
        } else
        {
            hashmap.put("Cookie", (new StringBuilder()).append("thx_guid=").append(m_cookie).toString());
        }
        hashmap.put("Referer", m_referrerURL);
        hashmap.put("Content-Type", "application/x-www-form-urlencoded");
        return hashmap;
    }

    String getSessionID()
    {
        return m_session_id;
    }

    void setBrowserStringFromJS(String s)
    {
        m_browserStringFromJS = s;
    }

    void setConfig(TDConfiguration tdconfiguration)
    {
        m_config = tdconfiguration;
    }

    void setContext(Context context)
    {
        m_context = context;
    }

    boolean setFPServer(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "h.online-metrix.net";
        }
        try
        {
            new URL((new StringBuilder()).append("https://").append(s1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, (new StringBuilder()).append("Invalid hostname ").append(s1).toString(), s);
            return false;
        }
        m_fp_server = s1;
        return true;
    }

    void setLocation(Location location)
    {
        m_location = location;
    }

    boolean setOrgID(String s)
    {
        if (s == null || s.length() != 8)
        {
            Log.e(TAG, "Invalid org_id");
            return false;
        } else
        {
            m_org_id = s;
            return true;
        }
    }

    boolean setProfileOptions(int i)
    {
        if ((i & 1) == 0)
        {
            Log.e(TAG, "Synchronous is deprecated, please switch to ASYNC");
            return false;
        } else
        {
            m_options = i;
            return true;
        }
    }

    void setSessionID(String s)
    {
        m_session_id = s;
    }

    boolean setURLS(String s, String s1)
    {
        String s2;
label0:
        {
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.isEmpty())
                {
                    break label0;
                }
            }
            s2 = "TrustDefenderMobileSDK";
        }
        m_referrerURL = (new StringBuilder()).append("http://").append(s2).toString();
        if (s != null && s.length() > 0)
        {
            m_url = s;
            if (s.compareToIgnoreCase(m_referrerURL) == 0)
            {
                m_url = (new StringBuilder()).append(s).append("mobile").toString();
            }
        } else
        {
            m_url = (new StringBuilder()).append("http://").append(s2).append("/mobile").toString();
        }
        return true;
    }

}
