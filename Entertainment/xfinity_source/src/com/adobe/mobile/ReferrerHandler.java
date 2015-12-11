// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Intent;
import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            MobileConfig, StaticMethods, RequestHandler, Lifecycle, 
//            AnalyticsWorker

final class ReferrerHandler
{

    static final String ACQUISITION_V3_TOKEN = "adb_acq_v3";
    static final String CONTEXT_DATA_KEY = "contextData";
    static final String REFERRER_FIELDS[] = {
        "utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign", "trackingcode"
    };
    private static boolean _referrerProcessed = true;

    ReferrerHandler()
    {
    }

    protected static String generateURLForV3(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        Object obj = MobileConfig.getInstance();
        stringbuilder.append(String.format("http://%s/v3/%s/end", new Object[] {
            ((MobileConfig) (obj)).getAcquisitionServer(), ((MobileConfig) (obj)).getAcquisitionAppId()
        }));
        obj = new StringBuilder(64);
        if (s != null && s.length() > 0)
        {
            ((StringBuilder) (obj)).append(String.format("?a_ugid=%s", new Object[] {
                StaticMethods.URLEncode(s)
            }));
        }
        if (s1 != null && s1.length() > 0)
        {
            if (((StringBuilder) (obj)).length() > 0)
            {
                s = "&";
            } else
            {
                s = "?";
            }
            ((StringBuilder) (obj)).append(s);
            ((StringBuilder) (obj)).append(String.format("a_cid=%s", new Object[] {
                StaticMethods.URLEncode(s1)
            }));
        }
        return stringbuilder.append(((CharSequence) (obj))).toString();
    }

    protected static String getReferrerDataFromV3Server(String s, String s1)
    {
        if (!MobileConfig.getInstance().mobileReferrerConfigured())
        {
            return null;
        }
        s = generateURLForV3(s, s1);
        StaticMethods.logDebugFormat("Analytics - Trying to fetch referrer data from (%s)", new Object[] {
            s
        });
        s = RequestHandler.retrieveData(s, null, MobileConfig.getInstance().getReferrerTimeout(), "Analytics");
        if (s == null)
        {
            return null;
        }
        try
        {
            s = new String(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Analytics - Unable to decode response(%s)", new Object[] {
                s.getLocalizedMessage()
            });
            return null;
        }
        return s;
    }

    protected static boolean getReferrerProcessed()
    {
        return _referrerProcessed;
    }

    protected static String getReferrerURLFromIntent(Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        StaticMethods.logWarningFormat("Analytics - Unable to process referrer due to an invalid intent parameter", new Object[0]);
_L4:
        return null;
_L2:
        if (!intent.getAction().equals("com.android.vending.INSTALL_REFERRER"))
        {
            StaticMethods.logDebugFormat("Analytics - Ignoring referrer due to the intent's action not being handled by analytics", new Object[0]);
            return null;
        }
        Object obj;
        try
        {
            obj = intent.getExtras();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        ((Bundle) (obj)).containsKey(null);
        intent = intent.getStringExtra("referrer");
        if (intent != null)
        {
            try
            {
                obj = URLDecoder.decode(intent, "UTF-8");
            }
            catch (Exception exception)
            {
                return intent;
            }
            return ((String) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected static void handleV1Acquisition(HashMap hashmap)
    {
        if (Lifecycle.lifecycleHasRun)
        {
            if (hashmap.containsKey("utm_source") && hashmap.containsKey("utm_campaign"))
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("a.referrer.campaign.source", hashmap.get("utm_source"));
                hashmap1.put("a.referrer.campaign.medium", hashmap.get("utm_medium"));
                hashmap1.put("a.referrer.campaign.term", hashmap.get("utm_term"));
                hashmap1.put("a.referrer.campaign.content", hashmap.get("utm_content"));
                hashmap1.put("a.referrer.campaign.name", hashmap.get("utm_campaign"));
                hashmap1.put("a.referrer.campaign.trackingcode", hashmap.get("trackingcode"));
                StaticMethods.getAnalyticsExecutor().execute(new Runnable(hashmap1) {

                    final HashMap val$referrerLifecycleContextData;

                    public void run()
                    {
                        Lifecycle.updateContextData(referrerLifecycleContextData);
                    }

            
            {
                referrerLifecycleContextData = hashmap;
                super();
            }
                });
                AnalyticsWorker.sharedInstance().kickWithReferrerData(hashmap1);
            }
            return;
        }
        android.content.SharedPreferences.Editor editor;
        String as[];
        int j;
        editor = StaticMethods.getSharedPreferencesEditor();
        as = REFERRER_FIELDS;
        j = as.length;
        int i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        s = as[i];
        if (hashmap.containsKey(s) && hashmap.get(s) != null)
        {
            editor.putString(s, hashmap.get(s).toString());
        }
        break MISSING_BLOCK_LABEL_228;
        try
        {
            editor.commit();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            StaticMethods.logErrorFormat("Analytics - Error persisting referrer data (%s)", new Object[] {
                hashmap.getMessage()
            });
        }
        _referrerProcessed = true;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static void handleV3Acquisition(HashMap hashmap)
    {
        hashmap = getReferrerDataFromV3Server((String)hashmap.get("utm_content"), StaticMethods.getAdvertisingIdentifier());
        if (Lifecycle.lifecycleHasRun)
        {
            hashmap = parseV3Response(hashmap);
            StaticMethods.getAnalyticsExecutor().execute(new Runnable(hashmap) {

                final HashMap val$contextData;

                public void run()
                {
                    Lifecycle.updateContextData(contextData);
                }

            
            {
                contextData = hashmap;
                super();
            }
            });
            AnalyticsWorker.sharedInstance().kickWithReferrerData(hashmap);
            return;
        }
        try
        {
            android.content.SharedPreferences.Editor editor = StaticMethods.getSharedPreferencesEditor();
            editor.putString("ADMS_Referrer_ContextData_Json_String", hashmap);
            editor.commit();
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            StaticMethods.logErrorFormat("Analytics - Error persisting referrer data (%s)", new Object[] {
                hashmap.getMessage()
            });
        }
        _referrerProcessed = true;
    }

    protected static boolean isV3Response(HashMap hashmap)
    {
        return "adb_acq_v3".equals(hashmap.get("utm_source")) && "adb_acq_v3".equals(hashmap.get("utm_campaign"));
    }

    protected static HashMap parseReferrerURLToMap(String s)
    {
        HashMap hashmap = new HashMap();
        s = s.split("&");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = s[i].split("=");
            if (as.length == 2)
            {
                hashmap.put(as[0], as[1]);
            }
        }

        return hashmap;
    }

    protected static HashMap parseV3Response(String s)
    {
        HashMap hashmap = new HashMap();
        if (s != null && s.length() != 0)
        {
            if (_referrerProcessed)
            {
                StaticMethods.logDebugFormat("Analytics - Acquisition referrer timed out", new Object[0]);
                return hashmap;
            }
            try
            {
                s = new JSONObject(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logDebugFormat("Analytics - Unable to parse response(%s)", new Object[] {
                    s.getLocalizedMessage()
                });
                return hashmap;
            }
            try
            {
                s = s.getJSONObject("contextData");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                StaticMethods.logDebugFormat("Analytics - Unable to parse acquisition service response (no contextData parameter in response)", new Object[0]);
                return hashmap;
            }
            if (s != null && s.has("a.referrer.campaign.name"))
            {
                for (Iterator iterator = s.keys(); iterator.hasNext();)
                {
                    String s1 = iterator.next().toString();
                    try
                    {
                        hashmap.put(s1, s.getString(s1));
                    }
                    catch (JSONException jsonexception)
                    {
                        StaticMethods.logDebugFormat("Analytics - Unable to parse acquisition service response (the value for %s is not a string)", new Object[] {
                            s1
                        });
                    }
                }

                StaticMethods.logDebugFormat("Analytics - Received Referrer Data(%s)", new Object[] {
                    hashmap.toString()
                });
                return hashmap;
            }
        }
        return hashmap;
    }

    public static void processIntent(Intent intent)
    {
        intent = getReferrerURLFromIntent(intent);
        if (intent == null || intent.length() == 0)
        {
            StaticMethods.logDebugFormat("Analytics - Ignoring referrer due to the intent's referrer string being empty", new Object[0]);
            return;
        }
        StaticMethods.logDebugFormat("Analytics - Received referrer information(%s)", new Object[] {
            intent
        });
        intent = parseReferrerURLToMap(intent);
        if (isV3Response(intent))
        {
            handleV3Acquisition(intent);
            return;
        } else
        {
            handleV1Acquisition(intent);
            return;
        }
    }

    protected static void setReferrerProcessed(boolean flag)
    {
        _referrerProcessed = flag;
    }

}
