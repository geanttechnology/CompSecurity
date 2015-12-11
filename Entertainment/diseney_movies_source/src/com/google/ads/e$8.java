// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.view.View;
import com.google.ads.internal.d;
import com.google.ads.util.b;

// Referenced classes of package com.google.ads:
//            e, h, f

class nit>
    implements Runnable
{

    final h a;
    final View b;
    final f c;
    final e d;

    public void run()
    {
        if (e.a(d, a))
        {
            com.google.ads.util.b.a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
            return;
        } else
        {
            com.google.ads.e.b(d).a(b, a, c, false);
            return;
        }
    }

    rnal.d(e e1, h h, View view, f f)
    {
        d = e1;
        a = h;
        b = view;
        c = f;
        super();
    }
}
