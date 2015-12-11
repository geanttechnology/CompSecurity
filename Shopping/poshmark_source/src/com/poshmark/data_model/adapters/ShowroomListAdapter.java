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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.view_holders.TableSectionHeaderViewHolder;

public class ShowroomListAdapter extends CursorAdapter
    implements StickyListHeadersAdapter
{

    private Context context;
    private LayoutInflater inflater;
    Showroom showroom;

    public ShowroomListAdapter(Context context1, Cursor cursor, int i)
    {
        super(context1, cursor, i);
        context = context1;
    }

    public void bindView(View view, Context context1, Cursor cursor)
    {
        context1 = (CustomMatrixCursor)cursor;
        context1 = (Showroom)context1.get(context1.getColumnIndex(PMData.DATA_COL));
        view = (LinearLayout)view;
        cursor = (ImageView)view.findViewById(0x7f0c02d3);
        ((PMTextView)view.findViewById(0x7f0c0241)).setText(context1.getName());
        ImageLoader.getInstance().displayImage(context1.getCoverShot().url_small, cursor);
    }

    public long getHeaderId(int i)
    {
        return 0L;
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            TableSectionHeaderViewHolder tablesectionheaderviewholder = new TableSectionHeaderViewHolder();
            view = inflater.inflate(0x7f0300c4, viewgroup, false);
            tablesectionheaderviewholder.titleView = (TextView)view.findViewById(0x7f0c0130);
            view.setTag(tablesectionheaderviewholder);
            viewgroup = tablesectionheaderviewholder;
        } else
        {
            viewgroup = (TableSectionHeaderViewHolder)view.getTag();
        }
        if (i == 0)
        {
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(context.getString(0x7f060269));
        }
        return view;
    }

    public View newView(Context context1, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context1);
        return inflater.inflate(0x7f0300bb, viewgroup, false);
    }

    public void setShowroom(Showroom showroom1)
    {
        showroom = showroom1;
    }
}
