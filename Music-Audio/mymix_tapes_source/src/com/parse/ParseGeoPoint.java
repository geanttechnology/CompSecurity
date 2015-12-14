// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.location.Criteria;
import android.location.Location;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            Parse, LocationNotifier, LocationCallback

public class ParseGeoPoint
{

    static double EARTH_MEAN_RADIUS_KM = 6371D;
    static double EARTH_MEAN_RADIUS_MILE = 3958.8000000000002D;
    private double latitude;
    private double longitude;

    public ParseGeoPoint()
    {
        latitude = 0.0D;
        longitude = 0.0D;
    }

    public ParseGeoPoint(double d, double d1)
    {
        latitude = 0.0D;
        longitude = 0.0D;
        setLatitude(d);
        setLongitude(d1);
    }

    public static Task getCurrentLocationInBackground(long l)
    {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(0);
        criteria.setPowerRequirement(0);
        return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), l, criteria).onSuccess(new Continuation() {

            public ParseGeoPoint then(Task task)
                throws Exception
            {
                task = (Location)task.getResult();
                return new ParseGeoPoint(task.getLatitude(), task.getLongitude());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        });
    }

    public static Task getCurrentLocationInBackground(long l, Criteria criteria)
    {
        return LocationNotifier.getCurrentLocationAsync(Parse.getApplicationContext(), l, criteria).onSuccess(new Continuation() {

            public ParseGeoPoint then(Task task)
                throws Exception
            {
                task = (Location)task.getResult();
                return new ParseGeoPoint(task.getLatitude(), task.getLongitude());
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        });
    }

    public static void getCurrentLocationInBackground(long l, Criteria criteria, LocationCallback locationcallback)
    {
        Parse.callbackOnMainThreadAsync(getCurrentLocationInBackground(l, criteria), locationcallback);
    }

    public static void getCurrentLocationInBackground(long l, LocationCallback locationcallback)
    {
        Parse.callbackOnMainThreadAsync(getCurrentLocationInBackground(l), locationcallback);
    }

    public double distanceInKilometersTo(ParseGeoPoint parsegeopoint)
    {
        return distanceInRadiansTo(parsegeopoint) * EARTH_MEAN_RADIUS_KM;
    }

    public double distanceInMilesTo(ParseGeoPoint parsegeopoint)
    {
        return distanceInRadiansTo(parsegeopoint) * EARTH_MEAN_RADIUS_MILE;
    }

    public double distanceInRadiansTo(ParseGeoPoint parsegeopoint)
    {
        double d = latitude * 0.017453292519943295D;
        double d3 = longitude;
        double d1 = parsegeopoint.getLatitude() * 0.017453292519943295D;
        double d4 = parsegeopoint.getLongitude();
        double d2 = Math.sin((d - d1) / 2D);
        d3 = Math.sin((d3 * 0.017453292519943295D - d4 * 0.017453292519943295D) / 2D);
        return 2D * Math.asin(Math.sqrt(Math.min(1.0D, d2 * d2 + Math.cos(d) * Math.cos(d1) * d3 * d3)));
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLatitude(double d)
    {
        if (d > 90D || d < -90D)
        {
            throw new IllegalArgumentException("Latitude must be within the range (-90.0, 90.0).");
        } else
        {
            latitude = d;
            return;
        }
    }

    public void setLongitude(double d)
    {
        if (d > 180D || d < -180D)
        {
            throw new IllegalArgumentException("Longitude must be within the range (-180.0, 180.0).");
        } else
        {
            longitude = d;
            return;
        }
    }

    public String toString()
    {
        return String.format("ParseGeoPoint[%.6f,%.6f]", new Object[] {
            Double.valueOf(latitude), Double.valueOf(longitude)
        });
    }

}
