// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.location.Location;
import android.view.View;
import com.groupon.Channel;
import com.groupon.abtest.CabCavOnDealDetailsAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.DefaultOnDealDetailsWidgetsEventListener;
import com.groupon.callbacks.OnDealDetailsWidgetsEventListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.models.division.Division;
import com.groupon.mvc.model.CabCavWidget;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class CavWidgetsController extends RecyclerItemViewController
{
    private class OnWidgetsEventListener extends DefaultOnDealDetailsWidgetsEventListener
    {

        final CavWidgetsController this$0;

        public void onCavWidgetClick(View view, DealSummary dealsummary)
        {
            loggingUtils.logWidgetDealClick(dealsummary, "mm_deal_details", deal.uuid, numDealActivitiesOnStack);
            context.startActivity(intentFactory.nextActivityFromWidgetDealClick(dealsummary, channel, numDealActivitiesOnStack));
        }

        public void onCavWidgetPageSelected(DealSummary dealsummary, int i)
        {
            loggingUtils.logWidgetDealImpression(channel.toString(), dealsummary, "INVALID_KEYSTRING", numDealActivitiesOnStack, i);
        }

        public void onCavWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
        {
            loggingUtils.setOriginatingNstChannel(channel);
            loggingUtils.setRequiresRedirectLogging(false);
            activityWidgetsCallback.onCavWidgetsInitialized(filterablewidgetlistadapter);
        }

        private OnWidgetsEventListener()
        {
            this$0 = CavWidgetsController.this;
            super();
        }

    }


    private OnDealDetailsWidgetsEventListener activityWidgetsCallback;
    private CabCavOnDealDetailsAbTestHelper cabCavOnDealDetailsAbTestHelper;
    private Channel channel;
    private CurrentDivisionManager currentDivisionManager;
    private Deal deal;
    private boolean fromMyGrouponsOrShoppingCart;
    private IntentFactory intentFactory;
    private LocationService locationService;
    private LoggingUtils loggingUtils;
    private int numDealActivitiesOnStack;

    public CavWidgetsController(Context context)
    {
        super(context);
    }

    public OnDealDetailsWidgetsEventListener getCallback()
    {
        return new OnWidgetsEventListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        if (!cabCavOnDealDetailsAbTestHelper.shouldDisplayWidgets(deal, fromMyGrouponsOrShoppingCart, numDealActivitiesOnStack))
        {
            setState(0);
            return;
        }
        Object obj = null;
        if (locationService.isAGpsProviderEnabled())
        {
            obj = locationService.getLocation();
            if (obj != null)
            {
                obj = new GeoPoint((int)(((Location) (obj)).getLatitude() * 1000000D), (int)(((Location) (obj)).getLongitude() * 1000000D));
            } else
            {
                obj = currentDivisionManager.getCurrentDivision().geoPoint;
            }
        }
        model = new CabCavWidget();
        ((CabCavWidget)model).displayWidget = cabCavOnDealDetailsAbTestHelper.shouldDisplayCAVWidget();
        ((CabCavWidget)model).channel = channel;
        ((CabCavWidget)model).currentLocation = ((GeoPoint) (obj));
        setState(2);
    }

    public void setActivityWidgetsCallback(OnDealDetailsWidgetsEventListener ondealdetailswidgetseventlistener)
    {
        setState(1);
        activityWidgetsCallback = ondealdetailswidgetseventlistener;
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setFromMyGrouponsOrShoppingCart(boolean flag)
    {
        setState(1);
        fromMyGrouponsOrShoppingCart = flag;
    }

    public void setNumDealActivitiesOnStack(int i)
    {
        setState(1);
        numDealActivitiesOnStack = i;
    }






}
