// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.support.v4.app.i;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b

public abstract class d extends b
{

    public d()
    {
    }

    protected com.google.android.gms.maps.model.c a(c c1, LatLng latlng)
    {
        return c1.a((new CircleOptions()).a(latlng).a(500D).b(0x19000000).a(0x19000000).a(0.0F));
    }

    protected void a(e e)
    {
        ((SupportMapFragment)f().a(0x7f100088)).a(e);
    }

    protected void c(int j)
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
        {
            j = 0x7f0900b2;
        }
        Toast.makeText(getApplicationContext(), j, 1).show();
    }

    protected c l()
    {
        return ((SupportMapFragment)f().a(0x7f100088)).b();
    }
}
