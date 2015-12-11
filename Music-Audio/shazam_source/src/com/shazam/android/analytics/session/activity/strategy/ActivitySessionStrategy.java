// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import android.app.Activity;

public interface ActivitySessionStrategy
{

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void onStart(Activity activity);

    public abstract void onStop(Activity activity);

    public abstract void onWindowFocused(Activity activity);

    public abstract void onWindowUnfocused(Activity activity);
}
