// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.geo.mapsv2.internal.ICoverageGapConfigCallback;
import com.amazon.geo.mapsv2.internal.IMapDelegate;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;
import com.amazon.geo.mapsv2.internal.IMapOptionsPrimitive;
import com.amazon.geo.mapsv2.internal.IMapViewDelegate;
import com.amazon.geo.mapsv2.internal.IOnMapReadyCallbackPrimitive;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.RemoteContextUtils;
import com.amazon.geo.mapsv2.pvt.Util;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.geo.mapsv2:
//            AmazonMapOptions, OnMapReadyCallback, AmazonMap

public class MapView extends FrameLayout
{
    private static class OnMapReadyCallbackPrimitive extends PrimitiveBase
        implements IOnMapReadyCallbackPrimitive
    {

        private static OnMapReadyCallbackPrimitive wrap(OnMapReadyCallback onmapreadycallback)
        {
            if (onmapreadycallback == null)
            {
                return null;
            } else
            {
                return new OnMapReadyCallbackPrimitive(onmapreadycallback);
            }
        }

        public void onMapReady(IMapDelegate imapdelegate)
        {
            AmazonMap amazonmap = (AmazonMap)imapdelegate.getWrapper();
            if (amazonmap != null)
            {
                ((OnMapReadyCallback)get()).onMapReady(amazonmap);
                return;
            } else
            {
                ((OnMapReadyCallback)get()).onMapReady(new AmazonMap(imapdelegate));
                return;
            }
        }


        private OnMapReadyCallbackPrimitive(OnMapReadyCallback onmapreadycallback)
        {
            super(onmapreadycallback);
        }
    }


    private AmazonMap mMap;
    private IMapViewDelegate mMapView;
    private IMapOptionsPrimitive mOptions;
    private final List mPendingCallbacks;
    private ICoverageGapConfigCallback mPendingCoverageGapCallback;
    private Bundle mServicesUnavailableInstanceState;
    private com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState mServicesUnavailableLifecycleState;
    private View mServicesUnavailableView;

    public MapView(Context context)
    {
        this(context, (AmazonMapOptions)null);
    }

    public MapView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MapView(Context context, AttributeSet attributeset, int i)
    {
        this(context, AmazonMapOptions.createFromAttributes(context, attributeset), attributeset, i);
    }

    public MapView(Context context, AmazonMapOptions amazonmapoptions)
    {
        this(context, amazonmapoptions, null, 0);
    }

    MapView(Context context, AmazonMapOptions amazonmapoptions, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mPendingCallbacks = new ArrayList();
        mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.UNINITIALIZED;
        if (amazonmapoptions == null)
        {
            context = null;
        } else
        {
            context = amazonmapoptions.createMapOptionsPrimitive();
        }
        mOptions = context;
    }

    MapView(Context context, IMapViewDelegate imapviewdelegate)
    {
        super(context);
        mPendingCallbacks = new ArrayList();
        mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.UNINITIALIZED;
        mMapView = imapviewdelegate;
        mMapView.setWrapper(this);
    }

    private int getErrorMessage(int i, PendingIntent pendingintent)
    {
        switch (i)
        {
        default:
            return com.amazon.geo.mapsv2.support.R.string.amazon_maps_unhandled_title;

        case 2: // '\002'
            if (pendingintent != null)
            {
                return com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_update_message;
            } else
            {
                return com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_update_manual_message;
            }

        case 1: // '\001'
            break;
        }
        if (pendingintent != null)
        {
            return com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_missing_message;
        } else
        {
            return com.amazon.geo.mapsv2.support.R.string.amazon_maps_service_missing_manual_message;
        }
    }

    private boolean initMapView()
    {
        if (mMapView == null)
        {
            Object obj = AmazonMapsRuntimeUtil.getRemoteContext(getContext());
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = RemoteContextUtils.getMapEngine(((Context) (obj)));
            }
            if (obj == null)
            {
                showServicesUnavailableView();
                return false;
            }
            mMapView = ((IMapEngineDelegate) (obj)).createMapControlView(getContext(), mOptions);
            mMapView.setWrapper(this);
            mOptions = null;
            if (mServicesUnavailableView != null)
            {
                removeView(mServicesUnavailableView);
                mServicesUnavailableView = null;
            }
            addView(mMapView.getView());
            if (mServicesUnavailableLifecycleState != com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.UNINITIALIZED)
            {
                onCreate(mServicesUnavailableInstanceState);
                mServicesUnavailableInstanceState = null;
            }
            if (mServicesUnavailableLifecycleState == com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.RESUMED)
            {
                onResume();
            }
            OnMapReadyCallback onmapreadycallback;
            for (Iterator iterator = mPendingCallbacks.iterator(); iterator.hasNext(); mMapView.getMapAsync(OnMapReadyCallbackPrimitive.wrap(onmapreadycallback)))
            {
                onmapreadycallback = (OnMapReadyCallback)iterator.next();
            }

            mPendingCallbacks.clear();
            if (mPendingCoverageGapCallback != null)
            {
                mMapView.setCoverageGapConfigCallback(mPendingCoverageGapCallback);
                mPendingCoverageGapCallback = null;
                return true;
            }
        }
        return true;
    }

    private void showServicesUnavailableView()
    {
        if (mServicesUnavailableView != null)
        {
            return;
        }
        int i = AmazonMapsRuntimeUtil.isAmazonMapsRuntimeAvailable(getContext());
        final PendingIntent pendingIntent = AmazonMapsRuntimeUtil.getErrorPendingIntent(i, getContext(), 0);
        LinearLayout linearlayout = new LinearLayout(getContext());
        linearlayout.setOrientation(1);
        TextView textview = new TextView(getContext());
        textview.setText(getErrorMessage(i, pendingIntent));
        linearlayout.addView(textview, -1, -2);
        if (pendingIntent != null)
        {
            Button button = new Button(getContext());
            button.setText(com.amazon.geo.mapsv2.support.R.string.amazon_maps_update);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final MapView this$0;
                final PendingIntent val$pendingIntent;

                public void onClick(View view)
                {
                    try
                    {
                        pendingIntent.send();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                }

            
            {
                this$0 = MapView.this;
                pendingIntent = pendingintent;
                super();
            }
            });
            linearlayout.addView(button, -2, -2);
        }
        addView(linearlayout, -1, -2);
        mServicesUnavailableView = linearlayout;
    }

    IMapViewDelegate getDelegate()
    {
        return mMapView;
    }

    public final AmazonMap getMap()
    {
        if (mMapView == null)
        {
            return null;
        }
        IMapDelegate imapdelegate = mMapView.getMap();
        if (mMap == null)
        {
            mMap = new AmazonMap(imapdelegate);
        }
        return mMap;
    }

    public final void getMapAsync(OnMapReadyCallback onmapreadycallback)
    {
        Util.ensureMainThread();
        if (mMapView != null)
        {
            mMapView.getMapAsync(OnMapReadyCallbackPrimitive.wrap(onmapreadycallback));
            return;
        } else
        {
            mPendingCallbacks.add(onmapreadycallback);
            return;
        }
    }

    Object iv()
    {
        return mMapView;
    }

    public final void onCreate(Bundle bundle)
    {
        if (initMapView())
        {
            mMapView.onCreate(bundle);
            return;
        } else
        {
            mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.CREATED;
            mServicesUnavailableInstanceState = bundle;
            return;
        }
    }

    public final void onDestroy()
    {
        if (mMapView != null)
        {
            mMapView.onDestroy();
        } else
        {
            mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.UNINITIALIZED;
            mServicesUnavailableInstanceState = null;
        }
        onDestroyInternal();
    }

    void onDestroyInternal()
    {
    }

    public final void onLowMemory()
    {
        if (mMapView != null)
        {
            mMapView.onLowMemory();
        }
    }

    public final void onPause()
    {
        if (mMapView != null)
        {
            mMapView.onPause();
            return;
        } else
        {
            mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.CREATED;
            return;
        }
    }

    public final void onResume()
    {
        if (initMapView())
        {
            mMapView.onResume();
            return;
        } else
        {
            mServicesUnavailableLifecycleState = com.amazon.geo.mapsv2.internal.IMapViewDelegate.LifecycleState.RESUMED;
            return;
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        if (mMapView != null)
        {
            mMapView.onSaveInstanceState(bundle);
        }
    }

    final void recreateView()
    {
        if (mMapView != null)
        {
            addView(mMapView.recreateView(getContext()));
            mMapView.onViewRecreated();
        }
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
