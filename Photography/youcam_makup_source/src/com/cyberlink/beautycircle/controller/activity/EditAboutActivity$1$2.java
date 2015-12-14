// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.c;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        String s1;
        a.a.l();
        s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_unknown_error)).append(s.a(i)).toString();
        if (c.a()) goto _L2; else goto _L1
_L1:
        s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
_L4:
        DialogUtils.a(a.a, null, s1, null, null, a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok), null);
        return;
_L2:
        if (i != 445)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_display_name_invalid)).append(s.a(i)).toString();
        if (true) goto _L4; else goto _L3
_L3:
        if (i != 420) goto _L4; else goto _L5
_L5:
        EditAboutActivity.a(a.a, 48258);
        return;
    }

    protected void a(com.cyberlink.beautycircle.model.ponse ponse)
    {
        a.a.l();
        ponse = AccountManager.b();
        UserInfo userinfo = AccountManager.d();
        userinfo.description = a.a;
        userinfo.displayName = a.a;
        userinfo.websiteUrl = a.a;
        AccountManager.a(ponse, userinfo, false);
        if (EditAboutActivity.a(a.a) == 1 || EditAboutActivity.a(a.a) == 5 || EditAboutActivity.a(a.a) == 8 || EditAboutActivity.a(a.a) == 6)
        {
            com.cyberlink.beautycircle.c.b(a.a, EditAboutActivity.a(a.a));
            return;
        } else
        {
            EditAboutActivity.a(a.a, -1, a.a, a.a, a.a, userinfo);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.ponse)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/EditAboutActivity$1

/* anonymous class */
    class EditAboutActivity._cls1 extends AsyncTask
    {

        final String a;
        final String b;
        final String c;
        final EditAboutActivity d;

        protected transient Void a(Void avoid[])
        {
            avoid = AccountManager.d();
            if (avoid == null)
            {
                return null;
            }
            if (((UserInfo) (avoid)).displayName != null && ((UserInfo) (avoid)).displayName.equals(a) && (((UserInfo) (avoid)).description != null && ((UserInfo) (avoid)).description.equals(b) || ((UserInfo) (avoid)).description == null && b.isEmpty()) && ((UserInfo) (avoid)).websiteUrl != null && ((UserInfo) (avoid)).websiteUrl.equals(c))
            {
                if (EditAboutActivity.a(d) == 1 || EditAboutActivity.a(d) == 5 || EditAboutActivity.a(d) == 8 || EditAboutActivity.a(d) == 6)
                {
                    com.cyberlink.beautycircle.c.b(d, EditAboutActivity.a(d));
                    return null;
                } else
                {
                    d.runOnUiThread(new EditAboutActivity._cls1._cls1());
                    return null;
                }
            } else
            {
                d.k();
                NetworkUser.a(AccountManager.b(), a, null, null, b, null, null, null, null, null, null, null, null, c).a(new EditAboutActivity._cls1._cls2(this));
                return null;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

            
            {
                d = editaboutactivity;
                a = s1;
                b = s2;
                c = s3;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/EditAboutActivity$1$1

/* anonymous class */
        class EditAboutActivity._cls1._cls1
            implements Runnable
        {

            final EditAboutActivity._cls1 a;

            public void run()
            {
                a.d.e();
            }

                    
                    {
                        a = EditAboutActivity._cls1.this;
                        super();
                    }
        }

    }

}
