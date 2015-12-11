// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.groupon.models.LocationSuggestion;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GeoUtils, DivisionUtil, CountryUtil, Function1, 
//            GrouponRoboAsyncTask

public class LocationSearchUtil
{

    private Context context;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private DivisionUtil divisionUtil;
    private GeoUtils geoUtils;

    public LocationSearchUtil()
    {
    }

    public void geocoderSearchForLocation(Function1 function1, Function1 function1_1, String s, int i)
    {
        (new GrouponRoboAsyncTask(function1_1) {

            final LocationSearchUtil this$0;
            final Function1 val$exceptionListener;
            final String val$locationKeyword;
            final int val$numberOfAddresses;
            final Function1 val$successListener;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public List call()
                throws Exception
            {
                Object obj = (new Geocoder(context, countryUtil.getLocale(currentCountryManager.getCurrentCountry()))).getFromLocationName(Strings.toString(locationKeyword), numberOfAddresses);
                String s1 = currentCountryManager.getCurrentCountry().shortName;
                ArrayList arraylist = new ArrayList();
                if (obj != null && !((List) (obj)).isEmpty())
                {
                    obj = ((List) (obj)).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        Address address = (Address)((Iterator) (obj)).next();
                        if (Strings.equalsIgnoreCase(address.getCountryCode(), countryUtil.reverseTransformIsoImperfections(s1)))
                        {
                            arraylist.add(address);
                        }
                    } while (true);
                    return getPlacesFromGeocoderAddress(arraylist);
                } else
                {
                    return null;
                }
            }

            protected void onException(Exception exception)
            {
                super.onException(exception);
                exceptionListener.execute(exception);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((List)obj);
            }

            protected void onSuccess(List list)
                throws Exception
            {
                super.onSuccess(list);
                successListener.execute(list);
            }

            
            {
                this$0 = LocationSearchUtil.this;
                locationKeyword = s;
                numberOfAddresses = i;
                successListener = function1;
                exceptionListener = function1_1;
                super(final_context1);
            }
        }).execute();
    }

    public List getPlacesFromGeocoderAddress(List list)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator = list.iterator();
            do
            {
                list = arraylist;
                if (!iterator.hasNext())
                {
                    break;
                }
                list = (Address)iterator.next();
                Object obj = geoUtils.toString(list);
                obj = new Place(((String) (obj)), ((String) (obj)), list.getLatitude(), list.getLongitude());
                obj.label = divisionUtil.getCityNameFromAddress(list);
                arraylist.add(obj);
            } while (true);
        } else
        {
            list = null;
        }
        return list;
    }

    public List getPlacesFromLocationSuggestions(List list)
    {
        ArrayList arraylist = new ArrayList();
        Place place;
        for (list = list.iterator(); list.hasNext(); arraylist.add(place))
        {
            LocationSuggestion locationsuggestion = (LocationSuggestion)list.next();
            place = new Place("location-query-search", locationsuggestion.lat, locationsuggestion.lng, locationsuggestion.value, locationsuggestion.label);
            place.name = locationsuggestion.value;
        }

        return arraylist;
    }


}
