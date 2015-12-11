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
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMData;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.view_holders.BundleViewHolder;
import java.util.List;

public class BundlesAdapter extends CursorAdapter
{

    PMFragment ownerFragment;

    public BundlesAdapter(Context context, PMFragment pmfragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
        ownerFragment = pmfragment;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        PMBundle pmbundle = (PMBundle)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        view = (BundleViewHolder)view.getTag();
        cursor = ImageLoader.getInstance();
        String s = pmbundle.getSellerAvataar();
        int i;
        if (s != null && s.length() > 0)
        {
            cursor.displayImage(pmbundle.getSellerAvataar(), ((BundleViewHolder) (view)).avataar);
        } else
        {
            ((BundleViewHolder) (view)).avataar.setImageDrawable(context.getResources().getDrawable(0x7f0200d4));
        }
        ((BundleViewHolder) (view)).userName.setText(pmbundle.getSellerUsername());
        context = pmbundle.getList();
        i = 0;
        if (context.size() > 0)
        {
            ListingSummary listingsummary = (ListingSummary)context.get(0);
            ((BundleViewHolder) (view)).image1.setVisibility(0);
            cursor.displayImage(listingsummary.getMediumCovershot(), ((BundleViewHolder) (view)).image1);
            i = 0 + 1;
        } else
        {
            ((BundleViewHolder) (view)).image1.setVisibility(4);
        }
        if (context.size() > i)
        {
            ListingSummary listingsummary1 = (ListingSummary)context.get(i);
            ((BundleViewHolder) (view)).image2.setVisibility(0);
            cursor.displayImage(listingsummary1.getMediumCovershot(), ((BundleViewHolder) (view)).image2);
            i++;
        } else
        {
            ((BundleViewHolder) (view)).image2.setVisibility(4);
        }
        if (context.size() > i)
        {
            context = (ListingSummary)context.get(i);
            ((BundleViewHolder) (view)).image3.setVisibility(0);
            cursor.displayImage(context.getMediumCovershot(), ((BundleViewHolder) (view)).image3);
            return;
        } else
        {
            ((BundleViewHolder) (view)).image3.setVisibility(4);
            return;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f03000d, viewgroup, false);
        cursor = new BundleViewHolder();
        cursor.avataar = (ImageView)context.findViewById(0x7f0c0057);
        cursor.userName = (PMTextView)context.findViewById(0x7f0c0058);
        cursor.image1 = (PMListingImageView)context.findViewById(0x7f0c0059);
        cursor.image2 = (PMListingImageView)context.findViewById(0x7f0c005a);
        cursor.image3 = (PMListingImageView)context.findViewById(0x7f0c005b);
        ((BundleViewHolder) (cursor)).image1.setFocusable(false);
        ((BundleViewHolder) (cursor)).image1.setClickable(false);
        ((BundleViewHolder) (cursor)).image2.setFocusable(false);
        ((BundleViewHolder) (cursor)).image2.setClickable(false);
        ((BundleViewHolder) (cursor)).image3.setFocusable(false);
        ((BundleViewHolder) (cursor)).image3.setClickable(false);
        context.setTag(cursor);
        return context;
    }
}
