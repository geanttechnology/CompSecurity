// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.flurry.sdk:
//            kb, lg, jb, kc, 
//            ka

class it>
    implements kb
{

    final jb a;

    public volatile void a(ka ka)
    {
        a((lg)ka);
    }

    public void a(lg lg1)
    {
        if (jb.a(a) != null && lg1.b != jb.a(a).get())
        {
            return;
        }
        switch (a[lg1.c.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a.a(lg1.b, (Context)lg1.a.get());
            return;

        case 2: // '\002'
            a.a((Context)lg1.a.get());
            return;

        case 3: // '\003'
            a.b((Context)lg1.a.get());
            return;

        case 4: // '\004'
            kc.a().b("com.flurry.android.sdk.FlurrySessionEvent", jb.b(a));
            break;
        }
        a.a(lg1.d);
    }

    ext(jb jb1)
    {
        a = jb1;
        super();
    }
}
