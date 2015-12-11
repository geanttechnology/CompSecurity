// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.api.Config;
import com.disney.datg.videoplatforms.sdk.models.api.GeoLocation;
import com.disney.datg.videoplatforms.sdk.service.ConfigAccessor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.springframework.http.ResponseEntity;

public class Configuration
{
    public static final class Environment extends Enum
    {

        private static final Environment $VALUES[];
        public static final Environment PRODUCTION;
        public static final Environment QA;
        String configService;

        public static Environment valueOf(String s)
        {
            return (Environment)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/Configuration$Environment, s);
        }

        public static Environment[] values()
        {
            return (Environment[])$VALUES.clone();
        }

        public String getService()
        {
            return configService;
        }

        static 
        {
            QA = new Environment("QA", 0, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%");
            PRODUCTION = new Environment("PRODUCTION", 1, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%");
            $VALUES = (new Environment[] {
                QA, PRODUCTION
            });
        }

        private Environment(String s, int i, String s1)
        {
            super(s, i);
            configService = s1;
        }
    }


    public static boolean ANALYTICS_ENABLED = true;
    public static int AUTHZ_TIMEOUT = 10;
    public static int LBS_REQUEST_TIMEOUT = 30;
    public static int LIVE_STREAM_AUTHZ_INTERVAL = 21600;
    public static int SERVICE_TIMEOUT = 10;
    public static boolean SLOGGER_ENABLED = true;
    public static Map networks = new HashMap() {

            
            {
                put("001", "abc");
                put("002", "abcf");
                put("004", "dc");
                put("008", "djr");
                put("009", "dxd");
            }
    };
    protected static Map partners = new HashMap() {

            
            {
                put("comcast", new _cls1());
                put("charter", new _cls2());
                put("att", new _cls3());
                put("verizon", new _cls4());
                put("dish", new _cls5());
                put("cox", new _cls6());
            }
    };
    public static String version = "1.0.0.9";
    private String currentApiKey;
    private Config currentConfig;
    private Environment currentEnvironment;
    private GeoLocation currentGeolocation;
    private String currentNetwork;
    private String currentPartnerCode;
    private String currentPartnerName;

    public Configuration()
    {
        currentNetwork = "";
        currentPartnerName = "";
        currentPartnerCode = "";
        currentApiKey = "";
        currentEnvironment = Environment.PRODUCTION;
        currentConfig = null;
        currentGeolocation = null;
    }

    private void setCurrentApiKey(String s)
    {
        currentApiKey = s;
    }

    private void setCurrentEnvironment(Environment environment)
    {
        currentEnvironment = environment;
    }

    private void setCurrentNetwork(String s)
    {
        currentNetwork = s;
    }

    private void setCurrentPartnerCode(String s)
    {
        currentPartnerCode = s;
    }

    private void setCurrentPartnerName(String s)
    {
        currentPartnerName = s;
    }

    public Config getCurrentConfig()
    {
        return currentConfig;
    }

    public String getCurrentNetwork()
    {
        return currentNetwork;
    }

    public String getCurrentPartnerCode()
    {
        return currentPartnerCode;
    }

    public String getCurrentPartnerName()
    {
        return currentPartnerName;
    }

    protected void initialize(String s, String s1)
        throws AndroidSDKException
    {
        if (android.os.Build.VERSION.SDK_INT < 15)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR, "API version of this device is not supported");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION, "invalid partner");
        }
        if (!partners.containsKey(s)) goto _L2; else goto _L1
_L1:
        setCurrentPartnerCode((new StringBuilder()).append("009_").append((String)((Map)partners.get(s)).get("partnerCode")).toString());
        setCurrentPartnerName(s);
        setCurrentApiKey((String)((Map)partners.get(s)).get("apiKey"));
        if (s.substring(Math.max(0, s.length() - 3), s.length()).contains("_qa"))
        {
            setCurrentEnvironment(Environment.QA);
            s.substring(0, Math.max(0, s.length() - 3));
        } else
        {
            setCurrentEnvironment(Environment.PRODUCTION);
        }
        if (TextUtils.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (!networks.containsKey(s1)) goto _L4; else goto _L3
_L3:
        setCurrentNetwork(s1);
_L6:
        s = new ConfigAccessor(currentEnvironment.getService().replace("%BRAND%", currentNetwork).replace("%PARTNER%", currentPartnerCode).replace("%APIKEY%", currentApiKey), null);
        java.util.Map.Entry entry;
        try
        {
            s = (ResponseEntity)s.getServiceAsync().get(SERVICE_TIMEOUT, TimeUnit.SECONDS);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR, s.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR, s.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_TIMEOUT, s.getCause());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR, s.getCause());
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CONFIG_SERVICE_ERROR);
_L2:
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION, "invalid partner");
_L4:
        if (!networks.containsValue(s1))
        {
            break MISSING_BLOCK_LABEL_391;
        }
        s = networks.entrySet().iterator();
_L8:
        if (!s.hasNext()) goto _L6; else goto _L5
_L5:
        entry = (java.util.Map.Entry)s.next();
        if (!((String)entry.getValue()).equals(s1)) goto _L8; else goto _L7
_L7:
        setCurrentNetwork((String)entry.getKey());
          goto _L6
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION, "invalid network");
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION, "invalid network");
        setCurrentConfig((Config)s.getBody());
        return;
    }

    protected void setCurrentConfig(Config config)
    {
        currentConfig = config;
    }

    public String toString()
    {
        return (new StringBuilder()).append("sdk: ").append(version).append(", env: ").append(currentEnvironment).append(", network: ").append(currentNetwork).append(", partner : ").append(currentPartnerName).append(", apikey: ").append(currentApiKey).append(", geo: ").append(currentGeolocation).toString();
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$1

/* anonymous class */
    class _cls1 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "21");
                put("apiKey", "gmb8wt9zecc3kgcqyc48dmwh");
            }
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$2

/* anonymous class */
    class _cls2 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "22");
                put("apiKey", "3msg9wn459hgdcy2kwq4bpba");
            }
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$3

/* anonymous class */
    class _cls3 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "23");
                put("apiKey", "d5vfuhhwyua754w89hkek3va");
            }
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$4

/* anonymous class */
    class _cls4 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "24");
                put("apiKey", "r2h395cxtz7rer37h67cnsjj");
            }
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$5

/* anonymous class */
    class _cls5 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "31");
                put("apiKey", "4rg3ht4ydjvd9f8jthsb227s");
            }
    }


    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/Configuration$2$6

/* anonymous class */
    class _cls6 extends HashMap
    {

        final _cls2 this$0;

            
            {
                this$0 = _cls2.this;
                super();
                put("partnerCode", "32");
                put("apiKey", "r3pryu9wnbptbvnhrz5y6e94");
            }
    }

}
