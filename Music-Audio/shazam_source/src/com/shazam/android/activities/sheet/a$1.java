// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.sheet;

import com.shazam.android.fragment.g.b;
import com.shazam.model.analytics.AnalyticsInfo;
import java.util.ArrayList;

// Referenced classes of package com.shazam.android.activities.sheet:
//            a

final class b
    implements Runnable
{

    final int a = 0x7f090145;
    final ArrayList b;
    final AnalyticsInfo c = null;
    final a d;

    public final void run()
    {
        com.shazam.android.fragment.g.b.a(a, b, c).a(d.getSupportFragmentManager());
    }

    (a a1, ArrayList arraylist)
    {
        d = a1;
        b = arraylist;
        super();
    }
}
