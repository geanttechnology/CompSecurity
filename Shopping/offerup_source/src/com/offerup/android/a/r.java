// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.view.View;
import com.offerup.android.activities.ExploreActivity;

// Referenced classes of package com.offerup.android.a:
//            q

final class r
    implements android.view.View.OnClickListener
{

    private int a;
    private q b;

    r(q q1, int i)
    {
        b = q1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        q.a(b).b(a);
    }
}
