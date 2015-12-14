// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a
    implements b
{

    final g a;
    final PostActivity b;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (a != null)
        {
            c.a(b, g.a(a));
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    (PostActivity postactivity, g g1)
    {
        b = postactivity;
        a = g1;
        super();
    }
}
