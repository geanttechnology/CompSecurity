// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.util;

import com.pointinside.model.Venue;

public abstract class VenueLoaderListener
    implements VenueLoader.IVenueLoader
{

    public VenueLoaderListener()
    {
    }

    public void onVenueCacheRefresh(Venue venue)
    {
    }

    public void onVenueLoadError(Exception exception)
    {
    }

    public void onVenueRetrieved(Venue venue)
    {
    }
}
