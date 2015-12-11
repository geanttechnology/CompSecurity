// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.data_model.models.inner_models.PartyRoomInfo;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.customviews.RoundedImageView;
import com.poshmark.utils.view_holders.TableSectionHeaderViewHolder;

public class PartyShowroomListAdapter extends CursorAdapter
    implements StickyListHeadersAdapter
{

    private Context context;
    PartyEvent event;
    private LayoutInflater inflater;

    public PartyShowroomListAdapter(Context context1, Fragment fragment, Cursor cursor, int i)
    {
        super(context1, cursor, i);
        context = context1;
    }

    public void bindView(View view, Context context1, Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = (PartyRoomInfo)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        Object obj = (LinearLayout)view;
        view = (RoundedImageView)((LinearLayout) (obj)).findViewById(0x7f0c023e);
        ImageView imageview = (ImageView)((LinearLayout) (obj)).findViewById(0x7f0c0240);
        PMTextView pmtextview = (PMTextView)((LinearLayout) (obj)).findViewById(0x7f0c0241);
        obj = (PMTextView)((LinearLayout) (obj)).findViewById(0x7f0c0242);
        pmtextview.setText((new StringBuilder()).append(cursor.getName()).append(" ").append(context1.getString(0x7f06026d)).toString());
        ((PMTextView) (obj)).setText(cursor.getDescription());
        if (cursor.isDefault())
        {
            view.setVisibility(0);
            imageview.setVisibility(8);
            if (event != null)
            {
                ImageLoader.getInstance().displayImage(event.getCovershot(), view);
            }
            return;
        } else
        {
            view.setVisibility(8);
            imageview.setVisibility(0);
            imageview.setImageDrawable(context1.getResources().getDrawable(cursor.getIconDrawable()));
            return;
        }
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
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(context.getString(0x7f060063));
        }
        return view;
    }

    public View newView(Context context1, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context1);
        return inflater.inflate(0x7f03009c, viewgroup, false);
    }

    public void setEvent(PartyEvent partyevent)
    {
        event = partyevent;
    }
}
