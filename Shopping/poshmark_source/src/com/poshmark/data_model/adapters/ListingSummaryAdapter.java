// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMData;
import com.poshmark.ui.customviews.ListingStatusView;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.ItemPair;
import com.poshmark.utils.TextFormatter;
import com.poshmark.utils.view_holders.ListingSummaryViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListingSummaryAdapter extends CursorAdapter
{

    Set imageList;
    private LayoutInflater inflater;
    PMFragment ownerFragment;
    TextFormatter textFormatter;

    public ListingSummaryAdapter(Context context, PMFragment pmfragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
        textFormatter = new TextFormatter();
        imageList = new HashSet();
        ownerFragment = pmfragment;
    }

    private void loadCovershot(ListingSummary listingsummary, PMCovershotImageView pmcovershotimageview, ListingStatusView listingstatusview)
    {
        pmcovershotimageview.setListingId(listingsummary.getIdAsString());
        String s = listingsummary.getSmallCovershot();
        String s1 = listingsummary.getMediumCovershot();
        if (!pmcovershotimageview.getImageURL().equals(s) && !pmcovershotimageview.getImageURL().equals(s1))
        {
            if (s == null)
            {
                s = s1;
            }
            pmcovershotimageview.loadImage(s);
        }
        listingsummary = listingsummary.getListingStatus();
        if (listingsummary == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.SOLD || listingsummary == com.poshmark.data_model.models.inner_models.Inventory.ListingStatus.RESERVED)
        {
            listingstatusview.setVisibility(0);
            listingstatusview.setListingStatus(listingsummary);
            listingstatusview.bringToFront();
            return;
        } else
        {
            listingstatusview.setVisibility(8);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = (ItemPair)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        view = (ListingSummaryViewHolder)view.getTag();
        Object obj = (ListingSummary)cursor.getLeftItem();
        LinearLayout linearlayout = ((ListingSummaryViewHolder) (view)).leftLayout;
        int i;
        if (obj != null)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        linearlayout.setVisibility(i);
        if (obj != null)
        {
            loadCovershot(((ListingSummary) (obj)), ((ListingSummaryViewHolder) (view)).covershotLeft, ((ListingSummaryViewHolder) (view)).statusViewLeft);
            ((ListingSummaryViewHolder) (view)).creatorTextViewLeft.setText((new StringBuilder()).append(context.getString(0x7f06006c)).append(" ").append(((ListingSummary) (obj)).getUserName()).toString());
            if (((ListingSummary) (obj)).isNWT())
            {
                ((ListingSummaryViewHolder) (view)).nwtViewLeft.setVisibility(0);
                ((ListingSummaryViewHolder) (view)).nwtViewLeft.setText(context.getResources().getString(0x7f0601d6));
            } else
            if (((ListingSummary) (obj)).isRetail())
            {
                ((ListingSummaryViewHolder) (view)).nwtViewLeft.setVisibility(0);
                ((ListingSummaryViewHolder) (view)).nwtViewLeft.setText(context.getResources().getString(0x7f06022c).toUpperCase());
            } else
            {
                ((ListingSummaryViewHolder) (view)).nwtViewLeft.setVisibility(8);
            }
            ((ListingSummaryViewHolder) (view)).titleViewLeft.setText(((ListingSummary) (obj)).getTitle());
            ((ListingSummaryViewHolder) (view)).priceViewLeft.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(((ListingSummary) (obj)).getPrice())).toString());
            ((ListingSummaryViewHolder) (view)).originalPriceViewLeft.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(((ListingSummary) (obj)).getOriginalPrice())).toString());
            ((ListingSummaryViewHolder) (view)).sizeViewLeft.setText((new StringBuilder()).append(context.getString(0x7f060281)).append(" ").append(((ListingSummary) (obj)).getSize()).toString());
        }
        cursor = (ListingSummary)cursor.getRightItem();
        obj = ((ListingSummaryViewHolder) (view)).rightLayout;
        if (cursor != null)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        if (cursor != null)
        {
            loadCovershot(cursor, ((ListingSummaryViewHolder) (view)).covershotRight, ((ListingSummaryViewHolder) (view)).statusViewRight);
            ((ListingSummaryViewHolder) (view)).creatorTextViewRight.setText((new StringBuilder()).append(context.getString(0x7f06006c)).append(" ").append(cursor.getUserName()).toString());
            if (cursor.isNWT())
            {
                ((ListingSummaryViewHolder) (view)).nwtViewRight.setVisibility(0);
                ((ListingSummaryViewHolder) (view)).nwtViewRight.setText(context.getResources().getString(0x7f0601d6));
            } else
            if (cursor.isRetail())
            {
                ((ListingSummaryViewHolder) (view)).nwtViewRight.setVisibility(0);
                ((ListingSummaryViewHolder) (view)).nwtViewRight.setText(context.getResources().getString(0x7f06022c).toUpperCase());
            } else
            {
                ((ListingSummaryViewHolder) (view)).nwtViewRight.setVisibility(8);
            }
            ((ListingSummaryViewHolder) (view)).titleViewRight.setText(cursor.getTitle());
            ((ListingSummaryViewHolder) (view)).priceViewRight.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(cursor.getPrice())).toString());
            ((ListingSummaryViewHolder) (view)).originalPriceViewRight.setText((new StringBuilder()).append(CurrencyUtils.getCurrencySymbol()).append(CurrencyUtils.getPriceAsWholeNumber(cursor.getOriginalPrice())).toString());
            ((ListingSummaryViewHolder) (view)).sizeViewRight.setText((new StringBuilder()).append(context.getString(0x7f060281)).append(" ").append(cursor.getSize()).toString());
        }
    }

    public void clearImageList()
    {
        for (Iterator iterator = imageList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((PMImageView)iterator.next()).releaseInternalBitmap();
        }

    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context);
        context = inflater.inflate(0x7f030079, viewgroup, false);
        cursor = new ListingSummaryViewHolder();
        cursor.leftLayout = (LinearLayout)context.findViewById(0x7f0c01d5);
        cursor.covershotLeft = (PMCovershotImageView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c01d7);
        cursor.statusViewLeft = (ListingStatusView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c0127);
        cursor.creatorTextViewLeft = (TextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c01d8);
        cursor.titleViewLeft = (TextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c00b7);
        cursor.nwtViewLeft = (PMTextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c007d);
        cursor.priceViewLeft = (TextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c007f);
        cursor.originalPriceViewLeft = (TextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c0080);
        ((ListingSummaryViewHolder) (cursor)).originalPriceViewLeft.setPaintFlags(((ListingSummaryViewHolder) (cursor)).originalPriceViewLeft.getPaintFlags() | 0x10);
        cursor.sizeViewLeft = (TextView)((ListingSummaryViewHolder) (cursor)).leftLayout.findViewById(0x7f0c0081);
        cursor.rightLayout = (LinearLayout)context.findViewById(0x7f0c01d6);
        cursor.covershotRight = (PMCovershotImageView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c01d7);
        cursor.statusViewRight = (ListingStatusView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c0127);
        cursor.creatorTextViewRight = (TextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c01d8);
        cursor.titleViewRight = (TextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c00b7);
        cursor.nwtViewRight = (PMTextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c007d);
        cursor.priceViewRight = (TextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c007f);
        cursor.originalPriceViewRight = (TextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c0080);
        ((ListingSummaryViewHolder) (cursor)).originalPriceViewRight.setPaintFlags(((ListingSummaryViewHolder) (cursor)).originalPriceViewRight.getPaintFlags() | 0x10);
        cursor.sizeViewRight = (TextView)((ListingSummaryViewHolder) (cursor)).rightLayout.findViewById(0x7f0c0081);
        imageList.add(((ListingSummaryViewHolder) (cursor)).covershotLeft);
        imageList.add(((ListingSummaryViewHolder) (cursor)).covershotRight);
        context.setTag(cursor);
        return context;
    }
}
