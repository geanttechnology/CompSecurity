// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.instagram;

import android.app.Activity;
import android.widget.GridView;
import java.util.List;
import myobfuscated.bx.a;

// Referenced classes of package com.socialin.android.instagram:
//            d

final class a
    implements Runnable
{

    private List a;
    private d b;

    public final void run()
    {
        if (b.getActivity() == null || b.getActivity().isFinishing())
        {
            return;
        }
        d d1 = b;
        android.widget.ListAdapter listadapter;
        if (d.b(b).getAdapter() instanceof a)
        {
            listadapter = d.b(b).getAdapter();
        } else
        {
            listadapter = null;
        }
        com.socialin.android.instagram.d.a(d1, (a)listadapter);
        if (d.i(b) == null)
        {
            d.j(b);
            com.socialin.android.instagram.d.a(b, new a(b.getActivity().getApplicationContext(), a, d.k(b)));
            d.l(b);
        }
        d.i(b).notifyDataSetChanged();
    }

    (d d1, List list)
    {
        b = d1;
        a = list;
        super();
    }
}
