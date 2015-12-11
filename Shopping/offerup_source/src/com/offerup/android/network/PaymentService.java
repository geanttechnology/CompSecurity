// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import retrofit.Callback;

public interface PaymentService
{

    public abstract void addCard(String s, Callback callback);

    public abstract void addPaymentMethod(String s, Callback callback);

    public abstract void defaultPaymentMethod(long l, Callback callback);

    public abstract void deletePaymentMethod(long l, Callback callback);

    public abstract void getPaymentMethods(Callback callback);

    public abstract void getToken(Callback callback);

    public abstract void payForItem(long l, String s, String s1, Callback callback);

    public abstract void payForItemWithNonce(long l, String s, String s1, Callback callback);

    public abstract void postMyPaymentLocation(long l, boolean flag, double d, double d1, 
            float f, String s, Callback callback);
}
