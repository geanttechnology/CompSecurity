// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;

import com.rdio.android.api.models.Ad;

public class AdCompletedEvent
{

    public final Ad ad;
    public final boolean hadClickthrough;
    public final boolean playedAudio;
    public final boolean showedAd;

    public AdCompletedEvent(Ad ad1)
    {
        this(ad1, true, false, false);
    }

    public AdCompletedEvent(Ad ad1, boolean flag, boolean flag1, boolean flag2)
    {
        ad = ad1;
        playedAudio = flag;
        showedAd = flag1;
        hadClickthrough = flag2;
    }
}
