// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.h;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.utility.ad;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class b
    implements android.view..OnClickListener
{

    final Uri a;
    final String b;
    final g c;

    public void onClick(View view)
    {
        if (a != null)
        {
            com.perfectcorp.a.b.a(new h(b));
            if (ad.d(a) && g.a(c).extLookUrl != null && !g.a(c).extLookUrl.isEmpty())
            {
                long l = System.currentTimeMillis();
                com.perfectcorp.a.b.a(new s(PostActivity.g(c.b), "video_play", null, g.a(c).postId, l - PostActivity.p(c.b).longValue()));
            }
            if (!ad.a(c.b, a))
            {
                com.cyberlink.beautycircle.c.a(c.b, a.toString(), 2);
            }
        }
    }

    Activity(g g1, Uri uri, String s1)
    {
        c = g1;
        a = uri;
        b = s1;
        super();
    }
}
