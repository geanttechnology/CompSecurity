// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.c;

import android.support.v4.app.t;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.c:
//            h

final class k
    implements android.view.View.OnClickListener
{

    private h a;

    k(h h1)
    {
        a = h1;
        super();
    }

    public final void onClick(View view)
    {
        if (!com.offerup.android.g.c.h.a(a))
        {
            com.offerup.android.tracker.a.b("PostItem_DoneScreen_Done-Button_click");
        }
        a.getActivity().finish();
    }
}
