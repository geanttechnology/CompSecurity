// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.controller.activity.CircleActivity;
import com.cyberlink.beautycircle.model.CircleDetail;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            i

class a extends m
{

    final i a;

    protected void a(CircleDetail circledetail)
    {
        if (circledetail != null)
        {
            i.a(a, circledetail);
            i.a(a);
            i.a(a, a.i);
        }
        circledetail = a.getActivity();
        if (circledetail != null)
        {
            ((BaseActivity)circledetail).l();
            if (circledetail instanceof CircleActivity)
            {
                ((CircleActivity)circledetail).a(i.b(a));
            }
        }
    }

    protected void b(Object obj)
    {
        a((CircleDetail)obj);
    }

    leActivity(i j)
    {
        a = j;
        super();
    }
}
