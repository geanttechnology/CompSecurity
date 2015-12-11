// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListing;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.ui.adapter.j.a;
import com.target.ui.adapter.j.b;
import com.target.ui.adapter.j.c;
import com.target.ui.view.BitmapImageView;
import java.util.ArrayList;
import java.util.List;

public class WeeklyAdListLayout extends ListView
{
    public static interface a
    {

        public abstract void a(WeeklyAdListingCollectionItem weeklyadlistingcollectionitem, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1);
    }

    public static interface b
    {

        public abstract void a(WeeklyAdListing weeklyadlisting, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1);
    }


    public static final String TAG = com/target/ui/view/weekly_ad/WeeklyAdListLayout.getSimpleName();
    private com.target.ui.adapter.j.a mAdapter;
    private a mCollectionItemClickedListener;
    private LinearLayout mHeaderView;
    private b mListingListener;
    private com.target.ui.adapter.j.b mWeeklyAdListingAdapter;
    private c mWeeklyAdListingCollectionItemAdapter;
    private List mWeeklyAdListingCollectionItems;
    private List mWeeklyAdListings;

    public WeeklyAdListLayout(Context context)
    {
        super(context);
        mWeeklyAdListings = new ArrayList();
        mWeeklyAdListingCollectionItems = new ArrayList();
        b();
    }

    public WeeklyAdListLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mWeeklyAdListings = new ArrayList();
        mWeeklyAdListingCollectionItems = new ArrayList();
        b();
    }

    public WeeklyAdListLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mWeeklyAdListings = new ArrayList();
        mWeeklyAdListingCollectionItems = new ArrayList();
        b();
    }

    static b a(WeeklyAdListLayout weeklyadlistlayout)
    {
        return weeklyadlistlayout.mListingListener;
    }

    private void a()
    {
        mHeaderView = new LinearLayout(getContext());
        mHeaderView.setOrientation(1);
        addHeaderView(mHeaderView);
    }

    static a b(WeeklyAdListLayout weeklyadlistlayout)
    {
        return weeklyadlistlayout.mCollectionItemClickedListener;
    }

    private void b()
    {
        a();
        c();
    }

    private void c()
    {
        mWeeklyAdListingAdapter = new com.target.ui.adapter.j.b(getContext(), mWeeklyAdListings);
        mWeeklyAdListingCollectionItemAdapter = new c(getContext(), mWeeklyAdListingCollectionItems);
        mAdapter = mWeeklyAdListingAdapter;
        setAdapter(mAdapter);
    }

    private void d()
    {
        mAdapter.notifyDataSetChanged();
    }

    public View a(int i)
    {
        View view = LayoutInflater.from(getContext()).inflate(i, getHeaderView(), false);
        mHeaderView.addView(view);
        return view;
    }

    public LinearLayout getHeaderView()
    {
        return mHeaderView;
    }

    public void setGuestInsideStore(boolean flag)
    {
        if (mAdapter.b() == flag)
        {
            return;
        } else
        {
            mAdapter.a(flag);
            d();
            return;
        }
    }

    public void setOnCollectionItemClickedListener(a a1)
    {
        mCollectionItemClickedListener = a1;
    }

    public void setOnListingClickedListener(b b1)
    {
        mListingListener = b1;
    }

    public void setWeeklyAdListingCollectionItemData(List list)
    {
        mWeeklyAdListingCollectionItems.clear();
        mWeeklyAdListingCollectionItems.addAll(list);
        mWeeklyAdListingCollectionItemAdapter.a(new com.target.ui.adapter.j.a.b() {

            final WeeklyAdListLayout this$0;

            public void a(WeeklyAdListingCollectionItem weeklyadlistingcollectionitem, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
            {
                if (com.target.ui.view.weekly_ad.WeeklyAdListLayout.b(WeeklyAdListLayout.this) != null)
                {
                    com.target.ui.view.weekly_ad.WeeklyAdListLayout.b(WeeklyAdListLayout.this).a(weeklyadlistingcollectionitem, bitmapimageview, a1);
                }
            }

            public volatile void a(Object obj, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
            {
                a((WeeklyAdListingCollectionItem)obj, bitmapimageview, a1);
            }

            
            {
                this$0 = WeeklyAdListLayout.this;
                super();
            }
        });
        if (!mAdapter.equals(mWeeklyAdListingCollectionItemAdapter))
        {
            mAdapter = mWeeklyAdListingCollectionItemAdapter;
            setAdapter(mAdapter);
        }
        d();
    }

    public void setWeeklyAdListingData(List list)
    {
        mWeeklyAdListings.clear();
        mWeeklyAdListings.addAll(list);
        mWeeklyAdListingAdapter.a(new com.target.ui.adapter.j.a.b() {

            final WeeklyAdListLayout this$0;

            public void a(WeeklyAdListing weeklyadlisting, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
            {
                if (com.target.ui.view.weekly_ad.WeeklyAdListLayout.a(WeeklyAdListLayout.this) != null)
                {
                    com.target.ui.view.weekly_ad.WeeklyAdListLayout.a(WeeklyAdListLayout.this).a(weeklyadlisting, bitmapimageview, a1);
                }
            }

            public volatile void a(Object obj, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
            {
                a((WeeklyAdListing)obj, bitmapimageview, a1);
            }

            
            {
                this$0 = WeeklyAdListLayout.this;
                super();
            }
        });
        if (!mAdapter.equals(mWeeklyAdListingAdapter))
        {
            mAdapter = mWeeklyAdListingAdapter;
            setAdapter(mAdapter);
        }
        d();
    }

}
