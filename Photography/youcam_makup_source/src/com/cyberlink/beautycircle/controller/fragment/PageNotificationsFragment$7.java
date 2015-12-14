// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.controller.adapter.l;
import com.cyberlink.beautycircle.model.Post;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageNotificationsFragment

class a
    implements l
{

    final PageNotificationsFragment a;

    public void a()
    {
    }

    public void a(int i)
    {
    }

    public void a(Post post)
    {
    }

    public void a(String s, Date date)
    {
        a.a(false);
        PageNotificationsFragment.a(a, s);
        PageNotificationsFragment.a(a, s, date);
    }

    public void a(boolean flag)
    {
        PageNotificationsFragment.a(a, flag);
    }

    public void b(boolean flag)
    {
        a.b(flag);
    }

    (PageNotificationsFragment pagenotificationsfragment)
    {
        a = pagenotificationsfragment;
        super();
    }
}
