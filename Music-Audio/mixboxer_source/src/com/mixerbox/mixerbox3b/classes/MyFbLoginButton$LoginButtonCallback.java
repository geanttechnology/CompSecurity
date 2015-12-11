// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import com.facebook.Session;
import com.facebook.SessionState;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyFbLoginButton

class <init>
    implements com.facebook.oginButtonCallback
{

    final MyFbLoginButton this$0;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        MyFbLoginButton.access$1300(MyFbLoginButton.this);
        MyFbLoginButton.access$1400(MyFbLoginButton.this);
        if (exception != null)
        {
            handleError(exception);
        }
        if (s.access._mth1500(MyFbLoginButton.access$800(MyFbLoginButton.this)) != null)
        {
            s.access._mth1500(MyFbLoginButton.access$800(MyFbLoginButton.this))._mth0(session, sessionstate, exception);
        }
    }

    private s()
    {
        this$0 = MyFbLoginButton.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
