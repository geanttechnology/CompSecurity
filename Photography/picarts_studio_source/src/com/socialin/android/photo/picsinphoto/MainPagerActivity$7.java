// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.FragmentManager;
import android.view.View;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.notifications.a;
import myobfuscated.cs.e;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class  extends android.support.v4.widget.rawerListener
{

    private MainPagerActivity a;

    public final void onDrawerClosed(View view)
    {
        super.onDrawerClosed(view);
        a.invalidateOptionsMenu();
    }

    public final void onDrawerOpened(View view)
    {
        super.onDrawerOpened(view);
        view = a.getFragmentManager().findFragmentByTag("notification.fragment");
        if (view != null && (view instanceof e))
        {
            ((e)view).g();
        }
        a.invalidateOptionsMenu();
        if (SocialinV3.getInstance().getUser() != null && SocialinV3.getInstance().getUser().id > 1L)
        {
            AnalyticUtils.getInstance(a.getApplicationContext()).track(new com.socialin.android.apiv3.events.cationsOpenEvent(SocialinV3.getInstance().getUser().id));
        }
        ((a)MainPagerActivity.f(a)).c();
    }

    nsOpenEvent(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
