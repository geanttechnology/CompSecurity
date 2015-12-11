// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.content.Context;
import android.os.AsyncTask;
import com.amazon.geo.mapsv2.AmazonMapOptionsInternal;
import com.amazon.geo.mapsv2.MapFragment;
import com.amazon.geo.mapsv2.MapFragmentInternal;
import com.amazon.geo.mapsv2.MapsInitializer;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtilInternal;
import com.amazon.geo.mapsv2.util.MapsInitializationOptions;
import com.amazon.geo.mapsv2.util.MapsPreloader;
import com.amazon.now.account.User;
import com.amazon.now.account.UserListener;
import com.amazon.now.platform.AndroidPlatform;

public class MapController
{
    private class NowMapsPreloader
        implements com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver
    {

        final MapController this$0;

        public void onPreloadEnd(com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult preloadresult)
        {
            (new AsyncTask() {

                final NowMapsPreloader this$1;

                protected transient MapFragment doInBackground(Void avoid[])
                {
                    return createMapFragment();
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected void onPostExecute(MapFragment mapfragment)
                {
                    mMapFragment = mapfragment;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((MapFragment)obj);
                }

            
            {
                this$1 = NowMapsPreloader.this;
                super();
            }
            }).execute(new Void[0]);
        }

        public void onPreloadProgress(com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadController preloadcontroller, int i, int j)
        {
        }

        public void onPreloadStart(com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadController preloadcontroller)
        {
        }

        private NowMapsPreloader()
        {
            this$0 = MapController.this;
            super();
        }

    }


    private static MapController sInstance;
    private final Context mContext = AndroidPlatform.getInstance().getApplicationContext();
    private MapFragment mMapFragment;

    private MapController()
    {
        mMapFragment = null;
    }

    private MapFragment createMapFragment()
    {
        if (User.isSignedIn())
        {
            setMapCorAndPfm();
        } else
        {
            User.addUserListener(new UserListener() {

                final MapController this$0;

                public void userSignedIn()
                {
                    setMapCorAndPfm();
                }

                public void userSignedOut()
                {
                }

            
            {
                this$0 = MapController.this;
                super();
            }
            });
        }
        return MapFragmentInternal.newInstance(getMapOptions());
    }

    public static MapController getInstance()
    {
        com/amazon/now/map/MapController;
        JVM INSTR monitorenter ;
        MapController mapcontroller;
        if (sInstance == null)
        {
            sInstance = new MapController();
        }
        mapcontroller = sInstance;
        com/amazon/now/map/MapController;
        JVM INSTR monitorexit ;
        return mapcontroller;
        Exception exception;
        exception;
        throw exception;
    }

    private AmazonMapOptionsInternal getMapOptions()
    {
        AmazonMapOptionsInternal amazonmapoptionsinternal = new AmazonMapOptionsInternal();
        amazonmapoptionsinternal.tiltGesturesEnabled(false);
        amazonmapoptionsinternal.zoomControlsEnabled(false);
        amazonmapoptionsinternal.compassEnabled(false);
        amazonmapoptionsinternal.rotateGesturesEnabled(true);
        amazonmapoptionsinternal.tileReplacer(Boolean.valueOf(true));
        return amazonmapoptionsinternal;
    }

    private void setMapCorAndPfm()
    {
        AndroidPlatform.getInstance().runOnUiThread(new Runnable() {

            final MapController this$0;

            public void run()
            {
                MapsInitializer.initialize(mContext);
                AmazonMapsRuntimeUtilInternal.setAccountInfo(User.getUserCor(), User.getUserPfm());
            }

            
            {
                this$0 = MapController.this;
                super();
            }
        });
    }

    public static void trimMemory()
    {
        if (sInstance != null)
        {
            sInstance.mMapFragment = null;
            sInstance = null;
        }
    }

    public MapFragment getMapFragment()
    {
        if (mMapFragment == null)
        {
            mMapFragment = createMapFragment();
        }
        return mMapFragment;
    }

    public void preload()
    {
        MapsPreloader mapspreloader = new MapsPreloader();
        MapsInitializationOptions mapsinitializationoptions = new MapsInitializationOptions();
        mapsinitializationoptions.appProvidesAccount = Boolean.valueOf(true);
        mapsinitializationoptions.forceNoAccount = Boolean.valueOf(true);
        mapspreloader.setInitializationParams(mapsinitializationoptions);
        mapspreloader.preload(mContext, new NowMapsPreloader());
    }



/*
    static MapFragment access$102(MapController mapcontroller, MapFragment mapfragment)
    {
        mapcontroller.mMapFragment = mapfragment;
        return mapfragment;
    }

*/


}
