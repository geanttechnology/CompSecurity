// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;

import com.rdio.android.api.models.Ad;

public class HasPendingAdEvent
{

    private Ad ad;

    public HasPendingAdEvent(Ad ad1)
    {
        ad = ad1;
    }

    public Ad getAd()
    {
        return ad;
    }
}
