// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            hq, ch, gk, gd, 
//            da, cy, ap, fp

class > extends hq
{

    final a a;

    public void safeRun()
    {
        ch.i(a.a);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/flurry/sdk/ch$11

/* anonymous class */
    class ch._cls11
        implements gk.a
    {

        final String a;
        final cy b;
        final int c;
        final ap d;
        final ch e;

        public volatile void a(gk gk1, Object obj)
        {
            a(gk1, (String)obj);
        }

        public void a(gk gk1, String s)
        {
            int i = gk1.e();
            gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver: HTTP status code is:").append(i).append(" for url: ").append(a).toString());
            cy cy1 = null;
            if (gk1.c())
            {
                gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver response:").append(s).append(" for url: ").append(a).toString());
                cy1 = cy.a(b, da.a(s));
            }
            if (cy1 == null)
            {
                gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver failed for frame: ").append(c).toString());
                d.a(c, (new cy.a()).a().b());
            } else
            {
                gd.a(3, ch.d(), (new StringBuilder()).append("VAST resolver successful for frame: ").append(c).toString());
                d.a(c, cy1);
            }
            fp.a().b(new ch._cls11._cls1(this));
        }

            
            {
                e = ch1;
                a = s;
                b = cy1;
                c = i;
                d = ap1;
                super();
            }
    }

}
