// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.widget.Toast;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.Place;
import com.groupon.models.error.GrouponException;
import com.groupon.util.GeoUtils;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.io.IOException;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class val.keyword extends Http
{

    final NearbyDealsFragment this$0;
    final String val$keyword;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        List list;
        try
        {
            list = NearbyDealsFragment.access$2300(NearbyDealsFragment.this).getFromLocationName(Strings.toString(val$keyword), 1);
        }
        catch (IOException ioexception)
        {
            ((GeoUtils)NearbyDealsFragment.access$2400(NearbyDealsFragment.this).get()).logGeocodeException(ioexception, getClass().getSimpleName());
            throw new GrouponException(getString(0x7f080162));
        }
        return list;
    }

    protected void onException(Exception exception)
    {
        setLocationAndReload(null, oadReason.locationSet);
        super.onException(exception);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((List)obj);
    }

    protected void onSuccess(List list)
        throws Exception
    {
        String s = null;
        if (list != null && list.size() > 0)
        {
            list = (Address)list.get(0);
            s = ((GeoUtils)NearbyDealsFragment.access$2400(NearbyDealsFragment.this).get()).toString(list);
            list = new Place(s, s, list.getLatitude(), list.getLongitude());
            NearbyDealsFragment.access$2000(NearbyDealsFragment.this).saveRecentLocation(list);
        } else
        {
            Toast.makeText(NearbyDealsFragment.access$2500(NearbyDealsFragment.this).getApplicationContext(), getString(0x7f080155), 1).show();
            list = s;
        }
        setLocationAndReload(list, oadReason.locationSet);
    }

    eWrapper(SyncHttp synchttp, String s)
    {
        this$0 = final_nearbydealsfragment;
        val$keyword = s;
        super(Context.this, synchttp);
    }
}
