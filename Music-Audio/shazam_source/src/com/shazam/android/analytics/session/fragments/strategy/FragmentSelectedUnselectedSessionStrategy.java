// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import android.support.v4.app.Fragment;
import com.shazam.android.analytics.session.SessionManager;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            NoOpFragmentSessionStrategy

public class FragmentSelectedUnselectedSessionStrategy extends NoOpFragmentSessionStrategy
{

    private final SessionManager sessionManager;

    public FragmentSelectedUnselectedSessionStrategy(SessionManager sessionmanager)
    {
        sessionManager = sessionmanager;
    }

    public void onSelected(Fragment fragment)
    {
        sessionManager.startSession(fragment);
    }

    public void onUnselected(Fragment fragment)
    {
        sessionManager.stopSession(fragment);
    }
}
