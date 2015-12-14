// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends m
{

    final a a;

    protected void a()
    {
        a.a.a.l();
    }

    protected void a(int i)
    {
        a.a.a.l();
        Globals.a(a.a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_server_connect_fail));
        e.e(new Object[] {
            "DeletePost: ", Integer.valueOf(i)
        });
    }

    protected void a(Void void1)
    {
        a.a.a.l();
        t.b.a();
        a.a.a.setResult(48257);
        WritePostActivity.c(a.a.a);
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/WritePostActivity$10

/* anonymous class */
    class WritePostActivity._cls10
        implements b
    {

        final WritePostActivity a;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            if (s != null)
            {
                DialogUtils.a(a, "", a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_delete_confirm_text), a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_cancel), null, a.getResources().getString(com.cyberlink.beautycircle.m.bc_post_delete), new WritePostActivity._cls10._cls1(this, s));
            }
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                a = writepostactivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/WritePostActivity$10$1

/* anonymous class */
    class WritePostActivity._cls10._cls1
        implements Runnable
    {

        final String a;
        final WritePostActivity._cls10 b;

        public void run()
        {
            b.a.k();
            NetworkPost.a(a, WritePostActivity.d(b.a)).a(new WritePostActivity._cls10._cls1._cls1(this));
        }

            
            {
                b = _pcls10;
                a = s;
                super();
            }
    }

}
