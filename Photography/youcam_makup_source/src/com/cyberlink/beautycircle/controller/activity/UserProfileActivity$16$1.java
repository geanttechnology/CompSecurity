// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class a extends AsyncTask
{

    final a a;

    protected transient UserInfo a(Void avoid[])
    {
        return AccountManager.d();
    }

    protected void a(UserInfo userinfo)
    {
        if (userinfo != null && userinfo.avatarUrl != null)
        {
            c.a(a.a, userinfo.avatarUrl);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((UserInfo)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$16

/* anonymous class */
    class UserProfileActivity._cls16
        implements android.view.View.OnClickListener
    {

        final UserProfileActivity a;

        public void onClick(View view)
        {
            (new UserProfileActivity._cls16._cls1(this)).executeOnExecutor(j.q, new Void[0]);
        }

            
            {
                a = userprofileactivity;
                super();
            }
    }

}
