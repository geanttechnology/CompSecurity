// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.app.Activity;
import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class a extends m
{

    final a a;

    public void a(int i)
    {
    }

    public void a(Void void1)
    {
        t.b.a();
        a.a.a.d(a.a.a);
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$3

/* anonymous class */
    class a._cls3
        implements b
    {

        final Post a;
        final a b;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            if (s != null)
            {
                DialogUtils.a(b.c, "", b.c.getResources().getString(com.cyberlink.beautycircle.m.bc_post_delete_confirm_text), b.c.getResources().getString(com.cyberlink.beautycircle.m.bc_post_cancel), new a._cls3._cls1(), b.c.getResources().getString(com.cyberlink.beautycircle.m.bc_post_delete), new a._cls3._cls2(this, s));
            }
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                b = a1;
                a = post;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$3$1

/* anonymous class */
        class a._cls3._cls1
            implements Runnable
        {

            final a._cls3 a;

            public void run()
            {
            }

                    
                    {
                        a = a._cls3.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/adapter/a$3$2

/* anonymous class */
    class a._cls3._cls2
        implements Runnable
    {

        final String a;
        final a._cls3 b;

        public void run()
        {
            NetworkPost.a(a, b.a.postId).a(new a._cls3._cls2._cls1(this));
        }

            
            {
                b = _pcls3;
                a = s;
                super();
            }
    }

}
