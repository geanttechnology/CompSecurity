// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.design.widget.al;
import com.a.a.a;
import com.a.a.b;
import com.a.a.d;
import com.a.a.f;
import com.a.a.g;
import com.a.a.h;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;

// Referenced classes of package com.a:
//            a, d, b, g

public final class c extends com.a.a
    implements com.a.a.c
{

    private com.a.d e;
    private int f;
    private Exception g;
    private ArrayList h;

    public c(Activity activity, al al, EnumSet enumset)
    {
        super(activity, al, enumset);
    }

    private void a(int i, Exception exception)
    {
        c = true;
        if (i != 0)
        {
            f = i;
            g = exception;
        }
        if (a == null) goto _L2; else goto _L1
_L1:
        if (f == 0)
        {
            a("Telling the listener we succeeded...", new Object[0]);
        } else
        {
            a("Telling the listener we had a bad error...", new Object[0]);
        }
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
_L4:
        c = true;
        return;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        a("No listener to notify", new Object[0]);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void c()
    {
        a("checking if we are done...", new Object[0]);
        if (h != null && h.size() > 0)
        {
            Object obj = new ArrayList();
            Iterator iterator = h.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                a a2 = (a)iterator.next();
                if (a2.c())
                {
                    ((ArrayList) (obj)).add(a2);
                }
            } while (true);
            a a1;
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); h.remove(a1))
            {
                a1 = (a)((Iterator) (obj)).next();
            }

        }
        if (e != null && e.c() != null && (h == null || h.size() == 0))
        {
            a("All done, sending data...", new Object[0]);
            d();
            a(0, null);
            return;
        } else
        {
            a("[%s] collectors left", new Object[] {
                (new StringBuilder()).append(h.size()).toString()
            });
            return;
        }
    }

    private void c(b b1)
    {
        if (h == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = h.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        a a1 = (a)iterator.next();
        if (!a1.b().equals(b1)) goto _L6; else goto _L5
_L5:
        if (a1 != null)
        {
            a("Removing collector [%s]", new Object[] {
                a1.b()
            });
            h.remove(a1);
            return;
        } else
        {
            a("Collector not found [%s]", new Object[] {
                b1
            });
            return;
        }
_L2:
        a("No collectors being held", new Object[0]);
        return;
_L4:
        a1 = null;
        if (true) goto _L5; else goto _L7
_L7:
    }

    private void d()
    {
        Object obj = new com.a.b();
        Object obj1 = new com.a.d[1];
        obj1[0] = e;
        if (android.os.Build.VERSION.SDK_INT > 10)
        {
            ((com.a.b) (obj)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ((Object []) (obj1)));
        } else
        {
            ((com.a.b) (obj)).execute(((Object []) (obj1)));
        }
        a("Final Collection:", new Object[0]);
        for (obj = e.e().keySet().iterator(); ((Iterator) (obj)).hasNext(); a("key:[%s] value:[%s]", new Object[] {
    obj1, e.e().get(obj1)
}))
        {
            obj1 = (String)((Iterator) (obj)).next();
        }

    }

    protected final transient Void a(String as[])
    {
        h = new ArrayList();
        e = new com.a.d(as[0], as[1], as[2]);
        boolean flag;
        long l;
        if (b())
        {
            l = a();
        } else
        {
            l = 5000L;
        }
        as = new h(b, this, e, l);
        h.add(as);
        as = b.d;
        if (d != null && d.contains(as))
        {
            e.a(as, g.b);
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            as = new f(b, this, e, l);
            h.add(as);
        }
        for (as = h.iterator(); as.hasNext();)
        {
            a a1 = (a)as.next();
            a((new StringBuilder("Starting off ")).append(a1.getClass().getName()).toString(), new Object[0]);
            if (android.os.Build.VERSION.SDK_INT > 10)
            {
                a1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else
            {
                a1.execute(new Void[0]);
            }
        }

        a("Getting the quick data...", new Object[0]);
        as = new d(b, e);
        as.a();
        a("Got Required Info", new Object[0]);
        as.b();
        a("Got optional info...", new Object[0]);
        as.c();
        a("Got Device Cookie Info", new Object[0]);
        a("Done with quick data", new Object[0]);
        c();
        return null;
    }

    public final void a(b b1)
    {
        a((new StringBuilder("Long Collector starting:")).append(b1).toString(), new Object[0]);
    }

    public final void a(b b1, g g1, Exception exception)
    {
        a("Removing collector[%s] due to error [%s]", new Object[] {
            b1, g1
        });
        c(b1);
        if (!b.b.equals(b1))
        {
            break MISSING_BLOCK_LABEL_65;
        }
        c = true;
        f = com.a.g.f;
        g = exception;
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        b1;
        this;
        JVM INSTR monitorexit ;
        throw b1;
        c();
        return;
    }

    public final void b(b b1)
    {
        a("Collector success [%s]", new Object[] {
            b1
        });
        c(b1);
        c();
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    public final void onCancelled()
    {
        a("Called cancel..", new Object[0]);
        if (!c && e != null && e.c() != null)
        {
            a("Cancelling each collector", new Object[0]);
            Iterator iterator = h.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                a a1 = (a)iterator.next();
                if (!a1.c() && !a1.isCancelled())
                {
                    e.a(a1.b(), g.a);
                    a((new StringBuilder("Cancelling [")).append(a1.b()).append("] collector...").toString(), new Object[0]);
                    a1.cancel(true);
                    a((new StringBuilder("Cancelled [")).append(a1.b()).append("] collector.").toString(), new Object[0]);
                }
            } while (true);
            d();
            a(0, null);
        } else
        if (!c)
        {
            a(g.e, new CancellationException("Merchant Cancelled"));
            return;
        }
    }
}
