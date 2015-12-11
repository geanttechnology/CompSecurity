// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.webkit.WebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            hq, av, aw, eb, 
//            gk, gd, cv, fp

class t> extends hq
{

    final dController a;

    public void safeRun()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("errorCode", Integer.toString(av.k.a()));
        a.a.a(aw.g, hashmap, a.a.getAdController(), 0);
    }

    >(> >)
    {
        a = >;
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
                fp.a().a(new eb._cls5._cls1(gk1, s));
                return;
            } else
            {
                fp.a().a(new eb._cls5._cls2(this));
                return;
            }
        }

            
            {
                b = eb1;
                a = s;
                super();
            }

        // Unreferenced inner class com/flurry/sdk/eb$5$1

/* anonymous class */
        class eb._cls5._cls1 extends hq
        {

            final String a;
            final String b;
            final eb._cls5 c;

            public void safeRun()
            {
                if (eb.d(c.b) != null)
                {
                    eb.d(c.b).loadDataWithBaseURL(a, b, "text/html", "utf-8", a);
                }
            }

                    
                    {
                        c = eb._cls5.this;
                        a = s;
                        b = s1;
                        super();
                    }
        }

    }

}
