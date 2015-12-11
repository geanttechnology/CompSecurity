// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import com.google.ads.mediation.MediationAdapter;
import com.google.ads.util.a;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads:
//            h

class nit>
    implements Runnable
{

    final h a;

    public void run()
    {
        if (a.l())
        {
            com.google.ads.util.a.b(com.google.ads.h.a(a));
            try
            {
                com.google.ads.h.a(a).destroy();
            }
            catch (Throwable throwable)
            {
                b.b((new StringBuilder()).append("Error while destroying adapter (").append(a.h()).append("):").toString(), throwable);
                return;
            }
            b.a((new StringBuilder()).append("Called destroy() for adapter with class: ").append(com.google.ads.h.a(a).getClass().getName()).toString());
        }
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
