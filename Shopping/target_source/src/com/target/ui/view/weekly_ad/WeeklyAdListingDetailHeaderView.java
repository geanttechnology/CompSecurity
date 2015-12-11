// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingPromotion;
import com.target.ui.common.h;
import com.target.ui.i.d.a;
import com.target.ui.service.k;
import com.target.ui.util.al;
import com.target.ui.view.common.TargetErrorCardView;
import com.target.ui.view.common.c;
import com.target.ui.view.product.PdpFulfillmentView;
import com.target.ui.view.product.PdpTitleView;
import com.target.ui.view.product.ProductViewPager;
import java.util.List;

// Referenced classes of package com.target.ui.view.weekly_ad:
//            WeeklyAdListingPromotionView

public class WeeklyAdListingDetailHeaderView extends LinearLayout
    implements c, com.target.ui.view.product.PdpFulfillmentView.a, WeeklyAdListingPromotionView.a
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

        TargetErrorCardView errorView;
        PdpFulfillmentView fulfillmentView;
        ProductViewPager imageViewPager;
        TextView productDetails;
        View productDetailsView;
        View progressView;
        WeeklyAdListingPromotionView promotionView;
        PdpTitleView titleView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();
    }


    private a mListener;
    private Views mViews;

    public WeeklyAdListingDetailHeaderView(Context context)
    {
        super(context);
        h();
    }

    public WeeklyAdListingDetailHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        h();
    }

    public WeeklyAdListingDetailHeaderView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        h();
    }

    static a a(WeeklyAdListingDetailHeaderView weeklyadlistingdetailheaderview)
    {
        return weeklyadlistingdetailheaderview.mListener;
    }

    private void a(SavedState savedstate)
    {
        mViews.imageViewPager.onRestoreInstanceState(savedstate.pagerSavedState);
    }

    private void b(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        mViews.promotionView.setPromotion(weeklyadlistingdetail.i());
    }

    private void b(WeeklyAdListingDetail weeklyadlistingdetail, Store store)
    {
        e e1 = k.a().c();
        boolean flag;
        if (e1.b() && ((RelevantStoreSummary)e1.c()).getStoreId().equals(store.getStoreId()))
        {
            flag = ((RelevantStoreSummary)e1.c()).a();
        } else
        {
            flag = false;
        }
        mViews.fulfillmentView.b(com.target.ui.i.d.a.a(getContext(), weeklyadlistingdetail, flag));
    }

    private void b(SavedState savedstate)
    {
        savedstate.pagerSavedState = mViews.imageViewPager.onSaveInstanceState();
    }

    private void b(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        al.a(byte0, new View[] {
            mViews.promotionView
        });
    }

    private void c(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        View view = mViews.productDetailsView;
        int i;
        if (weeklyadlistingdetail.g().b() || weeklyadlistingdetail.h().b())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void h()
    {
        inflate(getContext(), 0x7f03020c, this);
        mViews = new Views(this);
        mViews.productDetails.setText(getResources().getString(0x7f090427));
        mViews.errorView.setClickListener(this);
    }

    public void A_()
    {
        if (mListener != null)
        {
            mListener.b();
        }
    }

    public void a()
    {
    }

    public void a(Bitmap bitmap, String s, String s1)
    {
        mViews.imageViewPager.a(bitmap, s, s1);
    }

    public void a(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        mViews.imageViewPager.a(weeklyadlistingdetail, true);
    }

    public void a(WeeklyAdListingDetail weeklyadlistingdetail, Store store)
    {
        a(weeklyadlistingdetail);
        h h1 = new h(weeklyadlistingdetail.a());
        mViews.titleView.setDisplayOptions(h1);
        b(weeklyadlistingdetail, store);
        boolean flag;
        if (!weeklyadlistingdetail.k().isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
        if (!flag)
        {
            b(weeklyadlistingdetail);
        }
        c(weeklyadlistingdetail);
        mViews.fulfillmentView.setClickListener(this);
        mViews.promotionView.setOnPromotionClickedListener(this);
        mViews.productDetailsView.setOnClickListener(new android.view.View.OnClickListener() {

            final WeeklyAdListingDetailHeaderView this$0;

            public void onClick(View view)
            {
                if (com.target.ui.view.weekly_ad.WeeklyAdListingDetailHeaderView.a(WeeklyAdListingDetailHeaderView.this) != null)
                {
                    com.target.ui.view.weekly_ad.WeeklyAdListingDetailHeaderView.a(WeeklyAdListingDetailHeaderView.this).c();
                }
            }

            
            {
                this$0 = WeeklyAdListingDetailHeaderView.this;
                super();
            }
        });
    }

    public void a(WeeklyAdListingPromotion weeklyadlistingpromotion)
    {
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        al.a(mViews.errorView, new View[] {
            mViews.progressView, mViews.promotionView, mViews.productDetailsView, mViews.fulfillmentView
        });
        mViews.errorView.a(a1, flag);
    }

    public void a(String s, String s1, boolean flag)
    {
        al.a(mViews.errorView, new View[] {
            mViews.progressView, mViews.promotionView, mViews.productDetailsView, mViews.fulfillmentView
        });
        mViews.errorView.a(s, s1, flag);
    }

    public void a(boolean flag)
    {
        al.a(mViews.errorView, false);
        if (flag)
        {
            al.a(mViews.progressView, new View[] {
                mViews.promotionView, mViews.productDetailsView, mViews.fulfillmentView
            });
            return;
        } else
        {
            al.a(mViews.progressView, 8);
            al.b(new View[] {
                mViews.promotionView, mViews.productDetailsView, mViews.fulfillmentView
            });
            return;
        }
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

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        super.dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        super.dispatchFreezeSelfOnly(sparsearray);
    }

    public void e()
    {
    }

    public void f()
    {
    }

    public void g()
    {
        if (mListener != null)
        {
            mListener.a();
        }
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

    public void setListener(a a1)
    {
        mListener = a1;
    }

    public void setTitle(String s)
    {
        s = new h(s);
        mViews.titleView.setDisplayOptions(s);
    }
}
