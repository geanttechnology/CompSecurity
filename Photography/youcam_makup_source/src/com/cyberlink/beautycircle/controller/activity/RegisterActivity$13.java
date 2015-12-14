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

class b extends s
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

    public void a(com.cyberlink.beautycircle.utility.sult sult)
    {
        AsyncTask.execute(new Runnable(sult) {

            final com.cyberlink.beautycircle.utility.QQUtils.QQUserInfoResult a;
            final RegisterActivity._cls13 b;

            public void run()
            {
                QQUtils.a(a, b.a);
                boolean flag1 = false;
                boolean flag = flag1;
                if (a != null)
                {
                    flag = flag1;
                    if (a.figureurl_2 != null)
                    {
                        flag = RegisterActivity.a(b.c, b.b, a.figureurl_2.toString(), b.a);
                    }
                }
                if (!flag)
                {
                    RegisterActivity.a(b.c, b.b, b.a, -1L, -1L);
                }
            }

            
            {
                b = RegisterActivity._cls13.this;
                a = qquserinforesult;
                super();
            }
        });
    }

    public volatile void a(Model model)
    {
        a((com.cyberlink.beautycircle.utility.sult)model);
    }

    public void a(d d)
    {
        Globals.b(d.toString());
        RegisterActivity.b(c, b, a);
    }

    _cls1.a(RegisterActivity registeractivity, Class class1, UserInfo userinfo, String s1)
    {
        c = registeractivity;
        a = userinfo;
        b = s1;
        super(class1);
    }
}
