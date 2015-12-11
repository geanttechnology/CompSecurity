// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods, MobileConfig, VisitorIDService, RequestHandler

final class AudienceManagerWorker
{

    private static final String AUDIENCE_MANAGER_CUSTOMER_DATA_PREFIX = "c_";
    private static final String AUDIENCE_MANAGER_DATA_PROVIDER_ID_KEY = "d_dpid";
    private static final String AUDIENCE_MANAGER_DATA_PROVIDER_USER_ID_KEY = "d_dpuuid";
    private static final String AUDIENCE_MANAGER_JSON_COOKIE_NAME_KEY = "cn";
    private static final String AUDIENCE_MANAGER_JSON_COOKIE_VALUE_KEY = "cv";
    private static final String AUDIENCE_MANAGER_JSON_DESTS_KEY = "dests";
    private static final String AUDIENCE_MANAGER_JSON_STUFF_KEY = "stuff";
    private static final String AUDIENCE_MANAGER_JSON_URL_KEY = "c";
    private static final String AUDIENCE_MANAGER_JSON_USER_ID_KEY = "uuid";
    private static final String AUDIENCE_MANAGER_SHARED_PREFS_PROFILE_KEY = "AAMUserProfile";
    private static final String AUDIENCE_MANAGER_SHARED_PREFS_USER_ID_KEY = "AAMUserId";
    private static final String AUDIENCE_MANAGER_URL_SUFFIX = "&d_ptfm=android&d_dst=1&d_rtbd=json";
    private static final String AUDIENCE_MANAGER_USER_ID_KEY = "d_uuid";
    private static volatile boolean UrlPrefix_pred = true;
    private static volatile boolean VisitorProfile_pred = true;
    private static String _dpid = null;
    private static String _dpuuid = null;
    private static String _urlPrefix = null;
    private static HashMap _visitorProfile = null;

    AudienceManagerWorker()
    {
    }

    private static String BuildSchemaRequest(Map map)
    {
        if (GetUrlPrefix() == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append(GetUrlPrefix()).append(GetCustomUrlVariables(map)).append(GetDataProviderUrlVariables()).append("&d_ptfm=android&d_dst=1&d_rtbd=json").toString().replace("?&", "?");
        }
    }

    private static String GetCustomUrlVariables(Map map)
    {
        if (map == null || map.size() <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(1024);
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s = (String)entry.getKey();
            Object obj = entry.getValue();
            if (s != null && s.length() > 0 && obj != null && obj.toString().length() > 0 && entry.getValue().getClass() == java/lang/String)
            {
                stringbuilder.append("&").append("c_").append(StaticMethods.URLEncode(SanitizeUrlVariableName(s))).append("=").append(StaticMethods.URLEncode(obj.toString()));
            }
        } while (true);
        return stringbuilder.toString();
    }

    private static String GetDataProviderUrlVariables()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (MobileConfig.getInstance().getVisitorIdServiceEnabled())
        {
            stringbuilder.append(VisitorIDService.sharedInstance().getAAMParameterString());
        }
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

    public static String GetDpid()
    {
        Object obj = new FutureTask(new Callable() {

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                return AudienceManagerWorker._dpid;
            }

        });
        StaticMethods.getAudienceExecutor().execute(((Runnable) (obj)));
        try
        {
            obj = (String)((FutureTask) (obj)).get();
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("Audience Manager - Unable to get Dpid (%s)", new Object[] {
                exception.getMessage()
            });
            return null;
        }
        return ((String) (obj));
    }

    public static String GetDpuuid()
    {
        Object obj = new FutureTask(new Callable() {

            public volatile Object call()
            {
                return call();
            }

            public String call()
            {
                return AudienceManagerWorker._dpuuid;
            }

        });
        StaticMethods.getAudienceExecutor().execute(((Runnable) (obj)));
        try
        {
            obj = (String)((FutureTask) (obj)).get();
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("Audience Manager - Unable to get Dpid (%s)", new Object[] {
                exception.getMessage()
            });
            return null;
        }
        return ((String) (obj));
    }

    private static String GetUUID()
    {
        String s;
        try
        {
            s = StaticMethods.getSharedPreferences().getString("AAMUserId", null);
        }
        catch (StaticMethods.NullContextException nullcontextexception)
        {
            StaticMethods.logErrorFormat("Audience Manager - Error getting uuid from shared preferences (%s).", new Object[] {
                nullcontextexception.getMessage()
            });
            return null;
        }
        return s;
    }

    private static String GetUrlPrefix()
    {
        if (UrlPrefix_pred && MobileConfig.getInstance().mobileUsingAudienceManager())
        {
            UrlPrefix_pred = false;
            String s;
            if (MobileConfig.getInstance().getSSL())
            {
                s = "https";
            } else
            {
                s = "http";
            }
            _urlPrefix = String.format("%s://%s/event?", new Object[] {
                s, MobileConfig.getInstance().getAamServer()
            });
        }
        return _urlPrefix;
    }

    public static HashMap GetVisitorProfile()
    {
        Object obj = new FutureTask(new Callable() {

            public volatile Object call()
            {
                return call();
            }

            public HashMap call()
            {
                if (!AudienceManagerWorker.VisitorProfile_pred) goto _L2; else goto _L1
_L1:
                String s = StaticMethods.getSharedPreferences().getString("AAMUserProfile", null);
                if (s == null) goto _L2; else goto _L3
_L3:
                int i = s.length();
                if (i <= 0) goto _L2; else goto _L4
_L4:
                AudienceManagerWorker._visitorProfile = StaticMethods.mapFromJson(new JSONObject(s));
_L5:
                AudienceManagerWorker.VisitorProfile_pred = false;
_L2:
                return AudienceManagerWorker._visitorProfile;
                Object obj1;
                obj1;
                StaticMethods.logWarningFormat("Audience Manager - Problem accessing profile data (%s)", new Object[] {
                    ((JSONException) (obj1)).getLocalizedMessage()
                });
                  goto _L5
                obj1;
                StaticMethods.logErrorFormat("Audience Manager - Problem accessing profile data (%s)", new Object[] {
                    ((StaticMethods.NullContextException) (obj1)).getMessage()
                });
                  goto _L2
            }

        });
        StaticMethods.getAudienceExecutor().execute(((Runnable) (obj)));
        try
        {
            obj = (HashMap)((FutureTask) (obj)).get();
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("Audience Manager - Unable to retrieve Visitor Profile", new Object[] {
                exception.getMessage()
            });
            return null;
        }
        return ((HashMap) (obj));
    }

    private static void ProcessDestsArray(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getJSONArray("dests");
        int i = 0;
_L1:
        String s;
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s = jsonobject.getJSONObject(i).getString("c");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (s.length() > 0)
        {
            RequestHandler.sendGenericRequest(s, null, 5000, "Audience Manager");
        }
        i++;
          goto _L1
        jsonobject;
        StaticMethods.logDebugFormat("Audience Manager - No destination in response (%s)", new Object[] {
            jsonobject.getLocalizedMessage()
        });
    }

    private static HashMap ProcessStuffArray(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        jsonobject = jsonobject.getJSONArray("stuff");
        int i = 0;
_L1:
        JSONObject jsonobject1;
        if (i >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        jsonobject1 = jsonobject.getJSONObject(i);
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        hashmap.put(jsonobject1.getString("cn"), jsonobject1.getString("cv"));
        i++;
          goto _L1
        jsonobject;
        StaticMethods.logDebugFormat("Audience Manager - No 'stuff' array in response (%s)", new Object[] {
            jsonobject.getLocalizedMessage()
        });
        return hashmap;
    }

    public static void Reset()
    {
        StaticMethods.getAudienceExecutor().execute(new Runnable() {

            public void run()
            {
                AudienceManagerWorker.SetUUID(null);
                AudienceManagerWorker.SetVisitorProfile(null);
            }

        });
    }

    private static String SanitizeUrlVariableName(String s)
    {
        return s.replace(".", "_");
    }

    public static void SetDpidAndDpuuid(final String newDpid, final String newDpuuid)
    {
        StaticMethods.getAudienceExecutor().execute(new Runnable() {

            final String val$newDpid;
            final String val$newDpuuid;

            public void run()
            {
                AudienceManagerWorker._dpid = newDpid;
                AudienceManagerWorker._dpuuid = newDpuuid;
            }

            
            {
                newDpid = s;
                newDpuuid = s1;
                super();
            }
        });
    }

    private static void SetUUID(String s)
    {
        android.content.SharedPreferences.Editor editor;
        try
        {
            editor = StaticMethods.getSharedPreferencesEditor();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Audience Manager - Error updating uuid in shared preferences (%s)", new Object[] {
                s.getMessage()
            });
            return;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        editor.remove("AAMUserId");
_L2:
        editor.commit();
        return;
        editor.putString("AAMUserId", s);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void SetVisitorProfile(Map map)
    {
        VisitorProfile_pred = false;
        android.content.SharedPreferences.Editor editor;
        try
        {
            editor = StaticMethods.getSharedPreferencesEditor();
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            StaticMethods.logErrorFormat("Audience Manager - Error updating visitor profile (%s)", new Object[] {
                map.getMessage()
            });
            return;
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        editor.putString("AAMUserProfile", (new JSONObject(map)).toString());
        _visitorProfile = new HashMap(map);
_L2:
        editor.commit();
        return;
        editor.remove("AAMUserProfile");
        _visitorProfile = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void SubmitSignal(Map map, AudienceManager.AudienceManagerCallback audiencemanagercallback)
    {
        StaticMethods.getAudienceExecutor().execute(new SubmitSignalTask(map, audiencemanagercallback));
    }




/*
    static boolean access$002(boolean flag)
    {
        VisitorProfile_pred = flag;
        return flag;
    }

*/



/*
    static HashMap access$102(HashMap hashmap)
    {
        _visitorProfile = hashmap;
        return hashmap;
    }

*/



/*
    static String access$202(String s)
    {
        _dpuuid = s;
        return s;
    }

*/



/*
    static String access$302(String s)
    {
        _dpid = s;
        return s;
    }

*/






    private class SubmitSignalTask
        implements Runnable
    {

        public final AudienceManager.AudienceManagerCallback callback;
        public final Map data;

        public void run()
        {
            final HashMap callbackData = new HashMap();
            boolean flag = MobileConfig.getInstance().mobileUsingAudienceManager();
            if (flag) goto _L2; else goto _L1
_L1:
            if (callback != null)
            {
                (new Thread(new Runnable() {

                    final SubmitSignalTask this$0;
                    final HashMap val$callbackData;

                    public void run()
                    {
                        callback.call(callbackData);
                    }

                
                {
                    this$0 = SubmitSignalTask.this;
                    callbackData = hashmap;
                    super();
                }
                })).start();
            }
_L4:
            return;
_L2:
            if (MobileConfig.getInstance().getPrivacyStatus() != MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_OUT)
            {
                break MISSING_BLOCK_LABEL_96;
            }
            StaticMethods.logDebugFormat("Audience Manager - Privacy status is set to opt out, no signals will be submitted.", new Object[0]);
            if (callback == null) goto _L4; else goto _L3
_L3:
            (new Thread(new _cls1())).start();
            return;
            Object obj;
            obj = AudienceManagerWorker.BuildSchemaRequest(data);
            if (((String) (obj)).length() > 1)
            {
                break MISSING_BLOCK_LABEL_148;
            }
            StaticMethods.logWarningFormat("Audience Manager - Unable to create URL object", new Object[0]);
            if (callback == null) goto _L4; else goto _L5
_L5:
            (new Thread(new _cls1())).start();
            return;
            byte abyte0[];
            StaticMethods.logDebugFormat("Audience Manager - request (%s)", new Object[] {
                obj
            });
            abyte0 = RequestHandler.retrieveData(((String) (obj)), null, 2000, "Audience Manager");
            String s = "";
            obj = s;
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_203;
            }
            obj = s;
            if (abyte0.length > 0)
            {
                obj = new String(abyte0, "UTF-8");
            }
            obj = new JSONObject(((String) (obj)));
            AudienceManagerWorker.ProcessDestsArray(((JSONObject) (obj)));
            AudienceManagerWorker.SetUUID(((JSONObject) (obj)).getString("uuid"));
            obj = AudienceManagerWorker.ProcessStuffArray(((JSONObject) (obj)));
            if (((HashMap) (obj)).size() > 0)
            {
                break MISSING_BLOCK_LABEL_273;
            }
            StaticMethods.logWarningFormat("Audience Manager - response was empty", new Object[0]);
            if (callback == null) goto _L4; else goto _L6
_L6:
            (new Thread(new _cls1())).start();
            return;
            StaticMethods.logDebugFormat("Audience Manager - response (%s)", new Object[] {
                obj
            });
            AudienceManagerWorker.SetVisitorProfile(((Map) (obj)));
            callbackData.putAll(((Map) (obj)));
            if (callback != null)
            {
                (new Thread(new _cls1())).start();
                return;
            }
              goto _L4
            Object obj1;
            obj1;
            StaticMethods.logWarningFormat("Audience Manager - Unable to decode server response (%s)", new Object[] {
                ((UnsupportedEncodingException) (obj1)).getLocalizedMessage()
            });
            if (callback != null)
            {
                (new Thread(new _cls1())).start();
                return;
            }
              goto _L4
            obj1;
            StaticMethods.logWarningFormat("Audience Manager - Unable to parse JSON data (%s)", new Object[] {
                ((JSONException) (obj1)).getLocalizedMessage()
            });
            if (callback != null)
            {
                (new Thread(new _cls1())).start();
                return;
            }
              goto _L4
            obj1;
            StaticMethods.logWarningFormat("Audience Manager - Unexpected error parsing result (%s)", new Object[] {
                ((Exception) (obj1)).getLocalizedMessage()
            });
            if (callback == null) goto _L4; else goto _L7
_L7:
            (new Thread(new _cls1())).start();
            return;
            obj1;
            if (callback != null)
            {
                (new Thread(new _cls1())).start();
            }
            throw obj1;
        }

        public SubmitSignalTask(Map map, AudienceManager.AudienceManagerCallback audiencemanagercallback)
        {
            data = map;
            callback = audiencemanagercallback;
        }
    }

}
