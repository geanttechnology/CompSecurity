// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.utility.bv;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            e, n, g, ViewEngine, 
//            a

class f
{

    AtomicLong a;
    private ViewEngine b;
    private final Object c;
    private ConcurrentHashMap d;
    private ConcurrentHashMap e;
    private final n f;
    private bv g;
    private bv h;

    private f(ViewEngine viewengine)
    {
        a = new AtomicLong(0L);
        c = new Object();
        f = new e();
        b = viewengine;
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        g = new bv();
        h = new bv();
    }

    f(ViewEngine viewengine, ViewEngine._cls1 _pcls1)
    {
        this(viewengine);
    }

    static ConcurrentHashMap a(f f1)
    {
        return f1.d;
    }

    static void a(f f1, String s)
    {
        f1.a(s);
    }

    private void a(String s)
    {
    }

    private long b()
    {
        return a.addAndGet(1L) % 65535L;
    }

    static Object b(f f1)
    {
        return f1.c;
    }

    static n c(f f1)
    {
        return f1.f;
    }

    static ViewEngine d(f f1)
    {
        return f1.b;
    }

    static ConcurrentHashMap e(f f1)
    {
        return f1.e;
    }

    public n a(Class class1, HashMap hashmap, HashMap hashmap1, a a1, Object obj)
    {
        if (hashmap == null)
        {
            throw new IllegalArgumentException("Invalid paramObject: paramObject should not be null");
        }
        if (hashmap.get("imageID") == null)
        {
            throw new IllegalArgumentException("Invalid paramObject: paramObject.imageID should not be null");
        }
        long l = b();
        long l1 = ((Long)hashmap.get("imageID")).longValue();
        ViewEngine.Argd argd;
        if (hashmap.get("argd") != null)
        {
            argd = (ViewEngine.Argd)hashmap.get("argd");
        } else
        {
            argd = new ViewEngine.Argd(null);
            hashmap.put("argd", argd);
        }
        argd.put("taskID", Long.valueOf(l));
        argd.put("name", hashmap1.get("name"));
        if (hashmap1.containsKey("Role"))
        {
            hashmap1 = (ViewEngine.TaskRole)hashmap1.get("Role");
        } else
        {
            hashmap1 = ViewEngine.TaskRole.a;
        }
        try
        {
            class1 = (n)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            throw new RuntimeException("[TaskMgr][pushTask] Cannot create task object!", class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            throw new RuntimeException("[TaskMgr][pushTask] Cannot create task object!", class1);
        }
        class1.f = this;
        class1.a = l;
        class1.b = l1;
        class1.d = hashmap;
        class1.e = a1;
        class1.c = hashmap1;
        n.a(class1, obj);
        hashmap = ((HashMap) (c));
        hashmap;
        JVM INSTR monitorenter ;
        hashmap1 = new g(this, class1, null);
        if (((n) (class1)).c != ViewEngine.TaskRole.b)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        g.a(hashmap1);
_L2:
        return class1;
        h.a(hashmap1);
        if (true) goto _L2; else goto _L1
_L1:
        class1;
        hashmap;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public void a()
    {
        g.a();
        h.a();
    }

    public void a(long l)
    {
        if (d.containsKey(Long.valueOf(l)))
        {
            throw new ViewEngine.TaskMgrException((new StringBuilder()).append("onCancelTask taskID: ").append(l).append(", cancelType: ").append(ViewEngine.TaskCancelType.d).toString());
        } else
        {
            return;
        }
    }
}
