// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.ahd;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            v, c, m, a

public class r
{

    protected static a a(Context context, boolean flag)
    {
        Object obj = null;
        JSONObject jsonobject = null;
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        ArrayList arraylist1;
        SharedPreferences sharedpreferences;
        sharedpreferences = n(context);
        arraylist = new ArrayList();
        arraylist1 = new ArrayList();
        String s = sharedpreferences.getString("events", null);
        Object obj1 = arraylist;
        if (v.a(s)) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j1;
        jsonarray = JSONArrayInstrumentation.init(s);
        j1 = jsonarray.length();
        int i1;
        i1 = 0;
        context = jsonobject;
_L7:
        obj = context;
        obj1 = arraylist;
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        obj1 = context;
        jsonobject = jsonarray.getJSONObject(i1);
        obj1 = context;
        obj = com.kahuna.sdk.c.a(jsonobject, flag);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj1 = context;
        arraylist.add(obj);
          goto _L4
        obj = context;
        if (context == null)
        {
            obj = s;
        }
        obj1 = obj;
        arraylist1.add(jsonobject.optString("event"));
        context = ((Context) (obj));
          goto _L4
        obj;
        context = ((Context) (obj1));
_L5:
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting saved events: ").append(obj).toString());
        }
        obj1 = new ArrayList();
        sharedpreferences.edit().putString("events", null);
        obj = context;
_L2:
        context = new a(((List) (obj1)), ((String) (obj)), arraylist1);
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
        obj;
        context = null;
        if (true) goto _L5; else goto _L4
_L4:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected static String a(Context context)
    {
        return n(context).getString("device_id", "");
    }

    protected static Map a(Context context, String s, Class class1)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        SharedPreferences sharedpreferences;
        hashmap = new HashMap();
        sharedpreferences = n(context);
        context = sharedpreferences.getString(s, null);
        if (v.a(context)) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray;
        int j1;
        jsonarray = JSONArrayInstrumentation.init(context);
        j1 = jsonarray.length();
        int i1 = 0;
_L13:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = jsonarray.getJSONObject(i1);
        iterator = jsonobject.keys();
_L8:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        String s1 = (String)iterator.next();
        context = null;
        if (class1 != java/lang/String) goto _L7; else goto _L6
_L6:
        context = jsonobject.optString(s1, null);
_L9:
        hashmap.put(s1, context);
          goto _L8
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting stored internal map: ").append(context).toString());
        }
        context = new HashMap();
        sharedpreferences.edit().putString(s, null);
_L14:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
_L7:
        if (class1 != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        context = Long.valueOf(jsonobject.optLong(s1));
          goto _L9
        if (class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_227;
        }
        context = Integer.valueOf(jsonobject.optInt(s1));
          goto _L9
        if (class1 != java/lang/Boolean) goto _L11; else goto _L10
_L10:
        context = Boolean.valueOf(jsonobject.optBoolean(s1));
          goto _L9
_L11:
        if (class1 != java/lang/Double) goto _L9; else goto _L12
_L12:
        double d1 = jsonobject.optDouble(s1);
        context = Double.valueOf(d1);
          goto _L9
_L5:
        i1++;
          goto _L13
_L2:
        context = hashmap;
          goto _L14
        context;
        throw context;
          goto _L9
    }

    public static Map a(m m1, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to get any data from Kahuna preferences externally from the Kahuna SDK. Aborting!");
        m1 = new HashMap();
_L5:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return m1;
_L3:
        m1 = new HashMap();
        context = n(context);
        try
        {
            Object obj = context.getString("geofencing_regions", null);
            if (!v.a(((String) (obj))))
            {
                obj = JSONObjectInstrumentation.init(((String) (obj)));
                Iterator iterator = ((JSONObject) (obj)).keys();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    m1.put(s, Long.valueOf(((JSONObject) (obj)).getLong(s)));
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (m m1) { }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting saved region Ids: ").append(m1).toString());
        }
        m1 = new HashMap();
        context.edit().putString("geofencing_regions", null);
        if (true) goto _L5; else goto _L4
_L4:
        m1;
        throw m1;
    }

    protected static void a(long l1, Context context)
    {
        n(context).edit().putLong("last_flush_timestamp", l1).commit();
    }

    protected static void a(Context context, JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        context = n(context);
        android.content.SharedPreferences.Editor editor;
        editor = context.edit();
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        context = jsonobject.toString();
_L4:
        editor.putString("sdk_configuration", context).commit();
        return;
        context;
        if (!m.a) goto _L1; else goto _L3
_L3:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving SDK configuration: ").append(context).toString());
        return;
        context = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L4
    }

    public static void a(m m1, Context context, String s)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to save any data to Kahuna preferences externally from the Kahuna SDK. Aborting!");
_L5:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L3:
        n(context).edit().putString("last_entered_region_id", s).commit();
        if (true) goto _L5; else goto _L4
_L4:
        m1;
        throw m1;
    }

    public static void a(m m1, Context context, JSONArray jsonarray)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to save any data to Kahuna preferences externally from the Kahuna SDK. Aborting!");
_L4:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L3:
        m1 = n(context);
        context = m1.edit();
        if (jsonarray instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        m1 = jsonarray.toString();
_L6:
        context.putString("tracked_ibeacons", m1).commit();
          goto _L4
        m1;
        if (!m.a) goto _L4; else goto _L5
_L5:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving tracked iBeacons: ").append(m1).toString());
          goto _L4
        m1;
        throw m1;
        m1 = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L6
    }

    public static void a(m m1, List list, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to save any data to Kahuna preferences externally from the Kahuna SDK. Aborting!");
_L4:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L3:
        context = n(context);
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        context.edit().putString("geofencing_objects_list", null).commit();
          goto _L4
        try
        {
            m1 = new JSONArray();
            for (list = list.iterator(); list.hasNext(); m1.put(((ahd)list.next()).g())) { }
            break MISSING_BLOCK_LABEL_143;
        }
        // Misplaced declaration of an exception variable
        catch (m m1) { }
        finally
        {
            throw m1;
        }
        if (!m.a) goto _L4; else goto _L5
_L5:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving geofences: ").append(m1).toString());
          goto _L4
        list = context.edit();
        if (m1 instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        m1 = m1.toString();
_L6:
        list.putString("geofencing_objects_list", m1).commit();
          goto _L4
        m1 = JSONArrayInstrumentation.toString((JSONArray)m1);
          goto _L6
    }

    public static void a(m m1, Map map, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to save any data to Kahuna preferences externally from the Kahuna SDK. Aborting!");
_L4:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L3:
        context = n(context);
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        context.edit().putString("geofencing_regions", null).commit();
          goto _L4
        try
        {
            m1 = new JSONObject();
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); m1.put(s, map.get(s)))
            {
                s = (String)iterator.next();
            }

            break MISSING_BLOCK_LABEL_158;
        }
        // Misplaced declaration of an exception variable
        catch (m m1) { }
        finally
        {
            throw m1;
        }
        if (!m.a) goto _L4; else goto _L5
_L5:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving region Ids: ").append(m1).toString());
          goto _L4
        map = context.edit();
        if (m1 instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        m1 = m1.toString();
_L6:
        map.putString("geofencing_regions", m1).commit();
          goto _L4
        m1 = JSONObjectInstrumentation.toString((JSONObject)m1);
          goto _L6
    }

    protected static void a(String s, Context context)
    {
        n(context).edit().putString("device_id", s).commit();
    }

    protected static void a(List list, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = n(context);
        if (list != null) goto _L2; else goto _L1
_L1:
        context.edit().putString("events", null).commit();
_L6:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONArray jsonarray;
        int j1;
        int k1;
        jsonarray = new JSONArray();
        k1 = list.size();
        j1 = k1 - m.b;
        int i1;
        i1 = j1;
        if (j1 < 0)
        {
            i1 = 0;
        }
_L9:
        if (i1 >= k1) goto _L4; else goto _L3
_L3:
        JSONObject jsonobject = ((c)list.get(i1)).l();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        try
        {
            jsonarray.put(jsonobject);
            break MISSING_BLOCK_LABEL_203;
        }
        // Misplaced declaration of an exception variable
        catch (List list) { }
        finally
        {
            throw list;
        }
          goto _L5
_L4:
        context = context.edit();
        if (jsonarray instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        list = jsonarray.toString();
_L8:
        context.putString("events", list).commit();
          goto _L6
_L5:
        if (!m.a) goto _L6; else goto _L7
_L7:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving events: ").append(list).toString());
          goto _L6
        list = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L8
        i1++;
          goto _L9
    }

    protected static void a(Map map, Context context)
    {
        a(map, context, "user_credentials");
    }

    private static void a(Map map, Context context, String s)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = n(context);
        if (map != null) goto _L2; else goto _L1
_L1:
        context.edit().putString(s, null).commit();
_L6:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        obj = map.keySet().iterator();
_L5:
        String s1;
        Object obj1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_232;
        }
        s1 = (String)((Iterator) (obj)).next();
        obj1 = map.get(s1);
        if (!(obj1 instanceof String) || !v.a((String)obj1)) goto _L4; else goto _L3
_L3:
        if (m.a)
        {
            Log.d("Kahuna", "Ignoring attempt to save null or empty string value in internal hashmap");
        }
          goto _L5
        map;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception saving user map: ").append(map).toString());
        }
        context.edit().putString(s, null).commit();
          goto _L6
        map;
        throw map;
_L4:
label0:
        {
            if (!(obj1 instanceof JSONArray) && !(obj1 instanceof JSONObject))
            {
                break label0;
            }
            if (m.a)
            {
                Log.d("Kahuna", "Ignoring attempt to save JSON Objects in internal hashmap");
            }
        }
          goto _L5
        jsonobject.put(s1, obj1);
          goto _L5
        obj = context.edit();
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        map = jsonobject.toString();
_L7:
        ((android.content.SharedPreferences.Editor) (obj)).putString(s, map).commit();
          goto _L6
        map = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L7
    }

    protected static void a(Set set, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = n(context);
        if (set != null) goto _L2; else goto _L1
_L1:
        context.edit().putString("dirty_user_attributes", null).commit();
_L4:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONArray jsonarray;
        try
        {
            jsonarray = new JSONArray();
            for (set = set.iterator(); set.hasNext(); jsonarray.put((String)set.next())) { }
            break MISSING_BLOCK_LABEL_120;
        }
        // Misplaced declaration of an exception variable
        catch (Set set) { }
        finally
        {
            throw set;
        }
        if (!m.a) goto _L4; else goto _L3
_L3:
        Log.d("Kahuna", (new StringBuilder()).append("Exception saving dirty user attributes: ").append(set).toString());
          goto _L4
        context = context.edit();
        if (jsonarray instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        set = jsonarray.toString();
_L5:
        context.putString("dirty_user_attributes", set).commit();
          goto _L4
        set = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
          goto _L5
    }

    protected static void a(JSONObject jsonobject, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        context = n(context).edit();
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        jsonobject = jsonobject.toString();
_L3:
        context.putString("debug_manager_storage_object", jsonobject).commit();
_L2:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L3
        jsonobject;
        throw jsonobject;
    }

    protected static void a(boolean flag, Context context)
    {
        n(context).edit().putBoolean("push_enabled", flag).commit();
    }

    public static List b(m m1, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to get any data from Kahuna preferences externally from the Kahuna SDK. Aborting!");
        m1 = new ArrayList();
_L7:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return m1;
_L3:
        ArrayList arraylist;
        arraylist = new ArrayList();
        context = n(context);
        Object obj = context.getString("geofencing_objects_list", null);
        m1 = arraylist;
        if (v.a(((String) (obj))))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = JSONArrayInstrumentation.init(((String) (obj)));
        int i1 = 0;
_L5:
        m1 = arraylist;
        if (i1 >= ((JSONArray) (obj)).length())
        {
            continue; /* Loop/switch isn't completed */
        }
        m1 = ahd.a(((JSONArray) (obj)).getJSONObject(i1));
        if (m1 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        arraylist.add(m1);
        i1++;
        if (true) goto _L5; else goto _L4
_L4:
        m1;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting saved geofences: ").append(m1).toString());
        }
        m1 = new ArrayList();
        context.edit().putString("geofencing_objects_list", null);
        if (true) goto _L7; else goto _L6
_L6:
        m1;
        throw m1;
    }

    private static Map b(Context context, String s, Class class1)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        SharedPreferences sharedpreferences;
        hashmap = new HashMap();
        sharedpreferences = n(context);
        context = sharedpreferences.getString(s, null);
        if (v.a(context)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        Iterator iterator;
        jsonobject = JSONObjectInstrumentation.init(context);
        iterator = jsonobject.keys();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        String s1 = (String)iterator.next();
        if (class1 != java/lang/String) goto _L5; else goto _L4
_L4:
        context = jsonobject.optString(s1, null);
_L7:
        hashmap.put(s1, context);
          goto _L6
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting stored internal map: ").append(context).toString());
        }
        context = new HashMap();
        sharedpreferences.edit().putString(s, null);
_L8:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
_L5:
        if (class1 != java/lang/Long)
        {
            break MISSING_BLOCK_LABEL_179;
        }
        context = Long.valueOf(jsonobject.optLong(s1));
          goto _L7
        if (class1 != java/lang/Integer)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        context = Integer.valueOf(jsonobject.optInt(s1));
          goto _L7
        if (class1 != java/lang/Boolean)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        context = Boolean.valueOf(jsonobject.optBoolean(s1));
          goto _L7
        if (class1 != java/lang/Double)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        double d1 = jsonobject.optDouble(s1);
        context = Double.valueOf(d1);
          goto _L7
_L2:
        context = hashmap;
          goto _L8
        context;
        throw context;
        context = null;
          goto _L7
    }

    protected static void b(long l1, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        n(context).edit().putLong("event_number", l1).commit();
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    protected static void b(String s, Context context)
    {
        n(context).edit().putString("prev_push_token", s).commit();
    }

    protected static void b(Map map, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = n(context);
        if (map != null) goto _L2; else goto _L1
_L1:
        context.edit().putString("user_credentials_v2", null).commit();
_L7:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
_L2:
        JSONObject jsonobject;
        Object obj;
        jsonobject = new JSONObject();
        obj = map.keySet().iterator();
_L9:
        String s;
        JSONArray jsonarray;
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_240;
            }
            s = (String)((Iterator) (obj)).next();
            obj1 = (Set)map.get(s);
        } while (v.a(((Set) (obj1))));
        jsonarray = new JSONArray();
        obj1 = ((Set) (obj1)).iterator();
_L6:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        String s1 = (String)((Iterator) (obj1)).next();
        if (!v.a(s1))
        {
            jsonarray.put(s1);
        }
        if (true) goto _L6; else goto _L5
_L5:
        map;
        if (m.a)
        {
            Log.e("Kahuna", (new StringBuilder()).append("Exception saving user credentials: ").append(map).toString());
        }
        context.edit().putString("user_credentials_v2", null).commit();
          goto _L7
        map;
        throw map;
_L4:
        if (jsonarray.length() <= 0) goto _L9; else goto _L8
_L8:
        jsonobject.put(s, jsonarray);
          goto _L9
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Saving User Credentials: ").append(jsonobject).toString());
        }
        obj = context.edit();
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        map = jsonobject.toString();
_L10:
        ((android.content.SharedPreferences.Editor) (obj)).putString("user_credentials_v2", map).commit();
          goto _L7
        map = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L10
    }

    protected static boolean b(Context context)
    {
        return n(context).getBoolean("push_enabled", true);
    }

    protected static String c(Context context)
    {
        return n(context).getString("prev_push_token", "");
    }

    public static String c(m m1, Context context)
    {
        Object obj = null;
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        if (m1 == null) goto _L2; else goto _L1
_L1:
        if (m1 instanceof m) goto _L3; else goto _L2
_L2:
        Log.e("Kahuna", "You cannot request to get any data from Kahuna preferences externally from the Kahuna SDK. Aborting!");
        m1 = obj;
_L5:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return m1;
_L3:
        m1 = n(context).getString("last_entered_region_id", null);
        if (true) goto _L5; else goto _L4
_L4:
        m1;
        throw m1;
    }

    protected static void c(String s, Context context)
    {
        n(context).edit().putString("prev_sdk_version", s).commit();
    }

    protected static void c(Map map, Context context)
    {
        a(map, context, "user_attributes");
    }

    protected static Map d(Context context)
    {
        return b(context, "user_credentials", java/lang/String);
    }

    protected static void d(Map map, Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        a(map, context, "received_push_message_ids");
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    protected static Map e(Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        SharedPreferences sharedpreferences;
        hashmap = new HashMap();
        sharedpreferences = n(context);
        context = sharedpreferences.getString("user_credentials_v2", null);
        if (v.a(context)) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        context = JSONObjectInstrumentation.init(context);
        iterator = context.keys();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        HashSet hashset;
        String s;
        JSONArray jsonarray;
        hashset = new HashSet();
        s = (String)iterator.next();
        jsonarray = context.optJSONArray(s);
        if (jsonarray == null) goto _L5; else goto _L4
_L4:
        int j1 = jsonarray.length();
        for (int i1 = 0; i1 < j1; i1++)
        {
            try
            {
                String s1 = jsonarray.optString(i1);
                if (!v.a(s1))
                {
                    hashset.add(s1);
                }
                break MISSING_BLOCK_LABEL_220;
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            finally
            {
                throw context;
            }
            break MISSING_BLOCK_LABEL_148;
        }

        hashmap.put(s, hashset);
          goto _L5
_L6:
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting stored user credentials map: ").append(context).toString());
        }
        context = new HashMap();
        sharedpreferences.edit().putString("user_credentials_v2", null);
_L7:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
_L2:
        context = hashmap;
        if (true) goto _L7; else goto _L6
    }

    protected static Map f(Context context)
    {
        return b(context, "user_attributes", java/lang/String);
    }

    protected static Set g(Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        HashSet hashset;
        SharedPreferences sharedpreferences;
        hashset = new HashSet();
        sharedpreferences = n(context);
        Object obj = sharedpreferences.getString("dirty_user_attributes", null);
        context = hashset;
        if (v.a(((String) (obj)))) goto _L2; else goto _L1
_L1:
        int j1;
        obj = JSONArrayInstrumentation.init(((String) (obj)));
        j1 = ((JSONArray) (obj)).length();
        int i1 = 0;
_L3:
        context = hashset;
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(((JSONArray) (obj)).optString(i1));
        i1++;
        if (true) goto _L3; else goto _L2
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting saved dirty user attributes: ").append(context).toString());
        }
        context = new HashSet();
        sharedpreferences.edit().putString("dirty_user_attributes", null);
_L2:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    protected static long h(Context context)
    {
        return n(context).getLong("last_flush_timestamp", 0L);
    }

    protected static JSONObject i(Context context)
    {
        Object obj;
        obj = null;
        context = n(context);
        String s = context.getString("sdk_configuration", null);
        context = ((Context) (obj));
        if (!v.a(s))
        {
            context = JSONObjectInstrumentation.init(s);
        }
_L2:
        obj = context;
        if (context == null)
        {
            obj = new JSONObject();
        }
        return ((JSONObject) (obj));
        Exception exception;
        exception;
        context = ((Context) (obj));
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting SDK configuration: ").append(exception).toString());
            context = ((Context) (obj));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static String j(Context context)
    {
        return n(context).getString("prev_sdk_version", "0");
    }

    protected static Map k(Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = b(context, "received_push_message_ids", java/lang/Long);
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    protected static JSONObject l(Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        context = n(context);
        context = JSONObjectInstrumentation.init(context.getString("debug_manager_storage_object", "{}"));
_L2:
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return context;
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting internal Debug Manager preferences: ").append(context).toString());
        }
        context = new JSONObject();
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }

    protected static long m(Context context)
    {
        com/kahuna/sdk/r;
        JVM INSTR monitorenter ;
        long l1 = n(context).getLong("event_number", 1L);
        com/kahuna/sdk/r;
        JVM INSTR monitorexit ;
        return l1;
        context;
        throw context;
    }

    private static SharedPreferences n(Context context)
    {
        return context.getSharedPreferences("com.kahuna.sdk.android", 0);
    }
}
