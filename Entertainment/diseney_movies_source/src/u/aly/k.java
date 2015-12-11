// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import com.umeng.analytics.e;
import com.umeng.analytics.f;
import com.umeng.analytics.onlineconfig.a;
import com.umeng.analytics.onlineconfig.c;

// Referenced classes of package u.aly:
//            o, j, p

public final class k
    implements o
{

    private static k c;
    private o a;
    private Context b;

    private k(Context context)
    {
        b = context.getApplicationContext();
        a = new j(b);
    }

    public static k a(Context context)
    {
        u/aly/k;
        JVM INSTR monitorenter ;
        if (c != null || context == null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        c = new k(context);
        context = c;
        u/aly/k;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static o a(k k1)
    {
        return k1.a;
    }

    public void a()
    {
        e.b(new f() {

            final k a;

            public void a()
            {
                u.aly.k.a(a).a();
            }

            
            {
                a = k.this;
                super();
            }
        });
    }

    public void a(a a1)
    {
        if (a1 != null && a != null)
        {
            a1.a((c)a);
        }
    }

    public void a(o o1)
    {
        a = o1;
    }

    public void a(p p)
    {
        e.b(new f(p) {

            final k a;
            private final p b;

            public void a()
            {
                u.aly.k.a(a).a(b);
            }

            
            {
                a = k.this;
                b = p;
                super();
            }
        });
    }

    public void b()
    {
        e.b(new f() {

            final k a;

            public void a()
            {
                u.aly.k.a(a).b();
            }

            
            {
                a = k.this;
                super();
            }
        });
    }

    public void b(p p)
    {
        a.b(p);
    }
}
