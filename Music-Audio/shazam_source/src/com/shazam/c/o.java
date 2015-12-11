// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.model.location.SimpleLocation;

public final class o
    implements a
{

    public o()
    {
    }

    public final Object a(Object obj)
    {
        obj = (SimpleLocation)obj;
        if (obj == null)
        {
            return null;
        } else
        {
            return com.shazam.server.request.recognition.Geolocation.Builder.geolocation().withLatitude(((SimpleLocation) (obj)).latitude).withLongitude(((SimpleLocation) (obj)).longitude).withAltitude(((SimpleLocation) (obj)).altitude).build();
        }
    }
}
