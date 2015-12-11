// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import android.app.Activity;

// Referenced classes of package com.shazam.android.analytics.session.activity.strategy:
//            ActivitySessionStrategy

public class NoOpActivitySessionStrategy
    implements ActivitySessionStrategy
{

    public NoOpActivitySessionStrategy()
    {
    }

    public void onPause(Activity activity)
    {
    }

    public void onResume(Activity activity)
    {
    }

    public void onStart(Activity activity)
    {
    }

    public void onStop(Activity activity)
    {
    }

    public void onWindowFocused(Activity activity)
    {
    }

    public void onWindowUnfocused(Activity activity)
    {
    }
}
