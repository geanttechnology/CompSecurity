// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements android.view.bookSharingActivity._cls10
{

    final FacebookSharingActivity a;

    public void onClick(View view)
    {
        if (!FacebookSharingActivity.g(a))
        {
            FacebookSharingActivity.h(a);
            return;
        }
        if (!FacebookSharingActivity.b(a))
        {
            FacebookSharingActivity.b(a, ebookAction.a);
            FacebookSharingActivity.i(a);
            return;
        }
        if (!FacebookSharingActivity.e(a))
        {
            FacebookSharingActivity.b(a, ebookAction.a);
            FacebookSharingActivity.j(a);
            return;
        } else
        {
            FacebookSharingActivity.a(a, ebookAction.a);
            return;
        }
    }

    ebookAction(FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
