// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchRewriteDescriptor;
import com.ebay.common.net.api.search.idealmodel.AdsListItem;
import com.ebay.common.net.api.search.idealmodel.RewriteStartSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItemViewModel;
import com.ebay.mobile.search.SrpListItemRenderer;
import com.ebay.mobile.search.SrpTileItemRenderer;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.shell.app.BaseActivity;

// Referenced classes of package com.ebay.common.view:
//            AdsViewHolder, RewriteViewHolder, RegularItemViewHolder

public class SearchCompositeRecyclerAdapter extends CompositeArrayRecyclerAdapter
{
    private static class SizableHeaderViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder
    {

        private final View itemView;

        public SizableHeaderViewHolder(View view, int i)
        {
            super(view);
            itemView = view;
            view = new android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams(-1, i);
            view.setFullSpan(true);
            itemView.setLayoutParams(view);
        }
    }


    private static final int VIEW_TYPE_ADS = 11;
    private static final int VIEW_TYPE_COUNT = 5;
    private static final int VIEW_TYPE_GOOGLE_TEXT_AD = 12;
    private static final int VIEW_TYPE_LABELED_ITEM = 6;
    private static final int VIEW_TYPE_REGULAR_ITEM = 5;
    private static final int VIEW_TYPE_REWRITE_END = 10;
    private static final int VIEW_TYPE_REWRITE_NEW_SEARCH = 7;
    private static final int VIEW_TYPE_REWRITE_STATIC = 9;
    private static final int VIEW_TYPE_REWRITE_UNDO = 8;
    private final android.view.View.OnClickListener adsClickListener;
    private final int adsResId;
    private int headerHeight;
    private final int headerNewSearch = 0x7f0301cc;
    private int headerResourceId;
    private final int headerRewriteEnd = 0x7f0301cd;
    private final int headerStatic = 0x7f0301ce;
    private final int headerUndo = 0x7f0301d0;
    private final boolean isSellerItems;
    protected final boolean isTile;
    private final SearchParameters originalSearchParameters;
    private final SrpListItemRenderer renderer;
    private final int resourceId;
    private SearchParameters searchParameters;

    public SearchCompositeRecyclerAdapter(BaseActivity baseactivity, int i, int j, boolean flag, SearchParameters searchparameters, SearchParameters searchparameters1, android.view.View.OnClickListener onclicklistener)
    {
        super(baseactivity, i);
        resourceId = i;
        adsResId = j;
        isTile = flag;
        searchParameters = searchparameters;
        originalSearchParameters = searchparameters1;
        isSellerItems = TextUtils.isEmpty(searchparameters.sellerId);
        if (isTile)
        {
            baseactivity = new SrpTileItemRenderer(baseactivity.getEbayContext(), searchparameters);
        } else
        {
            baseactivity = new SrpListItemRenderer(baseactivity.getEbayContext(), searchparameters);
        }
        renderer = baseactivity;
        adsClickListener = onclicklistener;
    }

    private int getAdType(AdsListItem adslistitem)
    {
        return adslistitem.searchAds == null ? 12 : 11;
    }

    private int getRewriteType(RewriteStartSrpListItem rewritestartsrplistitem)
    {
        if (rewritestartsrplistitem.expansionDescriptor.expansionType == KnownSearchExpansion.SPELL_CHECK_SUGGESTED)
        {
            return 7;
        }
        return !rewritestartsrplistitem.expansionDescriptor.expansion.expansionResult.promotedToPrimary ? 9 : 8;
    }

    private AdsViewHolder onCreateAdsViewHolder(ViewGroup viewgroup, int i)
    {
        if (i == 11)
        {
            viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(adsResId, viewgroup, false);
        } else
        {
            viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(0x7f0301c8, viewgroup, false);
        }
        return new AdsViewHolder(viewgroup, adsClickListener);
    }

    private RewriteViewHolder onCreateRewriteViewHolder(ViewGroup viewgroup, int i)
    {
        i;
        JVM INSTR tableswitch 7 9: default 28
    //                   7 71
    //                   8 91
    //                   9 111;
           goto _L1 _L2 _L3 _L4
_L1:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(headerRewriteEnd, viewgroup, false);
_L6:
        return new RewriteViewHolder(viewgroup, (TextView)viewgroup.findViewById(0x1020014), searchParameters, originalSearchParameters);
_L2:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(headerNewSearch, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(headerUndo, viewgroup, false);
        continue; /* Loop/switch isn't completed */
_L4:
        viewgroup = LayoutInflater.from(viewgroup.getContext()).inflate(headerStatic, viewgroup, false);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getItemViewType(int i)
    {
        int j = super.getItemViewType(i);
        if (j != 0) goto _L2; else goto _L1
_L1:
        SrpListItem srplistitem = (SrpListItem)super.getItem(i);
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[];

            static 
            {
                $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType = new int[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REGULAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.LABELED_ANSWER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REWRITE_START.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REWRITE_END.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$search$idealmodel$SrpListItem$SrpListItemType[com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.ADS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType[srplistitem.itemType.ordinal()];
        JVM INSTR tableswitch 1 5: default 64
    //                   1 66
    //                   2 68
    //                   3 71
    //                   4 80
    //                   5 83;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return j;
_L3:
        return 5;
_L4:
        return 6;
_L5:
        return getRewriteType((RewriteStartSrpListItem)srplistitem);
_L6:
        return 10;
_L7:
        return getAdType((AdsListItem)srplistitem);
    }

    public int getResourceId()
    {
        return resourceId;
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new SizableHeaderViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(headerResourceId, viewgroup, false), headerHeight);
    }

    public RegularItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        return new RegularItemViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(resourceId, viewgroup, false), renderer, isSellerItems);
    }

    public volatile com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        return onCreateItemViewHolder(viewgroup);
    }

    public volatile android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        return onCreateViewHolder(viewgroup, i);
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder onCreateViewHolder(ViewGroup viewgroup, int i)
    {
        switch (i)
        {
        default:
            return super.onCreateViewHolder(viewgroup, i);

        case 5: // '\005'
        case 6: // '\006'
            return onCreateItemViewHolder(viewgroup);

        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            return onCreateRewriteViewHolder(viewgroup, i);

        case 11: // '\013'
        case 12: // '\f'
            return onCreateAdsViewHolder(viewgroup, i);
        }
    }

    public void onFragmentTimerTick(View view)
    {
        if (view != null && view.getTag() != null)
        {
            renderer.onFragmentTimerTick(view, (SrpListItemViewModel)view.getTag());
        }
    }

    public void setHeaderHeight(int i)
    {
        headerHeight = i;
    }

    public void setHeaderViewResource(int i)
    {
        super.setHeaderViewResource(i);
        headerResourceId = i;
    }

    public void setSearchParameters(SearchParameters searchparameters)
    {
        searchParameters = searchparameters;
    }
}
