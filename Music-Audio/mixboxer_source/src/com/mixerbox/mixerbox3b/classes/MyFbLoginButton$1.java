// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import com.facebook.FacebookRequestError;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.internal.SessionTracker;
import com.facebook.model.GraphUser;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyFbLoginButton

class val.currentSession
    implements com.facebook.allback
{

    final MyFbLoginButton this$0;
    final Session val$currentSession;

    public void onCompleted(GraphUser graphuser, Response response)
    {
        if (val$currentSession == MyFbLoginButton.access$200(MyFbLoginButton.this).getOpenSession())
        {
            MyFbLoginButton.access$302(MyFbLoginButton.this, graphuser);
            if (MyFbLoginButton.access$400(MyFbLoginButton.this) != null)
            {
                MyFbLoginButton.access$400(MyFbLoginButton.this).onUserInfoFetched(MyFbLoginButton.access$300(MyFbLoginButton.this));
            }
        }
        if (response.getError() != null)
        {
            handleError(response.getError().getException());
        }
    }

    erInfoChangedCallback()
    {
        this$0 = final_myfbloginbutton;
        val$currentSession = Session.this;
        super();
    }
}
