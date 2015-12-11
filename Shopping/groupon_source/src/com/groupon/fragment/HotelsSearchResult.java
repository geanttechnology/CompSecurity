// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.groupon.Channel;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.MarketRateSyncManager;
import com.groupon.mapview.HotelMapView;
import commonlib.manager.PaginatedSyncManager;
import java.util.Date;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

public class HotelsSearchResult extends HotelCardListFragment
{
    public static interface Callback
    {

        public abstract void onDatesSelectorClicked();
    }


    private Callback callback;
    private String destinationId;
    ListView list;
    private MarketRateSyncManager syncManager;

    public HotelsSearchResult()
    {
        super(Channel.MARKET_RATE);
    }

    private float getTranslationYToFitMiniMapCenter()
    {
        if (hotelsMapView != null)
        {
            Point point = hotelsMapView.getMapCenterScreenPoint();
            if (point != null)
            {
                int ai[] = new int[2];
                list.getLocationOnScreen(ai);
                float f = headerView.getHeight();
                return (float)point.y - ((float)ai[1] + f / 2.0F);
            }
        }
        return 0.0F;
    }

    protected void adjustCameraToFitMap()
    {
        if (!isMapAvailable())
        {
            return;
        }
        if (!isLandscape && !isHotelPagerModeActivated)
        {
            hotelsMapView.moveCameraToFitMarkersCenter(false, new com.google.android.gms.maps.GoogleMap.CancelableCallback() {

                final HotelsSearchResult this$0;

                public void onCancel()
                {
                }

                public void onFinish()
                {
                    if (hotelsMapView != null)
                    {
                        hotelsMapView.scrollCamera(0.0F, getTranslationYToFitMiniMapCenter(), true, null);
                    }
                }

            
            {
                this$0 = HotelsSearchResult.this;
                super();
            }
            });
            return;
        } else
        {
            hotelsMapView.moveCameraToFitMarkersCenter(true, null);
            return;
        }
    }

    public void configureSyncManager()
    {
        super.configureSyncManager();
        syncManager.setDestinationId(destinationId);
        syncManager.setPagerChannelAndSubchannel(pagerChannelAndSubchannel);
    }

    protected View createListHeaderView()
    {
        return inflater.inflate(0x7f03013f, list, false);
    }

    protected String getOriginatingChannel()
    {
        return pagerChannelAndSubchannel;
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public MarketRateSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void onActivityCreated(Bundle bundle)
    {
        String s;
        String s1;
        if (checkInDate != null)
        {
            s = checkInDate.toString();
        } else
        {
            s = "";
        }
        if (checkOutDate != null)
        {
            s1 = checkOutDate.toString();
        } else
        {
            s1 = "";
        }
        pagerChannelAndSubchannel = Channel.encodePath(new String[] {
            "MARKET_RATE", s, s1, destinationId
        });
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        callback = (Callback)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        destinationId = getArguments().getString("destination_id");
        disableScrollHelper = true;
    }

    protected void onDatesSelectorClicked()
    {
        callback.onDatesSelectorClicked();
    }

    public void onDetach()
    {
        callback = null;
        super.onDetach();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setUpHotelMap();
    }

}
