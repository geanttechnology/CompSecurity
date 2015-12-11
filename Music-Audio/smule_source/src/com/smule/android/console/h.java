// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.os.Build;
import android.os.Handler;
import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.c.aa;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.smule.android.console:
//            p, s, g, d, 
//            o, b, n, c, 
//            a, q, l

public class h
    implements p, Runnable
{

    private Thread a;
    private Semaphore b;
    private s c;
    private com.smule.android.console.b d;

    public h(Handler handler)
    {
        c = new s(handler);
        b = new Semaphore(0, true);
        a = new Thread(this);
        a.start();
    }

    private void a()
    {
        boolean flag = true;
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        b.acquire();
        flag = false;
        continue; /* Loop/switch isn't completed */
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(d d1)
    {
        d1.a(com.smule.android.console.g.a);
        int i = d1.b(com.smule.android.console.g.b);
        c.a(i);
    }

    private void b(d d1)
    {
        boolean flag;
        com.smule.android.console.o.a(this);
        flag = true;
_L6:
        c c1;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        a("#:-)> ");
        a();
        b(d.c());
        c1 = d.b();
        n n1 = d.a();
        Object obj = d.d();
        if (n1 != null)
        {
            b(n1.a(((String []) (obj))));
        } else
        if (c1 == c.f)
        {
            b((new StringBuilder()).append("host: ").append(com.smule.android.network.core.b.c()).toString());
            obj = UserManager.n();
            b((new StringBuilder()).append("playerId: ").append(((UserManager) (obj)).c()).toString());
            b((new StringBuilder()).append("handle: ").append(((UserManager) (obj)).e()).toString());
            b((new StringBuilder()).append("guest: ").append(((UserManager) (obj)).h()).toString());
            b((new StringBuilder()).append("sessionId: ").append(com.smule.android.network.core.b.a().h()).toString());
            b((new StringBuilder()).append("deviceId: ").append(com.smule.android.network.core.b.d().c()).toString());
            b((new StringBuilder()).append("androidId: ").append(com.smule.android.network.core.b.d().d()).toString());
            b((new StringBuilder()).append("installDays: ").append(((UserManager) (obj)).j().longValue() / 1000L).toString());
            b((new StringBuilder()).append("model: ").append(Build.MODEL).toString());
        } else
        if (c1 == c.m)
        {
            if (obj != null && obj.length == 2)
            {
                obj = Long.valueOf(Long.parseLong(obj[1]));
                if (obj != null)
                {
                    UserManager.n().a(Long.valueOf(((Long) (obj)).longValue() * 1000L));
                } else
                {
                    com.smule.android.console.o.a(this, c1);
                }
            } else
            {
                com.smule.android.console.o.a(this, c1);
            }
        } else
        if (c1 != c.h)
        {
            if (c1 == c.i)
            {
                c.b();
            } else
            if (c1 == c.d)
            {
                obj = d1.b(0);
                if (obj != null && ((LinkedHashMap) (obj)).size() > 0)
                {
                    obj = ((LinkedHashMap) (obj)).entrySet().iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                        b((new StringBuilder()).append(entry.getKey()).append(": ").append((String)entry.getValue()).toString());
                    }
                }
            } else
            if (c1 == c.j)
            {
                if (obj == null || obj.length != 2)
                {
                    com.smule.android.console.o.a(this, c1);
                }
            } else
            if (c1 == c.k)
            {
                com.smule.android.network.core.b.a().i();
            } else
            if (c1 == c.l)
            {
                if (obj != null)
                {
                    if (obj.length == 1)
                    {
                        obj = com.smule.android.network.core.b.d().m().iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            d((String)((Iterator) (obj)).next());
                        }
                    } else
                    if (obj.length == 2)
                    {
                        d(obj[1]);
                    } else
                    if (obj.length == 3)
                    {
                        JsonNode jsonnode = com.smule.android.network.managers.a.a().b(obj[1], obj[2]);
                        if (jsonnode != null)
                        {
                            b((new StringBuilder()).append("<").append(obj[1]).append(", ").append(obj[2]).append("> = ").append(jsonnode.toString()).toString());
                        } else
                        {
                            b((new StringBuilder()).append("<").append(obj[1]).append(", ").append(obj[2]).append("> = null").toString());
                        }
                    } else
                    {
                        com.smule.android.console.o.a(this, c1);
                    }
                } else
                {
                    com.smule.android.console.o.a(this, c1);
                }
            } else
            if (c1 == c.e)
            {
                if (obj != null)
                {
                    if (obj.length == 1)
                    {
                        com.smule.android.console.o.b(this);
                    } else
                    {
                        com.smule.android.console.o.a(this, obj[1]);
                    }
                }
            } else
            if (c1 == c.c)
            {
                obj = d1.a(d.e());
                if (obj != null)
                {
                    a(com.smule.android.console.b.b(((String) (obj))));
                } else
                {
                    c(com.smule.android.console.a.a(com.smule.android.h.error_history_id_not_found));
                }
            } else
            if (c1 == c.n)
            {
                b("");
                b((new StringBuilder()).append(com.smule.android.console.a.a(com.smule.android.h.app_name)).append(" [").append(com.smule.android.console.a.b()).append("]").toString());
                b("");
                b(com.smule.android.console.a.c());
                b("");
            } else
            if (c1 == c.o)
            {
                c.a();
            } else
            if (c1 == c.p)
            {
                com.smule.android.console.q.a(this);
            } else
            if (c1 == c.q)
            {
                if (obj != null)
                {
                    if (obj.length == 1)
                    {
                        c.d();
                    } else
                    {
                        try
                        {
                            obj = (l)Enum.valueOf(com/smule/android/console/l, obj[1]);
                            c.a(((l) (obj)).a());
                            d1.a(com.smule.android.console.g.b, Integer.valueOf(((l) (obj)).a()));
                        }
                        catch (Exception exception)
                        {
                            c(com.smule.android.console.a.a(com.smule.android.h.error_unknown_fontsize));
                            com.smule.android.console.o.a(this, c1);
                        }
                    }
                }
            } else
            {
label0:
                {
                    if (c1 != c.r)
                    {
                        break label0;
                    }
                    flag = false;
                }
            }
        }
          goto _L1
        if (c1 != com.smule.android.console.c.b) goto _L3; else goto _L2
_L2:
        flag = false;
          goto _L1
_L3:
        if (c1 != com.smule.android.console.c.a || com.smule.android.console.a.b(d.c())) goto _L1; else goto _L4
_L4:
        c((new StringBuilder()).append(com.smule.android.console.a.a(com.smule.android.h.error_unknown_cmd)).append(d.c()).toString());
_L1:
        if (c1 != c.d && (c1 == null || !com.smule.android.console.b.a(c1)))
        {
            d1.b(d.c());
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (d.b() == c.r)
        {
            c.c();
        }
        d1.a();
        aa.a("CommandDispatcher", "***** CommandDispatcher ends ****");
        return;
    }

    private void d(String s1)
    {
        Map map = com.smule.android.network.managers.a.a().a(s1);
        if (map != null)
        {
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                String s2;
                if (entry.getValue() != null)
                {
                    s2 = ((JsonNode)entry.getValue()).toString();
                } else
                {
                    s2 = "null";
                }
                b((new StringBuilder()).append("<").append(s1).append(", ").append((String)entry.getKey()).append("> = ").append(s2).toString());
            }
        } else
        {
            b((new StringBuilder()).append("<").append(s1).append("> = null").toString());
        }
    }

    public void a(com.smule.android.console.b b1)
    {
        d = b1;
        b.release();
    }

    public void a(String s1)
    {
        c.a(s1);
    }

    public boolean a(int i)
    {
        a(new com.smule.android.console.b(i));
        return true;
    }

    public void b(String s1)
    {
        c.b(s1);
    }

    public void c(String s1)
    {
        c.c(s1);
    }

    public void run()
    {
        d d1 = new d();
        a(d1);
        b(d1);
    }
}
