// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons.presenter;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.common.coupons.CouponIdentifier;
import com.target.mothership.model.coupons.c;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.CouponOffer;
import com.target.mothership.model.d;
import com.target.ui.fragment.mcoupons.a.a;
import com.target.ui.g.b;
import java.util.Iterator;
import java.util.List;

public class CouponDetailPresenter extends b
{
    public static class SavedState
        implements Parcelable
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
        AvailableCouponOffer availableCouponOffer;
        String couponUrl;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(availableCouponOffer, i);
            parcel.writeString(couponUrl);
        }


        public SavedState()
        {
        }

        private SavedState(Parcel parcel)
        {
            couponUrl = parcel.readString();
            availableCouponOffer = (AvailableCouponOffer)parcel.readParcelable(com/target/mothership/model/coupons/interfaces/AvailableCouponOffer.getClassLoader());
        }

    }


    private AvailableCouponOffer mAvailableCouponOffer;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private String mCouponUrl;
    private c mCouponsManager;
    private a mPresentation;

    public CouponDetailPresenter(c c1, com.target.ui.service.provider.b b1, String s, AvailableCouponOffer availablecouponoffer, Parcelable parcelable)
    {
        mCouponsManager = c1;
        mConnectivityProvider = b1;
        mCouponUrl = s;
        mAvailableCouponOffer = availablecouponoffer;
        if (parcelable != null)
        {
            a(parcelable);
        }
    }

    static a a(CouponDetailPresenter coupondetailpresenter)
    {
        return coupondetailpresenter.mPresentation;
    }

    private void a(AvailableCouponOffer availablecouponoffer)
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.n();
            return;
        }
        CompletedSignUp completedsignup = (CompletedSignUp)mCouponsManager.a().d();
        if (completedsignup == null)
        {
            mPresentation.a(0x7f0902b0);
            return;
        } else
        {
            mPresentation.o();
            mCouponsManager.a(completedsignup, availablecouponoffer, new d() {

                final CouponDetailPresenter this$0;

                public void a(com.target.mothership.model.coupons.interfaces.a.a a1)
                {
                    if (com.target.ui.fragment.mcoupons.presenter.CouponDetailPresenter.a(CouponDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        CouponDetailPresenter.this.a(a1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    if (com.target.ui.fragment.mcoupons.presenter.CouponDetailPresenter.a(CouponDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        c();
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.coupons.interfaces.a.a)obj);
                }

            
            {
                this$0 = CouponDetailPresenter.this;
                super();
            }
            });
            return;
        }
    }

    private void e()
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.n();
            return;
        }
        CompletedSignUp completedsignup = (CompletedSignUp)mCouponsManager.a().d();
        if (completedsignup == null)
        {
            mPresentation.a(0x7f0902b0);
            return;
        } else
        {
            mPresentation.o();
            mCouponsManager.b(completedsignup, new d() {

                final CouponDetailPresenter this$0;

                public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
                {
                    if (com.target.ui.fragment.mcoupons.presenter.CouponDetailPresenter.a(CouponDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        CouponDetailPresenter.this.a(c1);
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    if (com.target.ui.fragment.mcoupons.presenter.CouponDetailPresenter.a(CouponDetailPresenter.this) == null)
                    {
                        return;
                    } else
                    {
                        CouponDetailPresenter.this.a(list);
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.coupons.interfaces.a.c)obj);
                }

            
            {
                this$0 = CouponDetailPresenter.this;
                super();
            }
            });
            return;
        }
    }

    private void f()
    {
        if (mCouponUrl != null)
        {
            mPresentation.c(mCouponUrl);
            return;
        } else
        {
            g();
            return;
        }
    }

    private void g()
    {
        if (mAvailableCouponOffer == null)
        {
            mPresentation.a(0x7f0902ae);
            return;
        }
        if (!mAvailableCouponOffer.b())
        {
            a(mAvailableCouponOffer);
            return;
        } else
        {
            e();
            return;
        }
    }

    public void a(Parcelable parcelable)
    {
        parcelable = (SavedState)parcelable;
        mAvailableCouponOffer = ((SavedState) (parcelable)).availableCouponOffer;
        mCouponUrl = ((SavedState) (parcelable)).couponUrl;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.b("");
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.a a1)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[];

            static 
            {
                $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason = new int[com.target.mothership.model.coupons.interfaces.a.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$model$coupons$interfaces$error$AddOnDemandCouponFailure$AddOnDemandCouponFailureReason[com.target.mothership.model.coupons.interfaces.a.a.a.COUPON_ERR_PRE_ASSIGNED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls3..SwitchMap.com.target.mothership.model.coupons.interfaces.error.AddOnDemandCouponFailure.AddOnDemandCouponFailureReason[((com.target.mothership.model.coupons.interfaces.a.a.a)a1.e()).ordinal()])
        {
        default:
            mPresentation.a(0x7f0902ae);
            return;

        case 1: // '\001'
            e();
            break;
        }
    }

    public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
    {
        mPresentation.a(0x7f0902ae);
    }

    public void a(a a1, boolean flag)
    {
        mPresentation = a1;
        if (flag)
        {
            return;
        } else
        {
            f();
            return;
        }
    }

    public void a(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            CouponOffer couponoffer = (CouponOffer)list.next();
            if (couponoffer.c().equals(mAvailableCouponOffer.c()))
            {
                mCouponUrl = couponoffer.a();
                mPresentation.c(mCouponUrl);
                return;
            }
        }

        mPresentation.a(0x7f0902ae);
    }

    public void c()
    {
        mPresentation.b(0x7f0902aa);
        e();
    }

    public void d()
    {
        f();
    }

    public void v_()
    {
        mCouponsManager = null;
    }

    public void z_()
    {
        mPresentation = null;
    }
}
