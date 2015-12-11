// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.dto.ItemsResponse;
import com.offerup.android.dto.UserProfileModel;
import com.offerup.android.dto.response.UserProfileResponse;
import com.offerup.android.g.u;
import com.offerup.android.utils.ba;
import e.j;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity, iq

final class ii extends j
{

    private UserDetailActivity a;

    ii(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    public final void a()
    {
        a.i();
    }

    public final void a(Object obj)
    {
        obj = (iq)obj;
        UserProfileModel userprofilemodel = ba.a(((iq) (obj)).a.getUserProfile());
        UserDetailActivity.a(a, ((iq) (obj)).b.getItems());
        UserDetailActivity.a(a, userprofilemodel.getName());
        UserDetailActivity.a(a, userprofilemodel.isVerifiedUser());
        if (UserDetailActivity.c(a))
        {
            UserDetailActivity.d(a).setText(a.getString(0x7f09020c));
        }
        UserDetailActivity.e(a);
        UserDetailActivity.f(a).a(userprofilemodel);
    }

    public final void a(Throwable throwable)
    {
        g.a(this, throwable);
        a.i();
        a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
    }
}
