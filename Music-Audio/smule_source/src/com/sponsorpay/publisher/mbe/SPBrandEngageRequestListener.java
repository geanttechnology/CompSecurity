// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.content.Intent;

public interface SPBrandEngageRequestListener
{

    public abstract void onSPBrandEngageError(String s);

    public abstract void onSPBrandEngageOffersAvailable(Intent intent);

    public abstract void onSPBrandEngageOffersNotAvailable();
}
