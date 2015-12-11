// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Point;
import android.graphics.RectF;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.AppEventsLogger;
import com.google.analytics.tracking.android.ai;
import com.google.analytics.tracking.android.aj;
import com.google.analytics.tracking.android.aq;
import com.google.analytics.tracking.android.ay;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.iu;
import com.localytics.android.Localytics;
import com.wishabi.flipp.content.c;
import com.wishabi.flipp.content.e;
import com.wishabi.flipp.content.f;
import com.wishabi.flipp.content.h;
import com.wishabi.flipp.content.i;
import com.wishabi.flipp.util.k;
import com.wishabi.flipp.util.p;
import com.wishabi.flipp.util.q;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.wishabi.flipp.b:
//            b, n, o, r, 
//            p, q, i, f, 
//            c, ab, t, j, 
//            k, d, e

public final class a extends Enum
{

    private static final a D[];
    public static final a a;
    private RectF A;
    private com.wishabi.flipp.content.Flyer.Model B;
    private float C;
    public Context b;
    public Location c;
    public boolean d;
    public ay e;
    public AppEventsLogger f;
    public Timer g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public final Point l = new Point();
    public ContentResolver m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public long s;
    private com.google.android.gms.location.e t;
    private ab u;
    private String v;
    private UUID w;
    private Timer x;
    private Timer y;
    private long z;

    private a(String s1)
    {
        super(s1, 0);
        (new Timer()).scheduleAtFixedRate(new b(this), 0L, 250L);
    }

    static long a(a a1)
    {
        return a1.z;
    }

    static Location a(a a1, Location location)
    {
        a1.c = location;
        return location;
    }

    static String a(a a1, String s1)
    {
        a1.k = s1;
        return s1;
    }

    static UUID a(a a1, UUID uuid)
    {
        a1.w = uuid;
        return uuid;
    }

    static void a(a a1, String s1, Map map)
    {
        a1.a(s1, map, false);
    }

    private void a(String s1, Bundle bundle, double d1)
    {
        f.logEvent(s1, d1, bundle);
    }

    private void a(String s1, Map map, String s2, boolean flag)
    {
        android.net.Uri.Builder builder = Uri.parse(s2).buildUpon();
        if (!map.containsKey("aid"))
        {
            map.put("aid", "flipp");
        }
        if (!map.containsKey("t"))
        {
            map.put("t", s1);
        }
        if (!map.containsKey("rnd"))
        {
            map.put("rnd", UUID.randomUUID().toString());
        }
        if (!map.containsKey("sid"))
        {
            map.put("sid", d());
        }
        if (!map.containsKey("app_version"))
        {
            map.put("app_version", j);
        }
        if (!map.containsKey("system_version"))
        {
            map.put("system_version", android.os.Build.VERSION.RELEASE);
        }
        if (!map.containsKey("system_model"))
        {
            map.put("system_model", Build.MODEL);
        }
        int i1;
        if (!map.containsKey("tracking_enabled"))
        {
            if (i)
            {
                s2 = "0";
            } else
            {
                s2 = "1";
            }
            map.put("tracking_enabled", s2);
        }
        if (!map.containsKey("last_listing"))
        {
            map.put("last_listing", v);
        }
        if (!map.containsKey("cross_browse") && r)
        {
            map.put("cross_browse", "yes");
        }
        if (!map.containsKey("postal_code"))
        {
            map.put("postal_code", k);
        }
        if (k == null || k.isEmpty())
        {
            i1 = 0;
        } else
        if (k.length() < 6)
        {
            i1 = 175;
        } else
        {
            i1 = 119;
        }
        if (!map.containsKey("channel_id") && i1 != 0)
        {
            map.put("channel_id", String.valueOf(i1));
        }
        if (!map.containsKey("device_platform"))
        {
            map.put("device_platform", "Android");
        }
        if (!map.containsKey("allow_push"))
        {
            s2 = com.wishabi.flipp.util.p.a();
            boolean flag1;
            if (s2 != null)
            {
                flag1 = s2.getBoolean("allow_push", true);
            } else
            {
                flag1 = true;
            }
            if (flag1)
            {
                s2 = "true";
            } else
            {
                s2 = "false";
            }
            map.put("allow_push", s2);
        }
        if (!map.containsKey("cached_lat"))
        {
            if (c == null)
            {
                s2 = "0";
            } else
            {
                s2 = Double.toString(c.getLatitude());
            }
            map.put("cached_lat", s2);
        }
        if (!map.containsKey("cached_lon"))
        {
            if (c == null)
            {
                s2 = "0";
            } else
            {
                s2 = Double.toString(c.getLongitude());
            }
            map.put("cached_lon", s2);
        }
        for (map = map.entrySet().iterator(); map.hasNext(); builder.appendQueryParameter((String)s2.getKey(), (String)s2.getValue()))
        {
            s2 = (java.util.Map.Entry)map.next();
        }

        map = builder.build();
        if (map == null)
        {
            return;
        }
        try
        {
            map = new URL(map.toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.toString();
            return;
        }
        if (flag)
        {
            b(map, s1);
            return;
        } else
        {
            (new n(this, map, s1)).execute(new Void[0]);
            return;
        }
    }

    static void a(URL url, String s1)
    {
        b(url, s1);
    }

    public static void a(JSONObject jsonobject)
    {
        if (jsonobject != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        try
        {
            if (!jsonobject.isNull("msa_id"))
            {
                long l1 = jsonobject.getLong("msa_id");
                com.localytics.android.Localytics.ProfileScope profilescope = com.localytics.android.Localytics.ProfileScope.APPLICATION;
                Localytics.addProfileAttributesToSet("msa_id", new long[] {
                    l1
                }, profilescope);
            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        if (jsonobject.isNull("msa_name")) goto _L1; else goto _L3
_L3:
        jsonobject = jsonobject.getString("msa_name");
        com.localytics.android.Localytics.ProfileScope profilescope1 = com.localytics.android.Localytics.ProfileScope.APPLICATION;
        Localytics.addProfileAttributesToSet("msa_name", new String[] {
            jsonobject
        }, profilescope1);
        return;
        jsonobject;
        jsonobject.printStackTrace();
        return;
    }

    static boolean a(a a1, boolean flag)
    {
        a1.i = flag;
        return flag;
    }

    static com.wishabi.flipp.content.Flyer.Model b(a a1)
    {
        return a1.B;
    }

    static String b(a a1, String s1)
    {
        a1.h = s1;
        return s1;
    }

    public static void b(String s1, HashMap hashmap)
    {
        try
        {
            Localytics.tagEvent(s1, hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            hashmap.toString();
        }
    }

    private static void b(URL url, String s1)
    {
        try
        {
            HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setUseCaches(false);
            if (httpurlconnection.getResponseCode() == 200)
            {
                (new StringBuilder("Beacon: (")).append(s1).append(") ").append(url.toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            url.toString();
        }
    }

    static RectF c(a a1)
    {
        return a1.A;
    }

    static String c(a a1, String s1)
    {
        a1.v = s1;
        return s1;
    }

    static float d(a a1)
    {
        return a1.C;
    }

    static long e(a a1)
    {
        a1.z = 0L;
        return 0L;
    }

    static Context f(a a1)
    {
        return a1.b;
    }

    static String g(a a1)
    {
        return a1.h;
    }

    static boolean h(a a1)
    {
        return a1.i;
    }

    static UUID i(a a1)
    {
        return a1.w;
    }

    static ay j(a a1)
    {
        return a1.e;
    }

    static void k(a a1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("lat", "0");
        hashmap.put("lon", "0");
        hashmap.put("accuracy", "0.0");
        a1.a("app_open", hashmap);
    }

    static com.google.android.gms.location.e l(a a1)
    {
        return a1.t;
    }

    static com.google.android.gms.location.e m(a a1)
    {
        a1.t = null;
        return null;
    }

    static String n(a a1)
    {
        return a1.k;
    }

    public static a valueOf(String s1)
    {
        return (a)Enum.valueOf(com/wishabi/flipp/b/a, s1);
    }

    public static a[] values()
    {
        return (a[])D.clone();
    }

    public final void a()
    {
        b();
        z = 0L;
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model)
    {
        if (!d)
        {
            b(model);
        }
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, long l1, o o1)
    {
        a(model, l1, o1, 0.0D);
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, long l1, o o1, double d1)
    {
        String s1;
        HashMap hashmap;
        if (model == null)
        {
            return;
        }
        a(model);
        hashmap = new HashMap();
        hashmap.put("flyer_id", String.valueOf(model.a));
        hashmap.put("analytics_payload", model.o);
        hashmap.put("flyer_item_id", Long.toString(l1));
        hashmap.put("flyer_type_id", String.valueOf(model.c));
        hashmap.put("flyer_run_id", String.valueOf(model.b));
        hashmap.put("merchant_id", String.valueOf(model.d));
        Bundle bundle;
        if (model.e)
        {
            s1 = "1";
        } else
        {
            s1 = "0";
        }
        hashmap.put("flipp_premium_merchant", s1);
        hashmap.put("postal_code", model.f);
        hashmap.put("st", Integer.toString(o1.m));
        if (o1 != com.wishabi.flipp.b.o.e) goto _L2; else goto _L1
_L1:
        bundle = new Bundle();
        bundle.putLong("fb_content_id", l1);
        if (com.wishabi.flipp.util.k.b(k))
        {
            s1 = "CAD";
        } else
        {
            s1 = "USD";
        }
        bundle.putString("fb_currency", s1);
        a("fb_mobile_add_to_wishlist", bundle, d1);
        b("Clipped Item", hashmap);
_L4:
        a("item", ((Map) (hashmap)), false);
        a("item", String.format("item | %sitem", new Object[] {
            o1.n
        }), String.format("item | %sitem | MER %s | MID %d | FID %d", new Object[] {
            o1.n, model.g, Integer.valueOf(model.d), Integer.valueOf(model.a)
        }));
        return;
_L2:
        if (o1 == o.a)
        {
            b("Item Details", hashmap);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, RectF rectf, float f1)
    {
        z = 0L;
        if (model == null)
        {
            return;
        } else
        {
            z = System.currentTimeMillis();
            A = rectf;
            B = model;
            C = f1;
            return;
        }
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, r r1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("flyer_id", Integer.valueOf(model.a));
        contentvalues.put("valid_to", model.m);
        contentvalues.put("analytic_type", Integer.valueOf(r1.c));
        m.insert(i.i, contentvalues);
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, String s1)
    {
        if (model == null)
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("merchant", model.g);
            hashmap.put("flyer_id", String.valueOf(model.a));
            hashmap.put("analytics_payload", model.o);
            hashmap.put("st", s1);
            a("noclip", ((Map) (hashmap)), false);
            a("noclip", String.format("noclip | MER %s | MID %d", new Object[] {
                model.g, Integer.valueOf(model.d)
            }), String.format("noclip | MER %s | MID %d | FID %d | TYPE %s", new Object[] {
                model.g, Integer.valueOf(model.d), Integer.valueOf(model.a), s1
            }));
            return;
        }
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, String s1, h h1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("flyer_id", String.valueOf(model.a));
        hashmap.put("analytics_payload", model.o);
        hashmap.put("flyer_run_id", String.valueOf(model.b));
        hashmap.put("flyer_type_id", String.valueOf(model.c));
        hashmap.put("merchant_id", String.valueOf(model.d));
        String s2;
        if (model.e)
        {
            s2 = "1";
        } else
        {
            s2 = "0";
        }
        hashmap.put("flipp_premium_merchant", s2);
        hashmap.put("source", s1);
        hashmap.put("postal_code", model.f);
        if (h1 == null)
        {
            hashmap.put("featured_item_id", "<null>");
            hashmap.put("brand_name", "<null>");
            hashmap.put("brand_id", "<null>");
            hashmap.put("featured_item_weight", "<null>");
            hashmap.put("sales_story", "<null>");
        } else
        {
            hashmap.put("featured_item_id", Long.toString(h1.a));
            hashmap.put("brand_name", h1.g);
            hashmap.put("brand_id", String.valueOf(h1.f));
            hashmap.put("featured_item_weight", String.valueOf(h1.i));
            hashmap.put("sales_story", h1.d);
        }
        a("impression", ((Map) (hashmap)), false);
        a("impression", String.format("impression | MER %s | MID %d", new Object[] {
            model.g, Integer.valueOf(model.d)
        }), ((String) (null)));
    }

    public final void a(com.wishabi.flipp.content.Flyer.Model model, boolean flag)
    {
        if (model == null)
        {
            return;
        }
        Object obj = new HashMap();
        ((HashMap) (obj)).put("merchant_id", String.valueOf(model.d));
        String s1;
        int i1;
        long l1;
        if (flag)
        {
            b("Added to Favorites", ((HashMap) (obj)));
        } else
        {
            b("Removed from Favorites", ((HashMap) (obj)));
        }
        ((HashMap) (obj)).put("postal_code", model.f);
        if (flag)
        {
            s1 = "Favorited";
        } else
        {
            s1 = "Unfavorited";
        }
        ((HashMap) (obj)).put("action", s1);
        a("favorite", ((Map) (obj)), false);
        s1 = String.format("Favorite | MER %s | MID %d", new Object[] {
            model.g, Integer.valueOf(model.d)
        });
        obj = model.g;
        i1 = model.d;
        if (flag)
        {
            model = "Favorited";
        } else
        {
            model = "Unfavorited";
        }
        model = String.format("Favorite | MER %s | MID %d | ACTION %s", new Object[] {
            obj, Integer.valueOf(i1), model
        });
        if (flag)
        {
            l1 = 1L;
        } else
        {
            l1 = -1L;
        }
        a("Favorite", s1, ((String) (model)), Long.valueOf(l1));
    }

    public final void a(c c1, com.wishabi.flipp.b.q q1, com.wishabi.flipp.b.p p1)
    {
        if (c1 == null || q1 == null || p1 == null)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        String s1;
        String s2;
        if (c1.e == null)
        {
            s1 = "<null>";
        } else
        {
            s1 = String.valueOf(c1.e);
        }
        hashmap.put("coupon_id", String.valueOf(c1.a));
        if (c1.b == null)
        {
            s2 = "<null>";
        } else
        {
            s2 = String.valueOf(c1.b);
        }
        hashmap.put("merchant_id", s2);
        hashmap.put("coupon_vendor_id", s1);
        if (c1.f == null)
        {
            s1 = "<null>";
        } else
        {
            s1 = c1.f.d;
        }
        hashmap.put("coupon_type", s1);
        if (c1.g == null)
        {
            s1 = "<null>";
        } else
        {
            s1 = c1.g;
        }
        hashmap.put("brand", s1);
        if (c1.j == null)
        {
            s1 = "<null>";
        } else
        {
            s1 = c1.j.e;
        }
        hashmap.put("redemption_method", s1);
        hashmap.put("click_source", p1.k);
        hashmap.put("st", String.valueOf(q1.f));
        a("coupon", ((Map) (hashmap)), false);
        q1 = String.format("%s | %s", new Object[] {
            "coupon", q1.g
        });
        if (c1.e != null)
        {
            c1 = String.format("%s | CVID %s | CID %d", new Object[] {
                q1, c1.e, Integer.valueOf(c1.a)
            });
        } else
        {
            c1 = String.format("%s | MID %s | CID %d", new Object[] {
                q1, c1.b, Integer.valueOf(c1.a)
            });
        }
        a("coupon", ((String) (q1)), ((String) (c1)));
    }

    public final void a(String s1)
    {
        if (e == null)
        {
            return;
        }
        if (x != null)
        {
            x.cancel();
        }
        x = new Timer();
        x.schedule(new com.wishabi.flipp.b.i(this, s1), 300L);
    }

    public final void a(String s1, int i1, int j1)
    {
        Object obj;
        String s2;
        Long long1;
        HashMap hashmap3;
        int l1;
        hashmap3 = new HashMap();
        obj = null;
        Object obj5 = null;
        byte byte0 = -1;
        Object obj4 = null;
        if (j1 == -1)
        {
            long1 = null;
        } else
        {
            long1 = Long.valueOf(j1);
        }
        s2 = obj4;
        l1 = byte0;
        if (s1 != null)
        {
            obj = s1.split(" ", 2);
            int k1 = byte0;
            String s3 = obj5;
            if (obj.length > 1)
            {
                k1 = byte0;
                s3 = obj5;
                if (com.wishabi.flipp.util.q.b(obj[0]))
                {
                    s3 = obj[1];
                    k1 = Integer.parseInt(obj[0]);
                }
            }
            if (s3 == null)
            {
                hashmap3.put("qty", "null");
                hashmap3.put("item", s1);
                s2 = String.format("%s | HASQTY 0", new Object[] {
                    s1
                });
                obj = s3;
                l1 = k1;
            } else
            {
                s2 = obj4;
                l1 = k1;
                obj = s3;
                if (k1 != -1)
                {
                    hashmap3.put("qty", String.valueOf(k1));
                    hashmap3.put("item", s3);
                    s2 = String.format("%s | HASQTY 1", new Object[] {
                        s3
                    });
                    l1 = k1;
                    obj = s3;
                }
            }
        }
        f.a[i1 - 1];
        JVM INSTR tableswitch 1 10: default 212
    //                   1 304
    //                   2 566
    //                   3 772
    //                   4 978
    //                   5 1016
    //                   6 1067
    //                   7 1118
    //                   8 1169
    //                   9 1220
    //                   10 1271;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        throw new IllegalArgumentException("Invalid shopping list analytic");
_L2:
        hashmap3.put("st", "add");
        hashmap3.put("context", "list");
        String s4 = (new StringBuilder()).append("shopping list").append(" | add").toString();
        HashMap hashmap = new HashMap();
        double d1;
        Object obj1;
        if (obj != null)
        {
            obj1 = obj;
        } else
        {
            obj1 = s1;
        }
        hashmap.put("item", obj1);
        if (obj != null)
        {
            obj1 = "1";
        } else
        {
            obj1 = "0";
        }
        hashmap.put("hasQty", obj1);
        hashmap.put("context", "list");
        b("Shopping List Add", hashmap);
        obj1 = new Bundle();
        if (obj == null)
        {
            obj = s1;
        }
        ((Bundle) (obj1)).putString("fb_content_id", ((String) (obj)));
        ((Bundle) (obj1)).putString("fb_content_type", "list");
        if (l1 == -1)
        {
            d1 = 0.0D;
        } else
        {
            d1 = l1;
        }
        a("fb_mobile_add_to_cart", ((Bundle) (obj1)), d1);
        s1 = s4;
_L13:
        obj = s2;
        if (s2 != null)
        {
            obj = (new StringBuilder()).append(s1).append(" | ").append(s2).toString();
        }
        a("shopping_list", ((Map) (hashmap3)), false);
        a("shopping list", s1, ((String) (obj)), long1);
        return;
_L3:
        hashmap3.put("st", "add");
        hashmap3.put("context", "flyer");
        String s5 = (new StringBuilder()).append("shopping list").append(" | add from flyer").toString();
        HashMap hashmap1 = new HashMap();
        double d2;
        Object obj2;
        if (obj != null)
        {
            obj2 = obj;
        } else
        {
            obj2 = s1;
        }
        hashmap1.put("item", obj2);
        if (obj != null)
        {
            obj2 = "1";
        } else
        {
            obj2 = "0";
        }
        hashmap1.put("hasQty", obj2);
        hashmap1.put("context", "flyer");
        b("Shopping List Add", hashmap1);
        obj2 = new Bundle();
        if (obj == null)
        {
            obj = s1;
        }
        ((Bundle) (obj2)).putString("fb_content_id", ((String) (obj)));
        ((Bundle) (obj2)).putString("fb_content_type", "flyer");
        if (l1 == -1)
        {
            d2 = 0.0D;
        } else
        {
            d2 = l1;
        }
        a("fb_mobile_add_to_cart", ((Bundle) (obj2)), d2);
        s1 = s5;
        continue; /* Loop/switch isn't completed */
_L4:
        hashmap3.put("st", "add");
        hashmap3.put("context", "search");
        String s6 = (new StringBuilder()).append("shopping list").append(" | add from search").toString();
        HashMap hashmap2 = new HashMap();
        double d3;
        Object obj3;
        if (obj != null)
        {
            obj3 = obj;
        } else
        {
            obj3 = s1;
        }
        hashmap2.put("item", obj3);
        if (obj != null)
        {
            obj3 = "1";
        } else
        {
            obj3 = "0";
        }
        hashmap2.put("hasQty", obj3);
        hashmap2.put("context", "search");
        b("Shopping List Add", hashmap2);
        obj3 = new Bundle();
        if (obj == null)
        {
            obj = s1;
        }
        ((Bundle) (obj3)).putString("fb_content_id", ((String) (obj)));
        ((Bundle) (obj3)).putString("fb_content_type", "search");
        if (l1 == -1)
        {
            d3 = 0.0D;
        } else
        {
            d3 = l1;
        }
        a("fb_mobile_add_to_cart", ((Bundle) (obj3)), d3);
        s1 = s6;
        continue; /* Loop/switch isn't completed */
_L5:
        hashmap3.put("st", "edit");
        s1 = (new StringBuilder()).append("shopping list").append(" | edit").toString();
        continue; /* Loop/switch isn't completed */
_L6:
        hashmap3.put("st", "delete");
        hashmap3.put("clip", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | delete").toString();
        continue; /* Loop/switch isn't completed */
_L7:
        hashmap3.put("st", "clearChecked");
        hashmap3.put("clear", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | clearChecked").toString();
        continue; /* Loop/switch isn't completed */
_L8:
        hashmap3.put("st", "clearAll");
        hashmap3.put("clear", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | clearAll").toString();
        continue; /* Loop/switch isn't completed */
_L9:
        hashmap3.put("st", "uncheckAll");
        hashmap3.put("uncheck", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | uncheckAll").toString();
        continue; /* Loop/switch isn't completed */
_L10:
        hashmap3.put("st", "check");
        hashmap3.put("clip", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | check").toString();
        continue; /* Loop/switch isn't completed */
_L11:
        hashmap3.put("st", "uncheck");
        hashmap3.put("clip", Integer.toString(j1));
        s1 = (new StringBuilder()).append("shopping list").append(" | uncheck").toString();
        if (true) goto _L13; else goto _L12
_L12:
    }

    public final void a(String s1, Uri uri)
    {
        u = new com.wishabi.flipp.b.c(this, b);
        u.a(60000L);
        a("fb_mobile_activate_app", ((Bundle) (null)));
        HashMap hashmap;
        if (s1 != null)
        {
            s1 = "Push Notification";
        } else
        if (uri != null)
        {
            s1 = "Another App";
        } else
        {
            s1 = "Direct";
        }
        hashmap = new HashMap();
        hashmap.put("mechanism", s1);
        if (uri != null)
        {
            hashmap.put("url", uri.toString());
        }
        b("App Open", hashmap);
    }

    public final void a(String s1, Bundle bundle)
    {
        if (bundle == null)
        {
            f.logEvent(s1);
            return;
        } else
        {
            f.logEvent(s1, bundle);
            return;
        }
    }

    public final void a(String s1, t t1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("store", s1);
        hashmap.put("postal_code", k);
        hashmap.put("view", t1.c);
        a("store_request", ((Map) (hashmap)), false);
        a("Store Request", (new StringBuilder("Store Request | REQUESTED STORE ")).append(s1).toString(), String.format("Store Request | REQUESTED STORE %s | LOC %s | VIEW %s", new Object[] {
            s1, k, t1.c
        }));
    }

    public final void a(String s1, String s2, Cursor cursor)
    {
        if (cursor == null)
        {
            b(s1);
            return;
        }
        int j1 = cursor.getPosition();
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = 0;
        if (cursor.moveToFirst())
        {
            do
            {
                stringbuilder.append('f').append(cursor.getInt(cursor.getColumnIndexOrThrow("flyer_id"))).append('p').append(cursor.getInt(cursor.getColumnIndexOrThrow("premium")));
                i1++;
            } while (i1 < 50 && cursor.moveToNext());
        }
        cursor.moveToPosition(j1);
        HashMap hashmap = new HashMap();
        hashmap.put("screen_name", s1);
        hashmap.put("flyer_ids", stringbuilder.toString());
        hashmap.put("postal_code", k);
        hashmap.put("count", Integer.toString(cursor.getCount()));
        if (s2 != null)
        {
            hashmap.put("sort", s2);
        }
        if (y != null)
        {
            y.cancel();
        }
        y = new Timer();
        y.schedule(new j(this, hashmap, s1), 1000L);
    }

    public final void a(String s1, String s2, String s3)
    {
        a(s1, s2, s3, Long.valueOf(0L));
    }

    public final void a(String s1, String s2, String s3, Long long1)
    {
        if (e == null)
        {
            return;
        }
        ay ay1 = e;
        ai.a().a(aj.Y);
        aq aq1 = new aq();
        aq1.a("&t", "event");
        aq1.a("&ec", s1);
        aq1.a("&ea", s2);
        aq1.a("&el", s3);
        if (long1 == null)
        {
            s1 = null;
        } else
        {
            s1 = Long.toString(long1.longValue());
        }
        aq1.a("&ev", s1);
        ay1.a(aq1.a());
    }

    public final void a(String s1, HashMap hashmap)
    {
        hashmap.put("screen_name", s1);
        if (y != null)
        {
            y.cancel();
        }
        y = new Timer();
        y.schedule(new com.wishabi.flipp.b.k(this, hashmap, s1), 1000L);
    }

    public final void a(String s1, Map map)
    {
        a(s1, map, false);
    }

    public final void a(String s1, Map map, boolean flag)
    {
        a(s1, map, "https://a.wishabi.com/track.gif", flag);
        a(s1, map, "https://b.wishabi.com/track.gif", flag);
    }

    public final void a(ArrayList arraylist, com.wishabi.flipp.b.q q1, com.wishabi.flipp.b.p p1)
    {
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); a((c)arraylist.next(), q1, p1)) { }
    }

    public final void b()
    {
        if (g != null)
        {
            g.cancel();
        }
        g = null;
    }

    public final void b(com.wishabi.flipp.content.Flyer.Model model)
    {
        b();
        if (model == null)
        {
            return;
        }
        boolean flag1 = b(model, r.b);
        double d1;
        Object obj;
        Object obj1;
        Bundle bundle;
        boolean flag;
        if (!flag1 && model.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = true;
        obj1 = new HashMap();
        ((HashMap) (obj1)).put("flyer_id", String.valueOf(model.a));
        ((HashMap) (obj1)).put("analytics_payload", model.o);
        ((HashMap) (obj1)).put("flyer_run_id", String.valueOf(model.b));
        ((HashMap) (obj1)).put("flyer_type_id", String.valueOf(model.c));
        ((HashMap) (obj1)).put("merchant_id", String.valueOf(model.d));
        ((HashMap) (obj1)).put("merchant", model.g);
        if (model.e)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        ((HashMap) (obj1)).put("flipp_premium_merchant", obj);
        ((HashMap) (obj1)).put("postal_code", model.f);
        if (flag1)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        ((HashMap) (obj1)).put("repeat", obj);
        b("Flyer Engagement", ((HashMap) (obj1)));
        if (flag)
        {
            try
            {
                Localytics.tagEvent("Billing Engagement", ((Map) (obj1)), 31L);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((HashMap) (obj1)).toString();
            }
        }
        a("ev", ((Map) (obj1)), false);
        if (flag1)
        {
            obj = "repeat";
        } else
        {
            obj = "unique";
        }
        if (model.e)
        {
            obj1 = "promoted";
        } else
        {
            obj1 = "organic";
        }
        obj = String.format("EV %s %s", new Object[] {
            obj1, obj
        });
        a(((String) (obj)), String.format("%s | MER %s | MID %d", new Object[] {
            obj, model.g, Integer.valueOf(model.d)
        }), String.format("%s | MER %s | MID %d | FID %d", new Object[] {
            obj, model.g, Integer.valueOf(model.d), Integer.valueOf(model.a)
        }));
        flag1 = com.wishabi.flipp.util.k.b(k);
        bundle = new Bundle();
        bundle.putString("fb_content_type", ((String) (obj1)));
        bundle.putInt("fb_content_id", model.a);
        if (flag1)
        {
            obj = "CAD";
        } else
        {
            obj = "USD";
        }
        bundle.putString("fb_currency", ((String) (obj)));
        if (flag)
        {
            if (flag1)
            {
                d1 = 0.31D;
            } else
            {
                d1 = 0.28999999999999998D;
            }
        } else
        {
            d1 = 0.0D;
        }
        a("fb_mobile_content_view", bundle, d1);
        a(model, r.b);
    }

    public final void b(com.wishabi.flipp.content.Flyer.Model model, String s1, h h1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("flyer_id", String.valueOf(model.a));
        hashmap.put("analytics_payload", model.o);
        hashmap.put("flyer_run_id", String.valueOf(model.b));
        hashmap.put("flyer_type_id", String.valueOf(model.c));
        hashmap.put("merchant_id", String.valueOf(model.d));
        String s2;
        if (model.e)
        {
            s2 = "1";
        } else
        {
            s2 = "0";
        }
        hashmap.put("flipp_premium_merchant", s2);
        hashmap.put("source", s1);
        hashmap.put("postal_code", model.f);
        if (h1 == null)
        {
            hashmap.put("featured_item_id", "<null>");
            hashmap.put("brand_name", "<null>");
            hashmap.put("brand_id", "<null>");
            hashmap.put("featured_item_weight", "<null>");
            hashmap.put("sales_story", "<null>");
        } else
        {
            hashmap.put("featured_item_id", Long.toString(h1.a));
            hashmap.put("brand_name", h1.g);
            hashmap.put("brand_id", String.valueOf(h1.f));
            hashmap.put("featured_item_weight", String.valueOf(h1.i));
            hashmap.put("sales_story", h1.d);
        }
        a("featured_item_click", hashmap, false);
        a("featured item click", String.format("featured item click | MER %s | MID %d", new Object[] {
            model.g, Integer.valueOf(model.d)
        }), ((String) (null)));
    }

    public final void b(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("count", Integer.toString(0));
        a(s1, hashmap);
    }

    public final boolean b(com.wishabi.flipp.content.Flyer.Model model, r r1)
    {
        model = m.query(i.i, null, "flyer_id = ? and analytic_type = ?", new String[] {
            String.valueOf(model.a), String.valueOf(r1.c)
        }, null);
        if (model == null) goto _L2; else goto _L1
_L1:
        int i1 = model.getCount();
        if (i1 <= 0) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        if (model != null)
        {
            model.close();
        }
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        r1;
        model = null;
_L7:
        if (model != null)
        {
            model.close();
        }
        throw r1;
        r1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void c()
    {
        long l1 = System.currentTimeMillis();
        if ((float)(l1 - s) < 300000F || t != null || com.google.android.gms.common.g.a(b) != 0)
        {
            return;
        } else
        {
            s = l1;
            t = new com.google.android.gms.location.e(b, new d(this), new com.wishabi.flipp.b.e(this));
            t.a.d();
            return;
        }
    }

    public final void c(String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("platform", s1);
        hashmap.put("device_token", d(s1));
        a("device_token", hashmap, true);
    }

    public final String d()
    {
        if (h != null)
        {
            return h;
        }
        if (w != null)
        {
            return w.toString();
        } else
        {
            return "unknown";
        }
    }

    public final String d(String s1)
    {
        String s2 = null;
        SharedPreferences sharedpreferences = b.getSharedPreferences("com.wishabi.flipp.preferences", 0);
        if (s1.equals("gcm"))
        {
            s2 = sharedpreferences.getString("gcm_registration_id", null);
        } else
        if (s1.equals("adm"))
        {
            return sharedpreferences.getString("adm_registration_id", null);
        }
        return s2;
    }

    static 
    {
        a = new a("INSTANCE");
        D = (new a[] {
            a
        });
    }
}
