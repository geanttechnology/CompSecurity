// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.model.r;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements r
{

    final a a;

    public void a(Post post)
    {
        if (post != null)
        {
            g.a(a.a, post);
        }
        a.a.a(g.a(a.a));
        g.b(a.a, g.a(a.a));
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/g$16

/* anonymous class */
    class g._cls16 extends m
    {

        final g a;

        protected void a(d d1)
        {
            byte byte0 = 8;
            if (g.a(a) != null)
            {
                Object obj = a;
                obj.a = ((g) (obj)).a + d1.b.size();
                a.a(g.a(a).creator.userId, d1.b);
                obj = g.o(a).findViewById(j.more_comment_btn);
                int i;
                if (d1.a.intValue() > a.a)
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                ((View) (obj)).setVisibility(i);
                obj = g.o(a).findViewById(j.add_comment_btn);
                i = byte0;
                if (d1.a.intValue() > 0)
                {
                    i = 0;
                }
                ((View) (obj)).setVisibility(i);
                if (g.a(a).commentCount != null && d1.a != null && g.a(a).commentCount.intValue() != d1.a.intValue())
                {
                    e.e(new Object[] {
                        g.a(a).commentCount, " to ", d1.a
                    });
                    g.a(a).a(Long.valueOf(d1.a.longValue()), new g._cls16._cls1(this));
                }
            }
        }

        protected void b(Object obj)
        {
            a((d)obj);
        }

            
            {
                a = g1;
                super();
            }
    }

}
