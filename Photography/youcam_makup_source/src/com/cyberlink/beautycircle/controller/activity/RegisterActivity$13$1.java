// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.QQUtils;
import com.cyberlink.beautycircle.utility.s;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import com.tencent.tauth.d;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements Runnable
{

    final com.cyberlink.beautycircle.utility.lt a;
    final b b;

    public void run()
    {
        QQUtils.a(a, b.b);
        boolean flag1 = false;
        boolean flag = flag1;
        if (a != null)
        {
            flag = flag1;
            if (a.figureurl_2 != null)
            {
                flag = RegisterActivity.a(b.b, b.b, a.figureurl_2.toString(), b.b);
            }
        }
        if (!flag)
        {
            RegisterActivity.a(b.b, b.b, b.b, -1L, -1L);
        }
    }

    ( , com.cyberlink.beautycircle.utility.lt lt)
    {
        b = ;
        a = lt;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$13

/* anonymous class */
    class RegisterActivity._cls13 extends s
    {

        final UserInfo a;
        final String b;
        final RegisterActivity c;

        public void a()
        {
            e.c(new Object[] {
                "QQ getUserInfo: Cancel"
            });
        }

        public void a(com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult qquserinforesult)
        {
            AsyncTask.execute(new RegisterActivity._cls13._cls1(this, qquserinforesult));
        }

        public volatile void a(Model model)
        {
            a((com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult)model);
        }

        public void a(d d)
        {
            Globals.b(d.toString());
            RegisterActivity.b(c, b, a);
        }

            
            {
                c = registeractivity;
                a = userinfo;
                b = s1;
                super(class1);
            }
    }

}
