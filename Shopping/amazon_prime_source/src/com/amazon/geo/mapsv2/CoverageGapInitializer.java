// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.os.AsyncTask;
import android.util.Log;
import com.amazon.geo.mapsv2.internal.ICoverageGapConfigCallback;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.TileOverlayOptions;
import com.amazon.geo.mapsv2.model.pvt.CoverageGapTileReplacer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.geo.mapsv2:
//            OnMapReadyCallback, MapFragment, MapView, SupportMapFragment, 
//            AmazonMap

final class CoverageGapInitializer
    implements OnMapReadyCallback, ICoverageGapConfigCallback
{
    private class ParseConfigTask extends AsyncTask
    {

        final CoverageGapInitializer this$0;

        public volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        public transient Collection doInBackground(String as[])
        {
            if (as != null && as.length >= 1) goto _L2; else goto _L1
_L1:
            as = null;
_L4:
            return as;
_L2:
            as = as[0];
            ArrayList arraylist;
            JSONArray jsonarray;
            int i;
            try
            {
                jsonarray = (new JSONObject(as)).getJSONArray("replacers");
                arraylist = new ArrayList(jsonarray.length());
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Log.e("Maps-CoverageGapRemoteConfig", "Manifest file has an invalid format", as);
                return null;
            }
            i = 0;
            as = arraylist;
            if (i >= jsonarray.length()) goto _L4; else goto _L3
_L3:
            CoverageGapInitializer.parseReplacer(jsonarray.getJSONObject(i), arraylist);
            i++;
            break MISSING_BLOCK_LABEL_47;
        }

        protected void onCancelled()
        {
            mMap = null;
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Collection)obj);
        }

        public void onPostExecute(Collection collection)
        {
            if (collection != null)
            {
                mTileReplacers = collection;
                tryToAddTileOverlays();
            }
            mParseConfigTask = null;
        }

        private ParseConfigTask()
        {
            this$0 = CoverageGapInitializer.this;
            super();
        }

    }


    private static final String BOUNDS = "bounds";
    private static final String EAST = "east";
    private static final String NORTH = "north";
    private static final String NORTHEAST = "northeast";
    private static final String REPLACER_ARRAY_NAME = "replacers";
    private static final String SOUTH = "south";
    private static final String SOUTHWEST = "southwest";
    private static final String TAG = "Maps-CoverageGapRemoteConfig";
    private static final String TILE_HEIGHT = "tileHeight";
    private static final String TILE_WIDTH = "tileWidth";
    private static final String URL_FORMAT = "urlFormat";
    private static final String VERSION = "version";
    private static final String WEST = "west";
    private static final String ZOOM_CAP = "zoomCap";
    private static final String ZOOM_FLOOR = "zoomFloor";
    private AmazonMap mMap;
    private ParseConfigTask mParseConfigTask;
    private Collection mTileReplacers;

    CoverageGapInitializer(MapFragment mapfragment)
    {
        if (mapfragment.getActivity() != null)
        {
            mapfragment.getMapAsync(this);
            mapfragment.setCoverageGapConfigCallback(this);
        }
    }

    CoverageGapInitializer(MapView mapview)
    {
        if (mapview.getContext() != null)
        {
            mapview.getMapAsync(this);
            mapview.setCoverageGapConfigCallback(this);
        }
    }

    CoverageGapInitializer(SupportMapFragment supportmapfragment)
    {
        if (supportmapfragment.getActivity() != null)
        {
            supportmapfragment.getMapAsync(this);
            supportmapfragment.setCoverageGapConfigCallback(this);
        }
    }

    private static LatLngBounds parseBounds(JSONObject jsonobject)
        throws JSONException
    {
        return new LatLngBounds(new LatLng(jsonobject.getDouble("south"), jsonobject.getDouble("west")), new LatLng(jsonobject.getDouble("north"), jsonobject.getDouble("east")));
    }

    private static void parseReplacer(JSONObject jsonobject, List list)
        throws JSONException
    {
        JSONArray jsonarray = jsonobject.getJSONArray("bounds");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(parseBounds(jsonarray.getJSONObject(i)));
        }

        list.add(new CoverageGapTileReplacer(jsonobject.getString("urlFormat"), jsonobject.getInt("tileWidth"), jsonobject.getInt("tileHeight"), arraylist, jsonobject.getDouble("zoomCap"), jsonobject.getInt("zoomFloor"), jsonobject.getString("version")));
    }

    private void tryToAddTileOverlays()
    {
        if (mMap != null && mTileReplacers != null)
        {
            CoverageGapTileReplacer coveragegaptilereplacer;
            for (Iterator iterator = mTileReplacers.iterator(); iterator.hasNext(); mMap.addTileOverlay((new TileOverlayOptions()).tileProvider(coveragegaptilereplacer)))
            {
                coveragegaptilereplacer = (CoverageGapTileReplacer)iterator.next();
            }

            mMap = null;
        }
    }

    void cancel()
    {
        if (mParseConfigTask != null)
        {
            mParseConfigTask.cancel(true);
            mParseConfigTask = null;
        }
    }

    public void onConfigReady(String s)
    {
        cancel();
        mParseConfigTask = new ParseConfigTask();
        mParseConfigTask.execute(new String[] {
            s
        });
    }

    public void onMapReady(AmazonMap amazonmap)
    {
        mMap = amazonmap;
        tryToAddTileOverlays();
    }



/*
    static Collection access$202(CoverageGapInitializer coveragegapinitializer, Collection collection)
    {
        coveragegapinitializer.mTileReplacers = collection;
        return collection;
    }

*/



/*
    static ParseConfigTask access$402(CoverageGapInitializer coveragegapinitializer, ParseConfigTask parseconfigtask)
    {
        coveragegapinitializer.mParseConfigTask = parseconfigtask;
        return parseconfigtask;
    }

*/


/*
    static AmazonMap access$502(CoverageGapInitializer coveragegapinitializer, AmazonMap amazonmap)
    {
        coveragegapinitializer.mMap = amazonmap;
        return amazonmap;
    }

*/
}
