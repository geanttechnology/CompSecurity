// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            v, m

public class c
    implements Comparable
{
    private static class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private String a;
    private long b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;

    protected c(c c1)
    {
        h = -1;
        i = -1;
        j = -1;
        k = 0;
        l = -1L;
        a = c1.a;
        b = c1.b;
        c = c1.c;
        d = c1.d;
        g = c1.g;
        e = c1.e;
        k = c1.k;
        h = c1.h;
        i = c1.i;
    }

    protected c(String s)
    {
        h = -1;
        i = -1;
        j = -1;
        k = 0;
        l = -1L;
        a = s;
        b = System.currentTimeMillis() / 1000L;
    }

    protected c(String s, long l1)
    {
        h = -1;
        i = -1;
        j = -1;
        k = 0;
        l = -1L;
        a = s;
        b = l1;
    }

    protected static c a(JSONObject jsonobject, boolean flag)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((c) (obj));
_L2:
        Object obj2;
        long l2;
        obj2 = jsonobject.getString("event");
        l2 = jsonobject.getLong("time");
        obj = jsonobject.optString("credentials");
        if ("".equals(obj))
        {
            obj = null;
        }
        Object obj1 = jsonobject.optString("user_info");
        if ("".equals(obj1))
        {
            obj1 = null;
        }
        String s = jsonobject.optString("location");
        if ("".equals(s))
        {
            s = null;
        }
        String s1 = jsonobject.optString("properties");
        if ("".equals(s1))
        {
            s1 = null;
        }
        String s2 = jsonobject.optString("tracking_id");
        if ("".equals(s2))
        {
            s2 = null;
        }
        int i1;
        int j1;
        int k1;
        int l1;
        long l3;
        try
        {
            i1 = jsonobject.optInt("count", -1);
            j1 = jsonobject.optInt("value", -1);
            k1 = jsonobject.optInt("push_launch_override", -1);
            l1 = jsonobject.optInt("event_count", 0);
            l3 = jsonobject.optLong("event_number", -1L);
            obj2 = new c(((String) (obj2)), l2);
            obj2.g = s2;
            obj2.c = ((String) (obj));
            obj2.d = ((String) (obj1));
            obj2.e = s;
            obj2.f = s1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception building KAEvent from JSONObject: ").append(jsonobject).append(" andException:").append(obj).toString());
            }
            return null;
        }
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        obj2.h = i1;
        if (j1 == -1)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        obj2.i = j1;
        if (k1 == -1)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        obj2.j = k1;
        if (l3 <= 0L)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        obj2.l = l3;
        obj2.k = l1;
        obj = obj2;
        if (flag) goto _L4; else goto _L3
_L3:
        obj1 = jsonobject.optString("event_hash");
        obj = obj2;
        if (v.a(((String) (obj1)))) goto _L4; else goto _L5
_L5:
        obj = obj2;
        if (b(jsonobject).equals(obj1)) goto _L4; else goto _L6
_L6:
        obj1 = (new StringBuilder()).append("Detected corrupted archived event: ");
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_398;
        }
        obj = jsonobject.toString();
_L7:
        throw new a(((StringBuilder) (obj1)).append(((String) (obj))).toString());
        obj = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L7
    }

    private static Map a(JSONObject jsonobject, String s)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != null)
        {
            JSONArray jsonarray = jsonobject.names();
            for (int i1 = 0; i1 < jsonarray.length(); i1++)
            {
                String s2 = jsonarray.optString(i1);
                if (s2.length() <= 0)
                {
                    continue;
                }
                String s1 = (new StringBuilder()).append(s).append("_").append(s2).toString();
                s2 = jsonobject.optString(s2);
                if (!v.a(s2))
                {
                    hashmap.put(s1, (new StringBuilder()).append(s1).append(":").append(s2).toString());
                }
            }

        }
        return hashmap;
    }

    protected static String b(JSONObject jsonobject)
    {
        Object obj = new TreeMap();
        if (jsonobject != null)
        {
            if (jsonobject.has("count"))
            {
                ((TreeMap) (obj)).put("count", (new StringBuilder()).append("count:").append(jsonobject.optString("count")).toString());
            }
            if (jsonobject.optJSONObject("credentials") != null)
            {
                ((TreeMap) (obj)).putAll(a(jsonobject.optJSONObject("credentials"), "credentials"));
            }
            if (jsonobject.has("event"))
            {
                ((TreeMap) (obj)).put("event", (new StringBuilder()).append("event:").append(jsonobject.optString("event")).toString());
            }
            if (jsonobject.has("event_count"))
            {
                ((TreeMap) (obj)).put("event_count", (new StringBuilder()).append("event_count:").append(jsonobject.optString("event_count")).toString());
            }
            if (jsonobject.has("event_number"))
            {
                ((TreeMap) (obj)).put("event_number", (new StringBuilder()).append("event_number:").append(jsonobject.optString("event_number")).toString());
            }
            if (jsonobject.optJSONObject("location") != null)
            {
                ((TreeMap) (obj)).putAll(a(jsonobject.optJSONObject("location"), "location"));
            }
            if (jsonobject.optJSONObject("properties") != null)
            {
                ((TreeMap) (obj)).putAll(a(jsonobject.optJSONObject("properties"), "properties"));
            }
            if (jsonobject.has("time"))
            {
                ((TreeMap) (obj)).put("time", (new StringBuilder()).append("time:").append(jsonobject.optString("time")).toString());
            }
            if (jsonobject.has("tracking_id"))
            {
                ((TreeMap) (obj)).put("tracking_id", (new StringBuilder()).append("tracking_id:").append(jsonobject.optString("tracking_id")).toString());
            }
            if (jsonobject.optJSONObject("user_info") != null)
            {
                ((TreeMap) (obj)).putAll(a(jsonobject.optJSONObject("user_info"), "user_info"));
            }
            if (jsonobject.has("value"))
            {
                ((TreeMap) (obj)).put("value", (new StringBuilder()).append("value:").append(jsonobject.optString("value")).toString());
            }
        }
        jsonobject = new ArrayList();
        for (obj = ((TreeMap) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); jsonobject.add(((java.util.Map.Entry)((Iterator) (obj)).next()).getValue())) { }
        return v.a(TextUtils.join("|", jsonobject), "MD5", false);
    }

    public int a(c c1)
    {
        if (b < c1.b)
        {
            return -1;
        }
        return b <= c1.b ? 0 : 1;
    }

    protected String a()
    {
        return a;
    }

    protected void a(int i1)
    {
        h = i1;
    }

    protected void a(long l1)
    {
        l = l1;
    }

    protected void a(String s)
    {
        a = s;
    }

    protected void a(Map map)
    {
        if (!v.a(map))
        {
            JSONObject jsonobject = new JSONObject();
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                try
                {
                    jsonobject.put(s, new JSONArray((Set)map.get(s)));
                }
                catch (Exception exception)
                {
                    if (m.a)
                    {
                        Log.d("Kahuna", (new StringBuilder()).append("Exception building user credentials string from Map: ").append(map).append(" andException:").append(exception).toString());
                    }
                }
            } while (true);
            if (!(jsonobject instanceof JSONObject))
            {
                map = jsonobject.toString();
            } else
            {
                map = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            c = map;
            return;
        } else
        {
            c = null;
            return;
        }
    }

    protected void a(JSONObject jsonobject)
    {
        if (!v.a(jsonobject))
        {
            if (!(jsonobject instanceof JSONObject))
            {
                jsonobject = jsonobject.toString();
            } else
            {
                jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            f = jsonobject;
            return;
        } else
        {
            f = null;
            return;
        }
    }

    protected long b()
    {
        return b;
    }

    protected void b(int i1)
    {
        i = i1;
    }

    protected void b(String s)
    {
        g = s;
    }

    protected void b(Map map)
    {
        if (!v.a(map))
        {
            map = new JSONObject(map);
            if (!(map instanceof JSONObject))
            {
                map = map.toString();
            } else
            {
                map = JSONObjectInstrumentation.toString((JSONObject)map);
            }
            d = map;
            return;
        } else
        {
            d = null;
            return;
        }
    }

    protected void c()
    {
        j = 1;
    }

    protected void c(Map map)
    {
        if (!v.a(map))
        {
            map = new JSONObject(map);
            if (!(map instanceof JSONObject))
            {
                map = map.toString();
            } else
            {
                map = JSONObjectInstrumentation.toString((JSONObject)map);
            }
            e = map;
            return;
        } else
        {
            e = null;
            return;
        }
    }

    public int compareTo(Object obj)
    {
        return a((c)obj);
    }

    protected String d()
    {
        return c;
    }

    protected boolean e()
    {
        return !v.a(f);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof c)
        {
            obj = (c)obj;
            break MISSING_BLOCK_LABEL_12;
        }
        do
        {
            return false;
        } while (v.a(a) || v.a(((c) (obj)).a) || !a.equals(((c) (obj)).a) || b != ((c) (obj)).b);
        return true;
    }

    protected int f()
    {
        return h;
    }

    protected int g()
    {
        return i;
    }

    protected JSONObject h()
    {
        JSONObject jsonobject;
        if (v.a(f))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        jsonobject = JSONObjectInstrumentation.init(f);
        return jsonobject;
        JSONException jsonexception;
        jsonexception;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception building EventProperties from JSON String: ").append(f).append(" andException:").append(jsonexception).toString());
        }
        return null;
    }

    protected boolean i()
    {
        return k > 0;
    }

    protected void j()
    {
        k = k + 1;
    }

    protected long k()
    {
        return l;
    }

    protected JSONObject l()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("event", a);
            jsonobject.put("time", b);
            if (c != null)
            {
                jsonobject.put("credentials", JSONObjectInstrumentation.init(c));
            }
            if (d != null)
            {
                jsonobject.put("user_info", JSONObjectInstrumentation.init(d));
            }
            if (e != null)
            {
                jsonobject.put("location", JSONObjectInstrumentation.init(e));
            }
            if (f != null)
            {
                jsonobject.put("properties", JSONObjectInstrumentation.init(f));
            }
            if (g != null)
            {
                jsonobject.put("tracking_id", g);
            }
            if (h != -1)
            {
                jsonobject.put("count", h);
            }
            if (i != -1)
            {
                jsonobject.put("value", i);
            }
            if (j != -1)
            {
                jsonobject.put("push_launch_override", j);
            }
            if (k > 0)
            {
                jsonobject.put("event_count", k);
            }
            if (l > 0L)
            {
                jsonobject.put("event_number", l);
            }
            String s = b(jsonobject);
            if (s.length() > 0)
            {
                jsonobject.put("event_hash", s);
            }
        }
        catch (Exception exception)
        {
            if (m.a)
            {
                Log.d("Kahuna", (new StringBuilder()).append("Exception getting JSON representation for KAEvent: ").append(exception).toString());
            }
            return null;
        }
        return jsonobject;
    }

    public String toString()
    {
        return (new StringBuilder()).append("KAEvent: name: ").append(a).append(" creationDate: ").append(b).toString();
    }
}
