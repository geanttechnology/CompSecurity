// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.ads;

import android.view.View;
import com.shazam.model.advert.AdType;

public interface AdvertClickedEventAnalytics
{

    public abstract void sendAdClicked(View view, AdType adtype, String s);
}
