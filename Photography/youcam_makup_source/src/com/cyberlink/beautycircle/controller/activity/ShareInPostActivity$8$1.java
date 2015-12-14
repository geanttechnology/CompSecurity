// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.EditText;
import com.cyberlink.beautycircle.controller.a.j;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInPostActivity

class a extends m
{

    final  a;

    protected void a()
    {
        a.a.l();
        a(0x80000005);
    }

    protected void a(int i)
    {
        e.e(new Object[] {
            "NetworkPost.circleInPost fail: ", Integer.valueOf(i)
        });
        a.a.l();
        String s1 = (new StringBuilder()).append(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_write_post_message_create_post_fail)).append(s.a(i)).toString();
        DialogUtils.a(a.a, s1);
    }

    protected void a(com.cyberlink.beautycircle.model.network.Result result)
    {
        e.b(new Object[] {
            "NetworkPost.circleInPost done"
        });
        com.perfectcorp.a.b.a(new j("internal"));
        a.a.l();
        ShareInPostActivity.g(a.a);
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.network.Result)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ShareInPostActivity$8

/* anonymous class */
    class ShareInPostActivity._cls8
        implements com.cyberlink.beautycircle.utility.b
    {

        final ShareInPostActivity a;

        public void a()
        {
            e.b(new Object[] {
                "getAccountToken fail"
            });
            a.l();
            DialogUtils.a(a, com.cyberlink.beautycircle.m.bc_write_post_message_must_sign_in);
        }

        public void a(String s1)
        {
            if (ShareInPostActivity.f(a) == null)
            {
                a.l();
                DialogUtils.a(a, com.cyberlink.beautycircle.m.bc_write_post_message_need_circle);
                return;
            } else
            {
                NetworkPost.a(s1, ShareInPostActivity.h(a).postId, ShareInPostActivity.i(a).getText().toString(), ShareInPostActivity.f(a).id).a(new ShareInPostActivity._cls8._cls1(this));
                return;
            }
        }

        public void b()
        {
            e.b(new Object[] {
                "getAccountToken abort"
            });
            a.l();
            DialogUtils.a(a, com.cyberlink.beautycircle.m.bc_write_post_message_must_sign_in);
        }

            
            {
                a = shareinpostactivity;
                super();
            }
    }

}
