// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import io.branch.referral.i;
import io.branch.referral.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements i
{

    private MainPagerActivity a;

    public final void a(JSONObject jsonobject, m m)
    {
        if (m == null && "ad_remover".equals(jsonobject.optString("campaign")))
        {
            com.socialin.android.photo.picsinphoto.MainPagerActivity.m(a);
        }
    }

    A(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
