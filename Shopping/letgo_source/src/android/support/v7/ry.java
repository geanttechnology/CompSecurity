// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package android.support.v7:
//            tl, rz, tt, te, 
//            to, tp, mr, mc

public class ry extends tl
{

    private final ru.a a;
    private final AdResponseParcel b;
    private final te.a c;
    private final rz d;
    private final Object e;
    private Future f;

    public ry(Context context, zzn zzn, mr mr, te.a a1, mc mc, ru.a a2)
    {
        this(a1, a2, new rz(context, zzn, mr, new tt(context), mc, a1));
    }

    ry(te.a a1, ru.a a2, rz rz1)
    {
        e = new Object();
        c = a1;
        b = a1.b;
        a = a2;
        d = rz1;
    }

    static ru.a a(ry ry1)
    {
        return ry1.a;
    }

    private te a(int i)
    {
        return new te(c.a.zzDy, null, null, i, null, null, b.orientation, b.zzyA, c.a.zzDB, false, null, null, null, null, null, b.zzDY, c.d, b.zzDW, c.f, b.zzEb, b.zzEc, c.h, null, c.a.zzDO);
    }

    public void onStop()
    {
        synchronized (e)
        {
            if (f != null)
            {
                f.cancel(true);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzdG()
    {
        synchronized (e)
        {
            f = to.a(d);
        }
        obj = (te)f.get(60000L, TimeUnit.MILLISECONDS);
        byte byte0 = -2;
_L1:
        if (obj == null)
        {
            obj = a(byte0);
        }
        tp.a.post(new Runnable(((te) (obj))) {

            final te a;
            final ry b;

            public void run()
            {
                ry.a(b).zzb(a);
            }

            
            {
                b = ry.this;
                a = te1;
                super();
            }
        });
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzb.zzaE("Timed out waiting for native ad.");
            f.cancel(true);
            byte0 = 2;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            byte0 = 0;
            obj = null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            byte0 = -1;
        }
          goto _L1
    }
}
