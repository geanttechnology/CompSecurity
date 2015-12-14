// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.Intent;
import com.socialin.android.picsart.profile.activity.AboutPicsartActivity;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            NavigationFragment

final class a
    implements Runnable
{

    private NavigationFragment a;

    public final void run()
    {
        Intent intent = new Intent(a.getActivity(), com/socialin/android/picsart/profile/activity/AboutPicsartActivity);
        a.startActivity(intent);
    }

    (NavigationFragment navigationfragment)
    {
        a = navigationfragment;
        super();
    }
}
