// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.smule.android.network.managers:
//            UserManager

public class a
{

    protected static a a;
    private static final String c = com/smule/android/network/managers/a.getSimpleName();
    protected Context b;
    private List d;
    private Map e;
    private boolean f;
    private String g;
    private Map h;
    private Map i;
    private long j;
    private long k;
    private boolean l;
    private AtomicBoolean m;
    private final LinkedList n = new LinkedList();
    private ArrayList o;

    private a()
    {
        d = new ArrayList();
        e = null;
        f = false;
        g = "{}";
        h = null;
        i = new HashMap();
        j = 0L;
        k = 0L;
        l = false;
        m = new AtomicBoolean(false);
        o = new ArrayList();
    }

    public static a a()
    {
        com/smule/android/network/managers/a;
        JVM INSTR monitorenter ;
        a a1;
        if (a == null)
        {
            a = new a();
            a.b = com.smule.android.network.core.b.d().e();
            a.e();
            a.a(((Collection) (com.smule.android.network.core.b.d().m())));
        }
        a1 = a;
        com/smule/android/network/managers/a;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    public static a a(Context context)
    {
        com/smule/android/network/managers/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new a();
            a.a(((Collection) (com.smule.android.network.core.b.d().m())));
            a.b = context;
            a.e();
        }
        a.b = context;
        context = a;
        com/smule/android/network/managers/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private Map a(JsonNode jsonnode)
    {
        HashMap hashmap = new HashMap();
        jsonnode = jsonnode.fields();
        do
        {
            if (!jsonnode.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)jsonnode.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (JsonNode)((java.util.Map.Entry) (obj)).getValue();
            if (s != null && obj != null)
            {
                hashmap.put(s, obj);
            }
        } while (true);
        return hashmap;
    }

    private void a(Collection collection)
    {
        d.clear();
        if (collection != null)
        {
            d.addAll(collection);
        }
        if (!collection.contains("appFamily"))
        {
            d.add("appFamily");
        }
    }

    private void a(Map map)
    {
        Log.d(c, "Dump start");
        if (map != null)
        {
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); Log.d(c, (new StringBuilder()).append(s).append('=').append(((Map)map.get(s)).toString()).toString()))
            {
                s = (String)iterator.next();
            }

        } else
        {
            Log.d(c, "No settings loaded");
        }
        Log.d(c, "Dump end");
    }

    private void a(Map map, JsonNode jsonnode)
    {
        java.util.Map.Entry entry;
        for (jsonnode = jsonnode.fields(); jsonnode.hasNext(); map.put(entry.getKey(), a((JsonNode)entry.getValue())))
        {
            entry = (java.util.Map.Entry)jsonnode.next();
        }

        g();
    }

    private void a(Map map, String s)
    {
        JsonNode jsonnode = ((JsonNode)com.smule.android.f.e.a().readValue(s, com/fasterxml/jackson/databind/JsonNode)).get("data");
        s = jsonnode;
        if (jsonnode != null)
        {
            s = jsonnode;
            if (jsonnode.get("settings") != null)
            {
                s = jsonnode.get("settings");
            }
        }
        a(map, ((JsonNode) (s)));
    }

    static boolean a(a a1)
    {
        return a1.f();
    }

    static AtomicBoolean b(a a1)
    {
        return a1.m;
    }

    private void b(String s)
    {
        com.smule.android.f.h.a().a(s, new Object[0]);
    }

    private void b(Map map, String s)
    {
        a(map, (JsonNode)com.smule.android.f.e.a().readValue(s, com/fasterxml/jackson/databind/JsonNode));
    }

    static void c(a a1)
    {
        a1.i();
    }

    private void e()
    {
        String s;
        s = b.getSharedPreferences("APP_SETTINGS", 0).getString("LAST_SETTINGS_RESPONSE_BODY", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        HashMap hashmap;
        HashMap hashmap1;
        hashmap = new HashMap();
        a(hashmap, s);
        hashmap1 = new HashMap();
        a(hashmap1, s);
        Log.i(c, (new StringBuilder()).append("Restoring application config settings from shared preferences : ").append(s).toString());
        this;
        JVM INSTR monitorenter ;
        e = hashmap;
        f = true;
        g = s;
        h = hashmap1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (IOException ioexception)
        {
            Log.e(c, (new StringBuilder()).append("Error parsing json response from backup: ").append(s).toString(), ioexception);
        }
    }

    private boolean f()
    {
        l = true;
        long l1 = System.currentTimeMillis();
        if (h())
        {
            return true;
        }
        if (d.size() <= 0)
        {
            Log.e(c, "No setting IDs set to retrieve.");
            return false;
        }
        HashMap hashmap1 = new HashMap();
        o o1 = com.smule.android.network.a.a.a().a(d);
        if (o1.a())
        {
            p.a(b.getSharedPreferences("APP_SETTINGS", 0).edit().putString("LAST_SETTINGS_RESPONSE_BODY", o1.h));
            if (o1.b != 0)
            {
                Log.w(c, (new StringBuilder()).append("Bad response code from server : ").append(o1.b).toString());
                return false;
            }
        } else
        {
            com.smule.android.network.core.b.a(o1);
            Log.e(c, "There was a problem with the fetchAllConfigSettings() call!");
            return false;
        }
        Object obj = o1.j;
        a(hashmap1, ((JsonNode) (obj)));
        HashMap hashmap = new HashMap();
        obj = ((JsonNode) (obj)).toString();
        try
        {
            b(hashmap, ((String) (obj)));
        }
        catch (IOException ioexception)
        {
            Log.e(c, (new StringBuilder()).append("Unable to create copy:").append(ioexception).toString());
            ioexception = hashmap1;
        }
        Log.i(c, (new StringBuilder()).append("Read new application config settings from server : ").append(o1.h).toString());
        this;
        JVM INSTR monitorenter ;
        e = hashmap1;
        f = false;
        g = ((String) (obj));
        h = hashmap;
        this;
        JVM INSTR monitorexit ;
        j = Long.valueOf(l1).longValue();
        k = UserManager.n().b();
        b("APP_SETTINGS_PARSED_EVENT");
        return true;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void g()
    {
        ArrayList arraylist;
        Object obj;
        obj = a("appFamily", "apps", ((String) (null)));
        if (obj == null)
        {
            return;
        }
        arraylist = new ArrayList();
        obj = new JSONArray(((String) (obj)));
        int i1 = 0;
_L1:
        String s;
        if (i1 >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_89;
        }
        s = ((JSONArray) (obj)).get(i1).toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        arraylist.add(s);
        i1++;
          goto _L1
        JSONException jsonexception;
        jsonexception;
        Log.e(c, "JSONException thrown parsing app family data!");
        jsonexception.printStackTrace();
        o = arraylist;
        return;
    }

    private boolean h()
    {
        long l1 = UserManager.n().b();
        boolean flag;
        if (k == 0L && l1 == 0L || k != 0L && k == l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return System.currentTimeMillis() < j + 0x36ee80L && flag;
    }

    private void i()
    {
        LinkedList linkedlist = n;
        linkedlist;
        JVM INSTR monitorenter ;
        for (; n.size() > 0; ((Runnable)n.remove(0)).run()) { }
        break MISSING_BLOCK_LABEL_41;
        Exception exception;
        exception;
        linkedlist;
        JVM INSTR monitorexit ;
        throw exception;
        linkedlist;
        JVM INSTR monitorexit ;
    }

    public int a(String s, String s1, int i1)
    {
        s = b(s, s1);
        if (s == null || !s.isValueNode())
        {
            return i1;
        } else
        {
            return s.asInt(i1);
        }
    }

    public JsonNode a(String s, String s1, JsonNode jsonnode)
    {
        JsonNode jsonnode1 = b(s, s1);
        if (jsonnode1 == null)
        {
            Log.d(c, (new StringBuilder()).append("no value for settingid: ").append(s).append(" key: ").append(s1).toString());
            return jsonnode;
        } else
        {
            return jsonnode1;
        }
    }

    public String a(String s, String s1, String s2)
    {
        JsonNode jsonnode = b(s, s1);
        if (jsonnode == null)
        {
            Log.d(c, (new StringBuilder()).append("no value for settingid: ").append(s).append(" key: ").append(s1).toString());
        } else
        {
            s1 = jsonnode.toString();
            if (s1.length() != 0)
            {
                s = s1;
                if (s1.startsWith("\""))
                {
                    s = s1;
                    if (s1.endsWith("\""))
                    {
                        s = s1.substring(1, s1.length() - 1);
                    }
                }
                return s;
            }
        }
        return s2;
    }

    public List a(String s, String s1, List list)
    {
        JsonNode jsonnode = b(s, s1);
        if (jsonnode == null || !jsonnode.isArray())
        {
            return list;
        }
        List list1;
        try
        {
            list1 = (List)com.smule.android.f.e.a().treeToValue(jsonnode, java/util/List);
        }
        catch (IOException ioexception)
        {
            Log.w(c, (new StringBuilder()).append("Failed to parse value for settingId=").append(s).append(" key=").append(s1).append(" value=").append(jsonnode).append(". Returning default").toString());
            return list;
        }
        return list1;
    }

    public Map a(String s)
    {
        Map map = null;
        this;
        JVM INSTR monitorenter ;
        if (l || h != null) goto _L2; else goto _L1
_L1:
        Log.e(c, "Reading AppConfig settings before loading them!");
_L4:
        this;
        JVM INSTR monitorexit ;
        return map;
_L2:
        if (h != null)
        {
            map = (Map)h.get(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public Map a(String s, String s1, Map map)
    {
        JsonNode jsonnode = b(s, s1);
        if (jsonnode == null)
        {
            return map;
        }
        Map map1;
        try
        {
            map1 = (Map)com.smule.android.f.e.a().treeToValue(jsonnode, java/util/Map);
        }
        catch (IOException ioexception)
        {
            Log.w(c, (new StringBuilder()).append("Failed to parse value for settingId=").append(s).append(" key=").append(s1).append(" value=").append(jsonnode).append(". Returning default").toString());
            return map;
        }
        return map1;
    }

    public void a(Runnable runnable)
    {
        if (runnable != null)
        {
            synchronized (n)
            {
                n.addLast(runnable);
            }
        }
        if (h())
        {
            i();
        } else
        if (!m.getAndSet(true))
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final a a;

                public void run()
                {
                    a.a(a);
                    com.smule.android.network.managers.a.b(a).set(false);
                    a.c(a);
                    return;
                    Exception exception;
                    exception;
                    com.smule.android.network.managers.a.b(a).set(false);
                    a.c(a);
                    throw exception;
                }

            
            {
                a = a.this;
                super();
            }
            });
            return;
        }
        return;
        runnable;
        linkedlist;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void a(String s, String s1)
    {
        JsonNode jsonnode = (JsonNode)com.smule.android.f.e.a().readValue(s1, com/fasterxml/jackson/databind/JsonNode);
        this;
        JVM INSTR monitorenter ;
        i.put(s, a(jsonnode));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (JsonProcessingException jsonprocessingexception)
        {
            Log.e(c, "There was a problem with default settings!", jsonprocessingexception);
            throw new RuntimeException((new StringBuilder()).append("Bad default settings for ").append(s).append(". Value: ").append(s1).toString());
        }
        catch (IOException ioexception)
        {
            Log.e(c, "There was a problem with default settings!", ioexception);
        }
        throw new RuntimeException((new StringBuilder()).append("Bad default settings for ").append(s).append(". Value: ").append(s1).toString());
    }

    public boolean a(String s, String s1, boolean flag)
    {
        s = b(s, s1);
        if (s == null || !s.isValueNode())
        {
            return flag;
        } else
        {
            return s.asBoolean(flag);
        }
    }

    public JsonNode b(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Map map1 = a(s);
        Map map;
        map = map1;
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        map = (Map)i.get(s);
        if (map != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = (JsonNode)map.get(s1);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void b()
    {
        Log.d(c, "Dump mLastSettings");
        a(e);
        Log.d(c, "Dump mLocalizedSettings");
        a(h);
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = h;
        boolean flag;
        if (map != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = e;
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new HashMap();
        if (!f) goto _L4; else goto _L3
_L3:
        a(((Map) (obj)), g);
_L5:
        h = ((Map) (obj));
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        b(((Map) (obj)), g);
          goto _L5
        Object obj1;
        obj1;
        Log.e(c, (new StringBuilder()).append("IOException:").append(obj1).toString());
          goto _L2
        obj1;
        throw obj1;
          goto _L5
    }

}
