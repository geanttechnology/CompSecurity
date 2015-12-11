// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.k.a;

import android.location.Location;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        obj = (Location)obj;
        if (obj == null)
        {
            return null;
        }
        com.shazam.android.web.bridge.command.data.ShWebGeolocation.Builder builder = com.shazam.android.web.bridge.command.data.ShWebGeolocation.Builder.shWebGeolocation().withLatitude(((Location) (obj)).getLatitude()).withLongitude(((Location) (obj)).getLongitude());
        if (((Location) (obj)).hasAltitude())
        {
            builder.withAltitude(((Location) (obj)).getAltitude());
        }
        if (((Location) (obj)).hasAccuracy())
        {
            builder.withAccuracy(((Location) (obj)).getAccuracy());
        }
        if (((Location) (obj)).hasBearing())
        {
            builder.withCourse(((Location) (obj)).getBearing());
        }
        if (((Location) (obj)).hasSpeed())
        {
            builder.withSpeed(((Location) (obj)).getSpeed());
        }
        return builder.build();
    }
}
