// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            NavigationFragment, au

final class a
    implements Runnable
{

    private NavigationFragment a;

    public final void run()
    {
        if (NavigationFragment.b(a) != 14)
        {
            if (NavigationFragment.c(a) != null)
            {
                NavigationFragment.c(a).a(14);
            } else
            {
                Activity activity = a.getActivity();
                if (activity != null && !activity.isFinishing())
                {
                    Intent intent = new Intent();
                    intent.setClassName(activity.getApplicationContext(), "com.picsart.shop.ShopActivity");
                    if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
                    {
                        intent.putExtras(activity.getIntent().getExtras());
                    }
                    activity.startActivity(intent);
                    return;
                }
            }
        }
    }

    (NavigationFragment navigationfragment)
    {
        a = navigationfragment;
        super();
    }
}
