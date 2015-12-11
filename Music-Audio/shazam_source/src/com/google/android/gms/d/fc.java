// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            ew, gm, he, hf

public class fc extends ew
{

    fc(Context context, gb.a a, he he, fb.a a1)
    {
        super(context, a, he, a1);
    }

    protected final void b(long l)
    {
        gm.a.post(new Runnable() {

            final fc a;

            public final void run()
            {
label0:
                {
                    synchronized (a.e)
                    {
                        if (a.h.e == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.d.i().d = a;
                a.c();
                com.google.android.gms.ads.internal.util.client.b.a(2);
                he he1 = a.d;
                p.e();
                he1.loadDataWithBaseURL(gm.a(a.h.b), a.h.c, "text/html", "UTF-8", null);
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                a = fc.this;
                super();
            }
        });
        a(l);
    }

    protected void c()
    {
    }
}
