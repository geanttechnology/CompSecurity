// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import android.content.Context;
import de.a.a.b;
import de.a.a.c;
import de.a.a.d;
import de.a.a.i;
import de.a.a.u;
import de.a.a.w;

// Referenced classes of package com.shazam.android.analytics.session:
//            AgofSession

public class AndroidAgofSession
    implements AgofSession
{

    public AndroidAgofSession()
    {
    }

    public void initSession(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("The context must not be null when initializing IOLSession");
        }
        if ("aadshaz".length() == 0)
        {
            throw new IllegalArgumentException("The offerIdentifier must not be null or an empty String when initializing IOLSession");
        }
        if (d.a == null)
        {
            d.a = new d(context, "aadshaz");
            i.a("aadshaz", "offerIdentifier");
            i.a(null, "hybridIdentifier");
            i.a(null, "customerData");
            w.b();
            w.d();
            w.d();
            context = d.a;
            if (!((d) (context)).k.isAlive())
            {
                ((d) (context)).k.start();
                context.a(new de.a.a.d._cls1(context));
                context.a(new de.a.a.d._cls6(context));
                w.b();
                context.e();
                context.a(true);
            }
        }
    }

    public void onActivityStart()
    {
        d d1 = d.a();
        d1.h = d1.h + 1;
        if (d1.i)
        {
            d1.a(new de.a.a.d._cls13(d1));
            d1.a(new de.a.a.d._cls12(d1));
            w.b();
            d1.e();
            if (d1.f)
            {
                d1.f = false;
                d1.a(new de.a.a.d._cls9(d1));
                u.a(c.a, null, null);
                d1.a(new de.a.a.d._cls16(d1));
            }
            u.a(c.c, null, null);
            d1.a(new de.a.a.d._cls14(d1));
            d1.a(new de.a.a.d._cls17(d1));
        }
        d1.i = false;
    }

    public void onActivityStop()
    {
        d d1 = d.a();
        d1.h = d1.h - 1;
        boolean flag;
        if (d1.h == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1.i = flag;
        if (d1.i)
        {
            d1.a(new de.a.a.d._cls2(d1));
            d1.a(new de.a.a.d._cls15(d1));
            u.a(c.b, null, null);
            d1.a(true);
            d1.a(new de.a.a.d._cls11(d1));
        }
    }

    public void sendLoggedEvents()
    {
        d.a().a(true);
    }

    public void viewAppeared(String s)
    {
        u.a(b.ac, i.a(s, "category"), i.a(null, "comment"));
    }
}
