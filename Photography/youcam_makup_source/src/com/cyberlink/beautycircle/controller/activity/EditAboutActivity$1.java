// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditAboutActivity

class c extends AsyncTask
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
                d.runOnUiThread(new Runnable() {

                    final EditAboutActivity._cls1 a;

                    public void run()
                    {
                        a.d.e();
                    }

            
            {
                a = EditAboutActivity._cls1.this;
                super();
            }
                });
                return null;
            }
        } else
        {
            d.k();
            NetworkUser.a(AccountManager.b(), a, null, null, b, null, null, null, null, null, null, null, null, c).a(new m() {

                final EditAboutActivity._cls1 a;

                protected void a(int i)
                {
                    String s1;
                    a.d.l();
                    s1 = (new StringBuilder()).append(a.d.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_unknown_error)).append(s.a(i)).toString();
                    if (com.cyberlink.beautycircle.model.network.c.a()) goto _L2; else goto _L1
_L1:
                    s1 = (new StringBuilder()).append(a.d.getResources().getString(com.cyberlink.beautycircle.m.bc_register_error_network_unavailabe)).append(s.a(i)).toString();
_L4:
                    DialogUtils.a(a.d, null, s1, null, null, a.d.getResources().getString(com.cyberlink.beautycircle.m.bc_dialog_button_ok), null);
                    return;
_L2:
                    if (i != 445)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    s1 = (new StringBuilder()).append(a.d.getResources().getString(com.cyberlink.beautycircle.m.bc_user_profile_display_name_invalid)).append(s.a(i)).toString();
                    if (true) goto _L4; else goto _L3
_L3:
                    if (i != 420) goto _L4; else goto _L5
_L5:
                    EditAboutActivity.a(a.d, 48258);
                    return;
                }

                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                {
                    a.d.l();
                    updateuserresponse = AccountManager.b();
                    UserInfo userinfo = AccountManager.d();
                    userinfo.description = a.b;
                    userinfo.displayName = a.a;
                    userinfo.websiteUrl = a.c;
                    AccountManager.a(updateuserresponse, userinfo, false);
                    if (EditAboutActivity.a(a.d) == 1 || EditAboutActivity.a(a.d) == 5 || EditAboutActivity.a(a.d) == 8 || EditAboutActivity.a(a.d) == 6)
                    {
                        com.cyberlink.beautycircle.c.b(a.d, EditAboutActivity.a(a.d));
                        return;
                    } else
                    {
                        EditAboutActivity.a(a.d, -1, a.a, a.b, a.c, userinfo);
                        return;
                    }
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                }

            
            {
                a = EditAboutActivity._cls1.this;
                super();
            }
            });
            return null;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    _cls2.a(EditAboutActivity editaboutactivity, String s, String s1, String s2)
    {
        d = editaboutactivity;
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
