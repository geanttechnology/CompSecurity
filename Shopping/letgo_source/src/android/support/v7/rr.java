// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

// Referenced classes of package android.support.v7:
//            rp, ul, rq, tp, 
//            um

public class rr extends rp
{

    rr(Context context, te.a a, ul ul1, ru.a a1)
    {
        super(context, a, ul1, a1);
    }

    protected void b(long l)
        throws rs.a
    {
        Object obj = d.h();
        int i;
        int j;
        if (((AdSizeParcel) (obj)).zzsH)
        {
            j = c.getResources().getDisplayMetrics().widthPixels;
            i = c.getResources().getDisplayMetrics().heightPixels;
        } else
        {
            j = ((AdSizeParcel) (obj)).widthPixels;
            i = ((AdSizeParcel) (obj)).heightPixels;
        }
        obj = new rq(this, d, j, i);
        tp.a.post(new Runnable(((rq) (obj))) {

            final rq a;
            final rr b;

            public void run()
            {
label0:
                {
                    synchronized (b.e)
                    {
                        if (b.h.errorCode == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                b.d.i().a(b);
                a.a(b.h);
                obj1;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = rr.this;
                a = rq1;
                super();
            }
        });
        a(l);
        if (((rq) (obj)).c())
        {
            zzb.zzaC("Ad-Network indicated no fill with passback URL.");
            throw new rs.a("AdNetwork sent passback url", 3);
        }
        if (!((rq) (obj)).d())
        {
            throw new rs.a("AdNetwork timed out", 2);
        } else
        {
            return;
        }
    }
}
