// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.activity.FindFriendsActivity;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            NavigationFragment, au

final class a
    implements Runnable
{

    private NavigationFragment a;

    public final void run()
    {
label0:
        {
label1:
            {
                if (NavigationFragment.b(a) != 11)
                {
                    if (!SocialinV3.getInstance().isRegistered())
                    {
                        break label0;
                    }
                    if (NavigationFragment.c(a) == null)
                    {
                        break label1;
                    }
                    NavigationFragment.c(a).a(11);
                }
                return;
            }
            Activity activity = a.getActivity();
            Intent intent = new Intent(activity, com/socialin/android/picsart/profile/activity/FindFriendsActivity);
            if (activity.getIntent() != null && activity.getIntent().getExtras() != null)
            {
                intent.putExtras(activity.getIntent().getExtras());
            }
            activity.startActivity(intent);
            return;
        }
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.geOpenEvent("drawer", "find_friends"));
        NavigationFragment.a(a);
    }

    (NavigationFragment navigationfragment)
    {
        a = navigationfragment;
        super();
    }
}
