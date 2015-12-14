// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            MainActivity

class a extends AsyncTask
{

    final MainActivity a;

    protected transient String a(Void avoid[])
    {
        return AccountManager.b();
    }

    protected void a(String s)
    {
        if (s == null)
        {
            Globals.b((new StringBuilder()).append("No Log-in, Locale(").append(AccountManager.a()).append(")").toString());
            return;
        }
        UserInfo userinfo = AccountManager.d();
        String s1 = "";
        s = s1;
        if (userinfo != null)
        {
            s = s1;
            if (userinfo.displayName != null)
            {
                s = userinfo.displayName;
            }
        }
        Globals.b((new StringBuilder()).append("Log-in(").append(s).append("), Locale(").append(AccountManager.a()).append(")").toString());
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    (MainActivity mainactivity)
    {
        a = mainactivity;
        super();
    }
}
