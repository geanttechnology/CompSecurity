// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            NavigationFragment

final class a
    implements Runnable
{

    private NavigationFragment a;

    public final void run()
    {
        Activity activity = a.getActivity();
        Intent intent = new Intent();
        intent.setClassName(activity.getPackageName(), "com.socialin.android.preference.PreferencesActivity");
        a.startActivityForResult(intent, 101);
        AnalyticUtils.getInstance(activity).trackLocalAction("more:settings");
    }

    (NavigationFragment navigationfragment)
    {
        a = navigationfragment;
        super();
    }
}
