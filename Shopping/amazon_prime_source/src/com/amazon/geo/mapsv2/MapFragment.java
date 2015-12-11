// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.geo.mapsv2.internal.ICoverageGapConfigCallback;
import com.amazon.geo.mapsv2.internal.IMapViewDelegate;
import com.amazon.geo.mapsv2.pvt.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2:
//            MapView, AmazonMapOptions, OnMapReadyCallback, MapsInitializer, 
//            AmazonMap

public class MapFragment extends Fragment
{

    static final String MAPFRAGMENT_OPTIONS_KEY = "MapOptions";
    private AmazonMap mMap;
    private IMapViewDelegate mMapContextDelegate;
    private MapView mMapView;
    private final List mPendingCallbacks = new ArrayList();
    private ICoverageGapConfigCallback mPendingCoverageGapCallback;
    private boolean mUseViewLifecycle;

    public MapFragment()
    {
    }

    public static MapFragment newInstance()
    {
        return new MapFragment();
    }

    public static MapFragment newInstance(AmazonMapOptions amazonmapoptions)
    {
        MapFragment mapfragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", amazonmapoptions);
        mapfragment.setArguments(bundle);
        return mapfragment;
    }

    public final AmazonMap getMap()
    {
        if (mMap == null && mMapView != null)
        {
            mMap = mMapView.getMap();
        }
        return mMap;
    }

    public final void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        Util.ensureMainThread();
        if (mMapView != null)
        {
            mMapView.getMapAsync(onmapreadycallback);
            return;
        } else
        {
            mPendingCallbacks.add(onmapreadycallback);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (mMapContextDelegate != null)
        {
            mMapContextDelegate.resetActivity(activity);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = getActivity();
        if (mMapContextDelegate == null || mUseViewLifecycle)
        {
            layoutinflater = getArguments();
            if (layoutinflater == null)
            {
                layoutinflater = null;
            } else
            {
                layoutinflater = (AmazonMapOptions)layoutinflater.getParcelable("MapOptions");
            }
            if (layoutinflater != null)
            {
                mMapView = new MapView(viewgroup, layoutinflater);
                layoutinflater = layoutinflater.getUseViewLifecycleInFragment();
                boolean flag;
                if (layoutinflater != null && layoutinflater.booleanValue())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                mUseViewLifecycle = flag;
            } else
            {
                mMapView = new MapView(viewgroup);
                mUseViewLifecycle = false;
            }
            mMapView.onCreate(bundle);
        } else
        {
            mMapView = new MapView(viewgroup, mMapContextDelegate);
            mMapView.recreateView();
        }
        for (layoutinflater = mPendingCallbacks.iterator(); layoutinflater.hasNext(); mMapView.getMapAsync(viewgroup))
        {
            viewgroup = (OnMapReadyCallback)layoutinflater.next();
        }

        mPendingCallbacks.clear();
        if (mPendingCoverageGapCallback != null)
        {
            mMapView.setCoverageGapConfigCallback(mPendingCoverageGapCallback);
            mPendingCoverageGapCallback = null;
        }
        return mMapView;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mMapView == null) goto _L2; else goto _L1
_L1:
        mMapView.onDestroy();
_L4:
        mMapContextDelegate = null;
        mMap = null;
        return;
_L2:
        if (mMapContextDelegate != null)
        {
            mMapContextDelegate.onDestroy();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (mMapView == null) goto _L2; else goto _L1
_L1:
        if (!mUseViewLifecycle) goto _L4; else goto _L3
_L3:
        mMapView.onDestroy();
        mMapContextDelegate = null;
        mMap = null;
_L6:
        mMapView = null;
_L2:
        return;
_L4:
        mMapContextDelegate = mMapView.getDelegate();
        if (mMapContextDelegate != null)
        {
            mMapContextDelegate.onDestroyView();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onInflate(Activity activity, AttributeSet attributeset, Bundle bundle)
    {
        super.onInflate(activity, attributeset, bundle);
        Bundle bundle1 = getArguments();
        bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
            setArguments(bundle);
        }
        bundle.putParcelable("MapOptions", AmazonMapOptions.createFromAttributes(activity, attributeset));
        MapsInitializer.initialize(activity);
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (mMapView != null)
        {
            mMapView.onLowMemory();
        }
    }

    public void onPause()
    {
        super.onPause();
        if (mMapView != null)
        {
            mMapView.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mMapView != null)
        {
            mMapView.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mMapView != null)
        {
            mMapView.onSaveInstanceState(bundle);
        }
    }

    public void setArguments(Bundle bundle)
    {
        super.setArguments(bundle);
    }

    void setCoverageGapConfigCallback(ICoverageGapConfigCallback icoveragegapconfigcallback)
    {
        if (mMapView != null)
        {
            mMapView.setCoverageGapConfigCallback(icoveragegapconfigcallback);
            return;
        } else
        {
            mPendingCoverageGapCallback = icoveragegapconfigcallback;
            return;
        }
    }
}
