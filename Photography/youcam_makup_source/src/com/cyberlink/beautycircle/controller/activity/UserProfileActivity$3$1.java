// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            UserProfileActivity

class a
    implements Runnable
{

    final _cls1.a a;

    public void run()
    {
        a.a.k();
        NetworkUser.a(AccountManager.b()).a(new j() {

            final UserProfileActivity._cls3._cls1 a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected Void a(Void void1)
            {
                try
                {
                    AccountManager.a(true, false, Globals.c()).d();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1)
                {
                    void1.printStackTrace();
                }
                return null;
            }

            
            {
                a = UserProfileActivity._cls3._cls1.this;
                super();
            }
        }).a(new com.perfectcorp.utility.m() {

            final UserProfileActivity._cls3._cls1 a;

            protected void a()
            {
                Globals.a(a.a.a.getResources().getString(m.bc_user_log_out_fail));
                a.a.a.l();
                a.a.a.e();
            }

            protected void a(int i)
            {
                Globals.a(a.a.a.getResources().getString(m.bc_user_log_out_fail));
                a.a.a.l();
                a.a.a.e();
            }

            protected void a(Void void1)
            {
                a.a.a.l();
                a.a.a.e();
            }

            protected void b(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = UserProfileActivity._cls3._cls1.this;
                super();
            }
        });
    }

    _cls2.a(_cls2.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/UserProfileActivity$3

/* anonymous class */
    class UserProfileActivity._cls3
        implements android.view.View.OnClickListener
    {

        final UserProfileActivity a;

        public void onClick(View view)
        {
            DialogUtils.a(a, null, a.getResources().getString(m.bc_user_log_out_title_description), a.getResources().getString(m.bc_dialog_button_no), null, a.getResources().getString(m.bc_user_log_out_btn), new UserProfileActivity._cls3._cls1(this));
        }

            
            {
                a = userprofileactivity;
                super();
            }
    }

}
