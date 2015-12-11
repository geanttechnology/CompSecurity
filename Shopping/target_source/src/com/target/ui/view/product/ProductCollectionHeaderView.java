// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.google.a.a.e;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.ui.common.d;
import com.target.ui.common.g;
import com.target.ui.util.al;
import com.target.ui.view.common.TargetErrorCardView;

// Referenced classes of package com.target.ui.view.product:
//            ProductViewPager, PdpFulfillmentView, PdpCartwheelAndPromotionView, PdpTitleView, 
//            PdpHeaderView

public class ProductCollectionHeaderView extends LinearLayout
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
        private Parcelable pagerSavedState;

        static Parcelable a(SavedState savedstate)
        {
            return savedstate.pagerSavedState;
        }

        static Parcelable a(SavedState savedstate, Parcelable parcelable)
        {
            savedstate.pagerSavedState = parcelable;
            return parcelable;
        }

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

        PdpCartwheelAndPromotionView cartwheelAndPromotionView;
        TargetErrorCardView errorContainer;
        PdpFulfillmentView fulfillmentView;
        PdpHeaderView headerView;
        ProductViewPager imageViewPager;
        View progressContainer;
        PdpTitleView titleView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements com.target.ui.view.common.c
    {

        final ProductCollectionHeaderView this$0;

        public void A_()
        {
            if (ProductCollectionHeaderView.a(ProductCollectionHeaderView.this) == null)
            {
                return;
            } else
            {
                ProductCollectionHeaderView.a(ProductCollectionHeaderView.this).a();
                return;
            }
        }

        private a()
        {
            this$0 = ProductCollectionHeaderView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a();

        public abstract void a(ProductPromotion productpromotion);

        public abstract void b();
    }

    private class c
        implements PdpFulfillmentView.a
    {

        final ProductCollectionHeaderView this$0;

        public void a()
        {
        }

        public void b()
        {
        }

        public void c()
        {
        }

        public void d()
        {
        }

        public void e()
        {
        }

        public void f()
        {
        }

        public void g()
        {
            if (ProductCollectionHeaderView.a(ProductCollectionHeaderView.this) == null)
            {
                return;
            } else
            {
                ProductCollectionHeaderView.a(ProductCollectionHeaderView.this).b();
                return;
            }
        }

        private c()
        {
            this$0 = ProductCollectionHeaderView.this;
            super();
        }

    }

    private class d
        implements PdpCartwheelAndPromotionView.c
    {

        final ProductCollectionHeaderView this$0;

        public void a(CouponPromotionId couponpromotionid)
        {
        }

        public void a(ProductCartWheel productcartwheel)
        {
        }

        public void a(ProductPromotion productpromotion)
        {
            if (ProductCollectionHeaderView.a(ProductCollectionHeaderView.this) == null)
            {
                return;
            } else
            {
                ProductCollectionHeaderView.a(ProductCollectionHeaderView.this).a(productpromotion);
                return;
            }
        }

        private d()
        {
            this$0 = ProductCollectionHeaderView.this;
            super();
        }

    }


    private b mListener;
    private Views mViews;

    public ProductCollectionHeaderView(Context context)
    {
        super(context);
        c();
    }

    public ProductCollectionHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public ProductCollectionHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static b a(ProductCollectionHeaderView productcollectionheaderview)
    {
        return productcollectionheaderview.mListener;
    }

    private void a(SavedState savedstate)
    {
        mViews.imageViewPager.onRestoreInstanceState(SavedState.a(savedstate));
    }

    private void b(SavedState savedstate)
    {
        SavedState.a(savedstate, mViews.imageViewPager.onSaveInstanceState());
    }

    private void c()
    {
        inflate(getContext(), 0x7f030144, this);
        mViews = new Views(this);
        mViews.fulfillmentView.setClickListener(new c());
        mViews.cartwheelAndPromotionView.setClickListener(new d());
        mViews.errorContainer.setClickListener(new a());
        mViews.errorContainer.a("", getContext().getString(0x7f090429), true);
    }

    public void a()
    {
        al.a(mViews.progressContainer, new View[] {
            mViews.errorContainer
        });
    }

    public void a(Bitmap bitmap, String s, String s1)
    {
        mViews.imageViewPager.a(bitmap, s, s1);
    }

    public void a(com.target.ui.common.d d1, boolean flag)
    {
        if (d1.b().b())
        {
            mViews.imageViewPager.a((ProductImage)d1.b().c(), flag);
            al.b(mViews.imageViewPager);
        } else
        {
            al.c(mViews.imageViewPager);
        }
        mViews.titleView.setDisplayOptions(d1.a());
        al.b(mViews.titleView);
        mViews.fulfillmentView.b(d1.c());
        al.b(mViews.fulfillmentView);
        if (d1.d().a())
        {
            mViews.cartwheelAndPromotionView.setData(d1.d());
            al.b(mViews.cartwheelAndPromotionView);
        } else
        {
            al.c(mViews.cartwheelAndPromotionView);
        }
        al.c(mViews.errorContainer);
    }

    public void b()
    {
        al.a(new View[] {
            mViews.errorContainer, mViews.progressContainer
        });
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

    public void setClickListener(b b1)
    {
        mListener = b1;
    }

    public void setErrorData(com.target.ui.view.common.b.a a1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.errorContainer.a(a1, true);
            al.a(mViews.errorContainer, new View[] {
                mViews.progressContainer
            });
            return;
        }
    }

    public void setErrorData(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.errorContainer.a("", s, true);
            al.a(mViews.errorContainer, new View[] {
                mViews.progressContainer
            });
            return;
        }
    }
}
