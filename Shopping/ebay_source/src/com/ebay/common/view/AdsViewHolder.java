// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.ebay.common.net.api.search.idealmodel.AdsListItem;
import com.ebay.common.net.api.search.idealmodel.SrpListItem;
import com.ebay.mobile.util.AdUtil;
import java.util.List;

public class AdsViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder
{

    private final android.view.View.OnClickListener adsClickListener;
    private final View adsView;
    private final int numberAdColumns;
    private final int numberGridColumns;

    public AdsViewHolder(View view, android.view.View.OnClickListener onclicklistener)
    {
        super(view, null);
        adsView = view;
        adsClickListener = onclicklistener;
        view = view.getResources();
        numberAdColumns = view.getInteger(0x7f0c0002);
        numberGridColumns = view.getInteger(0x7f0c0003);
    }

    protected void onBindView(int i, SrpListItem srplistitem)
    {
        if (srplistitem != null)
        {
            srplistitem = (AdsListItem)srplistitem;
            adsView.setVisibility(0);
            if (((AdsListItem) (srplistitem)).searchAds != null)
            {
                adsView.findViewById(0x7f100562).setVisibility(0);
                AdUtil.renderAds(adsView, ((AdsListItem) (srplistitem)).searchAds.adsList, ((AdsListItem) (srplistitem)).searchAds.isProductListingAds, adsClickListener, numberAdColumns, ((AdsListItem) (srplistitem)).searchAds.adsList.size(), numberGridColumns);
            } else
            if (((AdsListItem) (srplistitem)).googleTextAdView != null)
            {
                LinearLayout linearlayout = (LinearLayout)adsView.findViewById(0x7f100560);
                linearlayout.removeAllViews();
                linearlayout.addView(((AdsListItem) (srplistitem)).googleTextAdView);
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
}
