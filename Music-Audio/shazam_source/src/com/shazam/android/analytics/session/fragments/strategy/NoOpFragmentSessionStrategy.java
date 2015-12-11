// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import android.support.v4.app.Fragment;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            FragmentSessionStrategy

public class NoOpFragmentSessionStrategy
    implements FragmentSessionStrategy
{

    public NoOpFragmentSessionStrategy()
    {
    }

    public void onPause(Fragment fragment)
    {
    }

    public void onResume(Fragment fragment)
    {
    }

    public void onSelected(Fragment fragment)
    {
    }

    public void onStart(Fragment fragment)
    {
    }

    public void onStop(Fragment fragment)
    {
    }

    public void onUnselected(Fragment fragment)
    {
    }

    public void onWindowFocused(Fragment fragment)
    {
    }

    public void onWindowUnfocused(Fragment fragment)
    {
    }
}
