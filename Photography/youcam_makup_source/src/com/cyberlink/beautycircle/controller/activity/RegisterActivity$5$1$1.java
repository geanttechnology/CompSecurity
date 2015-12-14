// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.i;
import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.model.GraphUser;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a extends AsyncTask
{

    final GraphUser a;
    final a b;

    protected transient Void a(Void avoid[])
    {
        b.b.b.displayName = a.getName();
        avoid = (String)a.getProperty("email");
        b.b.b.receiveEmail = avoid;
        AccountManager.c(avoid);
        avoid = (String)a.getProperty("gender");
        if (avoid == null) goto _L2; else goto _L1
_L1:
        if (!avoid.equals("male")) goto _L4; else goto _L3
_L3:
        b.b.b.gender = "Male";
_L2:
        avoid = i.a(a.getBirthday(), "MM/dd/yyyy", "yyyy-MM-dd");
        b.b.b.birthDay = avoid;
        b.b.b.description = (String)a.getProperty("bio");
        avoid = a.getId();
        avoid = (new StringBuilder()).append("http://graph.facebook.com/").append(avoid).append("/picture?width=").append(320).append("&height=").append(320).toString();
        if (!RegisterActivity.a(b.b.b, b.b.b, avoid, b.b.b))
        {
            RegisterActivity.a(b.b.b, b.b.b, b.b.b, -1L, -1L);
        }
        return null;
_L4:
        if (avoid.equals("female"))
        {
            b.b.b.gender = "Female";
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    ( , GraphUser graphuser)
    {
        b = ;
        a = graphuser;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$5

/* anonymous class */
    class RegisterActivity._cls5
        implements Runnable
    {

        final Session a;
        final UserInfo b;
        final String c;
        final RegisterActivity d;

        public void run()
        {
            Request.newMeRequest(a, new RegisterActivity._cls5._cls1(this)).executeAsync();
        }

            
            {
                d = registeractivity;
                a = session;
                b = userinfo;
                c = s;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$5$1

/* anonymous class */
    class RegisterActivity._cls5._cls1
        implements com.facebook.Request.GraphUserCallback
    {

        final RegisterActivity._cls5 a;

        public void onCompleted(GraphUser graphuser, Response response)
        {
            if (graphuser != null)
            {
                (new RegisterActivity._cls5._cls1._cls1(this, graphuser)).executeOnExecutor(j.q, new Void[0]);
                return;
            } else
            {
                e.b(new Object[] {
                    "Can't get GraphUser."
                });
                return;
            }
        }

            
            {
                a = _pcls5;
                super();
            }
    }

}
