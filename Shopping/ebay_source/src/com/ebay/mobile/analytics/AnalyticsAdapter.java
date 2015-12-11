// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.content.Context;
import com.ebay.mobile.analytics.model.TrackingData;

public interface AnalyticsAdapter
{

    public abstract boolean adapt(Context context, TrackingData trackingdata);
}
