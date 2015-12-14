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

class a extends AsyncTask
{

    final a a;

    protected transient Void a(Void avoid[])
    {
        boolean flag1 = false;
        avoid = a.a.j.d();
        a.a.j.a(a.a);
        boolean flag = flag1;
        if (avoid != null)
        {
            flag = flag1;
            if (((WeiboAccountInfo) (avoid)).avatar_large != null)
            {
                flag = RegisterActivity.a(a.a, a.a, ((WeiboAccountInfo) (avoid)).avatar_large, a.a);
            }
        }
        if (!flag)
        {
            RegisterActivity.a(a.a, a.a, a.a, -1L, -1L);
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    I(I i)
    {
        a = i;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/RegisterActivity$8

/* anonymous class */
    class RegisterActivity._cls8
        implements ai
    {

        final UserInfo a;
        final String b;
        final RegisterActivity c;

        public void a()
        {
            (new RegisterActivity._cls8._cls1(this)).executeOnExecutor(j.q, new Void[0]);
        }

        public void a(WeiboException weiboexception)
        {
            Globals.b(weiboexception.toString());
            RegisterActivity.b(c, b, a);
        }

            
            {
                c = registeractivity;
                a = userinfo;
                b = s;
                super();
            }
    }

}
