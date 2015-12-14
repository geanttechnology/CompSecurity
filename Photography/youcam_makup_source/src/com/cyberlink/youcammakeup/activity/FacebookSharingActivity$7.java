// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.facebook.Session;
import com.facebook.SessionState;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements com.facebook.ebookSharingActivity._cls7
{

    final FacebookSharingActivity a;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        if (!session.getPermissions().contains("user_friends"))
        {
            m.b("FacebookSharingActivity", "Can't get the user_friends permission");
            FacebookSharingActivity.b(a, null);
        }
    }

    (FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
