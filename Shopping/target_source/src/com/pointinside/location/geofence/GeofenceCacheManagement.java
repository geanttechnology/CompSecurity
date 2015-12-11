// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import com.google.b.f;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.pointinside.PIMapsAccessor;
import com.pointinside.feeds.VenueEntity;
import com.pointinside.internal.utils.LogUtils;
import com.pointinside.json.ResponseFeedsVenuesByLocation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pointinside.location.geofence:
//            VenuesLoaderTask

class GeofenceCacheManagement
{
    private static class PlaceHolder
    {

        String data;
        int inputModifiedSince;
        String status;

        private PlaceHolder()
        {
        }
    }

    private static interface VenueCacheUpdateListener
    {

        public abstract void onVenueCacheUpdate(Location location);
    }

    static interface VenueLookupListener
    {

        public abstract void onSuccessfulLookup(VenueEntity venueentity);
    }


    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/location/geofence/GeofenceCacheManagement.getSimpleName());
    static final String PREFS = "requestCache";
    private static final long SEVENTY_MILES_IN_METERS = 0x1b80eL;
    private static GeofenceCacheManagement sInstance = null;
    private static final long sStaleRequestTimeInterval = 0x127500L;
    private final String CACHE_COUNT = "count";
    private final String LATITUDE = "lat";
    private final String LONGITUDE = "lng";
    private final String TIME_STAMP = "time";
    private long mCachedFileDate;
    private List mCachedVenues;
    private HashMap mRequestCache;

    private GeofenceCacheManagement()
    {
        mCachedFileDate = 0xffffffff80000000L;
    }

    private void clearAndReWriteRequestCacheIntoSharedPrefs(Context context, HashMap hashmap)
    {
        Iterator iterator;
        int i;
        hashmap = context.getSharedPreferences("requestCache", 0).edit();
        hashmap.clear().commit();
        iterator = mRequestCache.entrySet().iterator();
        i = 1;
_L3:
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        obj = (Location)((java.util.Map.Entry)iterator.next()).getKey();
        context = new JSONObject();
        context.put("lat", ((Location) (obj)).getLatitude());
        context.put("lng", ((Location) (obj)).getLongitude());
        context.put("time", ((Location) (obj)).getTime());
        hashmap.putInt("count", i);
        obj = (new StringBuilder()).append("requestCache").append(i).toString();
        if (context instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        context = context.toString();
_L1:
        hashmap.putString(((String) (obj)), context);
        hashmap.commit();
        i++;
        continue; /* Loop/switch isn't completed */
        context = JSONObjectInstrumentation.toString((JSONObject)context);
          goto _L1
        context;
        LogUtils.logE("JSON Exception", context.toString());
        if (true) goto _L3; else goto _L2
_L2:
    }

    private File getDataFile()
        throws IOException
    {
        File file = new File(Environment.getExternalStorageDirectory(), PIMapsAccessor.getInstance().getContext().getPackageName());
        if (!file.exists() && !file.mkdirs())
        {
            throw new IOException("Error creating directory");
        } else
        {
            return new File(file, "geofence.json");
        }
    }

    public static GeofenceCacheManagement getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new GeofenceCacheManagement();
            sInstance.retrievePersistedData();
        }
        return sInstance;
    }

    private HashMap getRequestCacheFromSharedPrefs(Context context)
    {
        HashMap hashmap;
        int j;
        context = context.getSharedPreferences("requestCache", 0);
        hashmap = new HashMap();
        j = context.getInt("count", 0);
        if (j != 0) goto _L2; else goto _L1
_L1:
        return hashmap;
_L2:
        int i = 0;
_L4:
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = context.getString((new StringBuilder()).append("requestCache").append(i).toString(), null);
        if (obj != null)
        {
            try
            {
                obj = JSONObjectInstrumentation.init(((String) (obj)));
                Location location = new Location("cachedLocation");
                location.setLatitude(((JSONObject) (obj)).getDouble("lat"));
                location.setLongitude(((JSONObject) (obj)).getDouble("lng"));
                location.setTime(((JSONObject) (obj)).getLong("time"));
                hashmap.put(location, Long.valueOf(location.getTime()));
            }
            catch (JSONException jsonexception)
            {
                LogUtils.logE("JSON Exception", jsonexception.toString());
            }
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
    }

    private boolean isOlderThanTwoWeeks(long l)
    {
        return l < System.currentTimeMillis() - 0x48190800L;
    }

    private void persistRetrievedData(String s)
    {
        Object obj;
        try
        {
            obj = getDataFile();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = new FileOutputStream(((File) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        ((FileOutputStream) (obj)).write(s.getBytes());
        ((FileOutputStream) (obj)).flush();
        ((FileOutputStream) (obj)).close();
    }

    private void removeTwoWeekOldCacheData(Context context, long l)
    {
        Iterator iterator = mRequestCache.entrySet().iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (l - ((Long)((java.util.Map.Entry)iterator.next()).getValue()).longValue() >= 0x127500L)
            {
                iterator.remove();
                flag = true;
            }
        } while (true);
        if (flag)
        {
            clearAndReWriteRequestCacheIntoSharedPrefs(context, mRequestCache);
        }
    }

    private void retrievePersistedData()
    {
        Object obj;
        long l;
        obj = getDataFile();
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        l = ((File) (obj)).lastModified();
        if (0x48190800L + l < System.currentTimeMillis())
        {
            return;
        }
        FileInputStream fileinputstream;
        mCachedFileDate = l;
        fileinputstream = new FileInputStream(((File) (obj)));
        if (fileinputstream == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        obj = "";
        InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream);
        if (inputstreamreader == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = ((String) (obj)).concat(s);
          goto _L1
        mCachedVenues = ((ResponseFeedsVenuesByLocation)(new f()).a(((String) (obj)), com/pointinside/json/ResponseFeedsVenuesByLocation)).getData();
        inputstreamreader.close();
        bufferedreader.close();
        fileinputstream.close();
        return;
        Object obj1;
        obj1;
        ((IOException) (obj1)).printStackTrace();
        return;
        obj1;
        ((Exception) (obj1)).printStackTrace();
    }

    private void updateRequestCacheIntoSharedPrefs(Context context, Location location)
    {
        android.content.SharedPreferences.Editor editor;
        context = context.getSharedPreferences("requestCache", 0);
        editor = context.edit();
        int i = context.getInt("count", 0);
        context = new JSONObject();
        context.put("lat", location.getLatitude());
        context.put("lng", location.getLongitude());
        context.put("time", location.getTime());
        editor.putInt("count", i + 1);
        location = (new StringBuilder()).append("requestCache").append(i).toString();
        if (context instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        context = context.toString();
_L1:
        editor.putString(location, context);
        editor.commit();
        return;
        try
        {
            context = JSONObjectInstrumentation.toString((JSONObject)context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            LogUtils.logE("JSON Exception", context.toString());
            return;
        }
          goto _L1
    }

    void addRequestCacheParams(Context context, Location location)
    {
        mRequestCache.put(location, Long.valueOf(location.getTime()));
        updateRequestCacheIntoSharedPrefs(context, location);
    }

    void doVenueLookup(Context context, Location location, final VenueLookupListener listener)
    {
        if (!isCacheValidForLocation(context, location))
        {
            updateVenueCacheForLocation(context, location, new VenueCacheUpdateListener() {

                final GeofenceCacheManagement this$0;
                final VenueLookupListener val$listener;

                public void onVenueCacheUpdate(Location location1)
                {
                    location1 = getNearestVenue(location1);
                    if (location1 != null)
                    {
                        listener.onSuccessfulLookup(location1);
                        return;
                    } else
                    {
                        LogUtils.logE(GeofenceCacheManagement.LOG_TAG, "Cache returned null for nearest Venue Lookup.");
                        return;
                    }
                }

            
            {
                this$0 = GeofenceCacheManagement.this;
                listener = venuelookuplistener;
                super();
            }
            });
            return;
        } else
        {
            listener.onSuccessfulLookup(getNearestVenue(location));
            return;
        }
    }

    VenueEntity getNearestVenue(Location location)
    {
        VenueEntity venueentity1 = null;
        VenueEntity venueentity = null;
        if (mCachedVenues != null)
        {
            double d = 1.7976931348623157E+308D;
            Iterator iterator = mCachedVenues.iterator();
            do
            {
                venueentity1 = venueentity;
                if (!iterator.hasNext())
                {
                    break;
                }
                venueentity1 = (VenueEntity)iterator.next();
                Location location1 = new Location("CacheLocation");
                location1.setLongitude(venueentity1.longitude);
                location1.setLatitude(venueentity1.latitude);
                double d1 = location.distanceTo(location1);
                if (d1 < d)
                {
                    venueentity = venueentity1;
                    d = d1;
                }
            } while (true);
        }
        return venueentity1;
    }

    boolean isCacheValidForLocation(Context context, Location location)
    {
        mRequestCache = getRequestCacheFromSharedPrefs(context);
        removeTwoWeekOldCacheData(context, location.getTime());
        LogUtils.logD(LOG_TAG, (new StringBuilder()).append("Checking cache valid for (").append(location.getLatitude()).append(" ").append(location.getLongitude()).append(")").toString());
        Object obj = mRequestCache.entrySet().iterator();
        boolean flag = true;
        while (((Iterator) (obj)).hasNext()) 
        {
            context = (java.util.Map.Entry)((Iterator) (obj)).next();
            String s;
            StringBuilder stringbuilder;
            boolean flag1;
            if (location.distanceTo((Location)context.getKey()) > 112654F)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag &= flag1;
            s = LOG_TAG;
            stringbuilder = (new StringBuilder()).append("-----(").append(((Location)context.getKey()).getLatitude()).append(" ").append(((Location)context.getKey()).getLongitude()).append(") is ");
            if (flag1)
            {
                context = "further";
            } else
            {
                context = "closer";
            }
            LogUtils.logD(s, stringbuilder.append(context).append(" than 70 miles").toString());
        }
        location = LOG_TAG;
        obj = (new StringBuilder()).append("cache is valid? ");
        if (!flag)
        {
            context = "yes";
        } else
        {
            context = "no";
        }
        LogUtils.logD(location, ((StringBuilder) (obj)).append(context).toString());
        return !flag;
    }

    void updateVenueCacheForLocation(final Context final_context, final Location final_location, VenueCacheUpdateListener venuecacheupdatelistener)
    {
        if (mCachedVenues != null)
        {
            if (!isOlderThanTwoWeeks(mCachedFileDate))
            {
                if (venuecacheupdatelistener != null)
                {
                    venuecacheupdatelistener.onVenueCacheUpdate(final_location);
                }
                return;
            }
            mCachedVenues = null;
        }
        final_context = new VenuesLoaderTask(final_location, venuecacheupdatelistener) {

            final GeofenceCacheManagement this$0;
            final Context val$ctx;
            final Location val$locationFix;
            final VenueCacheUpdateListener val$up;

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((List)obj);
            }

            protected void onPostExecute(List list)
            {
                if (list != null)
                {
                    addRequestCacheParams(ctx, locationFix);
                    Log.d("updatevenuecache", (new StringBuilder()).append("updatevenueCache received ").append(list.size()).append(" venues").toString());
                    mCachedVenues = list;
                    persistRetrievedData(getResult());
                }
                if (up != null)
                {
                    up.onVenueCacheUpdate(locationFix);
                }
            }

            
            {
                this$0 = GeofenceCacheManagement.this;
                ctx = context1;
                locationFix = location1;
                up = venuecacheupdatelistener;
                super(final_context, final_location);
            }
        };
        final_location = new String[0];
        if (!(final_context instanceof AsyncTask))
        {
            final_context.execute(final_location);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)final_context, final_location);
            return;
        }
    }



/*
    static List access$002(GeofenceCacheManagement geofencecachemanagement, List list)
    {
        geofencecachemanagement.mCachedVenues = list;
        return list;
    }

*/


}
