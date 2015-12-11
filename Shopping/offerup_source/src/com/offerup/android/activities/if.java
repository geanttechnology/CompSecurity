// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.h;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity

final class if
    implements h
{

    private boolean a;
    private int b;
    private CollapsingToolbarLayout c;
    private UserDetailActivity d;

    if(UserDetailActivity userdetailactivity, CollapsingToolbarLayout collapsingtoolbarlayout)
    {
        d = userdetailactivity;
        c = collapsingtoolbarlayout;
        super();
        b = -1;
    }

    public final void a(AppBarLayout appbarlayout, int i)
    {
        if (b == -1)
        {
            b = appbarlayout.getTotalScrollRange();
        }
        if (b + i <= 200)
        {
            c.setTitle(UserDetailActivity.a(d));
            a = true;
        } else
        if (a)
        {
            c.setTitle("");
            a = false;
            return;
        }
    }
}
