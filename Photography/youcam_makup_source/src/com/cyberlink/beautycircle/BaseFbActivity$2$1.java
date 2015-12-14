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

class a
    implements com.facebook.llback
{

    final a a;

    public void onCompleted(GraphUser graphuser, Response response)
    {
        if (graphuser != null)
        {
            graphuser = (String)graphuser.getProperty("email");
            a.a.receiveEmail = graphuser;
            NetworkUser.a(a.a, null, null, null, null, null, null, null, null, null, null, graphuser, null, null);
            AccountManager.c(graphuser);
            AccountManager.a(a.a, a.a, false);
            if (a.a != null)
            {
                a.a.a();
            }
        } else
        {
            e.b(new Object[] {
                "Can't get GraphUser."
            });
            if (a.a != null)
            {
                a.a.b();
                return;
            }
        }
    }

    ger(ger ger)
    {
        a = ger;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/BaseFbActivity$2

/* anonymous class */
    class BaseFbActivity._cls2
        implements Runnable
    {

        final Session a;
        final UserInfo b;
        final String c;
        final c d;
        final BaseFbActivity e;

        public void run()
        {
            Request.newMeRequest(a, new BaseFbActivity._cls2._cls1(this)).executeAsync();
        }

            
            {
                e = basefbactivity;
                a = session;
                b = userinfo;
                c = s;
                d = c1;
                super();
            }
    }

}
