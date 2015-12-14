// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.text.TextUtils;
import com.socialin.android.apiv3.controllers.BaseSocialinApiRequestController;
import com.socialin.android.apiv3.request.GetUsersParams;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            ShareGroupActivity

final class a
    implements Runnable
{

    private String a;
    private ShareGroupActivity b;

    public final void run()
    {
        ShareGroupActivity.b(b, a);
        if (!TextUtils.isEmpty(ShareGroupActivity.c(b)))
        {
            ShareGroupActivity sharegroupactivity = b;
            AnalyticUtils.getInstance(sharegroupactivity).track(new com.socialin.android.apiv3.events.vent(null, sharegroupactivity.getClass().getSimpleName(), sharegroupactivity.c));
            sharegroupactivity.b.query = sharegroupactivity.c;
            sharegroupactivity.a.doRequest("SearchGroup", sharegroupactivity.b);
        }
    }

    ller(ShareGroupActivity sharegroupactivity, String s)
    {
        b = sharegroupactivity;
        a = s;
        super();
    }
}
