// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;


public interface PaymentForm
{

    public abstract String getCardNumber();

    public abstract String getCvc();

    public abstract Integer getExpMonth();

    public abstract Integer getExpYear();
}
