// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.WeeklyAdInfo;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import com.target.mothership.util.p;
import com.target.ui.adapter.h.d;
import com.target.ui.model.shop.a;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.shop:
//            BasePageItemView, WeeklyAdCardView

public class WeeklyAdView extends BasePageItemView
    implements com.target.ui.adapter.h.d.a
{
    static class Views extends com.target.ui.view.a
    {

        RecyclerView recyclerView;
        TextView text;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends android.support.v7.widget.RecyclerView.f
    {

        final WeeklyAdView this$0;

        public void a(Rect rect, View view, RecyclerView recyclerview, android.support.v7.widget.RecyclerView.q q)
        {
            if (com.target.ui.view.shop.WeeklyAdView.a(WeeklyAdView.this).size() != 1)
            {
                super.a(rect, view, recyclerview, q);
                return;
            }
            int i;
            if (view.getWidth() != 0)
            {
                i = view.getWidth();
            } else
            {
                i = Math.round((float)recyclerview.getHeight() * 0.8F);
            }
            rect.set(Math.round((float)(recyclerview.getWidth() - i) / 2.0F) - recyclerview.getPaddingLeft() - ((android.support.v7.widget.RecyclerView.i)view.getLayoutParams()).leftMargin, 0, 0, 0);
        }

        private a()
        {
            this$0 = WeeklyAdView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(WeeklyAdCardView weeklyadcardview);
    }

    private class c
        implements WeeklyAdCardView.a
    {

        private Date mEndDate;
        private String mImageUrl;
        private Date mStartDate;
        private WeeklyAdHomepageData mWeeklyAdHomePageData;
        final WeeklyAdView this$0;

        public e a()
        {
            return com.google.a.a.e.c(mEndDate);
        }

        public e a(int i)
        {
            if (mImageUrl == null)
            {
                return com.google.a.a.e.e();
            } else
            {
                return com.google.a.a.e.c(p.a(mImageUrl, i));
            }
        }

        public void a(WeeklyAdHomepageData weeklyadhomepagedata)
        {
            mWeeklyAdHomePageData = weeklyadhomepagedata;
        }

        public void a(String s)
        {
            mImageUrl = s;
        }

        public void a(Date date)
        {
            mEndDate = date;
        }

        public e b()
        {
            return com.google.a.a.e.c(mStartDate);
        }

        public void b(Date date)
        {
            mStartDate = date;
        }

        public e c()
        {
            return com.google.a.a.e.c(mImageUrl);
        }

        public e d()
        {
            return com.google.a.a.e.c(mWeeklyAdHomePageData);
        }

        public c()
        {
            this$0 = WeeklyAdView.this;
            super();
        }
    }


    private d mAdapter;
    private b mListener;
    private Rect mMarginCorrection;
    private List mViewModels;
    private WeakReference mViewParentRef;
    private Views mViews;
    private List mWeeklyAdData;

    public WeeklyAdView(Context context)
    {
        super(context);
        mViewModels = new ArrayList();
        c();
    }

    public WeeklyAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViewModels = new ArrayList();
        c();
    }

    public WeeklyAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViewModels = new ArrayList();
        c();
    }

    private c a(PageItem pageitem)
    {
        Date date;
        Object obj;
        c c1;
        if (pageitem.k().b() && ((WeeklyAdInfo)pageitem.k().c()).a().b())
        {
            pageitem = ((ImageInfo)((WeeklyAdInfo)pageitem.k().c()).a().c()).b();
        } else
        {
            pageitem = null;
        }
        obj = Calendar.getInstance();
        ((Calendar) (obj)).set(7, ((Calendar) (obj)).getFirstDayOfWeek());
        date = ((Calendar) (obj)).getTime();
        ((Calendar) (obj)).add(6, 6);
        obj = ((Calendar) (obj)).getTime();
        c1 = new c();
        c1.a(pageitem);
        c1.b(date);
        c1.a(((Date) (obj)));
        return c1;
    }

    private c a(WeeklyAdHomepageData weeklyadhomepagedata)
    {
        c c1 = new c();
        String s;
        Date date;
        Object obj;
        if (weeklyadhomepagedata.f().size() > 0)
        {
            s = ((WeeklyAdPage)weeklyadhomepagedata.f().get(0)).a();
        } else
        {
            s = weeklyadhomepagedata.e().c();
        }
        obj = weeklyadhomepagedata.g();
        date = ((WeeklyAdPromotion) (obj)).c();
        obj = ((WeeklyAdPromotion) (obj)).b();
        c1.a(s);
        c1.a(date);
        c1.b(((Date) (obj)));
        c1.a(weeklyadhomepagedata);
        return c1;
    }

    static List a(WeeklyAdView weeklyadview)
    {
        return weeklyadview.mViewModels;
    }

    private void c()
    {
        inflate(getContext(), 0x7f03017e, this);
        mViews = new Views(this);
        int i = getResources().getDimensionPixelOffset(0x7f0a02b7);
        mMarginCorrection = new Rect(i, i, i, 0);
        d();
    }

    private void d()
    {
        mAdapter = new d(mViewModels);
        mAdapter.a(this);
        mViews.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        mViews.recyclerView.setAdapter(mAdapter);
        mViews.recyclerView.a(new a());
    }

    private void e()
    {
        String s = "";
        if (getPageItem().g().b())
        {
            s = (String)getPageItem().g().c();
        }
        setFooterText(s);
    }

    protected void a()
    {
    }

    public void a(ViewParent viewparent)
    {
        mViewParentRef = new WeakReference(viewparent);
    }

    public void a(WeeklyAdCardView weeklyadcardview)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.a(weeklyadcardview);
            return;
        }
    }

    public void b()
    {
        mViewModels.clear();
        if (mWeeklyAdData != null)
        {
            WeeklyAdHomepageData weeklyadhomepagedata;
            for (Iterator iterator = mWeeklyAdData.iterator(); iterator.hasNext(); mViewModels.add(a(weeklyadhomepagedata)))
            {
                weeklyadhomepagedata = (WeeklyAdHomepageData)iterator.next();
            }

        } else
        {
            c c1 = a(getPageItem());
            mViewModels.add(c1);
        }
        mAdapter.d();
    }

    public Rect getAdditionalMargins()
    {
        return mMarginCorrection;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        ViewParent viewparent;
        boolean flag;
        if (mViews.recyclerView.canScrollHorizontally(1) || mViews.recyclerView.canScrollHorizontally(-1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mViewParentRef != null)
        {
            viewparent = (ViewParent)mViewParentRef.get();
        } else
        {
            viewparent = null;
        }
        if (flag && viewparent != null)
        {
            viewparent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionevent);
    }

    public void setFooterHeight(int i)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.text.getLayoutParams().height = i;
            mAdapter.f(i);
            mAdapter.d();
            return;
        }
    }

    public void setFooterText(String s)
    {
        mViews.text.setText(s);
    }

    public void setOnWeeklyAdCardViewClickListener(b b1)
    {
        mListener = b1;
    }

    public void setPageItemElement(com.target.ui.model.shop.a a1)
    {
        super.setPageItemElement(a1);
        b();
        e();
    }

    public void setWeeklyAdData(List list)
    {
        mWeeklyAdData = list;
    }
}
