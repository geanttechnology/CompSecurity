// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.view.View;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.g;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements android.view..OnClickListener
{

    final Uri a;
    final com.cyberlink.beautycircle.controller.activity.g b;

    public void onClick(View view)
    {
        long l = System.currentTimeMillis();
        com.perfectcorp.a.b.a(new s(com.cyberlink.beautycircle.controller.activity.PostActivity.g(b.b), "try_it", null, g.a(b).postId, l - PostActivity.p(b.b).longValue()));
        g.a(b.b, a);
    }

    Activity(com.cyberlink.beautycircle.controller.activity.g g1, Uri uri)
    {
        b = g1;
        a = uri;
        super();
    }
}
