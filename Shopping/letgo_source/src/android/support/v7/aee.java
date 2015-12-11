// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.j;

// Referenced classes of package android.support.v7:
//            ack, acv, acu, xc, 
//            vo, abn, aeh, abo, 
//            aed, vn, acm, aai, 
//            aag, xg, aaf

public class aee extends j
{
    private class a
        implements aed.a
    {

        final aee a;

        private a()
        {
            a = aee.this;
            super();
        }

    }

    static interface b
        extends f
    {

        public abstract void a(String s);
    }

    static interface c
        extends f
    {
    }


    private final vn b;
    private final a c;
    private final Looper d;
    private final acm e;
    private final int f;
    private final Context g;
    private final aai h;
    private final String i;
    private c j;
    private xc k;
    private volatile aed l;
    private lu.i m;
    private String n;
    private b o;

    aee(Context context, aai aai, Looper looper, String s, int i1, c c1, b b1, 
            xc xc1, vn vn, acm acm)
    {
        Looper looper1;
        if (looper == null)
        {
            looper1 = Looper.getMainLooper();
        } else
        {
            looper1 = looper;
        }
        super(looper1);
        g = context;
        h = aai;
        context = looper;
        if (looper == null)
        {
            context = Looper.getMainLooper();
        }
        d = context;
        i = s;
        f = i1;
        j = c1;
        o = b1;
        k = xc1;
        c = new a();
        m = new lu.i();
        b = vn;
        e = acm;
        if (e())
        {
            b(ack.a().c());
        }
    }

    public aee(Context context, aai aai, Looper looper, String s, int i1, aeh aeh1)
    {
        this(context, aai, looper, s, i1, ((c) (new acv(context, s))), ((b) (new acu(context, s, aeh1))), new xc(context), vo.d(), ((acm) (new abn(30, 0xdbba0L, 5000L, "refreshing", vo.d()))));
        k.a(aeh1.a());
    }

    static aed a(aee aee1, aed aed1)
    {
        aee1.l = aed1;
        return aed1;
    }

    static String a(aee aee1)
    {
        return aee1.i;
    }

    static aai b(aee aee1)
    {
        return aee1.h;
    }

    static Looper c(aee aee1)
    {
        return aee1.d;
    }

    static Context d(aee aee1)
    {
        return aee1.g;
    }

    static aed e(aee aee1)
    {
        return aee1.l;
    }

    private boolean e()
    {
        ack ack1 = ack.a();
        return (ack1.b() == ack.a.b || ack1.b() == ack.a.c) && i.equals(ack1.d());
    }

    protected aag a(Status status)
    {
        if (l != null)
        {
            return l;
        }
        if (status == Status.d)
        {
            abo.a("timer expired: setting result to failure");
        }
        return new aed(status);
    }

    public void a(String s)
    {
        Integer integer;
        if (f != -1)
        {
            integer = Integer.valueOf(f);
        } else
        {
            integer = null;
        }
        k.a(i, integer, s, new xc.a(s) {

            final String a;
            final aee b;

            public void a(xg xg1)
            {
                if (xg1.a() != Status.a)
                {
                    abo.a((new StringBuilder()).append("Load request failed for the container ").append(aee.a(b)).toString());
                    b.a(b.a(Status.c));
                    return;
                }
                xh.c c1 = xg1.b().e();
                if (c1 == null)
                {
                    abo.a("Response doesn't have the requested container");
                    b.a(b.a(new Status(8, "Response doesn't have the requested container", null)));
                    return;
                } else
                {
                    long l1 = xg1.b().f();
                    aee.a(b, new aed(aee.b(b), aee.c(b), new aaf(aee.d(b), aee.b(b).a(), aee.a(b), l1, c1), new aed.a(this) {

                        final _cls1 a;

            
            {
                a = _pcls1;
                super();
            }
                    }));
                    b.a(aee.e(b));
                    return;
                }
            }

            
            {
                b = aee.this;
                a = s;
                super();
            }
        });
    }

    protected g b(Status status)
    {
        return a(status);
    }

    void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        n = s;
        if (o != null)
        {
            o.a(s);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }
}
