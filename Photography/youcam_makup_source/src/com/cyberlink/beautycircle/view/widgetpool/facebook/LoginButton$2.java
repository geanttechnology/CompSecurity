// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import com.facebook.FacebookRequestError;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphUser;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            LoginButton, e

class a
    implements com.facebook.serCallback
{

    final Session a;
    final LoginButton b;

    public void onCompleted(GraphUser graphuser, Response response)
    {
        if (a == LoginButton.a(b).getOpenSession())
        {
            LoginButton.a(b, graphuser);
            if (LoginButton.b(b) != null)
            {
                LoginButton.b(b).a(LoginButton.c(b));
            }
        }
        if (response.getError() != null)
        {
            b.a(response.getError().getException());
        }
    }

    (LoginButton loginbutton, Session session)
    {
        b = loginbutton;
        a = session;
        super();
    }
}
