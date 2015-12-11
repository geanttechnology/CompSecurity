// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.c:
//            l

final class n
    implements android.view.View.OnClickListener
{

    private l a;

    n(l l1)
    {
        a = l1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.a("ou_item_post_camera", null);
        com.offerup.android.g.c.l.a(a);
    }
}
