// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.d;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;

// Referenced classes of package com.target.mothership.model.d:
//            d, b, a

public class c extends a
{

    private static final String TAG = com/target/mothership/model/d/c.getSimpleName();
    private com.target.mothership.model.d.a mRequestTeamMemberDataSource;

    public c()
    {
        if (b.a().m())
        {
            mRequestTeamMemberDataSource = new com.target.mothership.model.d.d();
            return;
        } else
        {
            mRequestTeamMemberDataSource = new com.target.mothership.model.d.b();
            return;
        }
    }

    public void a(Guest guest, String s, int i, int j, d d1)
    {
        mRequestTeamMemberDataSource.a(guest, s, i, j, d1);
    }

}
