// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import ahy;
import android.app.Activity;
import qm;
import qn;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragmentContainer

class a
    implements Runnable
{

    final Activity a;
    final DNMListFragmentContainer b;

    public void run()
    {
        DNMListFragmentContainer.a(b, (new qn(a)).a(ahy.a).a(b).a(b).b());
        DNMListFragmentContainer.a(b).b();
        DNMListFragmentContainer.a(b, true);
    }

    (DNMListFragmentContainer dnmlistfragmentcontainer, Activity activity)
    {
        b = dnmlistfragmentcontainer;
        a = activity;
        super();
    }
}
