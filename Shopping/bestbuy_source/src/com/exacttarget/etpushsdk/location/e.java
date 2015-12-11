// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk.location:
//            a, f

public class e
    implements a
{

    protected LocationListener a;
    protected LocationManager b;
    protected Criteria c;
    protected Context d;
    protected LocationListener e;

    public e(Context context)
    {
        e = new f(this);
        b = (LocationManager)context.getSystemService("location");
        c = new Criteria();
        c.setAccuracy(2);
        d = context;
    }

    public Location a(int i, long l)
    {
        Location location = null;
        long l1 = 0x7fffffffffffffffL;
        Iterator iterator = b.getAllProviders().iterator();
        float f1 = 3.402823E+38F;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            obj = b.getLastKnownLocation(((String) (obj)));
            if (obj != null)
            {
                float f2 = ((Location) (obj)).getAccuracy();
                long l2 = ((Location) (obj)).getTime();
                if (l2 < l && f2 < f1)
                {
                    f1 = f2;
                    location = ((Location) (obj));
                    l1 = l2;
                } else
                if (l2 > l && f1 == 3.402823E+38F && l2 < l1)
                {
                    location = ((Location) (obj));
                    l1 = l2;
                }
            }
        } while (true);
        if (a != null && (l1 > l || f1 > (float)i))
        {
            String s = b.getBestProvider(c, true);
            if (s != null)
            {
                b.requestLocationUpdates(s, 0L, 0.0F, e, d.getMainLooper());
            }
        }
        return location;
    }

    public void a()
    {
        b.removeUpdates(e);
    }
}
