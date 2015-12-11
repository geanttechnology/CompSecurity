// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.action.a;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.e;
import com.facebook.ads.internal.util.f;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.o;
import com.facebook.ads.internal.util.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            n, o

public class j extends n
    implements com.facebook.ads.internal.util.f.a
{
    public static class a
    {

        Map a;

        void a(String s1)
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
                    if (!com.facebook.ads.internal.util.r.a(s1))
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


    private static final String a = com/facebook/ads/internal/adapters/j.getSimpleName();
    private String A;
    private String B;
    private com.facebook.ads.NativeAd.Image C;
    private String D;
    private String E;
    private a F;
    private AdExtras G;
    private NativeAdViewAttributes H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private long N;
    private com.facebook.ads.internal.util.b.a O;
    private Context b;
    private Uri c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private com.facebook.ads.NativeAd.Image i;
    private com.facebook.ads.NativeAd.Image j;
    private com.facebook.ads.NativeAd.Rating k;
    private String l;
    private String m;
    private String n;
    private String o;
    private e p;
    private String q;
    private Collection r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private String z;

    public j()
    {
        N = 0L;
        O = null;
    }

    private boolean A()
    {
        return d != null && d.length() > 0 && g != null && g.length() > 0 && i != null && j != null;
    }

    private void B()
    {
        if (!M)
        {
            (new o()).execute(new String[] {
                o
            });
            M = true;
        }
    }

    static String a(j j1)
    {
        return j1.m;
    }

    private void a(String s1, Map map, Map map1)
    {
        if (map1.containsKey(s1))
        {
            map.put(s1, String.valueOf(map1.get(s1)));
        }
    }

    private void a(Map map, Map map1)
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
        map.put("mil", String.valueOf(true));
    }

    private void b(Map map, Map map1)
    {
        a("nti", map, map1);
        a("nhs", map, map1);
        a("nmv", map, map1);
    }

    private Map c(Map map)
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

    public e a()
    {
        return p;
    }

    public void a(int i1)
    {
        while (!z() || i1 != 0 || N <= 0L || O == null) 
        {
            return;
        }
        com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(N, O, E));
        N = 0L;
        O = null;
    }

    public void a(Context context, com.facebook.ads.internal.adapters.o o1, Map map)
    {
        a((JSONObject)map.get("data"));
        if (com.facebook.ads.internal.util.f.a(context, this))
        {
            o1.a(this, AdError.NO_FILL);
            return;
        }
        b = context;
        if (o1 != null)
        {
            o1.a(this);
        }
        b.a = E;
    }

    public void a(Map map)
    {
        while (!z() || K) 
        {
            return;
        }
        HashMap hashmap = new HashMap();
        if (map != null)
        {
            a(((Map) (hashmap)), map);
            b(hashmap, map);
        }
        (new o(hashmap)).execute(new String[] {
            l
        });
        if (e() || g())
        {
            try
            {
                map = c(map);
                (new Handler()).postDelayed(new Runnable(hashmap, map) {

                    final Map a;
                    final Map b;
                    final j c;

                    public void run()
                    {
                        (new o(a, b)).execute(new String[] {
                            com.facebook.ads.internal.adapters.j.a(c)
                        });
                    }

            
            {
                c = j.this;
                a = map;
                b = map1;
                super();
            }
                }, v * 1000);
            }
            // Misplaced declaration of an exception variable
            catch (Map map) { }
        }
        F.a("impression");
        K = true;
    }

    public void a(JSONObject jsonobject)
    {
        Object obj1 = null;
        if (I)
        {
            throw new IllegalStateException("Adapter already loaded data");
        }
        if (jsonobject == null)
        {
            return;
        }
        c = Uri.parse(jsonobject.optString("fbad_command"));
        d = jsonobject.optString("title");
        e = jsonobject.optString("subtitle");
        f = jsonobject.optString("body");
        g = jsonobject.optString("call_to_action");
        h = jsonobject.optString("social_context");
        i = com.facebook.ads.NativeAd.Image.fromJSONObject(jsonobject.optJSONObject("icon"));
        j = com.facebook.ads.NativeAd.Image.fromJSONObject(jsonobject.optJSONObject("image"));
        k = com.facebook.ads.NativeAd.Rating.fromJSONObject(jsonobject.optJSONObject("star_rating"));
        l = jsonobject.optString("impression_report_url");
        m = jsonobject.optString("native_view_report_url");
        n = jsonobject.optString("click_report_url");
        o = jsonobject.optString("used_report_url");
        G = (new AdExtras()).setIsOrganic(jsonobject.optBoolean("is_organic", false));
        s = jsonobject.optBoolean("manual_imp");
        t = jsonobject.optBoolean("enable_view_log");
        u = jsonobject.optBoolean("enable_snapshot_log");
        v = jsonobject.optInt("snapshot_log_delay_second", 4);
        w = jsonobject.optInt("snapshot_compress_quality", 0);
        x = jsonobject.optInt("viewability_check_initial_delay", 0);
        y = jsonobject.optInt("viewability_check_interval", 1000);
        JSONObject jsonobject1 = jsonobject.optJSONObject("ad_choices_icon");
        Object obj = jsonobject.optJSONObject("native_ui_config");
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new NativeAdViewAttributes(((JSONObject) (obj)));
        }
        H = ((NativeAdViewAttributes) (obj));
        if (jsonobject1 != null)
        {
            C = com.facebook.ads.NativeAd.Image.fromJSONObject(jsonobject1);
        }
        D = jsonobject.optString("ad_choices_link_url");
        E = jsonobject.optString("request_id");
        p = com.facebook.ads.internal.util.e.a(jsonobject.optString("invalidation_behavior"));
        q = jsonobject.optString("invalidation_report_url");
        try
        {
            obj = new JSONArray(jsonobject.optString("detection_strings"));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            jsonexception = obj1;
        }
        r = com.facebook.ads.internal.util.f.a(((JSONArray) (obj)));
        F = new a(jsonobject.optJSONArray("trackers"));
        z = jsonobject.optString("video_url");
        A = jsonobject.optString("video_play_report_url");
        B = jsonobject.optString("video_time_report_url");
        I = true;
        J = A();
    }

    public String b()
    {
        return q;
    }

    public void b(Map map)
    {
        if (z())
        {
            if (!L)
            {
                HashMap hashmap = new HashMap();
                if (map != null)
                {
                    a(hashmap, map);
                    b(((Map) (hashmap)), map);
                    hashmap.put("touch", com.facebook.ads.internal.util.g.a(map));
                }
                (new o(hashmap)).execute(new String[] {
                    n
                });
                F.a("click");
                L = true;
                com.facebook.ads.internal.util.g.a(b, "Click logged");
            }
            map = com.facebook.ads.internal.action.b.a(b, c);
            if (map != null)
            {
                try
                {
                    N = System.currentTimeMillis();
                    O = map.a();
                    map.b();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Map map)
                {
                    Log.e(a, "Error executing action", map);
                }
                return;
            }
        }
    }

    public Collection c()
    {
        return r;
    }

    public boolean d()
    {
        return z() && s;
    }

    public boolean e()
    {
        return z() && t;
    }

    public boolean f()
    {
        return z() && H != null;
    }

    public boolean g()
    {
        return z() && u;
    }

    public int h()
    {
        if (w < 0 || w > 100)
        {
            return 0;
        } else
        {
            return w;
        }
    }

    public int i()
    {
        return x;
    }

    public int j()
    {
        return y;
    }

    public com.facebook.ads.NativeAd.Image k()
    {
        if (!z())
        {
            return null;
        } else
        {
            return i;
        }
    }

    public com.facebook.ads.NativeAd.Image l()
    {
        if (!z())
        {
            return null;
        } else
        {
            return j;
        }
    }

    public NativeAdViewAttributes m()
    {
        if (!z())
        {
            return null;
        } else
        {
            return H;
        }
    }

    public String n()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return d;
        }
    }

    public String o()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return e;
        }
    }

    public void onDestroy()
    {
    }

    public String p()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return f;
        }
    }

    public String q()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return g;
        }
    }

    public String r()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return h;
        }
    }

    public com.facebook.ads.NativeAd.Rating s()
    {
        if (!z())
        {
            return null;
        } else
        {
            B();
            return k;
        }
    }

    public com.facebook.ads.NativeAd.Image t()
    {
        if (!z())
        {
            return null;
        } else
        {
            return C;
        }
    }

    public String u()
    {
        if (!z())
        {
            return null;
        } else
        {
            return D;
        }
    }

    public String v()
    {
        if (!z())
        {
            return null;
        } else
        {
            return z;
        }
    }

    public String w()
    {
        if (!z())
        {
            return null;
        } else
        {
            return A;
        }
    }

    public String x()
    {
        if (!z())
        {
            return null;
        } else
        {
            return B;
        }
    }

    public AdExtras y()
    {
        if (!z())
        {
            return null;
        } else
        {
            return G;
        }
    }

    public boolean z()
    {
        return I && J;
    }

}
