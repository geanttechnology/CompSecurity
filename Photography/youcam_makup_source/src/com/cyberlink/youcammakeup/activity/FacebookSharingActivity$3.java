// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements android.view.ebookSharingActivity._cls3
{

    final FacebookSharingActivity a;

    public void onClick(View view)
    {
        if (!FacebookSharingActivity.g(a))
        {
            FacebookSharingActivity.h(a);
            return;
        }
        FacebookSharingActivity.b(a, cebookAction.c);
        if (FacebookSharingActivity.b(a))
        {
            FacebookSharingActivity.d(a);
            return;
        } else
        {
            FacebookSharingActivity.i(a);
            return;
        }
    }

    cebookAction(FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
