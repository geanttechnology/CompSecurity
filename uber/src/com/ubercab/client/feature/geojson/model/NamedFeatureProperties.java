// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ubercab.client.feature.geojson.model;

import com.ubercab.rider.realtime.model.GeoJsonNamedFeatureProperties;

public interface NamedFeatureProperties
    extends GeoJsonNamedFeatureProperties
{

    public abstract String getId();

    public abstract String getName();

    public abstract String getShortName();
}
