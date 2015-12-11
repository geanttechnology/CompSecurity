// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import kf;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

class a
    implements android.view.tener
{

    final HomeFragment a;

    public void onClick(View view)
    {
        view = ((BBYButton)view).getText().toString();
        if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080392)))
        {
            HomeFragment.b(a).setText(HomeFragment.a(a).getResources().getString(0x7f0801d1));
            HomeFragment.c(a).setText(HomeFragment.a(a).getResources().getString(0x7f08027a));
            HomeFragment.d(a).setText(HomeFragment.a(a).getResources().getString(0x7f080356));
        } else
        {
            if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080356)))
            {
                view = new Intent("android.intent.action.VIEW");
                view.setData(Uri.parse("market://details?id=com.bestbuy.android"));
                try
                {
                    a.startActivity(view);
                    HomeFragment.f(a).removeView(HomeFragment.e(a));
                    HomeFragment.a(a, false);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    kf.a("HomeFragment.java", view);
                }
                kf.e("HomeFragment.java", (new StringBuilder()).append("Not able to find Market Activity: ").append(view).toString());
                return;
            }
            if (view.equals(HomeFragment.a(a).getResources().getString(0x7f080283)))
            {
                view = a.f.l();
                view = (new StringBuilder()).append("Best Buy Mobile App Feedback v").append(view).toString();
                a.startActivity(a.a("onlinestore@bestbuy.com", view, ""));
                HomeFragment.f(a).removeView(HomeFragment.e(a));
                HomeFragment.a(a, false);
                return;
            }
        }
    }

    (HomeFragment homefragment)
    {
        a = homefragment;
        super();
    }
}
