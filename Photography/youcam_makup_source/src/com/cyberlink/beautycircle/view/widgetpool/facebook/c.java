// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.facebook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.facebook.AppEventsLogger;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.internal.SessionTracker;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.facebook:
//            LoginButton, b

class c
    implements android.view.View.OnClickListener
{

    final LoginButton a;

    private c(LoginButton loginbutton)
    {
        a = loginbutton;
        super();
    }

    c(LoginButton loginbutton, LoginButton._cls1 _pcls1)
    {
        this(loginbutton);
    }

    public void onClick(View view)
    {
        Session session;
        android.content.Context context;
        context = a.getContext();
        session = LoginButton.a(a).getOpenSession();
        if (session == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        int i;
        if (LoginButton.d(a))
        {
            session.closeAndClearTokenInformation();
        } else
        {
            session.closeAndClearTokenInformation();
        }
_L4:
        obj = AppEventsLogger.newLogger(a.getContext());
        obj1 = new Bundle();
        if (session != null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        ((Bundle) (obj1)).putInt("logging_in", i);
        ((AppEventsLogger) (obj)).logSdkEvent(LoginButton.h(a), null, ((Bundle) (obj1)));
        if (LoginButton.i(a) != null)
        {
            LoginButton.i(a).onClick(view);
        }
        return;
_L2:
label0:
        {
            obj = LoginButton.a(a).getSession();
            if (obj != null)
            {
                obj1 = obj;
                if (!((Session) (obj)).getState().isClosed())
                {
                    break label0;
                }
            }
            LoginButton.a(a).setSession(null);
            obj1 = (new com.facebook.Session.Builder(context)).setApplicationId(LoginButton.e(a)).build();
            Session.setActiveSession(((Session) (obj1)));
        }
        if (!((Session) (obj1)).isOpened())
        {
            com.facebook.Session.OpenRequest openrequest;
            if (LoginButton.f(a) != null)
            {
                openrequest = new com.facebook.Session.OpenRequest(LoginButton.f(a));
            } else
            if (context instanceof Activity)
            {
                openrequest = new com.facebook.Session.OpenRequest((Activity)context);
            } else
            {
                openrequest = null;
            }
            if (openrequest != null)
            {
                openrequest.setDefaultAudience(b.a(LoginButton.g(a)));
                openrequest.setPermissions(b.b(LoginButton.g(a)));
                openrequest.setLoginBehavior(b.c(LoginButton.g(a)));
                if (SessionAuthorizationType.PUBLISH.equals(b.d(LoginButton.g(a))))
                {
                    ((Session) (obj1)).openForPublish(openrequest);
                } else
                {
                    ((Session) (obj1)).openForRead(openrequest);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
