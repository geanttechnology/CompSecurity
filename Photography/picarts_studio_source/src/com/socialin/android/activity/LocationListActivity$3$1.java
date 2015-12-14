// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.location.Address;
import android.location.Geocoder;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.socialin.android.activity:
//            LocationListActivity, c

final class a
    implements Runnable
{

    private Address a;
    private a b;

    public final void run()
    {
        LocationListActivity.access$100(b.b);
        LocationListActivity.access$000(b.b).add(new c((new StringBuilder()).append(a.getLocality()).append(", ").append(a.getCountryName()).toString(), null));
        LocationListActivity.access$000(b.b).add(new c(a.getCountryName(), null));
        for (int i = 0; i < a.getMaxAddressLineIndex(); i++)
        {
            LocationListActivity.access$000(b.b).add(new c(a.getAddressLine(i), null));
        }

    }

    tionAdapter(tionAdapter tionadapter, Address address)
    {
        b = tionadapter;
        a = address;
        super();
    }

    // Unreferenced inner class com/socialin/android/activity/LocationListActivity$3

/* anonymous class */
    final class LocationListActivity._cls3
        implements Runnable
    {

        final LocationListActivity a;
        private Geocoder b;
        private Double c;
        private Double d;

        public final void run()
        {
            Object obj;
label0:
            {
                try
                {
                    obj = b.getFromLocation(c.doubleValue(), d.doubleValue(), 4);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((IOException) (obj)).printStackTrace();
                    obj = null;
                }
                if (obj != null && ((List) (obj)).size() != 0)
                {
                    obj = (Address)((List) (obj)).get(0);
                    if (!a.isFinishing())
                    {
                        break label0;
                    }
                }
                return;
            }
            a.runOnUiThread(new LocationListActivity._cls3._cls1(this, ((Address) (obj))));
        }

            
            {
                a = locationlistactivity;
                b = geocoder;
                c = double1;
                d = double2;
                super();
            }
    }

}
