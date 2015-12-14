// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements b
{

    final g a;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            c.a(a.b, g.r(a));
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    _cls9(g g1)
    {
        a = g1;
        super();
    }
}
