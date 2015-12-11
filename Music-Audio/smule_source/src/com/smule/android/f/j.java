// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.smule.android.f:
//            k, h

public class j
{

    private static final String c = com/smule/android/f/j.getSimpleName();
    AtomicInteger a;
    final Object b = new Object();
    private final Map d = new HashMap();

    public j()
    {
        a = new AtomicInteger(0);
    }

    static void a(j j1)
    {
        j1.c();
    }

    private void a(String s, k k1)
    {
        synchronized (b)
        {
            d.put(s, k1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private k b()
    {
        Object obj1 = b;
        obj1;
        JVM INSTR monitorenter ;
        Iterator iterator = d.values().iterator();
        boolean flag;
        boolean flag1;
        boolean flag3;
        flag1 = false;
        flag3 = false;
        flag = false;
_L2:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (k)iterator.next();
        if (!k.a(((k) (obj))))
        {
            break MISSING_BLOCK_LABEL_63;
        }
        flag3 = true;
        if (true) goto _L2; else goto _L1
        if (!k.b(((k) (obj))))
        {
            flag = true;
        }
        if (((k) (obj)).f == null) goto _L4; else goto _L3
_L3:
        Iterator iterator1 = ((k) (obj)).f.iterator();
        boolean flag2;
        boolean flag4 = true;
        flag2 = flag1;
        flag1 = flag4;
_L9:
        if (!iterator1.hasNext()) goto _L6; else goto _L5
_L5:
        Object obj2;
        obj2 = (String)iterator1.next();
        obj2 = (k)d.get(obj2);
        if (obj2 == null)
        {
            flag2 = true;
        }
        if (obj2 == null) goto _L8; else goto _L7
_L7:
        if (k.b(((k) (obj2)))) goto _L9; else goto _L8
_L10:
        obj1;
        JVM INSTR monitorexit ;
        if (obj == null && flag2 && !flag3 && !flag)
        {
            Log.e(c, "Problem choosing next operation to execute. Is there a dependency cycle?");
        }
        return ((k) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        flag5 = true;
        continue; /* Loop/switch isn't completed */
_L1:
        flag2 = flag;
        obj = null;
        flag = flag1;
          goto _L10
_L8:
        flag1 = false;
          goto _L9
_L6:
        flag5 = flag1;
        flag1 = flag2;
        if (flag5) goto _L11; else goto _L2
_L11:
        boolean flag5;
        if (k.b(((k) (obj))) && !a(((k) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = flag;
        flag = flag1;
          goto _L10
    }

    private void c()
    {
        do
        {
            k k1 = b();
            if (k1 == null)
            {
                if (a.getAndDecrement() > 1)
                {
                    a.set(1);
                } else
                {
                    return;
                }
            } else
            {
                k.b(k1, true);
                k.a(k1, false);
                k1.a(this);
            }
        } while (true);
    }

    public j a(String s, Collection collection, k k1)
    {
        k1.e = s;
        k1.f = collection;
        k1.g = null;
        a(s, k1);
        return this;
    }

    public j a(String s, Collection collection, Runnable runnable)
    {
        k k1 = new k();
        k1.e = s;
        k1.f = collection;
        k1.g = runnable;
        a(s, k1);
        return this;
    }

    public j a(String s, boolean flag, String s1)
    {
        s1 = new k(flag, s1) {

            final boolean a;
            final String b;
            final j c;

            public void a(j j1)
            {
                j1 = new Observer(this, j1) {

                    final j a;
                    final _cls1 b;

                    public void update(Observable observable, Object obj)
                    {
                        if (b.a)
                        {
                            h.a().b(b.b, this);
                        }
                        a.b(b.h);
                    }

            
            {
                b = _pcls1;
                a = j1;
                super();
            }
                };
                h.a().a(b, j1);
            }

            
            {
                c = j.this;
                a = flag;
                b = s;
                super();
            }
        };
        s1.e = s;
        s1.f = null;
        s1.g = null;
        a(s, ((k) (s1)));
        return this;
    }

    public k a(String s)
    {
        synchronized (b)
        {
            s = (k)d.remove(s);
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void a()
    {
        if (a.getAndIncrement() > 0)
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final j a;

                public void run()
                {
                    j.a(a);
                }

            
            {
                a = j.this;
                super();
            }
            })).start();
            return;
        }
    }

    public boolean a(k k1)
    {
label0:
        {
            if (k1.f == null)
            {
                break label0;
            }
            Iterator iterator = k1.f.iterator();
            Object obj;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (String)iterator.next();
                obj = (k)d.get(obj);
                if (a(((k) (obj))))
                {
                    return false;
                }
            } while (k.c(((k) (obj))) <= k.c(k1));
            return true;
        }
        return false;
    }

    public void b(k k1)
    {
        k.a(k1, true);
        k.b(k1, false);
        k.a(k1, System.currentTimeMillis());
        a();
    }

}
