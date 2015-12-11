// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.i;

import android.location.Address;
import android.os.AsyncTask;
import com.b.a.a.g;
import com.offerup.android.activities.h;
import com.offerup.android.utils.OfferUpLocation;
import com.offerup.android.utils.as;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.i:
//            g

public final class a extends AsyncTask
{

    private h a;
    private OfferUpLocation b;

    public a(h h1, OfferUpLocation offeruplocation)
    {
        a = h1;
        b = offeruplocation;
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = null;
        if (b == null) goto _L2; else goto _L1
_L1:
        if (b.d() == 0.0D || b.c() == 0.0D) goto _L4; else goto _L3
_L3:
        aobj = as.a(a.getApplicationContext(), b.d(), b.c());
_L6:
        if (aobj != null && StringUtils.isNotEmpty(((Address) (aobj)).getLocality()) && StringUtils.isNotEmpty(((Address) (aobj)).getAdminArea()))
        {
            if (((Address) (aobj)).hasLatitude())
            {
                b.b(((Address) (aobj)).getLatitude());
            }
            if (((Address) (aobj)).hasLongitude())
            {
                b.a(((Address) (aobj)).getLongitude());
            }
            OfferUpLocation offeruplocation = b;
            offeruplocation.c(((Address) (aobj)).getLocality());
            offeruplocation.d(((Address) (aobj)).getAdminArea());
            offeruplocation.a(((Address) (aobj)).getPostalCode());
        }
_L2:
        return b;
_L4:
        if (StringUtils.isNotEmpty(b.a()))
        {
            aobj = as.a(a.getApplicationContext(), b.a());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (OfferUpLocation)obj;
        a.i();
        if (obj != null && ((OfferUpLocation) (obj)).d() != 0.0D && ((OfferUpLocation) (obj)).c() != 0.0D)
        {
            a.a(((OfferUpLocation) (obj)));
            return;
        } else
        {
            g.a("GetGeocodeInfoAsyncTask", new com.offerup.android.i.g("Couldn't determine location"));
            a.a(new OfferUpLocation());
            return;
        }
    }
}
