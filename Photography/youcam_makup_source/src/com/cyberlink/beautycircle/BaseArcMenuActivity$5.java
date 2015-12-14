// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.utility.b;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseArcMenuActivity, Globals

class a
    implements b
{

    final BaseArcMenuActivity a;

    public void a()
    {
        com.cyberlink.beautycircle.Globals.b("Get AccountToken Fail");
        a.n = null;
    }

    public void a(String s)
    {
        if (a.n.isLiked.booleanValue())
        {
            NetworkPost.b(s, "Post", a.n.postId.longValue());
            a.n.isLiked = Boolean.valueOf(false);
            s = a.n;
            s.likeCount = Long.valueOf(((Post) (s)).likeCount.longValue() - 1L);
        } else
        {
            NetworkPost.a(s, "Post", a.n.postId.longValue());
            BCTileImage.a(a.n);
            a.n.isLiked = Boolean.valueOf(true);
            s = a.n;
            s.likeCount = Long.valueOf(((Post) (s)).likeCount.longValue() + 1L);
        }
        t.d.a();
        a.n = null;
    }

    public void b()
    {
        com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
        a.n = null;
    }

    ost(BaseArcMenuActivity basearcmenuactivity)
    {
        a = basearcmenuactivity;
        super();
    }
}
