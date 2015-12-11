// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.ui.model.pi_blackfriday_deals.PiBlackFridayDeal;
import com.target.ui.view.map.BlackFridayDealView;
import java.util.List;

public class com.target.ui.adapter.map.a extends android.support.v7.widget.RecyclerView.a
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(PiBlackFridayDeal piblackfridaydeal);
    }

    static class b extends android.support.v7.widget.RecyclerView.t
    {

        public b(View view)
        {
            super(view);
        }
    }


    private static final int BLACK_FRIDAY_AD_ITEM_COUNT = 1;
    private static final int BLACK_FRIDAY_AD_POSITION = 0;
    private List mBlackFridayDealList;
    private a mListener;
    private WeeklyAdHomepage mWeeklyAdHomepage;

    public com.target.ui.adapter.map.a(a a1)
    {
        mListener = a1;
    }

    static a a(com.target.ui.adapter.map.a a1)
    {
        return a1.mListener;
    }

    private void a(BlackFridayDealView blackfridaydealview, WeeklyAdHomepage weeklyadhomepage)
    {
        if (weeklyadhomepage != null)
        {
            weeklyadhomepage = weeklyadhomepage.c();
        } else
        {
            weeklyadhomepage = null;
        }
        blackfridaydealview.setBlackFridayAdDetails(weeklyadhomepage);
    }

    public int a()
    {
        return mBlackFridayDealList.size() + 1;
    }

    public int a(int i)
    {
        return i != 0 ? 1 : 0;
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((b)t, i);
    }

    public void a(WeeklyAdHomepage weeklyadhomepage)
    {
        mWeeklyAdHomepage = weeklyadhomepage;
    }

    public void a(final b blackFridayDealForClickListener, int i)
    {
        if (mBlackFridayDealList == null)
        {
            return;
        }
        final int itemType = a(i);
        BlackFridayDealView blackfridaydealview = (BlackFridayDealView)blackFridayDealForClickListener.itemView;
        blackFridayDealForClickListener = null;
        if (itemType == 0)
        {
            a(blackfridaydealview, mWeeklyAdHomepage);
        } else
        {
            blackFridayDealForClickListener = (PiBlackFridayDeal)mBlackFridayDealList.get(i - 1);
            blackfridaydealview.setDealDetails(blackFridayDealForClickListener);
        }
        blackfridaydealview.setOnClickListener(new android.view.View.OnClickListener() {

            final com.target.ui.adapter.map.a this$0;
            final PiBlackFridayDeal val$blackFridayDealForClickListener;
            final int val$itemType;

            public void onClick(View view)
            {
                switch (itemType)
                {
                default:
                    return;

                case 0: // '\0'
                    com.target.ui.adapter.map.a.a(com.target.ui.adapter.map.a.this).a();
                    return;

                case 1: // '\001'
                    com.target.ui.adapter.map.a.a(com.target.ui.adapter.map.a.this).a(blackFridayDealForClickListener);
                    break;
                }
            }

            
            {
                this$0 = com.target.ui.adapter.map.a.this;
                itemType = i;
                blackFridayDealForClickListener = piblackfridaydeal;
                super();
            }
        });
    }

    public void a(List list)
    {
        mBlackFridayDealList = list;
    }

    public b c(ViewGroup viewgroup, int i)
    {
        return new b((BlackFridayDealView)LayoutInflater.from(viewgroup.getContext()).inflate(0x7f03016b, viewgroup, false));
    }
}
