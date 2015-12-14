// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            BeautyProfileActivity, b

class b
    implements Runnable
{

    final UserInfo a;
    final boolean b;
    final b c;

    public void run()
    {
        com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(c.c, a, b);
        AccountManager.d(AccountManager.b());
    }

    b(b b1, UserInfo userinfo, boolean flag)
    {
        c = b1;
        a = userinfo;
        b = flag;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/BeautyProfileActivity$4

/* anonymous class */
    class BeautyProfileActivity._cls4 extends AsyncTask
    {

        final BeautyProfileActivity a;

        protected transient b a(Void avoid[])
        {
            return a.o();
        }

        protected void a(b b1)
        {
            boolean flag2 = b1.a;
            boolean flag3 = b1.b;
            UserInfo userinfo = b1.c;
            b1 = b1.d;
            com.cyberlink.beautycircle.utility.AccountManager.AccountSource accountsource = AccountManager.f();
            boolean flag;
            boolean flag1;
            boolean flag4;
            boolean flag5;
            boolean flag6;
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 5 || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 6)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag && com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) != 7)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag4 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.b(a), a.a, flag1);
            flag5 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.c(a), a.a, flag);
            flag6 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.d(a), a.c, flag1);
            flag1 = com.cyberlink.beautycircle.a.a(BeautyProfileActivity.e(a), a.b, flag1);
            if (BeautyProfileActivity.f(a).getText().toString().equalsIgnoreCase(a.getResources().getString(m.bc_beauty_profile_birthday_hint)))
            {
                BeautyProfileActivity.f(a).setSelected(true);
            } else
            {
                BeautyProfileActivity.f(a).setSelected(false);
            }
            flag4 = flag4 & flag5 & flag6 & flag1;
            if (!flag)
            {
                (new Handler()).post(new BeautyProfileActivity._cls4._cls1(b1, flag4));
            }
            if (!flag4)
            {
                if (!flag1)
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_register_error_invalid_email_format), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
                    return;
                } else
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
                    return;
                }
            }
            if (!flag)
            {
                if (!flag2 || userinfo.name.length() == 0 || userinfo.phone.length() == 0 || userinfo.address.length() == 0 || accountsource != com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a && userinfo.receiveEmail.length() == 0)
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_continue), null);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                    AccountManager.d(AccountManager.b());
                    return;
                }
            }
            if (com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 7)
            {
                if (userinfo.birthDay == null || userinfo.name.length() == 0 || userinfo.phone.length() == 0 || accountsource != com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a && userinfo.receiveEmail.length() == 0)
                {
                    DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), null, null, a.getResources().getString(m.bc_dialog_button_continue), null);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                    AccountManager.d(AccountManager.b());
                    return;
                }
            }
            if (flag2 || com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a) == 8)
            {
                com.cyberlink.beautycircle.controller.activity.BeautyProfileActivity.a(a, userinfo, flag3);
                AccountManager.d(AccountManager.b());
                return;
            } else
            {
                DialogUtils.a(a, null, a.getResources().getString(m.bc_beauty_warning_message), a.getResources().getString(m.bc_dialog_button_skip), new BeautyProfileActivity._cls4._cls2(this, userinfo, flag3), a.getResources().getString(m.bc_dialog_button_continue), null);
                return;
            }
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((b)obj);
        }

            
            {
                a = beautyprofileactivity;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/BeautyProfileActivity$4$1

/* anonymous class */
        class BeautyProfileActivity._cls4._cls1
            implements Runnable
        {

            final View a;
            final boolean b;
            final BeautyProfileActivity._cls4 c;

            public void run()
            {
                if (a == null || !b)
                {
                    BeautyProfileActivity.g(c.a).scrollTo(0, 0);
                    return;
                } else
                {
                    BeautyProfileActivity.g(c.a).scrollTo(0, a.getTop());
                    return;
                }
            }

                    
                    {
                        c = BeautyProfileActivity._cls4.this;
                        a = view;
                        b = flag;
                        super();
                    }
        }

    }

}
