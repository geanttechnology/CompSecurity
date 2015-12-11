// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.l.a;

import com.target.mothership.services.f.a.a;
import com.target.mothership.services.f.a.c;

// Referenced classes of package com.target.mothership.services.apigee.l.a:
//            a

public class b extends a
{

    public static c REQUEST_TEAM_MEMBER;

    public b(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b a(String s, com.target.mothership.services.apigee.l.a.a a1)
    {
        return a(REQUEST_TEAM_MEMBER, ((com.target.mothership.services.n) (a1)), null, null, null, s);
    }

    static 
    {
        REQUEST_TEAM_MEMBER = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeeSecure, "/team_member_requests/v1");
    }
}
