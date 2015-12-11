// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            tl, te, tp, ul

public abstract class rs extends tl
{
    protected static final class a extends Exception
    {

        private final int a;

        public int a()
        {
            return a;
        }

        public a(String s, int i)
        {
            super(s);
            a = i;
        }
    }


    protected final ru.a b;
    protected final Context c;
    protected final ul d;
    protected final Object e = new Object();
    protected final Object f = new Object();
    protected final te.a g;
    protected AdResponseParcel h;

    protected rs(Context context, te.a a1, ul ul, ru.a a2)
    {
        c = context;
        g = a1;
        h = a1.b;
        d = ul;
        b = a2;
    }

    protected te a(int i)
    {
        AdRequestInfoParcel adrequestinfoparcel = g.a;
        return new te(adrequestinfoparcel.zzDy, d, h.zzyw, i, h.zzyx, h.zzDZ, h.orientation, h.zzyA, adrequestinfoparcel.zzDB, h.zzDX, null, null, null, null, null, h.zzDY, g.d, h.zzDW, g.f, h.zzEb, h.zzEc, g.h, null, adrequestinfoparcel.zzDO);
    }

    protected void a(te te1)
    {
        b.zzb(te1);
    }

    protected abstract void b(long l)
        throws a;

    public void onStop()
    {
    }

    public void zzdG()
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        int i;
        zzb.zzaC("AdRendererBackgroundTask started.");
        i = g.e;
        b(SystemClock.elapsedRealtime());
_L3:
        te te1 = a(i);
        tp.a.post(new Runnable(te1) {

            final te a;
            final rs b;

            public void run()
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
                b = rs.this;
                a = te1;
                super();
            }
        });
        return;
        Object obj1;
        obj1;
        i = ((a) (obj1)).a();
        if (i != 3 && i != -1) goto _L2; else goto _L1
_L1:
        zzb.zzaD(((a) (obj1)).getMessage());
_L4:
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        h = new AdResponseParcel(i);
_L5:
        tp.a.post(new Runnable() {

            final rs a;

            public void run()
            {
                a.onStop();
            }

            
            {
                a = rs.this;
                super();
            }
        });
          goto _L3
_L2:
        zzb.zzaE(((a) (obj1)).getMessage());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        h = new AdResponseParcel(i, h.zzyA);
          goto _L5
    }
}
