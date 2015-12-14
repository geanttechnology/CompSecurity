// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import com.facebook.Session;
import com.facebook.SessionState;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements com.facebook.ebookSharingActivity._cls1
{

    final FacebookSharingActivity a;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        FacebookSharingActivity.a(a);
        if (session != null)
        {
            session = session.getPermissions();
            if (session != null)
            {
                for (session = session.iterator(); session.hasNext(); m.b("FacebookSharingActivity", (new StringBuilder()).append("mStatusCallback, permission=").append(exception).toString()))
                {
                    exception = (String)session.next();
                }

            }
        }
        if (!FacebookSharingActivity.b(a) || FacebookSharingActivity.c(a) == null) goto _L2; else goto _L1
_L1:
        if (FacebookSharingActivity.c(a) != cebookAction.a) goto _L4; else goto _L3
_L3:
        FacebookSharingActivity.a(a, cebookAction.a);
_L6:
        return;
_L4:
        if (FacebookSharingActivity.c(a) == cebookAction.b)
        {
            FacebookSharingActivity.a(a, cebookAction.b);
            return;
        }
        if (FacebookSharingActivity.c(a) == cebookAction.c)
        {
            FacebookSharingActivity.d(a);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (sessionstate == SessionState.CLOSED_LOGIN_FAILED)
        {
            a.finish();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    cebookAction(FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
