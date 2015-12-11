// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.net.Uri;
import com.facebook.ads.a.f.e;
import com.facebook.ads.a.f.f;
import com.facebook.ads.a.f.o;
import com.facebook.ads.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            f

public class s
    implements com.facebook.ads.a.b.f
{
    private static final class a
    {

        Map a;

        final void a(String s1)
        {
            s1 = (List)a.get(s1);
            if (s1 != null && !s1.isEmpty())
            {
                s1 = s1.iterator();
                while (s1.hasNext()) 
                {
                    String s2 = (String)s1.next();
                    (new o()).execute(new String[] {
                        s2
                    });
                }
            }
        }

        a(JSONArray jsonarray)
        {
            a = new HashMap();
            if (jsonarray != null)
            {
                int i1 = 0;
                while (i1 < jsonarray.length()) 
                {
                    Object obj = jsonarray.optJSONObject(i1);
                    String s1 = ((JSONObject) (obj)).optString("type");
                    if (!com.facebook.ads.a.f.s.a(s1))
                    {
                        obj = ((JSONObject) (obj)).optJSONArray("urls");
                        if (obj != null)
                        {
                            ArrayList arraylist = new ArrayList(((JSONArray) (obj)).length());
                            for (int j1 = 0; j1 < ((JSONArray) (obj)).length(); j1++)
                            {
                                arraylist.add(((JSONArray) (obj)).optString(j1));
                            }

                            a.put(s1, arraylist);
                        }
                    }
                    i1++;
                }
            }
        }
    }


    static final String a = com/facebook/ads/a/b/s.getSimpleName();
    com.facebook.ads.a.f.b.a A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final e F;
    private final String G;
    private final Collection H;
    private final com.facebook.ads.k.a I;
    private final String J;
    private final n K;
    private boolean L;
    final Uri b;
    final String c;
    final String d;
    final String e;
    final com.facebook.ads.k.a f;
    final com.facebook.ads.k.a g;
    final com.facebook.ads.k.c h;
    final String i;
    final String j;
    final boolean k;
    final boolean l;
    final boolean m;
    final int n;
    final int o;
    final int p;
    final int q;
    final String r;
    final String s;
    final String t;
    final String u;
    final a v;
    final String w = UUID.randomUUID().toString();
    boolean x;
    boolean y;
    long z;

    private s(Uri uri, String s1, String s2, String s3, String s4, String s5, com.facebook.ads.k.a a1, 
            com.facebook.ads.k.a a2, com.facebook.ads.k.c c1, String s6, String s7, String s8, e e1, String s9, 
            Collection collection, boolean flag, com.facebook.ads.k.a a3, String s10, String s11, a a4, String s12, 
            boolean flag1, boolean flag2, int i1, int j1, String s13, String s14, String s15, 
            int k1, int l1, n n1)
    {
        z = 0L;
        A = null;
        b = uri;
        c = s1;
        B = s2;
        d = s3;
        e = s4;
        C = s5;
        f = a1;
        g = a2;
        h = c1;
        i = s6;
        j = s7;
        E = s8;
        F = e1;
        G = s9;
        H = collection;
        k = flag;
        l = flag1;
        m = flag2;
        I = a3;
        J = s10;
        u = s11;
        v = a4;
        D = s12;
        n = i1;
        o = j1;
        p = k1;
        q = l1;
        r = s13;
        s = s14;
        t = s15;
        K = n1;
    }

    public static s a(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            jsonobject = null;
        } else
        {
            Uri uri = Uri.parse(jsonobject.optString("fbad_command"));
            String s1 = jsonobject.optString("title");
            String s2 = jsonobject.optString("subtitle");
            String s3 = jsonobject.optString("body");
            String s4 = jsonobject.optString("call_to_action");
            String s5 = jsonobject.optString("social_context");
            com.facebook.ads.k.a a2 = com.facebook.ads.k.a.a(jsonobject.optJSONObject("icon"));
            com.facebook.ads.k.a a3 = com.facebook.ads.k.a.a(jsonobject.optJSONObject("image"));
            Object obj = jsonobject.optJSONObject("star_rating");
            Object obj1;
            com.facebook.ads.k.a a1;
            Object obj2;
            String s6;
            String s7;
            String s8;
            String s9;
            String s10;
            String s11;
            e e1;
            String s12;
            int i1;
            boolean flag;
            int j1;
            int k1;
            int l1;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (obj == null)
            {
                obj = null;
            } else
            {
                double d1 = ((JSONObject) (obj)).optDouble("value", 0.0D);
                double d2 = ((JSONObject) (obj)).optDouble("scale", 0.0D);
                if (d1 == 0.0D || d2 == 0.0D)
                {
                    obj = null;
                } else
                {
                    obj = new com.facebook.ads.k.c(d1, d2);
                }
            }
            s6 = jsonobject.optString("impression_report_url");
            s7 = jsonobject.optString("native_view_report_url");
            s8 = jsonobject.optString("click_report_url");
            s9 = jsonobject.optString("used_report_url");
            flag1 = jsonobject.optBoolean("manual_imp");
            flag2 = jsonobject.optBoolean("enable_view_log");
            flag3 = jsonobject.optBoolean("enable_snapshot_log");
            i1 = jsonobject.optInt("snapshot_log_delay_second", 4);
            j1 = jsonobject.optInt("snapshot_compress_quality", 0);
            k1 = jsonobject.optInt("viewability_check_initial_delay", 0);
            l1 = jsonobject.optInt("viewability_check_interval", 1000);
            a1 = null;
            obj2 = jsonobject.optJSONObject("ad_choices_icon");
            obj1 = jsonobject.optJSONObject("native_ui_config");
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = new n(((JSONObject) (obj1)));
            }
            if (obj2 != null)
            {
                a1 = com.facebook.ads.k.a.a(((JSONObject) (obj2)));
            }
            s10 = jsonobject.optString("ad_choices_link_url");
            s11 = jsonobject.optString("request_id");
            e1 = com.facebook.ads.a.f.e.a(jsonobject.optString("invalidation_behavior"));
            s12 = jsonobject.optString("invalidation_report_url");
            try
            {
                obj2 = new JSONArray(jsonobject.optString("detection_strings"));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                jsonexception = null;
            }
            jsonobject = new s(uri, s1, s2, s3, s4, s5, a2, a3, ((com.facebook.ads.k.c) (obj)), s6, s8, s9, e1, s12, com.facebook.ads.a.f.f.a(((JSONArray) (obj2))), flag1, a1, s10, s11, new a(jsonobject.optJSONArray("trackers")), s7, flag2, flag3, i1, j1, jsonobject.optString("video_url"), jsonobject.optString("video_play_report_url"), jsonobject.optString("video_time_report_url"), k1, l1, ((n) (obj1)));
            if (((s) (jsonobject)).c != null && ((s) (jsonobject)).c.length() > 0 && ((s) (jsonobject)).e != null && ((s) (jsonobject)).e.length() > 0 && ((s) (jsonobject)).f != null && ((s) (jsonobject)).g != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                return null;
            }
        }
        return jsonobject;
    }

    static String a(s s1)
    {
        return s1.D;
    }

    static Map a(Map map)
    {
        HashMap hashmap = new HashMap();
        if (map.containsKey("view"))
        {
            hashmap.put("view", String.valueOf(map.get("view")));
        }
        if (map.containsKey("snapshot"))
        {
            hashmap.put("snapshot", String.valueOf(map.get("snapshot")));
        }
        return hashmap;
    }

    private static void a(String s1, Map map, Map map1)
    {
        if (map1.containsKey(s1))
        {
            map.put(s1, String.valueOf(map1.get(s1)));
        }
    }

    static void a(Map map, Map map1)
    {
        if (map1.containsKey("mil"))
        {
            boolean flag = ((Boolean)map1.get("mil")).booleanValue();
            map1.remove("mil");
            if (!flag)
            {
                return;
            }
        }
        map.put("mil", "true");
    }

    static void b(Map map, Map map1)
    {
        a("nti", map, map1);
        a("nhs", map, map1);
        a("nmv", map, map1);
    }

    public final e a()
    {
        return F;
    }

    public final String b()
    {
        return G;
    }

    public final Collection c()
    {
        return H;
    }

    final void d()
    {
        if (!L)
        {
            (new o()).execute(new String[] {
                E
            });
            L = true;
        }
    }


    // Unreferenced inner class com/facebook/ads/a/b/s$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final Map a;
        final Map b;
        final s c;

        public final void run()
        {
            (new o(a, b)).execute(new String[] {
                s.a(c)
            });
        }

            
            {
                c = s.this;
                a = map;
                b = map1;
                super();
            }
    }

}
