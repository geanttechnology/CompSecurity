// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.location.Location;
import android.os.Bundle;
import com.b.a.a.g;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.offerup.android.i.a;
import com.offerup.android.i.b;
import com.offerup.android.i.d;
import com.offerup.android.i.e;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            k, j, i

public abstract class h extends k
{

    private String a;
    private e b;

    public h()
    {
        a = "BaseLocationActivity";
    }

    static String a(h h1)
    {
        return h1.a;
    }

    private void a()
    {
        com.b.a.a.g.b(a, "getLocationLegacy");
        a(((android.os.AsyncTask) (new b(this))), new Object[0]);
    }

    static void b(h h1)
    {
        h1.a();
    }

    public final void a(Location location)
    {
        com.b.a.a.g.b(a, "getGeocodeInformation");
        a(((android.os.AsyncTask) (new a(this, new OfferUpLocation(location)))), new Object[0]);
    }

    public abstract void a(OfferUpLocation offeruplocation);

    public final void f()
    {
        if (b != null)
        {
            b.a();
            return;
        } else
        {
            a();
            return;
        }
    }

    public final void g()
    {
        android.app.AlertDialog.Builder builder = n.c(this);
        builder.setTitle("Location Error");
        builder.setMessage("Please check your device's GPS setting and try again.\n\nIf this problem persists, try using Zip Code or contact support.");
        builder.setNeutralButton("OK", new j(this));
        n.a(builder);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b = new d(this);
            b.a(new i(this));
        }
    }
}
