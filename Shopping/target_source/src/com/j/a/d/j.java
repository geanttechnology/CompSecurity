// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.AsyncTask;
import com.j.a.c.c;
import com.j.a.c.d;
import com.j.a.c.e;
import com.j.a.e.a;
import com.j.a.g.b;
import com.j.a.g.m;
import com.j.a.g.w;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            e, k, af

public class j
{

    private Boolean a;
    private List b;
    private com.j.a.e c;
    private com.j.a.d d;

    public j()
    {
        a = Boolean.valueOf(false);
        b = null;
        c = null;
        d = null;
        b = new ArrayList();
    }

    static com.j.a.e a(j j1)
    {
        return j1.c;
    }

    static Boolean a(j j1, Boolean boolean1)
    {
        j1.a = boolean1;
        return boolean1;
    }

    public void a(JSONObject jsonobject)
    {
        Object obj = null;
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        if (jsonobject.length() == 0) goto _L2; else goto _L3
_L3:
        if (jsonobject == JSONObject.NULL)
        {
            return;
        }
        String s;
        JSONObject jsonobject1;
        e e1;
        try
        {
            jsonobject1 = new JSONObject();
            w.a("Creating params");
            e1 = com.j.a.d.e.e().k();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            w.b("Posting GCM Token", jsonobject);
            return;
        }
        if (e1 == null) goto _L2; else goto _L4
_L4:
        jsonobject1.put("ad", com.j.a.d.e.e().m().d().get("id"));
        if (e1.c() == null) goto _L6; else goto _L5
_L5:
        s = e1.c().optString("_id");
_L11:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        jsonobject1.put("pid", s);
        if (com.j.a.d.e.e().f() != null)
        {
            jsonobject1.put("t", com.j.a.d.e.e().f());
        }
        if (e1.i() == null) goto _L8; else goto _L7
_L7:
        s = e1.i().optString("_id");
_L9:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        jsonobject1.put("auid", s);
        s = obj;
        if (e1.b() != null)
        {
            s = e1.b();
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        jsonobject1.put("sid", s);
        w.a((new StringBuilder()).append("Posting GCM Token: ").append(jsonobject.optString("token")).toString());
        w.a((new StringBuilder()).append("Posting GCM Token, environment: ").append(jsonobject.optString("env")).toString());
        jsonobject1.put("pt", jsonobject.optString("token"));
        jsonobject1.put("env", jsonobject.optString("env"));
        jsonobject1.put("os", "Android");
        com.j.a.d.e.e().l().d(jsonobject1, new k(this));
        return;
_L6:
        s = null;
        continue; /* Loop/switch isn't completed */
_L8:
        s = null;
        if (true) goto _L9; else goto _L2
_L2:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void a(boolean flag)
    {
        Object obj = null;
        if ((!a.booleanValue() || flag) && com.j.a.d.e.e().j() && !m.a(b.q)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (com.j.a.d.e.e().k() != null)
        {
            obj = com.j.a.d.e.e().k().c();
        }
        if (obj == null) goto _L1; else goto _L3
_L3:
        obj = ((JSONObject) (obj)).optJSONObject("credentials");
        if (obj == null)
        {
            try
            {
                w.a("Project does not have GCM credentials");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                w.b("Getting GCM senderID", ((Exception) (obj)));
            }
            return;
        }
        Object obj1 = ((JSONObject) (obj)).optJSONObject("gcm");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        obj1 = ((JSONObject) (obj1)).getString("gcmSenderId");
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        Object obj2;
        String as[];
        w.a((new StringBuilder()).append("Sender ID: ").append(((String) (obj1))).toString());
        obj2 = new af(this, null);
        as = new String[2];
        as[0] = ((String) (obj1));
        as[1] = "prod";
        if (obj2 instanceof AsyncTask)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        ((af) (obj2)).execute(as);
_L7:
        obj = ((JSONObject) (obj)).optJSONObject("gcmSandbox");
        if (obj == null) goto _L1; else goto _L4
_L4:
        if (!com.j.a.d.e.e().g()) goto _L1; else goto _L5
_L5:
        obj = ((JSONObject) (obj)).getString("gcmSenderId");
        if (obj == null) goto _L1; else goto _L6
_L6:
        w.a((new StringBuilder()).append("Sandbox Sender ID: ").append(((String) (obj))).toString());
        obj1 = new af(this, null);
        obj2 = new String[2];
        obj2[0] = obj;
        obj2[1] = "sandbox";
        if (!(obj1 instanceof AsyncTask))
        {
            ((af) (obj1)).execute(((Object []) (obj2)));
            return;
        }
        break MISSING_BLOCK_LABEL_280;
        AsyncTaskInstrumentation.execute((AsyncTask)obj2, as);
          goto _L7
        AsyncTaskInstrumentation.execute((AsyncTask)obj1, ((Object []) (obj2)));
        return;
    }

    public boolean a()
    {
        return a.booleanValue();
    }

    public void b()
    {
        d = null;
        if (b != null)
        {
            b.clear();
        }
    }
}
