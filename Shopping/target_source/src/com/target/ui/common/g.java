// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.product.interfaces.ProductDetails;
import java.util.List;

public class g
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a BLACK;
        public static final a RED;
        public static final a UNKNOWN;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/common/g$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            RED = new a("RED", 0);
            BLACK = new a("BLACK", 1);
            UNKNOWN = new a("UNKNOWN", 2);
            $VALUES = (new a[] {
                RED, BLACK, UNKNOWN
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private List mCartWheel;
    private boolean mCouponApplied;
    private CouponPromotionId mCouponPromotionId;
    private a mPromoColor;
    private List mPromotions;
    private boolean mShowCartwheelIcon;
    private boolean mShowPromoIcon;

    public g(ProductDetails productdetails)
    {
        mShowCartwheelIcon = true;
        mShowPromoIcon = true;
        mPromoColor = a.BLACK;
        a(productdetails);
    }

    private void a(ProductDetails productdetails)
    {
        mCartWheel = productdetails.n();
        mPromotions = productdetails.y();
        mCouponPromotionId = (CouponPromotionId)productdetails.z().d();
    }

    public void a(boolean flag)
    {
        mCouponApplied = flag;
    }

    public boolean a()
    {
        return !c().isEmpty() || !b().isEmpty();
    }

    public List b()
    {
        return mCartWheel;
    }

    public List c()
    {
        return mPromotions;
    }

    public boolean d()
    {
        return mCouponApplied;
    }

    public boolean e()
    {
        return mShowCartwheelIcon;
    }

    public boolean f()
    {
        return mShowPromoIcon;
    }

    public a g()
    {
        return mPromoColor;
    }

    public e h()
    {
        return com.google.a.a.e.c(mCouponPromotionId);
    }
}
