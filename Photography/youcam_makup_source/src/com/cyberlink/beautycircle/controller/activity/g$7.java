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

class a
    implements android.view..OnClickListener
{

    final Uri a;
    final g b;

    public void onClick(View view)
    {
        com.perfectcorp.a.b.a(new h(Long.toString(g.a(b).postId.longValue())));
        if (ad.d(a) && g.a(b).extLookUrl != null && !g.a(b).extLookUrl.isEmpty())
        {
            long l = System.currentTimeMillis();
            com.perfectcorp.a.b.a(new s(PostActivity.g(b.b), "video_play", null, g.a(b).postId, l - PostActivity.p(b.b).longValue()));
        }
        if (!ad.a(b.b, a))
        {
            c.a(b.b, a.toString(), 2);
        }
    }

    Activity(g g1, Uri uri)
    {
        b = g1;
        a = uri;
        super();
    }
}
