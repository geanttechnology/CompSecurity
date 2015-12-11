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
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMData;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMClickableImageView;
import com.poshmark.ui.customviews.PMCovershotImageView;
import com.poshmark.ui.customviews.PMPriceLayout;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.utils.BundleItemRemoveClickListener;

public class BundleListAdapter extends CursorAdapter
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE VIEW_BUNDLE;
        public static final MODE VIEW_UNAVAILABLE_ITEMS;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/data_model/adapters/BundleListAdapter$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            VIEW_BUNDLE = new MODE("VIEW_BUNDLE", 0);
            VIEW_UNAVAILABLE_ITEMS = new MODE("VIEW_UNAVAILABLE_ITEMS", 1);
            $VALUES = (new MODE[] {
                VIEW_BUNDLE, VIEW_UNAVAILABLE_ITEMS
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    public PMClickableImageView covershot;
    public MODE mode;
    PMFragment ownerFragment;
    public PMPriceLayout priceLayout;
    public BundleItemRemoveClickListener removeItemListener;
    public PMTextView title;

    public BundleListAdapter(Context context, PMFragment pmfragment, BundleItemRemoveClickListener bundleitemremoveclicklistener, MODE mode1, Cursor cursor, int i)
    {
        super(context, cursor, i);
        ownerFragment = pmfragment;
        removeItemListener = bundleitemremoveclicklistener;
        mode = mode1;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        ListingSummary listingsummary = (ListingSummary)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        Object obj = (PMCovershotImageView)view.findViewById(0x7f0c007c);
        ((PMCovershotImageView) (obj)).setListingId(listingsummary.getIdAsString());
        ImageLoader.getInstance().displayImage(listingsummary.getSmallCovershot(), ((android.widget.ImageView) (obj)));
        ((PMTextView)view.findViewById(0x7f0c007e)).setText(listingsummary.getTitle());
        ((PMTextView)view.findViewById(0x7f0c007f)).setText(listingsummary.getPriceStringAsWholeNumber());
        ((PMTextView)view.findViewById(0x7f0c0080)).setText(listingsummary.getOriginalPriceString());
        ((PMTextView)view.findViewById(0x7f0c0081)).setText((new StringBuilder()).append(context.getText(0x7f060281)).append(" ").append(listingsummary.getSize()).toString());
        obj = (PMTextView)view.findViewById(0x7f0c007d);
        if (listingsummary.isNWT())
        {
            ((PMTextView) (obj)).setVisibility(0);
            ((PMTextView) (obj)).setText(context.getResources().getString(0x7f0601d6));
        } else
        if (listingsummary.isRetail())
        {
            ((PMTextView) (obj)).setVisibility(0);
            ((PMTextView) (obj)).setText(context.getResources().getString(0x7f06022c).toUpperCase());
        } else
        {
            ((PMTextView) (obj)).setVisibility(8);
        }
        context = (PMButton)view.findViewById(0x7f0c0083);
        context.setTag(Integer.valueOf(cursor.getPosition()));
        context.setOnClickListener(new android.view.View.OnClickListener() {

            final BundleListAdapter this$0;

            public void onClick(View view1)
            {
                view1 = (Integer)view1.getTag();
                if (removeItemListener != null)
                {
                    removeItemListener.removeItemFromBundle(view1.intValue());
                }
            }

            
            {
                this$0 = BundleListAdapter.this;
                super();
            }
        });
        view = view.findViewById(0x7f0c0082);
        if (mode == MODE.VIEW_UNAVAILABLE_ITEMS)
        {
            view.setVisibility(0);
            context.setAlpha(1.0F);
            return;
        } else
        {
            view.setVisibility(8);
            context.setAlpha(0.3F);
            return;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f030017, viewgroup, false);
        cursor = (TextView)context.findViewById(0x7f0c0080);
        cursor.setPaintFlags(cursor.getPaintFlags() | 0x10);
        return context;
    }
}
