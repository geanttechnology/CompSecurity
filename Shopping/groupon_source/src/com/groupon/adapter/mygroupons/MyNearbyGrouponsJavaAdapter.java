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

public class MyNearbyGrouponsJavaAdapter extends JavaListAdapter
{
    private static final class ViewTypes extends Enum
    {

        private static final ViewTypes $VALUES[];
        public static final ViewTypes GROUPON_CARD_VIEW_TYPE;
        public static final ViewTypes LIST_HEADER_VIEW_TYPE;
        public static final ViewTypes SECTION_HEADER_VIEW_TYPE;

        public static ViewTypes valueOf(String s)
        {
            return (ViewTypes)Enum.valueOf(com/groupon/adapter/mygroupons/MyNearbyGrouponsJavaAdapter$ViewTypes, s);
        }

        public static ViewTypes[] values()
        {
            return (ViewTypes[])$VALUES.clone();
        }

        static 
        {
            GROUPON_CARD_VIEW_TYPE = new ViewTypes("GROUPON_CARD_VIEW_TYPE", 0);
            SECTION_HEADER_VIEW_TYPE = new ViewTypes("SECTION_HEADER_VIEW_TYPE", 1);
            LIST_HEADER_VIEW_TYPE = new ViewTypes("LIST_HEADER_VIEW_TYPE", 2);
            $VALUES = (new ViewTypes[] {
                GROUPON_CARD_VIEW_TYPE, SECTION_HEADER_VIEW_TYPE, LIST_HEADER_VIEW_TYPE
            });
        }

        private ViewTypes(String s, int i)
        {
            super(s, i);
        }
    }


    private final int VIEW_TYPE_COUNT = 3;
    private Context context;
    protected Logger logger;
    private android.view.View.OnClickListener trackPackageClickListener;

    public MyNearbyGrouponsJavaAdapter(Context context1, android.view.View.OnClickListener onclicklistener)
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
        Object obj = getItem(i);
        if (Strings.equalsIgnoreCase(obj, context.getString(0x7f080276)))
        {
            return ViewTypes.LIST_HEADER_VIEW_TYPE.ordinal();
        }
        if (obj instanceof MyGrouponItemSummary)
        {
            return ViewTypes.GROUPON_CARD_VIEW_TYPE.ordinal();
        } else
        {
            return ViewTypes.SECTION_HEADER_VIEW_TYPE.ordinal();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getItemViewType(i);
        LayoutInflater layoutinflater = LayoutInflater.from(context);
        if (j == ViewTypes.GROUPON_CARD_VIEW_TYPE.ordinal())
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = new MyGrouponItem(context);
            }
            view = (MyGrouponItemSummary)getItem(i);
            j = context.getResources().getDimensionPixelSize(0x7f0b017b);
            TextView textview;
            boolean flag;
            if (i == getCount() - 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((MyGrouponItem)viewgroup).setGroupon(view);
            textview = (TextView)viewgroup.findViewById(0x7f100444);
            if (textview.getVisibility() == 0)
            {
                textview.setOnClickListener(trackPackageClickListener);
                textview.setTag(view);
                logger.logImpression("", "track_package_impression", Channel.GOODS.toString(), "", new TrackPackageExtraInfo(((MyGrouponItemSummary) (view)).orderId, Integer.toString(i + 1)));
            }
            ((MyGrouponItem)viewgroup).setGrouponItemMargins(j, flag);
            logger.logImpression("", "mygroupons_card", ((MyGrouponItemSummary) (view)).remoteId, "groupon_list_page", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            return viewgroup;
        }
        View view1 = view;
        if (view == null)
        {
            if (j == ViewTypes.LIST_HEADER_VIEW_TYPE.ordinal())
            {
                j = 0x7f030181;
            } else
            {
                j = 0x7f030180;
            }
            view1 = layoutinflater.inflate(j, viewgroup, false);
        }
        ((TextView)view1).setText((String)getItem(i));
        return view1;
    }

    public int getViewTypeCount()
    {
        return 3;
    }

    public boolean isEnabled(int i)
    {
        Object obj = getItem(i);
        return (obj instanceof MyGrouponItemSummary) && ((MyGrouponItemSummary)obj).isSelectable;
    }
}
