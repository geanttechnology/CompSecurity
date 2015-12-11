// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.model;

import android.content.Context;
import android.content.SharedPreferences;
import com.pointinside.feeds.VenueEntity;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.net.VenueCacheIOException;
import com.pointinside.net.requestor.AllVenueFeedRequestor;
import com.pointinside.net.requestor.RequestorFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pointinside.model:
//            CacheController, Venue, Zone

public class VenueFactory
{

    private static final String SHARED_PREFERENCES_FILE = "VenueCacheSvgLocations";
    private static final String TAG = com/pointinside/model/VenueFactory.getSimpleName();
    private static SharedPreferences prefs = null;
    CacheController mCache;

    public VenueFactory(Context context)
    {
        mCache = CacheController.getInstance(context.getApplicationContext());
        prefs = context.getSharedPreferences("VenueCacheSvgLocations", 0);
    }

    private List getAllVenues()
    {
        Object obj;
        LinkedList linkedlist;
        obj = new LinkedList();
        linkedlist = new LinkedList();
        List list = RequestorFactory.newAllVenueRequestor().fetchAll();
        obj = list;
_L2:
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); linkedlist.add(Venue.newShallow(this, (VenueEntity)((Iterator) (obj)).next()))) { }
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        LogUtils.logW(TAG, "All-venues Feed request failed. ", ioexception);
        if (true) goto _L2; else goto _L1
_L1:
        return Collections.unmodifiableList(linkedlist);
    }

    private transient List getCachedVenues(String as[], com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        throws VenueCacheIOException
    {
        ArrayList arraylist = new ArrayList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            arraylist.addAll(mCache.fetchCacheableIfExists(Venue.newEmpty(s)));
        }

        for (as = arraylist.iterator(); as.hasNext(); ((Venue)as.next()).overrideImageType(aimagetype)) { }
        return arraylist;
    }

    protected static String getSvgGuid(String s)
    {
        return prefs.getString(s, null);
    }

    private transient List getVenuesById(String as[], com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        throws VenueCacheIOException
    {
        ArrayList arraylist = new ArrayList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            arraylist.addAll(mCache.fetch(Venue.newEmpty(s)));
        }

        for (as = arraylist.iterator(); as.hasNext();)
        {
            Object obj = (Venue)as.next();
            ((Venue) (obj)).overrideImageType(aimagetype);
            obj = ((Venue) (obj)).getAllZones().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Zone zone = (Zone)((Iterator) (obj)).next();
                mCache.fetch(zone.getImage());
            }
        }

        return arraylist;
    }

    protected static void saveSvgFileGuid(String s, String s1)
    {
        prefs.edit().putString(s, s1).commit();
    }

    public transient Venue getCachedVenue(String s, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        throws VenueCacheIOException
    {
        s = getCachedVenues(new String[] {
            s
        }, aimagetype);
        if (s.isEmpty())
        {
            return null;
        } else
        {
            return (Venue)s.get(0);
        }
    }

    public transient Venue getVenueById(String s, com.pointinside.feeds.ZoneImageEntity.ImageType aimagetype[])
        throws VenueCacheIOException
    {
        s = getVenuesById(new String[] {
            s
        }, aimagetype);
        if (s.isEmpty())
        {
            return null;
        } else
        {
            return (Venue)s.get(0);
        }
    }

    public void refreshCache(Venue venue)
    {
        mCache.refresh(venue);
        Zone zone;
        for (venue = venue.getAllZones().iterator(); venue.hasNext(); mCache.refresh(zone.getImage()))
        {
            zone = (Zone)venue.next();
        }

    }

}
