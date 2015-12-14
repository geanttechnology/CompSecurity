// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$37

/* anonymous class */
    class g._cls37
        implements b
    {

        final g a;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            if (s != null)
            {
                DialogUtils.a(a.b, "", a.b.getResources().getString(m.bc_post_delete_confirm_text), a.b.getResources().getString(m.bc_post_cancel), new g._cls37._cls1(this), a.b.getResources().getString(m.bc_post_delete), new g._cls37._cls2(s));
            }
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                a = g1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$37$2

/* anonymous class */
        class g._cls37._cls2
            implements Runnable
        {

            final String a;
            final g._cls37 b;

            public void run()
            {
                b.a.b.k();
                NetworkContest.c(Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(b.a)));
                NetworkPost.a(a, Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(b.a))).a(new g._cls37._cls2._cls1(this));
            }

                    
                    {
                        b = g._cls37.this;
                        a = s;
                        super();
                    }
        }


        // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$37$2$1

/* anonymous class */
        class g._cls37._cls2._cls1 extends com.perfectcorp.utility.m
        {

            final g._cls37._cls2 a;

            protected void a()
            {
                a.b.a.b.l();
            }

            protected void a(int i)
            {
                a.b.a.b.l();
                Globals.a(a.b.a.b.getResources().getString(m.bc_server_connect_fail));
                e.e(new Object[] {
                    "DeletePost: ", Integer.valueOf(i)
                });
            }

            protected void a(Void void1)
            {
                a.b.a.b.l();
                t.b.a();
                PostActivity.r(a.b.a.b);
            }

            protected void b(Object obj)
            {
                a((Void)obj);
            }

                    
                    {
                        a = _pcls2;
                        super();
                    }
        }

    }

}
