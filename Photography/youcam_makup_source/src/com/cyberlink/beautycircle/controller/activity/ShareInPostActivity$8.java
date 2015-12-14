// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.widget.EditText;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInPostActivity

class a
    implements b
{

    final ShareInPostActivity a;

    public void a()
    {
        e.b(new Object[] {
            "getAccountToken fail"
        });
        a.l();
        DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
    }

    public void a(String s)
    {
        if (ShareInPostActivity.f(a) == null)
        {
            a.l();
            DialogUtils.a(a, m.bc_write_post_message_need_circle);
            return;
        } else
        {
            NetworkPost.a(s, ShareInPostActivity.h(a).postId, ShareInPostActivity.i(a).getText().toString(), ShareInPostActivity.f(a).id).a(new com.perfectcorp.utility.m() {

                final ShareInPostActivity._cls8 a;

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
                    String s1 = (new StringBuilder()).append(a.a.getResources().getString(m.bc_write_post_message_create_post_fail)).append(com.cyberlink.beautycircle.model.network.s.a(i)).toString();
                    DialogUtils.a(a.a, s1);
                }

                protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CircleInPostResult circleinpostresult)
                {
                    e.b(new Object[] {
                        "NetworkPost.circleInPost done"
                    });
                    com.perfectcorp.a.b.a(new com.cyberlink.beautycircle.controller.a.j("internal"));
                    a.a.l();
                    ShareInPostActivity.g(a.a);
                }

                protected void b(Object obj)
                {
                    a((com.cyberlink.beautycircle.model.network.NetworkPost.CircleInPostResult)obj);
                }

            
            {
                a = ShareInPostActivity._cls8.this;
                super();
            }
            });
            return;
        }
    }

    public void b()
    {
        e.b(new Object[] {
            "getAccountToken abort"
        });
        a.l();
        DialogUtils.a(a, m.bc_write_post_message_must_sign_in);
    }

    _cls1.a(ShareInPostActivity shareinpostactivity)
    {
        a = shareinpostactivity;
        super();
    }
}
