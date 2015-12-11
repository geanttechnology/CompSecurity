// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.Channel;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.service.core.AbTestService;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import com.groupon.view.widgetcards.DealDetailsWidgetHeaderCard;
import com.groupon.view.widgetcards.LimitedListWidgetHeaderCard;
import com.groupon.view.widgetcards.RotatingImageWidgetCard;
import com.groupon.view.widgetcards.SmallDealListCard;
import com.groupon.view.widgetcards.TrackingWidgetHeaderCard;
import commonlib.adapter.JavaListAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.adapter.widget:
//            WidgetPart

public class WidgetListAdapter extends JavaListAdapter
{

    protected static final Class widgetCardTypeClasses[] = {
        com/groupon/view/widgetcards/LimitedListWidgetHeaderCard, com/groupon/view/dealcards/DefaultLargeDealCard, com/groupon/view/widgetcards/RotatingImageWidgetCard, com/groupon/view/widgetcards/SmallDealListCard, com/groupon/view/widgetcards/DealDetailsWidgetHeaderCard, com/groupon/view/widgetcards/TrackingWidgetHeaderCard, com/groupon/view/dealcards/DefaultLargeDealCard
    };
    private AbTestService abTestService;
    private Context context;
    private GeoPoint currentLocation;
    private DealSetCallbacks dealSetCallbacks;
    private boolean hideHeaderSeeAllButtons;
    private AppStartupImageLoadListener imageLoadingCallbacks;
    private String keyString;
    private LoggingUtils loggingUtils;
    private String nstChannel;
    private int numDealSummariesDisplayed;
    private final int padding;
    private final int paddingEdge;
    private String pageId;
    private SharedPreferences prefs;
    private List rotatingImageWidgetCards;
    private List smuggledDeals;
    private List transformedList;
    private boolean widgetsAdapterOnThankYouScreen;

    public WidgetListAdapter(Context context1, DealSetCallbacks dealsetcallbacks, AppStartupImageLoadListener appstartupimageloadlistener, GeoPoint geopoint, LoggingUtils loggingutils, String s, Channel channel)
    {
        this(context1, dealsetcallbacks, appstartupimageloadlistener, geopoint, loggingutils, s, false, channel);
    }

    public WidgetListAdapter(Context context1, DealSetCallbacks dealsetcallbacks, AppStartupImageLoadListener appstartupimageloadlistener, GeoPoint geopoint, LoggingUtils loggingutils, String s, boolean flag, 
            Channel channel)
    {
        smuggledDeals = Collections.EMPTY_LIST;
        widgetsAdapterOnThankYouScreen = false;
        context = context1;
        dealSetCallbacks = dealsetcallbacks;
        imageLoadingCallbacks = appstartupimageloadlistener;
        currentLocation = geopoint;
        loggingUtils = loggingutils;
        keyString = s;
        nstChannel = channel.toString();
        transformedList = new ArrayList();
        hideHeaderSeeAllButtons = flag;
        paddingEdge = context1.getResources().getDimensionPixelSize(0x7f0b0226);
        padding = context1.getResources().getDimensionPixelSize(0x7f0b0225);
        if (loggingutils != null)
        {
            loggingUtils.setRequiresRedirectLogging(true);
        }
        RoboGuice.getInjector(context1).injectMembers(this);
        rotatingImageWidgetCards = new ArrayList();
    }

    public int getCount()
    {
        return transformedList.size();
    }

    public Object getItem(int i)
    {
        return transformedList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)getItem(i).hashCode();
    }

    public int getItemViewType(int i)
    {
        return ((WidgetPart)getItem(i)).getType();
    }

    public int getNumDealSummariesDisplayed()
    {
        return numDealSummariesDisplayed;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        WidgetPart widgetpart;
        int j;
        boolean flag;
        widgetpart = (WidgetPart)getItem(i);
        j = widgetpart.getType();
        flag = reuseView(view, j);
        j;
        JVM INSTR tableswitch 0 6: default 72
    //                   0 76
    //                   1 304
    //                   2 420
    //                   3 497
    //                   4 72
    //                   5 654
    //                   6 186;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        view = null;
_L9:
        return view;
_L2:
        if (!flag)
        {
            view = new LimitedListWidgetHeaderCard(context);
        }
        viewgroup = (LimitedListWidgetHeaderCard)(LimitedListWidgetHeaderCard)view;
        viewgroup.setInfo(widgetpart.getWidgetSummary(), dealSetCallbacks, hideHeaderSeeAllButtons);
        view = viewgroup;
        if (loggingUtils != null)
        {
            loggingUtils.logWidgetImpression(widgetpart.getWidgetSummary(), keyString);
            view = viewgroup;
            if (widgetsAdapterOnThankYouScreen)
            {
                view = viewgroup;
                if (!hideHeaderSeeAllButtons)
                {
                    loggingUtils.logThankYouWidgetSeeAllButton(widgetpart.getWidgetSummary(), nstChannel, pageId);
                    return viewgroup;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (!flag)
        {
            view = new DefaultLargeDealCard(context);
        }
        view = (DefaultLargeDealCard)(DefaultLargeDealCard)view;
        if (imageLoadingCallbacks != null)
        {
            imageLoadingCallbacks.assignToViews(view);
        }
        view.setInfoWithPlace(widgetpart.getDealSummary(), currentLocation);
        if (loggingUtils != null)
        {
            viewgroup = new DealImpressionMetadata(widgetpart.getDealSummary().getDealStatus());
            loggingUtils.logDealImpressionV1(nstChannel, "", widgetpart.getDealSummary(), i, viewgroup, keyString, abTestService, true, loggingUtils.isRequiresRedirectLogging(), false);
        }
        return view;
_L3:
        if (!flag)
        {
            view = new DefaultLargeDealCard(context);
        }
        viewgroup = (DefaultLargeDealCard)(DefaultLargeDealCard)view;
        if (imageLoadingCallbacks != null)
        {
            imageLoadingCallbacks.assignToViews(viewgroup);
        }
        viewgroup.setInfoWithPlace(widgetpart.getDealSummary(), currentLocation);
        view = viewgroup;
        if (loggingUtils != null)
        {
            if (widgetsAdapterOnThankYouScreen)
            {
                loggingUtils.logThankYouWidgetImpression(nstChannel, widgetpart.getDealSummary(), keyString);
                return viewgroup;
            } else
            {
                loggingUtils.logWidgetDealImpression(nstChannel, widgetpart.getDealSummary(), keyString);
                return viewgroup;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!flag)
        {
            view = new RotatingImageWidgetCard(context);
        }
        view = (RotatingImageWidgetCard)(RotatingImageWidgetCard)view;
        view.setInfo(widgetpart.getWidgetSummary(), dealSetCallbacks);
        if (loggingUtils != null)
        {
            loggingUtils.logWidgetImpression(widgetpart.getWidgetSummary(), keyString);
        }
        rotatingImageWidgetCards.add(view);
        return view;
_L5:
        int k;
        int l;
        if (!flag)
        {
            view = new SmallDealListCard(context);
        }
        view = (SmallDealListCard)(SmallDealListCard)view;
        if (imageLoadingCallbacks != null)
        {
            imageLoadingCallbacks.assignToViews(view);
        }
        view.setInfo(widgetpart.getDealSummary(), widgetpart.isLastPosition(), widgetpart.isFirstPosition(), dealSetCallbacks, currentLocation);
        if (loggingUtils != null)
        {
            loggingUtils.logWidgetDealImpression(nstChannel, widgetpart.getDealSummary(), keyString);
        }
        if (i == 0)
        {
            k = padding;
        } else
        {
            k = padding;
        }
        l = padding;
        if (i == getCount() - 1)
        {
            i = paddingEdge;
        } else
        {
            i = padding;
        }
        view.setPadding(k, l, i, 0);
        return view;
_L6:
        if (!flag)
        {
            view = new TrackingWidgetHeaderCard(context);
        }
        viewgroup = (TrackingWidgetHeaderCard)(TrackingWidgetHeaderCard)view;
        view = viewgroup;
        if (loggingUtils != null)
        {
            loggingUtils.logWidgetImpression(widgetpart.getWidgetSummary(), keyString);
            return viewgroup;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public int getViewTypeCount()
    {
        return widgetCardTypeClasses.length;
    }

    public void resetAnimation()
    {
        if (rotatingImageWidgetCards != null)
        {
            for (Iterator iterator = rotatingImageWidgetCards.iterator(); iterator.hasNext(); ((RotatingImageWidgetCard)iterator.next()).resetAnimation()) { }
        }
    }

    public boolean reuseView(View view, int i)
    {
        return view != null && i != 2 && widgetCardTypeClasses[i].isAssignableFrom(view.getClass());
    }

    public void setList(List list, boolean flag)
    {
        transform(list);
        if (flag)
        {
            notifyDataSetChanged();
        }
    }

    public void setPageId(String s)
    {
        pageId = s;
    }

    public void setRequiresRedirectLogging(boolean flag)
    {
        if (loggingUtils != null)
        {
            loggingUtils.setRequiresRedirectLogging(flag);
        }
    }

    public void setSmuggledDeals(List list)
    {
        smuggledDeals = list;
    }

    public void setWidgetsAdapterOnThankYouScreen(boolean flag)
    {
        widgetsAdapterOnThankYouScreen = flag;
    }

    public void transform(List list)
    {
        transformedList.clear();
        numDealSummariesDisplayed = 0;
        String s2 = prefs.getString("widgetType", "none");
        int i;
        int j;
        boolean flag;
        if (!Strings.equals(s2, "none"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = 0;
        j = 0;
        for (Iterator iterator = smuggledDeals.iterator(); iterator.hasNext();)
        {
            DealSummary dealsummary = (DealSummary)iterator.next();
            dealsummary.putAttr("ns:DealOffset", Integer.valueOf(j));
            transformedList.add(new WidgetPart(dealsummary, 6, false));
            j++;
        }

        Iterator iterator1 = list.iterator();
        do
        {
            if (iterator1.hasNext())
            {
                WidgetSummary widgetsummary = (WidgetSummary)iterator1.next();
                if (widgetsummary.dealSummaries.size() == 0)
                {
                    continue;
                }
                String s1 = widgetsummary.viewLayout;
                String s = null;
                Object obj = s1;
                if (Strings.equals(s1, "deal_cards_layout_no_header"))
                {
                    obj = "deal_cards_layout";
                    s = "no_header";
                }
                if (!flag && Strings.equals(obj, "rotating_image_layout") || Strings.equals(s2, "goods"))
                {
                    if (!Strings.isEmpty(widgetsummary.moreAssetsDealsUrl))
                    {
                        widgetsummary.putAttr("ns:widgetOffset", Integer.valueOf(i));
                        transformedList.add(new WidgetPart(widgetsummary, 2));
                        i++;
                    }
                    continue;
                }
                if (!flag && Strings.equals(obj, "deal_cards_layout") || Strings.equals(s2, "default"))
                {
                    widgetsummary.putAttr("ns:widgetOffset", Integer.valueOf(i));
                    if (!Strings.equals(s, "no_header"))
                    {
                        transformedList.add(new WidgetPart(widgetsummary));
                    } else
                    {
                        transformedList.add(new WidgetPart(widgetsummary, 5));
                    }
                    for (obj = widgetsummary.dealSummaries.iterator(); ((Iterator) (obj)).hasNext();)
                    {
                        DealSummary dealsummary1 = (DealSummary)((Iterator) (obj)).next();
                        dealsummary1.putAttr("ns:DealOffset", Integer.valueOf(j));
                        transformedList.add(new WidgetPart(dealsummary1));
                        j++;
                    }

                    i++;
                    continue;
                }
                if ((flag || !Strings.equals(obj, "small_deal_list_cards_layout")) && !Strings.equals(s2, "smallDealCardList"))
                {
                    continue;
                }
                widgetsummary.putAttr("ns:widgetOffset", Integer.valueOf(i));
                int k = 0;
                int l = widgetsummary.dealSummaries.size();
                obj = widgetsummary.dealSummaries.iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    DealSummary dealsummary2 = (DealSummary)((Iterator) (obj)).next();
                    dealsummary2.putAttr("ns:DealOffset", Integer.valueOf(j));
                    List list1 = transformedList;
                    boolean flag1;
                    boolean flag2;
                    if (k == l - 1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (k == 0)
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    list1.add(new WidgetPart(dealsummary2, 3, flag1, flag2));
                    k++;
                    j++;
                }
            } else
            {
                numDealSummariesDisplayed = j;
                this.list = list;
                return;
            }
            i++;
        } while (true);
    }

}
