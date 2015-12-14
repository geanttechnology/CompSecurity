// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.configs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.uid.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.commons.core.configs:
//            g, c, a, d, 
//            e, ConfigError

public class com.inmobi.commons.core.configs.b
{
    static final class a extends Handler
        implements d.a
    {

        private List a;
        private Map b;
        private Map c;
        private ExecutorService d;

        private void a(String s, Map map)
        {
            int j = com.inmobi.commons.core.configs.b.f().f();
            int k = com.inmobi.commons.core.configs.b.f().e();
            s = new com.inmobi.commons.core.configs.d(this, new e(map, new d(com.inmobi.commons.core.configs.b.f().o().a()), s, k, j));
            d.execute(s);
        }

        private void a(List list)
        {
            for (int j = 0; j < list.size(); j++)
            {
                com.inmobi.commons.core.configs.a a1 = (com.inmobi.commons.core.configs.a)list.get(j);
                HashMap hashmap1 = (HashMap)b.get(com.inmobi.commons.core.configs.b.f().b(a1.a()));
                HashMap hashmap = hashmap1;
                if (hashmap1 == null)
                {
                    hashmap = new HashMap();
                }
                hashmap.put(a1.a(), a1);
                b.put(com.inmobi.commons.core.configs.b.f().b(a1.a()), hashmap);
            }

        }

        private boolean a(String s)
        {
            boolean flag;
            boolean flag1;
            if (b.get(com.inmobi.commons.core.configs.b.f().b(s)) != null && ((Map)b.get(com.inmobi.commons.core.configs.b.f().b(s))).containsKey(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (c != null)
            {
                flag1 = flag;
                if (c.containsKey(s))
                {
                    flag1 = true;
                }
            }
            return flag1;
        }

        public void a()
        {
            if (d != null && !d.isShutdown())
            {
                c = null;
                b.clear();
                removeMessages(3);
                d.shutdownNow();
            }
        }

        public void a(ConfigNetworkResponse.ConfigResponse configresponse)
        {
            com.inmobi.commons.core.configs.c c1 = new com.inmobi.commons.core.configs.c();
            if (!configresponse.d())
            {
                if (configresponse.b() == ConfigNetworkResponse.ConfigResponse.ConfigResponseStatus.NOT_MODIFIED)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Config not modified status from server:").append(configresponse.a().a()).toString());
                    c1.a(configresponse.a().a(), System.currentTimeMillis());
                    return;
                }
                c1.a(configresponse.a());
                try
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Config cached successfully:").append(configresponse.a().a()).toString());
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Config cached successfully:").append(configresponse.a().b().toString()).toString());
                    com.inmobi.commons.core.configs.b.a(configresponse.a());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ConfigNetworkResponse.ConfigResponse configresponse)
                {
                    configresponse.printStackTrace();
                }
                return;
            } else
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Config fetching failed:").append(configresponse.a().a()).append(", Error code:").append(configresponse.c().a()).toString());
                return;
            }
        }

        public void b()
        {
            sendEmptyMessage(4);
        }

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 5: default 40
        //                       1 41
        //                       2 165
        //                       3 183
        //                       4 234
        //                       5 339;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            break; /* Loop/switch isn't completed */
_L6:
            break MISSING_BLOCK_LABEL_339;
_L7:
            return;
_L2:
            message = (com.inmobi.commons.core.configs.a)message.obj;
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Fetch requested for config:").append(message.a()).append(". IsAlreadyScheduled:").append(a(message.a())).toString());
            if (!a(message.a()))
            {
                a.add(message);
                if (!hasMessages(2))
                {
                    sendEmptyMessage(2);
                    return;
                }
            } else
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), (new StringBuilder()).append("Config fetching already in progress:").append(message.a()).toString());
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            sendEmptyMessageDelayed(3, com.inmobi.commons.core.configs.b.f().g() * 1000);
            return;
_L4:
            a(a);
            a.clear();
            if (d == null || d.isShutdown())
            {
                d = Executors.newFixedThreadPool(1);
                sendEmptyMessage(4);
                return;
            }
            if (true) goto _L7; else goto _L5
_L5:
            if (!b.isEmpty())
            {
                message = (java.util.Map.Entry)b.entrySet().iterator().next();
            } else
            {
                message = null;
            }
            if (message != null)
            {
                c = (Map)message.getValue();
                b.remove(message.getKey());
                a((String)message.getKey(), c);
                return;
            } else
            {
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.commons.core.configs.b.e(), "Config fetching stopping as no more configs left to fetch.");
                sendEmptyMessage(5);
                return;
            }
            a();
            return;
        }

        a(Looper looper)
        {
            super(looper);
            a = new ArrayList();
            b = new HashMap();
            c = new HashMap();
        }
    }

    public static interface b
    {

        public abstract void a(com.inmobi.commons.core.configs.a a1);
    }

    static class c
        implements b
    {

        public void a(com.inmobi.commons.core.configs.a a1)
        {
            com.inmobi.commons.core.configs.b.a((g)a1);
        }

        c()
        {
        }
    }


    private static final String a = com/inmobi/commons/core/configs/b.getSimpleName();
    private static final Object b = new Object();
    private static Map c;
    private static g d;
    private static volatile com.inmobi.commons.core.configs.b e;
    private static c f;
    private HandlerThread g;
    private a h;
    private boolean i;

    private com.inmobi.commons.core.configs.b()
    {
        i = false;
        c = new HashMap();
        g = new HandlerThread("ConfigBootstrapHandler");
        g.start();
        h = new a(g.getLooper());
        d = new g();
    }

    public static com.inmobi.commons.core.configs.b a()
    {
        Object obj;
        obj = e;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        com.inmobi.commons.core.configs.b b1 = e;
        obj = b1;
        if (b1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        obj = new com.inmobi.commons.core.configs.b();
        e = ((com.inmobi.commons.core.configs.b) (obj));
        obj1;
        JVM INSTR monitorexit ;
        return ((com.inmobi.commons.core.configs.b) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((com.inmobi.commons.core.configs.b) (obj));
    }

    static g a(g g1)
    {
        d = g1;
        return g1;
    }

    static void a(com.inmobi.commons.core.configs.a a1)
    {
        b(a1);
    }

    private boolean a(long l, long l1)
    {
        return System.currentTimeMillis() - l > 1000L * l1;
    }

    public static boolean a(String s, String s1)
    {
        int j;
        boolean flag;
        flag = true;
        s = s.split("\\.");
        s1 = s1.split("\\.");
        j = 0;
_L3:
        if (j >= s.length)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        if (Integer.valueOf(s[j]).intValue() < 0)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_160;
_L1:
        int k;
        for (; j >= s1.length; j = 0)
        {
            break MISSING_BLOCK_LABEL_66;
        }

        k = Integer.valueOf(s1[j]).intValue();
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        j++;
          goto _L1
        if (s.length < s1.length)
        {
            j = s.length;
        } else
        {
            j = s1.length;
        }
        for (k = 0; k < j; k++)
        {
            if (!s[k].equals(s1[k]))
            {
                if (Integer.valueOf(s[k]).intValue() < Integer.valueOf(s1[k]).intValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
        }

        if (s.length >= s1.length)
        {
            flag = false;
        }
        return flag;
        s;
        return false;
        j++;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private static void b(com.inmobi.commons.core.configs.a a1)
    {
        ArrayList arraylist = (ArrayList)c.get(a1);
        if (arraylist != null)
        {
            for (int j = 0; j < arraylist.size(); j++)
            {
                if (arraylist.get(j) != null && ((WeakReference)arraylist.get(j)).get() != null)
                {
                    ((b)((WeakReference)arraylist.get(j)).get()).a(a1);
                }
            }

        }
    }

    private void b(com.inmobi.commons.core.configs.a a1, b b1)
    {
        ArrayList arraylist = (ArrayList)c.get(a1);
        if (arraylist == null)
        {
            arraylist = new ArrayList();
        }
        if (b1 == null)
        {
            b1 = null;
        } else
        {
            b1 = new WeakReference(b1);
        }
        arraylist.add(b1);
        c.put(a1, arraylist);
    }

    private final void c(com.inmobi.commons.core.configs.a a1)
    {
        this;
        JVM INSTR monitorenter ;
        com.inmobi.commons.core.configs.c c1 = new com.inmobi.commons.core.configs.c();
        if (c1.a(d.a())) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("RootConfig not available. Fetching root and returning defaults for config type:").append(a1.a()).toString());
        d(d.d());
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        c1.b(d);
        if (a(c1.b(d.a()), d.a(d.a())))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "RootConfig expired. Fetching root.");
            d(d.d());
        }
        if (c1.a(a1.a()))
        {
            break MISSING_BLOCK_LABEL_182;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Requested config not present. Returning default and fetching. Config type:").append(a1.a()).toString());
        d(a1.d());
          goto _L3
        a1;
        throw a1;
label0:
        {
            c1.b(a1);
            if (!a(c1.b(a1.a()), d.a(a1.a())))
            {
                break label0;
            }
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Requested config expired. Returning currently cached and fetching. Config type:").append(a1.a()).toString());
            d(a1.d());
        }
          goto _L3
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Serving config from cache. Config:").append(a1.a()).toString());
          goto _L3
    }

    private void d(com.inmobi.commons.core.configs.a a1)
    {
        Message message = h.obtainMessage();
        message.what = 1;
        message.obj = a1;
        h.sendMessage(message);
    }

    static String e()
    {
        return a;
    }

    static g f()
    {
        return d;
    }

    private void g()
    {
        com.inmobi.commons.core.configs.a a1;
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext(); b(a1))
        {
            a1 = (com.inmobi.commons.core.configs.a)((java.util.Map.Entry)iterator.next()).getKey();
            c(a1);
        }

    }

    public final void a(com.inmobi.commons.core.configs.a a1, b b1)
    {
        this;
        JVM INSTR monitorenter ;
        if (i) goto _L2; else goto _L1
_L1:
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Config component not yet started, config can't be fetched. Requested type:").append(a1.a()).toString());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b(a1, b1);
        c(a1);
        if (true) goto _L4; else goto _L3
_L3:
        a1;
        throw a1;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!i)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Starting config component.");
            i = true;
            com.inmobi.commons.core.c.a.a().a("root", d.i());
            if (f == null)
            {
                f = new c();
                a(d, f);
            }
            g();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        if (i)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Stopping config component.");
            i = false;
            h.sendEmptyMessage(5);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void d()
    {
        String s = d.h().a();
        String s1 = d.h().b();
        if (s.trim().length() != 0 && a(com.inmobi.commons.a.b.b(), s.trim()))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.DEBUG, a, (new StringBuilder()).append("A newer version (version ").append(s).append(") of the InMobi SDK is available! ").append("You are currently on an older version (Version ").append(com.inmobi.commons.a.b.b()).append("). Please download the latest InMobi SDK from ").append(s1).toString());
        }
    }

}
