// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import com.target.mothership.util.o;
import com.target.ui.adapter.list.d;
import com.target.ui.util.al;
import com.target.ui.view.common.ViewPagerIndicator;
import java.util.ArrayList;
import java.util.List;

public class PromotionsCarouselView extends RelativeLayout
    implements com.target.ui.adapter.list.d.a
{
    static class Views extends com.target.ui.view.a
    {

        ViewPagerIndicator indicator;
        View progress;
        TextView relatedDealsHeader;
        ViewPager viewPages;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.support.v4.view.ViewPager.f
    {

        final PromotionsCarouselView this$0;

        public void a(int i)
        {
            PromotionsCarouselView.a(PromotionsCarouselView.this).indicator.a(i);
            PromotionsCarouselView.a(PromotionsCarouselView.this).indicator.setContentDescription(((PromotionDetail)PromotionsCarouselView.b(PromotionsCarouselView.this).get(i)).a());
        }

        public void a(int i, float f, int j)
        {
        }

        public void b(int i)
        {
        }

        private a()
        {
            this$0 = PromotionsCarouselView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(PromotionDetail promotiondetail, int i);
    }


    private static final int DEFAULT_INDEX = 0;
    private static final int OFF_PAGE_LIMIT = 2;
    public static final String TAG = com/target/ui/view/list/PromotionsCarouselView.getSimpleName();
    private d mAdapter;
    private b mListener;
    private List mPromotionData;
    private Views mViews;

    public PromotionsCarouselView(Context context)
    {
        super(context);
        b();
    }

    public PromotionsCarouselView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public PromotionsCarouselView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    static Views a(PromotionsCarouselView promotionscarouselview)
    {
        return promotionscarouselview.mViews;
    }

    static List b(PromotionsCarouselView promotionscarouselview)
    {
        return promotionscarouselview.mPromotionData;
    }

    private void b()
    {
        inflate(getContext(), 0x7f030168, this);
        mViews = new Views(this);
        c();
    }

    private void c()
    {
        mAdapter = new d(getContext(), this);
        mViews.viewPages.setAdapter(mAdapter);
        mViews.viewPages.setOffscreenPageLimit(2);
        mViews.viewPages.setPageMargin(getResources().getDimensionPixelSize(0x7f0a01ca));
        mViews.viewPages.setClipToPadding(false);
        int i = getResources().getDimensionPixelOffset(0x7f0a01cb);
        mViews.viewPages.setPadding(i, 0, i, 0);
        mViews.viewPages.setOnPageChangeListener(new a());
    }

    public void a()
    {
        mPromotionData = new ArrayList();
        mAdapter.a(mPromotionData);
        mViews.indicator.setPageCount(0);
        mViews.relatedDealsHeader.setText("");
    }

    public void a(PromotionDetail promotiondetail, int i)
    {
        if (mListener == null)
        {
            return;
        } else
        {
            mListener.a(promotiondetail, i);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.progress, new View[] {
                mViews.viewPages, mViews.indicator
            });
            return;
        } else
        {
            al.a(0, new View[] {
                mViews.viewPages, mViews.indicator
            });
            al.c(mViews.progress);
            return;
        }
    }

    public void setData(List list)
    {
        mPromotionData = list;
        mAdapter.a(list);
        mViews.indicator.setPageCount(list.size());
        mViews.viewPages.a(0, false);
        mViews.indicator.a(0);
        if (!mPromotionData.isEmpty())
        {
            mViews.indicator.setContentDescription(((PromotionDetail)mPromotionData.get(0)).a());
        }
    }

    public void setPosition(int i)
    {
        if (mAdapter == null)
        {
            return;
        } else
        {
            mAdapter.a(i);
            return;
        }
    }

    public void setPromotionsListener(b b1)
    {
        mListener = b1;
    }

    public void setReferenceProductName(String s)
    {
        if (o.g(s))
        {
            s = getResources().getString(0x7f0903ac, new Object[] {
                s
            });
        } else
        {
            s = "";
        }
        mViews.relatedDealsHeader.setText(s);
    }

}
