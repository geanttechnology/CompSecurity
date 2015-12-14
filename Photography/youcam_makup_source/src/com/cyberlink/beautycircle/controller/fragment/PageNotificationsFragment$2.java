// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class a extends m
{

    final PageNotificationsFragment a;

    protected void a(Boolean boolean1)
    {
        PageNotificationsFragment.d(a, boolean1.booleanValue());
        if (boolean1.booleanValue())
        {
            a.d(false);
            PageNotificationsFragment.k(a);
            return;
        } else
        {
            a.d(true);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((Boolean)obj);
    }

    (PageNotificationsFragment pagenotificationsfragment)
    {
        a = pagenotificationsfragment;
        super();
    }
}
