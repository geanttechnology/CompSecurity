// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            ew, he, ex, gm, 
//            hf

public final class ey extends ew
{

    ey(Context context, gb.a a, he he1, fb.a a1)
    {
        super(context, a, he1, a1);
    }

    protected final void b(long l)
    {
        Object obj = d.h();
        int i;
        int j;
        if (((AdSizeParcel) (obj)).e)
        {
            i = c.getResources().getDisplayMetrics().widthPixels;
            j = c.getResources().getDisplayMetrics().heightPixels;
        } else
        {
            i = ((AdSizeParcel) (obj)).g;
            j = ((AdSizeParcel) (obj)).d;
        }
        obj = new ex(this, d, i, j, (byte)0);
        gm.a.post(new Runnable(((ex) (obj))) {

            final ex a;
            final ey b;

            public final void run()
            {
label0:
                {
                    synchronized (b.e)
                    {
                        if (b.h.e == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                b.d.i().d = b;
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
                b = ey.this;
                a = ex1;
                super();
            }
        });
        a(l);
        if (((ex) (obj)).b())
        {
            com.google.android.gms.ads.internal.util.client.b.a(3);
            throw new ez.a("AdNetwork sent passback url", 3);
        }
        if (!((ex) (obj)).c())
        {
            throw new ez.a("AdNetwork timed out", 2);
        } else
        {
            return;
        }
    }
}
