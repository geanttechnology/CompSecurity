// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bf, c, ar, br, 
//            bh

final class aq
    implements bf
{

    final c a;

    aq(c c1)
    {
        a = c1;
        super();
    }

    public final void a()
    {
        Date date = Calendar.getInstance().getTime();
        if (c.d(a).compareTo(date) > 0)
        {
            long l = c.d(a).getTime() - date.getTime();
            c.a();
            (new StringBuilder("Delaying ")).append(l).append(" milliseconds so user doesn't see flicker.");
            c.a(a, new Timer());
            c.f(a).schedule(new ar(this), l);
            return;
        } else
        {
            c.e(a);
            return;
        }
    }

    public final void a(bh bh)
    {
        br.a(a, bh);
    }
}
