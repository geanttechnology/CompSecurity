// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.ListSummary;

// Referenced classes of package com.target.mothership.model.list:
//            d, b, a

public class c extends a
{

    public static final int FLAG_PROVIDER_LOCAL = 0;
    public static final int FLAG_PROVIDER_NETWORK = 1;
    private com.target.mothership.model.list.a mListCollectionBaseDataSource;

    public c(Guest guest)
    {
        if (guest == null || guest.isAnonymous())
        {
            guest = com.target.mothership.model.guest.b.a();
        }
        a(guest);
    }

    private void a(GuestBase guestbase)
    {
        if (com.target.mothership.b.a().m())
        {
            mListCollectionBaseDataSource = new com.target.mothership.model.list.d(guestbase);
            return;
        } else
        {
            mListCollectionBaseDataSource = new com.target.mothership.model.list.b(guestbase);
            return;
        }
    }

    public void a(d d1)
    {
        mListCollectionBaseDataSource.a(d1);
    }

    public void a(ListSummary listsummary, int i, d d1)
    {
        mListCollectionBaseDataSource.a(listsummary, i, d1);
    }

    public void a(String s, String s1, String s2, String s3, d d1)
    {
        mListCollectionBaseDataSource.a(s, s1, s2, s3, d1);
    }

    public void b(d d1)
    {
        mListCollectionBaseDataSource.b(d1);
    }

    public void c(d d1)
    {
        mListCollectionBaseDataSource.c(d1);
    }
}
