// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.c;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseFbActivity

class d
    implements Runnable
{

    final Session a;
    final UserInfo b;
    final String c;
    final c d;
    final BaseFbActivity e;

    public void run()
    {
        Request.newMeRequest(a, new com.facebook.Request.GraphUserCallback() {

            final BaseFbActivity._cls2 a;

            public void onCompleted(GraphUser graphuser, Response response)
            {
                if (graphuser != null)
                {
                    graphuser = (String)graphuser.getProperty("email");
                    a.b.receiveEmail = graphuser;
                    NetworkUser.a(a.c, null, null, null, null, null, null, null, null, null, null, graphuser, null, null);
                    AccountManager.c(graphuser);
                    AccountManager.a(a.c, a.b, false);
                    if (a.d != null)
                    {
                        a.d.a();
                    }
                } else
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "Can't get GraphUser."
                    });
                    if (a.d != null)
                    {
                        a.d.b();
                        return;
                    }
                }
            }

            
            {
                a = BaseFbActivity._cls2.this;
                super();
            }
        }).executeAsync();
    }

    _cls1.a(BaseFbActivity basefbactivity, Session session, UserInfo userinfo, String s, c c1)
    {
        e = basefbactivity;
        a = session;
        b = userinfo;
        c = s;
        d = c1;
        super();
    }
}
