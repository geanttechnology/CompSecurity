// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.division.converter;

import com.groupon.models.country.Country;
import com.groupon.models.division.json.Area;
import com.groupon.models.division.json.Division;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.GeoPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import roboguice.util.Strings;

public class DivisionConverter
{

    private static final String COUNTRY_CANADA = "Canada";
    private static final String COUNTRY_USA = "USA";
    CurrentCountryManager currentCountryManager;

    public DivisionConverter()
    {
    }

    private void doFilterUSCanadaDivisions(List list)
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            String s;
            if (Strings.equalsIgnoreCase(currentCountryManager.getCurrentCountry().shortName, "ca"))
            {
                s = "Canada";
            } else
            {
                s = "USA";
            }
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                if (!Strings.equalsIgnoreCase(((Division)list.next()).country, s))
                {
                    list.remove();
                }
            } while (true);
        }
    }

    public List fromJson(com.groupon.models.division.json.Division.List list)
    {
        ArrayList arraylist = new ArrayList();
        doFilterUSCanadaDivisions(list.divisions);
        for (list = list.divisions.listIterator(); list.hasNext(); arraylist.addAll(fromJson((Division)list.next()))) { }
        return arraylist;
    }

    public List fromJson(Division division)
    {
        Object obj;
        com.groupon.models.division.Division division1;
        obj = division.areas;
        division1 = new com.groupon.models.division.Division();
        division1.id = division.id;
        division1.name = division.name;
        division1.latE6 = (long)(division.lat * 1000000D);
        division1.lngE6 = (long)(division.lng * 1000000D);
        division1.geoPoint = new GeoPoint((int)division1.latE6, (int)division1.lngE6);
        division1.isReserveEnabled = division.isReserveEnabled;
        division1.timezoneIdentifier = division.timezoneIdentifier;
        division1.timezone = division.timezone;
        division1.timezoneOffsetInSeconds = division.timezoneOffsetInSeconds;
        if (obj != null && !((List) (obj)).isEmpty()) goto _L2; else goto _L1
_L1:
        obj = Arrays.asList(new com.groupon.models.division.Division[] {
            division1
        });
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            Area area = (Area)iterator.next();
            Object obj1 = area.name;
            obj = obj1;
            if (!((String) (obj1)).startsWith(division1.name))
            {
                obj = obj1;
                if (!currentCountryManager.getCurrentCountry().shouldUseDivisionAsHeader())
                {
                    obj = (new StringBuilder()).append(division1.name).append(" - ").append(area.name).toString();
                }
            }
            obj1 = new com.groupon.models.division.Division();
            obj1.id = area.id;
            obj1.name = ((String) (obj));
            obj1.latE6 = (long)(area.lat * 1000000D);
            obj1.lngE6 = (long)(area.lng * 1000000D);
            obj1.geoPoint = new GeoPoint((int)((com.groupon.models.division.Division) (obj1)).latE6, (int)((com.groupon.models.division.Division) (obj1)).lngE6);
            obj1.parent = division1;
            obj1.isReserveEnabled = division.isReserveEnabled;
            obj1.timezoneIdentifier = division.timezoneIdentifier;
            obj1.timezone = division.timezone;
            obj1.timezoneOffsetInSeconds = division.timezoneOffsetInSeconds;
            arraylist.add(obj1);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }
}
