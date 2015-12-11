// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            xj, vo, xf, xa, 
//            xe, vn, xr, xp, 
//            xg, abo, xd, xi

public class xc
{
    public static interface a
    {

        public abstract void a(xg xg);
    }

    class b extends xp
    {

        final xc a;
        private final a b;

        protected xp.b a(xa xa1)
        {
            return null;
        }

        protected void a(xg xg1)
        {
            xg.a a1 = xg1.b();
            a.a(a1);
            if (a1.a() == Status.a && a1.b() == xg.a.a.a && a1.c() != null && a1.c().length > 0)
            {
                xc.a(a).a(a1.d().d(), a1.c());
                abo.d("Resource successfully load from Network.");
                b.a(xg1);
                return;
            }
            StringBuilder stringbuilder = (new StringBuilder()).append("Response status: ");
            if (a1.a().f())
            {
                xg1 = "SUCCESS";
            } else
            {
                xg1 = "FAILURE";
            }
            abo.d(stringbuilder.append(xg1).toString());
            if (a1.a().f())
            {
                abo.d((new StringBuilder()).append("Response source: ").append(a1.b().toString()).toString());
                abo.d((new StringBuilder()).append("Response size: ").append(a1.c().length).toString());
            }
            a.a(a1.d(), b);
        }

        b(xf xf1, xd xd, a a1)
        {
            a = xc.this;
            super(xf1, xd);
            b = a1;
        }
    }

    static class c
    {

        private Status a;
        private Object b;
        private long c;

        public long a()
        {
            return c;
        }

        public void a(long l)
        {
            c = l;
        }

        public void a(Status status)
        {
            a = status;
        }

        public void a(Object obj)
        {
            b = obj;
        }

        public c(Status status, Object obj, long l)
        {
            a = status;
            b = obj;
            c = l;
        }
    }


    Map a;
    private final Context b;
    private final xj c;
    private final vn d;
    private String e;
    private final Map f;

    public xc(Context context)
    {
        this(context, ((Map) (new HashMap())), new xj(context), vo.d());
    }

    xc(Context context, Map map, xj xj1, vn vn1)
    {
        e = null;
        a = new HashMap();
        b = context;
        d = vn1;
        c = xj1;
        f = map;
    }

    static xj a(xc xc1)
    {
        return xc1.c;
    }

    private void a(xf xf1, a a1)
    {
        boolean flag = true;
        xf1 = xf1.a();
        if (xf1.size() != 1)
        {
            flag = false;
        }
        x.b(flag);
        a((xa)xf1.get(0), a1);
    }

    void a(xa xa1, a a1)
    {
        c.a(xa1.d(), xa1.b(), xe.a, new xi(xa1, a1) {

            final xa a;
            final a b;
            final xc c;

            public void a(Status status, Object obj, Integer integer, long l)
            {
                if (status.f())
                {
                    if (integer == xj.a)
                    {
                        status = xg.a.a.c;
                    } else
                    {
                        status = xg.a.a.b;
                    }
                    status = new xg.a(Status.a, a, null, (xh.c)obj, status, l);
                } else
                {
                    status = new xg.a(new Status(16, (new StringBuilder()).append("There is no valid resource for the container: ").append(a.a()).toString()), null, xg.a.a.b);
                }
                b.a(new xg(status));
            }

            
            {
                c = xc.this;
                a = xa1;
                b = a1;
                super();
            }
        });
    }

    void a(xf xf1, a a1, xp xp)
    {
        Iterator iterator = xf1.a().iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            xa xa1 = (xa)iterator.next();
            c c1 = (c)a.get(xa1.a());
            long l;
            if (c1 != null)
            {
                l = c1.a();
            } else
            {
                l = c.a(xa1.a());
            }
            if (l + 0xdbba0L < d.a())
            {
                flag = true;
            }
        } while (true);
        if (flag)
        {
            a1 = (xr)f.get(xf1.b());
            if (a1 == null)
            {
                if (e == null)
                {
                    a1 = new xr();
                } else
                {
                    a1 = new xr(e);
                }
                f.put(xf1.b(), a1);
            }
            a1.a(b, xf1, 0L, xp);
            return;
        } else
        {
            a(xf1, a1);
            return;
        }
    }

    void a(xg.a a1)
    {
        Object obj = a1.d().a();
        Status status = a1.a();
        a1 = a1.e();
        if (a.containsKey(obj))
        {
            obj = (c)a.get(obj);
            ((c) (obj)).a(d.a());
            if (status == Status.a)
            {
                ((c) (obj)).a(status);
                ((c) (obj)).a(a1);
            }
            return;
        } else
        {
            a.put(obj, new c(status, a1, d.a()));
            return;
        }
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(String s, Integer integer, String s1, a a1)
    {
        s = (new xf()).a(new xa(s, integer, s1, false));
        a(((xf) (s)), a1, ((xp) (new b(s, xe.a, a1))));
    }
}
