// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ItemsResponse;
import com.offerup.android.dto.response.UserProfileResponse;
import e.c.e;

// Referenced classes of package com.offerup.android.activities:
//            iq, UserDetailActivity

final class ij
    implements e
{

    private UserDetailActivity a;

    ij(UserDetailActivity userdetailactivity)
    {
        a = userdetailactivity;
        super();
    }

    public final Object a(Object obj, Object obj1)
    {
        obj = (ItemsResponse)obj;
        obj1 = (UserProfileResponse)obj1;
        return new iq(a, ((UserProfileResponse) (obj1)), ((ItemsResponse) (obj)));
    }
}
