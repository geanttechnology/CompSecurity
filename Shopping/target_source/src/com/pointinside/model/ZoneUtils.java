// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.location.Location;
import com.pointinside.internal.utils.LogUtils;

// Referenced classes of package com.pointinside.model:
//            Zone, ZoneImage

class ZoneUtils
{
    private static class CalculatedDistance
    {

        public double angleOffYAxisDeg;
        public double feet;
        public double meters;

        private CalculatedDistance()
        {
        }

    }

    private static class PointD
    {

        public double x;
        public double y;

        private PointD()
        {
        }

    }


    private static final double FEET_TO_METERS = 0.304799999536704D;
    private static final double FLATTENING = 0.0033528106647474805D;
    private static final double MAJOR_AXIS = 6378137D;
    private static final double METERS_TO_FEET = 3.2808399000000001D;
    private static final double MINOR_AXIS = 6356752.3141999999D;
    private static final String TAG = LogUtils.makeLogTag(com/pointinside/model/ZoneUtils.getSimpleName());

    ZoneUtils()
    {
    }

    private static double calculateAngleOffYAxis(double d, double d1)
    {
        double d3 = 0.0D;
        double d4 = Math.toDegrees(Math.atan(d1 / d));
        double d2;
        if (d >= 0.0D && d1 >= 0.0D)
        {
            d2 = 90D + d4;
        } else
        {
            if (d < 0.0D && d1 >= 0.0D)
            {
                return -(90D - d4);
            }
            if (d < 0.0D && d1 < 0.0D)
            {
                return -(90D - d4);
            }
            d2 = d3;
            if (d >= 0.0D)
            {
                d2 = d3;
                if (d1 < 0.0D)
                {
                    return 90D + d4;
                }
            }
        }
        return d2;
    }

    static CalculatedDistance calculateDirectDistanceBetweenPoints(Zone zone, PointD pointd, PointD pointd1)
    {
        convertMap2Svg(zone.getImage(), pointd);
        pointd1 = convertMap2Svg(zone.getImage(), pointd1);
        return calculateDistanceFromSvgXY(zone.getImage(), pointd, pointd1);
    }

    private static CalculatedDistance calculateDistance(double d, double d1, double d2, double d3)
    {
        d = Math.toRadians(d);
        double d4 = Math.toRadians(d1);
        d1 = Math.toRadians(d2);
        double d9 = Math.toRadians(d3) - d4;
        if (0.0D == d9 && Double.compare(d, d1) == 0)
        {
            CalculatedDistance calculateddistance = new CalculatedDistance();
            calculateddistance.feet = 0.0D;
            calculateddistance.meters = 0.0D;
            calculateddistance.angleOffYAxisDeg = 0.0D;
            return calculateddistance;
        }
        d2 = Math.atan(Math.tan(d) * 0.99664718933525254D);
        d = Math.atan(0.99664718933525254D * Math.tan(d1));
        double d11 = Math.sin(d2);
        double d12 = Math.cos(d2);
        double d13 = Math.sin(d);
        double d14 = Math.cos(d);
        double d8 = 6.2831853071795862D;
        int i = 20;
        double d7 = 0.0D;
        double d6 = 0.0D;
        double d5 = 0.0D;
        d4 = 0.0D;
        d3 = 0.0D;
        d2 = 0.0D;
        d1 = 0.0D;
        double d10;
        for (d = d9; Math.abs(d - d8) > 9.9999999999999998E-13D && i > 1; d = d10)
        {
            i--;
            d2 = Math.sin(d);
            d1 = Math.cos(d);
            d6 = Math.sqrt(d14 * d2 * (d14 * d2) + (d12 * d13 - d11 * d14 * d1) * (d12 * d13 - d11 * d14 * d1));
            d4 = d12 * d14 * d1 + d11 * d13;
            d3 = Math.atan2(d6, d4);
            d8 = Math.asin((d12 * d14 * d2) / d6);
            d5 = Math.cos(d8);
            d7 = Math.cos(d8) * d5;
            d5 = d4 - (2D * d11 * d13) / d7;
            d10 = 0.00020955066654671753D * d7 * (4D + 0.0033528106647474805D * (4D - 3D * d7));
            d10 = Math.sin(d8) * ((1.0D - d10) * 0.0033528106647474805D) * ((d10 * d4 * (-1D + 2D * d5 * d5) + d5) * (d10 * d6) + d3) + d9;
            d8 = d;
        }

        d = (d7 * 272331606681.94531D) / 40408299984087.055D;
        d7 = d / 16384D;
        d8 = (d * (-128D + (74D - 47D * d) * d) + 256D) * (d / 1024D);
        d9 = d8 / 4D;
        d = (d3 - ((d4 * (-1D + 2D * d5 * d5) - (d6 * (4D * d6) - 3D) * ((d8 / 6D) * d5) * (-3D + 4D * d5 * d5)) * d9 + d5) * (d8 * d6)) * (6356752.3141999999D * (1.0D + d7 * (4096D + (-768D + (320D - 175D * d) * d) * d)));
        d1 = Math.toDegrees(Math.atan2(d2 * d14, d12 * d13 - d1 * (d11 * d14)));
        CalculatedDistance calculateddistance1 = new CalculatedDistance();
        calculateddistance1.meters = d;
        calculateddistance1.feet = d * 3.2808399000000001D;
        calculateddistance1.angleOffYAxisDeg = d1;
        return calculateddistance1;
    }

    static CalculatedDistance calculateDistanceFromSvgXY(ZoneImage zoneimage, PointD pointd, PointD pointd1)
    {
        double d3 = zoneimage.getFtPerPxX();
        double d = zoneimage.getFtPerPxY();
        double d4 = pointd1.x;
        double d5 = pointd.x;
        double d1 = pointd1.y;
        double d2 = pointd.y;
        d3 *= d4 - d5;
        d1 = d * (d1 - d2);
        d = Math.sqrt(d3 * d3 + d1 * d1);
        d1 = calculateAngleOffYAxis(d3, d1);
        zoneimage = new CalculatedDistance();
        zoneimage.feet = d;
        zoneimage.meters = d * 0.304799999536704D;
        zoneimage.angleOffYAxisDeg = d1;
        return zoneimage;
    }

    static PointD convertMap2Svg(ZoneImage zoneimage, PointD pointd)
    {
        PointD pointd1 = new PointD();
        pointd1.x = pointd.x * (double)zoneimage.getBaseRatioX();
        pointd1.y = pointd.y * (double)zoneimage.getBaseRatioY();
        return pointd1;
    }

    static PointD convertSvg2Map(ZoneImage zoneimage, PointD pointd)
    {
        PointD pointd1 = new PointD();
        pointd1.x = pointd.x / (double)zoneimage.getBaseRatioX();
        pointd1.y = pointd.y / (double)zoneimage.getBaseRatioX();
        return pointd1;
    }

    static PointD getLatLngForReferencePoint(Zone zone, int i)
    {
        PointD pointd = new PointD();
        switch (i)
        {
        default:
            return pointd;

        case 1: // '\001'
            pointd.x = zone.getPoint1Latitude();
            pointd.y = zone.getPoint1Longitude();
            return pointd;

        case 2: // '\002'
            pointd.x = zone.getPoint2Latitude();
            pointd.y = zone.getPoint2Longitude();
            return pointd;

        case 3: // '\003'
            pointd.x = zone.getPoint3Latitude();
            pointd.y = zone.getPoint3Longitude();
            return pointd;

        case 4: // '\004'
            pointd.x = zone.getPoint4Latitude();
            break;
        }
        pointd.y = zone.getPoint4Longitude();
        return pointd;
    }

    private static Location getLatLonDestFromStartBearingRange(double d, double d1, double d2, double d3)
    {
        double d8 = d2 * 0.304799999536704D;
        if (Math.abs(d2) < 1.0D)
        {
            Location location = new Location("Location");
            location.setLatitude(d);
            location.setLongitude(d1);
            return location;
        }
        d = Math.toRadians(d);
        double d7 = Math.toRadians(d1);
        d1 = Math.toRadians(d3);
        double d9 = Math.sin(d1);
        double d10 = Math.cos(d1);
        d = Math.tan(d) * 0.99664718933525254D;
        double d12 = 1.0D / Math.sqrt(1.0D + d * d);
        double d13 = d * d12;
        double d15 = Math.atan2(d, d10);
        double d11 = d12 * d9;
        double d14 = 1.0D - d11 * d11;
        d = (272331606681.94531D * d14) / 40408299984087.055D;
        double d16 = 1.0D + (d / 16384D) * (4096D + (-768D + (320D - 175D * d) * d) * d);
        double d17 = (d / 1024D) * (d * (-128D + (74D - 47D * d) * d) + 256D);
        d = d8 / (6356752.3141999999D * d16);
        double d4 = 6.2831853071795862D;
        d3 = 0.0D;
        d2 = 0.0D;
        d1 = 0.0D;
        double d5;
        for (; Math.abs(d - d4) > 9.9999999999999998E-13D; d = d5)
        {
            d1 = Math.cos(2D * d15 + d);
            d3 = Math.sin(d);
            d2 = Math.cos(d);
            d5 = d17 * d3 * ((d17 / 4D) * ((-1D + 2D * d1 * d1) * d2 - (d17 / 6D) * d1 * (-3D + 4D * d3 * d3) * (-3D + 4D * d1 * d1)) + d1) + d8 / (6356752.3141999999D * d16);
            d4 = d;
        }

        d4 = d13 * d3 - d12 * d2 * d10;
        double d6 = Math.atan2(d13 * d2 + d12 * d3 * d10, 0.99664718933525254D * Math.sqrt(d11 * d11 + d4 * d4));
        d8 = Math.atan2(d9 * d3, d12 * d2 - d10 * (d13 * d3));
        d9 = 0.00020955066654671753D * d14 * (4D + 0.0033528106647474805D * (4D - d14 * 3D));
        Math.atan2(d11, -d4);
        Location location1 = new Location("Location");
        location1.setLatitude(Math.toDegrees(d6));
        location1.setLongitude(Math.toDegrees((d8 - ((d1 + d2 * d9 * (-1D + 2D * d1 * d1)) * (d3 * d9) + d) * ((1.0D - d9) * 0.0033528106647474805D * d11)) + d7));
        return location1;
    }

    static Location getLatLonOfXY(Zone zone, float f, float f1)
    {
        double d = 1.7976931348623157E+308D;
        double d1 = 0.0D;
        PointD pointd = new PointD();
        new PointD();
        PointD pointd1 = new PointD();
        PointD pointd2 = new PointD();
        pointd1.x = f;
        pointd1.y = f1;
        for (int i = 1; i < 5; i++)
        {
            PointD pointd3 = getXYForReferencePoint(zone, i);
            PointD pointd4 = getLatLngForReferencePoint(zone, i);
            getXYOfLatLon(zone, pointd4.x, pointd4.y);
            CalculatedDistance calculateddistance = calculateDirectDistanceBetweenPoints(zone, pointd3, pointd1);
            if (calculateddistance.feet < d)
            {
                d = calculateddistance.feet;
                d1 = calculateddistance.angleOffYAxisDeg;
                pointd2.x = pointd3.x;
                pointd2.y = pointd3.y;
                pointd.x = pointd4.x;
                pointd.y = pointd4.y;
            }
        }

        double d2 = calculateDistance(zone.getPoint2Latitude(), zone.getPoint2Longitude(), zone.getPoint1Latitude(), zone.getPoint1Longitude()).angleOffYAxisDeg;
        return getLatLonDestFromStartBearingRange(pointd.x, pointd.y, d, d2 + d1);
    }

    static PointD getXYForReferencePoint(Zone zone, int i)
    {
        PointD pointd = new PointD();
        switch (i)
        {
        default:
            return pointd;

        case 1: // '\001'
            pointd.x = zone.getPoint1PixelX();
            pointd.y = zone.getPoint1PixelY();
            return pointd;

        case 2: // '\002'
            pointd.x = zone.getPoint2PixelX();
            pointd.y = zone.getPoint2PixelY();
            return pointd;

        case 3: // '\003'
            pointd.x = zone.getPoint3PixelX();
            pointd.y = zone.getPoint3PixelY();
            return pointd;

        case 4: // '\004'
            pointd.x = zone.getPoint4PixelX();
            break;
        }
        pointd.y = zone.getPoint4PixelY();
        return pointd;
    }

    static com.pointinside.maps.Location getXYOfLatLon(Zone zone, double d, double d1)
    {
        double d2 = 1.7976931348623157E+308D;
        CalculatedDistance calculateddistance = null;
        int k = 1;
        double d3 = 0.0D;
        int i = 1;
        while (i < 5) 
        {
            int j;
            if (i == 1)
            {
                calculateddistance = calculateDistance(zone.getPoint1Latitude(), zone.getPoint1Longitude(), d, d1);
            } else
            if (i == 2)
            {
                calculateddistance = calculateDistance(zone.getPoint2Latitude(), zone.getPoint2Longitude(), d, d1);
            } else
            if (i == 3)
            {
                calculateddistance = calculateDistance(zone.getPoint3Latitude(), zone.getPoint3Longitude(), d, d1);
            } else
            if (i == 4)
            {
                calculateddistance = calculateDistance(zone.getPoint4Latitude(), zone.getPoint4Longitude(), d, d1);
            } else
            {
                LogUtils.logV(TAG, "getXYOfLatLon() failed to get valid point");
            }
            float f;
            float f1;
            if (calculateddistance.feet < d2)
            {
                d2 = calculateddistance.feet;
                d3 = calculateddistance.angleOffYAxisDeg;
                j = i;
            } else
            {
                j = k;
            }
            i++;
            k = j;
        }
        d = calculateDistance(zone.getPoint2Latitude(), zone.getPoint2Longitude(), zone.getPoint1Latitude(), zone.getPoint1Longitude()).angleOffYAxisDeg;
        Math.toRadians(d);
        d1 = d3 - d;
        d = d1;
        if (d1 > 180D)
        {
            d = d1 - 360D;
        }
        d1 = d;
        if (d < -180D)
        {
            d1 = d + 360D;
        }
        if (d1 > 0.0D && d1 < 90D)
        {
            d = Math.toRadians(d1);
            j = (int)((Math.sin(d) * d2) / (double)zone.getFeetPerPixelX());
            i = (int)((Math.cos(d) * d2) / (double)zone.getFeetPerPixelY());
        } else
        if (d1 < 0.0D && d1 > -90D)
        {
            d = Math.toRadians(d1);
            j = (int)((Math.sin(d) * d2) / (double)zone.getFeetPerPixelX());
            i = (int)((Math.cos(d) * d2) / (double)zone.getFeetPerPixelY());
        } else
        if (d1 < -90D && d1 > -180D)
        {
            d = Math.toRadians(-d1 - 90D);
            j = -(int)((Math.cos(d) * d2) / (double)zone.getFeetPerPixelX());
            i = -(int)((Math.sin(d) * d2) / (double)zone.getFeetPerPixelY());
        } else
        if (d1 > 90D && d1 < 180D)
        {
            d = Math.toRadians(d1 - 90D);
            j = (int)((Math.cos(d) * d2) / (double)zone.getFeetPerPixelX());
            i = -(int)((Math.sin(d) * d2) / (double)zone.getFeetPerPixelY());
        } else
        if (d1 == 0.0D)
        {
            i = (int)(d2 / (double)zone.getFeetPerPixelY());
            j = 0;
        } else
        if (d1 == 90D)
        {
            j = (int)(d2 / (double)zone.getFeetPerPixelX());
            i = 0;
        } else
        if (d1 == -90D)
        {
            j = -(int)(d2 / (double)zone.getFeetPerPixelX());
            i = 0;
        } else
        if (d1 == 180D)
        {
            i = -(int)(d2 / (double)zone.getFeetPerPixelY());
            j = 0;
        } else
        {
            LogUtils.logV(TAG, "Could not get the correct angle");
            i = 0;
            j = 0;
        }
        if (k == 1)
        {
            f1 = zone.getPoint1PixelX();
            f = zone.getPoint1PixelY();
        } else
        if (k == 2)
        {
            f1 = zone.getPoint2PixelX();
            f = zone.getPoint2PixelY();
        } else
        if (k == 3)
        {
            f1 = zone.getPoint3PixelX();
            f = zone.getPoint3PixelY();
        } else
        if (k == 4)
        {
            f1 = zone.getPoint4PixelX();
            f = zone.getPoint4PixelY();
        } else
        {
            LogUtils.logV(TAG, "Didn't get a valid point");
            f = 0.0F;
            f1 = 0.0F;
        }
        f1 = (f1 + (float)j) / zone.getImage().getBaseRatioX();
        f = (f - (float)i) / zone.getImage().getBaseRatioY();
        return (new com.pointinside.maps.Location.Builder()).x(f1).y(f).zone(zone.getUUID()).venue(zone.getVenueUUID()).build();
    }

    private static double orientationDegrees(Zone zone)
    {
        double d1 = calculateDistance(zone.getPoint2Latitude(), zone.getPoint2Longitude(), zone.getPoint1Latitude(), zone.getPoint1Longitude()).angleOffYAxisDeg;
        double d;
        if (d1 < 0.0D)
        {
            d = d1 + 360D;
        } else
        {
            d = d1;
            if (d1 >= 360D)
            {
                return d1 - 360D;
            }
        }
        return d;
    }

    public static double zoneHeadingForTrueHeading(Zone zone, double d)
    {
        double d1 = (360D - orientationDegrees(zone)) + d;
        d = d1;
        if (d1 >= 360D)
        {
            d = d1 - 360D;
        }
        return d;
    }

}
