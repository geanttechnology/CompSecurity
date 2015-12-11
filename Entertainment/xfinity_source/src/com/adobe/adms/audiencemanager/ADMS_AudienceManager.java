// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.audiencemanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class ADMS_AudienceManager
{
    public static interface AudienceManagerCallback
    {

        public abstract void call(Object obj);
    }

    private static class SubmitSignalTask
        implements Runnable
    {

        public AudienceManagerCallback callback;
        public HashMap data;

        public void run()
        {
            Object obj;
            obj = ADMS_AudienceManager.BuildSchemaRequest(data);
            ADMS_AudienceManager.ADBLogDebugFormat("Audience Manager - request (%s)", new Object[] {
                obj
            });
            if (((String) (obj)).length() <= 0) goto _L2; else goto _L1
_L1:
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Exception exception2;
            Object obj6;
            DefaultHttpClient defaulthttpclient;
            StringBuilder stringbuilder;
            stringbuilder = new StringBuilder();
            defaulthttpclient = new DefaultHttpClient();
            HttpResponse httpresponse;
            try
            {
                obj5 = new HttpGet(((String) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ADMS_AudienceManager.ADBLogErrorFormat("Audience Manager - Error creating URL query string (%s)", new Object[] {
                    ((Exception) (obj)).getLocalizedMessage()
                });
                return;
            }
            obj6 = null;
            obj = null;
            obj1 = null;
            exception2 = null;
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            httpresponse = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj5)));
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            if (httpresponse.getStatusLine().getStatusCode() != 200) goto _L4; else goto _L3
_L3:
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            obj = httpresponse.getEntity().getContent();
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj;
            obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj)), "UTF-8"));
_L7:
            obj2 = ((BufferedReader) (obj1)).readLine();
            if (obj2 == null) goto _L6; else goto _L5
_L5:
            stringbuilder.append(((String) (obj2)));
              goto _L7
            obj4;
_L12:
            obj2 = obj;
            obj3 = obj1;
            ADMS_AudienceManager.ADBLogErrorFormat("Audience Manager - Problem communicating with the server (%s)", new Object[] {
                ((Exception) (obj4)).getLocalizedMessage()
            });
            obj2 = obj;
            obj3 = obj1;
            if (callback == null)
            {
                break MISSING_BLOCK_LABEL_231;
            }
            obj2 = obj;
            obj3 = obj1;
            callback.call(null);
            ((InputStream) (obj)).close();
            ((BufferedReader) (obj1)).close();
_L14:
            return;
_L4:
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            ADMS_AudienceManager.ADBLogErrorFormat("Audience Manager - No response from server", new Object[0]);
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            if (callback == null)
            {
                break MISSING_BLOCK_LABEL_311;
            }
            obj2 = obj;
            obj3 = obj1;
            obj4 = obj6;
            callback.call(null);
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
_L6:
            obj4 = new JSONObject(stringbuilder.toString());
            obj3 = ((JSONObject) (obj4)).getJSONArray("dests");
            int i;
            i = 0;
            obj2 = obj5;
_L10:
            if (i >= ((JSONArray) (obj3)).length()) goto _L9; else goto _L8
_L8:
            obj5 = ((JSONArray) (obj3)).getJSONObject(i).getString("c");
            ADMS_AudienceManager.ADBLogDebugFormat("Audience Manager - forwarding 'dests' request (%s)", new Object[] {
                obj5
            });
            if (obj5 == null)
            {
                break MISSING_BLOCK_LABEL_420;
            }
            if (((String) (obj5)).length() <= 0)
            {
                break MISSING_BLOCK_LABEL_420;
            }
            obj2 = new HttpGet(((String) (obj5)));
            defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
_L11:
            i++;
              goto _L10
            exception2;
            ADMS_AudienceManager.ADBLogErrorFormat("Audience Manager - Unable to send dests hit for url (%s), (%s)", new Object[] {
                obj5, exception2.getLocalizedMessage()
            });
              goto _L11
            obj2;
            obj3 = obj1;
            obj1 = obj2;
_L15:
            try
            {
                ((InputStream) (obj)).close();
                ((BufferedReader) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            throw obj1;
_L9:
            ADMS_AudienceManager.SetUUID(((JSONObject) (obj4)).getString("uuid"));
            obj3 = ((JSONObject) (obj4)).getJSONArray("stuff");
            obj4 = new HashMap();
            i = 0;
_L16:
            if (i >= ((JSONArray) (obj3)).length())
            {
                break MISSING_BLOCK_LABEL_547;
            }
            obj2 = ((JSONArray) (obj3)).getJSONObject(i);
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_664;
            }
            Exception exception;
            try
            {
                ((HashMap) (obj4)).put(((JSONObject) (obj2)).getString("cn"), ((JSONObject) (obj2)).getString("cv"));
                break MISSING_BLOCK_LABEL_664;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj4) { }
            finally
            {
                obj3 = obj1;
                obj1 = exception1;
            }
              goto _L12
            ADMS_AudienceManager.ADBLogDebugFormat("Audience Manager - response (%s)", new Object[] {
                obj4
            });
            ADMS_AudienceManager.SetVisitorProfile(((HashMap) (obj4)));
            if (callback != null)
            {
                callback.call(obj4);
            }
            try
            {
                ((InputStream) (obj)).close();
                ((BufferedReader) (obj1)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
_L2:
            ADMS_AudienceManager.ADBLogErrorFormat("Audience Manager - Unable to create URL object", new Object[0]);
            if (callback == null) goto _L14; else goto _L13
_L13:
            callback.call(null);
            return;
            obj1;
            obj = obj2;
              goto _L15
            obj;
            return;
            exception;
            obj = obj4;
            obj4 = exception;
            exception = exception2;
              goto _L12
            i++;
              goto _L16
        }

        public SubmitSignalTask(HashMap hashmap, AudienceManagerCallback audiencemanagercallback)
        {
            data = hashmap;
            callback = audiencemanagercallback;
        }
    }


    private static final String ADB_AUDIENCE_MANAGER_CUSTOMER_DATA_PREFIX = "c_";
    private static final String ADB_AUDIENCE_MANAGER_DATA_PROVIDER_ID_KEY = "d_dpid";
    private static final String ADB_AUDIENCE_MANAGER_DATA_PROVIDER_USER_ID_KEY = "d_dpuuid";
    private static final String ADB_AUDIENCE_MANAGER_JSON_COOKIE_NAME_KEY = "cn";
    private static final String ADB_AUDIENCE_MANAGER_JSON_COOKIE_VALUE_KEY = "cv";
    private static final String ADB_AUDIENCE_MANAGER_JSON_DESTS_KEY = "dests";
    private static final String ADB_AUDIENCE_MANAGER_JSON_STUFF_KEY = "stuff";
    private static final String ADB_AUDIENCE_MANAGER_JSON_URL_KEY = "c";
    private static final String ADB_AUDIENCE_MANAGER_JSON_USER_ID_KEY = "uuid";
    private static final String ADB_AUDIENCE_MANAGER_SHARED_PREFS_PROFILE_KEY = "AAMUserProfile";
    private static final String ADB_AUDIENCE_MANAGER_SHARED_PREFS_USER_ID_KEY = "AAMUserId";
    private static final String ADB_AUDIENCE_MANAGER_URL_PREFIX = "http://%s/event?";
    private static final String ADB_AUDIENCE_MANAGER_URL_SUFFIX = "&d_ptfm=android&d_dst=1&d_rtbd=json";
    private static final String ADB_AUDIENCE_MANAGER_USER_ID_KEY = "d_uuid";
    private static final String PREFS_NAME = "APP_MEASUREMENT_CACHE";
    private static volatile boolean SharedPreferencesEditor_pred = true;
    private static volatile boolean SharedPreferences_pred = true;
    private static volatile boolean UrlPrefix_pred = true;
    private static volatile boolean Uuid_pred = true;
    private static volatile boolean VisitorProfile_pred = true;
    private static String _aamServer = null;
    private static Context _context = null;
    private static boolean _debugLogging = false;
    private static String _dpid = null;
    private static String _dpuuid = null;
    private static android.content.SharedPreferences.Editor _editor = null;
    private static SharedPreferences _prefs = null;
    private static String _urlPrefix = null;
    private static String _uuid = null;
    private static HashMap _visitorProfile = null;
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

    public ADMS_AudienceManager()
    {
    }

    private static transient void ADBLogDebugFormat(String s, Object aobj[])
    {
        if (GetDebugLogging())
        {
            Log.d("ADBMobile", String.format((new StringBuilder()).append("ADBMobile Debug : ").append(s).toString(), aobj));
        }
    }

    private static transient void ADBLogErrorFormat(String s, Object aobj[])
    {
        Log.d("ADBMobile", String.format((new StringBuilder()).append("ADBMobile Error : ").append(s).toString(), aobj));
    }

    public static boolean AudienceManagerIsConfigured()
    {
        return _aamServer != null && _aamServer.length() > 0;
    }

    private static String BuildSchemaRequest(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(GetUrlPrefix()).append(GetCustomUrlVariables(hashmap)).append(GetDataProviderUrlVariables()).append("&d_ptfm=android&d_dst=1&d_rtbd=json");
        return stringbuilder.toString().replace("?&", "?");
    }

    public static void ConfigureAudienceManager(String s, Context context)
    {
        _aamServer = s;
        _context = context;
    }

    private static String GetCustomUrlVariables(HashMap hashmap)
    {
        if (hashmap == null || hashmap.size() == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); stringbuilder.append("&").append("c_").append(SanitizeUrlVariableName((String)entry.getKey())).append("=").append(urlEncode(entry.getValue().toString())))
        {
            entry = (java.util.Map.Entry)hashmap.next();
        }

        return stringbuilder.toString();
    }

    private static String GetDataProviderUrlVariables()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (GetUUID() != null)
        {
            stringbuilder.append("&").append("d_uuid").append("=").append(GetUUID());
        }
        if (_dpid != null && _dpid.length() > 0 && _dpuuid != null && _dpuuid.length() > 0)
        {
            stringbuilder.append("&").append("d_dpid").append("=").append(_dpid).append("&").append("d_dpuuid").append("=").append(_dpuuid);
        }
        return stringbuilder.toString();
    }

    public static boolean GetDebugLogging()
    {
        return _debugLogging;
    }

    public static String GetDpid()
    {
        return _dpid;
    }

    public static String GetDpuuid()
    {
        return _dpuuid;
    }

    private static SharedPreferences GetSharedPreferences()
    {
        if (SharedPreferences_pred)
        {
            SharedPreferences_pred = false;
            _prefs = _context.getSharedPreferences("APP_MEASUREMENT_CACHE", 0);
        }
        return _prefs;
    }

    private static android.content.SharedPreferences.Editor GetSharedPreferencesEditor()
    {
        if (SharedPreferencesEditor_pred)
        {
            SharedPreferencesEditor_pred = false;
            _editor = _context.getSharedPreferences("APP_MEASUREMENT_CACHE", 0).edit();
        }
        return _editor;
    }

    private static String GetUUID()
    {
        if (Uuid_pred)
        {
            Uuid_pred = false;
            _uuid = GetSharedPreferences().getString("AAMUserId", null);
        }
        return _uuid;
    }

    private static String GetUrlPrefix()
    {
        if (UrlPrefix_pred)
        {
            UrlPrefix_pred = false;
            _urlPrefix = String.format("http://%s/event?", new Object[] {
                _aamServer
            });
        }
        return _urlPrefix;
    }

    public static HashMap GetVisitorProfile()
    {
        if (_context == null)
        {
            ADBLogErrorFormat("Audience Manager - Unable to retrieve visitor profile from SharedPreferences, context is null", new Object[0]);
            return null;
        }
        if (VisitorProfile_pred)
        {
            VisitorProfile_pred = false;
            _visitorProfile = restoreFromStringify(GetSharedPreferences().getString("AAMUserProfile", null));
        }
        return _visitorProfile;
    }

    private static String SanitizeUrlVariableName(String s)
    {
        return s.replace(".", "_");
    }

    public static void SetDebugLogging(boolean flag)
    {
        _debugLogging = flag;
    }

    public static void SetDpidAndDpuuid(String s, String s1)
    {
        _dpid = s;
        _dpuuid = s1;
    }

    private static void SetUUID(String s)
    {
        if (!s.equals(_uuid))
        {
            _uuid = s;
            s = GetSharedPreferencesEditor();
            s.putString("AAMUserId", _uuid);
            s.commit();
        }
    }

    private static void SetVisitorProfile(HashMap hashmap)
    {
        VisitorProfile_pred = false;
        android.content.SharedPreferences.Editor editor = GetSharedPreferencesEditor();
        if (hashmap != null)
        {
            editor.putString("AAMUserProfile", stringify(hashmap));
        } else
        {
            editor.remove("AAMUserProfile");
        }
        _visitorProfile = hashmap;
        editor.commit();
    }

    public static void SubmitSignal(HashMap hashmap, AudienceManagerCallback audiencemanagercallback)
    {
        if (_aamServer == null || _aamServer.length() == 0)
        {
            ADBLogErrorFormat("Audience Manager - Configure has not been called", new Object[0]);
            if (audiencemanagercallback != null)
            {
                audiencemanagercallback.call(null);
            }
            return;
        } else
        {
            (new Thread(new SubmitSignalTask(hashmap, audiencemanagercallback))).start();
            return;
        }
    }

    private static HashMap restoreFromStringify(String s)
    {
        HashMap hashmap = new HashMap();
        s = splitUsingTokenizer(s, "|||");
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = splitUsingTokenizer(s[i], "~~~");
            if (as.length == 2)
            {
                hashmap.put(as[0], as[1]);
            }
        }

        return hashmap;
    }

    private static String[] splitUsingTokenizer(String s, String s1)
    {
        s1 = new StringTokenizer(s, s1);
        s = new ArrayList(s.length());
        for (; s1.hasMoreTokens(); s.add(s1.nextToken())) { }
        return (String[])s.toArray(new String[0]);
    }

    private static String stringify(HashMap hashmap)
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); stringbuilder.append((String)entry.getKey()).append("~~~").append((String)entry.getValue()).append("|||"))
        {
            entry = (java.util.Map.Entry)hashmap.next();
        }

        return stringbuilder.substring(0, stringbuilder.length() - 3);
    }

    private static String urlEncode(String s)
    {
        if (s == null)
        {
            return null;
        }
        StringBuilder stringbuilder;
        int i;
        int j;
        try
        {
            s = s.getBytes("UTF-8");
            j = s.length;
            stringbuilder = new StringBuilder(j << 1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ADBLogErrorFormat((new StringBuilder()).append("UnsupportedEncodingException : ").append(s.getMessage()).toString(), new Object[0]);
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(encodedChars[s[i] & 0xff]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_30;
_L1:
        s = stringbuilder.toString();
        return s;
    }






}
