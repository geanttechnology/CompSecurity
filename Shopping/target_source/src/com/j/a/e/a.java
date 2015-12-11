// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import android.content.Context;
import com.a.a.a.c;
import com.a.a.a.g;
import com.a.a.a.h;
import com.a.a.a.i;
import com.a.a.d;
import com.a.a.n;
import com.j.a.d.ag;
import com.j.a.d.e;
import com.j.a.g.m;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            ay, bc, at, d, 
//            ba, e, p, f, 
//            aq, aw, ax, h, 
//            au, b, c, bb, 
//            ad, as, g, j, 
//            i

public class a
{

    private ay a;
    private String b;
    private String c;
    private String d;
    private n e;

    public a(Context context)
    {
        a = ay.b;
        b = "api.taplytics.com";
        c = "socketio.taplytics.com";
        d = "https://";
        e = new n(new c(context.getCacheDir(), 0x2300000), new com.a.a.a.a(new g()));
        e.a();
    }

    public String a()
    {
        String s = (new StringBuilder()).append(d).append(c).toString();
        if (a != com.j.a.e.ay.d)
        {
            return (new StringBuilder()).append(s).append(":443").toString();
        } else
        {
            return (new StringBuilder()).append(s).append(":3020").toString();
        }
    }

    public void a(ay ay1)
    {
label0:
        {
label1:
            {
label2:
                {
                    if (ay1 != a)
                    {
                        a = ay1;
                        switch (bc.a[a.ordinal()])
                        {
                        default:
                            c = "socketio.taplytics.com";
                            b = "api.taplytics.com";
                            d = "https://";
                            w.a("Switched to Production Server!");
                            break;

                        case 1: // '\001'
                            break label2;

                        case 2: // '\002'
                            break label1;

                        case 3: // '\003'
                            break label0;
                        }
                    }
                    return;
                }
                c = "socketio-dev.taplytics.com";
                b = "dev.taplytics.com";
                d = "https://";
                w.a("Switched to Dev Server!");
                return;
            }
            c = "socketio-staging.taplytics.com";
            b = "staging.taplytics.com";
            d = "https://";
            w.a("Switched to Staging Server!");
            return;
        }
        c = "10.0.3.2";
        b = "10.0.3.2:3002";
        d = "http://";
        w.a("Switched to Local Host!");
    }

    public void a(j j)
    {
        if (!com.j.a.d.e.e().j())
        {
            return;
        } else
        {
            j = new h("https://api.github.com/repos/taplytics/taplytics-android-sdk/releases", new at(this, j), new com.j.a.e.d(this, j));
            j.setTag("github_release");
            e.a(j);
            return;
        }
    }

    public void a(Map map, com.j.a.e.i j)
    {
        if (!com.j.a.d.e.e().j())
        {
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append(d).append(b).append("/api/v1/clientConfig").toString());
            String s = stringbuilder.toString();
            com.j.a.d.e.e().m().a(stringbuilder);
            m.a(map, stringbuilder);
            map = new Date();
            w.a((new StringBuilder()).append("Get Properties From Server, url: ").append(stringbuilder.toString().replaceAll(" ", "%20")).toString());
            map = new i(0, stringbuilder.toString().replaceAll(" ", "%20"), new JSONObject(), new ba(this, map, j), new com.j.a.e.e(this, s, j));
            map.setTag("get_clientConfig");
            map.setRetryPolicy(new d(15000, 3, 1.0F));
            e.a(map);
            return;
        }
    }

    public void a(JSONArray jsonarray, j j)
    {
        if (com.j.a.d.e.e().j()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject;
        String s;
        s = (new StringBuilder()).append(d).append(b).append("/api/v1/experimentElements").toString().replaceAll(" ", "%20");
        jsonobject = ag.c().b();
        if (jsonobject instanceof JSONObject) goto _L4; else goto _L3
_L3:
        Object obj = jsonobject.toString();
_L6:
        obj = JSONObjectInstrumentation.init(((String) (obj)));
        ((JSONObject) (obj)).put("t", com.j.a.d.e.e().f());
        ((JSONObject) (obj)).put("os", "Android");
        ((JSONObject) (obj)).put("views", jsonarray);
        ((JSONObject) (obj)).put("exp_id", jsonobject.optString("experiment_id"));
_L7:
        if (obj == null || ((JSONObject) (obj)).length() == 0) goto _L1; else goto _L5
_L5:
        jsonarray = new Date();
        jsonarray = new p(1, s, ((JSONObject) (obj)), ag.c().m(), new f(this, jsonarray, j), new aq(this, s, j));
        jsonarray.setTag("post_viewinfo");
        e.a(jsonarray);
        return;
_L4:
        obj = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
          goto _L6
        obj;
        jsonarray = null;
_L8:
        w.b("Setting POST experimentElements properties", ((Exception) (obj)));
        obj = jsonarray;
          goto _L7
        Exception exception;
        exception;
        jsonarray = ((JSONArray) (obj));
        obj = exception;
          goto _L8
    }

    public void a(JSONObject jsonobject, j j)
    {
        if (com.j.a.d.e.e().j())
        {
            String s = (new StringBuilder()).append(d).append(b).append("/api/v1/chosenView").toString().replaceAll(" ", "%20");
            JSONObject jsonobject1 = new JSONObject();
            try
            {
                jsonobject1.put("projectToken", com.j.a.d.e.e().f());
                jsonobject1.put("viewDic", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                w.b("postChosenActivity", jsonobject);
            }
            if (jsonobject1.length() != 0)
            {
                jsonobject = new Date();
                jsonobject = new p(1, s, jsonobject1, ag.c().m(), new aw(this, jsonobject, j), new ax(this, s, j));
                jsonobject.setTag("post_chosenView");
                e.a(jsonobject);
                return;
            }
        }
    }

    public void b(j j)
    {
        if (!com.j.a.d.e.e().j())
        {
            return;
        }
        String s = (new StringBuilder()).append(d).append(b).append("/api/v1/images").toString().replaceAll(" ", "%20");
        JSONObject jsonobject = new JSONObject();
        Date date;
        HashMap hashmap;
        byte abyte0[];
        try
        {
            jsonobject.put("projectToken", com.j.a.d.e.e().f());
            jsonobject.put("isAppIcon", true);
            jsonobject.put("isAndroid", true);
        }
        catch (JSONException jsonexception)
        {
            w.b("postChosenActivity", jsonexception);
        }
        date = new Date();
        hashmap = new HashMap();
        abyte0 = com.j.a.g.c.c();
        if (abyte0 != null && abyte0.length > 0)
        {
            hashmap.put("icon", abyte0);
            j = new p(1, s, jsonobject, hashmap, new com.j.a.e.h(this, date, j), new au(this, s, j));
            j.setTag("post_appIcon");
            e.a(j);
            return;
        } else
        {
            w.c("app icon null");
            return;
        }
    }

    public void b(JSONObject jsonobject, j j)
    {
        if (!com.j.a.d.e.e().j() || jsonobject == null || jsonobject.length() == 0)
        {
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder()).append(d).append(b).append("/api/v1/clientEvents").toString());
            String s = stringbuilder.toString();
            com.j.a.d.e.e().m().a(stringbuilder);
            Date date = new Date();
            jsonobject = new i(1, stringbuilder.toString().replaceAll(" ", "%20"), jsonobject, new b(this, date, j), new com.j.a.e.c(this, s, j));
            jsonobject.setTag("post_clientEvents");
            e.a(jsonobject);
            return;
        }
    }

    public void c(JSONObject jsonobject, j j)
    {
        if (!com.j.a.d.e.e().j())
        {
            return;
        } else
        {
            String s = (new StringBuilder()).append(d).append(b).append("/api/v1/clientAppUser").toString();
            Date date = new Date();
            jsonobject = new i(1, s.replaceAll(" ", "%20"), jsonobject, new bb(this, date, j), new ad(this, s, j));
            jsonobject.setTag("post_clientAppUser");
            e.a(jsonobject);
            return;
        }
    }

    public void d(JSONObject jsonobject, j j)
    {
        if (!com.j.a.d.e.e().j() || jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        if (jsonobject.length() == 0)
        {
            return;
        }
        try
        {
            String s = (new StringBuilder()).append(d).append(b).append("/api/v1/pushToken").toString();
            Date date = new Date();
            jsonobject = new i(1, s.replaceAll(" ", "%20"), jsonobject, new as(this, date, j), new com.j.a.e.g(this, s, j));
            jsonobject.setTag("post_pushToken");
            e.a(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
    }
}
