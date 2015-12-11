// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.d;
import com.appnexus.opensdk.b.e;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            ae, aq, h, aa, 
//            ab, ap, at, d, 
//            z, ar, i, r, 
//            al

public abstract class ac
{
    private final class a extends d
    {

        WeakReference a;
        final aq b;
        final ac c;
        private final String d;
        private final HashMap e;
        private final boolean f;
        private final long g;
        private final long h;

        protected final String a()
        {
            StringBuilder stringbuilder = new StringBuilder(d);
            stringbuilder.append("&reason=").append(b.ordinal());
            if (!com.appnexus.opensdk.b.k.a(com.appnexus.opensdk.b.j.a().d))
            {
                stringbuilder.append("&aaid=").append(Uri.encode(com.appnexus.opensdk.b.j.a().d));
            } else
            {
                stringbuilder.append("&md5udid=").append(Uri.encode(com.appnexus.opensdk.b.j.a().a));
                stringbuilder.append("&sha1udid=").append(Uri.encode(com.appnexus.opensdk.b.j.a().b));
            }
            if (g > 0L)
            {
                stringbuilder.append("&latency=").append(Uri.encode(String.valueOf(g)));
            }
            if (h > 0L)
            {
                stringbuilder.append("&total_latency=").append(Uri.encode(String.valueOf(h)));
            }
            return stringbuilder.toString();
        }

        protected final void a(e e1)
        {
            if (f)
            {
                com.appnexus.opensdk.b.b.c(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.result_cb_ignored));
                return;
            }
            h h1 = (h)a.get();
            if (h1 == null)
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.fire_cb_requester_null));
                return;
            }
            ar ar1 = null;
            if (e1 != null && e1.a)
            {
                ar1 = new ar(e1, c.a);
                e1 = ar1;
                if (e.containsKey("ORIENTATION"))
                {
                    ar1.a("ORIENTATION", e.get("ORIENTATION"));
                    e1 = ar1;
                }
            } else
            {
                com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.result_cb_bad_response));
                e1 = ar1;
            }
            h1.a(e1);
        }

        protected final void onPostExecute(Object obj)
        {
            a((e)obj);
        }

        private a(h h1, String s, aq aq1, HashMap hashmap, boolean flag, long l1, long l2)
        {
            c = ac.this;
            super();
            a = new WeakReference(h1);
            d = s;
            b = aq1;
            e = hashmap;
            f = flag;
            g = l1;
            h = l2;
        }

        a(h h1, String s, aq aq1, HashMap hashmap, boolean flag, long l1, long l2, byte byte0)
        {
            this(h1, s, aq1, hashmap, flag, l1, l2);
        }
    }

    static final class b extends Handler
    {

        WeakReference a;

        public final void handleMessage(Message message)
        {
            Exception exception;
            message = (ac)a.get();
            if (message == null || ((ac) (message)).f)
            {
                return;
            }
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_timeout));
            try
            {
                message.a(aq.f);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                message.d = null;
                message.b = null;
                message.c = null;
                return;
            }
            finally
            {
                message.d = null;
            }
            message.d = null;
            message.b = null;
            message.c = null;
            return;
            message.b = null;
            message.c = null;
            throw exception;
        }

        public b(ac ac1)
        {
            a = new WeakReference(ac1);
        }
    }


    protected z a;
    protected ab b;
    protected aa c;
    protected com.appnexus.opensdk.d d;
    protected ae e;
    boolean f;
    boolean g;
    protected boolean h;
    long i;
    protected boolean j;
    private WeakReference k;
    private final Handler l;
    private long m;

    ac(h h1, aa aa1, com.appnexus.opensdk.d d1, z z)
    {
        e = new ae(this);
        f = false;
        g = false;
        h = false;
        l = new b(this);
        i = -1L;
        m = -1L;
        j = false;
        k = new WeakReference(h1);
        c = aa1;
        d = d1;
        a = z;
        h1 = null;
        if (aa1 != null) goto _L2; else goto _L1
_L1:
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediated_no_ads));
        h1 = aq.c;
_L4:
        if (h1 != null)
        {
            a(h1);
        }
        return;
_L2:
        if (!l())
        {
            h1 = com.appnexus.opensdk.aq.d;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Throwable throwable, String s)
    {
        com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_instantiation_failure, throwable.getClass().getSimpleName()));
        if (!com.appnexus.opensdk.b.k.a(s))
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, String.format("Adding %s to invalid networks list", new Object[] {
                s
            }));
            com.appnexus.opensdk.b.j.a().a(a, s);
        }
    }

    private void b(aq aq1)
    {
        if (!f) goto _L2; else goto _L1
_L1:
        return;
_L2:
        h h1;
        h1 = (h)k.get();
        if (c != null && !com.appnexus.opensdk.b.k.a(c.f))
        {
            break; /* Loop/switch isn't completed */
        }
        if (aq1 != aq.a)
        {
            com.appnexus.opensdk.b.b.d(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.fire_cb_result_null));
            if (h1 == null)
            {
                com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.f, com.appnexus.opensdk.b.b.a(an.d.fire_cb_requester_null));
                return;
            } else
            {
                h1.a(null);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag1 = false;
        boolean flag = flag1;
        Object obj;
        long l1;
        long l2;
        if (h1 != null)
        {
            flag = flag1;
            HashMap hashmap;
            if (h1.a() != null)
            {
                if (h1.a().size() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
        }
        if (aq1 == aq.a)
        {
            flag = true;
        }
        obj = c.f;
        hashmap = c.g;
        if (i > 0L && m > 0L)
        {
            l1 = m - i;
        } else
        {
            l1 = -1L;
        }
        if (h1 != null && m > 0L)
        {
            l2 = h1.a(m);
        } else
        {
            l2 = -1L;
        }
        obj = new a(h1, ((String) (obj)), aq1, hashmap, flag, l1, l2, (byte)0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            ((a) (obj)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else
        {
            ((a) (obj)).execute(new Void[0]);
        }
        if (flag && aq1 != aq.a && h1 != null)
        {
            h1.a(null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private boolean l()
    {
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.instantiating_class, c.a));
        String s;
        String s1;
        s = c.a;
        s1 = (String)com.appnexus.opensdk.b.j.a().t.get(s);
        if (!com.appnexus.opensdk.b.k.a(s1)) goto _L2; else goto _L1
_L1:
        b = (ab)Class.forName(s).newInstance();
          goto _L3
_L2:
        b = (ab)Class.forName(s1).getConstructor(new Class[] {
            java/lang/String
        }).newInstance(new Object[] {
            s
        });
          goto _L3
        Object obj;
        obj;
        a(((Throwable) (obj)), c.a);
_L4:
        return false;
        obj;
        a(((Throwable) (obj)), c.a);
        continue; /* Loop/switch isn't completed */
        obj;
        a(((Throwable) (obj)), c.a);
        continue; /* Loop/switch isn't completed */
        obj;
        a(((Throwable) (obj)), c.a);
        continue; /* Loop/switch isn't completed */
        obj;
        a(((Throwable) (obj)), c.a);
        continue; /* Loop/switch isn't completed */
        obj;
        a(((Throwable) (obj)), c.a);
        continue; /* Loop/switch isn't completed */
        obj;
        a(((Throwable) (obj)), c.a);
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    private void m()
    {
        l.removeMessages(0);
    }

    protected final at a()
    {
        Object obj = (h)k.get();
        at at1;
        if (obj != null && ((h) (obj)).b() != null)
        {
            obj = ((h) (obj)).b().g();
        } else
        {
            obj = null;
        }
        at1 = ((at) (obj));
        if (obj == null)
        {
            at1 = new at();
        }
        return at1;
    }

    public final void a(aq aq1)
    {
        if (g || f || h)
        {
            return;
        } else
        {
            m = System.currentTimeMillis();
            m();
            b(aq1);
            f = true;
            b();
            return;
        }
    }

    final boolean a(Class class1)
    {
        if (f)
        {
            return false;
        }
        if (b == null || !class1.isInstance(b))
        {
            com.appnexus.opensdk.b.b.e(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.instance_exception, class1.getCanonicalName()));
            a(com.appnexus.opensdk.aq.d);
            return false;
        } else
        {
            return true;
        }
    }

    protected final void b()
    {
        if (b != null)
        {
            b.destroy();
        }
        h = true;
        b = null;
        c = null;
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.c, com.appnexus.opensdk.b.b.a(an.d.mediation_finish));
    }

    public final void c()
    {
        if (g || f || h)
        {
            return;
        }
        m = System.currentTimeMillis();
        m();
        g = true;
        h h1 = (h)k.get();
        if (h1 != null)
        {
            h1.a(new i() {

                final ac a;

                public final z a()
                {
                    return a.a;
                }

                public final boolean b()
                {
                    return true;
                }

                public final r c()
                {
                    return a.e;
                }

                public final al d()
                {
                    return null;
                }

                public final void e()
                {
                    a.e.destroy();
                }

            
            {
                a = ac.this;
                super();
            }
            });
        } else
        {
            e.destroy();
        }
        b(aq.a);
    }

    public final void d()
    {
        while (f || h || d == null) 
        {
            return;
        }
        d.a();
    }

    public final void e()
    {
        while (f || h || d == null) 
        {
            return;
        }
        d.b();
    }

    public final void f()
    {
        while (f || h || d == null) 
        {
            return;
        }
        d.c();
    }

    final void g()
    {
        if (g || f)
        {
            return;
        } else
        {
            l.sendEmptyMessageDelayed(0, 15000L);
            return;
        }
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();

    protected final void k()
    {
        j = true;
        b();
    }
}
