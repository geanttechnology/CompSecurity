// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.s;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.l();
        WritePostActivity.a(a.a, false);
        Globals.a(a.a.getResources().getString(m.bc_write_post_edit_success));
        t.b.a();
        WritePostActivity.b(a.a, true);
    }

    t(t t1)
    {
        a = t1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/WritePostActivity$5

/* anonymous class */
    class WritePostActivity._cls5 extends com.perfectcorp.utility.m
    {

        final WritePostActivity a;

        protected void a()
        {
            e.b(new Object[] {
                "Requesting updatePosts cancelled."
            });
            a.l();
            WritePostActivity.a(a, false);
        }

        protected void a(int i)
        {
            e.e(new Object[] {
                "Requesting updatePosts error:", Integer.valueOf(i)
            });
            String s1 = (new StringBuilder()).append(a.getResources().getString(m.bc_write_post_message_edit_post_fail)).append(s.a(i)).toString();
            DialogUtils.a(a, s1);
            a.l();
            WritePostActivity.a(a, false);
        }

        protected void a(com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult createpostsresult)
        {
            e.b(new Object[] {
                "updatePosts success"
            });
            a.a(m.bc_write_post_dialog_title, Float.valueOf(1.0F), WritePostActivity.x(a), new WritePostActivity._cls5._cls1(this));
        }

        protected void b(Object obj)
        {
            a((com.cyberlink.beautycircle.model.network.NetworkPost.CreatePostsResult)obj);
        }

            
            {
                a = writepostactivity;
                super();
            }
    }

}
