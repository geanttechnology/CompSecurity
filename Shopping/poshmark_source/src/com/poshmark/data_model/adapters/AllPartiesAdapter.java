// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersAdapter;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.PartyEvent;
import com.poshmark.utils.view_holders.PartyOverviewHolder;
import com.poshmark.utils.view_holders.TableSectionHeaderViewHolder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AllPartiesAdapter extends CursorAdapter
    implements StickyListHeadersAdapter
{

    Set imageList;
    private LayoutInflater inflater;

    public AllPartiesAdapter(Context context, Cursor cursor, int i)
    {
        super(context, cursor, i);
        imageList = new HashSet();
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        PartyOverviewHolder partyoverviewholder;
        cursor = (CustomMatrixCursor)cursor;
        cursor = (PartyEvent)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        partyoverviewholder = (PartyOverviewHolder)view.getTag();
        if (cursor == null) goto _L2; else goto _L1
_L1:
        ImageView imageview = partyoverviewholder.partyCovershotView;
        imageview.setImageBitmap(null);
        ImageLoader.getInstance().displayImage(cursor.getCovershot(), imageview);
        imageList.add(imageview);
        view.setBackgroundDrawable(context.getResources().getDrawable(0x7f020022));
        partyoverviewholder.partyTitleView.setTextColor(context.getResources().getColor(0x7f09003c));
        partyoverviewholder.partyDetailsView.setTextColor(context.getResources().getColor(0x7f090038));
        partyoverviewholder.partyHostsView.setTextColor(context.getResources().getColor(0x7f090038));
        partyoverviewholder.partyTitleView.setText(cursor.getTitle().toUpperCase());
        if (!cursor.isHappeningNow()) goto _L4; else goto _L3
_L3:
        int i = cursor.getListingCount();
        partyoverviewholder.partyDetailsView.setText("Ends in ...");
        view.setBackgroundColor(context.getResources().getColor(0x7f090003));
        partyoverviewholder.partyTitleView.setTextColor(context.getResources().getColor(0x7f090040));
        partyoverviewholder.partyDetailsView.setTextColor(context.getResources().getColor(0x7f090040));
        partyoverviewholder.partyHostsView.setTextColor(context.getResources().getColor(0x7f090040));
        partyoverviewholder.partyDetailsView.setText((new StringBuilder()).append(Integer.toString(i)).append(" ").append(context.getString(0x7f06018f)).toString());
        partyoverviewholder.partyDetailsView.setText((new StringBuilder()).append(context.getString(0x7f0600ce)).append(" ").append(cursor.getFormattedPendingTime()).toString());
        partyoverviewholder.partyHostsView.setText(context.getString(0x7f06015b));
_L6:
        if (!cursor.isHappeningNow())
        {
            if (cursor.getHosts().size() <= 1)
            {
                break; /* Loop/switch isn't completed */
            }
            partyoverviewholder.partyHostsView.setText((new StringBuilder()).append(context.getString(0x7f060143)).append(" ").append(cursor.getCommaSeparatedHostNames()).toString());
        }
_L2:
        return;
_L4:
        if (cursor.isPastEvent())
        {
            int j = cursor.getListingCount();
            if (j == 0)
            {
                partyoverviewholder.partyDetailsView.setText(context.getString(0x7f0601d2));
            } else
            if (j == 1)
            {
                partyoverviewholder.partyDetailsView.setText((new StringBuilder()).append(Integer.toString(j)).append(" ").append(context.getString(0x7f060167)).toString());
            } else
            {
                partyoverviewholder.partyDetailsView.setText((new StringBuilder()).append(Integer.toString(j)).append(" ").append(context.getString(0x7f06018f)).toString());
            }
        } else
        if (cursor.isFutureEvent())
        {
            partyoverviewholder.partyDetailsView.setText(cursor.getStartDateTimeString(context));
        }
        if (true) goto _L6; else goto _L5
_L5:
        partyoverviewholder.partyHostsView.setText((new StringBuilder()).append(context.getString(0x7f060141)).append(" ").append(cursor.getCommaSeparatedHostNames()).toString());
        return;
    }

    public void clearImageList()
    {
        for (Iterator iterator = imageList.iterator(); iterator.hasNext(); iterator.remove())
        {
            ImageView imageview = (ImageView)iterator.next();
            Object obj = (BitmapDrawable)imageview.getDrawable();
            if (obj == null)
            {
                continue;
            }
            obj = ((BitmapDrawable) (obj)).getBitmap();
            if (obj != null)
            {
                ((Bitmap) (obj)).recycle();
                imageview.setImageDrawable(null);
                imageview.setImageBitmap(null);
            }
        }

    }

    public long getHeaderId(int i)
    {
        int j;
        int k;
        GlobalPartiesController globalpartiescontroller = GlobalPartiesController.getGlobalPartiesController();
        j = globalpartiescontroller.getCurrentPartiesCount();
        k = globalpartiescontroller.getUpcomingPartiesCount();
        globalpartiescontroller.getPastPartiesCount();
        if (j <= 0) goto _L2; else goto _L1
_L1:
        if (i >= j) goto _L4; else goto _L3
_L3:
        return 0L;
_L4:
        if (i < j + k)
        {
            return (long)j;
        } else
        {
            return (long)(j + k);
        }
_L2:
        if (i >= k)
        {
            return (long)k;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        GlobalPartiesController globalpartiescontroller;
        int j;
        int k;
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
        globalpartiescontroller = GlobalPartiesController.getGlobalPartiesController();
        j = globalpartiescontroller.getCurrentPartiesCount();
        k = globalpartiescontroller.getUpcomingPartiesCount();
        if (j > 0)
        {
            if (i < j)
            {
                ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(0x7f06020f);
                return view;
            }
            if (i < j + k)
            {
                ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(0x7f060210);
                return view;
            } else
            {
                ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(0x7f060211);
                return view;
            }
        }
        if (i < k)
        {
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(0x7f060210);
            return view;
        } else
        {
            ((TableSectionHeaderViewHolder) (viewgroup)).titleView.setText(0x7f060211);
            return view;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context);
        context = new PartyOverviewHolder();
        cursor = (LinearLayout)inflater.inflate(0x7f030098, viewgroup, false);
        context.partyCovershotView = (ImageView)cursor.findViewById(0x7f0c0254);
        context.partyTitleView = (TextView)cursor.findViewById(0x7f0c0255);
        context.partyDetailsView = (TextView)cursor.findViewById(0x7f0c0256);
        context.partyHostsView = (TextView)cursor.findViewById(0x7f0c0257);
        cursor.setTag(context);
        return cursor;
    }
}
