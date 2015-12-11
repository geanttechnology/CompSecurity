// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity, il, im

final class ik
    implements android.view.View.OnClickListener
{

    final UserDetailActivity a;

    ik(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (!UserDetailActivity.g(a))
        {
            com.offerup.android.tracker.a.b("UserProfile_TruYouMemberInfo-Button_click");
            UserDetailActivity.h(a);
            UserDetailActivity.i(a).setOnClickListener(new il(this));
            UserDetailActivity.k(a).setOnClickListener(new im(this));
        }
    }
}
