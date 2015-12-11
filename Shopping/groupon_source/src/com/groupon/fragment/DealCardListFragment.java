// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.ImagePrefetchAdapterHelper;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.models.Badge;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.models.country.Country;
import com.groupon.models.nst.FinderCard;
import com.groupon.models.nst.FinderCardExtraInfo;
import com.groupon.models.nst.GtgMockDealExtraInfo;
import com.groupon.models.nst.ImpressionClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.DealUtils;
import com.groupon.util.LoggingUtils;
import com.groupon.view.DealSetCallbacks;
import com.groupon.view.HasImageView;
import com.groupon.view.dealcards.DealCardBase;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.PendingAdapterInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseCardListFragment, DealCardEndlessAdapter, DealSummaryListLoaderCallbacks

public abstract class DealCardListFragment extends BaseCardListFragment
    implements DealSetCallbacks
{

    private Lazy buyUtils;
    private DeepLinkUtil deepLinkUtil;
    private GdtService gdtService;
    protected boolean isForceDownload;
    private boolean isShowBadgeOnGAPIFeaturedTab1509USCA;
    protected DealSubsetAttribute lastDealSubsetAttrs;

    public DealCardListFragment(Channel channel)
    {
        super(channel);
    }

    protected void afterOnLoadFinished(List list)
    {
    }

    public boolean checkForAndStartGoodsMultiOptionActivity(DealSummary dealsummary)
    {
        int i;
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
        if (((BuyUtils)buyUtils.get()).showOptionsWithImages(dealsummary, getActivity()))
        {
            startActivity(((IntentFactory)intentFactory.get()).newGoodsMultiOptionIntent(dealsummary.remoteId, getOriginatingChannel(dealsummary), i));
            return true;
        } else
        {
            return false;
        }
    }

    public PendingAdapterInterface getAppendingAdapter()
    {
        return dealCardEndlessAdapter;
    }

    protected View getCardView(ListAdapter listadapter, int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (DealSummary)listadapter.getItem(i);
        tracking(nstChannel, viewgroup, i, getDealImpressionExtraInfo(viewgroup));
        view = getDealCardView(view, viewgroup, getPlaces());
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

    public Intent getDealCardClickedIntent(DealSummary dealsummary, com.groupon.util.ViewUtils.Size size)
    {
        return ((IntentFactory)intentFactory.get()).newDealIntent(dealsummary, getOriginatingChannel(dealsummary), size);
    }

    protected DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment)
    {
        return new DealCardEndlessAdapter(this, this, new DealCardMultiColumnListAdapter(baseadapter, getDealListColumns()) {

            final DealCardListFragment this$0;

            public void onDealCardClicked(int i, View view, DealSummary dealsummary)
            {
                DealCardListFragment.this.onDealCardClicked(i, view, dealsummary);
            }

            public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
            {
                onMemberClick(view, dealsummary);
            }

            
            {
                this$0 = DealCardListFragment.this;
                super(listadapter, i);
            }
        });
    }

    protected View getDealCardView(View view, DealSummary dealsummary, List list)
    {
        if (view != null && (view instanceof DefaultLargeDealCard))
        {
            view = (DefaultLargeDealCard)view;
        } else
        {
            view = new DefaultLargeDealCard(activity);
        }
        view.setInfoWithPlaces(dealsummary, list);
        return view;
    }

    protected Channel getOriginatingChannel(DealSummary dealsummary)
    {
        return dealsummary.getChannel();
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        getLoaderManager().initLoader(0, null, new DealSummaryListLoaderCallbacks(javalistadapter, this));
    }

    protected void logDealImpression(String s, String s1, DealSummary dealsummary, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
        loggingUtils.logDealImpressionV1(s, s1, dealsummary, i, jsonencodednstfield, s2, abtestservice, flag, requiresRedirectLogging(), flag1);
    }

    protected volatile void logDealImpression(String s, String s1, Object obj, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
        logDealImpression(s, s1, (DealSummary)obj, i, jsonencodednstfield, s2, abtestservice, flag, flag1);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        buyUtils = new Lazy(getActivity()) {

            final DealCardListFragment this$0;

            
            {
                this$0 = DealCardListFragment.this;
                super(context);
            }
        };
        isShowBadgeOnGAPIFeaturedTab1509USCA = abTestService.isVariantEnabledAndUSCA("showBadgeOnGAPIFeaturedTab1509USCA", "on");
    }

    public void onDealCardClicked(int i, View view, DealSummary dealsummary)
    {
        if (dealsummary != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ImpressionClickMetadata impressionclickmetadata;
label0:
        {
            Object obj = dealsummary.remoteId;
            if (Strings.equals(obj, "gtg_mock_promo_deal_summary_remote_id") || Strings.equals(obj, "gtg_mock_jumpoff_deal_summary_remote_id"))
            {
                startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(gdtService.getGtgEntryUrl(), false, true, true, true, false));
                if (Strings.equals(obj, "gtg_mock_promo_deal_summary_remote_id"))
                {
                    view = "gtg_on_featured_click";
                } else
                {
                    view = "impression_click";
                }
                if (pagerChannel != null)
                {
                    dealsummary = pagerChannel.toString();
                } else
                {
                    dealsummary = "";
                }
                if (Strings.equals(obj, "gtg_mock_promo_deal_summary_remote_id"))
                {
                    obj = new GtgMockDealExtraInfo(String.valueOf(i));
                } else
                {
                    obj = new FinderCardExtraInfo(new FinderCard("", "gtg_jumpoff", i));
                }
                loggingUtils.logClick("", view, dealsummary, Logger.NULL_NST_FIELD, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)));
                return;
            }
            impressionclickmetadata = new ImpressionClickMetadata(((String) (obj)), dealsummary.uuid, i, "deal");
            if (!isShowBadgeOnGAPIFeaturedTab1509USCA)
            {
                break label0;
            }
            obj = dealsummary.badges.iterator();
            Badge badge;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                badge = (Badge)((Iterator) (obj)).next();
            } while (!DealUtils.isBadgeValid(badge));
            impressionclickmetadata.badgeDisplayText = badge.text;
            impressionclickmetadata.badgeType = badge.badgeType;
        }
        LoggingUtils loggingutils = loggingUtils;
        Object obj1;
        if (pagerChannel != null)
        {
            obj1 = pagerChannel.toString();
        } else
        {
            obj1 = "";
        }
        loggingutils.logClickWithMetadata("", "impression_click", ((String) (obj1)), impressionclickmetadata);
        if (!checkForAndStartGoodsMultiOptionActivity(dealsummary))
        {
            obj1 = view.findViewById(0x7f100121);
            View view1 = view.findViewById(0x7f100230);
            ArrayList arraylist = new ArrayList();
            arraylist.add(Pair.create(obj1, "deal_image_transition"));
            if (view1.getVisibility() == 0)
            {
                arraylist.add(Pair.create(view1, "sold_out_banner_transition"));
            }
            if (android.os.Build.VERSION.SDK_INT >= 21)
            {
                obj1 = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), (Pair[])arraylist.toArray(new Pair[arraylist.size()]));
            } else
            {
                obj1 = null;
            }
            startActivity(getDealCardClickedIntent(dealsummary, ((DealCardBase)((com.groupon.util.MultiColumnListAdapter.RowItemWrapper)view).getWrappedView()).getImageViewSize()), ((Bundle) (obj1)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public volatile void onDealCardClicked(int i, View view, Object obj)
    {
        onDealCardClicked(i, view, (DealSummary)obj);
    }

    public void onMemberClick(View view, DealSummary dealsummary)
    {
        onWidgetDealCardClicked(view, dealsummary);
    }

    public void onSubsetClick(WidgetSummary widgetsummary)
    {
        loggingUtils.logDealSubsetClick(widgetsummary, getWidgetNstChannelName());
        Object obj = widgetsummary.moreAssetsDealsUrl;
        if (deepLinkUtil.isDeepLink(((String) (obj))))
        {
            try
            {
                obj = deepLinkUtil.getDeepLink(((String) (obj)));
                Bundle bundle = new Bundle();
                bundle.putParcelable("originating_channel", Channel.safeValueOf(getNstChannel()));
                bundle.putString("title", widgetsummary.displayName);
                getOnSubsetClickedExtras(bundle);
                deepLinkManager.followDeepLink(getActivity(), ((com.groupon.deeplink.DeepLinkData) (obj)), bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WidgetSummary widgetsummary)
            {
                startActivity(((IntentFactory)intentFactory.get()).newCarouselIntent());
            }
            return;
        } else
        {
            startActivity(((IntentFactory)intentFactory.get()).newDealSubsetIntent(widgetsummary, channel));
            return;
        }
    }

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
        loggingUtils.logWidgetDealClick(dealsummary, getWidgetNstChannelName());
        View view1 = view.findViewById(0x7f100121);
        View view2 = view.findViewById(0x7f100230);
        view = ((DealCardBase)((com.groupon.util.MultiColumnListAdapter.RowItemWrapper)view).getWrappedView()).getImageViewSize();
        dealsummary = ((IntentFactory)intentFactory.get()).nextActivityFromWidgetDealClick(dealsummary, getChannelNameForDealDetails(), 0, view);
        view = new ArrayList();
        view.add(Pair.create(view1, "deal_image_transition"));
        if (view2.getVisibility() == 0)
        {
            view.add(Pair.create(view2, "sold_out_banner_transition"));
        }
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            view = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), (Pair[])view.toArray(new Pair[view.size()]));
        } else
        {
            view = null;
        }
        startActivity(dealsummary, view);
    }

    public void setForceDownload(boolean flag)
    {
        isForceDownload = flag;
    }

    protected final void tracking(String s, DealSummary dealsummary, int i, JsonEncodedNSTField jsonencodednstfield)
    {
        logDealImpression(s, "", dealsummary, i, jsonencodednstfield, getClass().getSimpleName(), abTestService, true, true);
    }

    protected volatile void tracking(String s, Object obj, int i, JsonEncodedNSTField jsonencodednstfield)
    {
        tracking(s, (DealSummary)obj, i, jsonencodednstfield);
    }
}
