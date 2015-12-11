// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session;

import android.content.Context;

public interface SessionAnalytics
{

    public abstract void startSession(Context context);

    public abstract void stopSession(Context context);
}
