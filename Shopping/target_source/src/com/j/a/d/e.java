// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import com.j.a.a.a.l;
import com.j.a.c.a;
import com.j.a.c.b;
import com.j.a.c.c;
import com.j.a.e.ay;
import com.j.a.e.az;
import com.j.a.f;
import com.j.a.g.a.d;
import com.j.a.g.h;
import com.j.a.g.m;
import com.j.a.g.o;
import com.j.a.g.w;
import com.j.a.i;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            a, q, j, f, 
//            ac, ab, aj, ah, 
//            ad, y, g, ag, 
//            ae

public class e
    implements com.j.a.d.a
{

    public static final b a = new b("1.5.7");
    private static final e b = new e();
    private q A;
    private List B;
    private ArrayList C;
    private AlertDialog D;
    private com.j.a.e.a c;
    private c d;
    private com.j.a.a.d e;
    private j f;
    private String g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Date r;
    private Integer s;
    private boolean t;
    private boolean u;
    private d v;
    private com.j.a.c.e w;
    private Context x;
    private Activity y;
    private i z;

    private e()
    {
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = false;
        i = false;
        j = false;
        k = true;
        l = false;
        m = false;
        n = false;
        o = false;
        p = false;
        q = false;
        r = null;
        s = Integer.valueOf(10);
        t = false;
        u = true;
        v = new d();
        w = null;
        x = null;
        y = null;
        A = null;
        B = new ArrayList();
        D = null;
    }

    private void A()
    {
        D = null;
    }

    static com.j.a.c.e a(e e1)
    {
        return e1.w;
    }

    private Map a(JSONObject jsonobject, JSONArray jsonarray)
        throws JSONException
    {
        HashMap hashmap;
        int i1;
        hashmap = new HashMap();
        i1 = 0;
_L7:
        if (i1 >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        String s1;
        Object obj;
        obj = new com.j.a.c.d(jsonarray.getJSONObject(i1));
        if (!((com.j.a.c.d) (obj)).a("_id"))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        s1 = ((com.j.a.c.d) (obj)).optString("_id");
_L8:
        if (!((com.j.a.c.d) (obj)).a("name")) goto _L4; else goto _L3
_L3:
        obj = ((com.j.a.c.d) (obj)).optString("name");
_L6:
        if (s1 == null || obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            if (!s1.equals("") && !((String) (obj)).equals("") && jsonobject.has(s1))
            {
                hashmap.put(obj, jsonobject.get(s1));
            }
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.j.a.g.w.b("Getting vars", jsonobject);
        }
          goto _L2
_L4:
        obj = "";
        if (true) goto _L6; else goto _L5
_L2:
        return hashmap;
_L5:
        i1++;
          goto _L7
        s1 = "";
          goto _L8
    }

    private boolean a(b b1)
    {
        int i1;
        try
        {
            i1 = a.a(b1);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            return false;
        }
        switch (i1)
        {
        default:
            return false;

        case -1: 
            return true;
        }
    }

    private boolean a(com.j.a.c.e e1)
    {
        boolean flag = true;
        if (e1 == null) goto _L2; else goto _L1
_L1:
        e1 = e1.c();
        if (e1 == null) goto _L2; else goto _L3
_L3:
        String s1;
        int j1;
        e1 = e1.optJSONObject("settings").optJSONArray("killForBuilds");
        j1 = com.j.a.g.m.b();
        s1 = com.j.a.g.m.a();
        if (e1 == null) goto _L2; else goto _L4
_L4:
        int i1 = 0;
_L8:
        String s2;
        String s3;
        if (i1 >= e1.length())
        {
            break MISSING_BLOCK_LABEL_229;
        }
        s2 = ((JSONObject)e1.get(i1)).optString("appBuild");
        s3 = ((JSONObject)e1.get(i1)).optString("appVersion");
        if (!String.valueOf(j1).equals(s2) && !s1.equals(s3)) goto _L6; else goto _L5
_L5:
        k = false;
        com.j.a.g.w.a("TAPLYTICS IS NOW DISABLED");
        if (A != null)
        {
            A.b();
        }
        if (z != null)
        {
            com.j.a.i.a(w());
        }
        if (e != null)
        {
            com.j.a.a.a.l.b().l();
        }
        if (f != null && f.a())
        {
            f.b();
        }
_L7:
        return !k;
        e1;
        com.j.a.g.w.b("error unregistering things for killswitch", e1);
          goto _L7
_L2:
        if (k)
        {
            flag = false;
        }
        return flag;
_L6:
        i1++;
          goto _L8
        try
        {
            k = true;
        }
        // Misplaced declaration of an exception variable
        catch (com.j.a.c.e e1)
        {
            com.j.a.g.w.b("error checking kill builds", e1);
        }
          goto _L2
    }

    static boolean a(e e1, b b1)
    {
        return e1.a(b1);
    }

    static boolean a(e e1, com.j.a.c.e e2)
    {
        return e1.a(e2);
    }

    static boolean a(e e1, String s1)
    {
        return e1.a(s1);
    }

    static boolean a(e e1, boolean flag)
    {
        e1.n = flag;
        return flag;
    }

    private boolean a(String s1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (x != null)
        {
            PackageManager packagemanager = x.getPackageManager();
            String s2 = s1;
            if (s1 != null)
            {
                s2 = (new StringBuilder()).append("tl-").append(s1).append("://").toString();
            }
            flag = flag1;
            if (packagemanager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(s2)), 0x10020).size() > 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    static com.j.a.c.e b(e e1, com.j.a.c.e e2)
    {
        e1.w = e2;
        return e2;
    }

    static void b(e e1)
    {
        e1.y();
    }

    private void b(f f1)
    {
        if (w == null || w.f() == null) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        JSONArray jsonarray;
        jsonarray = w.f();
        hashmap = new HashMap();
        a a1;
        if (w.g() == null)
        {
            break MISSING_BLOCK_LABEL_417;
        }
        a1 = new a(w.g());
          goto _L3
_L27:
        int i1;
        if (i1 >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        Object obj;
        String s1;
        Object obj1;
        obj = jsonarray.optJSONObject(i1);
        s1 = ((JSONObject) (obj)).optString("_id");
        obj1 = ((JSONObject) (obj)).optString("status");
        if (a1 == null || s1 == null) goto _L7; else goto _L6
_L6:
        if (!a1.a(s1).booleanValue() || obj == null || obj1 == null) goto _L7; else goto _L8
_L8:
        if (!((String) (obj1)).equals("active")) goto _L7; else goto _L9
_L9:
        if (!((JSONObject) (obj)).has("name")) goto _L11; else goto _L10
_L10:
        s1 = ((JSONObject) (obj)).optString("name");
_L23:
        obj1 = ((JSONObject) (obj)).optJSONArray("variations");
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        if (w.h() == null) goto _L13; else goto _L14
_L14:
        int j1 = 0;
_L26:
        if (j1 >= ((JSONArray) (obj1)).length()) goto _L13; else goto _L15
_L15:
        com.j.a.c.d d1 = new com.j.a.c.d(((JSONArray) (obj1)).optJSONObject(j1));
        if (!d1.a("_id")) goto _L17; else goto _L16
_L16:
        obj = w.h();
        if (obj instanceof JSONArray) goto _L19; else goto _L18
_L18:
        obj = ((JSONArray) (obj)).toString();
_L24:
        if (!((String) (obj)).contains((new StringBuilder()).append("\"").append(d1.optString("_id")).append("\"").toString())) goto _L17; else goto _L20
_L20:
        if (!d1.has("name")) goto _L22; else goto _L21
_L21:
        obj = d1.optString("name");
_L25:
        hashmap.put(s1, obj);
          goto _L7
_L11:
        s1 = ((JSONObject) (obj)).optString("_id");
          goto _L23
_L19:
        obj = JSONArrayInstrumentation.toString((JSONArray)obj);
          goto _L24
_L22:
        obj = d1.optString("_id");
          goto _L25
_L17:
        j1++;
          goto _L26
_L5:
        f1.a(hashmap);
        return;
        obj;
        com.j.a.g.w.b("Getting running experiments and variations", ((Exception) (obj)));
        f1.a(hashmap);
        return;
        obj;
        f1.a(hashmap);
        throw obj;
_L2:
        f1.a(null);
        return;
_L13:
        obj = "baseline";
          goto _L25
_L3:
        i1 = 0;
          goto _L27
_L7:
        i1++;
          goto _L27
        a1 = null;
          goto _L3
    }

    static boolean b(e e1, boolean flag)
    {
        e1.p = flag;
        return flag;
    }

    static com.j.a.a.d c(e e1)
    {
        return e1.e;
    }

    static boolean d(e e1)
    {
        return e1.n;
    }

    public static e e()
    {
        return b;
    }

    static void e(e e1)
    {
        e1.z();
    }

    static boolean f(e e1)
    {
        return e1.h;
    }

    static boolean g(e e1)
    {
        return e1.t;
    }

    static Context h(e e1)
    {
        return e1.x;
    }

    static j i(e e1)
    {
        return e1.f;
    }

    static d j(e e1)
    {
        return e1.v;
    }

    static void k(e e1)
    {
        e1.A();
    }

    private i w()
    {
        return z;
    }

    private void x()
    {
        if (!h)
        {
            return;
        } else
        {
            c.a(new com.j.a.d.f(this));
            return;
        }
    }

    private void y()
    {
        if (B.size() > 0)
        {
            Map map;
            for (Iterator iterator = B.iterator(); iterator.hasNext(); a((String)map.get("experiment"), false, (com.j.a.b)map.get("listener")))
            {
                map = (Map)iterator.next();
            }

            B.clear();
        }
    }

    private void z()
    {
        if (C != null)
        {
            for (Iterator iterator = C.iterator(); iterator.hasNext(); b((f)iterator.next())) { }
            C = null;
        }
    }

    public void a()
    {
        com.j.a.g.w.a("Shake Menu triggered");
        if (A != null && !com.j.a.d.ac.a().d() && !com.j.a.g.m.a(com.j.a.g.b.v) && g() && m)
        {
            com.j.a.d.ac.a().b();
        }
    }

    public void a(Activity activity)
    {
        Iterator iterator;
        try
        {
            if (!k)
            {
                y = null;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.j.a.g.w.b("Error setting activity.", activity);
            return;
        }
        if (activity == y)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        iterator = com.j.a.d.ab.a().b().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((String)((Pair)entry.getValue()).first).equals(y.getClass().getSimpleName()))
            {
                com.j.a.g.a.a(((Integer)entry.getKey()).intValue(), false);
            }
        } while (true);
        y = activity;
        m = true;
        t();
        com.j.a.d.ab.a().b().clear();
        com.j.a.d.ab.a().c().clear();
        com.j.a.g.w.a("Setting current activity");
        activity = activity.getIntent().getExtras();
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        if (activity.getBoolean("tl_notif", false) && activity.getString("tl_id") != null)
        {
            e.c(activity.getString("tl_id"));
        }
    }

    public void a(Context context, String s1, Map map)
    {
        Log.d("Taplytics", (new StringBuilder()).append("Starting taplytics version ").append(a.a()).toString());
        if (context == null || s1 == null)
        {
            try
            {
                Log.d("Taplytics", "Failed to start Taplytics, missing App Context or API Key");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                com.j.a.g.w.b("Master catch!", context);
            }
            break MISSING_BLOCK_LABEL_80;
        }
        if (!com.j.a.g.m.a(context, "android.permission.INTERNET"))
        {
            Log.w("Taplytics", "Failed to find the necessary android.permission.INTERNET permission.");
            return;
        }
        break MISSING_BLOCK_LABEL_81;
        return;
        if (g != null && s1.equals(g))
        {
            Log.d("Taplytics", "Taplytics has already started! Taplytics only needs to be started once, preferably in your Application subclass.");
            return;
        }
        ay ay1;
        com.j.a.g.w.a((new StringBuilder()).append("Start Taplytics with API Key: ").append(s1).toString());
        g = s1;
        x = context;
        d = new c(context);
        c = new com.j.a.e.a(context);
        e = new com.j.a.a.d();
        f = new j();
        if (android.os.Build.VERSION.SDK_INT >= 14 && !i)
        {
            z = com.j.a.i.a(context);
        }
        if (!j)
        {
            a(true, map);
            j = true;
        }
        ay1 = ay.b;
        if (map == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        obj2 = map.get("debugLogging");
        obj3 = map.get("liveUpdate");
        obj4 = map.get("shakeMenu");
        obj1 = map.get("server");
        obj5 = map.get("fragments");
        obj = map.get("sessionMinutes");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_335;
        }
        if (obj3 instanceof Boolean)
        {
            h = ((Boolean)obj3).booleanValue();
            l = true;
        }
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        if (obj5 instanceof Boolean)
        {
            u = ((Boolean)obj5).booleanValue();
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        if (obj2 instanceof Boolean)
        {
            com.j.a.g.w.a().a(((Boolean)obj2).booleanValue());
        }
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        if ((obj4 instanceof Boolean) && !((Boolean)obj4).booleanValue())
        {
            com.j.a.d.aj.a().a(com.j.a.g.b.v);
            if (A != null)
            {
                A.b();
            }
        }
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (!(obj1 instanceof String)) goto _L4; else goto _L5
_L5:
        obj2 = (String)obj1;
        if (!((String) (obj2)).equals("local") && obj1 != "localHost") goto _L7; else goto _L6
_L6:
        ay1 = ay.d;
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        boolean flag = obj instanceof Number;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        a((Integer)obj);
_L11:
        if (map.containsKey("disable"))
        {
            map = ((Map) (map.get("disable")));
            if (map instanceof ArrayList)
            {
                map = new HashSet((ArrayList)map);
                com.j.a.d.aj.a().b(map);
            }
        }
        break MISSING_BLOCK_LABEL_689;
_L12:
        c.a(map);
        e.e();
        com.j.a.g.h.a().a(new ah(this, s1));
        if (android.os.Build.VERSION.SDK_INT < 14 || !i)
        {
            r();
        }
        if ((context.getApplicationInfo().flags & 2) != 0)
        {
            c.b(null);
        }
        q();
        return;
_L7:
        if (!((String) (obj2)).equals("staging")) goto _L9; else goto _L8
_L8:
        ay1 = ay.c;
          goto _L4
_L9:
        if (!((String) (obj2)).equals("dev")) goto _L4; else goto _L10
_L10:
        ay1 = ay.a;
          goto _L4
        Exception exception;
        exception;
        com.j.a.g.w.b("problem setting session interval time", exception);
          goto _L11
_L2:
        map = ay1;
          goto _L12
        map = ay1;
          goto _L12
    }

    public void a(f f1)
    {
        if (!k)
        {
            f1.a(null);
            return;
        }
        if (p)
        {
            b(f1);
            return;
        }
        if (C == null)
        {
            C = new ArrayList();
        }
        C.add(f1);
    }

    public void a(Integer integer)
    {
        s = integer;
    }

    public void a(String s1, String s2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("exp", s1);
        s1 = new d();
        s1.a(new ad(this, s2));
        e().a(((Map) (hashmap)), ((d) (s1)));
    }

    public void a(String s1, String s2, String s3, String s4)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("exp", s1);
        hashmap.put("var", s2);
        s1 = new d();
        s1.a(new y(this, s3, s4));
        e().a(((Map) (hashmap)), ((d) (s1)));
    }

    public void a(String s1, boolean flag, com.j.a.b b1)
    {
        if (!com.j.a.g.m.a(com.j.a.g.b.r)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (k)
        {
            break; /* Loop/switch isn't completed */
        }
        if (b1 != null)
        {
            b1.a(null);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (s1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        com.j.a.g.w.c("Code experiment name null! running baseline variation!");
        if (b1 != null)
        {
            b1.a(null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj7;
        JSONArray jsonarray;
        com.j.a.c.d d1;
        Object obj8;
        int j1;
        if (b1 == null)
        {
            com.j.a.g.w.c("No TaplyticsCodeExperimentListener to run code experiment!");
            return;
        }
        if (w == null && !flag)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("experiment", s1);
            hashmap.put("listener", b1);
            B.add(hashmap);
            return;
        }
        j1 = 0;
        d1 = null;
        jsonarray = null;
        obj7 = null;
        obj1 = null;
        obj3 = null;
        obj2 = null;
        obj = null;
        obj4 = "baseline";
        obj8 = null;
        obj5 = obj1;
        if (w == null) goto _L6; else goto _L5
_L5:
        obj5 = obj1;
        if (w.e() == null) goto _L6; else goto _L7
_L7:
        obj5 = obj1;
        if (s1 == null) goto _L6; else goto _L8
_L8:
        if (!w.e().a(s1)) goto _L10; else goto _L9
_L9:
        obj5 = w.e().b(s1);
_L6:
        if (obj5 == null) goto _L12; else goto _L11
_L11:
        if (w.h() == null) goto _L12; else goto _L13
_L13:
        obj1 = ((com.j.a.c.d) (obj5)).optString("_id");
        obj2 = obj8;
        obj3 = jsonarray;
        if (!((com.j.a.c.d) (obj5)).has("customVariableNames"))
        {
            break MISSING_BLOCK_LABEL_268;
        }
        obj3 = jsonarray;
        obj2 = ((com.j.a.c.d) (obj5)).optJSONArray("customVariableNames");
        obj3 = jsonarray;
        d1 = ((com.j.a.c.d) (obj5)).b("baseline");
        obj = obj7;
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        obj = obj7;
        obj3 = jsonarray;
        if (!d1.a("customVariables"))
        {
            break MISSING_BLOCK_LABEL_330;
        }
        obj3 = jsonarray;
        obj = a(d1.optJSONObject("customVariables"), ((JSONArray) (obj2)));
        obj3 = obj;
        jsonarray = ((com.j.a.c.d) (obj5)).optJSONArray("variations");
        int i1;
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_1206;
        }
        i1 = 0;
_L25:
        obj3 = obj;
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_1206;
        }
        obj3 = obj;
        obj7 = new com.j.a.c.d(jsonarray.optJSONObject(i1));
        obj3 = obj;
        if (!((com.j.a.c.d) (obj7)).a("_id")) goto _L15; else goto _L14
_L14:
        obj3 = obj;
        obj5 = w.h();
        obj3 = obj;
        if (obj5 instanceof JSONArray) goto _L17; else goto _L16
_L16:
        obj3 = obj;
        obj5 = ((JSONArray) (obj5)).toString();
_L24:
        obj3 = obj;
        if (!((String) (obj5)).contains((new StringBuilder()).append("\"").append(((com.j.a.c.d) (obj7)).optString("_id")).append("\"").toString())) goto _L15; else goto _L18
_L18:
        obj3 = obj;
        obj5 = ((com.j.a.c.d) (obj7)).getString("_id");
        obj3 = obj5;
        obj4 = obj7;
_L34:
        obj5 = obj3;
        obj3 = obj2;
        obj2 = obj;
        obj = obj1;
        obj1 = obj5;
_L26:
        if (obj4 == null) goto _L20; else goto _L19
_L19:
        if (!((com.j.a.c.d) (obj4)).a("customVariables")) goto _L22; else goto _L21
_L21:
        obj5 = ((com.j.a.c.d) (obj4)).b("customVariables");
_L27:
        obj4 = ((com.j.a.c.d) (obj4)).optString("name");
        if (((String) (obj4)).equals("") || obj4 == null) goto _L20; else goto _L23
_L23:
        com.j.a.g.w.a((new StringBuilder()).append("Show var: ").append(((String) (obj4))).append(", for exp: ").append(s1).toString());
        b1.a(((String) (obj4)), a(((JSONObject) (obj5)), ((JSONArray) (obj3))));
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = true;
        flag1 = true;
        i1 = ((flag1) ? 1 : 0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_739;
        }
        i1 = ((flag1) ? 1 : 0);
        obj5 = obj1;
        obj4 = obj;
        obj7 = obj2;
        j1 = ((flag3) ? 1 : 0);
        if (((String) (obj)).equals(""))
        {
            break MISSING_BLOCK_LABEL_739;
        }
        i1 = ((flag1) ? 1 : 0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_739;
        }
        i1 = ((flag1) ? 1 : 0);
        obj5 = obj1;
        obj4 = obj;
        obj7 = obj2;
        j1 = ((flag3) ? 1 : 0);
        if (((String) (obj1)).equals(""))
        {
            break MISSING_BLOCK_LABEL_739;
        }
        obj5 = obj1;
        obj4 = obj;
        obj7 = obj2;
        j1 = ((flag3) ? 1 : 0);
        e.a(((String) (obj)), ((String) (obj1)));
        i1 = ((flag1) ? 1 : 0);
_L33:
        if (i1 == 0)
        {
            com.j.a.g.w.a((new StringBuilder()).append("Show base var for exp: ").append(s1).toString());
            b1.a(((Map) (obj2)));
            if (obj != null && obj1 != null)
            {
                e.a(((String) (obj)), ((String) (obj1)));
                return;
            }
        }
          goto _L1
_L10:
        obj5 = null;
          goto _L6
_L17:
        obj3 = obj;
        obj5 = JSONArrayInstrumentation.toString((JSONArray)obj5);
          goto _L24
_L15:
        i1++;
          goto _L25
_L12:
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_863;
        }
        com.j.a.g.w.a((new StringBuilder()).append("No exp found by name ").append(s1).append(", disp baseline instead.").toString());
        obj3 = null;
        obj2 = null;
        obj5 = null;
        obj1 = obj4;
        obj4 = obj5;
          goto _L26
_L22:
        obj5 = null;
          goto _L27
        obj5;
        obj2 = null;
        i1 = 0;
        obj = obj3;
        obj1 = obj4;
        obj3 = obj5;
_L32:
        obj5 = obj1;
        obj4 = obj;
        obj7 = obj2;
        j1 = i1;
        com.j.a.g.w.b("Get code exp", ((Exception) (obj3)));
        if (i1 != 0) goto _L1; else goto _L28
_L28:
        com.j.a.g.w.a((new StringBuilder()).append("Show base var for exp: ").append(s1).toString());
        b1.a(((Map) (obj2)));
        if (obj == null || obj1 == null) goto _L1; else goto _L29
_L29:
        e.a(((String) (obj)), ((String) (obj1)));
        return;
        obj3;
        i1 = j1;
        obj1 = d1;
        obj = obj2;
        obj5 = obj4;
        obj2 = obj3;
_L31:
        if (i1 == 0)
        {
            com.j.a.g.w.a((new StringBuilder()).append("Show base var for exp: ").append(s1).toString());
            b1.a(((Map) (obj1)));
            if (obj != null && obj5 != null)
            {
                e.a(((String) (obj)), ((String) (obj5)));
            }
        }
        throw obj2;
        obj2;
        obj = obj1;
        obj5 = obj4;
        obj1 = obj3;
        i1 = j1;
        continue; /* Loop/switch isn't completed */
        obj4;
        obj3 = obj2;
        obj2 = obj4;
        obj5 = obj1;
        obj1 = obj3;
        i1 = j1;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj1 = obj7;
        i1 = j1;
        obj = obj4;
        if (true) goto _L31; else goto _L30
_L30:
        obj3;
        obj = obj1;
        obj2 = null;
        i1 = 0;
        obj1 = obj4;
          goto _L32
        obj3;
        obj2 = obj1;
        Object obj6 = obj;
        i1 = 0;
        obj1 = obj4;
        obj = obj2;
        obj2 = obj6;
          goto _L32
        obj3;
        i1 = 0;
          goto _L32
        obj3;
        i1 = ((flag2) ? 1 : 0);
          goto _L32
_L20:
        i1 = 0;
          goto _L33
        obj3 = "baseline";
        obj4 = null;
          goto _L34
    }

    public void a(Map map, d d1)
    {
        if (!k)
        {
            return;
        }
        d d2;
        if (v.c())
        {
            d2 = new d();
        } else
        {
            d2 = v;
        }
        v = d2;
        c.a(map, new g(this, d1));
    }

    public void a(JSONObject jsonobject)
    {
        if (jsonobject != null && w != null && !com.j.a.g.m.a(com.j.a.g.b.k))
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject("ViewElement");
            jsonobject = jsonobject.optJSONObject("Image");
            if (jsonobject1 != null)
            {
                b(jsonobject1);
            }
            if (jsonobject != null)
            {
                c(jsonobject);
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        i = flag;
    }

    public void a(boolean flag, Map map)
    {
        JSONObject jsonobject;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag1 = true;
        JSONObject jsonobject1;
        if ((x.getApplicationInfo().flags & 2) != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (w == null || w.c() == null) goto _L2; else goto _L1
_L1:
        jsonobject1 = w.c().optJSONObject("settings");
        if (jsonobject1 == null) goto _L2; else goto _L3
_L3:
        jsonobject = jsonobject1.optJSONObject("enabledForReleaseModes");
        flag3 = jsonobject1.optBoolean("setFromUserDevice", false);
_L5:
        if (jsonobject != null)
        {
            if (flag2)
            {
                flag2 = jsonobject.optBoolean("dev", true);
            } else
            {
                flag2 = jsonobject.optBoolean("appStore", false);
            }
        }
        if (map != null && map.containsKey("liveUpdate"))
        {
            h = ((Boolean)map.get("liveUpdate")).booleanValue();
            l = true;
        }
        if (!l)
        {
            if (flag3)
            {
                if (h == flag2)
                {
                    flag1 = false;
                }
                h = flag2;
                if (flag1 && !flag)
                {
                    a(((Map) (null)), ((d) (null)));
                }
            } else
            {
                h = flag2;
            }
        }
        if (!h)
        {
            az.a().c();
        }
        q();
        return;
_L2:
        flag3 = false;
        jsonobject = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void b(Activity activity)
    {
        if (k && !b()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.j.a.g.w.a("Checking for app link");
        if (activity == null) goto _L1; else goto _L3
_L3:
        try
        {
            activity = activity.getIntent();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.j.a.g.w.b("Error finding app link", activity);
            return;
        }
        if (activity == null) goto _L1; else goto _L4
_L4:
        if (activity.getAction() == null) goto _L1; else goto _L5
_L5:
        com.j.a.g.w.a((new StringBuilder()).append("Intent data string:").append(activity.getDataString()).toString());
        if (activity.getAction().equals("android.intent.action.VIEW") && activity.getDataString() != null && activity.getDataString().startsWith("tl-"))
        {
            com.j.a.g.w.a("Found App Link!");
            az.a().a(activity.getDataString());
            return;
        }
          goto _L1
    }

    public void b(JSONObject jsonobject)
    {
        Object obj1;
        boolean flag;
        obj1 = jsonobject.optString("key");
        flag = jsonobject.optBoolean("android");
        if (obj1 == null || !Boolean.valueOf(flag).booleanValue()) goto _L2; else goto _L1
_L1:
        com.j.a.g.w.a((new StringBuilder()).append("Got Updated View from Socket: ").append(((String) (obj1))).toString());
        Object obj = w.j();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = new a(((JSONArray) (obj)));
          goto _L5
_L15:
        int i1;
        if (i1 >= ((a) (obj)).length()) goto _L7; else goto _L6
_L6:
        Object obj2 = ((a) (obj)).optJSONObject(i1);
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        obj2 = ((JSONObject) (obj2)).optString("key");
        if (obj2 == null) goto _L9; else goto _L10
_L10:
        if (!((String) (obj1)).equals(obj2)) goto _L9; else goto _L11
_L11:
        obj1 = obj;
        if (i1 <= -1)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        obj1 = ((a) (obj)).a(i1);
        ((a) (obj1)).put(jsonobject);
        w.a(((a) (obj1)).a());
_L13:
        com.j.a.d.ag.c().e();
_L2:
        return;
_L4:
        try
        {
            obj = new a();
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.j.a.g.w.b("Update View From Socket JSONException", jsonobject);
        }
        if (true) goto _L13; else goto _L12
_L12:
        break; /* Loop/switch isn't completed */
_L9:
        i1++;
        continue; /* Loop/switch isn't completed */
_L7:
        i1 = -1;
        if (true) goto _L11; else goto _L5
_L5:
        i1 = 0;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public void b(boolean flag)
    {
        q = flag;
    }

    public boolean b()
    {
        return t;
    }

    public void c(JSONObject jsonobject)
    {
        String s1 = jsonobject.optString("_id");
        if (s1.equals("") || e().o() == null || w == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        com.j.a.g.w.a((new StringBuilder()).append("Got Update Image From Socket: ").append(s1).toString());
        JSONObject jsonobject1;
        JSONObject jsonobject2;
        try
        {
            jsonobject2 = w.k();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            com.j.a.g.w.b("Updating Image From Socket JSONException", jsonobject);
            return;
        }
        jsonobject1 = jsonobject2;
        if (jsonobject2 != null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        jsonobject1 = new JSONObject();
        if (jsonobject1.has(s1))
        {
            jsonobject1.remove(s1);
        }
        jsonobject1.put(s1, jsonobject);
        com.j.a.g.c.a(jsonobject.optString("path"), jsonobject.optString("filename"), e().o());
        if (e().p() != null && g() && com.j.a.d.ag.c().d() != null)
        {
            com.j.a.g.o.c(com.j.a.d.ag.c().d());
        }
    }

    public void c(boolean flag)
    {
        m = flag;
        if (flag)
        {
            t();
        }
        if (q)
        {
            q = false;
        }
    }

    public boolean c()
    {
        return u;
    }

    public d d()
    {
        return v;
    }

    public void d(boolean flag)
    {
        t = flag;
    }

    public String f()
    {
        return g;
    }

    public boolean g()
    {
        return h;
    }

    public boolean h()
    {
        return n;
    }

    public boolean i()
    {
        return m;
    }

    public boolean j()
    {
        return k;
    }

    public com.j.a.c.e k()
    {
        return w;
    }

    public com.j.a.e.a l()
    {
        return c;
    }

    public c m()
    {
        return d;
    }

    public com.j.a.a.d n()
    {
        return e;
    }

    public Context o()
    {
        return x;
    }

    public Activity p()
    {
        return y;
    }

    public void q()
    {
        if (((x.getApplicationInfo().flags & 2) != 0 || g()) && !com.j.a.g.m.a(com.j.a.g.b.v) && A == null)
        {
            A = new q();
            A.a(this);
            A.a(x);
        }
    }

    public void r()
    {
        if (o)
        {
            return;
        } else
        {
            o = true;
            a(((Map) (null)), ((d) (null)));
            n().a("appActive");
            x();
            return;
        }
    }

    public void s()
    {
        w.a(null);
        a(((Map) (null)), ((d) (null)));
    }

    public void t()
    {
        if (r != null && q && (new Date()).getTime() - r.getTime() > (long)(s.intValue() * 60 * 1000))
        {
            o = false;
            s();
        }
        r = new Date();
    }

    public void u()
    {
        B.clear();
    }

    public void v()
    {
        if (!h)
        {
            com.j.a.g.w.a("live update being set to true due to pair token.");
            h = true;
            q();
        }
        a(((Map) (null)), ((d) (null)));
        if (y != null && m)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(y);
            builder.setTitle("Taplytics Pairing Successful!");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new ae(this));
            D = builder.create();
            D.show();
        }
    }

}
