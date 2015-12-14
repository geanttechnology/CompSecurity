// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import bvw;
import bwv;

interface SessionAnalyticsManagerStrategy
    extends bvw
{

    public abstract void processEvent(SessionEvent.Builder builder);

    public abstract void setAnalyticsSettingsData(bwv bwv, String s);
}
