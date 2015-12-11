// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import retrofit.RestAdapter;

// Referenced classes of package com.abtnprojects.ambatana.datasource.api:
//            GeoReverseService

public class b
{

    public static GeoReverseService a()
    {
        return (GeoReverseService)b().create(com/abtnprojects/ambatana/datasource/api/GeoReverseService);
    }

    private static RestAdapter b()
    {
        return (new retrofit.RestAdapter.Builder()).setEndpoint("http://maps.googleapis.com/maps/api/geocode").build();
    }
}
