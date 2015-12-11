// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.inventory;

import android.location.Address;
import android.location.Location;
import java.util.Comparator;

// Referenced classes of package com.ebay.mobile.inventory:
//            StorePickerActivity

static final class userLongitude
    implements Comparator
{

    private final double userLatitude;
    private final double userLongitude;

    public int compare(Address address, Address address1)
    {
        boolean flag = false;
        int i = ((flag) ? 1 : 0);
        if (address != null)
        {
            i = ((flag) ? 1 : 0);
            if (address1 != null)
            {
                i = ((flag) ? 1 : 0);
                if (address.hasLatitude())
                {
                    i = ((flag) ? 1 : 0);
                    if (address.hasLongitude())
                    {
                        i = ((flag) ? 1 : 0);
                        if (address1.hasLatitude())
                        {
                            i = ((flag) ? 1 : 0);
                            if (address1.hasLongitude())
                            {
                                double d = address.getLatitude();
                                double d1 = address.getLongitude();
                                address = new float[1];
                                Location.distanceBetween(userLatitude, userLongitude, d, d1, address);
                                d = address1.getLatitude();
                                d1 = address1.getLongitude();
                                address1 = new float[1];
                                Location.distanceBetween(userLatitude, userLongitude, d, d1, address1);
                                i = (int)(address[0] - address1[0]);
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Address)obj, (Address)obj1);
    }

    (double d, double d1)
    {
        userLatitude = d;
        userLongitude = d1;
    }
}
