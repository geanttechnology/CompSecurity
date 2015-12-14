// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.database.ContentObserver;
import android.os.Handler;
import com.picsart.studio.view.SlidingTabLayout;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity, e

final class c extends ContentObserver
{

    private MainPagerActivity a;

    public c(MainPagerActivity mainpageractivity, Handler handler)
    {
        a = mainpageractivity;
        super(handler);
    }

    public final void onChange(boolean flag)
    {
        super.onChange(flag);
        if (MainPagerActivity.o(a) != null)
        {
            MainPagerActivity.o(a).notifyDataSetChanged();
        }
        if (MainPagerActivity.t(a) != null)
        {
            MainPagerActivity.t(a).setViewPager(MainPagerActivity.u(a));
            MainPagerActivity.t(a).invalidate();
        }
    }
}
