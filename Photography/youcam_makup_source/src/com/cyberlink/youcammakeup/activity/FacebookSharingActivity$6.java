// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.facebook.Session;
import com.facebook.SessionState;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements com.facebook.ebookSharingActivity._cls6
{

    final FacebookSharingActivity a;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        if (!FacebookSharingActivity.e(a))
        {
            FacebookSharingActivity.a(a, 0x7f07068e);
            FacebookSharingActivity.b(a, null);
        }
    }

    (FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
