// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            ContextData, MobileConfig, Lifecycle, VisitorIDService, 
//            RequestHandler, WearableFunctionBridge, AnalyticsTrackInternal

final class StaticMethods
{

    private static final String ADID_DPID = "20914";
    private static final String AID_JSON_ID_KEY = "id";
    private static final String APPID_KEY = "a.AppID";
    private static final char BYTE_TO_HEX[] = "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F202122232425262728292A2B2C2D2E2F303132333435363738393A3B3C3D3E3F404142434445464748494A4B4C4D4E4F505152535455565758595A5B5C5D5E5F606162636465666768696A6B6C6D6E6F707172737475767778797A7B7C7D7E7F808182838485868788898A8B8C8D8E8F909192939495969798999A9B9C9D9E9FA0A1A2A3A4A5A6A7A8A9AAABACADAEAFB0B1B2B3B4B5B6B7B8B9BABBBCBDBEBFC0C1C2C3C4C5C6C7C8C9CACBCCCDCECFD0D1D2D3D4D5D6D7D8D9DADBDCDDDEDFE0E1E2E3E4E5E6E7E8E9EAEBECEDEEEFF0F1F2F3F4F5F6F7F8F9FAFBFCFDFEFF".toCharArray();
    private static final String CARRIER_NAME_KEY = "a.CarrierName";
    private static final String DEVICE_NAME_KEY = "a.DeviceName";
    protected static final String LAST_KNOWN_TIMESTAMP_KEY = "ADBLastKnownTimestampKey";
    protected static final String LIBRARY_VERSION = "4.6.1-AN";
    private static final String MCPNS_DPID = "20919";
    private static final String NO_ACTIVITY_MESSAGE = "Message - No Current Activity (Messages must have a reference to the current activity to work properly)";
    private static final String NO_CONTEXT_MESSAGE = "Config - No Application Context (Application context must be set prior to calling any library functions.)";
    private static final String NO_SHARED_PREFERENCES_EDITOR_MESSAGE = "Config - Unable to create an instance of a SharedPreferences Editor";
    private static final String NO_SHARED_PREFERENCES_MESSAGE = "Config - No SharedPreferences available";
    private static final String OS_VERSION_KEY = "a.OSVersion";
    private static final String PUSH_ID_ENABLED_ACTION_NAME = "Push";
    private static final String RESOLUTION_KEY = "a.Resolution";
    private static final String RUN_MODE_APPLICATION = "Application";
    private static final String RUN_MODE_EXTENSION = "Extension";
    private static final String RUN_MODE_KEY = "a.RunMode";
    protected static final String TIME_SINCE_LAUNCH_KEY = "a.TimeSinceLaunch";
    private static WeakReference _activity = null;
    private static final Object _advertisingIdentifierMutex = new Object();
    private static boolean _aidDone = false;
    private static final Object _aidMutex = new Object();
    private static final Object _analyticsExecutorMutex = new Object();
    private static Config.ApplicationType _appType;
    private static final Object _applicationIDMutex = new Object();
    private static final Object _applicationNameMutex = new Object();
    private static final Object _applicationVersionCodeMutex = new Object();
    private static final Object _applicationVersionMutex = new Object();
    private static final Object _audienceExecutorMutex = new Object();
    private static final Object _carrierMutex = new Object();
    static final Map _contextDataKeyWhiteList = new HashMap(256);
    static int _contextDataKeyWhiteListCount = 0;
    private static final Object _currentActivityMutex = new Object();
    private static boolean _debugLogging;
    private static final Object _defaultDataMutex = new Object();
    private static boolean _isWearable = false;
    private static final Object _mediaExecutorMutex = new Object();
    private static final Object _messageImageCachingExecutorMutex = new Object();
    private static final Object _messagesExecutorMutex = new Object();
    private static final Object _operatingSystemMutex = new Object();
    private static final Object _pushEnabledMutex = new Object();
    private static final Object _pushIdentifierMutex = new Object();
    private static final Object _resolutionMutex = new Object();
    private static final Object _sharedExecutorMutex = new Object();
    private static final Object _sharedPreferencesMutex = new Object();
    private static final Object _thirdPartyCallbacksExecutorMutex = new Object();
    private static final Object _timedActionsExecutorMutex = new Object();
    private static final Object _timestampMutex = new Object();
    private static final Object _userAgentMutex = new Object();
    private static final Object _userIdentifierMutex = new Object();
    private static final Object _visitorIDMutex = new Object();
    private static String advertisingIdentifier = null;
    private static String aid = null;
    private static ExecutorService analyticsExecutor = null;
    private static String appID = null;
    private static String appName = null;
    private static ExecutorService audienceExecutor = null;
    private static String carrier = null;
    private static final boolean contextDataMask[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };
    private static HashMap defaultData = null;
    private static final String encodedChars[] = {
        "%00", "%01", "%02", "%03", "%04", "%05", "%06", "%07", "%08", "%09", 
        "%0A", "%0B", "%0C", "%0D", "%0E", "%0F", "%10", "%11", "%12", "%13", 
        "%14", "%15", "%16", "%17", "%18", "%19", "%1A", "%1B", "%1C", "%1D", 
        "%1E", "%1F", "%20", "%21", "%22", "%23", "%24", "%25", "%26", "%27", 
        "%28", "%29", "*", "%2B", "%2C", "-", ".", "%2F", "0", "1", 
        "2", "3", "4", "5", "6", "7", "8", "9", "%3A", "%3B", 
        "%3C", "%3D", "%3E", "%3F", "%40", "A", "B", "C", "D", "E", 
        "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
        "Z", "%5B", "%5C", "%5D", "%5E", "_", "%60", "a", "b", "c", 
        "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", 
        "x", "y", "z", "%7B", "%7C", "%7D", "%7E", "%7F", "%80", "%81", 
        "%82", "%83", "%84", "%85", "%86", "%87", "%88", "%89", "%8A", "%8B", 
        "%8C", "%8D", "%8E", "%8F", "%90", "%91", "%92", "%93", "%94", "%95", 
        "%96", "%97", "%98", "%99", "%9A", "%9B", "%9C", "%9D", "%9E", "%9F", 
        "%A0", "%A1", "%A2", "%A3", "%A4", "%A5", "%A6", "%A7", "%A8", "%A9", 
        "%AA", "%AB", "%AC", "%AD", "%AE", "%AF", "%B0", "%B1", "%B2", "%B3", 
        "%B4", "%B5", "%B6", "%B7", "%B8", "%B9", "%BA", "%BB", "%BC", "%BD", 
        "%BE", "%BF", "%C0", "%C1", "%C2", "%C3", "%C4", "%C5", "%C6", "%C7", 
        "%C8", "%C9", "%CA", "%CB", "%CC", "%CD", "%CE", "%CF", "%D0", "%D1", 
        "%D2", "%D3", "%D4", "%D5", "%D6", "%D7", "%D8", "%D9", "%DA", "%DB", 
        "%DC", "%DD", "%DE", "%DF", "%E0", "%E1", "%E2", "%E3", "%E4", "%E5", 
        "%E6", "%E7", "%E8", "%E9", "%EA", "%EB", "%EC", "%ED", "%EE", "%EF", 
        "%F0", "%F1", "%F2", "%F3", "%F4", "%F5", "%F6", "%F7", "%F8", "%F9", 
        "%FA", "%FB", "%FC", "%FD", "%FE", "%FF"
    };
    private static ExecutorService mediaExecutor = null;
    private static ExecutorService messageImageCachingExecutor = null;
    private static ExecutorService messagesExecutor = null;
    private static String operatingSystem = null;
    private static SharedPreferences prefs = null;
    private static boolean pushEnabled = false;
    private static String pushIdentifier = null;
    private static String resolution = null;
    private static Context sharedContext = null;
    private static ExecutorService sharedExecutor = null;
    private static ExecutorService thirdPartyCallbacksExecutor = null;
    private static ExecutorService timedActionsExecutor = null;
    private static String timestamp = null;
    private static String userAgent = null;
    private static final boolean utf8Mask[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };
    private static int versionCode = -1;
    private static String versionName = null;
    private static String visitorID = null;

    StaticMethods()
    {
    }

    protected static String URLEncode(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        s = null;
_L6:
        return s;
_L2:
        byte abyte0[];
        int i;
        int j;
        int k;
        try
        {
            abyte0 = s.getBytes("UTF-8");
            k = abyte0.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logWarningFormat((new StringBuilder()).append("UnsupportedEncodingException : ").append(s.getMessage()).toString(), new Object[0]);
            return null;
        }
        i = 0;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!utf8Mask[abyte0[i] & 0xff])
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        continue; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_22;
        if (i == k) goto _L6; else goto _L5
_L5:
        s = new StringBuilder(abyte0.length << 1);
        j = i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        s.append(new String(abyte0, 0, i, "UTF-8"));
        j = i;
_L8:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        s.append(encodedChars[abyte0[j] & 0xff]);
        j++;
        if (true) goto _L8; else goto _L7
_L7:
        s = s.toString();
        return s;
    }

    private static void addValueToHashMap(Object obj, ContextData contextdata, List list, int i)
    {
        if (contextdata != null && list != null)
        {
            int j = list.size();
            String s;
            if (i < j)
            {
                s = (String)list.get(i);
            } else
            {
                s = null;
            }
            if (s != null)
            {
                ContextData contextdata1 = new ContextData();
                if (contextdata.containsKey(s))
                {
                    contextdata1 = contextdata.get(s);
                }
                if (j - 1 == i)
                {
                    contextdata1.value = obj;
                    contextdata.put(s, contextdata1);
                    return;
                } else
                {
                    contextdata.put(s, contextdata1);
                    addValueToHashMap(obj, contextdata1, list, i + 1);
                    return;
                }
            }
        }
    }

    protected static String appendContextData(Map map, String s)
    {
        Matcher matcher;
        String s1;
        if (s != null && map != null && map.size() != 0)
        {
            if ((matcher = Pattern.compile(".*(&c\\.(.*)&\\.c).*").matcher(s)).matches() && (s1 = matcher.group(2)) != null)
            {
                HashMap hashmap = new HashMap(64);
                Object obj = new ArrayList(16);
                String as[] = s1.split("&");
                int j = as.length;
                int i = 0;
                while (i < j) 
                {
                    String s2 = as[i];
                    if (s2.endsWith(".") && !s2.contains("="))
                    {
                        ((List) (obj)).add(s2);
                    } else
                    if (s2.startsWith("."))
                    {
                        if (((List) (obj)).size() > 0)
                        {
                            ((List) (obj)).remove(((List) (obj)).size() - 1);
                        }
                    } else
                    {
                        String as1[] = s2.split("=");
                        if (as1.length == 2)
                        {
                            String s3 = contextDataStringPath(((List) (obj)), as1[0]);
                            try
                            {
                                hashmap.put(s3, URLDecoder.decode(as1[1], "UTF-8"));
                            }
                            catch (UnsupportedEncodingException unsupportedencodingexception)
                            {
                                unsupportedencodingexception.printStackTrace();
                            }
                        }
                    }
                    i++;
                }
                hashmap.putAll(map);
                map = new StringBuilder(s.substring(0, matcher.start(1)));
                obj = new HashMap();
                ((HashMap) (obj)).put("c", translateContextData(hashmap));
                serializeToQueryString(((Map) (obj)), map);
                map.append(s.substring(matcher.end(1)));
                return map.toString();
            }
        }
        return s;
    }

    protected static Map cleanContextDataDictionary(Map map)
    {
        if (map == null)
        {
            return new HashMap();
        }
        HashMap hashmap = new HashMap();
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s = cleanContextDataKey((String)entry.getKey());
            if (s != null)
            {
                hashmap.put(s, entry.getValue());
            }
        } while (true);
        return hashmap;
    }

    protected static String cleanContextDataKey(String s)
    {
        if (s == null)
        {
            return null;
        }
        Map map = _contextDataKeyWhiteList;
        map;
        JVM INSTR monitorenter ;
        Object obj1 = (String)_contextDataKeyWhiteList.get(s);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        map;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        map;
        JVM INSTR monitorexit ;
        byte byte0;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        try
        {
            obj = s.getBytes("UTF-8");
            obj1 = new byte[obj.length];
            j1 = obj.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logErrorFormat("Analytics - Unable to clean context data key (%s)", new Object[] {
                s.getLocalizedMessage()
            });
            return null;
        }
        j = 0;
        i = 0;
        i1 = 0;
          goto _L1
_L7:
        k = i;
        if (contextDataMask[byte0 & 0xff])
        {
            obj1[i] = byte0;
            k = i + 1;
            i1 = byte0;
        }
          goto _L2
_L5:
        obj1 = new String(((byte []) (obj1)), j, i, "UTF-8");
        synchronized (_contextDataKeyWhiteList)
        {
            if (_contextDataKeyWhiteListCount > 250)
            {
                _contextDataKeyWhiteList.clear();
                _contextDataKeyWhiteListCount = 0;
            }
            _contextDataKeyWhiteList.put(s, obj1);
            _contextDataKeyWhiteListCount++;
        }
        return ((String) (obj1));
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
_L1:
        if (j >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((byte0 = obj[j]) != 46 || i1 != 46)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = i;
_L2:
        j++;
        i = k;
        if (true) goto _L1; else goto _L3
_L3:
        if (i == 0)
        {
            return null;
        }
        int l;
        if (obj1[0] == 46)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (obj1[i - 1] == 46)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        i = i - l - j;
        if (i > 0) goto _L5; else goto _L4
_L4:
        return null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected static String contextDataStringPath(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (list = list.iterator(); list.hasNext(); stringbuilder.append((String)list.next())) { }
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    protected static String expandTokens(String s, Map map)
    {
        Iterator iterator = map.entrySet().iterator();
_L2:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        map = (java.util.Map.Entry)iterator.next();
        map = s.replace((CharSequence)map.getKey(), (CharSequence)map.getValue());
        s = map;
        if (true) goto _L2; else goto _L1
_L1:
        return s;
        map;
_L4:
        logDebugFormat("Unable to expand tokens (%s)", new Object[] {
            map.toString()
        });
        return s;
        map;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String generateAID()
    {
        Object obj1 = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.US);
        Object obj = Pattern.compile("^[89A-F]");
        Object obj2 = Pattern.compile("^[4-9A-F]");
        obj = ((Pattern) (obj)).matcher(((String) (obj1)).substring(0, 16));
        obj1 = ((Pattern) (obj2)).matcher(((String) (obj1)).substring(16, 32));
        obj2 = new SecureRandom();
        obj = ((Matcher) (obj)).replaceAll(String.valueOf(((SecureRandom) (obj2)).nextInt(7)));
        obj1 = ((Matcher) (obj1)).replaceAll(String.valueOf(((SecureRandom) (obj2)).nextInt(3)));
        return (new StringBuilder()).append(((String) (obj))).append("-").append(((String) (obj1))).toString();
    }

    protected static String getAID()
    {
        Object obj = _aidMutex;
        obj;
        JVM INSTR monitorenter ;
        if (_aidDone) goto _L2; else goto _L1
_L1:
        _aidDone = true;
        boolean flag;
        flag = getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", false);
        aid = getSharedPreferences().getString("ADOBEMOBILE_STOREDDEFAULTS_AID", null);
        if (flag) goto _L4; else goto _L3
_L3:
        if (aid == null) goto _L5; else goto _L4
_L4:
        if (MobileConfig.getInstance().getVisitorIdServiceEnabled() || !flag) goto _L2; else goto _L5
_L5:
        android.content.SharedPreferences.Editor editor;
        aid = retrieveAIDFromVisitorIDService();
        editor = getSharedPreferencesEditor();
        if (aid == null) goto _L7; else goto _L6
_L6:
        editor.putString("ADOBEMOBILE_STOREDDEFAULTS_AID", aid);
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", false);
_L8:
        editor.commit();
        syncAIDIfNeeded(aid);
_L2:
        obj;
        JVM INSTR monitorexit ;
        return aid;
_L7:
        editor.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_IGNORE_AID", true);
          goto _L8
        Object obj1;
        obj1;
        logErrorFormat("Config - Error getting AID. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
          goto _L2
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
          goto _L8
    }

    protected static String getAdvertisingIdentifier()
    {
        String s;
        synchronized (_advertisingIdentifierMutex)
        {
            s = advertisingIdentifier;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static ExecutorService getAnalyticsExecutor()
    {
        ExecutorService executorservice;
        synchronized (_analyticsExecutorMutex)
        {
            if (analyticsExecutor == null)
            {
                analyticsExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = analyticsExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String getAndroidVersion()
    {
        return android.os.Build.VERSION.RELEASE;
    }

    protected static String getApplicationID()
    {
        Object obj1 = _applicationIDMutex;
        obj1;
        JVM INSTR monitorenter ;
        if (appID != null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = new StringBuilder();
        if (getApplicationName() == null) goto _L4; else goto _L3
_L3:
        Object obj = getApplicationName();
_L7:
        stringbuilder = stringbuilder.append(((String) (obj)));
        if (getApplicationVersion() == null || getApplicationVersion().length() <= 0) goto _L6; else goto _L5
_L5:
        obj = (new StringBuilder()).append(" ").append(getApplicationVersion()).append(" ").toString();
_L8:
        stringbuilder = stringbuilder.append(((String) (obj)));
        if (getApplicationVersionCode() == 0)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = String.format(Locale.US, "(%d)", new Object[] {
            Integer.valueOf(getApplicationVersionCode())
        });
_L9:
        appID = stringbuilder.append(((String) (obj))).toString();
_L2:
        obj = appID;
        return ((String) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        obj = "";
          goto _L7
_L6:
        obj = "";
          goto _L8
        obj = "";
          goto _L9
    }

    private static String getApplicationName()
    {
        Object obj2 = _applicationNameMutex;
        obj2;
        JVM INSTR monitorenter ;
        if (appName != null) goto _L2; else goto _L1
_L1:
        appName = "";
        Object obj = getSharedContext().getPackageManager();
        if (obj == null) goto _L4; else goto _L3
_L3:
        android.content.pm.ApplicationInfo applicationinfo = ((PackageManager) (obj)).getApplicationInfo(getSharedContext().getPackageName(), 0);
        if (applicationinfo == null) goto _L6; else goto _L5
_L5:
        if (((PackageManager) (obj)).getApplicationLabel(applicationinfo) == null) goto _L8; else goto _L7
_L7:
        obj = (String)((PackageManager) (obj)).getApplicationLabel(applicationinfo);
_L9:
        appName = ((String) (obj));
_L2:
        obj = appName;
        obj2;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L8:
        obj = "";
          goto _L9
_L6:
        logWarningFormat("Analytics - ApplicationInfo was null", new Object[0]);
        appName = "";
          goto _L2
        Object obj1;
        obj1;
        logWarningFormat("Analytics - PackageManager couldn't find application name (%s)", new Object[] {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).toString()
        });
        appName = "";
          goto _L2
        obj1;
        obj2;
        JVM INSTR monitorexit ;
        throw obj1;
_L4:
        logWarningFormat("Analytics - PackageManager was null", new Object[0]);
        appName = "";
          goto _L2
        obj1;
        logErrorFormat("Config - Unable to get package to pull application name. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
        appName = "";
          goto _L2
    }

    protected static Config.ApplicationType getApplicationType()
    {
        return _appType;
    }

    protected static String getApplicationVersion()
    {
        Object obj2 = _applicationVersionMutex;
        obj2;
        JVM INSTR monitorenter ;
        if (versionName != null) goto _L2; else goto _L1
_L1:
        versionName = "";
        Object obj = getSharedContext().getPackageManager();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((PackageManager) (obj)).getPackageInfo(getSharedContext().getPackageName(), 0);
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (((PackageInfo) (obj)).versionName == null) goto _L8; else goto _L7
_L7:
        obj = ((PackageInfo) (obj)).versionName;
_L9:
        versionName = ((String) (obj));
_L2:
        obj = versionName;
        obj2;
        JVM INSTR monitorexit ;
        return ((String) (obj));
_L8:
        obj = "";
          goto _L9
_L6:
        logWarningFormat("Analytics - PackageInfo was null", new Object[0]);
        versionName = "";
          goto _L2
        Object obj1;
        obj1;
        logWarningFormat("Analytics - PackageManager couldn't find application version (%s)", new Object[] {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj1)).toString()
        });
        versionName = "";
          goto _L2
        obj1;
        obj2;
        JVM INSTR monitorexit ;
        throw obj1;
_L4:
        logWarningFormat("Analytics - PackageManager was null", new Object[0]);
        versionName = "";
          goto _L2
        obj1;
        logErrorFormat("Config - Unable to get package to pull application version. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
        versionName = "";
          goto _L2
    }

    protected static int getApplicationVersionCode()
    {
        int i = 0;
        Object obj = _applicationVersionCodeMutex;
        obj;
        JVM INSTR monitorenter ;
        int j = versionCode;
        if (j != -1) goto _L2; else goto _L1
_L1:
        Object obj1 = getSharedContext().getPackageManager();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj1 = ((PackageManager) (obj1)).getPackageInfo(getSharedContext().getPackageName(), 0);
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        if (((PackageInfo) (obj1)).versionCode > 0)
        {
            i = ((PackageInfo) (obj1)).versionCode;
        }
        versionCode = i;
_L2:
        i = versionCode;
        obj;
        JVM INSTR monitorexit ;
        return i;
_L6:
        logWarningFormat("Analytics - PackageInfo was null", new Object[0]);
        versionCode = 0;
          goto _L2
        Object obj2;
        obj2;
        logWarningFormat("Analytics - PackageManager couldn't find application version code (%s)", new Object[] {
            ((android.content.pm.PackageManager.NameNotFoundException) (obj2)).toString()
        });
        versionCode = 0;
          goto _L2
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
_L4:
        logWarningFormat("Analytics - PackageManager was null", new Object[0]);
        versionCode = 0;
          goto _L2
        obj2;
        logErrorFormat("Config - Unable to get package to pull application version code. (%s)", new Object[] {
            ((NullContextException) (obj2)).getMessage()
        });
        versionCode = 0;
          goto _L2
    }

    protected static ExecutorService getAudienceExecutor()
    {
        ExecutorService executorservice;
        synchronized (_audienceExecutorMutex)
        {
            if (audienceExecutor == null)
            {
                audienceExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = audienceExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static File getCacheDirectory()
    {
        File file;
        try
        {
            file = getSharedContext().getCacheDir();
        }
        catch (NullContextException nullcontextexception)
        {
            logErrorFormat("Config - Error getting cache directory. (%s)", new Object[] {
                nullcontextexception.getMessage()
            });
            return null;
        }
        return file;
    }

    protected static String getCarrier()
    {
        Object obj = _carrierMutex;
        obj;
        JVM INSTR monitorenter ;
        String s = carrier;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        carrier = ((TelephonyManager)getSharedContext().getSystemService("phone")).getNetworkOperatorName();
_L1:
        s = carrier;
        obj;
        JVM INSTR monitorexit ;
        return s;
        Object obj1;
        obj1;
        logErrorFormat("Config - Error getting device carrier. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected static Activity getCurrentActivity()
    {
        Object obj = _currentActivityMutex;
        obj;
        JVM INSTR monitorenter ;
        if (_activity == null || _activity.get() == null)
        {
            throw new NullActivityException("Message - No Current Activity (Messages must have a reference to the current activity to work properly)");
        }
        break MISSING_BLOCK_LABEL_36;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        Activity activity = (Activity)_activity.get();
        obj;
        JVM INSTR monitorexit ;
        return activity;
    }

    protected static int getCurrentOrientation()
    {
        int i;
        try
        {
            i = getCurrentActivity().getResources().getConfiguration().orientation;
        }
        catch (NullActivityException nullactivityexception)
        {
            return -1;
        }
        return i;
    }

    protected static boolean getDebugLogging()
    {
        return _debugLogging;
    }

    protected static String getDefaultAcceptLanguage()
    {
        Object obj;
        try
        {
            obj = getSharedContext().getResources();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logErrorFormat("Config - Error getting application resources for default accepted language. (%s)", new Object[] {
                ((NullContextException) (obj)).getMessage()
            });
            return null;
        }
        if (obj != null)
        {
            if ((obj = ((Resources) (obj)).getConfiguration()) != null && (obj = ((Configuration) (obj)).locale) != null)
            {
                return ((Locale) (obj)).toString().replace('_', '-');
            }
        }
        return null;
    }

    protected static HashMap getDefaultData()
    {
        Object obj1 = _defaultDataMutex;
        obj1;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        if (defaultData != null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        defaultData = new HashMap();
        defaultData.put("a.DeviceName", Build.MODEL);
        defaultData.put("a.Resolution", getResolution());
        defaultData.put("a.OSVersion", getOperatingSystem());
        defaultData.put("a.CarrierName", getCarrier());
        defaultData.put("a.AppID", getApplicationID());
        hashmap = defaultData;
        Object obj;
        if (isWearableApp())
        {
            obj = "Extension";
        } else
        {
            obj = "Application";
        }
        hashmap.put("a.RunMode", obj);
        obj = defaultData;
        obj1;
        JVM INSTR monitorexit ;
        return ((HashMap) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
    }

    protected static String getDefaultUserAgent()
    {
        String s;
        synchronized (_userAgentMutex)
        {
            if (userAgent == null)
            {
                userAgent = (new StringBuilder()).append("Mozilla/5.0 (Linux; U; Android ").append(getAndroidVersion()).append("; ").append(getDefaultAcceptLanguage()).append("; ").append(Build.MODEL).append(" Build/").append(Build.ID).append(")").toString();
            }
            s = userAgent;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static Locale getDeviceLocale()
    {
        Object obj;
        try
        {
            obj = getSharedContext().getResources();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logErrorFormat("Config - Error getting application resources for device locale. (%s)", new Object[] {
                ((NullContextException) (obj)).getMessage()
            });
            return Locale.US;
        }
        if (obj == null)
        {
            return Locale.US;
        }
        obj = ((Resources) (obj)).getConfiguration();
        if (obj == null)
        {
            return Locale.US;
        }
        if (((Configuration) (obj)).locale != null)
        {
            return ((Configuration) (obj)).locale;
        } else
        {
            return Locale.US;
        }
    }

    protected static String getHexString(String s)
    {
        int j = 0;
        if (s == null || s.length() <= 0)
        {
            return null;
        }
        char ac[];
        int k;
        try
        {
            s = s.getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logDebugFormat("Failed to get hex from string (%s)", new Object[] {
                s.getMessage()
            });
            return null;
        }
        k = s.length;
        ac = new char[k << 1];
        for (int i = 0; i < k; i++)
        {
            int l = (s[i] & 0xff) << 1;
            int i1 = j + 1;
            ac[j] = BYTE_TO_HEX[l];
            j = i1 + 1;
            ac[i1] = BYTE_TO_HEX[l + 1];
        }

        return new String(ac);
    }

    protected static String getIso8601Date()
    {
        return getIso8601Date(new Date());
    }

    protected static String getIso8601Date(Date date)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ", getDeviceLocale());
        if (date == null)
        {
            date = new Date();
        }
        return simpledateformat.format(date);
    }

    protected static ExecutorService getMediaExecutor()
    {
        ExecutorService executorservice;
        synchronized (_mediaExecutorMutex)
        {
            if (mediaExecutor == null)
            {
                mediaExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = mediaExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static ExecutorService getMessageImageCachingExecutor()
    {
        ExecutorService executorservice;
        synchronized (_messageImageCachingExecutorMutex)
        {
            if (messageImageCachingExecutor == null)
            {
                messageImageCachingExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = messageImageCachingExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static ExecutorService getMessagesExecutor()
    {
        ExecutorService executorservice;
        synchronized (_messagesExecutorMutex)
        {
            if (messagesExecutor == null)
            {
                messagesExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = messagesExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getOperatingSystem()
    {
        String s;
        synchronized (_operatingSystemMutex)
        {
            if (operatingSystem == null)
            {
                operatingSystem = (new StringBuilder()).append("Android ").append(getAndroidVersion()).toString();
            }
            s = operatingSystem;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getPushIdentifier()
    {
        String s;
        synchronized (_pushIdentifierMutex)
        {
            s = pushIdentifier;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getResolution()
    {
        Object obj = _resolutionMutex;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = resolution;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj1 = getSharedContext().getResources().getDisplayMetrics();
        resolution = (new StringBuilder()).append(((DisplayMetrics) (obj1)).widthPixels).append("x").append(((DisplayMetrics) (obj1)).heightPixels).toString();
_L1:
        obj1 = resolution;
        obj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
        Object obj2;
        obj2;
        logErrorFormat("Config - Error getting device resolution. (%s)", new Object[] {
            ((NullContextException) (obj2)).getMessage()
        });
          goto _L1
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
    }

    protected static Context getSharedContext()
    {
        if (sharedContext == null)
        {
            throw new NullContextException("Config - No Application Context (Application context must be set prior to calling any library functions.)");
        } else
        {
            return sharedContext;
        }
    }

    protected static ExecutorService getSharedExecutor()
    {
        ExecutorService executorservice;
        synchronized (_sharedExecutorMutex)
        {
            if (sharedExecutor == null)
            {
                sharedExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = sharedExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static SharedPreferences getSharedPreferences()
    {
        Object obj = _sharedPreferencesMutex;
        obj;
        JVM INSTR monitorenter ;
        if (prefs == null)
        {
            prefs = getSharedContext().getSharedPreferences("APP_MEASUREMENT_CACHE", 0);
            if (prefs == null)
            {
                logWarningFormat("Config - No SharedPreferences available", new Object[0]);
            }
        }
        if (prefs == null)
        {
            throw new NullContextException("Config - No SharedPreferences available");
        }
        break MISSING_BLOCK_LABEL_61;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        SharedPreferences sharedpreferences = prefs;
        obj;
        JVM INSTR monitorexit ;
        return sharedpreferences;
    }

    protected static android.content.SharedPreferences.Editor getSharedPreferencesEditor()
    {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        if (editor == null)
        {
            throw new NullContextException("Config - Unable to create an instance of a SharedPreferences Editor");
        } else
        {
            return editor;
        }
    }

    protected static ExecutorService getThirdPartyCallbacksExecutor()
    {
        ExecutorService executorservice;
        synchronized (_thirdPartyCallbacksExecutorMutex)
        {
            if (thirdPartyCallbacksExecutor == null)
            {
                thirdPartyCallbacksExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = thirdPartyCallbacksExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static long getTimeSince1970()
    {
        return System.currentTimeMillis() / 1000L;
    }

    protected static long getTimeSinceLaunch()
    {
        long l = Lifecycle.sessionStartTime;
        l = getTimeSince1970() - l;
        if (l < 0x93a80L)
        {
            return l;
        } else
        {
            return 0L;
        }
    }

    public static ExecutorService getTimedActionsExecutor()
    {
        ExecutorService executorservice;
        synchronized (_timedActionsExecutorMutex)
        {
            if (timedActionsExecutor == null)
            {
                timedActionsExecutor = Executors.newSingleThreadExecutor();
            }
            executorservice = timedActionsExecutor;
        }
        return executorservice;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getTimestampString()
    {
        String s;
        synchronized (_timestampMutex)
        {
            if (timestamp == null)
            {
                Object obj1 = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(((Date) (obj1)));
                obj1 = (new StringBuilder()).append("00/00/0000 00:00:00 0 ");
                TimeZone timezone = calendar.getTimeZone();
                int i = calendar.get(1);
                int j = calendar.get(2);
                int k = calendar.get(5);
                int l = calendar.get(7);
                int i1 = calendar.get(11);
                int j1 = calendar.get(12);
                int k1 = calendar.get(13);
                timestamp = ((StringBuilder) (obj1)).append((timezone.getOffset(1, i, j, k, l, calendar.get(14) + ((i1 * 60 + j1) * 60 + k1) * 1000) / 60000) * -1).toString();
            }
            s = timestamp;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getVisitorID()
    {
        Object obj = _visitorIDMutex;
        obj;
        JVM INSTR monitorenter ;
        String s = visitorID;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        visitorID = getSharedPreferences().getString("APP_MEASUREMENT_VISITOR_ID", null);
_L1:
        s = visitorID;
        obj;
        JVM INSTR monitorexit ;
        return s;
        Object obj1;
        obj1;
        logErrorFormat("Config - Unable to pull visitorID from shared preferences. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected static String hexToString(String s)
    {
        if (s == null || s.length() <= 0 || s.length() % 2 != 0)
        {
            return null;
        }
        int j = s.length();
        byte abyte0[] = new byte[j / 2];
        for (int i = 0; i < j; i += 2)
        {
            abyte0[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        try
        {
            s = new String(abyte0, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logDebugFormat("Failed to get string from hex (%s)", new Object[] {
                s.getMessage()
            });
            return null;
        }
        return s;
    }

    protected static boolean isPushEnabled()
    {
        Object obj = _pushEnabledMutex;
        obj;
        JVM INSTR monitorenter ;
        pushEnabled = getSharedPreferences().getBoolean("ADBMOBILE_KEY_PUSH_ENABLED", false);
_L2:
        return pushEnabled;
        Object obj1;
        obj1;
        logErrorFormat("Config - Unable to pull push status from shared preferences. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected static boolean isWearableApp()
    {
        return _isWearable;
    }

    protected static String join(Iterable iterable, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        iterable = iterable.iterator();
        do
        {
label0:
            {
                if (iterable.hasNext())
                {
                    stringbuilder.append(iterable.next());
                    if (iterable.hasNext())
                    {
                        break label0;
                    }
                }
                return stringbuilder.toString();
            }
            stringbuilder.append(s);
        } while (true);
    }

    protected static transient void logDebugFormat(String s, Object aobj[])
    {
label0:
        {
            if (getDebugLogging())
            {
                if (aobj == null || aobj.length <= 0)
                {
                    break label0;
                }
                Log.d("ADBMobile", String.format((new StringBuilder()).append("ADBMobile Debug : ").append(s).toString(), aobj));
            }
            return;
        }
        Log.d("ADBMobile", (new StringBuilder()).append("ADBMobile Debug : ").append(s).toString());
    }

    protected static transient void logErrorFormat(String s, Object aobj[])
    {
        if (aobj != null && aobj.length > 0)
        {
            Log.e("ADBMobile", String.format((new StringBuilder()).append("ADBMobile Error : ").append(s).toString(), aobj));
            return;
        } else
        {
            Log.e("ADBMobile", (new StringBuilder()).append("ADBMobile Error : ").append(s).toString());
            return;
        }
    }

    protected static transient void logWarningFormat(String s, Object aobj[])
    {
label0:
        {
            if (getDebugLogging())
            {
                if (aobj == null || aobj.length <= 0)
                {
                    break label0;
                }
                Log.w("ADBMobile", String.format((new StringBuilder()).append("ADBMobile Warning : ").append(s).toString(), aobj));
            }
            return;
        }
        Log.w("ADBMobile", (new StringBuilder()).append("ADBMobile Warning : ").append(s).toString());
    }

    protected static HashMap mapFromJson(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        Iterator iterator = jsonobject.keys();
        HashMap hashmap = new HashMap();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            try
            {
                hashmap.put(s, jsonobject.getString(s));
            }
            catch (JSONException jsonexception)
            {
                logWarningFormat("Problem parsing json data (%s)", new Object[] {
                    jsonexception.getLocalizedMessage()
                });
            }
        }
        return hashmap;
    }

    private static String retrieveAIDFromVisitorIDService()
    {
        Object obj;
        boolean flag;
        Object obj1 = new StringBuilder(64);
        if (MobileConfig.getInstance().getSSL())
        {
            obj = "https";
        } else
        {
            obj = "http";
        }
        ((StringBuilder) (obj1)).append(((String) (obj)));
        ((StringBuilder) (obj1)).append("://");
        ((StringBuilder) (obj1)).append(MobileConfig.getInstance().getTrackingServer());
        ((StringBuilder) (obj1)).append("/id");
        flag = MobileConfig.getInstance().getVisitorIdServiceEnabled();
        if (flag)
        {
            ((StringBuilder) (obj1)).append(VisitorIDService.sharedInstance().getAnalyticsIDRequestParameterString());
        }
        obj = RequestHandler.retrieveData(((StringBuilder) (obj1)).toString(), null, 500, "Analytics ID");
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = (new JSONObject(new String(((byte []) (obj)), "UTF-8"))).getString("id");
_L4:
label0:
        {
            if (obj != null)
            {
                obj1 = obj;
                if (((String) (obj)).length() == 33)
                {
                    break label0;
                }
            }
            if (!flag)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = null;
        }
        return ((String) (obj1));
        obj;
        logErrorFormat("Analytics ID - Unable to decode /id response(%s)", new Object[] {
            ((UnsupportedEncodingException) (obj)).getLocalizedMessage()
        });
        obj = null;
        continue; /* Loop/switch isn't completed */
        obj;
        if (!flag)
        {
            logErrorFormat("Analytics ID - Unable to parse /id response(%s)", new Object[] {
                ((JSONException) (obj)).getLocalizedMessage()
            });
        }
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        return generateAID();
    }

    private static void serializeKeyValuePair(String s, Object obj, StringBuilder stringbuilder)
    {
        while (s == null || obj == null || (obj instanceof ContextData) || s.length() <= 0 || (obj instanceof String) && ((String)obj).length() <= 0) 
        {
            return;
        }
        stringbuilder.append("&");
        stringbuilder.append(s);
        stringbuilder.append("=");
        if (obj instanceof List)
        {
            stringbuilder.append(URLEncode(join((List)obj, ",")));
            return;
        } else
        {
            stringbuilder.append(URLEncode(obj.toString()));
            return;
        }
    }

    protected static void serializeToQueryString(Map map, StringBuilder stringbuilder)
    {
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)map.next();
                String s = URLEncode((String)((java.util.Map.Entry) (obj)).getKey());
                if (s != null)
                {
                    obj = ((java.util.Map.Entry) (obj)).getValue();
                    if (obj instanceof ContextData)
                    {
                        obj = (ContextData)obj;
                        if (((ContextData) (obj)).value != null)
                        {
                            serializeKeyValuePair(s, ((ContextData) (obj)).value, stringbuilder);
                        }
                        if (((ContextData) (obj)).contextData != null && ((ContextData) (obj)).contextData.size() > 0)
                        {
                            stringbuilder.append("&");
                            stringbuilder.append(s);
                            stringbuilder.append(".");
                            serializeToQueryString(((Map) (((ContextData) (obj)).contextData)), stringbuilder);
                            stringbuilder.append("&.");
                            stringbuilder.append(s);
                        }
                    } else
                    {
                        serializeKeyValuePair(s, obj, stringbuilder);
                    }
                }
            }
        }
    }

    protected static void setAdvertisingIdentifier(final String adid)
    {
        if (adid != null && adid.equals(getAdvertisingIdentifier()))
        {
            return;
        }
        synchronized (_advertisingIdentifierMutex)
        {
            advertisingIdentifier = adid;
            WearableFunctionBridge.syncAdvertisingIdentifierToWearable(adid);
            VisitorIDService.sharedInstance().idSync(null, new HashMap() {

                final String val$adid;

            
            {
                adid = s;
                super();
                put("20914", adid);
            }
            });
        }
        return;
        adid;
        obj;
        JVM INSTR monitorexit ;
        throw adid;
    }

    protected static void setApplicationType(Config.ApplicationType applicationtype)
    {
        _appType = applicationtype;
        boolean flag;
        if (_appType == Config.ApplicationType.APPLICATION_TYPE_WEARABLE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        _isWearable = flag;
    }

    protected static void setCurrentActivity(Activity activity)
    {
        synchronized (_currentActivityMutex)
        {
            _activity = new WeakReference(activity);
        }
        return;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
    }

    protected static void setDebugLogging(boolean flag)
    {
        _debugLogging = flag;
    }

    protected static void setPushEnabled(boolean flag)
    {
        Object obj = _pushEnabledMutex;
        obj;
        JVM INSTR monitorenter ;
        android.content.SharedPreferences.Editor editor = getSharedPreferencesEditor();
        editor.putBoolean("ADBMOBILE_KEY_PUSH_ENABLED", flag);
        editor.commit();
        pushEnabled = flag;
        WearableFunctionBridge.syncPushEnabledToWearable(flag);
_L1:
        return;
        Object obj1;
        obj1;
        logErrorFormat("Config - Unable to set pushEnabled shared preferences. (%s)", new Object[] {
            ((NullContextException) (obj1)).getMessage()
        });
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    protected static void setPushIdentifier(final String registrationID)
    {
        Object obj = _pushIdentifierMutex;
        obj;
        JVM INSTR monitorenter ;
        if (registrationID != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (isPushEnabled())
        {
            setPushEnabled(false);
            AnalyticsTrackInternal.trackInternal("Push", new HashMap() {

            
            {
                put("a.push.optin", "False");
            }
            }, getTimeSince1970());
        }
        if (registrationID == null)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        if (registrationID.length() >= 0 && !isPushEnabled())
        {
            setPushEnabled(true);
            AnalyticsTrackInternal.trackInternal("Push", new HashMap() {

            
            {
                put("a.push.optin", "True");
            }
            }, getTimeSince1970());
        }
        pushIdentifier = registrationID;
        VisitorIDService.sharedInstance().idSync(null, new HashMap() {

            final String val$registrationID;

            
            {
                registrationID = s;
                super();
                put("20919", registrationID);
            }
        });
        obj;
        JVM INSTR monitorexit ;
        return;
        registrationID;
        obj;
        JVM INSTR monitorexit ;
        throw registrationID;
    }

    protected static void setSharedContext(Context context)
    {
label0:
        {
            if (context != null)
            {
                if (!(context instanceof Activity))
                {
                    break label0;
                }
                sharedContext = context.getApplicationContext();
            }
            return;
        }
        sharedContext = context;
    }

    protected static void setVisitorID(String s)
    {
        Object obj = _userIdentifierMutex;
        obj;
        JVM INSTR monitorenter ;
        visitorID = s;
        WearableFunctionBridge.syncVisitorIDToWearable(s);
        android.content.SharedPreferences.Editor editor = getSharedPreferencesEditor();
        editor.putString("APP_MEASUREMENT_VISITOR_ID", s);
        editor.commit();
_L1:
        return;
        s;
        logErrorFormat("Config - Error updating visitorID. (%s)", new Object[] {
            s.getMessage()
        });
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void syncAIDIfNeeded(String s)
    {
        if (s != null && MobileConfig.getInstance().getVisitorIdServiceEnabled())
        {
            boolean flag;
            try
            {
                flag = getSharedPreferences().getBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", false);
            }
            catch (NullContextException nullcontextexception)
            {
                logWarningFormat("Visitor ID - Null context when attempting to determine visitor ID sync status (%s)", new Object[] {
                    nullcontextexception.getLocalizedMessage()
                });
                flag = false;
            }
            if (!flag)
            {
                HashMap hashmap = new HashMap();
                hashmap.put("AVID", s);
                VisitorIDService.sharedInstance().idSync(hashmap);
                try
                {
                    s = getSharedPreferencesEditor();
                    s.putBoolean("ADOBEMOBILE_STOREDDEFAULTS_AID_SYNCED", true);
                    s.commit();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    logWarningFormat("Visitor ID - Null context when attempting to persist visitor ID sync status (%s)", new Object[] {
                        s.getLocalizedMessage()
                    });
                }
                return;
            }
        }
    }

    protected static ContextData translateContextData(Map map)
    {
        ContextData contextdata = new ContextData();
        java.util.Map.Entry entry;
        ArrayList arraylist;
        for (map = cleanContextDataDictionary(map).entrySet().iterator(); map.hasNext(); addValueToHashMap(entry.getValue(), contextdata, arraylist, 0))
        {
            entry = (java.util.Map.Entry)map.next();
            String s = (String)entry.getKey();
            arraylist = new ArrayList();
            int i = 0;
            do
            {
                int j = s.indexOf('.', i);
                if (j < 0)
                {
                    break;
                }
                arraylist.add(s.substring(i, j));
                i = j + 1;
            } while (true);
            arraylist.add(s.substring(i, s.length()));
        }

        return contextdata;
    }

    protected static void updateLastKnownTimestamp(Long long1)
    {
        MobileConfig mobileconfig = MobileConfig.getInstance();
        if (mobileconfig == null)
        {
            logErrorFormat("Config - Lost config instance", new Object[0]);
        } else
        if (mobileconfig.getOfflineTrackingEnabled())
        {
            try
            {
                android.content.SharedPreferences.Editor editor = getSharedPreferencesEditor();
                editor.putLong("ADBLastKnownTimestampKey", long1.longValue());
                editor.commit();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Long long1)
            {
                logErrorFormat("Config - Error while updating last known timestamp. (%s)", new Object[] {
                    long1.getMessage()
                });
            }
            return;
        }
    }

    static 
    {
        _appType = Config.ApplicationType.APPLICATION_TYPE_HANDHELD;
    }

    private class NullContextException extends Exception
    {

        public NullContextException(String s)
        {
            super(s);
        }
    }


    private class NullActivityException extends Exception
    {

        public NullActivityException(String s)
        {
            super(s);
        }
    }

}
