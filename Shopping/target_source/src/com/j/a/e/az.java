// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import com.d.a.b.a;
import com.j.a.c.c;
import com.j.a.c.d;
import com.j.a.d.e;
import com.j.a.g.b;
import com.j.a.g.m;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            w, x, v, a, 
//            u, t, s, q, 
//            n, l, ao, am, 
//            al, aj, ah, af, 
//            av, aa, k, ar, 
//            y, ac

public class az
{

    private static final az c = new az();
    public boolean a;
    public boolean b;
    private com.d.a.g.a.e d;
    private String e;
    private Boolean f;
    private Boolean g;
    private JSONObject h;
    private boolean i;
    private int j;
    private AlertDialog k;

    private az()
    {
        d = null;
        e = null;
        f = Boolean.valueOf(false);
        g = Boolean.valueOf(false);
        a = false;
        b = false;
        i = false;
        j = 0;
        k = null;
    }

    public static az a()
    {
        return c;
    }

    static Boolean a(az az1)
    {
        return az1.f;
    }

    static Boolean a(az az1, Boolean boolean1)
    {
        az1.g = boolean1;
        return boolean1;
    }

    static String a(az az1, String s1)
    {
        az1.e = s1;
        return s1;
    }

    static void a(az az1, JSONObject jsonobject)
    {
        az1.c(jsonobject);
    }

    private void a(JSONObject jsonobject)
    {
        Object obj = com.j.a.d.e.e();
        if (!((e) (obj)).j() || ((e) (obj)).o() == null || jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_189;
        }
        android.app.AlertDialog.Builder builder;
        if (k != null || !com.j.a.d.e.e().i() || com.j.a.d.e.e().p() == null || !com.j.a.d.e.e().i())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        builder = new android.app.AlertDialog.Builder(com.j.a.d.e.e().p());
        builder.setTitle("Connect Taplytics Test Device");
        obj = jsonobject.getString("user_name");
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        builder.setMessage((new StringBuilder()).append("To User: ").append(((String) (obj))).toString());
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new com.j.a.e.w(this, jsonobject));
        builder.setNegativeButton("No Thanks", new x(this));
        k = builder.create();
        k.show();
        return;
        JSONException jsonexception;
        jsonexception;
        w.b("Getting Test Device username", jsonexception);
        jsonexception = null;
        if (true) goto _L2; else goto _L1
_L1:
        jsonobject;
        w.b(getClass().toString(), jsonobject);
    }

    static void b(az az1)
    {
        az1.e();
    }

    static void b(az az1, JSONObject jsonobject)
    {
        az1.a(jsonobject);
    }

    private void b(JSONObject jsonobject)
    {
        com.j.a.c.e e1 = com.j.a.d.e.e().k();
        if (e1 == null || e1.b() == null || jsonobject == null) goto _L2; else goto _L1
_L1:
        w.a("Send Connect Test Device Socket!");
        if (jsonobject instanceof JSONObject) goto _L4; else goto _L3
_L3:
        jsonobject = jsonobject.toString();
_L5:
        jsonobject = JSONObjectInstrumentation.init(jsonobject);
        jsonobject.put("session_id", e1.b());
_L6:
        if (jsonobject != null)
        {
            d.a("foundTestDevice", new Object[] {
                jsonobject
            });
            StringBuilder stringbuilder = (new StringBuilder()).append("Found test device: ");
            if (!(jsonobject instanceof JSONObject))
            {
                jsonobject = jsonobject.toString();
            } else
            {
                jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
            }
            w.a(stringbuilder.append(jsonobject).toString());
        }
_L2:
        return;
_L4:
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L5
        jsonobject;
        w.b("sendConnectTestDeviceSocket creating JSON Object", jsonobject);
        jsonobject = null;
          goto _L6
    }

    static void c(az az1)
    {
        az1.f();
    }

    static void c(az az1, JSONObject jsonobject)
    {
        az1.b(jsonobject);
    }

    private void c(JSONObject jsonobject)
    {
        if (jsonobject == null || k == null) goto _L2; else goto _L1
_L1:
        Object obj1 = com.j.a.d.e.e().k();
        jsonobject = jsonobject.getString("project_id");
        Object obj = jsonobject;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        obj = jsonobject;
        if (((com.j.a.c.e) (obj1)).c() == null) goto _L4; else goto _L5
_L5:
        obj = ((com.j.a.c.e) (obj1)).c().getString("_id");
        obj1 = jsonobject;
        jsonobject = ((JSONObject) (obj));
_L6:
        if (obj1 != null && jsonobject != null && ((String) (obj1)).equals(jsonobject))
        {
            k.dismiss();
            k = null;
        }
_L2:
        return;
        obj;
        jsonobject = null;
_L7:
        w.b("hideTestDeviceAlert get project_id", ((Exception) (obj)));
        obj = jsonobject;
_L4:
        jsonobject = null;
        obj1 = obj;
          goto _L6
        obj;
          goto _L7
    }

    static JSONObject d(az az1, JSONObject jsonobject)
    {
        az1.h = jsonobject;
        return jsonobject;
    }

    static void d(az az1)
    {
        az1.g();
    }

    static JSONObject e(az az1)
    {
        return az1.h;
    }

    private void e()
    {
        w.a("Retry Connecting SocketIO");
        c();
        d = null;
        (new Timer()).schedule(new v(this), 500L);
    }

    static int f(az az1)
    {
        int i1 = az1.j;
        az1.j = i1 + 1;
        return i1;
    }

    private void f()
    {
        Map map = com.j.a.d.e.e().m().a();
        if (d == null || map == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        if (map.containsKey("pid"))
        {
            String s1 = (new StringBuilder()).append("project_").append(map.get("pid")).toString();
            if (e == null || !e.equals(s1))
            {
                map.put("room", s1);
                d.a("subscribe", new Object[] {
                    new JSONObject(map)
                });
                e = s1;
                b = true;
                w.a((new StringBuilder()).append("Connected to Socket Room: ").append(e).toString());
            }
        }
        return;
        Exception exception;
        exception;
    }

    private void g()
    {
        k = null;
    }

    public void a(ar ar1)
    {
        String s1;
        s1 = com.j.a.d.e.e().l().a();
        w.a("connecting socket");
        if (d != null && d.f() || g.booleanValue() || m.a(b.m)) goto _L2; else goto _L1
_L1:
        g = Boolean.valueOf(true);
        if (d == null) goto _L4; else goto _L3
_L3:
        com.d.a.g.a.b.a a1 = new com.d.a.g.a.b.a();
        a1.q = true;
        d = com.d.a.g.a.b.a(s1, a1);
_L5:
        f = Boolean.valueOf(false);
        b = false;
        d.a("connect", new u(this, ar1)).a("disconnect", new t(this, ar1)).a("error", new s(this)).a("connectTestDevice", new q(this)).a("foundTestDevice", new n(this)).a("clientShowExperiment", new l(this)).a("clientHideExperiment", new ao(this)).a("clientPickElement", new am(this)).a("highlightTapElement", new al(this)).a("experimentUpdated", new aj(this)).a("dataUpdated", new ah(this)).a("chooseView", new af(this)).a("foundView", new av(this)).a("pairTokenSuccessful", new aa(this)).a("pairTokenFailed", new k(this));
        w.a((new StringBuilder()).append("Connect SocketIO with path: ").append(s1).toString());
        d.c();
_L7:
        return;
_L4:
        try
        {
            d = com.d.a.g.a.b.a(s1);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            try
            {
                w.b("Socket URI path error", urisyntaxexception);
            }
            // Misplaced declaration of an exception variable
            catch (ar ar1)
            {
                w.b("socket problem", ar1);
                return;
            }
        }
          goto _L5
_L2:
        if (ar1 == null) goto _L7; else goto _L6
_L6:
        ar1.a(Boolean.valueOf(true));
        return;
          goto _L5
    }

    public void a(String s1)
    {
        if (i)
        {
            return;
        }
        if (s1 == null)
        {
            w.a("Missing link to pair device");
            return;
        }
        com.j.a.c.e e1 = com.j.a.d.e.e().k();
        String s2;
        try
        {
            if (!a)
            {
                a(((ar) (new y(this, s1))));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
        if (com.j.a.d.e.e().f() == null || e1 == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        if (e1.c() == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        s2 = e1.b();
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        try
        {
            if (h == null)
            {
                h = new JSONObject();
            }
            h.put("projectToken", com.j.a.d.e.e().f());
            s1 = s1.substring(3);
            h.put("projectConnectToken", s1.substring(0, s1.indexOf("://")));
            h.put("deviceToken", s1.substring(s1.indexOf("://") + 3, s1.length()));
            h.put("session_id", e1.b());
            a("pairDeviceWithToken", h);
            i = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        w.b("Sending pairing device socket", s1);
        return;
        (new Handler(Looper.getMainLooper())).postDelayed(new ac(this, s1), 1000L);
        return;
    }

    public void a(String s1, Object obj)
    {
label0:
        {
            if (d != null)
            {
                w.a((new StringBuilder()).append("Emit Socket Event: ").append(s1).append(", data: ").append(obj.toString()).toString());
                if (obj == JSONObject.NULL)
                {
                    break label0;
                }
                d.a(s1, new Object[] {
                    obj
                });
            }
            return;
        }
        d.a(s1, new Object[0]);
    }

    public com.d.a.g.a.e b()
    {
        return d;
    }

    public void c()
    {
        if (d != null)
        {
            f = Boolean.valueOf(true);
            d.e();
            a = false;
            b = false;
        }
    }

    public void d()
    {
        com.j.a.c.e e1;
        e1 = com.j.a.d.e.e().k();
        if (com.j.a.d.e.e().b() || e1 == null || e1.c() == null || !a)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        com.j.a.d.e.e().n().a("tlHasAppLinking");
        JSONObject jsonobject = new JSONObject();
        if (e1.c() != null && e1.c().has("_id"))
        {
            jsonobject.put("project_id", e1.c().opt("_id"));
        }
        if (e1.i() != null && e1.i().has("_id"))
        {
            jsonobject.put("appUser_id", e1.i().opt("_id"));
        }
        if (e1.b() != null)
        {
            jsonobject.put("session_id", e1.b());
        }
        a("hasAppLinking", jsonobject);
        com.j.a.d.e.e().d(true);
        return;
        Exception exception;
        exception;
        w.b("Sending hasAppLinking Socket", exception);
        return;
    }

}
