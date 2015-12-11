// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.TrackPackageExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.view.MyGrouponItem;
import commonlib.adapter.JavaListAdapter;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class MyGrouponsJavaAdapter extends JavaListAdapter
{
    private static class GtgCardViewHolder
    {

        public TextView cardSubtitle;
        public TextView cartTitle;

        private GtgCardViewHolder()
        {
        }

    }


    protected static final String TRACK_PACKAGE_IMPRESSION = "track_package_impression";
    private final int GROUPON_BASIC_CARD_VIEW_TYPE = 0;
    private final int GTG_CARD_VIEW_TYPE = 1;
    private Context context;
    protected Logger logger;
    private android.view.View.OnClickListener trackPackageClickListener;

    public MyGrouponsJavaAdapter(Context context1, android.view.View.OnClickListener onclicklistener)
    {
        context = context1;
        trackPackageClickListener = onclicklistener;
        RoboGuice.getInjector(context1).injectMembers(this);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return !Strings.equals(((MyGrouponItemSummary)getItem(i)).remoteId, "gtg_mock_my_groupon_item_summary_remote_id") ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        MyGrouponItemSummary mygrouponitemsummary = (MyGrouponItemSummary)getItem(i);
        int j = context.getResources().getDimensionPixelSize(0x7f0b017b);
        boolean flag;
        if (i == getCount() - 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (getItemViewType(i) == 1)
        {
            if (view == null)
            {
                view = LayoutInflater.from(context).inflate(0x7f03012f, viewgroup, false);
                viewgroup = new GtgCardViewHolder();
                viewgroup.cartTitle = (TextView)view.findViewById(0x7f10007a);
                viewgroup.cardSubtitle = (TextView)view.findViewById(0x7f10011a);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (GtgCardViewHolder)view.getTag();
            }
            if (flag)
            {
                i = j;
            } else
            {
                i = 0;
            }
            view.setPadding(j, j, j, i);
            ((GtgCardViewHolder) (viewgroup)).cartTitle.setText(mygrouponitemsummary.title);
            ((GtgCardViewHolder) (viewgroup)).cardSubtitle.setText(mygrouponitemsummary.subTitle);
            logger.logImpression("", "mygroupons_myfood", "mygroupon_available_tab", "header", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            return view;
        }
        viewgroup = view;
        if (view == null)
        {
            viewgroup = new MyGrouponItem(context);
        }
        ((MyGrouponItem)viewgroup).setGroupon(mygrouponitemsummary);
        view = (TextView)viewgroup.findViewById(0x7f100444);
        if (view.getVisibility() == 0)
        {
            view.setOnClickListener(trackPackageClickListener);
            view.setTag(mygrouponitemsummary);
            logger.logImpression("", "track_package_impression", Channel.GOODS.toString(), "", new TrackPackageExtraInfo(mygrouponitemsummary.orderId, Integer.toString(i + 1)));
        }
        ((MyGrouponItem)viewgroup).setGrouponItemMargins(j, flag);
        logger.logImpression("", "mygroupons_card", mygrouponitemsummary.remoteId, "groupon_list_page", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        return viewgroup;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isEnabled(int i)
    {
        return ((MyGrouponItemSummary)getItem(i)).isSelectable;
    }
}
