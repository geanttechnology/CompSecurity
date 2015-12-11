// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.support.v7.agt;
import android.support.v7.agv;
import android.support.v7.agx;
import android.support.v7.ahc;
import android.support.v7.ahh;
import android.support.v7.ahj;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            m, v, s, c, 
//            d, p, r, n

private class <init> extends TimerTask
{

    final m a;

    public void run()
    {
        synchronized (m.r(a))
        {
            m.b(a, true);
        }
        obj1 = new agx();
        ((agx) (obj1)).a("key", m.h(a));
        ((agx) (obj1)).a("dev_id", m.i(a));
        ((agx) (obj1)).a("app_name", m.s(a));
        ((agx) (obj1)).a("app_ver", m.t(a));
        ((agx) (obj1)).a("os_version", m.u(a));
        ((agx) (obj1)).a("os_name", m.v(a));
        ((agx) (obj1)).a("dev_name", m.w(a));
        ((agx) (obj1)).a("client_time", (new StringBuilder()).append("").append(System.currentTimeMillis() / 1000L).toString());
        ((agx) (obj1)).a("sdk_version", "2.0.3");
        if (!v.a(m.x(a)))
        {
            ((agx) (obj1)).a("push_token", m.x(a));
        }
        if (!v.a(m.y(a)) && !v.a(m.z(a)))
        {
            ((agx) (obj1)).a("sdk_wrapper", m.y(a));
            ((agx) (obj1)).a("sdk_wrapper_version", m.z(a));
        }
        Object obj2;
        Object obj3;
        int i;
        int j;
        if (m.j(a))
        {
            obj = "s";
        } else
        {
            obj = "p";
        }
        ((agx) (obj1)).a("env", ((String) (obj)));
        ((agx) (obj1)).a("c", (new StringBuilder()).append("").append(m.A(a).a()).toString());
        obj2 = new JSONArray();
        if (m.u())
        {
            ((JSONArray) (obj2)).put("iam");
        }
        if (!m.v() || !ahj.a()) goto _L2; else goto _L1
_L1:
        ((JSONArray) (obj2)).put("rm");
        obj3 = ahj.b(a);
        if (((Set) (obj3)).size() <= 0) goto _L2; else goto _L3
_L3:
        obj = new JSONArray();
        for (obj3 = ((Set) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj3)).next())) { }
          goto _L4
        obj;
_L16:
        if (v.a(((JSONArray) (obj2)))) goto _L6; else goto _L5
_L5:
        if (obj2 instanceof JSONArray) goto _L8; else goto _L7
_L7:
        obj = ((JSONArray) (obj2)).toString();
_L21:
        ((agx) (obj1)).a("fsupported", ((String) (obj)));
_L6:
        obj2 = new JSONArray();
        m.b(a, new ArrayList());
        obj = m.d(a);
        obj;
        JVM INSTR monitorenter ;
        if (m.B(a).get() <= 0)
        {
            m.B(a).set(m.e(a).size());
        }
        i = m.A(a).q();
        if (i < m.e(a).size())
        {
            break MISSING_BLOCK_LABEL_1547;
        }
          goto _L9
_L12:
        if (j >= i) goto _L11; else goto _L10
_L10:
        obj3 = (c)m.e(a).get(j);
        m.C(a).add(obj3);
        obj3 = ((c) (obj3)).l();
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        ((JSONArray) (obj2)).put(obj3);
        j++;
          goto _L12
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Send Events Task handler: ").append(obj).toString());
            ((Exception) (obj)).printStackTrace();
        }
        synchronized (m.n(a))
        {
            if (m.o(a) != null)
            {
                m.o(a).cancel();
                m.a(a, null);
            }
        }
_L29:
        return;
_L4:
        if (obj instanceof JSONArray) goto _L14; else goto _L13
_L13:
        obj = ((JSONArray) (obj)).toString();
_L19:
        ((agx) (obj1)).a("rm", ((String) (obj)));
_L2:
        if (android.os.d.VERSION.SDK_INT < 18 || !m.w() || !ahc.a() || !ahh.a(a)) goto _L16; else goto _L15
_L15:
        ((JSONArray) (obj2)).put("bm");
        obj3 = ahh.b(a);
        if (((Set) (obj3)).size() <= 0) goto _L16; else goto _L17
_L17:
        obj = new JSONArray();
        for (obj3 = ((Set) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((JSONArray) (obj)).put((String)((Iterator) (obj3)).next())) { }
          goto _L18
_L14:
        obj = JSONArrayInstrumentation.toString((JSONArray)obj);
          goto _L19
_L18:
        if (obj instanceof JSONArray)
        {
            break MISSING_BLOCK_LABEL_836;
        }
        obj = ((JSONArray) (obj)).toString();
_L20:
        ((agx) (obj1)).a("bm", ((String) (obj)));
          goto _L16
        obj = JSONArrayInstrumentation.toString((JSONArray)obj);
          goto _L20
_L8:
        obj = JSONArrayInstrumentation.toString((JSONArray)obj2);
          goto _L21
_L9:
        i = m.e(a).size();
        break MISSING_BLOCK_LABEL_1547;
_L11:
        obj;
        JVM INSTR monitorexit ;
        d.a();
        if (m.C(a).size() != 0)
        {
            break MISSING_BLOCK_LABEL_973;
        }
        synchronized (m.r(a))
        {
            m.b(a, false);
        }
        synchronized (m.n(a))
        {
            if (m.o(a) != null)
            {
                m.o(a).cancel();
                m.a(a, null);
            }
        }
        return;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        if (obj2 instanceof JSONArray) goto _L23; else goto _L22
_L22:
        obj = ((JSONArray) (obj2)).toString();
_L35:
        ((agx) (obj1)).a("events_cksum", v.a(((String) (obj)), "MD5", false));
        ((agx) (obj1)).a("events", ((String) (obj)));
        if (!v.a(m.D(a)))
        {
            ((agx) (obj1)).a("archive_corrupt_raw_data", m.D(a));
        }
        if (v.a(m.E(a))) goto _L25; else goto _L24
_L24:
        obj = m.E(a);
        if (obj instanceof JSONArray) goto _L27; else goto _L26
_L26:
        obj = ((JSONArray) (obj)).toString();
_L36:
        ((agx) (obj1)).a("archive_corrupt_event_names", ((String) (obj)));
_L25:
        obj = v.a(EntityUtils.toString(((agx) (obj1)).b(), "UTF-8"), "MD5", false);
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Top Level Checksum was: ").append(((String) (obj))).toString());
        }
        obj = new BasicHeader("top_level_checksum", ((String) (obj)));
        obj2 = m.J(a);
        obj3 = m.F(a);
        agv agv = new agv() {

            final m.b a;

            public void a(String s1)
            {
                int k = 0;
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
                obj4 = s1.optJSONArray("s");
                if (obj4 == null) goto _L2; else goto _L1
_L1:
                int l = ((JSONArray) (obj4)).length();
_L7:
                if (k >= l)
                {
                    break; /* Loop/switch isn't completed */
                }
                Object obj5 = ((JSONArray) (obj4)).optString(k);
                if (v.a(((String) (obj5)))) goto _L4; else goto _L3
_L3:
                if (!"a".equals(((String) (obj5)).trim())) goto _L6; else goto _L5
_L5:
                obj5 = m.q(a.a);
                c c1 = new c("k_server_request");
                c1.b(((Map) (obj5)));
                a.a.a(c1);
_L4:
                k++;
                if (true) goto _L7; else goto _L2
                s1;
                obj4;
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
                            m.o(a.a).cancel();
                            m.a(a.a, null);
                        }
                        if (m.B(a.a).get() > 0 || m.I(a.a))
                        {
                            m.a(a.a, new m.a(a.a, null));
                            m.o(a.a).schedule(new m.b(a.a, null), 2000L);
                        }
                    }
                    return;
                } else
                {
                    m.G(a.a);
                    return;
                }
_L6:
                if (!"c".equals(((String) (obj5)).trim())) goto _L4; else goto _L8
_L8:
                obj5 = r.e(m.a(a.a));
                c2 = new c("k_server_request");
                c2.a(((Map) (obj5)));
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
                if (android.os.Build.VERSION.SDK_INT < 18) goto _L10; else goto _L11
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
                exception1;
                s1;
                JVM INSTR monitorexit ;
                throw exception1;
                exception2;
                s1;
                JVM INSTR monitorexit ;
                throw exception2;
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

            
            {
                a = m.b.this;
                super();
            }
        };
        ((agt) (obj2)).a(null, ((String) (obj3)), new Header[] {
            obj
        }, ((agx) (obj1)), "application/x-www-form-urlencoded", agv);
        if (!m.a) goto _L29; else goto _L28
_L28:
        if (!p.b(m.a(a)))
        {
            break MISSING_BLOCK_LABEL_1515;
        }
        Log.d("Kahuna", "filtering some parameters");
        obj1 = ((agx) (obj1)).a();
        obj2 = new StringBuilder();
        obj3 = ((Map) (obj1)).keySet().iterator();
_L38:
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break MISSING_BLOCK_LABEL_1485;
            }
            obj = (String)((Iterator) (obj3)).next();
        } while ("key".equals(obj));
        if (((StringBuilder) (obj2)).length() > 0)
        {
            ((StringBuilder) (obj2)).append("&");
        }
        if (!"events".equals(obj))
        {
            break MISSING_BLOCK_LABEL_1444;
        }
        ((StringBuilder) (obj2)).append((new StringBuilder()).append(((String) (obj))).append("=[").toString());
        j = m.C(a).size();
        i = 0;
_L34:
        if (i >= j) goto _L31; else goto _L30
_L30:
        obj = ((c)m.C(a).get(i)).l();
        ((JSONObject) (obj)).remove("credentials");
        if (obj instanceof JSONObject) goto _L33; else goto _L32
_L32:
        obj = ((JSONObject) (obj)).toString();
_L37:
        ((StringBuilder) (obj2)).append(((String) (obj)));
        i++;
          goto _L34
_L23:
        obj = JSONArrayInstrumentation.toString((JSONArray)obj2);
          goto _L35
_L27:
        obj = JSONArrayInstrumentation.toString((JSONArray)obj);
          goto _L36
_L33:
        obj = JSONObjectInstrumentation.toString((JSONObject)obj);
          goto _L37
_L31:
        ((StringBuilder) (obj2)).append("]");
          goto _L38
        ((StringBuilder) (obj2)).append((new StringBuilder()).append(((String) (obj))).append("=").append((String)((Map) (obj1)).get(obj)).toString());
          goto _L38
        Log.d("Kahuna", (new StringBuilder()).append("Sending request: ").append(((StringBuilder) (obj2)).toString()).toString());
        return;
        Log.d("Kahuna", (new StringBuilder()).append("Sending request: ").append(obj1).toString());
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        j = 0;
          goto _L12
    }

    private agv(m m1)
    {
        a = m1;
        super();
    }

    (m m1,  )
    {
        this(m1);
    }
}
