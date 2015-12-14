// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            j

class a extends m
{

    final j a;

    protected void a(d d1)
    {
        if (j.f(a) != null)
        {
            j.b(a, d1.b.size());
            a.a(j.f(a).creator.userId, d1.b);
            a.c();
            View view = j.h(a);
            int i;
            if (d1.a.intValue() > j.g(a))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
        a.a();
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    _cls9(j j1)
    {
        a = j1;
        super();
    }
}
