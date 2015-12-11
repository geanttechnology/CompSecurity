// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics.slogger;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.analytics.IAdTracker;
import com.disney.datg.videoplatforms.sdk.analytics.IAuthZTracker;
import com.disney.datg.videoplatforms.sdk.analytics.ILinkTracker;
import com.disney.datg.videoplatforms.sdk.analytics.IMediaTracker;
import com.disney.datg.videoplatforms.sdk.analytics.ITrackable;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.media.Configuration;
import com.disney.datg.videoplatforms.sdk.media.VPGeolocation;
import com.disney.datg.videoplatforms.sdk.media.VPMedia;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliate;
import com.disney.datg.videoplatforms.sdk.models.api.Affiliates;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.models.api.User;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.CookieEnabledHttpRequestFactory;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics.slogger:
//            SloggerAccessor

public class SloggerTracker
    implements IAdTracker, IAuthZTracker, ILinkTracker, IMediaTracker
{

    public static Map networks = new HashMap() {

            
            {
                put("001", Integer.valueOf(com.disney.datg.videoplatforms.sdk.R.string.slogger_001));
                put("002", Integer.valueOf(com.disney.datg.videoplatforms.sdk.R.string.slogger_002));
                put("004", Integer.valueOf(com.disney.datg.videoplatforms.sdk.R.string.slogger_004));
                put("008", Integer.valueOf(com.disney.datg.videoplatforms.sdk.R.string.slogger_008));
                put("009", Integer.valueOf(com.disney.datg.videoplatforms.sdk.R.string.slogger_009));
            }
    };
    private Configuration configuration;

    public SloggerTracker(Activity activity, Configuration configuration1)
        throws Exception
    {
        if (configuration1 != null && configuration1.getCurrentConfig() != null)
        {
            setConfiguration(configuration1);
            return;
        } else
        {
            throw new Exception("configuration cannot be null");
        }
    }

    private Map getHeaders()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("Cookie", CookieEnabledHttpRequestFactory.getSWID());
        hashmap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hashmap.put("User-Agent", System.getProperty("http.agent"));
        return hashmap;
    }

    private Map getParams(ITrackable itrackable, String s, Context context)
    {
        Object obj;
        Object obj3;
        String s1;
        String s2;
        String s3;
        Object obj4;
        Object obj5;
        String s4;
        Object obj6;
        String s5;
        String s6;
        HashMap hashmap;
        Activity activity;
        activity = (Activity)context;
        hashmap = new HashMap();
        hashmap.put("appid", activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.slogger_app_id));
        obj3 = "phone";
        obj = obj3;
        if (context != null)
        {
            obj = obj3;
            if (((TelephonyManager)context.getSystemService("phone")).getPhoneType() == 0)
            {
                obj = "tablet";
            }
        }
        obj4 = activity.getPackageManager();
        s3 = activity.getPackageName();
        s2 = null;
        s1 = "";
        obj3 = s2;
        if (obj4 != null)
        {
            obj3 = s2;
            if (!TextUtils.isEmpty(s3))
            {
                try
                {
                    obj3 = ((PackageManager) (obj4)).getPackageInfo(s3, 0);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj3)
                {
                    LogUtils.logException(((Exception) (obj3)));
                    obj3 = s2;
                }
            }
        }
        if (obj3 != null)
        {
            s1 = ((PackageInfo) (obj3)).versionName;
        }
        hashmap.put("dinfo", activity.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.slogger_dinfo).replace("%DEVICE_TYPE%", ((CharSequence) (obj))).replace("%DEVICE_NAME%", Build.MODEL).replace("%DEVICE_VERSION%", Build.DISPLAY).replace("%OS_NAME%", "android").replace("%OS_VERSION%", android.os.Build.VERSION.RELEASE).replace("%APP_NAME%", s3).replace("%APP_VERSION%", s1));
        obj = configuration.getCurrentPartnerName();
        s4 = ((String) (obj));
        if (itrackable != null)
        {
            s4 = ((String) (obj));
            if (itrackable.getContextData() != null)
            {
                s4 = ((String) (obj));
                if (itrackable.getContextData().get("currentMVPDId") != null)
                {
                    s4 = (String)itrackable.getContextData().get("currentMVPDId");
                }
            }
        }
        if (!TextUtils.isEmpty(s4))
        {
            hashmap.put("mvp", s4);
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("currentMVPDGUID") != null)
        {
            obj = (String)itrackable.getContextData().get("currentMVPDGUID");
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                hashmap.put("mvpuid", obj);
            }
        }
        s1 = "";
        s2 = "0";
        s6 = "none";
        obj6 = null;
        obj3 = s1;
        s3 = s2;
        if (VPGeolocation.getGeolocationManager().getCurrentGeolocation() == null)
        {
            break MISSING_BLOCK_LABEL_411;
        }
        obj3 = s1;
        s3 = s2;
        obj6 = VPGeolocation.getGeolocationManager().getCurrentGeolocation();
        obj5 = s1;
        s5 = s6;
        obj4 = s2;
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_831;
        }
        obj3 = s1;
        s3 = s2;
        obj4 = ((GeoLocation) (obj6)).getAffiliates();
        obj = s1;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_654;
        }
        obj = s1;
        obj3 = s1;
        s3 = s2;
        if (((Affiliates) (obj4)).getAffiliates().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_654;
        }
        obj3 = s1;
        s3 = s2;
        obj = ((Affiliates) (obj4)).getAffiliates().iterator();
_L2:
        obj3 = s1;
        s3 = s2;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = s1;
        s3 = s2;
        obj4 = (Affiliate)((Iterator) (obj)).next();
        if (obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = s1;
        s3 = s2;
        if (TextUtils.isEmpty(((Affiliate) (obj4)).getId()))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = s1;
        s3 = s2;
        s1 = (new StringBuilder()).append(s1).append(((Affiliate) (obj4)).getId()).append(",").toString();
        if (true) goto _L2; else goto _L1
_L1:
        obj = s1;
        obj3 = s1;
        s3 = s2;
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_654;
        }
        obj3 = s1;
        s3 = s2;
        obj = s1.substring(0, s1.length() - 1);
        obj5 = obj;
        s5 = s6;
        obj4 = s2;
        obj3 = obj;
        s3 = s2;
        if (((GeoLocation) (obj6)).getUser() == null)
        {
            break MISSING_BLOCK_LABEL_831;
        }
        obj3 = obj;
        s3 = s2;
        obj6 = ((GeoLocation) (obj6)).getUser();
        s1 = s2;
        obj3 = obj;
        s3 = s2;
        if (((User) (obj6)).getProxy() == null)
        {
            break MISSING_BLOCK_LABEL_747;
        }
        s1 = s2;
        obj3 = obj;
        s3 = s2;
        if (!"".equals(((User) (obj6)).getProxy()))
        {
            s1 = "1";
        }
        obj5 = obj;
        s5 = s6;
        obj4 = s1;
        obj3 = obj;
        s3 = s1;
        if (((User) (obj6)).getZipCode() == null)
        {
            break MISSING_BLOCK_LABEL_831;
        }
        obj5 = obj;
        s5 = s6;
        obj4 = s1;
        obj3 = obj;
        s3 = s1;
        if ("".equals(((User) (obj6)).getZipCode()))
        {
            break MISSING_BLOCK_LABEL_831;
        }
        obj3 = obj;
        s3 = s1;
        s5 = ((User) (obj6)).getZipCode();
        obj4 = s1;
        obj5 = obj;
_L8:
        if (!TextUtils.isEmpty(((CharSequence) (obj5))))
        {
            hashmap.put("aff", obj5);
        }
        hashmap.put("aprx", obj4);
        hashmap.put("lbs", s5);
        hashmap.put("netw", Configuration.networks.get(getConfiguration().getCurrentNetwork()));
        hashmap.put("netw", activity.getResources().getString(((Integer)networks.get(getConfiguration().getCurrentNetwork())).intValue()));
        hashmap.put("cxntyp", ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName());
        hashmap.put("sdkver", android.os.Build.VERSION.RELEASE);
        Object obj1 = null;
        context = obj1;
        if (itrackable != null)
        {
            context = obj1;
            if (itrackable.getContextData() != null)
            {
                context = obj1;
                if (itrackable.getContextData().get("currentMedia") != null)
                {
                    Object obj2 = (VPMedia)itrackable.getContextData().get("currentMedia");
                    context = ((Context) (obj2));
                    if (obj2 != null)
                    {
                        context = ((VPMedia) (obj2)).getMediaType().getTypes();
                        static class _cls2
                        {

                            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[];

                            static 
                            {
                                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow = new int[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.values().length];
                                try
                                {
                                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.FREE.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                try
                                {
                                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.MARKET.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$AccessWindow[com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow.SUBSCRIPTION.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        int i;
                        if ("lf,es,mp".equals(context))
                        {
                            hashmap.put("ctyp", "lf");
                            context = ((Context) (obj2));
                        } else
                        {
                            hashmap.put("ctyp", context);
                            context = ((Context) (obj2));
                        }
                    }
                }
            }
        }
        if (context != null)
        {
            hashmap.put("cid", context.getMediaId());
        }
        if (!TextUtils.isEmpty(s4))
        {
            hashmap.put("accpt", s4);
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("errc") != null)
        {
            obj2 = (String)itrackable.getContextData().get("errc");
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                hashmap.put("errc", obj2);
            }
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("errmsg") != null)
        {
            obj2 = (String)itrackable.getContextData().get("errmsg");
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                hashmap.put("errmsg", obj2);
            }
        }
        if (itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("authzerror") != null)
        {
            obj2 = (String)itrackable.getContextData().get("authzerror");
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                hashmap.put("authzerror", obj2);
            }
        }
        if ("authz".equals(s) || context == null) goto _L4; else goto _L3
_L3:
        _cls2..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.AccessWindow[context.getAccessWindow().ordinal()];
        JVM INSTR tableswitch 1 3: default 1392
    //                   1 1615
    //                   2 1615
    //                   3 1631;
           goto _L5 _L6 _L6 _L7
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_1631;
_L4:
        if (!"authz".equals(s) && itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("authenticated") != null)
        {
            if (((Boolean)itrackable.getContextData().get("authenticated")).booleanValue())
            {
                hashmap.put("athu", "1");
            } else
            {
                hashmap.put("athu", "0");
            }
        }
        if (!"authz".equals(s) && itrackable != null && itrackable.getContextData() != null && itrackable.getContextData().get("position") != null)
        {
            i = ((Integer)itrackable.getContextData().get("position")).intValue();
            hashmap.put("cpos", (new StringBuilder()).append(i / 1000).append("").toString());
        }
        return hashmap;
        obj2;
        LogUtils.LOGD("SloggerTracker", ((AndroidSDKException) (obj2)).getMessage());
        obj5 = obj3;
        s5 = s6;
        obj4 = s3;
          goto _L8
_L6:
        hashmap.put("gt", "0");
          goto _L4
        hashmap.put("gt", "1");
          goto _L4
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }

    public String getName()
    {
        return "SLOGGER TRACKER";
    }

    public void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
    }

    public void track(String s, Map map, AsyncHandler asynchandler)
    {
        s = new SloggerAccessor(s, map, null);
        s.getServiceAsync().get(5L, TimeUnit.SECONDS);
_L2:
        return;
        s;
        if (asynchandler == null) goto _L2; else goto _L1
_L1:
        asynchandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR, s));
        return;
        s;
        if (asynchandler == null) goto _L2; else goto _L3
_L3:
        asynchandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR, s));
        return;
        s;
        s.printStackTrace();
        if (asynchandler != null)
        {
            asynchandler.onError(new AndroidSDKException(ErrorCode.ANDROID_SDK_SLOGGER_ERROR, s));
            return;
        }
          goto _L2
    }

    public void trackAdBreakEnd(ITrackable itrackable)
    {
    }

    public void trackAdBreakStart(ITrackable itrackable)
    {
    }

    public void trackAdEnd(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("ad1");
            LogUtils.LOGD(getName(), "trackAdEnd");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackAdEnd could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackAdError(ITrackable itrackable)
    {
    }

    public void trackAdFirstQuartile(ITrackable itrackable)
    {
    }

    public void trackAdMidpoint(ITrackable itrackable)
    {
    }

    public void trackAdStart(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("ad0");
            LogUtils.LOGD(getName(), "trackAdStart");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackAdStart could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackAdThirdQuartile(ITrackable itrackable)
    {
    }

    public void trackAuthZFailure(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("atz2");
            itrackable.addContext("authzerror", "AuthZFailure");
            LogUtils.LOGD(getName(), "trackAuthZFailure");
            trackLink(null, "authz", itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackAuthZFailure could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackAuthZStarted(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("atz0");
            trackLink(null, "authz", itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackAuthZStarted could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackAuthZSuccess(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("atz1");
            LogUtils.LOGD(getName(), "trackAuthZSuccess");
            trackLink(null, "authz", itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackAuthZSuccess could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackLink(String s, String s1, ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        Object obj;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        obj = itrackable.getContextData().get("activity");
        s = ((String) (obj));
        Iterator iterator;
        try
        {
            if (obj instanceof Fragment)
            {
                s = ((Fragment)obj).getActivity();
            }
            s = (Activity)s;
            itrackable = getParams(itrackable, s1, s);
            obj = getHeaders();
            s = (new StringBuilder()).append(s.getResources().getString(com.disney.datg.videoplatforms.sdk.R.string.slogger_url)).append("?").toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            LogUtils.LOGE(getName(), String.format("trackLink could not be executed : %s", new Object[] {
                s.getMessage()
            }));
            return;
        }
        s1 = s;
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        iterator = itrackable.keySet().iterator();
_L1:
        s1 = s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        s1 = (String)iterator.next();
        s = (new StringBuilder()).append(s).append(s1).append("=").append(URLEncoder.encode((String)itrackable.get(s1), "UTF-8")).append("&").toString();
          goto _L1
        track(s1, ((Map) (obj)), null);
    }

    public void trackMediaComplete(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("end1");
            LogUtils.LOGD(getName(), "trackMediaComplete");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaComplete could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaError(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("activity") != null && itrackable.getContextData().get("error") != null)
        {
            String s = (String)itrackable.getContextData().get("trackCode");
            String s1 = (String)itrackable.getContextData().get("error");
            itrackable.addContext("errc", s);
            itrackable.addContext("errmsg", s1);
            itrackable.addEvent("err0");
            LogUtils.LOGD(getName(), "trackMediaError");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaError could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaFirstQuarter(ITrackable itrackable)
    {
    }

    public void trackMediaForward(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("start5");
            LogUtils.LOGD(getName(), "trackMediaForward");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaForward could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaMidpoint(ITrackable itrackable)
    {
    }

    public void trackMediaPaused(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("stop0");
            LogUtils.LOGD(getName(), "trackMediaPaused");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaPaused could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaResumed(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        try
        {
            if (obj1 instanceof Fragment)
            {
                obj = ((Fragment)obj1).getActivity();
            }
            obj = (Activity)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ITrackable itrackable)
        {
            LogUtils.LOGE(getName(), String.format("trackMediaResumed could not be executed : %s", new Object[] {
                itrackable.getMessage()
            }));
            return;
        }
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("start4");
            LogUtils.LOGD(getName(), "trackMediaResumed");
            trackLink(null, null, itrackable);
        }
    }

    public void trackMediaRewind(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            if (itrackable.getContextData().get("10_sec_rewind") != null)
            {
                itrackable.addEvent("start7");
            }
            itrackable.addEvent("start6");
            LogUtils.LOGD(getName(), "trackMediaRewind");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaRewind could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaStarted(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        Object obj1;
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj1 = itrackable.getContextData().get("activity");
        Object obj = obj1;
        if (obj1 instanceof Fragment)
        {
            obj = ((Fragment)obj1).getActivity();
        }
        obj = (Activity)obj;
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("currentMedia") == null || (VPMedia)itrackable.getContextData().get("currentMedia") == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (itrackable.getContextData().get("start_video") == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        itrackable.addEvent("start3");
_L2:
        LogUtils.LOGD(getName(), "trackMediaStarted");
        trackLink(null, null, itrackable);
        return;
        itrackable.addEvent("start1");
        if (true) goto _L2; else goto _L1
_L1:
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaStarted could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
    }

    public void trackMediaStateUpdated(ITrackable itrackable)
    {
    }

    public void trackMediaStopped(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() == null || itrackable.getContextData().get("activity") == null || itrackable == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("currentMedia") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("stop1");
            LogUtils.LOGD(getName(), "trackMediaStopped");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackMediaStopped could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

    public void trackMediaThirdQuarter(ITrackable itrackable)
    {
    }

    public void trackPing(ITrackable itrackable)
    {
        if (itrackable == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (itrackable.getContextData() != null && itrackable.getContextData().get("activity") != null && (VPMedia)itrackable.getContextData().get("currentMedia") != null)
        {
            itrackable.addEvent("ping0");
            LogUtils.LOGD(getName(), "trackPing");
            trackLink(null, null, itrackable);
        }
        return;
        itrackable;
        LogUtils.LOGE(getName(), String.format("trackPing could not be executed : %s", new Object[] {
            itrackable.getMessage()
        }));
        return;
    }

}
