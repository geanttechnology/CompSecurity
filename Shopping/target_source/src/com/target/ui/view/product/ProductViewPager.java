// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.h.c.ad;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.util.o;
import com.target.mothership.util.p;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.q;
import com.target.ui.view.ExpandableImageViewPager;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductViewPager extends LinearLayout
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

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(pagerSavedState, i);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            pagerSavedState = parcel.readParcelable(getClass().getClassLoader());
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    static class Views extends com.target.ui.view.a
    {

        ImageView imageView;
        ExpandableImageViewPager viewPager;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements ad
    {

        final boolean mAnimate;
        final List mImageUrl;
        final ProductViewPager this$0;

        public void a(Bitmap bitmap, com.h.c.u.d d1)
        {
            ProductViewPager.a(ProductViewPager.this, mImageUrl, mAnimate);
        }

        public void a(Drawable drawable)
        {
            q.a(ProductViewPager.a(), "Unable to get the bitmap");
            ProductViewPager.a(ProductViewPager.this, mImageUrl, mAnimate);
        }

        public void b(Drawable drawable)
        {
        }

        a(List list, boolean flag)
        {
            this$0 = ProductViewPager.this;
            super();
            mImageUrl = list;
            mAnimate = flag;
        }
    }


    private static final float COLLAPSED_VIEW_WIDTH = 0.6F;
    private static final float EXPANDED_VIEW_WIDTH = 1F;
    private static final int PRODUCT_IMAGES_PER_PAGE = 1;
    private static final String TAG = com/target/ui/view/product/ProductViewPager.getSimpleName();
    private a mCacheHolder;
    private Views mViews;

    public ProductViewPager(Context context)
    {
        super(context);
        b();
    }

    public ProductViewPager(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public ProductViewPager(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    static String a()
    {
        return TAG;
    }

    private List a(ProductImage productimage)
    {
        int i = getResources().getDimensionPixelSize(0x7f0a0242);
        ArrayList arraylist = new ArrayList();
        arraylist.add(productimage.b(i).toString());
        for (productimage = productimage.c(i).iterator(); productimage.hasNext(); arraylist.add(((URL)productimage.next()).toString())) { }
        return arraylist;
    }

    private void a(SavedState savedstate)
    {
        mViews.viewPager.onRestoreInstanceState(savedstate.pagerSavedState);
    }

    static void a(ProductViewPager productviewpager, List list, boolean flag)
    {
        productviewpager.d(list, flag);
    }

    private void a(String s)
    {
        if (o.g(s))
        {
            s = p.a(s, getResources().getDimensionPixelSize(0x7f0a0242));
            u.a(getContext()).a(s).c();
        }
    }

    private void b()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0301c4, this);
        mViews = new Views(this);
        c();
    }

    private void b(SavedState savedstate)
    {
        savedstate.pagerSavedState = mViews.viewPager.onSaveInstanceState();
    }

    private void b(List list, boolean flag)
    {
        if (j.b())
        {
            mCacheHolder = new a(list, flag);
            u.a(getContext()).a((String)list.get(0)).a(mCacheHolder);
            return;
        } else
        {
            c(list, flag);
            return;
        }
    }

    private void c()
    {
        mViews.viewPager.setBaseContentDescription(getResources().getString(0x7f09016e));
        mViews.viewPager.setPagerHeightMin(getResources().getDimensionPixelSize(0x7f0a0242));
        mViews.viewPager.setPagingHeightMax(getResources().getDimensionPixelSize(0x7f0a0243));
        mViews.viewPager.setCollapsedNumberOfItemsPerPage(1);
        mViews.viewPager.setEndPagesCentered(false);
        mViews.viewPager.t();
    }

    private void c(List list, boolean flag)
    {
        setViewPagersCollapsedWidth(list);
        setImageUrls(list);
        al.c(mViews.imageView);
        if (flag)
        {
            aj.f(mViews.viewPager);
            return;
        } else
        {
            al.b(mViews.viewPager);
            return;
        }
    }

    private void d(List list, boolean flag)
    {
        setViewPagersCollapsedWidth(list);
        setImageUrls(list);
        if (flag)
        {
            aj.a(mViews.viewPager, mViews.imageView);
            return;
        } else
        {
            al.a(mViews.viewPager, new View[] {
                mViews.imageView
            });
            return;
        }
    }

    private void setImageUrls(List list)
    {
        if (list == null || list.isEmpty())
        {
            q.a(TAG, "Image urls is either null or empty");
            return;
        } else
        {
            mViews.viewPager.setImageUrls(list);
            mViews.viewPager.t();
            return;
        }
    }

    private void setViewPagersCollapsedWidth(List list)
    {
        if (j.b())
        {
            mViews.viewPager.setCollapsedViewWidth(0.6F);
            return;
        }
        if (list.size() > 1)
        {
            mViews.viewPager.setCollapsedViewWidth(0.6F);
            return;
        } else
        {
            mViews.viewPager.setCollapsedViewWidth(1.0F);
            return;
        }
    }

    public void a(Bitmap bitmap, String s, String s1)
    {
        a(s1);
        int i = getResources().getDimensionPixelSize(0x7f0a0242);
        s1 = new android.widget.FrameLayout.LayoutParams((int)((float)getContext().getResources().getDisplayMetrics().widthPixels * 0.6F), i);
        mViews.imageView.setLayoutParams(s1);
        mViews.imageView.setImageBitmap(bitmap);
        mViews.imageView.setTransitionName(s);
        mViews.imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
    }

    public void a(ProductImage productimage, boolean flag)
    {
        b(a(productimage), flag);
    }

    public void a(WeeklyAdListingDetail weeklyadlistingdetail, boolean flag)
    {
        b(weeklyadlistingdetail.b(getResources().getDimensionPixelSize(0x7f0a0242)), flag);
    }

    public void a(List list, boolean flag)
    {
        b(list, flag);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        super.dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        super.dispatchFreezeSelfOnly(sparsearray);
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

}
