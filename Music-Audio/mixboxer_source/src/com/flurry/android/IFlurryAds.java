// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Map;

interface IFlurryAds
{

    public abstract void cleanUpSession(Context context);

    public abstract void onContinueSession(Context context);

    public abstract void onEndSession(Context context);

    public abstract void onStartNewSession(Context context, long l, long l1);

    public abstract void savePersistentAdLogData();

    public abstract void savePersistentFreqCapData();

    public abstract void setReportedIds(Map map);
}
