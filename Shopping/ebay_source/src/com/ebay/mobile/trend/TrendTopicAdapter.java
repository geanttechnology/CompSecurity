// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.trend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.nautilus.domain.data.Trend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.trend:
//            TrendTopicViewHolder, TopicViewModel

public class TrendTopicAdapter extends RecyclerContentAdapter
{

    public static final int VIEW_TYPE_TREND_LISTINGS = 3;
    public static final int VIEW_TYPE_TREND_TOPIC = 2;
    protected static boolean isTablet;
    private Context context;
    public final ChannelCardDecoration itemDecorator = new ChannelCardDecoration();
    private List positionToGridSpanSize;
    private Resources resources;

    public TrendTopicAdapter(Context context1)
    {
        RecyclerContentAdapter(context1);
        context = context1;
        resources = context1.getResources();
        isTablet = resources.getBoolean(0x7f0b0006);
        addViewType(2, com/ebay/mobile/trend/TrendTopicViewHolder, 0x7f03005d);
        positionToGridSpanSize = new ArrayList();
    }

    public void setTrendItems(List list)
    {
        dataSet.clear();
        positionToGridSpanSize.clear();
        if (list == null)
        {
            return;
        }
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            TopicViewModel topicviewmodel = new TopicViewModel(2, (Trend)list.next(), getOnClickListener(3), getOnClickListener(2), context);
            if (TrendTopicViewHolder.isValidModel(topicviewmodel, isTablet))
            {
                dataSet.add(topicviewmodel);
                positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
            }
        } while (true);
        notifyDataSetChanged();
    }


}
