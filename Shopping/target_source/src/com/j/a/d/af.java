// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.AsyncTask;
import com.google.android.gms.gcm.d;
import com.j.a.c.e;
import com.j.a.g.w;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.j.a.d:
//            e, j, k

class af extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    Random a;
    final j b;

    private af(j j1)
    {
        b = j1;
        super();
        a = new Random();
    }

    af(j j1, k k)
    {
        this(j1);
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected transient JSONObject a(String as[])
    {
        Object obj;
        Object obj1;
        int i;
        long l;
        long l1;
        obj = null;
        String s;
        String s1;
        if (as != null && as.length > 0)
        {
            s = as[0];
        } else
        {
            s = null;
        }
        if (as != null && as.length > 1)
        {
            s1 = as[1];
        } else
        {
            s1 = null;
        }
        l = a.nextInt(1000) + 10;
        i = 1;
_L4:
        obj1 = obj;
        if (i > 10)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        w.a((new StringBuilder()).append("Attempt #").append(i).append(" to register").toString());
        as = ((String []) (obj));
        obj1 = d.a(com.j.a.d.e.e().o());
        as = ((String []) (obj));
        l1 = l;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        as = ((String []) (obj));
        l1 = l;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        as = ((String []) (obj));
        w.a("Posting the GCM token");
        as = ((String []) (obj));
        obj1 = ((d) (obj1)).a(new String[] {
            s
        });
        as = ((String []) (obj1));
        w.a((new StringBuilder()).append("Push Token: ").append(((String) (obj1))).toString());
_L2:
        as = new JSONObject();
        as.put("token", obj1);
        as.put("env", s1);
        return as;
        obj;
        w.b((new StringBuilder()).append("Failed to register on attempt ").append(i).toString(), ((Exception) (obj)));
        obj1 = as;
        if (i == 10) goto _L2; else goto _L1
_L1:
        try
        {
            w.a((new StringBuilder()).append("Sleeping for ").append(l).append(" ms before retry").toString());
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedexception)
        {
            w.a("Thread interrupted: abort remaining retries!");
            Thread.currentThread().interrupt();
        }
        l1 = l * 2L;
        i++;
        obj = as;
        l = l1;
        continue; /* Loop/switch isn't completed */
        JSONException jsonexception;
        jsonexception;
        w.b("Getting GCM token", jsonexception);
        return as;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(JSONObject jsonobject)
    {
        boolean flag;
        flag = false;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        Object obj = com.j.a.d.e.e().k();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        j.a(b, Boolean.valueOf(true));
        return;
        obj = com.j.a.d.e.e().k().i();
        if (obj == null)
        {
            j.a(b, Boolean.valueOf(true));
            return;
        }
        obj = ((JSONObject) (obj)).optJSONArray("deviceInfo");
        int i;
        if (obj == null)
        {
            j.a(b, Boolean.valueOf(true));
            return;
        }
        i = 0;
_L2:
        Object obj1;
        if (i >= ((JSONArray) (obj)).length())
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj1 = ((JSONArray) (obj)).getJSONObject(i);
        boolean flag1 = flag;
        String s;
        if (!jsonobject.optString("env").equals("sandbox"))
        {
            break MISSING_BLOCK_LABEL_157;
        }
        s = ((JSONObject) (obj1)).optString("pushTokenSandbox");
        flag1 = flag;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        flag1 = flag;
        if (jsonobject.optString("token").equals(s))
        {
            flag1 = true;
        }
        flag = flag1;
        if (!jsonobject.optString("env").equals("prod"))
        {
            break MISSING_BLOCK_LABEL_311;
        }
        obj1 = ((JSONObject) (obj1)).optString("pushToken");
        flag = flag1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        flag = flag1;
        if (jsonobject.optString("token").equals(obj1))
        {
            flag = true;
        }
        break MISSING_BLOCK_LABEL_311;
        w.a(jsonobject.optString("token"));
        if (j.a(b) != null)
        {
            j.a(b).a(jsonobject.optString("token"));
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        b.a(jsonobject);
        j.a(b, Boolean.valueOf(true));
        return;
        jsonobject;
        w.b("Checking GCM Push Token", jsonobject);
        j.a(b, Boolean.valueOf(true));
        return;
        jsonobject;
        j.a(b, Boolean.valueOf(true));
        throw jsonobject;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "af#doInBackground", null);
_L1:
        aobj = a((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "af#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "af#onPostExecute", null);
_L1:
        a((JSONObject)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "af#onPostExecute", null);
          goto _L1
    }
}
