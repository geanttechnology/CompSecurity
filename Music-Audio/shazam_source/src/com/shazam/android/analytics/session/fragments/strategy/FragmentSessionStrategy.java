// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import android.support.v4.app.Fragment;

public interface FragmentSessionStrategy
{

    public abstract void onPause(Fragment fragment);

    public abstract void onResume(Fragment fragment);

    public abstract void onSelected(Fragment fragment);

    public abstract void onStart(Fragment fragment);

    public abstract void onStop(Fragment fragment);

    public abstract void onUnselected(Fragment fragment);

    public abstract void onWindowFocused(Fragment fragment);

    public abstract void onWindowUnfocused(Fragment fragment);
}
