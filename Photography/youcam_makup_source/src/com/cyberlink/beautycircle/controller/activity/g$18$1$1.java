// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.r;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        boolean flag1 = true;
        Object obj = a.a.a.b;
        View view = a.a;
        android.widget.TextView textview;
        int i;
        long l;
        long l1;
        boolean flag;
        if (!a.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        PostActivity.a(((PostActivity) (obj)), view, flag, true);
        obj = a.a.a;
        view = g.m(a.a.a);
        textview = g.p(a.a.a);
        l = g.a(a.a.a).likeCount.longValue();
        if (a.a)
        {
            i = -1;
        } else
        {
            i = 1;
        }
        l1 = i;
        if (!a.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(((g) (obj)), view, textview, l + l1, flag);
        obj = g.a(a.a.a);
        if (!a.a)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((Post) (obj)).a(flag, new r() {

            final g._cls18._cls1._cls1 a;

            public void a(Post post)
            {
                if (post != null)
                {
                    g.a(a.a.c.a, post);
                }
                a.a.c.a.a(g.a(a.a.c.a));
                com.cyberlink.beautycircle.controller.activity.g.b(a.a.c.a, g.a(a.a.c.a));
            }

            
            {
                a = g._cls18._cls1._cls1.this;
                super();
            }
        });
    }

    _cls1.a(_cls1.a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$18

/* anonymous class */
    class g._cls18
        implements android.view.View.OnClickListener
    {

        final g a;

        public void onClick(View view)
        {
            aq.c = "like";
            String s = PostActivity.a(a.b, g.a(a));
            if (s != null)
            {
                b.a(new e(s, 0L, "like", PostActivity.f(a.b), 0L));
            }
            b.a(new am(am.b, "like", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(a)), Long.valueOf(g.a(a).creator.userId), 0L));
            boolean flag = ((Boolean)view.getTag()).booleanValue();
            AccountManager.a(a.b, new g._cls18._cls1(this, view, flag));
        }

            
            {
                a = g1;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$18$1

/* anonymous class */
    class g._cls18._cls1
        implements com.cyberlink.beautycircle.utility.b
    {

        final View a;
        final boolean b;
        final g._cls18 c;

        public void a()
        {
            Globals.b("Get AccountToken Fail");
        }

        public void a(String s)
        {
            c.a.b.runOnUiThread(new g._cls18._cls1._cls1(this));
            if (b)
            {
                NetworkPost.b(s, "Post", g.a(c.a).postId.longValue());
            } else
            {
                NetworkPost.a(s, "Post", g.a(c.a).postId.longValue());
                BCTileImage.a(g.a(c.a));
            }
            t.d.a();
        }

        public void b()
        {
            Globals.b("Get AccountToken Cancel");
        }

            
            {
                c = _pcls18;
                a = view;
                b = flag;
                super();
            }
    }

}
