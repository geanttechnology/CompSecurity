// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.google.a.a.e;
import com.newrelic.agent.android.NewRelic;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;

// Referenced classes of package com.target.ui.service:
//            k, a

public class h
    implements a.b, k.c
{

    private static String IN_GEOFENCE_KEY = "in_geofence";
    private static String IS_ANONYMOUS_KEY = "is_guest_anonymous";
    private static String IS_MY_STORE_KEY = "my_store";
    private static String STORE_ID_KEY = "store_id";
    private static h sInstance;

    private h()
    {
        k.a().a(this);
        com.target.ui.service.a.a().a(this);
    }

    public static void a()
    {
        sInstance = new h();
    }

    public void a(e e1)
    {
        if (e1 != null && e1.b())
        {
            String s;
            String s1;
            if (((RelevantStoreSummary)e1.c()).getStoreId() != null)
            {
                NewRelic.setAttribute(STORE_ID_KEY, ((RelevantStoreSummary)e1.c()).getStoreId().a());
            } else
            {
                NewRelic.setAttribute(STORE_ID_KEY, "unknown");
            }
            s1 = IN_GEOFENCE_KEY;
            if (((RelevantStoreSummary)e1.c()).a())
            {
                s = "true";
            } else
            {
                s = "false";
            }
            NewRelic.setAttribute(s1, s);
            s = IS_MY_STORE_KEY;
            if (((RelevantStoreSummary)e1.c()).c())
            {
                e1 = "true";
            } else
            {
                e1 = "false";
            }
            NewRelic.setAttribute(s, e1);
            return;
        } else
        {
            NewRelic.setAttribute(STORE_ID_KEY, "none");
            NewRelic.setAttribute(IN_GEOFENCE_KEY, "false");
            NewRelic.setAttribute(IS_MY_STORE_KEY, "false");
            return;
        }
    }

    public void a(Guest guest)
    {
        if (guest != null)
        {
            String s = IS_ANONYMOUS_KEY;
            if (guest.isAnonymous())
            {
                guest = "true";
            } else
            {
                guest = "false";
            }
            NewRelic.setAttribute(s, guest);
        }
    }

    public void b()
    {
        NewRelic.setAttribute(IS_ANONYMOUS_KEY, "true");
    }

}
