// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import com.cyberlink.beautycircle.controller.activity.HotTopicActivity;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.model.CircleType;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            g

class a extends m
{

    final g a;

    protected void a(int i)
    {
        super.a(i);
        g.b(a);
    }

    protected void a(CircleType circletype)
    {
        if (circletype != null)
        {
            if (circletype.circleTypeName != null)
            {
                ((HotTopicActivity)a.c).b().c(circletype.circleTypeName);
            }
            if (circletype.id != null)
            {
                g.a(a, circletype.id);
            }
        }
        g.a(a);
    }

    protected void b(Object obj)
    {
        a((CircleType)obj);
    }

    BarFragment(g g1)
    {
        a = g1;
        super();
    }
}
