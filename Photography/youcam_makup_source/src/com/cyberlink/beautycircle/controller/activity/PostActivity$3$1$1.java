// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        c.a(a.a.a, g.a(a.a), true, 2);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$3

/* anonymous class */
    class PostActivity._cls3
        implements android.view.View.OnClickListener
    {

        final PostActivity a;

        public void onClick(View view)
        {
            view = (g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(PostActivity.d(a)));
            if (view == null)
            {
                return;
            }
            aq.c = "comment";
            String s = PostActivity.a(a, g.a(view));
            if (s != null)
            {
                b.a(new e(s, 0L, "comment", PostActivity.f(a), 0L));
            }
            b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(g.a(view).creator.userId), 0L));
            if (((g) (view)).a > 0)
            {
                c.a(a, g.a(view), false, 2);
                return;
            } else
            {
                AccountManager.a(a, new PostActivity._cls3._cls1(this, view));
                return;
            }
        }

            
            {
                a = postactivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$3$1

/* anonymous class */
    class PostActivity._cls3._cls1
        implements com.cyberlink.beautycircle.utility.b
    {

        final g a;
        final PostActivity._cls3 b;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            b.a.runOnUiThread(new PostActivity._cls3._cls1._cls1(this));
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                b = _pcls3;
                a = g1;
                super();
            }
    }

}
