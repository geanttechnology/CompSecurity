// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import android.util.Log;
import com.facebook.Session;
import com.facebook.SessionDefaultAudience;
import com.facebook.SessionLoginBehavior;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.Utility;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            LoginButton, d

class b
{

    private SessionDefaultAudience a;
    private List b;
    private SessionAuthorizationType c;
    private d d;
    private SessionLoginBehavior e;
    private com.facebook.Session.StatusCallback f;

    b()
    {
        a = SessionDefaultAudience.FRIENDS;
        b = Collections.emptyList();
        c = null;
        e = SessionLoginBehavior.SSO_WITH_FALLBACK;
    }

    static SessionDefaultAudience a(b b1)
    {
        return b1.a;
    }

    private boolean a(List list, SessionAuthorizationType sessionauthorizationtype, Session session)
    {
        if (SessionAuthorizationType.PUBLISH.equals(sessionauthorizationtype) && Utility.isNullOrEmpty(list))
        {
            throw new IllegalArgumentException("Permissions for publish actions cannot be null or empty.");
        }
        if (session != null && session.isOpened() && !Utility.isSubset(list, session.getPermissions()))
        {
            Log.e(LoginButton.c(), "Cannot set additional permissions when session is already open.");
            return false;
        } else
        {
            return true;
        }
    }

    static List b(b b1)
    {
        return b1.b;
    }

    static SessionLoginBehavior c(b b1)
    {
        return b1.e;
    }

    static SessionAuthorizationType d(b b1)
    {
        return b1.c;
    }

    static com.facebook.Session.StatusCallback e(b b1)
    {
        return b1.f;
    }

    static d f(b b1)
    {
        return b1.d;
    }

    public d a()
    {
        return d;
    }

    public void a(d d1)
    {
        d = d1;
    }

    public void a(com.facebook.Session.StatusCallback statuscallback)
    {
        f = statuscallback;
    }

    public void a(SessionDefaultAudience sessiondefaultaudience)
    {
        a = sessiondefaultaudience;
    }

    public void a(SessionLoginBehavior sessionloginbehavior)
    {
        e = sessionloginbehavior;
    }

    public void a(List list, Session session)
    {
        if (SessionAuthorizationType.PUBLISH.equals(c))
        {
            throw new UnsupportedOperationException("Cannot call setReadPermissions after setPublishPermissions has been called.");
        }
        if (a(list, SessionAuthorizationType.READ, session))
        {
            b = list;
            c = SessionAuthorizationType.READ;
        }
    }

    public SessionDefaultAudience b()
    {
        return a;
    }

    public void b(List list, Session session)
    {
        if (SessionAuthorizationType.READ.equals(c))
        {
            throw new UnsupportedOperationException("Cannot call setPublishPermissions after setReadPermissions has been called.");
        }
        if (a(list, SessionAuthorizationType.PUBLISH, session))
        {
            b = list;
            c = SessionAuthorizationType.PUBLISH;
        }
    }

    List c()
    {
        return b;
    }

    public SessionLoginBehavior d()
    {
        return e;
    }

    public com.facebook.Session.StatusCallback e()
    {
        return f;
    }
}
