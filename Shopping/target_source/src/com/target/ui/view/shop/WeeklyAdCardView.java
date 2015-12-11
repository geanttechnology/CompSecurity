// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.h.c.u;
import com.h.c.y;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.b.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeeklyAdCardView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView displayText;
        BitmapImageView image;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract e a();

        public abstract e a(int i);

        public abstract e b();

        public abstract e c();

        public abstract e d();
    }


    public static final float ASPECT_RATIO = 0.8F;
    private static final String SINGLE_DATE_FORMAT = "MMM d";
    private com.target.ui.view.b.a mAspectMeasurer;
    private String mCurrentImageUrl;
    private boolean mImageNeedsUpdating;
    private Views mViews;
    private a mWeeklyAdCardViewModel;

    public WeeklyAdCardView(Context context)
    {
        super(context);
        mImageNeedsUpdating = false;
        a();
    }

    public WeeklyAdCardView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mImageNeedsUpdating = false;
        a();
    }

    public WeeklyAdCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mImageNeedsUpdating = false;
        a();
    }

    static String a(WeeklyAdCardView weeklyadcardview, String s)
    {
        weeklyadcardview.mCurrentImageUrl = s;
        return s;
    }

    private void a()
    {
        inflate(getContext(), 0x7f0300da, this);
        mViews = new Views(this);
        mAspectMeasurer = new com.target.ui.view.b.a(0.80000001192092896D);
        mViews.displayText.setTextColor(getResources().getColor(0x7f0f00f6));
    }

    private void a(a a1)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MMM d", Locale.US);
        Date date = (Date)a1.b().d();
        a1 = (Date)a1.a().d();
        if (date != null && a1 != null)
        {
            a1 = getResources().getString(0x7f0903f5, new Object[] {
                simpledateformat.format(date), simpledateformat.format(a1)
            });
        } else
        if (date != null)
        {
            a1 = getResources().getString(0x7f0903f6, new Object[] {
                simpledateformat.format(date)
            });
        } else
        if (a1 != null)
        {
            a1 = getResources().getString(0x7f0903f7, new Object[] {
                simpledateformat.format(a1)
            });
        } else
        {
            a1 = "";
        }
        mViews.displayText.setText(a1);
    }

    private void b()
    {
        BitmapImageView bitmapimageview = mViews.image;
        u.a(getContext()).a(bitmapimageview);
        int i = mViews.image.getMeasuredWidth();
        int j = mViews.image.getMeasuredHeight();
        final String imageUrl;
        if (mWeeklyAdCardViewModel != null)
        {
            imageUrl = (String)mWeeklyAdCardViewModel.a(j).d();
        } else
        {
            imageUrl = null;
        }
        if (imageUrl == null)
        {
            mCurrentImageUrl = null;
            u.a(getContext()).a((String)null).a(bitmapimageview);
        } else
        if (!imageUrl.equals(mCurrentImageUrl))
        {
            mViews.image.setCallback(new com.h.c.e() {

                final WeeklyAdCardView this$0;
                final String val$imageUrl;

                public void a()
                {
                    com.target.ui.view.shop.WeeklyAdCardView.a(WeeklyAdCardView.this, imageUrl);
                }

                public void b()
                {
                    com.target.ui.view.shop.WeeklyAdCardView.a(WeeklyAdCardView.this, null);
                }

            
            {
                this$0 = WeeklyAdCardView.this;
                imageUrl = s;
                super();
            }
            });
            u.a(getContext()).a(imageUrl).a(i, j).b().a(bitmapimageview);
            return;
        }
    }

    public BitmapImageView getBitmapImageView()
    {
        return mViews.image;
    }

    public e getViewModel()
    {
        return e.c(mWeeklyAdCardViewModel);
    }

    protected void onMeasure(int i, int j)
    {
        mAspectMeasurer.a(i, j);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(mAspectMeasurer.a(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(mAspectMeasurer.b(), 0x40000000));
        if (mImageNeedsUpdating)
        {
            mImageNeedsUpdating = false;
            b();
        }
    }

    public void setFooterHeight(int i)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.displayText.getLayoutParams().height = i;
            return;
        }
    }

    public void setViewModel(a a1)
    {
        mWeeklyAdCardViewModel = a1;
        a(mWeeklyAdCardViewModel);
        mImageNeedsUpdating = true;
    }
}
