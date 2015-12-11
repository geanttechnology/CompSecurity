// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import com.shazam.android.j.q.a;
import com.shazam.h.i;
import com.shazam.h.j;
import java.util.Date;

// Referenced classes of package com.shazam.android.ae:
//            i, h, j, g

final class a
    implements Runnable
{

    final g a;
    final com.shazam.android.ae.i b;

    public final void run()
    {
        h h1 = com.shazam.android.ae.i.a(b);
        Object obj = a;
        Date date = new Date();
        java.net.URL url = com.shazam.b.c.a.a(String.format("https://sdk.hockeyapp.net/api/2/apps/%s/crashes/", new Object[] {
            h1.b.a
        }));
        obj = h1.c.a(h1.b, ((Throwable) (obj)), date);
        obj = (new com.shazam.h.<init>()).a("raw", ((String) (obj))).a("sdk", "ShazamSDK").a("sdk_version", "0.0.1").a();
        try
        {
            h1.a.a(url, ((com.shazam.h.y) (obj)));
            return;
        }
        catch (j j1)
        {
            return;
        }
    }

    (com.shazam.android.ae.i k, g g)
    {
        b = k;
        a = g;
        super();
    }
}
