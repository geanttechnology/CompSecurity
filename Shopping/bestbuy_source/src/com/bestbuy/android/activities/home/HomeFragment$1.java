// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

class a
    implements android.view.tener
{

    final HomeFragment a;

    public void onClick(View view)
    {
        view = ((BBYButton)view).getText().toString();
        if (view.equals(HomeFragment.a(a).getResources().getString(0x7f08027b)))
        {
            HomeFragment.b(a).setText(HomeFragment.a(a).getResources().getString(0x7f08032c));
            HomeFragment.c(a).setText(HomeFragment.a(a).getResources().getString(0x7f080275));
            HomeFragment.d(a).setText(HomeFragment.a(a).getResources().getString(0x7f080283));
        } else
        if (view.equals(HomeFragment.a(a).getResources().getString(0x7f08027a)) || view.equals(HomeFragment.a(a).getResources().getString(0x7f080275)))
        {
            HomeFragment.f(a).removeView(HomeFragment.e(a));
            HomeFragment.a(a, true);
            return;
        }
    }

    (HomeFragment homefragment)
    {
        a = homefragment;
        super();
    }
}
