// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.view.widgetpool.common.b;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseArcMenuActivity

class a
    implements b
{

    final BaseArcMenuActivity a;

    public void a()
    {
        a.q();
    }

    public void b()
    {
        if (a.f != null)
        {
            com.perfectcorp.a.b.a(new e(a.f, 0L, "circleIt", a.g, 0L));
        }
        com.perfectcorp.a.b.a(new am(am.a, "circleIt".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
        com.cyberlink.beautycircle.BaseArcMenuActivity.b(a);
    }

    public void c()
    {
        if (a.f != null)
        {
            com.perfectcorp.a.b.a(new e(a.f, 0L, "like", a.g, 0L));
        }
        com.perfectcorp.a.b.a(new am(am.a, "like".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
        a.p();
    }

    public void d()
    {
        if (a.f != null)
        {
            com.perfectcorp.a.b.a(new e(a.f, 0L, "share", a.g, 0L));
        }
        com.perfectcorp.a.b.a(new am(am.a, "share".toString(), a.n.postId, Long.valueOf(a.n.creator.userId), 0L));
        BaseArcMenuActivity.c(a);
    }

    public void e()
    {
        BaseArcMenuActivity.d(a);
    }

    .b(BaseArcMenuActivity basearcmenuactivity)
    {
        a = basearcmenuactivity;
        super();
    }
}
