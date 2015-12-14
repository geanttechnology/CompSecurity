// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            LikeListActivity

class a extends m
{

    final LikeListActivity a;

    protected void a(d d1)
    {
        LikeListActivity.a(a, d1.b.size());
        View view = LikeListActivity.b(a);
        int i;
        if (LikeListActivity.a(a) < d1.a.intValue())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        LikeListActivity.a(a, d1.b);
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    (LikeListActivity likelistactivity)
    {
        a = likelistactivity;
        super();
    }
}
