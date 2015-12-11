// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.OfferResponse;

public interface OfferService
{

    public abstract OfferResponse makeOffer(long l, double d);
}
