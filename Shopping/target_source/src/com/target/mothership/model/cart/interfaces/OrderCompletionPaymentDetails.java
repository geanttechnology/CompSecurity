// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.interfaces;

import android.os.Parcelable;
import com.target.mothership.common.tender.a;
import com.target.mothership.model.common.GuestAddress;

public interface OrderCompletionPaymentDetails
    extends Parcelable
{

    public abstract a a();

    public abstract GuestAddress b();
}
