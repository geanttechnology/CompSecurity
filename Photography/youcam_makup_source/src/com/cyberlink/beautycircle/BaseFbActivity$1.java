// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.facebook.Session;
import com.facebook.SessionState;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseFbActivity

class a
    implements com.facebook.lback
{

    final BaseFbActivity a;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        e.b(new Object[] {
            session, ", ", sessionstate, ", ", exception
        });
        a.a(session, sessionstate, exception);
    }

    (BaseFbActivity basefbactivity)
    {
        a = basefbactivity;
        super();
    }
}
