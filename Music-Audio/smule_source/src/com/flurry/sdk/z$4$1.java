// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            hq, z, ae, ai, 
//            gd, ah, f, fp

class it> extends hq
{

    final a a;

    public void safeRun()
    {
        z.b(a.a);
    }

    t>(t> t>)
    {
        a = t>;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/z$4

/* anonymous class */
    class z._cls4
        implements ai.a
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
            fp.a().b(new z._cls4._cls1(this));
            return;
            ai1;
            map;
            JVM INSTR monitorexit ;
            throw ai1;
        }

            
            {
                b = z1;
                a = ae1;
                super();
            }
    }

}
