// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.WeiboAccountInfo;
import com.cyberlink.beautycircle.utility.ah;
import com.cyberlink.beautycircle.utility.ai;
import com.perfectcorp.utility.j;
import com.sina.weibo.sdk.exception.WeiboException;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class b
    implements ai
{

    final UserInfo a;
    final String b;
    final RegisterActivity c;

    public void a()
    {
        (new AsyncTask() {

            final RegisterActivity._cls8 a;

            protected transient Void a(Void avoid[])
            {
                boolean flag1 = false;
                avoid = a.c.j.d();
                a.c.j.a(a.a);
                boolean flag = flag1;
                if (avoid != null)
                {
                    flag = flag1;
                    if (((WeiboAccountInfo) (avoid)).avatar_large != null)
                    {
                        flag = RegisterActivity.a(a.c, a.b, ((WeiboAccountInfo) (avoid)).avatar_large, a.a);
                    }
                }
                if (!flag)
                {
                    RegisterActivity.a(a.c, a.b, a.a, -1L, -1L);
                }
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = RegisterActivity._cls8.this;
                super();
            }
        }).executeOnExecutor(j.q, new Void[0]);
    }

    public void a(WeiboException weiboexception)
    {
        Globals.b(weiboexception.toString());
        RegisterActivity.b(c, b, a);
    }

    _cls1.a(RegisterActivity registeractivity, UserInfo userinfo, String s)
    {
        c = registeractivity;
        a = userinfo;
        b = s;
        super();
    }
}
