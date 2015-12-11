// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.aob;
import android.support.v7.aov;

interface SessionAnalyticsManagerStrategy
    extends aob
{

    public abstract void processEvent(SessionEvent.Builder builder);

    public abstract void setAnalyticsSettingsData(aov aov, String s);
}
