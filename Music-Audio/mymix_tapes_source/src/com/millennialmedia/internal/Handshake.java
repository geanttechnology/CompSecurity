// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.AssetManager;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.playlistserver.GreenServerAdapter;
import com.millennialmedia.internal.playlistserver.OrangeServerAdapter;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.IOUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Handshake
{
    public static class HandshakeInfo
    {

        public volatile String activePlaylistServerBaseUrl;
        public volatile String activePlaylistServerName;
        public volatile int clientMediationTimeout;
        public volatile String config;
        public volatile int exchangeTimeout;
        public volatile String handshakeBaseUrl;
        public volatile int handshakeTtl;
        public volatile int inlineTimeout;
        public volatile int interstitialExpirationDuration;
        public volatile int interstitialTimeout;
        public volatile int minInlineRefreshRate;
        public volatile int nativeExpirationDuration;
        public volatile int nativeTimeout;
        public volatile Map nativeTypeDefinitions;
        public volatile String reportingBaseUrl;
        public volatile int reportingBatchFrequency;
        public volatile int reportingBatchSize;
        public volatile boolean sdkEnabled;
        public volatile int serverToServerTimeout;
        public volatile int vastVideoSkipOffsetMax;
        public volatile int vastVideoSkipOffsetMin;
        public volatile String version;

        public HandshakeInfo()
        {
            sdkEnabled = true;
        }
    }

    public static class NativeTypeDefinition
    {

        public List componentDefinitions;
        public String typeName;

        public NativeTypeDefinition(String s)
        {
            componentDefinitions = new ArrayList();
            typeName = s;
        }
    }

    public static class NativeTypeDefinition.ComponentDefinition
    {

        public int adverstiserRequired;
        public String componentId;
        public int publisherRequired;

        public NativeTypeDefinition.ComponentDefinition(String s, int i, int j)
        {
            componentId = s;
            publisherRequired = i;
            adverstiserRequired = j;
        }
    }


    private static final int CLIENT_MEDIATION_TIMEOUT_FLOOR = 1000;
    private static final String DEFAULT_HANDSHAKE_BASE_URL = "https://ads.nexage.com";
    private static final String DEFAULT_HANDSHAKE_JSON = "mmadsdk/default_handshake.json";
    private static final int EXCHANGE_TIMEOUT_FLOOR = 1000;
    public static final String HANDSHAKE_JSON = "handshake.json";
    public static String HANDSHAKE_PATH = "/admax/sdk/handshake/1";
    private static final int HANDSHAKE_TTL_FLOOR = 60000;
    public static final String HANDSHAKE_VERSION = "1";
    private static final int INLINE_TIMEOUT_FLOOR = 3000;
    private static final int INTERSTITIAL_TIMEOUT_FLOOR = 3000;
    private static final int MAX_HANDSHAKE_ATTEMPTS = 10;
    private static final int MIN_INLINE_REFRESH_RATE_FLOOR = 10000;
    private static final int NATIVE_TIMEOUT_FLOOR = 3000;
    private static final int REPORTING_BATCH_FREQUENCY_FLOOR = 0x1d4c0;
    private static final int REPORTING_BATCH_SIZE_FLOOR = 1;
    private static final String SERVER_ADAPTER_KEY_GREEN = "green";
    private static final String SERVER_ADAPTER_KEY_ORANGE = "orange";
    private static final int SERVER_TO_SERVER_TIMEOUT_FLOOR = 1000;
    private static final String TAG = com/millennialmedia/internal/Handshake.getSimpleName();
    private static final int VAST_VIDEO_SKIP_OFFSET_FLOOR = 0;
    private static Map availableHandshakePlayListServerAdapters;
    private static HandshakeInfo currentHandshakeInfo;
    private static HandshakeInfo defaultHandshakeInfo;
    private static Map existingPackages;
    private static int handshakeAttempts = 0;
    private static boolean initialized = false;
    private static AtomicBoolean requestInProgress = new AtomicBoolean(false);
    private static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledRunnable = null;

    public Handshake()
    {
    }

    public static Class getActivePlayListServerAdapterClass()
    {
        Class class1 = (Class)availableHandshakePlayListServerAdapters.get(getActivePlaylistServerName());
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake active playlist server adapter class: ").append(class1).toString());
        }
        return class1;
    }

    public static String getActivePlaylistServerBaseUrl()
    {
        String s = getCurrentHandshakeInfo().activePlaylistServerBaseUrl;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake active playlist server base url: ").append(s).toString());
        }
        return s;
    }

    public static String getActivePlaylistServerName()
    {
        String s = getCurrentHandshakeInfo().activePlaylistServerName;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake playlist server name: ").append(s).toString());
        }
        return s;
    }

    public static int getClientMediationTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().clientMediationTimeout, 1000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake client mediation timeout: ").append(i).toString());
        }
        return i;
    }

    public static String getConfig()
    {
        String s = getCurrentHandshakeInfo().config;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake config: ").append(s).toString());
        }
        return s;
    }

    public static HandshakeInfo getCurrentHandshakeInfo()
    {
        if (currentHandshakeInfo != null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Returning current handshake info");
            }
            return currentHandshakeInfo;
        }
        if (defaultHandshakeInfo != null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Returning default handshake info");
            }
            return defaultHandshakeInfo;
        } else
        {
            return new HandshakeInfo();
        }
    }

    public static int getExchangeTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().exchangeTimeout, 1000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake exchange timeout: ").append(i).toString());
        }
        return i;
    }

    public static List getExistingIds()
    {
        ArrayList arraylist = new ArrayList();
        if (existingPackages != null)
        {
            Iterator iterator = existingPackages.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                if (Utils.isPackageAvailable((String)existingPackages.get(s)))
                {
                    arraylist.add(s);
                }
            }
        }
        return arraylist;
    }

    public static int getHandshakeTtl()
    {
        int i = Math.max(getCurrentHandshakeInfo().handshakeTtl, 60000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake handshake ttl: ").append(i).toString());
        }
        return i;
    }

    public static int getInlineTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().inlineTimeout, 3000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake inline timeout: ").append(i).toString());
        }
        return i;
    }

    public static int getInterstitialExpirationDuration()
    {
        int i = Math.max(getCurrentHandshakeInfo().interstitialExpirationDuration, 0);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake interstitial expiration: ").append(i).toString());
        }
        return i;
    }

    public static int getInterstitialTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().interstitialTimeout, 3000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake interstitial timeout: ").append(i).toString());
        }
        return i;
    }

    public static int getMinInlineRefreshRate()
    {
        int i = Math.max(getCurrentHandshakeInfo().minInlineRefreshRate, 10000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake min inline refresh rate: ").append(i).toString());
        }
        return i;
    }

    public static int getNativeExpirationDuration()
    {
        int i = Math.max(getCurrentHandshakeInfo().nativeExpirationDuration, 0);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake native expiration duration: ").append(i).toString());
        }
        return i;
    }

    public static int getNativeTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().nativeTimeout, 3000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake native timeout: ").append(i).toString());
        }
        return i;
    }

    public static NativeTypeDefinition getNativeTypeDefinition(String s)
    {
        NativeTypeDefinition nativetypedefinition = null;
        if (getCurrentHandshakeInfo().nativeTypeDefinitions != null)
        {
            nativetypedefinition = (NativeTypeDefinition)getCurrentHandshakeInfo().nativeTypeDefinitions.get(s);
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake native type definition: ").append(nativetypedefinition).toString());
        }
        return nativetypedefinition;
    }

    public static Map getNativeTypeDefinitions()
    {
        Map map = getCurrentHandshakeInfo().nativeTypeDefinitions;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake native type definitions: ").append(map).toString());
        }
        return map;
    }

    public static String getReportingBaseUrl()
    {
        String s = getCurrentHandshakeInfo().reportingBaseUrl;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake reporting base url: ").append(s).toString());
        }
        return s;
    }

    public static int getReportingBatchFrequency()
    {
        int i = Math.max(getCurrentHandshakeInfo().reportingBatchFrequency, 0x1d4c0);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake reporting batch frequency: ").append(i).toString());
        }
        return i;
    }

    public static int getReportingBatchSize()
    {
        int i = Math.max(getCurrentHandshakeInfo().reportingBatchSize, 1);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake reportingBatchSize: ").append(i).toString());
        }
        return i;
    }

    public static boolean getSdkEnabled()
    {
        boolean flag = getCurrentHandshakeInfo().sdkEnabled;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake sdk enabled: ").append(flag).toString());
        }
        return flag;
    }

    public static int getServerToServerTimeout()
    {
        int i = Math.max(getCurrentHandshakeInfo().serverToServerTimeout, 1000);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake server to server timeout: ").append(i).toString());
        }
        return i;
    }

    public static int getVASTVideoSkipOffsetMax()
    {
        int j = getCurrentHandshakeInfo().vastVideoSkipOffsetMax;
        int i = j;
        if (j < 0)
        {
            i = 0;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake VAST video max skip offset: ").append(i).toString());
        }
        return i;
    }

    public static int getVASTVideoSkipOffsetMin()
    {
        int j = getCurrentHandshakeInfo().vastVideoSkipOffsetMin;
        int i = j;
        if (j < 0)
        {
            i = 0;
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake VAST video min skip offset: ").append(i).toString());
        }
        return i;
    }

    public static String getVersion()
    {
        String s = getCurrentHandshakeInfo().version;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Handshake version: ").append(s).toString());
        }
        return s;
    }

    public static void initialize()
    {
        if (!initialized) goto _L2; else goto _L1
_L1:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Handshake already initialized");
        }
_L4:
        return;
_L2:
        Object obj;
        Object obj1;
        InputStream inputstream;
        Object obj3;
        Object obj4;
        Object obj5;
        initialized = true;
        availableHandshakePlayListServerAdapters = new HashMap();
        availableHandshakePlayListServerAdapters.put("green", com/millennialmedia/internal/playlistserver/GreenServerAdapter);
        availableHandshakePlayListServerAdapters.put("orange", com/millennialmedia/internal/playlistserver/OrangeServerAdapter);
        obj4 = null;
        obj5 = null;
        inputstream = null;
        obj = inputstream;
        obj1 = obj4;
        obj3 = obj5;
        if (!MMLog.isDebugEnabled())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        obj = inputstream;
        obj1 = obj4;
        obj3 = obj5;
        MMLog.d(TAG, "Loading packaged default handshake");
        obj = inputstream;
        obj1 = obj4;
        obj3 = obj5;
        inputstream = EnvironmentUtils.getApplicationContext().getAssets().open("mmadsdk/default_handshake.json");
        obj = inputstream;
        obj1 = inputstream;
        obj3 = inputstream;
        defaultHandshakeInfo = parseHandshake(IOUtils.read(inputstream, "UTF-8"));
        obj3 = inputstream;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        inputstream.close();
        obj = inputstream;
_L5:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Loading previously stored handshake");
        }
        obj1 = new FileInputStream(new File(EnvironmentUtils.getMillennialDir(), "handshake.json"));
        obj = obj1;
        currentHandshakeInfo = parseHandshake(IOUtils.read(((InputStream) (obj1)), "UTF-8"));
        obj = obj1;
        if (currentHandshakeInfo != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = obj1;
        MMLog.e(TAG, "Unable to create handshake info object");
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        try
        {
            ((InputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(TAG, "Could not close InputStream when reading handshake.json", ((Throwable) (obj)));
        }
        return;
        obj;
        MMLog.e(TAG, "Could not close InputStream when reading default handshake.", ((Throwable) (obj)));
        obj = inputstream;
          goto _L5
        obj1;
        obj3 = obj;
        MMLog.e(TAG, "Could not read default handshake.", ((Throwable) (obj1)));
        obj3 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        try
        {
            ((InputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            MMLog.e(TAG, "Could not close InputStream when reading default handshake.", ((Throwable) (obj1)));
        }
          goto _L5
        obj;
        obj3 = obj1;
        MMLog.e(TAG, "Could not parse the default handshake.", ((Throwable) (obj)));
        obj3 = obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_525;
        }
        ((InputStream) (obj1)).close();
        obj = obj1;
          goto _L5
        obj;
        MMLog.e(TAG, "Could not close InputStream when reading default handshake.", ((Throwable) (obj)));
        obj = obj1;
          goto _L5
        obj;
        if (obj3 != null)
        {
            try
            {
                ((InputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                MMLog.e(TAG, "Could not close InputStream when reading default handshake.", ((Throwable) (obj1)));
            }
        }
        throw obj;
        obj1;
        obj1 = obj;
_L11:
        obj = obj1;
        MMLog.i(TAG, "No handshake.json exists.");
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(TAG, "Could not close InputStream when reading handshake.json", ((Throwable) (obj)));
            }
            return;
        }
          goto _L4
        Object obj2;
        obj2;
        obj1 = obj;
_L10:
        obj = obj1;
        MMLog.e(TAG, "Could not read handshake.json", ((Throwable) (obj2)));
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(TAG, "Could not close InputStream when reading handshake.json", ((Throwable) (obj)));
            }
            return;
        }
          goto _L4
        obj2;
        obj1 = obj;
_L9:
        obj = obj1;
        MMLog.e(TAG, "Could not parse handshake.json", ((Throwable) (obj2)));
        if (obj1 == null) goto _L4; else goto _L6
_L6:
        try
        {
            ((InputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(TAG, "Could not close InputStream when reading handshake.json", ((Throwable) (obj)));
        }
        return;
        obj2;
        obj1 = obj;
        obj = obj2;
_L8:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                MMLog.e(TAG, "Could not close InputStream when reading handshake.json", ((Throwable) (obj1)));
            }
        }
        throw obj;
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
          goto _L9
        obj2;
          goto _L10
        obj;
          goto _L11
        obj = obj3;
          goto _L5
    }

    private static Map loadNativeAdConfig(JSONObject jsonobject)
        throws JSONException
    {
        Object obj = null;
        JSONObject jsonobject1 = jsonobject.getJSONObject("nativeConfig").optJSONObject("typeDefs");
        jsonobject = obj;
        if (jsonobject1 != null)
        {
            HashMap hashmap = new HashMap();
            Iterator iterator = jsonobject1.keys();
            do
            {
                jsonobject = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                jsonobject = (String)iterator.next();
                JSONObject jsonobject2 = jsonobject1.getJSONObject(jsonobject);
                NativeTypeDefinition nativetypedefinition = new NativeTypeDefinition(jsonobject2.getString("name"));
                jsonobject2 = jsonobject2.getJSONObject("components");
                String s;
                JSONObject jsonobject3;
                for (Iterator iterator1 = jsonobject2.keys(); iterator1.hasNext(); nativetypedefinition.componentDefinitions.add(new NativeTypeDefinition.ComponentDefinition(s, jsonobject3.getInt("publisherRequired"), jsonobject3.getInt("advertiserRequired"))))
                {
                    s = (String)iterator1.next();
                    jsonobject3 = jsonobject2.getJSONObject(s);
                }

                hashmap.put(jsonobject, nativetypedefinition);
            } while (true);
        }
        return jsonobject;
    }

    private static HandshakeInfo parseHandshake(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Parsing handshake:\n").append(s).toString());
        }
        Object obj = null;
        if (s != null)
        {
            obj = new JSONObject(s);
            s = new HandshakeInfo();
            s.version = ((JSONObject) (obj)).getString("ver");
            if (!((HandshakeInfo) (s)).version.equals("1"))
            {
                MMLog.e(TAG, "Handshake response does not match requested version");
                return null;
            }
            s.config = ((JSONObject) (obj)).getString("config");
            JSONObject jsonobject = ((JSONObject) (obj)).getJSONObject("playlistServer");
            s.activePlaylistServerName = jsonobject.getString("name");
            s.activePlaylistServerBaseUrl = jsonobject.getString("baseUrl");
            s.handshakeBaseUrl = ((JSONObject) (obj)).getString("handshakeBaseUrl");
            s.reportingBaseUrl = ((JSONObject) (obj)).getString("rptBaseUrl");
            s.handshakeTtl = ((JSONObject) (obj)).getInt("ttl");
            s.sdkEnabled = ((JSONObject) (obj)).optBoolean("sdkEnabled", true);
            s.reportingBatchSize = ((JSONObject) (obj)).getInt("rptBatchSize");
            s.reportingBatchFrequency = ((JSONObject) (obj)).getInt("rptFreq");
            s.inlineTimeout = ((JSONObject) (obj)).getInt("inlineTmax");
            s.interstitialTimeout = ((JSONObject) (obj)).getInt("instlTmax");
            s.nativeTimeout = ((JSONObject) (obj)).getInt("nativeTmax");
            s.clientMediationTimeout = ((JSONObject) (obj)).getInt("clientAdTmax");
            s.serverToServerTimeout = ((JSONObject) (obj)).getInt("serverAdTmax");
            s.exchangeTimeout = ((JSONObject) (obj)).getInt("exTmax");
            s.minInlineRefreshRate = ((JSONObject) (obj)).getInt("minInlineRefresh");
            s.interstitialExpirationDuration = ((JSONObject) (obj)).getInt("instlExpDur");
            s.nativeExpirationDuration = ((JSONObject) (obj)).getInt("nativeExpDur");
            s.vastVideoSkipOffsetMax = ((JSONObject) (obj)).getInt("vastSkipOffsetMax");
            s.vastVideoSkipOffsetMin = ((JSONObject) (obj)).getInt("vastSkipOffsetMin");
            s.nativeTypeDefinitions = loadNativeAdConfig(((JSONObject) (obj)));
            existingPackages = new HashMap();
            obj = ((JSONObject) (obj)).optJSONArray("exists");
            if (obj != null)
            {
                int i = 0;
                while (i < ((JSONArray) (obj)).length()) 
                {
                    JSONObject jsonobject1 = ((JSONArray) (obj)).optJSONObject(i);
                    if (jsonobject1 != null)
                    {
                        try
                        {
                            existingPackages.put(jsonobject1.getString("id"), jsonobject1.getString("pkg"));
                        }
                        catch (JSONException jsonexception) { }
                    }
                    i++;
                }
            }
            obj = s;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Handshake successfully parsed");
                obj = s;
            }
        }
        return ((HandshakeInfo) (obj));
    }

    public static void request(boolean flag)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Requesting handshake, async mode <").append(flag).append(">").toString());
        }
        if (flag)
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                public void run()
                {
                    Handshake.requestInternal();
                }

            });
            return;
        } else
        {
            requestInternal();
            return;
        }
    }

    private static void requestInternal()
    {
        int i;
        if (!requestInProgress.compareAndSet(false, true))
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Handshake request already in progress");
            }
            return;
        }
        i = 60000;
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonobject.put("ver", "1");
        jsonobject.put("sdkVer", "6.1.0-5323db4");
        jsonobject.put("os", "android");
        jsonobject.put("osv", android.os.Build.VERSION.RELEASE);
        jsonobject.put("appId", EnvironmentUtils.getApplicationContext().getPackageName());
        Object obj;
        Object obj1;
        obj1 = "https://ads.nexage.com";
        obj = obj1;
        if (currentHandshakeInfo == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = obj1;
        if (handshakeAttempts < 10)
        {
            obj = currentHandshakeInfo.handshakeBaseUrl;
        }
        obj = ((String) (obj)).concat(HANDSHAKE_PATH);
        handshakeAttempts++;
        obj1 = jsonobject.toString();
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Executing handshake request.\n\tattempt: ").append(handshakeAttempts).append("\n\turl: ").append(((String) (obj))).append("\n\tpost data: ").append(((String) (obj1))).toString());
        }
        obj = HttpUtils.getContentFromPostRequest(((String) (obj)), ((String) (obj1)), "application/json");
        if (((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).code != 200)
        {
            break MISSING_BLOCK_LABEL_594;
        }
        obj1 = ((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content;
        int j;
        int k;
        int l;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_594;
        }
        j = i;
        k = i;
        l = i;
        obj1 = parseHandshake(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content);
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        j = i;
        k = i;
        l = i;
        throw new Exception("Unable to create handshake info object");
        obj;
        MMLog.e(TAG, "An error occurred parsing the handshake response.  Reverting to last known good copy.", ((Throwable) (obj)));
        i = j;
_L3:
        try
        {
            if (scheduledRunnable != null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, "Canceling existing handshake refresh");
                }
                scheduledRunnable.cancel();
            }
            scheduledRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                public void run()
                {
                    Handshake.requestInternal();
                }

            }, i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MMLog.e(TAG, "Cannot build the handshake request data", ((Throwable) (obj)));
        }
        requestInProgress.set(false);
        return;
_L2:
        j = i;
        k = i;
        l = i;
        currentHandshakeInfo = ((HandshakeInfo) (obj1));
        j = i;
        k = i;
        l = i;
        obj1 = new FileOutputStream(new File(EnvironmentUtils.getMillennialDir(), "handshake.json"));
        IOUtils.write(((java.io.OutputStream) (obj1)), ((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).content);
        j = i;
        k = i;
        l = i;
        ((FileOutputStream) (obj1)).close();
_L4:
        j = i;
        k = i;
        l = i;
        i = getHandshakeTtl();
        j = i;
        k = i;
        l = i;
        handshakeAttempts = 0;
          goto _L3
        obj;
        MMLog.e(TAG, "Unable to open a file to store the handshake response.", ((Throwable) (obj)));
        i = k;
          goto _L3
        obj;
        j = i;
        k = i;
        l = i;
        MMLog.e(TAG, "Failed to close OutputStream when writing handshake response", ((Throwable) (obj)));
          goto _L4
        obj;
        MMLog.e(TAG, "Exception occurred when trying to load handshake.", ((Throwable) (obj)));
        i = l;
          goto _L3
        obj;
        MMLog.e(TAG, "Error storing handshake response", ((Throwable) (obj)));
        j = i;
        k = i;
        l = i;
        ((FileOutputStream) (obj1)).close();
          goto _L4
        obj;
        j = i;
        k = i;
        l = i;
        MMLog.e(TAG, "Failed to close OutputStream when writing handshake response", ((Throwable) (obj)));
          goto _L4
        obj;
        j = i;
        k = i;
        l = i;
        ((FileOutputStream) (obj1)).close();
_L5:
        j = i;
        k = i;
        l = i;
        throw obj;
        IOException ioexception;
        ioexception;
        j = i;
        k = i;
        l = i;
        MMLog.e(TAG, "Failed to close OutputStream when writing handshake response", ioexception);
          goto _L5
        MMLog.e(TAG, (new StringBuilder()).append("Handshake request failed with HTTP response code: ").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj)).code).toString());
          goto _L3
    }


}
