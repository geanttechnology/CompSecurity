// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import com.shazam.android.j.q.a;
import com.shazam.h.j;
import java.util.Date;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.shazam.android.ae:
//            l, g, h, j

public final class i
    implements l
{

    private final h b;
    private final ExecutorService c;

    public i(h h, ExecutorService executorservice)
    {
        b = h;
        c = executorservice;
    }

    static h a(i j)
    {
        return j.b;
    }

    private void a(g g1)
    {
        if (!c.isShutdown())
        {
            c.execute(new Runnable(g1) {

                final g a;
                final i b;

                public final void run()
                {
                    h h1 = com.shazam.android.ae.i.a(b);
                    Object obj = a;
                    Date date = new Date();
                    java.net.URL url = com.shazam.b.c.a.a(String.format("https://sdk.hockeyapp.net/api/2/apps/%s/crashes/", new Object[] {
                        h1.b.a
                    }));
                    obj = h1.c.a(h1.b, ((Throwable) (obj)), date);
                    obj = (new com.shazam.h.y.a()).a("raw", ((String) (obj))).a("sdk", "ShazamSDK").a("sdk_version", "0.0.1").a();
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

            
            {
                b = i.this;
                a = g1;
                super();
            }
            });
        }
    }

    private static String b(String s, String s1)
    {
        return String.format("(Tag: %s) Message: %s", new Object[] {
            s, s1
        });
    }

    public final void a(String s, String s1)
    {
        a(new g(b(s, s1)));
    }

    public final void a(String s, String s1, Throwable throwable)
    {
        a(new g(b(s, s1), throwable));
    }
}
