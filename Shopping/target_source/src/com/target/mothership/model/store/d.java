// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store;

import android.location.Location;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.c;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.b;
import com.target.mothership.services.x;
import com.target.mothership.util.g;
import com.target.mothership.util.h;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store:
//            a, b

public class d extends c
    implements a
{

    private com.target.mothership.model.store.b mLiveDataSource;

    public d()
    {
        mLiveDataSource = new com.target.mothership.model.store.b();
    }

    private void a(com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(g.FAKE_RELEVANT_STORE_SUMMARY_INSIDE);
            h1.a(arraylist);
            return;
        }
    }

    public void a(StoreIdentifier storeidentifier, com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_store_details.json");
            mLiveDataSource.a(storeidentifier, h1);
            return;
        }
    }

    public void a(GuestBase guestbase, double d1, double d2, int i, com.target.mothership.model.h h1)
    {
        a(h1);
    }

    public void a(GuestBase guestbase, Location location, int i, com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        guestbase = new ArrayList();
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        }
        if (b() != com.target.mothership.c.b.InStore) goto _L2; else goto _L1
_L1:
        guestbase.add(g.FAKE_RELEVANT_STORE_SUMMARY_INSIDE);
        guestbase.add(g.FAKE_RELEVANT_STORE_FREQUENTED);
        guestbase.add(g.FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE);
_L4:
        h1.a(guestbase);
        return;
_L2:
        if (b() == com.target.mothership.c.b.OutOfStore)
        {
            guestbase.add(g.FAKE_RELEVANT_STORE_FREQUENTED);
            guestbase.add(g.FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE);
            guestbase.add(g.FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE_2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(GuestBase guestbase, Location location, com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        }
        if (b() == com.target.mothership.c.b.InStore)
        {
            h1.a(e.b(g.FAKE_RELEVANT_STORE_SUMMARY_INSIDE));
            return;
        }
        if (b() == com.target.mothership.c.b.OutOfStore)
        {
            h1.a(e.b(g.FAKE_RELEVANT_STORE_SUMMARY_OUTSIDE));
            return;
        } else
        {
            h1.a(e.e());
            return;
        }
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        if (a1 == null)
        {
            return;
        }
        if (a())
        {
            a1.onFailure(h.NETWORK_ERROR);
            return;
        } else
        {
            a1.onStoreUpdated();
            return;
        }
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.model.h h1)
    {
        a(((com.target.mothership.model.d) (h1)), com/target/mothership/model/store/interfaces/RelevantStoreSummary, com/target/mothership/services/x);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, boolean flag, com.target.mothership.cache.i.a a1)
    {
        if (a1 == null)
        {
            return;
        }
        if (a())
        {
            a1.onFailure(h.NETWORK_ERROR);
            return;
        } else
        {
            a1.onStoreUpdated();
            return;
        }
    }

    public void a(GuestBase guestbase, com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            h1.a(e.b(a(com/target/mothership/model/store/interfaces/RelevantStoreSummary)));
            return;
        }
    }

    public void a(GuestBase guestbase, List list, com.target.mothership.model.h h1)
    {
        a(h1);
    }

    public void a(String s, int i, int j, com.target.mothership.model.h h1)
    {
        if (h1 == null)
        {
            return;
        }
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            h1.a(a(com/target/mothership/model/store/interfaces/b));
            return;
        }
    }

    public void b(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        if (a1 == null)
        {
            return;
        }
        if (a())
        {
            a1.onFailure(h.NETWORK_ERROR);
            return;
        } else
        {
            a1.onStoreUpdated();
            return;
        }
    }
}
