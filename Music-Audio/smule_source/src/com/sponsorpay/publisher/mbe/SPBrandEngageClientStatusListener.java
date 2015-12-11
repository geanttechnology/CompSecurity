// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;


public interface SPBrandEngageClientStatusListener
{

    public abstract void didChangeStatus(SPBrandEngageClientStatus spbrandengageclientstatus);

    public abstract void didReceiveOffers(boolean flag);
}
