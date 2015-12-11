// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.LinkedBlockingQueue;

final class cza
    implements Runnable
{

    private cyz a;

    cza(cyz cyz1)
    {
        a = cyz1;
        super();
    }

    public final void run()
    {
        cyz cyz1 = a;
        if (cyz1.e == null && cyz1.d)
        {
            cyz1.f = (cyx)cyz1.h.poll();
            if (cyz1.f != null)
            {
                int i = cyz1.f.b();
                cyz1.e = new czg(cyz1);
                if (!cyz1.g)
                {
                    cyz1.g = true;
                    cyz1.a.c(i);
                }
                cyz1.f.a(cyz1.e);
                return;
            }
            if (cyz1.g)
            {
                cyz1.g = false;
                cyz1.a.t();
                return;
            }
        }
    }
}
