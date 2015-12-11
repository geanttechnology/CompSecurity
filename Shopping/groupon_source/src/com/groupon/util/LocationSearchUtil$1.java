// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            GrouponRoboAsyncTask, LocationSearchUtil, CountryUtil, Function1

class <init> extends GrouponRoboAsyncTask
{

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
        Object obj = (new Geocoder(context, LocationSearchUtil.access$100(LocationSearchUtil.this).getLocale(LocationSearchUtil.access$000(LocationSearchUtil.this).getCurrentCountry()))).getFromLocationName(Strings.toString(val$locationKeyword), val$numberOfAddresses);
        String s = LocationSearchUtil.access$000(LocationSearchUtil.this).getCurrentCountry().shortName;
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
                if (Strings.equalsIgnoreCase(address.getCountryCode(), LocationSearchUtil.access$100(LocationSearchUtil.this).reverseTransformIsoImperfections(s)))
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
        val$exceptionListener.execute(exception);
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
        val$successListener.execute(list);
    }

    .CurrentCountryManager(Function1 function1_1)
    {
        this$0 = final_locationsearchutil;
        val$locationKeyword = s;
        val$numberOfAddresses = i;
        val$successListener = Function1.this;
        val$exceptionListener = function1_1;
        super(final_context);
    }
}
