// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import com.socialin.android.photo.picsinphoto.MainPagerActivity;
import com.socialin.android.photo.picsinphoto.e;

public class au
{

    public MainPagerActivity a;

    public au(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }

    public void a(int i)
    {
        if (i == 11)
        {
            MainPagerActivity.n(a);
            MainPagerActivity.o(a).a(false);
        } else
        {
            if (i == 13)
            {
                MainPagerActivity.a(a, true);
                MainPagerActivity.p(a);
                return;
            }
            if (i == 14)
            {
                MainPagerActivity.q(a);
                MainPagerActivity.o(a).a(false);
                return;
            }
        }
    }
}
