// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseArcMenuActivity, Globals, c

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
        c.a(a, a.n);
        a.n = null;
    }

    public void b()
    {
        com.cyberlink.beautycircle.Globals.b("Get AccountToken Cancel");
        a.n = null;
    }

    (BaseArcMenuActivity basearcmenuactivity)
    {
        a = basearcmenuactivity;
        super();
    }
}
