// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j.api;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.ResponseList;

public interface PlacesGeoResources
{

    public abstract Place getGeoDetails(String s);

    public abstract ResponseList getSimilarPlaces(GeoLocation geolocation, String s, String s1, String s2);

    public abstract ResponseList reverseGeoCode(GeoQuery geoquery);

    public abstract ResponseList searchPlaces(GeoQuery geoquery);
}
