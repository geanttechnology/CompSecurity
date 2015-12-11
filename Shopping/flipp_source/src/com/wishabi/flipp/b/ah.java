// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.location.Geocoder;
import com.google.android.gms.common.c;
import com.google.android.gms.internal.iu;
import com.google.android.gms.location.e;

// Referenced classes of package com.wishabi.flipp.b:
//            ag, ai

final class ah
    implements c
{

    final Geocoder a;
    final ag b;

    ah(ag ag1, Geocoder geocoder)
    {
        b = ag1;
        a = geocoder;
        super();
    }

    public final void a_()
    {
        if (b.b.a.e())
        {
            android.location.Location location = b.b.a();
            b.b.a.g();
            b.b = null;
            if (location != null)
            {
                (new ai(this, location)).execute(new Void[0]);
                return;
            }
        }
    }

    public final void b()
    {
    }
}
