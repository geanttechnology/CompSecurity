// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.BuyingOverviewHolder;
import com.ebay.mobile.home.cards.BuyingOverviewModel;
import com.ebay.mobile.home.cards.ErrorViewHolder;
import com.ebay.mobile.home.cards.FollowingViewHolder;
import com.ebay.mobile.home.cards.FollowingViewModel;
import com.ebay.mobile.home.cards.NotificationsViewHolder;
import com.ebay.mobile.home.cards.NotificationsViewModel;
import com.ebay.mobile.home.cards.RecentlyViewedItemsHolder;
import com.ebay.mobile.home.cards.RecentlyViewedItemsModel;
import com.ebay.mobile.home.cards.SellingOverviewHolder;
import com.ebay.mobile.home.cards.SellingOverviewModel;
import com.ebay.mobile.home.cards.WatchingViewHolder;
import com.ebay.mobile.home.cards.WatchingViewModel;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.RecordStatusEnum;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            UssContentsViewAdapter

public class StartFragmentAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{
    public static interface AdapterHost
    {

        public abstract boolean isSellChannelEnabled();
    }


    public static final int VIEW_TYPE_BUYINGOVERVIEW = 8;
    public static final int VIEW_TYPE_BUYINGOVERVIEW_EMPTY = 9;
    public static final int VIEW_TYPE_BUYINGOVERVIEW_ERROR = 10;
    public static final int VIEW_TYPE_FOLLOWING = 2;
    public static final int VIEW_TYPE_FOLLOWING_EMPTY = 3;
    public static final int VIEW_TYPE_NOTIFICATIONS = 0;
    public static final int VIEW_TYPE_RECENTLYVIEWED = 4;
    public static final int VIEW_TYPE_SELLINGOVERVIEW = 5;
    public static final int VIEW_TYPE_SELLINGOVERVIEW_EMPTY = 6;
    public static final int VIEW_TYPE_SELLINGOVERVIEW_ERROR = 7;
    public static final int VIEW_TYPE_WATCHING = 1;
    protected static boolean isLandscape;
    protected static boolean isNarrowTablet;
    protected static boolean isTablet;
    private AdapterHost adapterHost;
    private ItemCache cache;
    private GridLayoutManager gridLayoutManager;
    public final ChannelCardDecoration itemDecorator = new ChannelCardDecoration();
    private android.support.v7.widget.RecyclerView.LayoutManager linearLayoutManager;
    private List positionToGridSpanSize;
    private Resources resources;

    public StartFragmentAdapter(Context context, AdapterHost adapterhost)
    {
        boolean flag1 = true;
        RecyclerContentAdapter(context);
        cache = new ItemCache(context);
        addViewType(0, com/ebay/mobile/home/cards/NotificationsViewHolder, 0x7f0300fe);
        addViewType(1, com/ebay/mobile/home/cards/WatchingViewHolder, 0x7f030121);
        addViewType(2, com/ebay/mobile/home/cards/FollowingViewHolder, 0x7f0300f3);
        addViewType(3, com/ebay/mobile/home/cards/FollowingViewHolder, 0x7f0300f4);
        addViewType(4, com/ebay/mobile/home/cards/RecentlyViewedItemsHolder, 0x7f0300ff);
        addViewType(5, com/ebay/mobile/home/cards/SellingOverviewHolder, 0x7f030108);
        addViewType(6, com/ebay/mobile/home/cards/SellingOverviewHolder, 0x7f030109);
        addViewType(7, com/ebay/mobile/home/cards/ErrorViewHolder, 0x7f03010a);
        addViewType(8, com/ebay/mobile/home/cards/BuyingOverviewHolder, 0x7f0300cf);
        addViewType(9, com/ebay/mobile/home/cards/BuyingOverviewHolder, 0x7f0300d0);
        addViewType(10, com/ebay/mobile/home/cards/ErrorViewHolder, 0x7f0300d1);
        isTablet = context.getResources().getBoolean(0x7f0b0006);
        boolean flag;
        if (!DeviceInfoUtil.isPortrait(context))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLandscape = flag;
        if (context.getResources().getConfiguration().screenWidthDp < 720)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isNarrowTablet = flag;
        resources = context.getResources();
        positionToGridSpanSize = new ArrayList();
        adapterHost = adapterhost;
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        if ((isTablet || isLandscape) && !isNarrowTablet)
        {
            if (gridLayoutManager == null)
            {
                gridLayoutManager = new GridLayoutManager((Context)contextReference.get(), getNumSpans(), 1, false);
                gridLayoutManager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                    final StartFragmentAdapter this$0;

                    public int getSpanSize(int i)
                    {
                        return ((Integer)positionToGridSpanSize.get(i)).intValue();
                    }

            
            {
                this$0 = StartFragmentAdapter.this;
                super();
            }
                });
            }
            return gridLayoutManager;
        }
        if (linearLayoutManager == null)
        {
            linearLayoutManager = new LinearLayoutManager((Context)contextReference.get());
        }
        return linearLayoutManager;
    }

    public int getNumSpans()
    {
        return !isTablet && !isLandscape ? 1 : 2;
    }

    public void setContents(Contents contents)
    {
        dataSet.clear();
        positionToGridSpanSize.clear();
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (contents != null && contents.contentGroups != null)
        {
            for (contents = contents.contentGroups.iterator(); contents.hasNext();)
            {
                Object obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.next();
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.TODO && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.notifications))
                {
                    dataSet.add(new NotificationsViewModel(0, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(0)));
                    positionToGridSpanSize.add(Integer.valueOf(2));
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.WATCHING && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.watchedItems))
                {
                    dataSet.add(new WatchingViewModel(1, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(1)));
                    positionToGridSpanSize.add(Integer.valueOf(2));
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.FOLLOW && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.following) && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents != null)
                {
                    com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.get(0);
                    if (contentrecord != null && contentrecord.followedEntities != null && contentrecord.followedEntities.emptyFollow)
                    {
                        dataSet.add(new FollowingViewModel(3, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), cache, null));
                    } else
                    {
                        dataSet.add(new FollowingViewModel(2, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), cache, getOnClickListener(2)));
                    }
                    positionToGridSpanSize.add(Integer.valueOf(2));
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.RECENTLY_VIEWED_ITEMS && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.recentlyViewedItems))
                {
                    dataSet.add(new RecentlyViewedItemsModel(4, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(4)));
                    positionToGridSpanSize.add(Integer.valueOf(2));
                }
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.BUYING_SELLING_OVERVIEW)
                {
                    obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
                        if (contentrecord1.source == ContentSourceEnum.BUYING_SELLING_OVERVIEW)
                        {
                            if (contentrecord1.type == ContentTypeEnum.BUYING_SUMMARY && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.buyingOverview))
                            {
                                if (contentrecord1.status == RecordStatusEnum.FAILURE)
                                {
                                    dataSet.add(new BuyingOverviewModel(10, contentrecord1, getOnClickListener(10)));
                                } else
                                if (contentrecord1.emptyBuying)
                                {
                                    dataSet.add(new BuyingOverviewModel(9, contentrecord1, getOnClickListener(9)));
                                } else
                                {
                                    dataSet.add(new BuyingOverviewModel(8, contentrecord1, getOnClickListener(8)));
                                }
                                if (isTablet || isLandscape)
                                {
                                    positionToGridSpanSize.add(Integer.valueOf(1));
                                } else
                                {
                                    positionToGridSpanSize.add(Integer.valueOf(2));
                                }
                            } else
                            if (contentrecord1.type == ContentTypeEnum.SELLING_SUMMARY && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.sellingOverview))
                            {
                                if (contentrecord1.status == RecordStatusEnum.FAILURE)
                                {
                                    dataSet.add(new SellingOverviewModel(7, contentrecord1, adapterHost.isSellChannelEnabled(), getOnClickListener(7)));
                                } else
                                if (contentrecord1.sellingOverview.isFirstTimeLister)
                                {
                                    dataSet.add(new SellingOverviewModel(6, contentrecord1, adapterHost.isSellChannelEnabled(), getOnClickListener(6)));
                                } else
                                {
                                    dataSet.add(new SellingOverviewModel(5, contentrecord1, adapterHost.isSellChannelEnabled(), getOnClickListener(5)));
                                }
                                if (isTablet || isLandscape)
                                {
                                    positionToGridSpanSize.add(Integer.valueOf(1));
                                } else
                                {
                                    positionToGridSpanSize.add(Integer.valueOf(2));
                                }
                            }
                        }
                    }
                }
            }

        }
        notifyDataSetChanged();
    }









}
