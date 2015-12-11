// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import com.google.analytics.tracking.android.ai;
import com.google.analytics.tracking.android.aj;
import com.google.analytics.tracking.android.aq;
import com.google.analytics.tracking.android.ay;
import java.util.TimerTask;

// Referenced classes of package com.wishabi.flipp.b:
//            a

final class i extends TimerTask
{

    final String a;
    final a b;

    i(a a1, String s)
    {
        b = a1;
        a = s;
        super();
    }

    public final void run()
    {
        ay ay1 = com.wishabi.flipp.b.a.j(b);
        ai.a().a(aj.ak);
        aq aq1 = new aq();
        aq1.a("&t", "appview");
        ay1.a(aq1.a("&cd", a).a());
    }
}
