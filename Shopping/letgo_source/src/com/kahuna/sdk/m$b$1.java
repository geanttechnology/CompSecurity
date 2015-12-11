// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.support.v7.agv;
import android.support.v7.ahh;
import android.support.v7.ahj;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            m, r, v, c, 
//            s, d, n

class v extends agv
{

    final a a;

    public void a(String s1)
    {
        int i = 0;
        boolean flag;
        s1 = JSONObjectInstrumentation.init(s1);
        flag = s1.getBoolean("success");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_324;
        }
        synchronized (m.d(a.a))
        {
            m.e(a.a).removeAll(m.C(a.a));
            r.a(m.e(a.a), m.a(a.a));
        }
        r.b(m.f(a.a).get(), m.a(a.a));
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Number events submitted: ").append(m.C(a.a).size()).toString());
        }
        m.B(a.a).addAndGet(0 - m.C(a.a).size());
        m.C(a.a).clear();
        m.b(a.a, null);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Events let in Queue: ").append(m.e(a.a).size()).toString());
        }
        m.a(a.a, System.currentTimeMillis() / 1000L);
        r.a(m.H(a.a), m.a(a.a));
        m.a(a.a, null);
        m.a(a.a, null);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("server reply: ").append(flag).toString());
        }
        obj = s1.optJSONArray("s");
        if (obj == null) goto _L2; else goto _L1
_L1:
        int j = ((JSONArray) (obj)).length();
_L7:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = ((JSONArray) (obj)).optString(i);
        if (v.a(((String) (obj1)))) goto _L4; else goto _L3
_L3:
        if (!"a".equals(((String) (obj1)).trim())) goto _L6; else goto _L5
_L5:
        obj1 = m.q(a.a);
        c c1 = new c("k_server_request");
        c1.b(((java.util.Map) (obj1)));
        a.a.a(c1);
_L4:
        i++;
        if (true) goto _L7; else goto _L2
        s1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
_L13:
        boolean flag1;
        flag1 = flag;
        if (m.a)
        {
            Log.w("Kahuna", (new StringBuilder()).append("Caught exception in http response handler: ").append(s1).toString());
            Thread.dumpStack();
            flag1 = flag;
        }
_L10:
        synchronized (m.r(a.a))
        {
            m.b(a.a, false);
        }
        if (m.C(a.a) != null)
        {
            m.C(a.a).clear();
            m.b(a.a, null);
        }
        JSONObject jsonobject;
        c c2;
        if (flag1)
        {
            synchronized (m.n(a.a))
            {
                if (m.o(a.a) != null)
                {
                    m.o(a.a).ncel();
                    m.a(a.a, null);
                }
                if (m.B(a.a).get() > 0 || m.I(a.a))
                {
                    m.a(a.a, new nit>(a.a, null));
                    m.o(a.a).hedule(new nit>(a.a, null), 2000L);
                }
            }
            return;
        } else
        {
            m.G(a.a);
            return;
        }
_L6:
        if (!"c".equals(((String) (obj1)).trim())) goto _L4; else goto _L8
_L8:
        obj1 = r.e(m.a(a.a));
        c2 = new c("k_server_request");
        c2.a(((java.util.Map) (obj1)));
        a.a.a(c2);
          goto _L4
_L2:
        jsonobject = s1.optJSONObject("c");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_1146;
        }
        m.a(a.a, s.a(jsonobject));
        d.a(m.A(a.a).p());
        s.a(m.a(a.a), m.A(a.a));
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Updated SDK Config Version:").append(m.A(a.a).a()).append(" flushInterval: ").append(m.A(a.a).b()).append(" flushEventCount: ").append(m.A(a.a).d()).append(" events:").append(m.A(a.a).e()).append(" flushWithDelayTime: ").append(m.A(a.a).g()).append(" delayEvents: ").append(m.A(a.a).i()).append(" bucketConfig: ").append(m.A(a.a).p()).append(" eventMapping: ").append(m.A(a.a).j()).append(" include: ").append(m.A(a.a).l()).append(" exclude: ").append(m.A(a.a).k()).append(" eventPropertiesMaxCount: ").append(m.A(a.a).m()).append(" eventPropertiesIncludeMap: ").append(m.A(a.a).n()).append(" eventPropertiesExcludeMap: ").append(m.A(a.a).o()).toString());
        }
        jsonobject = s1.optJSONObject("iam");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_1162;
        }
        n.a(jsonobject);
        s1 = s1.optJSONObject("location");
        flag1 = flag;
        if (s1 == null) goto _L10; else goto _L9
_L9:
        ahj.a(a.a, s1, m.a(a.a));
        flag1 = flag;
        if (android.os.VERSION.SDK_INT < 18) goto _L10; else goto _L11
_L11:
        ahh.a(a.a, s1, m.a(a.a));
        flag1 = flag;
          goto _L10
        s1;
        flag1 = flag;
        if (!m.a) goto _L10; else goto _L12
_L12:
        Log.w("Kahuna", "Caught error when attepmting to to parse server location services command. If you are NOT using location services please ignore this error: ");
        Log.w("Kahuna", s1);
        flag1 = flag;
          goto _L10
        exception;
        s1;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        s1;
        JVM INSTR monitorexit ;
        throw exception1;
        s1;
        flag = false;
          goto _L13
    }

    public void a(Throwable throwable, String s1)
    {
        super.a(throwable, s1);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Failed to send request: ").append(s1).toString(), throwable);
        }
        synchronized (m.r(a.a))
        {
            m.b(a.a, false);
        }
        m.G(a.a);
        return;
        s1;
        throwable;
        JVM INSTR monitorexit ;
        throw s1;
    }

    h(h h)
    {
        a = h;
        super();
    }
}
