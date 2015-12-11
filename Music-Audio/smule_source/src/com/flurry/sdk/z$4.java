// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            z, ae, ai, gd, 
//            ah, f, fp, hq

class nit>
    implements 
{

    final ae a;
    final z b;

    public void a(ai ai1)
    {
        synchronized (z.c(b))
        {
            z.c(b).remove(a.a());
        }
        z.a(b, a);
        if (ai1.a())
        {
            long l = ai1.c();
            gd.a(3, z.l(), (new StringBuilder()).append("Precaching: Download success: ").append(a.a()).append(" size: ").append(l).toString());
            a.a(l);
            z.a(b, a, ah.d);
            f.a().a("precachingDownloadSuccess", 1);
        } else
        {
            gd.a(3, z.l(), (new StringBuilder()).append("Precaching: Download error: ").append(a.a()).toString());
            z.a(b, a, ah.g);
            f.a().a("precachingDownloadError", 1);
        }
        fp.a().b(new hq() {

            final z._cls4 a;

            public void safeRun()
            {
                z.b(a.b);
            }

            
            {
                a = z._cls4.this;
                super();
            }
        });
        return;
        ai1;
        map;
        JVM INSTR monitorexit ;
        throw ai1;
    }

    init>(z z1, ae ae1)
    {
        b = z1;
        a = ae1;
        super();
    }
}
