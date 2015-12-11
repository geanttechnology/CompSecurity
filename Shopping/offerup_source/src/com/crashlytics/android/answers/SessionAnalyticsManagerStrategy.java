// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import c.a.a.a.a.d.g;
import c.a.a.a.a.g.b;

interface SessionAnalyticsManagerStrategy
    extends g
{

    public abstract void processEvent(SessionEvent.Builder builder);

    public abstract void setAnalyticsSettingsData(b b, String s);
}
