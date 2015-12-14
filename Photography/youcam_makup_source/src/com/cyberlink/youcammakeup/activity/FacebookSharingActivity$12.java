// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements android.view.bookSharingActivity._cls12
{

    final FacebookSharingActivity a;

    public void onClick(View view)
    {
        if (!FacebookSharingActivity.g(a))
        {
            FacebookSharingActivity.h(a);
            return;
        }
        if (FacebookSharingActivity.b(a))
        {
            FacebookSharingActivity.a(a, ebookAction.b);
            return;
        } else
        {
            FacebookSharingActivity.b(a, ebookAction.b);
            FacebookSharingActivity.i(a);
            return;
        }
    }

    ebookAction(FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
