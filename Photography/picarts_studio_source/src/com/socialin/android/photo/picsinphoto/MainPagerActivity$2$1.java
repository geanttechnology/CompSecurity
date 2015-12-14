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
    implements Runnable
{

    private Location a;
    private pplicationContext b;

    public final void run()
    {
        List list;
        try
        {
            list = c.b(b.b.getApplicationContext(), a.getLatitude(), a.getLongitude());
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
            c.a(b.b.getApplicationContext(), ((Address)list.get(0)).getCountryCode());
        }
    }

    ( , Location location)
    {
        b = ;
        a = location;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/picsinphoto/MainPagerActivity$2

/* anonymous class */
    final class MainPagerActivity._cls2
        implements LocationListener
    {

        final MainPagerActivity a;

        public final void onLocationChanged(Location location)
        {
            (new Thread(new MainPagerActivity._cls2._cls1(this, location))).start();
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

            
            {
                a = mainpageractivity;
                super();
            }
    }

}
