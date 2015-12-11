// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j;

import android.content.Context;
import android.net.Uri;
import com.google.a.a.e;
import com.j.a.f;
import com.target.a.a.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.analytics.a.i;
import com.target.ui.analytics.b.g;
import com.target.ui.analytics.b.h;
import com.target.ui.analytics.b.j;
import com.target.ui.service.k;
import com.target.ui.util.ai;
import com.target.ui.util.q;
import de.greenrobot.event.EventBus;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.target.ui.j:
//            b, d

public class c
    implements f, com.target.ui.service.a.b, com.target.ui.service.k.c
{

    private static final String TAG = com/target/ui/j/c.getSimpleName();
    private static c sInstance;
    private String mABTestingIds;
    private String mCachedGuest;

    private c(a a1)
    {
        com.j.a.a.a(a1.a(), "9a660b897b217afaf0945ff1526a888be06b7f2f");
        com.j.a.a.a(this);
        com.target.ui.service.a.a().a(this);
        k.a().a(this);
        com.target.ui.util.c.a.a().register(this);
        com.target.ui.j.b.a();
    }

    public static c a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("Initialize must be called before getInstance");
        } else
        {
            return sInstance;
        }
    }

    public static void a(Uri uri, Context context)
    {
        if (!com.target.ui.util.g.a.a(context))
        {
            q.d(TAG, "Taplytics is not enabled");
            return;
        } else
        {
            ai.b(context, "Acknowledging Taplytics pairing request.");
            com.j.a.a.a(uri.toString());
            return;
        }
    }

    public static void a(a a1)
    {
        if (sInstance != null)
        {
            return;
        } else
        {
            sInstance = new c(a1);
            return;
        }
    }

    private void a(d d1)
    {
        try
        {
            com.j.a.a.a((new JSONObject()).put("user_id", mCachedGuest).put("customData", d1.a()));
            q.e(TAG, "Updated Taplytics user attributes successfully");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (d d1)
        {
            q.a(TAG, "Failed to create Taplytics user attributes JSON object");
        }
    }

    private void a(String s)
    {
        a(com.target.ui.j.d.a(s, Boolean.TRUE));
    }

    public static boolean a(Uri uri)
    {
        uri = uri.getScheme();
        return uri != null && uri.equals("tl-099dd904");
    }

    private void d()
    {
        if (k.a().c().b())
        {
            RelevantStoreSummary relevantstoresummary = (RelevantStoreSummary)k.a().c().c();
            a(com.target.ui.j.d.a("hasEnteredGeofence", Boolean.valueOf(true)).b("mostRelevantStoreID", relevantstoresummary.getStoreId()));
            return;
        } else
        {
            a(com.target.ui.j.d.a("mostRelevantStoreID", null));
            return;
        }
    }

    public void a(e e1)
    {
        d();
    }

    public void a(Guest guest)
    {
        mCachedGuest = guest.getGuestId();
        d();
    }

    public void a(Map map)
    {
        mABTestingIds = i.a(map);
    }

    public void b()
    {
    }

    public String c()
    {
        return mABTestingIds;
    }

    public void onEvent(com.target.ui.analytics.b.e e1)
    {
        a("hasAddedToCart");
    }

    public void onEvent(g g1)
    {
        if (g1.listEventType == com.target.ui.analytics.b.g.a.Add)
        {
            a("hasAddedProductToList");
        }
    }

    public void onEvent(h h)
    {
        a("hasUsedDeepLinkURI");
    }

    public void onEvent(com.target.ui.analytics.b.i j)
    {
        a("hasPurchased");
    }

    public void onEvent(j j)
    {
        a("hasViewedProduct");
    }

    public void onEvent(com.target.ui.analytics.b.k k1)
    {
        if (k1.searchMethod == com.target.ui.analytics.b.k.a.Query)
        {
            a("hasViewedSearchResults");
        }
    }

}
