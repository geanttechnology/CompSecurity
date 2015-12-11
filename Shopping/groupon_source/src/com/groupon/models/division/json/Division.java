// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.division.json;

import com.groupon.util.GeoPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.groupon.models.division.json:
//            Area

public class Division extends Area
{
    public static class List
    {

        public ArrayList divisions;

        public List()
        {
        }
    }


    public String areaId;
    public java.util.List areas;
    public String country;
    public GeoPoint geoPoint;
    public boolean isReserveEnabled;
    public long latE6;
    public long lngE6;
    public String timezone;
    public String timezoneIdentifier;
    public int timezoneOffsetInSeconds;

    public Division()
    {
        areas = Collections.EMPTY_LIST;
    }
}
