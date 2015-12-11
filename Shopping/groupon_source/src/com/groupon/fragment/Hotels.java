// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.HotelsCarouselSyncManager;
import com.groupon.mapview.HotelMapView;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GlobalSearchTextHintProvider;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.ScrollToolBarHelper;
import commonlib.manager.PaginatedSyncManager;
import java.util.Calendar;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

public class Hotels extends HotelCardListFragment
    implements GlobalSearchTextHintProvider
{

    private CurrentDivisionManager currentDivisionManager;
    private LocationService locationService;
    private HotelsCarouselSyncManager syncManager;

    public Hotels()
    {
        super(Channel.HOTELS);
    }

    private float getTranslationYToFitMiniMapCenter()
    {
        if (hotelsMapView != null)
        {
            Point point = hotelsMapView.getCurrentLocationOrDivisionScreenPoint();
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
            hotelsMapView.moveCameraFitMapRadius(hotelsMapView.getCurrentLocationOrDivisionLatLng(), false, new com.google.android.gms.maps.GoogleMap.CancelableCallback() {

                final Hotels this$0;

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
                this$0 = Hotels.this;
                super();
            }
            });
            return;
        } else
        {
            hotelsMapView.moveCameraFitMapRadius(hotelsMapView.getCurrentLocationOrDivisionLatLng(), true, null);
            return;
        }
    }

    protected View createListHeaderView()
    {
        return inflater.inflate(0x7f030140, list, false);
    }

    public String getGlobalSearchTextHint()
    {
        if (isHotelsMap1503USCA)
        {
            StringBuilder stringbuilder = new StringBuilder();
            String s;
            if (locationService.isAGpsProviderEnabled())
            {
                s = getString(0x7f080288);
            } else
            {
                s = currentDivisionManager.getCurrentDivision().name;
            }
            return stringbuilder.append(s).append(" \267 ").append(MarketRateUtil.getReservationDatesString(getActivity(), checkInDate, checkOutDate, false)).toString();
        } else
        {
            return getString(0x7f080225);
        }
    }

    protected float getInitialScrollableContentYPosition()
    {
        return scrollToolBarHelper.getToolBarScreenHeight() + scrollToolBarHelper.getTabsBarScreenHeight();
    }

    protected String getOriginatingChannel()
    {
        return "HOTELS";
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public HotelsCarouselSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = Calendar.getInstance();
        bundle.set(11, 0);
        bundle.set(12, 0);
        bundle.set(13, 0);
        bundle.set(14, 0);
        checkInDate = bundle.getTime();
        bundle.add(5, 1);
        checkOutDate = bundle.getTime();
    }

    protected void onDatesSelectorClicked()
    {
        if (isAdded())
        {
            Channel channel;
            if (sourceChannel != null)
            {
                channel = sourceChannel;
            } else
            {
                channel = Channel.HOTELS;
            }
            logger.logClick("", "current_location_hotels_click", "market_rate", channel.toString());
            startActivity(((IntentFactory)intentFactory.get()).newHotelSearchIntent(channel));
        }
    }

    protected void setHotelPagerMode(boolean flag, final boolean animated)
    {
        if (flag)
        {
            scrollToolBarHelper.snapDown(new com.groupon.util.ScrollToolBarHelper.OnToolBarSnapDownListener() {

                final Hotels this$0;
                final boolean val$animated;

                public void onSnapDown()
                {
                    setHotelPagerMode(true, animated);
                }

            
            {
                this$0 = Hotels.this;
                animated = flag;
                super();
            }
            });
            return;
        } else
        {
            super.setHotelPagerMode(false, animated);
            return;
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
        }
    }


}
