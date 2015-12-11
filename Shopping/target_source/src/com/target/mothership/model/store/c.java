// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store;

import android.location.Location;
import com.target.mothership.b;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.a;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.h;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store:
//            d, b, a

public class c extends a
{

    private com.target.mothership.model.store.a mStoreDataSource;

    public c()
    {
        if (com.target.mothership.b.a().m())
        {
            mStoreDataSource = new d();
            return;
        } else
        {
            mStoreDataSource = new com.target.mothership.model.store.b();
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, h h)
    {
        mStoreDataSource.a(storeidentifier, h);
    }

    public void a(GuestBase guestbase, double d1, double d2, int i, h h)
    {
        mStoreDataSource.a(guestbase, d1, d2, i, h);
    }

    public void a(GuestBase guestbase, Location location, int i, h h)
    {
        mStoreDataSource.a(guestbase, location, i, h);
    }

    public void a(GuestBase guestbase, Location location, h h)
    {
        mStoreDataSource.a(guestbase, location, h);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        mStoreDataSource.a(guestbase, storeidentifier, a1);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, h h)
    {
        mStoreDataSource.a(guestbase, storeidentifier, h);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, boolean flag, com.target.mothership.cache.i.a a1)
    {
        mStoreDataSource.a(guestbase, storeidentifier, flag, a1);
    }

    public void a(GuestBase guestbase, h h)
    {
        mStoreDataSource.a(guestbase, h);
    }

    public void a(GuestBase guestbase, List list, h h)
    {
        mStoreDataSource.a(guestbase, list, h);
    }

    public void a(String s, int i, int j, h h)
    {
        mStoreDataSource.a(s, i, j, h);
    }

    public void b(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        mStoreDataSource.b(guestbase, storeidentifier, a1);
    }
}
