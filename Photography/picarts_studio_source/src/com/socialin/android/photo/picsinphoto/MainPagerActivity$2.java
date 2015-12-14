// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.picsart.studio.utils.c;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements LocationListener
{

    final MainPagerActivity a;

    public final void onLocationChanged(Location location)
    {
        (new Thread(new Runnable(location) {

            private Location a;
            private MainPagerActivity._cls2 b;

            public final void run()
            {
                List list;
                try
                {
                    list = c.b(b.a.getApplicationContext(), a.getLatitude(), a.getLongitude());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return;
                }
                if (list == null)
                {
                    break MISSING_BLOCK_LABEL_67;
                }
                if (list.size() > 0)
                {
                    c.a(b.a.getApplicationContext(), ((Address)list.get(0)).getCountryCode());
                }
            }

            
            {
                b = MainPagerActivity._cls2.this;
                a = location;
                super();
            }
        })).start();
    }

    public final void onProviderDisabled(String s)
    {
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    _cls1.a(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
