// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            gi, gb, gm, he

public abstract class ez extends gi
{
    protected static final class a extends Exception
    {

        final int a;

        public a(String s, int i)
        {
            super(s);
            a = i;
        }
    }


    protected final fb.a b;
    protected final Context c;
    protected final he d;
    protected final Object e = new Object();
    protected final Object f = new Object();
    protected final gb.a g;
    protected AdResponseParcel h;

    protected ez(Context context, gb.a a1, he he, fb.a a2)
    {
        c = context;
        g = a1;
        h = a1.b;
        d = he;
        b = a2;
    }

    protected gb a(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = g.a;
        return new gb(adrequestinfoparcel.c, d, h.d, i, h.f, h.j, h.l, h.k, adrequestinfoparcel.i, h.h, null, null, null, null, null, h.i, g.d, h.g, g.f, h.n, h.o, g.h, null, adrequestinfoparcel.x);
    }

    public final void a()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        int i;
        com.google.android.gms.ads.internal.util.client.b.a(3);
        i = g.e;
        b(SystemClock.elapsedRealtime());
_L3:
        gb gb1 = a(i);
        gm.a.post(new Runnable(gb1) {

            final gb a;
            final ez b;

            public final void run()
            {
                synchronized (b.e)
                {
                    b.a(a);
                }
                return;
                exception;
                obj2;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = ez.this;
                a = gb1;
                super();
            }
        });
        return;
        Object obj1;
        obj1;
        i = ((a) (obj1)).a;
        if (i != 3 && i != -1) goto _L2; else goto _L1
_L1:
        ((a) (obj1)).getMessage();
        com.google.android.gms.ads.internal.util.client.b.a(4);
_L4:
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        h = new AdResponseParcel(i);
_L5:
        gm.a.post(new Runnable() {

            final ez a;

            public final void run()
            {
                a.b();
            }

            
            {
                a = ez.this;
                super();
            }
        });
          goto _L3
_L2:
        ((a) (obj1)).getMessage();
        com.google.android.gms.ads.internal.util.client.b.a(5);
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        h = new AdResponseParcel(i, h.k);
          goto _L5
    }

    protected void a(gb gb1)
    {
        b.b(gb1);
    }

    public void b()
    {
    }

    protected abstract void b(long l);
}
