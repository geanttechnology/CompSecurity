// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import com.facebook.Session;
import com.facebook.SessionState;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            LoginButton, b

class a
    implements com.facebook.Session.StatusCallback
{

    final LoginButton a;

    private a(LoginButton loginbutton)
    {
        a = loginbutton;
        super();
    }

    a(LoginButton loginbutton, LoginButton._cls1 _pcls1)
    {
        this(loginbutton);
    }

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        LoginButton.j(a);
        if (b.e(LoginButton.g(a)) != null)
        {
            b.e(LoginButton.g(a)).call(session, sessionstate, exception);
        } else
        if (exception != null)
        {
            a.a(exception);
            return;
        }
    }
}
