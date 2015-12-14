// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.support.v7.widget.SearchView;
import android.view.View;
import com.picsart.studio.utils.d;
import java.util.List;

// Referenced classes of package com.picsart.studio.activity:
//            b, MapActivity

final class c
    implements android.view..OnClickListener
{

    private int a;
    private double b;
    private double c;
    private b d;

    public final void onClick(View view)
    {
        MapActivity.i(d.a).clearFocus();
        MapActivity.a(d.a, (d)MapActivity.m(d.a).get(a));
        view = d;
        view.changeCursor(null);
        view.notifyDataSetChanged();
        MapActivity.a(d.a, b, c);
    }

    View(b b1, int i, double d1, double d2)
    {
        d = b1;
        a = i;
        b = d1;
        c = d2;
        super();
    }
}
