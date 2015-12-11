// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import com.offerup.android.activities.k;

// Referenced classes of package com.offerup.android.utils:
//            x, aa

final class z
    implements android.widget.AdapterView.OnItemClickListener
{

    final x a;
    private String b[];

    z(x x1, String as[])
    {
        a = x1;
        b = as;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        x.c(a).setTitle(b[i]);
        x.d(a).a();
        (new Handler()).postDelayed(new aa(this, i), 200L);
    }
}
