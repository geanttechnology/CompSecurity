// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ItemsResponse;
import com.offerup.android.dto.response.UserProfileResponse;

// Referenced classes of package com.offerup.android.activities:
//            UserDetailActivity

final class iq
{

    UserProfileResponse a;
    ItemsResponse b;

    public iq(UserDetailActivity userdetailactivity, UserProfileResponse userprofileresponse, ItemsResponse itemsresponse)
    {
        a = userprofileresponse;
        b = itemsresponse;
    }
}
