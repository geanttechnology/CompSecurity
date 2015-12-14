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
import com.cyberlink.beautycircle.utility.b;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a
    implements b
{

    final g a;
    final a b;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        b.b.runOnUiThread(new Runnable() {

            final PostActivity._cls4._cls1 a;

            public void run()
            {
                c.a(a.b.a, g.a(a.a), true, 2);
            }

            
            {
                a = PostActivity._cls4._cls1.this;
                super();
            }
        });
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    _cls1.a(_cls1.a a1, g g)
    {
        b = a1;
        a = g;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/PostActivity$4

/* anonymous class */
    class PostActivity._cls4
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
                com.perfectcorp.a.b.a(new e(s, 0L, "comment", PostActivity.f(a), 0L));
            }
            com.perfectcorp.a.b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(g.a(view).creator.userId), 0L));
            AccountManager.a(a, new PostActivity._cls4._cls1(this, view));
        }

            
            {
                a = postactivity;
                super();
            }
    }

}
