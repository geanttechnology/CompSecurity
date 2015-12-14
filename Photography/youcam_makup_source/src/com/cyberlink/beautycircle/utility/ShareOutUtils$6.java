// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.you.u;
import com.perfectcorp.model.Model;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            b, ShareOutUtils, AccountManager

final class b
    implements b
{

    final areInfo a;
    final BaseFbActivity b;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (a.a instanceof Post)
        {
            s = a.a.toString();
            Globals.b("ToDo: [BC Messages] Implement Share Post");
            u.a(b, AccountManager.b());
            u.b(b, s);
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    areInfo(areInfo areinfo, BaseFbActivity basefbactivity)
    {
        a = areinfo;
        b = basefbactivity;
        super();
    }
}
