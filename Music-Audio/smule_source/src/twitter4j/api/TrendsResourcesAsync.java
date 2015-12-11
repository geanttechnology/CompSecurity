// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.api;

import twitter4j.GeoLocation;

public interface TrendsResourcesAsync
{

    public abstract void getAvailableTrends();

    public abstract void getClosestTrends(GeoLocation geolocation);

    public abstract void getPlaceTrends(int i);
}
