// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.abtest.BadgesAbTestHelper;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.adapter.ImagePrefetchAdapterHelper;
import com.groupon.adapter.widget.DealListHeaderAdapter;
import com.groupon.adapter.widget.FeaturedWidgetMergeAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.FeaturedLocationBarClickListener;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Badge;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Finder;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.FeaturedSyncManager;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.InAppMessageService;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.DealUtils;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.view.HasImageView;
import com.groupon.view.InAppToast;
import com.groupon.view.LocationBar;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import com.groupon.view.widgetcards.GtgDefaultJumpOffView;
import commonlib.manager.PaginatedSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseDealsWithOptionalWidgetsListFragment, FeaturedDataTransformer, DealCardEndlessAdapter, DataTransformer, 
//            BaseCardListFragment

public class Featured extends BaseDealsWithOptionalWidgetsListFragment
{

    public static final String NST_CLICK_DIVISION_TYPE = "click_country_selector";
    private BadgesAbTestHelper badgesAbTestHelper;
    private Context context;
    private CurrentDivisionManager currentDivisionManager;
    private DeepLinkUtil deepLinkUtil;
    private GtgAbTestHelper gtgAbTestHelper;
    private AppStartupImageLoadListener imageLoadListener;
    private Lazy inAppMessageService;
    private InAppToast inAppToast;
    private boolean isRedesignInAppMessages1406;
    private boolean isShowBadgeOnGAPIFeaturedTab1509USCA;
    private LocationBar locationBar;
    private ArraySharedPreferences loginPrefs;
    private NotificationManager notificationManager;
    private volatile boolean runningInAppMessageFetch;
    private FeaturedSyncManager syncManager;
    private FeaturedWidgetMergeAdapter widgetMergeAdapter;

    public Featured()
    {
        super(Channel.FEATURED);
        runningInAppMessageFetch = false;
    }

    private void disposeInAppMessage(InAppMessage inappmessage, String s)
    {
        Logger logger = this.logger;
        if (s == null)
        {
            s = "";
        }
        logger.logGeneralEvent("in_app_message_dispose", s, inappmessage.getId(), 0, Logger.NULL_NST_FIELD);
        inappmessage.dispose();
    }

    private View getDealCardView(View view, DealSummary dealsummary)
    {
        if (Strings.equals(dealsummary.remoteId, "gtg_mock_promo_deal_summary_remote_id"))
        {
            return ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f03012c, null);
        }
        if (Strings.equals(dealsummary.remoteId, "gtg_mock_jumpoff_deal_summary_remote_id"))
        {
            view = (GtgDefaultJumpOffView)((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(0x7f03012d, null);
            view.setInfo(new Finder());
            return view;
        }
        if (view != null && (view instanceof DefaultLargeDealCard))
        {
            view = (DefaultLargeDealCard)view;
        } else
        {
            view = new DefaultLargeDealCard(activity);
        }
        imageLoadListener.assignToViews(view);
        dealsummary.putAttr("is_show_badge_ab_test_on", Boolean.valueOf(isShowBadgeOnGAPIFeaturedTab1509USCA));
        view.setInfoWithPlaces(dealsummary, null);
        return view;
    }

    private int getFeaturedEndlessDealsDisplayPositionOffset()
    {
        if (widgetMergeAdapter == null)
        {
            return 0;
        } else
        {
            return widgetMergeAdapter.getFeaturedEndlessDealsDisplayPositionOffset();
        }
    }

    private void refreshInAppMessage()
    {
        if (inAppToast == null || runningInAppMessageFetch || isRedesignInAppMessages1406 || !((InAppMessageService)inAppMessageService.get()).isInAppMessageEnabled())
        {
            return;
        }
        if (inAppToast.isEnabled())
        {
            inAppToast.refresh();
            return;
        } else
        {
            runningInAppMessageFetch = true;
            ((InAppMessageService)inAppMessageService.get()).getOneMessage(new Function1() {

                final Featured this$0;

                public void execute(InAppMessage inappmessage)
                {
                    if (inappmessage == null || !inappmessage.isEnabled())
                    {
                        break MISSING_BLOCK_LABEL_160;
                    }
                    try
                    {
                        if (Strings.isEmpty(inappmessage.getMessage()))
                        {
                            disposeInAppMessage(inappmessage, "message");
                            return;
                        }
                    }
                    catch (Exception exception)
                    {
                        Ln.e(exception);
                        disposeInAppMessage(inappmessage, null);
                        return;
                    }
                    if (!Strings.equalsIgnoreCase(inappmessage.getContext(), Channel.FEATURED))
                    {
                        disposeInAppMessage(inappmessage, "context");
                        return;
                    }
                    DeepLinkData deeplinkdata;
                    deeplinkdata = deepLinkUtil.getDeepLink(deepLinkUtil.normalizeUrl(inappmessage.getTarget(), true));
                    deeplinkdata.setAttributionId(inappmessage.getId());
                    deeplinkdata.setAttributionType("in_app_message");
                    if (!deepLinkManager.isDirectlyFollowable(deeplinkdata))
                    {
                        disposeInAppMessage(inappmessage, "target");
                        return;
                    }
                    inAppToast.setDeepLink(deeplinkdata);
                    inAppToast.updateModel(inappmessage);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((InAppMessage)obj);
                }

            
            {
                this$0 = Featured.this;
                super();
            }
            }, new Function0() {

                final Featured this$0;

                public void execute()
                {
                    runningInAppMessageFetch = false;
                    inAppToast.refresh();
                }

            
            {
                this$0 = Featured.this;
                super();
            }
            });
            return;
        }
    }

    protected void afterOnLoadFinished(List list)
    {
        super.afterOnLoadFinished(list);
        String s = currentDivisionManager.getCurrentDivision().name;
        LocationBar locationbar;
        boolean flag;
        if (list.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        locationbar = locationBar;
        if (Strings.notEmpty(s))
        {
            list = s;
        } else
        if (flag)
        {
            list = ((DealSummary)list.get(0)).divisionName;
        } else
        {
            list = "";
        }
        locationbar.setText(list);
        if (flag)
        {
            loggingUtils.logPageViewed("deal_list");
            return;
        } else
        {
            locationBar = (LocationBar)getListView().getEmptyView().findViewById(0x7f100289);
            initLocationBar(locationBar);
            return;
        }
    }

    protected View createHeaderView()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(context).inflate(0x7f0300df, null);
        locationBar = (LocationBar)linearlayout.findViewById(0x7f100289);
        inAppToast = new InAppToast(activity);
        linearlayout.addView(inAppToast.getView());
        return linearlayout;
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        super.enableSyncProgressIndicator(flag);
        loginPrefs.edit().remove("should_refresh_deals_after_login").apply();
    }

    protected View getCardView(ListAdapter listadapter, int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (DealSummary)listadapter.getItem(i);
        int j = getFeaturedEndlessDealsDisplayPositionOffset();
        tracking(nstChannel, viewgroup, j + i, getDealImpressionExtraInfo(viewgroup));
        view = getDealCardView(view, viewgroup);
        if (view instanceof HasImageView)
        {
            imagePrefetchAdapterHelper.prefetchNextImage(listadapter, i, (HasImageView)view);
            return view;
        } else
        {
            Ln.d("Prefetching doesn't work with views like %s as it does not implement com.groupon.view.HasImageView", new Object[] {
                view
            });
            return view;
        }
    }

    public DataTransformer getDataTransformer()
    {
        return new FeaturedDataTransformer(gtgAbTestHelper);
    }

    protected DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment)
    {
        int i = activity.getResources().getInteger(0x7f0d0001);
        widgetMergeAdapter = null;
        if (i != 1 || !currentCountryManager.getCurrentCountry().isUSACompatible() && !widgetsSupported)
        {
            return super.getDealCardEndlessAdapter(baseadapter, this);
        }
        ArrayList arraylist = new ArrayList();
        if (widgetsSupported)
        {
            basecardlistfragment = ((LocationService)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/service/LocationService)).getLocation();
            String s;
            if (basecardlistfragment != null)
            {
                basecardlistfragment = new GeoPoint((int)(basecardlistfragment.getLatitude() * 1000000D), (int)(basecardlistfragment.getLongitude() * 1000000D));
            } else
            {
                basecardlistfragment = ((CurrentDivisionManager)RoboGuice.getInjector(getActivity()).getInstance(com/groupon/service/countryanddivision/CurrentDivisionManager)).getCurrentDivision().geoPoint;
            }
            s = getClass().getSimpleName();
            widgetListAdapter = new FilterableWidgetListAdapter(getActivity(), this, imageLoadListener, basecardlistfragment, loggingUtils, s, Channel.safeValueOf(nstChannel), new String[] {
                "topSlot"
            });
            arraylist.add(widgetListAdapter);
            basecardlistfragment = currentDivisionManager.getCurrentDivision().name;
            s = getString(0x7f0801b3);
            arraylist.add(new DealListHeaderAdapter(activity, s, basecardlistfragment));
            arraylist.add(baseadapter);
            widgetMergeAdapter = new FeaturedWidgetMergeAdapter(currentCountryManager.getCurrentCountry().isMegamindEnabledCountry(), currentCountryManager.getCurrentCountry().isUSACompatible(), (Adapter[])arraylist.toArray(new Adapter[arraylist.size()]), widgetListAdapter);
            return new DealCardEndlessAdapter(this, this, new DealCardMultiColumnListAdapter(widgetMergeAdapter, getDealListColumns()) {

                final Featured this$0;

                public void onDealCardClicked(int j, View view, DealSummary dealsummary)
                {
                    int k = widgetListAdapter.getCount();
                    Featured.this.onDealCardClicked(j - k - 1, view, dealsummary);
                }

                public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
                {
                    onMemberClick(view, dealsummary);
                }

            
            {
                this$0 = Featured.this;
                super(listadapter, i);
            }
            });
        } else
        {
            arraylist.add(baseadapter);
            return new DealCardEndlessAdapter(this, this, new DealCardMultiColumnListAdapter(baseadapter, getDealListColumns()) {

                final Featured this$0;

                public void onDealCardClicked(int j, View view, DealSummary dealsummary)
                {
                    Featured.this.onDealCardClicked(j, view, dealsummary);
                }

                public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
                {
                    onMemberClick(view, dealsummary);
                }

            
            {
                this$0 = Featured.this;
                super(listadapter, i);
            }
            });
        }
    }

    protected JsonEncodedNSTField getDealImpressionExtraInfo(AbstractDeal abstractdeal)
    {
        Object obj = super.getDealImpressionExtraInfo(abstractdeal);
        if (isShowBadgeOnGAPIFeaturedTab1509USCA && !DealUtils.isSoldOutOrClosed(abstractdeal) && (obj instanceof DealImpressionMetadata))
        {
            obj = (DealImpressionMetadata)obj;
            abstractdeal = abstractdeal.badges.iterator();
            do
            {
                if (!abstractdeal.hasNext())
                {
                    break;
                }
                Badge badge = (Badge)abstractdeal.next();
                if (!DealUtils.isBadgeValid(badge))
                {
                    continue;
                }
                obj.badgeDisplayText = badge.text;
                obj.badgeType = badge.badgeType;
                break;
            } while (true);
            return ((JsonEncodedNSTField) (obj));
        } else
        {
            return ((JsonEncodedNSTField) (obj));
        }
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public FeaturedSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected String getWidgetNstChannelName()
    {
        return "personalized_featured";
    }

    public void initLocationBar(LocationBar locationbar)
    {
        locationbar.setText(currentDivisionManager.getCurrentDivision().name);
        locationbar.setOnClickListener(new FeaturedLocationBarClickListener(getActivity(), locationbar.getText().toString(), channel));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        inAppMessageService = new Lazy(getActivity()) {

            final Featured this$0;

            
            {
                this$0 = Featured.this;
                super(context1);
            }
        };
        initLocationBar(locationBar);
        refreshInAppMessage();
        if (loginPrefs.getBoolean("should_refresh_deals_after_login", false))
        {
            forceReload();
            loginPrefs.edit().remove("should_refresh_deals_after_login").apply();
        }
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            boolean flag1 = false;
            super.onCreate(bundle);
            isRedesignInAppMessages1406 = abTestService.isVariantEnabled("redesignInAppMessages1406", "on");
            boolean flag;
            if (currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnFeatured1410USCA")) && !abTestService.isVariantEnabled("megamindOnFeatured1410USCA", "Original"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            widgetsSupportedUSA = flag;
            if (currentCountryManager.getCurrentCountry().isMegamindEnabledCountry() && !currentCountryManager.getCurrentCountry().isUSACompatible() && Strings.notEmpty(abTestService.getVariant("megamindOnFeatured1503INTL")) && !abTestService.isVariantEnabled("megamindOnFeatured1503INTL", "Original"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            widgetsSupportedINTL = flag;
            if (!widgetsSupportedUSA)
            {
                flag = flag1;
                if (!widgetsSupportedINTL)
                {
                    break label0;
                }
            }
            flag = true;
        }
        widgetsSupported = flag;
        isShowBadgeOnGAPIFeaturedTab1509USCA = badgesAbTestHelper.isShowBadgeOnFeaturedGapi();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300dd, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        com.groupon.Constants.Notification.NotificationType anotificationtype[] = com.groupon.Constants.Notification.NotificationType.values();
        int j = anotificationtype.length;
        for (int i = 0; i < j; i++)
        {
            com.groupon.Constants.Notification.NotificationType notificationtype = anotificationtype[i];
            if (notificationtype != com.groupon.Constants.Notification.NotificationType.NON_DEAL_NOTIFICATION)
            {
                notificationManager.cancel(notificationtype.getId());
            }
        }

    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
            abTestService.isVariantEnabled("AAonFeaturedTab1510", "On");
        }
    }





/*
    static boolean access$302(Featured featured, boolean flag)
    {
        featured.runningInAppMessageFetch = flag;
        return flag;
    }

*/
}
