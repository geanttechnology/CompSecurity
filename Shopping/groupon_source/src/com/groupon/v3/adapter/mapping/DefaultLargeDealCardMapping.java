// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.models.Place;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.util.GeoPoint;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.v3.view.param.DealInfo;
import com.groupon.view.dealcards.DealCardBase;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import com.groupon.view.dealcards.DefaultSmallDealCard;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping

public class DefaultLargeDealCardMapping extends Mapping
{

    protected AppStartupImageLoadListener appStartupImageLoadListener;
    protected GeoPoint currentPlace;
    protected boolean isShowBadge;
    protected boolean useSmallDealCard;

    public DefaultLargeDealCardMapping()
    {
        super(com/groupon/db/models/DealSummary);
        currentPlace = null;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (DealSummary)universallistadapter.getItem(i);
        DealCallbacks dealcallbacks = (DealCallbacks)getCallback(com/groupon/v3/view/callbacks/DealCallbacks);
        if (dealcallbacks != null)
        {
            dealcallbacks.onDealBound(new DealInfo(universallistadapter));
        }
        if (appStartupImageLoadListener != null)
        {
            appStartupImageLoadListener.assignToViews((DealCardBase)viewholder.itemView);
        }
        universallistadapter.putAttr("is_show_badge_ab_test_on", Boolean.valueOf(isShowBadge));
        ((DealCardBase)(DealCardBase)viewholder.itemView).setInfoWithPlace(universallistadapter, currentPlace);
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
    }

    public View createView(Context context)
    {
        if (useSmallDealCard)
        {
            return new DefaultSmallDealCard(context);
        } else
        {
            return new DefaultLargeDealCard(context);
        }
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(universallistadapter) {

            final DefaultLargeDealCardMapping this$0;
            final UniversalListAdapter val$universalListAdapter;

            public void onClick(View view)
            {
                DealCallbacks dealcallbacks = (DealCallbacks)getCallback(com/groupon/v3/view/callbacks/DealCallbacks);
                if (dealcallbacks != null)
                {
                    dealcallbacks.onDealClick(view, new DealInfo((DealSummary)universalListAdapter.getItem(getPosition())));
                }
            }

            
            {
                this$0 = DefaultLargeDealCardMapping.this;
                universalListAdapter = universallistadapter;
                super(final_view);
            }
        };
    }

    public boolean isShowBadge()
    {
        return isShowBadge;
    }

    public DefaultLargeDealCardMapping setCurrentLocation(Place place)
    {
        if (place != null)
        {
            currentPlace = new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D));
        }
        return this;
    }

    public void setImageStartUpListener(AppStartupImageLoadListener appstartupimageloadlistener)
    {
        appStartupImageLoadListener = appstartupimageloadlistener;
    }

    public void setIsShowBadge(boolean flag)
    {
        isShowBadge = flag;
    }

    public void setUseSmallDealCard(boolean flag)
    {
        useSmallDealCard = flag;
    }
}
