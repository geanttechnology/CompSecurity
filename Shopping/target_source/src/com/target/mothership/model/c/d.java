// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.c;

import com.target.mothership.model.c;

// Referenced classes of package com.target.mothership.model.c:
//            a, b

class d extends c
    implements a
{

    private b mLocationLiveDataSource;

    public d()
    {
        mLocationLiveDataSource = new b();
    }

    public void a(String s, com.target.mothership.model.d d1)
    {
        a("get_geocode_model.json");
        mLocationLiveDataSource.a(s, d1);
    }
}
