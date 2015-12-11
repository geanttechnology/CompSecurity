// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            r, v, m

public class s
{

    protected static final Set a = new HashSet(Arrays.asList(new String[] {
        "Start".toLowerCase()
    }));
    private static final HashSet b = new HashSet(Arrays.asList(new String[] {
        "k_app_bg", "k_user_logout"
    }));
    private static final HashSet c = new HashSet();
    private long d;
    private double e;
    private long f;
    private Set g;
    private int h;
    private double i;
    private Set j;
    private Map k;
    private Set l;
    private Set m;
    private int n;
    private Map o;
    private Map p;
    private JSONObject q;
    private int r;

    public s()
    {
        n = 25;
        d = 0L;
        e = 5D;
        f = 100L;
        g = b;
        h = 5;
        i = 0.5D;
        j = c;
        k = null;
        l = null;
        m = null;
        q = null;
        r = 100;
    }

    protected static s a(Context context)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        double d1;
        JSONObject jsonobject;
        long l1;
        long l2;
        jsonobject = com.kahuna.sdk.r.i(context);
        l1 = jsonobject.optLong("version", 0L);
        d1 = jsonobject.optDouble("flush_interval_min", 5D);
        l2 = jsonobject.optLong("flush_on_event_count", 100L);
        context = jsonobject.optJSONArray("trigger_events");
        if (context == null) goto _L2; else goto _L1
_L1:
        context = a(((JSONArray) (context)), ((Set) (new HashSet())), true);
_L5:
        double d2;
        Object obj;
        int i1;
        i1 = jsonobject.optInt("retry_attempts", 5);
        d2 = jsonobject.optDouble("flush_soon_delay_min", 0.5D);
        obj = jsonobject.optJSONArray("flush_soon_events");
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = a(((JSONArray) (obj)), ((Set) (new HashSet())), true);
_L6:
        s s1;
        s1 = new s();
        s1.a(l1);
        s1.b(d1);
        s1.b(l2);
        s1.a(((Set) (context)));
        s1.b(i1);
        s1.a(d2);
        s1.b(((Set) (obj)));
        s1.a(b(jsonobject.optJSONObject("event_remapping"), new HashMap()));
        s1.d(a(jsonobject.optJSONArray("events_to_include"), ((Set) (null)), false));
        s1.c(a(jsonobject.optJSONArray("events_to_exclude"), ((Set) (null)), false));
        s1.c(jsonobject.optInt("event_properties_max_count", 25));
        s1.b(a(jsonobject.optJSONObject("event_properties_to_include"), ((Map) (new HashMap()))));
        s1.c(a(jsonobject.optJSONObject("event_properties_to_exclude"), ((Map) (new HashMap()))));
        s1.b(jsonobject.optJSONObject("event_bucket_config"));
        s1.a(jsonobject.optInt("event_batch_size", 100));
        v.a();
        context = s1;
_L7:
        obj = context;
        if (context == null)
        {
            obj = new s();
        }
        return ((s) (obj));
_L2:
        context = b;
          goto _L5
_L4:
        obj = c;
          goto _L6
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Exception getting SDK configurations: ").append(context).toString());
        }
        context = null;
        v.a();
          goto _L7
        context = null;
          goto _L7
    }

    protected static s a(JSONObject jsonobject)
    {
        s s1 = new s();
        if (jsonobject != null)
        {
            s1.a(jsonobject.optLong("v", 0L));
            s1.b(jsonobject.optDouble("t", 5D));
            s1.b(jsonobject.optLong("n", 100L));
            s1.b(jsonobject.optInt("ro", 5));
            s1.a(jsonobject.optDouble("fsd", 0.5D));
            if (jsonobject.has("fi"))
            {
                s1.a(a(jsonobject.optJSONArray("fi"), ((Set) (b)), true));
            }
            if (jsonobject.has("fs"))
            {
                s1.b(a(jsonobject.optJSONArray("fs"), ((Set) (c)), true));
            }
            s1.a(b(jsonobject.optJSONObject("mapev"), new HashMap()));
            if (jsonobject.has("incev"))
            {
                s1.d(a(jsonobject.optJSONArray("incev"), ((Set) (null)), false));
            } else
            {
                s1.c(a(jsonobject.optJSONArray("excev"), ((Set) (null)), false));
            }
            if (jsonobject.has("epmc"))
            {
                s1.c(jsonobject.optInt("epmc", 25));
            }
            if (jsonobject.has("incev_p"))
            {
                s1.b(a(jsonobject.optJSONObject("incev_p"), ((Map) (new HashMap()))));
            }
            if (jsonobject.has("execv_p"))
            {
                s1.c(a(jsonobject.optJSONObject("execv_p"), ((Map) (new HashMap()))));
            }
            s1.b(jsonobject.optJSONObject("bckev"));
            s1.a(jsonobject.optInt("bs", 100));
        }
        v.a();
        return s1;
    }

    private static Map a(JSONObject jsonobject, Map map)
    {
        if (jsonobject != null)
        {
            HashMap hashmap = new HashMap();
            Iterator iterator = jsonobject.keys();
            do
            {
                map = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                map = (String)iterator.next();
                hashmap.put(map, b(jsonobject.optJSONObject(map), new HashMap()));
            } while (true);
        }
        return map;
    }

    private static Set a(JSONArray jsonarray, Set set, boolean flag)
    {
        if (jsonarray != null)
        {
            HashSet hashset = new HashSet();
            int j1 = jsonarray.length();
            int i1 = 0;
            do
            {
                set = hashset;
                if (i1 >= j1)
                {
                    break;
                }
                String s1 = jsonarray.optString(i1);
                if (!v.a(s1))
                {
                    set = s1;
                    if (flag)
                    {
                        set = s1.toLowerCase();
                    }
                    hashset.add(set);
                }
                i1++;
            } while (true);
        }
        return set;
    }

    protected static void a(Context context, s s1)
    {
        if (s1 != null && context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject;
        Object obj;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("version", s1.a());
            jsonobject.put("flush_interval_min", s1.b());
            jsonobject.put("flush_on_event_count", s1.d());
            obj = new JSONArray();
            for (Iterator iterator = s1.e().iterator(); iterator.hasNext(); ((JSONArray) (obj)).put((String)iterator.next())) { }
            break MISSING_BLOCK_LABEL_131;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (!m.a) goto _L1; else goto _L3
_L3:
        Log.d("Kahuna", (new StringBuilder()).append("Exception serializing SDK config to save: ").append(context).toString());
        return;
        jsonobject.put("trigger_events", obj);
        jsonobject.put("retry_attempts", s1.f());
        jsonobject.put("flush_soon_delay_min", s1.g());
        obj = new JSONArray();
        for (Iterator iterator1 = s1.i().iterator(); iterator1.hasNext(); ((JSONArray) (obj)).put((String)iterator1.next())) { }
        Object obj1;
        jsonobject.put("flush_soon_events", obj);
        obj = new JSONObject();
        obj1 = s1.j();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        String s2;
        for (Iterator iterator2 = ((Map) (obj1)).keySet().iterator(); iterator2.hasNext(); ((JSONObject) (obj)).put(s2, ((Map) (obj1)).get(s2)))
        {
            s2 = (String)iterator2.next();
        }

        jsonobject.put("event_remapping", obj);
        obj = new JSONArray();
        obj1 = s1.l();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj1)).next())) { }
        jsonobject.put("events_to_include", obj);
        obj = new JSONArray();
        obj1 = s1.k();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj1)).next())) { }
        jsonobject.put("events_to_exclude", obj);
        jsonobject.put("event_properties_max_count", s1.m());
        jsonobject.put("event_properties_to_include", new JSONObject(s1.n()));
        jsonobject.put("event_properties_to_exclude", new JSONObject(s1.o()));
        if (s1.q == null)
        {
            s1.q = new JSONObject();
        }
        jsonobject.put("event_bucket_config", s1.q);
        jsonobject.put("event_batch_size", s1.q());
        com.kahuna.sdk.r.a(context, jsonobject);
        return;
    }

    private void a(Map map)
    {
        if (map != null)
        {
            HashMap hashmap = new HashMap();
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (a(s1) && !v.a((String)map.get(s1)))
                {
                    hashmap.put(s1, map.get(s1));
                }
            } while (true);
            k = hashmap;
            return;
        } else
        {
            k = map;
            return;
        }
    }

    private void a(Set set)
    {
        g = set;
    }

    private boolean a(String s1)
    {
        if (!v.a(s1))
        {
            if ("Start".equalsIgnoreCase(s1))
            {
                if (m.a)
                {
                    Log.d("Kahuna", "Can't process event filterings or mappings if the name is start");
                    return false;
                }
            } else
            {
                return v.c(s1);
            }
        }
        return false;
    }

    private boolean a(String s1, String s2, String s3, Map map)
    {
        if (v.a(map) || v.a(s1) || v.a(s2) || v.a(s3))
        {
            return false;
        }
        Iterator iterator = map.keySet().iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (String)iterator.next();
                if (!v.a(((String) (obj)), s1))
                {
                    continue;
                }
                obj = (Map)map.get(obj);
                if (obj == null)
                {
                    continue;
                }
                Iterator iterator1 = ((Map) (obj)).keySet().iterator();
                String s4;
                String s5;
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    s4 = (String)iterator1.next();
                    s5 = (String)((Map) (obj)).get(s4);
                } while (!v.a(s4, s2) || !v.a(s5, s3));
                break;
            } else
            {
                return false;
            }
        } while (true);
        return true;
    }

    private boolean a(String s1, Map map)
    {
        if (v.a(map))
        {
            return false;
        }
        for (map = map.keySet().iterator(); map.hasNext();)
        {
            if (v.a((String)map.next(), s1))
            {
                return true;
            }
        }

        return false;
    }

    private static Map b(JSONObject jsonobject, Map map)
    {
        if (jsonobject != null)
        {
            HashMap hashmap = new HashMap();
            Iterator iterator = jsonobject.keys();
            do
            {
                map = hashmap;
                if (!iterator.hasNext())
                {
                    break;
                }
                map = (String)iterator.next();
                hashmap.put(map, jsonobject.optString(map));
            } while (true);
        }
        return map;
    }

    private void b(double d1)
    {
        e = d1;
        if (e == (0.0D / 0.0D))
        {
            e = 5D;
        }
        if (e < 0.5D)
        {
            e = 0.5D;
        } else
        if (e > 259200D)
        {
            e = 259200D;
            return;
        }
    }

    private void b(int i1)
    {
        h = i1;
        if (h < 0)
        {
            h = 0;
        } else
        if (h > 30)
        {
            h = 30;
            return;
        }
    }

    private void b(long l1)
    {
        f = l1;
        if (f < 1L)
        {
            f = 1L;
        } else
        if (f > 5000L)
        {
            f = 5000L;
            return;
        }
    }

    private void b(Map map)
    {
        if (map != null)
        {
            o = d(map);
            return;
        } else
        {
            o = null;
            return;
        }
    }

    private void b(Set set)
    {
        j = set;
    }

    private void c(int i1)
    {
        if (i1 >= 0)
        {
            n = i1;
        }
    }

    private void c(Map map)
    {
        if (map != null)
        {
            p = d(map);
            return;
        } else
        {
            p = map;
            return;
        }
    }

    private void c(Set set)
    {
        if (set != null)
        {
            HashSet hashset = new HashSet();
            set = set.iterator();
            do
            {
                if (!set.hasNext())
                {
                    break;
                }
                String s1 = (String)set.next();
                if (a(s1))
                {
                    hashset.add(s1);
                }
            } while (true);
            l = hashset;
            return;
        } else
        {
            l = set;
            return;
        }
    }

    private Map d(Map map)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            Map map1 = (Map)map.get(s1);
            if (!v.a(s1) && !v.a(map1) && v.c(s1))
            {
                HashMap hashmap1 = new HashMap();
                Iterator iterator1 = map1.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)iterator1.next();
                    String s3 = (String)map1.get(s2);
                    if (!v.a(s2) && !v.a(s3) && v.c(s2) && v.c(s3))
                    {
                        hashmap1.put(s2, s3);
                    }
                } while (true);
                if (!v.a(hashmap1))
                {
                    hashmap.put(s1, hashmap1);
                }
            }
        } while (true);
        return hashmap;
    }

    private void d(Set set)
    {
        if (set != null)
        {
            HashSet hashset = new HashSet();
            set = set.iterator();
            do
            {
                if (!set.hasNext())
                {
                    break;
                }
                String s1 = (String)set.next();
                if (a(s1))
                {
                    hashset.add(s1);
                }
            } while (true);
            m = hashset;
            return;
        } else
        {
            m = set;
            return;
        }
    }

    protected long a()
    {
        return d;
    }

    protected void a(double d1)
    {
        i = d1;
        if (i == (0.0D / 0.0D))
        {
            i = 0.5D;
        }
        if (i < 0.5D)
        {
            i = 0.5D;
        } else
        if (i > 259200D)
        {
            i = 259200D;
            return;
        }
    }

    protected void a(int i1)
    {
        r = i1;
        if (r >= 1) goto _L2; else goto _L1
_L1:
        r = 1;
_L4:
        if ((long)r > f)
        {
            r = (int)f;
        }
        return;
_L2:
        if (r > 5000)
        {
            r = 5000;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(long l1)
    {
        d = l1;
    }

    protected boolean a(String s1, String s2, String s3)
    {
        if (a(s1, o) || a(s1, p)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!v.a(o))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!v.a(p) && a(s1, s2, s3, p))
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (v.a(p))
        {
            return a(s1, s2, s3, o);
        }
        if (!a(s1, s2, s3, o) || a(s1, s2, s3, p))
        {
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected double b()
    {
        return e;
    }

    protected void b(JSONObject jsonobject)
    {
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        q = new JSONObject();
        Iterator iterator = jsonobject.keys();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        double d2;
        String s1;
        s1 = (String)iterator.next();
        d2 = jsonobject.optDouble(s1, 0.5D);
        double d1;
        d1 = d2;
        if (d2 == (0.0D / 0.0D))
        {
            d1 = 0.5D;
        }
          goto _L5
_L7:
        q.put(s1.toLowerCase(), d2);
          goto _L6
        jsonobject;
        if (m.a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Caught exception while trying to set event bucket config: ").append(jsonobject).toString());
        }
_L4:
        return;
_L9:
        d2 = d1;
        if (d1 > 259200D)
        {
            d2 = 259200D;
        }
          goto _L7
_L2:
        q = null;
        return;
_L5:
        if (d1 >= 0.5D) goto _L9; else goto _L8
_L8:
        d2 = 0.5D;
          goto _L7
    }

    protected long c()
    {
        return (long)(e * 60D);
    }

    protected long d()
    {
        return f;
    }

    protected Set e()
    {
        if (g != null)
        {
            return new HashSet(g);
        } else
        {
            return new HashSet();
        }
    }

    protected int f()
    {
        return h;
    }

    protected double g()
    {
        return i;
    }

    protected long h()
    {
        return (long)(i * 60D);
    }

    protected Set i()
    {
        if (j != null)
        {
            return new HashSet(j);
        } else
        {
            return new HashSet();
        }
    }

    protected Map j()
    {
        if (k != null)
        {
            return new HashMap(k);
        } else
        {
            return new HashMap();
        }
    }

    protected Set k()
    {
        if (l != null)
        {
            return new HashSet(l);
        } else
        {
            return new HashSet();
        }
    }

    protected Set l()
    {
        if (m != null)
        {
            return new HashSet(m);
        } else
        {
            return new HashSet();
        }
    }

    protected int m()
    {
        return n;
    }

    protected Map n()
    {
        if (o != null)
        {
            return o;
        } else
        {
            return new HashMap();
        }
    }

    protected Map o()
    {
        if (p != null)
        {
            return p;
        } else
        {
            return new HashMap();
        }
    }

    protected JSONObject p()
    {
        if (q != null)
        {
            return q;
        } else
        {
            return new JSONObject();
        }
    }

    protected int q()
    {
        return r;
    }

}
