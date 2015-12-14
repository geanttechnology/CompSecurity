// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.a.af;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.utility.ad;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a
    implements android.support.v4.view.ChangeListener
{

    final PostActivity a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        e.b(new Object[] {
            Integer.valueOf(i)
        });
        PostActivity.a(a, i);
        g g1 = (g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(i));
        if (g1 != null)
        {
            if (!g.d(g1))
            {
                g.c(g1);
            }
            Object obj = Long.valueOf(System.currentTimeMillis());
            b.a(new af(Long.toString(com.cyberlink.beautycircle.controller.activity.g.b(g1)), PostActivity.g(a), PostActivity.h(a), ((Long) (obj))));
            b.a(new am(null, null, null, null, ((Long) (obj)).longValue() - PostActivity.h(a).longValue()));
            PostActivity.a(a, Long.valueOf(System.currentTimeMillis()));
            obj = (Post)com.cyberlink.beautycircle.controller.activity.PostActivity.b(a).get(PostActivity.d(a));
            if (obj != null && ((Post) (obj)).extLookUrl != null && !((Post) (obj)).extLookUrl.isEmpty() && PostActivity.i(a) != ((Post) (obj)).postId.longValue())
            {
                com.cyberlink.beautycircle.controller.activity.PostActivity.b(a, Long.valueOf(System.currentTimeMillis()));
                if (ad.d(((Post) (obj)).d()))
                {
                    b.a(new s(PostActivity.g(a), "show", "video", ((Post) (obj)).postId, 0L));
                } else
                {
                    b.a(new s(PostActivity.g(a), "show", "picture", ((Post) (obj)).postId, 0L));
                }
                PostActivity.a(a, ((Post) (obj)).postId.longValue());
            }
            com.cyberlink.beautycircle.controller.activity.g.e(g1);
        }
    }

    (PostActivity postactivity)
    {
        a = postactivity;
        super();
    }
}
