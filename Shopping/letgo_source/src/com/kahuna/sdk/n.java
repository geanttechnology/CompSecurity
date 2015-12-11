// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.os.Bundle;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            m, k, i, j, 
//            v, o

public class n
{

    private static n f;
    private Object a;
    private String b;
    private Bundle c;
    private long d;
    private JSONObject e;

    public n()
    {
        a = new Object();
    }

    protected static void a()
    {
        Object obj1 = b();
        Bundle bundle;
        String s;
        long l;
        synchronized (((n) (obj1)).a)
        {
            s = ((n) (obj1)).b;
            l = ((n) (obj1)).d;
            bundle = ((n) (obj1)).c;
            obj1 = ((n) (obj1)).e;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (m.m() == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        obj = bundle;
        if (bundle != null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj = new Bundle();
        a(s, l, ((Bundle) (obj)), ((JSONObject) (obj1)));
        return;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            Log.e("Kahuna", (new StringBuilder()).append("Caught exception when checking pending in-app message on activity start: ").append(exception).toString());
        }
        return;
    }

    private static void a(String s, long l, Bundle bundle, JSONObject jsonobject)
    {
        n n1 = b();
        if (System.currentTimeMillis() / 1000L >= l) goto _L2; else goto _L1
_L1:
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        Map map;
        Iterator iterator;
        boolean flag;
        map = k.i().d().a();
        iterator = jsonobject.keys();
        flag = true;
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        String s1;
        Object obj;
        obj = (String)iterator.next();
        s1 = (String)jsonobject.opt(((String) (obj)));
        if (v.a(((String) (obj))) || v.a(s1)) goto _L8; else goto _L7
_L7:
        obj = (Set)map.get(obj);
        if (v.a(((Set) (obj)))) goto _L8; else goto _L9
_L9:
        obj = ((Set) (obj)).iterator();
_L13:
        if (!((Iterator) (obj)).hasNext()) goto _L11; else goto _L10
_L10:
        boolean flag1 = s1.equals((String)((Iterator) (obj)).next());
        if (!flag1) goto _L13; else goto _L12
_L12:
        flag = false;
_L11:
        if (flag) goto _L8; else goto _L6
_L6:
        if (flag)
        {
            if (m.a)
            {
                Log.d("Kahuna", "In-App Message recieved, but was restricted due to non-matching user not logged into the app");
            }
            return;
        }
        break MISSING_BLOCK_LABEL_199;
        Exception exception;
        exception;
        flag = true;
          goto _L8
        if (m.a)
        {
            Log.d("Kahuna", "Calling in-app message listener");
        }
        m.m().a(s, bundle);
_L14:
        synchronized (n1.a)
        {
            n1.b = null;
            n1.c = null;
            n1.d = 0L;
            n1.e = null;
        }
        return;
        bundle;
        s;
        JVM INSTR monitorexit ;
        throw bundle;
_L2:
        if (m.a)
        {
            Log.d("Kahuna", "Supressing in-app message due to expiration time");
        }
        if (true) goto _L14; else goto _L4
_L4:
        flag = false;
          goto _L6
    }

    protected static void a(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        Bundle bundle;
        long l;
        s = jsonobject.optString("k_m");
        l = jsonobject.optLong("k_t", System.currentTimeMillis() / 1000L + 7200L);
        bundle = new Bundle();
        if (v.a(s)) goto _L1; else goto _L3
_L3:
        JSONObject jsonobject1;
        jsonobject.remove("k_m");
        jsonobject.remove("k_t");
        jsonobject1 = jsonobject.optJSONObject("k_c");
        if (jsonobject1 != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        if (!jsonobject.has("k_c"))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        if (!m.a) goto _L1; else goto _L4
_L4:
        Log.d("Kahuna", "In-App Message recieved, but was restricted due to non-matching user not logged into the app");
        return;
        Object obj;
        jsonobject.remove("k_c");
        obj = jsonobject.keys();
_L6:
        String s1;
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_309;
            }
            s1 = (String)((Iterator) (obj)).next();
            obj1 = jsonobject.opt(s1);
        } while (obj1 == null);
        if (obj1 instanceof Boolean)
        {
            bundle.putBoolean(s1, ((Boolean)obj1).booleanValue());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Integer)
        {
            bundle.putInt(s1, ((Integer)obj1).intValue());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Long)
        {
            bundle.putLong(s1, ((Long)obj1).longValue());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Float)
        {
            bundle.putFloat(s1, ((Float)obj1).floatValue());
            continue; /* Loop/switch isn't completed */
        }
        if (obj1 instanceof Double)
        {
            bundle.putDouble(s1, ((Double)obj1).doubleValue());
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            bundle.putString(s1, obj1.toString());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.e("Kahuna", (new StringBuilder()).append("Caught exception in handle InAppMessage Response handler: ").append(jsonobject).toString());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj = b();
        if (m.m() != null)
        {
            a(s, l, bundle, jsonobject1);
            return;
        }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("In-App Message recieved, but no listener exists. Holding message until: ").append(l).toString());
        }
        synchronized (((n) (obj)).a)
        {
            obj.b = s;
            obj.c = bundle;
            obj.d = l;
            obj.e = jsonobject1;
        }
        return;
        exception;
        jsonobject;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static n b()
    {
        if (f == null)
        {
            f = new n();
        }
        return f;
    }
}
