// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.analytics;

import android.location.Location;

public abstract class BaseAnalyticsData
{
    protected static abstract class Builder
    {

        private Float accuracy;
        private String custData;
        private Long datetime;
        private Double lat;
        private Double lng;
        private String proximity;
        private Long userLocTime;

        public Builder custData(String s)
        {
            custData = s;
            return getThis();
        }

        public Builder datetime(long l)
        {
            datetime = Long.valueOf(l);
            return getThis();
        }

        protected abstract Builder getThis();

        public Builder location(Location location1)
        {
            if (location1 != null)
            {
                lat = Double.valueOf(location1.getLatitude());
                lng = Double.valueOf(location1.getLongitude());
                userLocTime = Long.valueOf(location1.getTime());
                accuracy = Float.valueOf(location1.getAccuracy());
            }
            return getThis();
        }

        public Builder proximity(String s)
        {
            proximity = s;
            return getThis();
        }








        public Builder()
        {
            datetime = null;
            userLocTime = null;
            custData = null;
            proximity = null;
            accuracy = null;
            lat = null;
            lng = null;
        }
    }


    public final Float accuracy;
    public final String custData;
    public final Long datetime;
    public final Double lat;
    public final Double lng;
    public final String proximity;
    public final Long userLocTime;

    protected BaseAnalyticsData(Builder builder)
    {
        userLocTime = builder.userLocTime;
        accuracy = builder.accuracy;
        custData = builder.custData;
        lat = builder.lat;
        lng = builder.lng;
        proximity = builder.proximity;
        datetime = builder.datetime;
    }

    public Location getLocation()
    {
        Location location = new Location("AnalyticsData");
        if (lat != null && !Double.isNaN(lat.doubleValue()))
        {
            location.setLatitude(lat.doubleValue());
        }
        if (lng != null && !Double.isNaN(lng.doubleValue()))
        {
            location.setLongitude(lng.doubleValue());
        }
        if (accuracy != null && !Float.isNaN(accuracy.floatValue()))
        {
            location.setAccuracy(accuracy.floatValue());
        }
        if (userLocTime != null)
        {
            location.setTime(userLocTime.longValue());
        }
        return location;
    }
}
