// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPage;
import com.target.mothership.util.o;
import com.target.mothership.util.p;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.view.ExpandableImageViewPager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WeeklyAdHeaderView extends LinearLayout
    implements com.target.ui.view.ExpandableImageViewPager.a
{
    public static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState a(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public SavedState[] a(int i)
            {
                return new SavedState[i];
            }

            public Object createFromParcel(Parcel parcel)
            {
                return a(parcel);
            }

            public Object[] newArray(int i)
            {
                return a(i);
            }

        };
        Parcelable pagerSavedState;
        int weeklyAdPagerHeight;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(weeklyAdPagerHeight);
            parcel.writeParcelable(pagerSavedState, i);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            weeklyAdPagerHeight = parcel.readInt();
            pagerSavedState = parcel.readParcelable(getClass().getClassLoader());
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    static class Views extends com.target.ui.view.a
    {

        TextView dates;
        ExpandableImageViewPager pager;
        ImageView placeholderImage;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(int i);

        public abstract void a(int i, int j);
    }


    private static final int COLLAPSED_VIEWS_PER_PAGE = 2;
    private static final float COLLAPSED_VIEW_WIDTH_FRACTION = 0.5F;
    private static final String DATE_RANGE_FORMAT = "%s - %s";
    private static final int MINIMUM_IMAGE_PAGE_IMAGE_HEIGHT = 600;
    private static final float SCREEN_HEIGHT_MULTIPLIER = 0.5F;
    private static final String SINGLE_DATE_FORMAT = "MMM d";
    private a mListener;
    private int mPageImageHeight;
    private List mPageImageUrls;
    private List mPages;
    private String mPlaceholderImageUrl;
    private boolean mRestoredFromSavedState;
    private Views mViews;
    private int mWeeklyAdPagerHeight;

    public WeeklyAdHeaderView(Context context)
    {
        super(context);
        mRestoredFromSavedState = false;
        mWeeklyAdPagerHeight = 0;
        e();
    }

    public WeeklyAdHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRestoredFromSavedState = false;
        mWeeklyAdPagerHeight = 0;
        e();
    }

    public WeeklyAdHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRestoredFromSavedState = false;
        mWeeklyAdPagerHeight = 0;
        e();
    }

    private void a(SavedState savedstate)
    {
        mViews.pager.onRestoreInstanceState(savedstate.pagerSavedState);
        mWeeklyAdPagerHeight = savedstate.weeklyAdPagerHeight;
        mRestoredFromSavedState = true;
    }

    private void b(SavedState savedstate)
    {
        savedstate.weeklyAdPagerHeight = mWeeklyAdPagerHeight;
        savedstate.pagerSavedState = mViews.pager.onSaveInstanceState();
    }

    private void e()
    {
        setBackgroundColor(getResources().getColor(0x7f0f00ef));
        setOrientation(1);
        inflate(getContext(), 0x7f03020a, this);
        mViews = new Views(this);
        mPageImageHeight = Math.max(600, Math.round(0.5F * (float)getContext().getResources().getDisplayMetrics().heightPixels));
        f();
    }

    private void f()
    {
        mViews.pager.setListener(this);
        if (mRestoredFromSavedState)
        {
            return;
        } else
        {
            d();
            return;
        }
    }

    public void a()
    {
        al.a(mViews.dates, true);
        aj.h(mViews.dates);
    }

    public void a(int i)
    {
        if (mListener != null)
        {
            mListener.a(i);
        }
    }

    public void a(int i, int j)
    {
        if (mListener != null)
        {
            mListener.a(i, j);
        }
    }

    public void a(Bitmap bitmap, String s, String s1)
    {
        mViews.placeholderImage.setImageBitmap(bitmap);
        mViews.placeholderImage.setTransitionName(s1);
        mPlaceholderImageUrl = s;
        mViews.pager.setHeroImagePlaceholderDrawable(new BitmapDrawable(getResources(), bitmap));
    }

    public void a(Date date, Date date1)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM d", Locale.US);
        mViews.dates.setText(String.format("%s - %s", new Object[] {
            simpledateformat.format(date), simpledateformat.format(date1)
        }));
    }

    public void a(boolean flag)
    {
        ExpandableImageViewPager expandableimageviewpager = mViews.pager;
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        al.a(expandableimageviewpager, byte0);
        al.a(mViews.placeholderImage, flag);
    }

    public void b()
    {
        mViews.pager.r();
    }

    public void b(int i)
    {
        int i1 = 0;
        if (mWeeklyAdPagerHeight == 0)
        {
            int j1 = mViews.dates.getHeight();
            Object obj = (android.widget.LinearLayout.LayoutParams)mViews.dates.getLayoutParams();
            int j;
            int k;
            int l;
            if (obj != null)
            {
                k = ((android.widget.LinearLayout.LayoutParams) (obj)).topMargin;
                j = ((android.widget.LinearLayout.LayoutParams) (obj)).bottomMargin;
            } else
            {
                j = 0;
                k = 0;
            }
            obj = (android.widget.FrameLayout.LayoutParams)mViews.pager.getLayoutParams();
            if (obj != null)
            {
                l = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
                i1 = ((android.widget.FrameLayout.LayoutParams) (obj)).bottomMargin;
            } else
            {
                l = 0;
            }
            mWeeklyAdPagerHeight = i - (l + (j + (k + j1)) + i1);
            mViews.pager.setPagerHeightMin(mWeeklyAdPagerHeight / 2);
            mViews.pager.setPagingHeightMax(mWeeklyAdPagerHeight);
            mViews.pager.t();
            if (o.g(mPlaceholderImageUrl))
            {
                String s = p.a(mPlaceholderImageUrl, mWeeklyAdPagerHeight);
                u.a(getContext()).a(s).a(com.h.c.u.e.c).c();
                return;
            }
        }
    }

    public void c()
    {
        al.a(mViews.dates, 4);
    }

    public void d()
    {
        if (mWeeklyAdPagerHeight == 0)
        {
            mViews.pager.setPagerHeightMin(getResources().getDimensionPixelSize(0x7f0a02d2));
            mViews.pager.setPagingHeightMax(getResources().getDimensionPixelSize(0x7f0a02d3));
        }
        mViews.pager.setBaseContentDescription(getResources().getString(0x7f09016f));
        mViews.pager.setCollapsed(false);
        mViews.pager.setCollapsedViewWidth(0.5F);
        mViews.pager.setCollapsedNumberOfItemsPerPage(2);
        mViews.pager.setEndPagesCentered(true);
        mViews.pager.t();
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        super.dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        super.dispatchFreezeSelfOnly(sparsearray);
    }

    public int getFirstSelectedItem()
    {
        return mViews.pager.getFirstSelectedItem();
    }

    public int getFullWeeklyAdHeight()
    {
        return mWeeklyAdPagerHeight;
    }

    public int getNumberOfSelectedItems()
    {
        return mViews.pager.d(getFirstSelectedItem());
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        a(parcelable);
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        b(savedstate);
        return savedstate;
    }

    public void setOnImageEventListener(a a1)
    {
        mListener = a1;
    }

    public void setPages(List list)
    {
        mPages = list;
        mPageImageUrls = new ArrayList();
        WeeklyAdPage weeklyadpage;
        for (list = mPages.iterator(); list.hasNext(); mPageImageUrls.add(weeklyadpage.a(mPageImageHeight)))
        {
            weeklyadpage = (WeeklyAdPage)list.next();
        }

        mViews.pager.setImageUrls(mPageImageUrls);
        mViews.pager.t();
        mViews.pager.s();
    }
}
