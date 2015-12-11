// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.interfaces;

import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.common.coupons.CouponIdentifier;

public interface BaseCouponOffer
    extends Parcelable
{

    public abstract CouponIdentifier c();

    public abstract String d();

    public abstract e e();
}
