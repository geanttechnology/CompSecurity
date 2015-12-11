// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.d;

import com.target.mothership.model.d;
import com.target.mothership.model.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.apigee.l.b.a;

// Referenced classes of package com.target.mothership.model.d:
//            a

public class b
    implements com.target.mothership.model.d.a
{

    private final a mServices = new a();

    public b()
    {
    }

    public void a(Guest guest, String s, int i, int j, d d)
    {
        d = new e(new com.target.mothership.model.d.b.a(d));
        mServices.a(guest.getAccessToken(), new com.target.mothership.services.apigee.l.a.a(s, i, j), d);
    }
}
