// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.google.android.gms.internal.dt;
import java.lang.ref.WeakReference;

public final class xi
{

    private final Runnable a;
    private volatile boolean b;

    public xi(dt dt)
    {
        b = false;
        a = new Runnable(dt) {

            final dt a;
            final xi b;
            private final WeakReference c;

            public void run()
            {
                dt dt1 = (dt)c.get();
                if (!xi.a(b) && dt1 != null)
                {
                    dt1.e();
                    b.b();
                }
            }

            
            {
                b = xi.this;
                a = dt1;
                super();
                c = new WeakReference(a);
            }
        };
    }

    static boolean a(xi xi1)
    {
        return xi1.b;
    }

    public void a()
    {
        b = true;
        aca.a.removeCallbacks(a);
    }

    public void b()
    {
        aca.a.postDelayed(a, 250L);
    }
}
