// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.ui.fragments.ListingDetailsFragment;
import com.poshmark.utils.DateUtils;
import com.poshmark.utils.ViewUtils;

public class ListingDetailsAdapter extends CursorAdapter
{

    private LayoutInflater inflater;
    private ListView listView;
    ListingDetailsFragment parentFragment;

    public ListingDetailsAdapter(Context context, ListingDetailsFragment listingdetailsfragment, Cursor cursor, int i)
    {
        super(context, cursor, i);
        parentFragment = listingdetailsfragment;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        context = (CustomMatrixCursor)cursor;
        int i = context.getColumnIndex(PMData.DATA_COL);
        int j = context.getPosition();
        cursor = (Comment)context.get(i);
        Object obj = (RoundedImageView)view.findViewById(0x7f0c016f);
        ((RoundedImageView) (obj)).setUser(cursor.getCommenterName());
        ImageLoader imageloader = ImageLoader.getInstance();
        if (cursor.getCommenterPicture() != null)
        {
            imageloader.loadImage(cursor.getCommenterPicture(), ((RoundedImageView) (obj)).listener);
        } else
        {
            ((RoundedImageView) (obj)).setBitmap(0x7f0200d4);
        }
        obj = (PMTextView)view.findViewById(0x7f0c0171);
        ((PMTextView) (obj)).setParentLayout(listView);
        ((PMTextView) (obj)).setComment((new StringBuilder()).append(cursor.getCommenterDisplayHandle()).append(" ").append(cursor.getComment().toString()).toString());
        obj = (PMTextView)view.findViewById(0x7f0c0172);
        ((PMTextView) (obj)).setVisibility(0);
        ((PMTextView) (obj)).setText(DateUtils.formatDateForDisplay(cursor.getCreatedAt(), ""));
        obj = (LinearLayout)view.findViewById(0x7f0c0174);
        ((LinearLayout) (obj)).setVisibility(0);
        ((LinearLayout) (obj)).setTag(cursor.getCommenterDisplayHandle());
        ((LinearLayout) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsAdapter this$0;

            public void onClick(View view1)
            {
                parentFragment.replyToComment((String)view1.getTag());
            }

            
            {
                this$0 = ListingDetailsAdapter.this;
                super();
            }
        });
        cursor = view.findViewById(0x7f0c012a);
        if (context.getPosition() < context.getCount() - 1)
        {
            cursor.setVisibility(0);
        } else
        {
            cursor.setVisibility(4);
        }
        view.setTag(Integer.valueOf(j));
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context);
        ((CustomMatrixCursor)cursor).getColumnIndex(PMData.DATA_COL);
        cursor = inflater.inflate(0x7f03005f, viewgroup, false);
        cursor.setPadding(cursor.getPaddingLeft(), (int)ViewUtils.dipToPixels(context, 10F), cursor.getPaddingRight(), cursor.getPaddingBottom());
        cursor.findViewById(0x7f0c012a).setVisibility(0);
        return cursor;
    }

    public void setParentListView(ListView listview)
    {
        listView = listview;
    }
}
