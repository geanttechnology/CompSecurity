// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.engine.c;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.v;
import com.bumptech.glide.load.engine.w;
import com.bumptech.glide.load.engine.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import myobfuscated.ag.g;
import myobfuscated.ag.h;
import myobfuscated.aj.j;
import myobfuscated.ak.a;
import myobfuscated.ak.b;
import myobfuscated.ak.d;
import myobfuscated.ak.f;
import myobfuscated.t.l;

// Referenced classes of package com.bumptech.glide.request:
//            b, f, a, c, 
//            d

public final class SingleRequest
    implements com.bumptech.glide.request.b, com.bumptech.glide.request.f, g, d
{

    private static final android.support.v4.util.Pools.Pool a = myobfuscated.ak.a.a(new b() {

        public final Object a()
        {
            return new SingleRequest((byte)0);
        }

    });
    private final String b;
    private final f c;
    private com.bumptech.glide.request.c d;
    private com.bumptech.glide.d e;
    private Object f;
    private Class g;
    private com.bumptech.glide.request.a h;
    private int i;
    private int j;
    private Priority k;
    private h l;
    private com.bumptech.glide.request.d m;
    private m n;
    private myobfuscated.ah.g o;
    private ad p;
    private p q;
    private long r;
    private Status s;
    private Drawable t;
    private Drawable u;
    private Drawable v;
    private int w;
    private int x;

    private SingleRequest()
    {
        b = String.valueOf(hashCode());
        c = myobfuscated.ak.f.a();
    }

    SingleRequest(byte byte0)
    {
        this();
    }

    private Drawable a(int i1)
    {
        return ResourcesCompat.getDrawable(e.getResources(), i1, h.u);
    }

    public static SingleRequest a(com.bumptech.glide.d d1, Object obj, Class class1, com.bumptech.glide.request.a a1, int i1, int j1, Priority priority, h h1, 
            com.bumptech.glide.request.d d2, com.bumptech.glide.request.c c1, m m1, myobfuscated.ah.g g1)
    {
        SingleRequest singlerequest1 = (SingleRequest)a.acquire();
        SingleRequest singlerequest = singlerequest1;
        if (singlerequest1 == null)
        {
            singlerequest = new SingleRequest();
        }
        singlerequest.e = d1;
        singlerequest.f = obj;
        singlerequest.g = class1;
        singlerequest.h = a1;
        singlerequest.i = i1;
        singlerequest.j = j1;
        singlerequest.k = priority;
        singlerequest.l = h1;
        singlerequest.m = d2;
        singlerequest.d = c1;
        singlerequest.n = m1;
        singlerequest.o = g1;
        singlerequest.s = Status.PENDING;
        return singlerequest;
    }

    private void a(GlideException glideexception, int i1)
    {
        c.b();
        int j1 = e.d;
        if (j1 <= i1)
        {
            Log.w("Glide", (new StringBuilder("Load failed for ")).append(f).append(" with size [").append(w).append("x").append(x).append("]").toString(), glideexception);
            if (j1 <= 4)
            {
                glideexception.logRootCauses("Glide");
            }
        }
        q = null;
        s = Status.FAILED;
        if (m != null)
        {
            m();
        }
        if (l())
        {
            Object obj;
            if (f == null)
            {
                glideexception = k();
            } else
            {
                if (t == null)
                {
                    t = h.e;
                    if (t == null && h.f > 0)
                    {
                        t = a(h.f);
                    }
                }
                glideexception = t;
            }
            obj = glideexception;
            if (glideexception == null)
            {
                obj = j();
            }
            l.c(((Drawable) (obj)));
        }
    }

    private void a(ad ad1)
    {
        myobfuscated.aj.j.a();
        if (ad1 instanceof y)
        {
            ((y)ad1).f();
            p = null;
            return;
        } else
        {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
    }

    private void a(String s1)
    {
        (new StringBuilder()).append(s1).append(" this: ").append(b);
    }

    private Drawable j()
    {
        if (u == null)
        {
            u = h.g;
            if (u == null && h.h > 0)
            {
                u = a(h.h);
            }
        }
        return u;
    }

    private Drawable k()
    {
        if (v == null)
        {
            v = h.o;
            if (v == null && h.p > 0)
            {
                v = a(h.p);
            }
        }
        return v;
    }

    private boolean l()
    {
        return d == null || d.b(this);
    }

    private boolean m()
    {
        return d == null || !d.b();
    }

    public final void a()
    {
        c.b();
        r = myobfuscated.aj.f.a();
        if (f == null)
        {
            if (myobfuscated.aj.j.a(i, j))
            {
                w = i;
                x = j;
            }
            byte byte0;
            if (k() == null)
            {
                byte0 = 5;
            } else
            {
                byte0 = 3;
            }
            a(new GlideException("Received null model"), byte0);
        } else
        {
            s = Status.WAITING_FOR_SIZE;
            if (myobfuscated.aj.j.a(i, j))
            {
                a(i, j);
            } else
            {
                l.a(this);
            }
            if ((s == Status.RUNNING || s == Status.WAITING_FOR_SIZE) && l())
            {
                l.b(j());
            }
            if (Log.isLoggable("Request", 2))
            {
                a((new StringBuilder("finished run method in ")).append(myobfuscated.aj.f.a(r)).toString());
                return;
            }
        }
    }

    public final void a(int i1, int j1)
    {
        c.b();
        if (Log.isLoggable("Request", 2))
        {
            a((new StringBuilder("Got onSizeReady in ")).append(myobfuscated.aj.f.a(r)).toString());
        }
        if (s == Status.WAITING_FOR_SIZE) goto _L2; else goto _L1
_L1:
        return;
_L2:
        w w1;
        m m1;
        com.bumptech.glide.d d1;
        Object obj2;
        com.bumptech.glide.load.b b1;
        Class class1;
        Class class2;
        Priority priority;
        com.bumptech.glide.load.engine.l l1;
        Map map;
        com.bumptech.glide.load.e e1;
        long l2;
        boolean flag;
        boolean flag1;
        s = Status.RUNNING;
        float f1 = h.b;
        w = Math.round((float)i1 * f1);
        x = Math.round(f1 * (float)j1);
        if (Log.isLoggable("Request", 2))
        {
            a((new StringBuilder("finished setup for calling load in ")).append(myobfuscated.aj.f.a(r)).toString());
        }
        m1 = n;
        d1 = e;
        obj2 = f;
        b1 = h.l;
        i1 = w;
        j1 = x;
        class1 = h.s;
        class2 = g;
        priority = k;
        l1 = h.c;
        map = h.r;
        flag = h.m;
        e1 = h.q;
        flag1 = h.i;
        myobfuscated.aj.j.a();
        l2 = myobfuscated.aj.f.a();
        w1 = new w(obj2, b1, i1, j1, map, class1, class2, e1);
        if (flag1) goto _L4; else goto _L3
_L3:
        Object obj1 = null;
_L5:
        Object obj;
        if (obj1 != null)
        {
            a(((ad) (obj1)), DataSource.MEMORY_CACHE);
            if (Log.isLoggable("Engine", 2))
            {
                com.bumptech.glide.load.engine.m.a("Loaded resource from cache", l2, w1);
            }
            obj = null;
        } else
        {
            if (!flag1)
            {
                obj = null;
            } else
            {
                obj = (WeakReference)m1.d.get(w1);
                s s1;
                DecodeJob decodejob;
                com.bumptech.glide.load.engine.h h1;
                int k1;
                if (obj != null)
                {
                    obj = (y)((WeakReference) (obj)).get();
                    if (obj != null)
                    {
                        ((y) (obj)).e();
                    } else
                    {
                        m1.d.remove(w1);
                    }
                } else
                {
                    obj = null;
                }
            }
            if (obj != null)
            {
                a(((ad) (obj)), DataSource.MEMORY_CACHE);
                if (Log.isLoggable("Engine", 2))
                {
                    com.bumptech.glide.load.engine.m.a("Loaded resource from active resources", l2, w1);
                }
                obj = null;
            } else
            {
                obj = (s)m1.a.get(w1);
                if (obj != null)
                {
                    ((s) (obj)).a(this);
                    if (Log.isLoggable("Engine", 2))
                    {
                        com.bumptech.glide.load.engine.m.a("Added to existing load", l2, w1);
                    }
                    obj = new p(this, ((s) (obj)));
                } else
                {
                    s1 = (s)m1.c.d.acquire();
                    s1.f = w1;
                    s1.g = flag1;
                    obj = m1.e;
                    decodejob = (DecodeJob)((n) (obj)).b.acquire();
                    k1 = ((n) (obj)).c;
                    obj.c = k1 + 1;
                    obj = decodejob.a;
                    h1 = decodejob.b;
                    obj.c = d1;
                    obj.d = obj2;
                    obj.n = b1;
                    obj.e = i1;
                    obj.f = j1;
                    obj.p = l1;
                    obj.g = class1;
                    obj.h = h1;
                    obj.k = class2;
                    obj.o = priority;
                    obj.i = e1;
                    obj.j = map;
                    obj.q = flag;
                    decodejob.d = d1;
                    decodejob.e = b1;
                    decodejob.f = priority;
                    decodejob.g = w1;
                    decodejob.h = i1;
                    decodejob.i = j1;
                    decodejob.j = l1;
                    decodejob.k = e1;
                    decodejob.l = s1;
                    decodejob.m = k1;
                    decodejob.n = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE;
                    m1.a.put(w1, s1);
                    s1.a(this);
                    s1.k = decodejob;
                    obj = decodejob.a(com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE);
                    if (obj == com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE || obj == com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    if (i1 != 0)
                    {
                        obj = s1.d;
                    } else
                    {
                        obj = s1.e;
                    }
                    ((GlideExecutor) (obj)).execute(decodejob);
                    if (Log.isLoggable("Engine", 2))
                    {
                        com.bumptech.glide.load.engine.m.a("Started new load", l2, w1);
                    }
                    obj = new p(this, s1);
                }
            }
        }
        q = ((p) (obj));
        if (Log.isLoggable("Request", 2))
        {
            a((new StringBuilder("finished onSizeReady in ")).append(myobfuscated.aj.f.a(r)).toString());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        obj = m1.b.a(w1);
        if (obj == null)
        {
            obj = null;
        } else
        if (obj instanceof y)
        {
            obj = (y)obj;
        } else
        {
            obj = new y(((ad) (obj)), true);
        }
        obj1 = obj;
        if (obj != null)
        {
            ((y) (obj)).e();
            m1.d.put(w1, new r(w1, ((y) (obj)), m1.a()));
            obj1 = obj;
        }
          goto _L5
    }

    public final void a(GlideException glideexception)
    {
        a(glideexception, 5);
    }

    public final void a(ad ad1, DataSource datasource)
    {
        c.b();
        q = null;
        if (ad1 == null)
        {
            a(new GlideException((new StringBuilder("Expected to receive a Resource<R> with an object of ")).append(g).append(" inside, but instead got null.").toString()), 5);
        } else
        {
            Object obj = ad1.b();
            if (obj == null || !g.isAssignableFrom(obj.getClass()))
            {
                a(ad1);
                StringBuilder stringbuilder = (new StringBuilder("Expected to receive an object of ")).append(g).append(" but instead got ");
                if (obj != null)
                {
                    datasource = obj.getClass();
                } else
                {
                    datasource = "";
                }
                datasource = stringbuilder.append(datasource).append("{").append(obj).append("} inside Resource{").append(ad1).append("}.");
                if (obj != null)
                {
                    ad1 = "";
                } else
                {
                    ad1 = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                }
                a(new GlideException(datasource.append(ad1).toString()), 5);
                return;
            }
            boolean flag;
            if (d == null || d.a(this))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                a(ad1);
                s = Status.COMPLETE;
                return;
            }
            boolean flag1 = m();
            s = Status.COMPLETE;
            p = ad1;
            if (e.d <= 3)
            {
                (new StringBuilder("Finished loading ")).append(obj.getClass().getSimpleName()).append(" from ").append(datasource).append(" for ").append(f).append(" with size [").append(w).append("x").append(x).append("] in ").append(myobfuscated.aj.f.a(r)).append(" ms");
            }
            if (m != null)
            {
                m.a(obj);
            }
            ad1 = o.a(datasource, flag1);
            l.a(obj, ad1);
            if (d != null)
            {
                d.c(this);
                return;
            }
        }
    }

    public final void c()
    {
        d();
        s = Status.PAUSED;
    }

    public final void d()
    {
        myobfuscated.aj.j.a();
        if (s == Status.CLEARED)
        {
            return;
        }
        c.b();
        s = Status.CANCELLED;
        if (q == null) goto _L2; else goto _L1
_L1:
        s s1;
        Object obj;
        obj = q;
        s1 = ((p) (obj)).a;
        obj = ((p) (obj)).b;
        myobfuscated.aj.j.a();
        s1.b.b();
        if (!s1.h && !s1.i) goto _L4; else goto _L3
_L3:
        if (s1.j == null)
        {
            s1.j = new ArrayList(2);
        }
        if (!s1.j.contains(obj))
        {
            s1.j.add(obj);
        }
_L6:
        q = null;
_L2:
        if (p != null)
        {
            a(p);
        }
        if (l())
        {
            l.d(j());
        }
        s = Status.CLEARED;
        return;
_L4:
        s1.a.remove(obj);
        if (s1.a.isEmpty() && !s1.i && !s1.h && !s1.l)
        {
            s1.l = true;
            Object obj1 = s1.k;
            obj1.p = true;
            obj1 = ((DecodeJob) (obj1)).o;
            if (obj1 != null)
            {
                ((c) (obj1)).b();
            }
            boolean flag;
            if (s1.d.remove(s1.k) || s1.e.remove(s1.k))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s1.c.a(s1, s1.f);
            if (flag)
            {
                s1.a(true);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final boolean e()
    {
        return s == Status.RUNNING || s == Status.WAITING_FOR_SIZE;
    }

    public final f e_()
    {
        return c;
    }

    public final boolean f()
    {
        return s == Status.COMPLETE;
    }

    public final boolean g()
    {
        return f();
    }

    public final boolean h()
    {
        return s == Status.CANCELLED || s == Status.CLEARED;
    }

    public final void i()
    {
        e = null;
        f = null;
        g = null;
        h = null;
        i = -1;
        j = -1;
        l = null;
        m = null;
        d = null;
        o = null;
        q = null;
        t = null;
        u = null;
        v = null;
        w = -1;
        x = -1;
        a.release(this);
    }


    private class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status CANCELLED;
        public static final Status CLEARED;
        public static final Status COMPLETE;
        public static final Status FAILED;
        public static final Status PAUSED;
        public static final Status PENDING;
        public static final Status RUNNING;
        public static final Status WAITING_FOR_SIZE;

        public static Status valueOf(String s1)
        {
            return (Status)Enum.valueOf(com/bumptech/glide/request/SingleRequest$Status, s1);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            PENDING = new Status("PENDING", 0);
            RUNNING = new Status("RUNNING", 1);
            WAITING_FOR_SIZE = new Status("WAITING_FOR_SIZE", 2);
            COMPLETE = new Status("COMPLETE", 3);
            FAILED = new Status("FAILED", 4);
            CANCELLED = new Status("CANCELLED", 5);
            CLEARED = new Status("CLEARED", 6);
            PAUSED = new Status("PAUSED", 7);
            $VALUES = (new Status[] {
                PENDING, RUNNING, WAITING_FOR_SIZE, COMPLETE, FAILED, CANCELLED, CLEARED, PAUSED
            });
        }

        private Status(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
