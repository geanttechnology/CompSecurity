// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.ActiveItemsViewHolder;
import com.ebay.mobile.home.cards.InspirationContentViewHolder;
import com.ebay.mobile.home.cards.ListAnItemContentViewHolder;
import com.ebay.mobile.home.cards.ListOfScheduledViewModel;
import com.ebay.mobile.home.cards.ListOfSellingDraftsViewModel;
import com.ebay.mobile.home.cards.NotificationsViewHolder;
import com.ebay.mobile.home.cards.NotificationsViewModel;
import com.ebay.mobile.home.cards.RTMViewHolder;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.mobile.home.cards.SellSignInViewHolder;
import com.ebay.mobile.home.cards.SellSignInViewModel;
import com.ebay.mobile.home.cards.SellingDraftsContentViewHolder;
import com.ebay.mobile.home.cards.SellingOverviewModel;
import com.ebay.mobile.home.cards.SellingUtilityViewHolder;
import com.ebay.mobile.home.cards.SellingUtilityViewModel;
import com.ebay.mobile.home.cards.SoldItemsViewHolder;
import com.ebay.mobile.home.cards.UnsoldItemsViewHolder;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            UssContentsViewAdapter

public class SellFragmentAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{

    private static final int SCREEN_WIDTH_WIDE = 768;
    public static final int VIEW_TYPE_ACTIVE = 4;
    public static final int VIEW_TYPE_INSPIRATION_FULL_RENDER_TIPS = 20;
    public static final int VIEW_TYPE_INSPIRATION_FULL_RENDER_VALET = 16;
    public static final int VIEW_TYPE_INSPIRATION_TIPS = 19;
    public static final int VIEW_TYPE_INSPIRATION_VALET = 5;
    public static final int VIEW_TYPE_LISTANITEM = 2;
    public static final int VIEW_TYPE_LISTANITEM_TABLET = 3;
    public static final int VIEW_TYPE_NOTIFICATIONS = 18;
    public static final int VIEW_TYPE_RTM_PROMO = 14;
    public static final int VIEW_TYPE_RTM_PROMO_SLIM = 15;
    public static final int VIEW_TYPE_SCHEDULED = 12;
    public static final int VIEW_TYPE_SCHEDULED_ITEM = 13;
    public static final int VIEW_TYPE_SELLING_DRAFTS = 6;
    public static final int VIEW_TYPE_SELLING_DRAFTS_ITEM = 7;
    public static final int VIEW_TYPE_SELLING_UTILITY = 8;
    public static final int VIEW_TYPE_SELLING_UTILITY_DOUBLE = 11;
    public static final int VIEW_TYPE_SELLING_UTILITY_SINGLE_ACTIVE_ONLY = 10;
    public static final int VIEW_TYPE_SELLING_UTILITY_SINGLE_SOLD_ONLY = 9;
    public static final int VIEW_TYPE_SELL_SIGN_IN = 17;
    public static final int VIEW_TYPE_SOLD = 0;
    public static final int VIEW_TYPE_UNSOLD = 1;
    protected static boolean isTablet;
    private GridLayoutManager gridLayoutManager;
    public final ChannelCardDecoration itemDecorator = new ChannelCardDecoration();
    private android.support.v7.widget.RecyclerView.LayoutManager linearLayoutManager;
    private List positionToGridSpanSize;
    private final Resources resources;
    private ListOfSellingDraftsViewModel sellingDraftListViewModel;
    public int variationIdCount;

    public SellFragmentAdapter(Context context)
    {
        RecyclerContentAdapter(context);
        resources = context.getResources();
        addViewType(0, com/ebay/mobile/home/cards/SoldItemsViewHolder, 0x7f03010d);
        addViewType(1, com/ebay/mobile/home/cards/UnsoldItemsViewHolder, 0x7f03011d);
        addViewType(2, com/ebay/mobile/home/cards/ListAnItemContentViewHolder, 0x7f0300d3);
        addViewType(3, com/ebay/mobile/home/cards/ListAnItemContentViewHolder, 0x7f0300d4);
        addViewType(4, com/ebay/mobile/home/cards/ActiveItemsViewHolder, 0x7f0300c8);
        addViewType(5, com/ebay/mobile/home/cards/InspirationContentViewHolder, 0x7f0300eb);
        addViewType(19, com/ebay/mobile/home/cards/InspirationContentViewHolder, 0x7f0300eb);
        addViewType(16, com/ebay/mobile/home/cards/InspirationContentViewHolder, 0x7f0300eb);
        addViewType(20, com/ebay/mobile/home/cards/InspirationContentViewHolder, 0x7f0300eb);
        addViewType(6, com/ebay/mobile/home/cards/SellingDraftsContentViewHolder, 0x7f030103);
        addViewType(8, com/ebay/mobile/home/cards/SellingUtilityViewHolder, 0x7f030104);
        addViewType(10, com/ebay/mobile/home/cards/SellingUtilityViewHolder, 0x7f030106);
        addViewType(9, com/ebay/mobile/home/cards/SellingUtilityViewHolder, 0x7f030107);
        addViewType(11, com/ebay/mobile/home/cards/SellingUtilityViewHolder, 0x7f030105);
        addViewType(12, com/ebay/mobile/home/cards/SellingDraftsContentViewHolder, 0x7f030103);
        addViewType(14, com/ebay/mobile/home/cards/RTMViewHolder, 0x7f0300ed);
        addViewType(15, com/ebay/mobile/home/cards/RTMViewHolder, 0x7f0300ee);
        addViewType(17, com/ebay/mobile/home/cards/SellSignInViewHolder, 0x7f030102);
        addViewType(18, com/ebay/mobile/home/cards/NotificationsViewHolder, 0x7f0300fe);
        isTablet = resources.getBoolean(0x7f0b0006);
        positionToGridSpanSize = new ArrayList();
        variationIdCount = 0;
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        if (isTablet || isLandscape)
        {
            if (gridLayoutManager == null)
            {
                gridLayoutManager = new GridLayoutManager((Context)contextReference.get(), getNumSpans(), 1, false);
                gridLayoutManager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                    final SellFragmentAdapter this$0;

                    public int getSpanSize(int i)
                    {
                        return ((Integer)positionToGridSpanSize.get(i)).intValue();
                    }

            
            {
                this$0 = SellFragmentAdapter.this;
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

    public ListOfSellingDraftsViewModel getDrafts()
    {
        return sellingDraftListViewModel;
    }

    public void setContents(Contents contents)
    {
        int k;
        dataSet.clear();
        variationIdCount = 0;
        positionToGridSpanSize.clear();
        if (contents == null)
        {
            return;
        }
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        k = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        if (contents == null || contents.contentGroups == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = contents.contentGroups.iterator();
_L9:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        contents = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)iterator.next();
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource == ContentSourceEnum.TODO)
        {
            dataSet.add(new NotificationsViewModel(18, contents, getOnClickListener(18)));
            positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource == ContentSourceEnum.SIGN_IN)
        {
            dataSet.add(new SellSignInViewModel(17, getOnClickListener(17)));
            positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource != ContentSourceEnum.SELLING_UTILITY && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource != ContentSourceEnum.SELLERINSPIRATION_INSPIRATION && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource != ContentSourceEnum.SELLERINSPIRATION_LISTANITEM)
        {
            break MISSING_BLOCK_LABEL_931;
        }
        if (k >= 768 && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource == ContentSourceEnum.SELLING_UTILITY)
        {
            int i = SellingUtilityViewHolder.getSellingUtilityResource(contents);
            SellingUtilityViewModel sellingutilityviewmodel = new SellingUtilityViewModel(i, contents, getOnClickListener(i));
            if (SellingUtilityViewHolder.isValidModel(sellingutilityviewmodel))
            {
                dataSet.add(sellingutilityviewmodel);
                positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            }
        }
        obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contents.iterator();
_L4:
        Object obj1;
        Object obj2;
        boolean flag2;
label0:
        do
        {
            while (((Iterator) (obj)).hasNext()) 
            {
                obj1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
                obj2 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).type;
                if (k < 768 && obj2 == ContentTypeEnum.ACTIVE)
                {
                    obj1 = new SellingUtilityViewModel(4, contents, getOnClickListener(4));
                    if (ActiveItemsViewHolder.isValidModel(((ViewModel) (obj1)), isTablet, isLandscape))
                    {
                        dataSet.add(obj1);
                        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                    }
                } else
                if (k < 768 && obj2 == ContentTypeEnum.SOLD)
                {
                    obj1 = new SellingUtilityViewModel(0, contents, getOnClickListener(0));
                    if (SoldItemsViewHolder.isValidModel(((ViewModel) (obj1)), isTablet, isLandscape))
                    {
                        dataSet.add(obj1);
                        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                    }
                } else
                if (k < 768 && obj2 == ContentTypeEnum.UNSOLD)
                {
                    obj1 = new SellingUtilityViewModel(1, contents, getOnClickListener(1));
                    if (UnsoldItemsViewHolder.isValidModel(((ViewModel) (obj1)), isTablet, isLandscape))
                    {
                        dataSet.add(obj1);
                        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                    }
                } else
                {
                    if (obj2 != ContentTypeEnum.IMAGE_TEMPLATE)
                    {
                        continue label0;
                    }
                    byte byte0;
                    if (k < 768)
                    {
                        byte0 = 2;
                    } else
                    {
                        byte0 = 3;
                    }
                    obj1 = new SellingOverviewModel(byte0, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)), getOnClickListener(byte0));
                    if (ListAnItemContentViewHolder.isValidModel(((ViewModel) (obj1)), isTablet, isLandscape))
                    {
                        dataSet.add(obj1);
                        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                        variationIdCount = variationIdCount + 1;
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
        } while (obj2 != ContentTypeEnum.IMAGE_LIST_TEMPLATE || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).sellerInspirations == null);
        flag2 = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.Verticals.B.valet);
        obj2 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).sellerInspirations.iterator();
_L6:
        if (!((Iterator) (obj2)).hasNext()) goto _L4; else goto _L3
_L3:
        int j;
        boolean flag;
        boolean flag1;
        Object obj3 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList)((Iterator) (obj2)).next();
        if (isTablet && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).sellerInspirations.size() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isTablet && !flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (obj3)).name != com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Name.valet)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        if (!flag2) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            j = 16;
        } else
        {
            j = 5;
        }
_L7:
        dataSet.add(new SellingOverviewModel(j, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (obj3)), getOnClickListener(j)));
        obj3 = positionToGridSpanSize;
        if (k < 768 || flag || flag1)
        {
            j = getNumSpans();
        } else
        {
            j = 1;
        }
        ((List) (obj3)).add(Integer.valueOf(j));
        variationIdCount = variationIdCount + 1;
          goto _L6
          goto _L4
        if (flag || flag1)
        {
            j = 20;
        } else
        {
            j = 19;
        }
          goto _L7
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource == ContentSourceEnum.LISTING_DRAFT)
        {
            sellingDraftListViewModel = ListOfSellingDraftsViewModel.createFromSellingDrafts(6, resources.getString(0x7f07029d), contents, getOnClickListener(7), getOnClickListener(6));
            if (SellingDraftsContentViewHolder.isValidModel(sellingDraftListViewModel, isTablet, isLandscape))
            {
                dataSet.add(sellingDraftListViewModel);
                positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            }
        } else
        {
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource != ContentSourceEnum.SCHEDULED_LISTING)
            {
                continue; /* Loop/switch isn't completed */
            }
            contents = ListOfScheduledViewModel.createFromScheduledListings(12, resources.getString(0x7f07046c), contents, getOnClickListener(13), getOnClickListener(12));
            if (SellingDraftsContentViewHolder.isValidModel(contents, isTablet, isLandscape))
            {
                dataSet.add(contents);
                positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            }
        }
        continue; /* Loop/switch isn't completed */
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contentSource != ContentSourceEnum.RTM) goto _L9; else goto _L8
_L8:
        obj = DeviceConfiguration.getAsync();
        obj1 = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (contents)).contents.iterator();
_L10:
        while (((Iterator) (obj1)).hasNext()) 
        {
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj1)).next();
            if (contentrecord.type == ContentTypeEnum.RTM_CAMPAIGN)
            {
                contents = null;
                if (contentrecord.rtm.cardStyle == 0 || !((DeviceConfiguration) (obj)).get(com.ebay.mobile.dcs.Dcs.Verticals.B.rtmCardStyle))
                {
                    contents = new RTMViewModel(14, contentrecord.rtm, getOnClickListener(14));
                } else
                if (contentrecord.rtm.cardStyle == 1)
                {
                    contents = new RTMViewModel(15, contentrecord.rtm, getOnClickListener(14));
                }
                if (contents != null && RTMViewHolder.isValidModel(contents))
                {
                    dataSet.add(contents);
                    positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                }
            }
        }
        if (true) goto _L9; else goto _L2
_L2:
        notifyDataSetChanged();
        return;
          goto _L10
    }









}
