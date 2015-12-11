// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.deals;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.UssContentsViewAdapter;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.deals:
//            DealsDetailsHeaderViewHolder, ListingViewHolder, DealsContentViewHolder, DealsDetailsHeaderViewModel, 
//            DealsDetailsActivity

public class DealsContentAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{

    private static final int SCREEN_WIDTH_WIDE = 768;
    public static final int VIEW_TYPE_DEALS_DETAILS = 44;
    public static final int VIEW_TYPE_DEALS_DETAILS_HEADER = 45;
    public static final int VIEW_TYPE_DEALS_LARGE_PHONE = 40;
    private static final int VIEW_TYPE_DEALS_LARGE_TABLET = 42;
    public static final int VIEW_TYPE_DEALS_SMALL_PHONE = 41;
    private static final int VIEW_TYPE_DEALS_SMALL_TABLET = 43;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener dealsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

        final DealsContentAdapter this$0;

        public void onClick(View view, ViewModel viewmodel)
        {
            if (viewmodel instanceof ListingViewModel)
            {
                viewmodel = (ListingViewModel)viewmodel;
                ItemViewActivity.StartActivity((Activity)view.getContext(), Long.parseLong(((ListingViewModel) (viewmodel)).listingId), com.ebay.common.ConstantsCommon.ItemKind.Deals);
            }
        }

            
            {
                this$0 = DealsContentAdapter.this;
                super();
            }
    };
    private final String dealsTitle;
    private final int dp;
    private final Boolean isDetailsMode;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener moreClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

        final DealsContentAdapter this$0;

        public void onClick(View view, ViewModel viewmodel)
        {
            if (viewmodel instanceof ListOfListingsViewModel)
            {
                viewmodel = (ListOfListingsViewModel)viewmodel;
                DealsDetailsActivity.startActivity((Activity)view.getContext(), ((ListOfListingsViewModel) (viewmodel)).listingsTitle, ((ListOfListingsViewModel) (viewmodel)).categoryId, true);
            }
        }

            
            {
                this$0 = DealsContentAdapter.this;
                super();
            }
    };
    private final Resources resources;

    public DealsContentAdapter(Context context)
    {
        this(context, null, Boolean.valueOf(false));
    }

    public DealsContentAdapter(Context context, String s, Boolean boolean1)
    {
        super(context);
        resources = context.getResources();
        context = resources.getDisplayMetrics();
        dp = (int)((float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density);
        dealsTitle = s;
        isDetailsMode = boolean1;
        if (boolean1.booleanValue())
        {
            addViewType(45, com/ebay/mobile/deals/DealsDetailsHeaderViewHolder, 0x7f030037);
            addViewType(44, com/ebay/mobile/deals/ListingViewHolder, 0x7f030087);
            return;
        } else
        {
            addViewType(40, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f0300e1);
            addViewType(41, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f0300e3);
            addViewType(42, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f0300e2);
            addViewType(43, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f0300e4);
            return;
        }
    }

    public int getNumSpans()
    {
        if (isTablet && isDetailsMode.booleanValue())
        {
            return !isLandscape ? 3 : 4;
        } else
        {
            return 2;
        }
    }

    public void setContents(Contents contents)
    {
        if (contents == null)
        {
            contents = null;
        } else
        {
            contents = contents.contentGroups;
        }
        if (contents == null || contents.isEmpty())
        {
            return;
        }
        dataSet.clear();
        contents = contents.iterator();
        do
        {
            if (!contents.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.next();
            if (contentgroup != null || contentgroup.contentSource == ContentSourceEnum.DEALS)
            {
                List list = contentgroup.contents;
                if (list != null)
                {
                    ArrayList arraylist = new ArrayList();
                    Iterator iterator = list.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        Object obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)iterator.next();
                        if (obj != null)
                        {
                            ContentTypeEnum contenttypeenum = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj)).type;
                            if (contenttypeenum != null && contenttypeenum == ContentTypeEnum.DEALS_CATEGORY)
                            {
                                byte byte0;
                                if (isDetailsMode.booleanValue())
                                {
                                    byte0 = 44;
                                } else
                                if (obj == list.get(0))
                                {
                                    if (dp < 768)
                                    {
                                        byte0 = 40;
                                    } else
                                    {
                                        byte0 = 42;
                                    }
                                } else
                                if (dp < 768)
                                {
                                    byte0 = 41;
                                } else
                                {
                                    byte0 = 43;
                                }
                                obj = ListOfListingsViewModel.createFromContentRecordListings(byte0, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj)).title, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj)).id, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj)).listings, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj)).hasMoreListings, dealsClickListener, moreClickListener);
                                if (DealsContentViewHolder.isValidModel(((ViewModel) (obj)), isTablet, isLandscape))
                                {
                                    if (isDetailsMode.booleanValue())
                                    {
                                        arraylist.addAll(((ListOfListingsViewModel) (obj)).listings);
                                    } else
                                    {
                                        arraylist.add(obj);
                                    }
                                }
                            }
                        }
                    } while (true);
                    if (!arraylist.isEmpty())
                    {
                        if (isDetailsMode.booleanValue())
                        {
                            DealsDetailsHeaderViewModel dealsdetailsheaderviewmodel = new DealsDetailsHeaderViewModel(45, dealsTitle, null, getOnClickListener(45));
                            dataSet.add(dealsdetailsheaderviewmodel);
                        }
                        dataSet.addAll(arraylist);
                    }
                }
            }
        } while (true);
        notifyDataSetChanged();
    }
}
