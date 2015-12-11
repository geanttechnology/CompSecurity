// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.webkit.WebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            hq, eb, gk, gd, 
//            cv, aw, fp, av

class t> extends hq
{

    final String a;
    final String b;
    final a c;

    public void safeRun()
    {
        if (eb.d(c.c) != null)
        {
            eb.d(c.c).loadDataWithBaseURL(a, b, "text/html", "utf-8", a);
        }
    }

    >(> >, String s, String s1)
    {
        c = >;
        a = s;
        b = s1;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/eb$5

/* anonymous class */
    class eb._cls5
        implements gk.a
    {

        final String a;
        final eb b;

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (String)obj);
        }

        public void a(gk gk1, String s)
        {
            int i = gk1.e();
            gd.a(3, eb.c(b), (new StringBuilder()).append("Prerender: HTTP status code is:").append(i).append(" for url: ").append(a).toString());
            if (gk1.c())
            {
                gk1 = cv.c(a);
                b.a(aw.f, Collections.emptyMap(), b.getAdController(), 0);
                fp.a().a(new eb._cls5._cls1(this, gk1, s));
                return;
            } else
            {
                fp.a().a(new eb._cls5._cls2());
                return;
            }
        }

            
            {
                b = eb1;
                a = s;
                super();
            }

        // Unreferenced inner class com/flurry/sdk/eb$5$2

/* anonymous class */
        class eb._cls5._cls2 extends hq
        {

            final eb._cls5 a;

            public void safeRun()
            {
                HashMap hashmap = new HashMap();
                hashmap.put("errorCode", Integer.toString(av.k.a()));
                a.b.a(aw.g, hashmap, a.b.getAdController(), 0);
            }

                    
                    {
                        a = eb._cls5.this;
                        super();
                    }
        }

    }

}
