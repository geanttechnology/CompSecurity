// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.FragmentManager;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchRewriteDescriptor;
import com.ebay.common.net.api.search.idealmodel.RewriteEndSrpListItem;
import com.ebay.common.net.api.search.idealmodel.RewriteStartSrpListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.mobile.search.SearchResultFragment;
import com.ebay.mobile.search.SearchResultFragmentActivity;
import com.ebay.mobile.search.SearchUtil;

public class RewriteViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
    implements android.view.View.OnClickListener
{

    private SrpListItem bannerItem;
    private final View itemView;
    private final SearchParameters originalSearchParameters;
    private final SearchParameters searchParameters;

    public RewriteViewHolder(View view, TextView textview, SearchParameters searchparameters, SearchParameters searchparameters1)
    {
        super(view, textview);
        itemView = view;
        itemView.setOnClickListener(this);
        searchParameters = searchparameters;
        originalSearchParameters = searchparameters1;
    }

    protected void onBindView(int i, SrpListItem srplistitem)
    {
        if (srplistitem != null)
        {
            bannerItem = srplistitem;
            if (srplistitem.itemType == com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REWRITE_END)
            {
                srplistitem = (RewriteEndSrpListItem)bannerItem;
                SearchParameters searchparameters = KnownSearchExpansion.getCorrectedSearchParameters(searchParameters, ((RewriteEndSrpListItem) (srplistitem)).expansionDescriptor.expansion);
                ((RewriteEndSrpListItem) (srplistitem)).expansionDescriptor.setExpansionSearchParameters(searchparameters);
                if (((RewriteEndSrpListItem) (srplistitem)).expansionDescriptor.expansionType == KnownSearchExpansion.CROSS_BORDER)
                {
                    textView.setText(itemView.getContext().getString(0x7f07063e));
                } else
                {
                    textView.setText(itemView.getContext().getString(0x7f07063f));
                }
            } else
            {
                RewriteStartSrpListItem rewritestartsrplistitem = (RewriteStartSrpListItem)bannerItem;
                if (rewritestartsrplistitem.expansionDescriptor.expansionType == KnownSearchExpansion.SPELL_CHECK_SUGGESTED)
                {
                    srplistitem = KnownSearchExpansion.getCorrectedSearchParameters(searchParameters, rewritestartsrplistitem.expansionDescriptor.expansion);
                } else
                {
                    srplistitem = originalSearchParameters;
                }
                rewritestartsrplistitem.expansionDescriptor.setExpansionSearchParameters(srplistitem);
                textView.setText(SearchUtil.getTitleForRewrite(itemView.getContext(), rewritestartsrplistitem));
            }
            srplistitem = itemView.getLayoutParams();
            if (srplistitem instanceof android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)
            {
                srplistitem = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)srplistitem;
                srplistitem.setFullSpan(true);
                itemView.setLayoutParams(srplistitem);
                return;
            }
        }
    }

    protected volatile void onBindView(int i, Object obj)
    {
        onBindView(i, (SrpListItem)obj);
    }

    public void onClick(View view)
    {
        view = (SearchResultFragment)((SearchResultFragmentActivity)view.getContext()).getFragmentManager().findFragmentById(0x7f1005ff);
        if (bannerItem.itemType == com.ebay.common.net.api.search.idealmodel.SrpListItem.SrpListItemType.REWRITE_END)
        {
            RewriteEndSrpListItem rewriteendsrplistitem = (RewriteEndSrpListItem)bannerItem;
            if (rewriteendsrplistitem.expansionDescriptor.expansionSearchParameters != null)
            {
                view.restartSearch(rewriteendsrplistitem.expansionDescriptor.expansionSearchParameters, rewriteendsrplistitem.expansionDescriptor.expansionType.permitExpansionsInRecourse, false);
            }
        } else
        {
            RewriteStartSrpListItem rewritestartsrplistitem = (RewriteStartSrpListItem)bannerItem;
            if (rewritestartsrplistitem.expansionDescriptor.expansion.expansionResult.isRecoursable && (rewritestartsrplistitem.expansionDescriptor.expansion.expansionResult.promotedToPrimary || rewritestartsrplistitem.expansionDescriptor.expansionSearchParameters != null))
            {
                view.restartSearch(rewritestartsrplistitem.expansionDescriptor.expansionSearchParameters, rewritestartsrplistitem.expansionDescriptor.expansionType.permitExpansionsInRecourse, false);
                return;
            }
        }
    }
}
