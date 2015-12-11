// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import android.location.Location;
import com.wishabi.flipp.b.ab;

// Referenced classes of package com.wishabi.flipp.app:
//            bx, bz

final class by extends ab
{

    final bx a;

    by(bx bx1, Context context)
    {
        a = bx1;
        super(context);
    }

    protected final void a(Location location, int i)
    {
        Double double2 = null;
        boolean flag1 = true;
        if (a.getActivity() == null)
        {
            return;
        }
        Double double1;
        bx bx1;
        boolean flag;
        if (location == null)
        {
            double1 = null;
        } else
        {
            double1 = Double.valueOf(location.getLatitude());
        }
        if (location != null)
        {
            double2 = Double.valueOf(location.getLongitude());
        }
        bx1 = a;
        if (location != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bx.a(bx1, flag);
        location = a;
        if (i != 2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        bx.b(location, flag);
        (new bz(this, bx.a(a), bx.b(a), double1, double2)).execute(new Void[0]);
    }
}
