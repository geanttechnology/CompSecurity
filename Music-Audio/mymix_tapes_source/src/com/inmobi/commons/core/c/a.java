// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.c;

import android.content.ContentValues;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.c;
import com.inmobi.commons.core.utilities.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.c:
//            c, b, e, d

public class com.inmobi.commons.core.c.a
    implements com.inmobi.commons.core.configs.b.b
{
    private final class a extends Handler
    {

        final com.inmobi.commons.core.c.a a;
        private String b;
        private String c;
        private com.inmobi.commons.core.c.d d;
        private int e;
        private int f;
        private int g;
        private AtomicBoolean h;
        private int i;
        private int j;
        private boolean k;
        private List l;

        private String a(List list)
        {
            JSONArray jsonarray = new JSONArray();
            int i1 = 0;
            do
            {
                try
                {
                    if (i1 >= list.size())
                    {
                        break;
                    }
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("componentType", ((e)list.get(i1)).a());
                    jsonobject.put("eventType", ((e)list.get(i1)).b());
                    if (!((e)list.get(i1)).c().trim().isEmpty())
                    {
                        jsonobject.put("payload", ((e)list.get(i1)).c());
                    }
                    jsonobject.put("ts", ((e)list.get(i1)).d());
                    jsonarray.put(jsonobject);
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    return "";
                }
                i1++;
            } while (true);
            list = jsonarray.toString();
            return list;
        }

        private void a()
        {
            e = com.inmobi.commons.core.c.a.f().i();
            b = com.inmobi.commons.core.c.a.f().f();
            f = com.inmobi.commons.core.c.a.f().k() * 1000;
            g = com.inmobi.commons.core.c.a.f().g() * 1000;
            j = com.inmobi.commons.core.c.a.f().j();
        }

        private String b(List list)
        {
            JSONArray jsonarray = new JSONArray();
            int i1 = 0;
            do
            {
                try
                {
                    if (i1 >= list.size())
                    {
                        break;
                    }
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("componentType", ((ContentValues)list.get(i1)).getAsString("componentType"));
                    jsonobject.put("eventType", ((ContentValues)list.get(i1)).getAsString("eventType"));
                    jsonobject.put("payload", ((ContentValues)list.get(i1)).getAsString("payload"));
                    jsonarray.put(jsonobject);
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    return "";
                }
                i1++;
            } while (true);
            list = jsonarray.toString();
            return list;
        }

        private void b()
        {
            List list;
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), "Begin reporting");
            d = new com.inmobi.commons.core.c.d();
            list = d.a();
            if (list.isEmpty()) goto _L2; else goto _L1
_L1:
            k = true;
            c = b(list);
_L4:
            sendEmptyMessage(2);
            return;
_L2:
            if (c == null || c.equals(""))
            {
                k = false;
                if (l.isEmpty())
                {
                    l = d.a(e);
                }
                if (l.isEmpty())
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), "No events to report");
                    sendEmptyMessage(3);
                    return;
                }
                c = a(l);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void c()
        {
            Object obj = new com.inmobi.commons.core.utilities.uid.d(com.inmobi.commons.core.c.a.f().o().a());
            obj = new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.POST, b, true, ((com.inmobi.commons.core.utilities.uid.d) (obj)));
            HashMap hashmap = new HashMap();
            if (k)
            {
                hashmap.put("metric", c);
            } else
            {
                hashmap.put("telemetry", c);
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Telemetry Payload: ").append(c).toString());
            ((NetworkRequest) (obj)).c(hashmap);
            obj = (new com.inmobi.commons.core.network.d(((NetworkRequest) (obj)))).a();
            if (((com.inmobi.commons.core.network.c) (obj)).a())
            {
                i = i + 1;
                if (i > j)
                {
                    i = 0;
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Unable to send telemetry events to server: ").append(((com.inmobi.commons.core.network.c) (obj)).b()).append(" . And retry count exhausted. Will Discard Events").toString());
                    l.clear();
                    c = null;
                    sendEmptyMessage(3);
                    return;
                } else
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Unable to send telemetry events to server: ").append(((com.inmobi.commons.core.network.c) (obj)).b()).append(". Will retry").toString());
                    h.set(false);
                    sendEmptyMessageDelayed(1, g);
                    return;
                }
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Successfully sent events to server: ").append(((com.inmobi.commons.core.network.c) (obj)).b()).toString());
            c = null;
            l.clear();
            if (d.c() > e)
            {
                h.set(false);
                sendEmptyMessage(1);
                return;
            } else
            {
                sendEmptyMessage(3);
                return;
            }
        }

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 4: default 36
        //                       1 37
        //                       2 108
        //                       3 113
        //                       4 133;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L2:
            removeMessages(1);
            if (h.compareAndSet(false, true))
            {
                if (!com.inmobi.commons.a.a.e() || !com.inmobi.commons.core.utilities.d.a())
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), "App not in foreground or No Network available ");
                    h.set(false);
                    if (!com.inmobi.commons.a.a.e())
                    {
                        sendEmptyMessage(4);
                        return;
                    }
                } else
                {
                    a();
                    b();
                    return;
                }
            }
              goto _L1
_L3:
            c();
            return;
_L4:
            h.set(false);
            sendEmptyMessageDelayed(1, f);
            return;
_L5:
            com.inmobi.commons.core.c.a.a(com.inmobi.commons.core.c.a.a());
            return;
        }

        public a(Looper looper)
        {
            a = com.inmobi.commons.core.c.a.this;
            super(looper);
            h = new AtomicBoolean(false);
            i = 0;
            l = new ArrayList();
            c = null;
            a();
        }
    }


    private static final String a = com/inmobi/commons/core/c/a.getSimpleName();
    private static final Object b = new Object();
    private static volatile com.inmobi.commons.core.c.a c;
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static final AtomicBoolean e = new AtomicBoolean(false);
    private static Map f;
    private static com.inmobi.commons.core.c.c h;
    private static final Random o = new Random(System.currentTimeMillis());
    private List g;
    private HandlerThread i;
    private a j;
    private Map k;
    private final Object l = new Object();
    private final Object m = new Object();
    private final Object n = new Object();

    private com.inmobi.commons.core.c.a()
    {
        g = new ArrayList();
        f = new HashMap();
        k = new HashMap();
        h = new com.inmobi.commons.core.c.c();
        e.set(com.inmobi.commons.core.utilities.d.a());
        com.inmobi.commons.core.configs.b.a().a(h, this);
        a(h.a(), h.m());
        com.inmobi.commons.core.utilities.c.a a1 = new com.inmobi.commons.core.utilities.c.a() {

            final com.inmobi.commons.core.c.a a;

            public void a(boolean flag)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.c.a.d(), (new StringBuilder()).append("Network status changed ").append(flag).toString());
                if (flag && !com.inmobi.commons.core.c.a.e().get() && com.inmobi.commons.a.a.e())
                {
                    com.inmobi.commons.core.c.a.a(com.inmobi.commons.core.c.a.a(), 60);
                }
                com.inmobi.commons.core.c.a.e().set(flag);
            }

            
            {
                a = com.inmobi.commons.core.c.a.this;
                super();
            }
        };
        com.inmobi.commons.core.utilities.c.a().a(a1);
    }

    public static com.inmobi.commons.core.c.a a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        com.inmobi.commons.core.c.a a1 = c;
        obj = a1;
        if (a1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new com.inmobi.commons.core.c.a();
        c = ((com.inmobi.commons.core.c.a) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((com.inmobi.commons.core.c.a) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((com.inmobi.commons.core.c.a) (obj));
    }

    private String a(String s, String s1)
    {
        return (new StringBuilder()).append(s).append("@$#$@").append(s1).toString();
    }

    private void a(int i1)
    {
        if (!com.inmobi.commons.a.a.e() || !com.inmobi.commons.core.utilities.d.a())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "App not in foreground or No Network available");
            return;
        }
        Object obj = m;
        obj;
        JVM INSTR monitorenter ;
        if (d.compareAndSet(false, true))
        {
            i = new HandlerThread("telemetry");
            i.start();
            j = new a(i.getLooper());
        }
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Begin reporting after ").append(i1).append(" seconds").toString());
        j.sendEmptyMessageDelayed(1, i1 * 1000);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        j.sendEmptyMessage(1);
          goto _L1
    }

    static void a(com.inmobi.commons.core.c.a a1)
    {
        a1.i();
    }

    static void a(com.inmobi.commons.core.c.a a1, int i1)
    {
        a1.a(i1);
    }

    private void a(String s, com.inmobi.commons.core.c.b b1)
    {
        if (s == null || s.trim().equals(""))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Component type provided while registering is null or empty!");
            return;
        }
        if (b1 != null)
        {
            f.put(s, b1);
            return;
        } else
        {
            f.put(s, new com.inmobi.commons.core.c.b(s, null, h.m()));
            return;
        }
    }

    private String[] b(String s)
    {
        return s.split("\\@\\$\\#\\$\\@");
    }

    private void c(e e1)
    {
        if (g(e1).c())
        {
            b(e1);
        }
    }

    static String d()
    {
        return a;
    }

    private void d(e e1)
    {
        int i1 = g(e1).b();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Event Sampling factor: ").append(i1).toString());
        if (i1 <= 0)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Sampling factor is <=0 for this event!");
            return;
        }
        if (o.nextInt(i1) != 0)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Event ").append(e1.b()).append(" is not lucky enough to be processed further").toString());
            return;
        } else
        {
            e(e1);
            return;
        }
    }

    static AtomicBoolean e()
    {
        return e;
    }

    private void e(e e1)
    {
        if (!(e1 instanceof com.inmobi.commons.core.a.b)) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Got a crash event, will save it right away!");
        (new com.inmobi.commons.core.c.d()).a(e1);
_L4:
        return;
_L2:
        int i1;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Caching event ").append(e1.b()).append(" in memory").toString());
        i1 = h.h();
        synchronized (n)
        {
            g.add(e1);
        }
        if (g.size() < i1) goto _L4; else goto _L3
_L3:
        int j1;
        g();
        i1 = (new com.inmobi.commons.core.c.d()).c();
        j1 = h.l();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Current event count: ").append(i1).append(" Upper cap: ").append(j1).toString());
        if (i1 <= (j1 * 3) / 4) goto _L4; else goto _L5
_L5:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Telemetry is more than 75% full. Begin reporting ");
        h();
        return;
        e1;
        obj;
        JVM INSTR monitorexit ;
        throw e1;
    }

    private com.inmobi.commons.core.c.b f(e e1)
    {
        return a().a(e1.a());
    }

    static com.inmobi.commons.core.c.c f()
    {
        return h;
    }

    private b.a g(e e1)
    {
        return f(e1).a(e1.b());
    }

    private void g()
    {
        Object obj = n;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        int i1;
        int j1;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Adding events ").append(g.toString()).append("to persistence").toString());
        obj1 = new com.inmobi.commons.core.c.d();
        i1 = h.l();
        j1 = ((com.inmobi.commons.core.c.d) (obj1)).c();
        if ((g.size() + j1) - i1 > 0) goto _L2; else goto _L1
_L1:
        ((com.inmobi.commons.core.c.d) (obj1)).a(g);
_L3:
        g.clear();
        return;
_L2:
        i1 -= j1;
        if (i1 > 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Persistence is full, won't add events");
          goto _L3
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        ((com.inmobi.commons.core.c.d) (obj1)).a(g.subList(0, i1));
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Persistence will overflow, will add ").append(i1).append(" events to persistence").toString());
          goto _L3
    }

    private void h()
    {
        a(0);
    }

    private void i()
    {
        synchronized (m)
        {
            if (i != null)
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Deiniting telemetry");
                i.getLooper().quit();
                i.interrupt();
                i = null;
                j = null;
                d.set(false);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void j()
    {
        Object obj = l;
        obj;
        JVM INSTR monitorenter ;
        com.inmobi.commons.core.c.d d1;
        Iterator iterator;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Saving metric to persistence");
        d1 = new com.inmobi.commons.core.c.d();
        d1.b();
        iterator = k.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        String as[];
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        entry = (java.util.Map.Entry)iterator.next();
        as = b((String)entry.getKey());
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("count", entry.getValue());
        d1.a(as[0], as[1], jsonobject.toString());
          goto _L1
        JSONException jsonexception;
        jsonexception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error forming metric payload");
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        k.clear();
        obj;
        JVM INSTR monitorexit ;
    }

    com.inmobi.commons.core.c.b a(String s)
    {
        if (s == null || s.trim().equals(""))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Request null or empty Component type!");
            return null;
        } else
        {
            return (com.inmobi.commons.core.c.b)f.get(s);
        }
    }

    public void a(e e1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Event submitted to telemetry: ").append(e1.b()).append(" - ").append(e1.a()).toString());
        com.inmobi.commons.core.c.b b1 = f(e1);
        if (b1 == null || !b1.b() || !h.e())
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Telemetry service is not enabled or registered for component: ").append(e1.a()).toString());
            return;
        } else
        {
            c(e1);
            d(e1);
            return;
        }
    }

    public void a(com.inmobi.commons.core.configs.a a1)
    {
        h = (com.inmobi.commons.core.c.c)a1;
    }

    public void a(String s, String s1, Map map)
    {
        s = new e(s, s1);
        if (map == null || map.isEmpty()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); jsonobject.put(entry.getKey().toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

          goto _L3
_L2:
        a().a(((e) (s)));
        return;
_L3:
        try
        {
            s.a(jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error forming JSON payload for ").append(s1).append(" Error: ").append(map).toString());
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public final void a(String s, JSONObject jsonobject)
    {
        a(s, new com.inmobi.commons.core.c.b(s, jsonobject, h.m()));
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "start called");
        a().h();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void b(e e1)
    {
        String s;
        s = e1.a();
        e1 = e1.b();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Metric collected: ").append(e1).append(" - ").append(s).toString());
        s = a(s, e1);
        e1 = ((e) (l));
        e1;
        JVM INSTR monitorenter ;
        if (!k.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_113;
        }
        int i1 = ((Integer)k.get(s)).intValue();
        k.put(s, Integer.valueOf(i1 + 1));
_L2:
        return;
        k.put(s, Integer.valueOf(1));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        e1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "stop called");
        a().j();
        a().g();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
