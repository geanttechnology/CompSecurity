// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import android.support.v4.app.Fragment;
import com.shazam.android.analytics.session.SessionManager;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            NoOpFragmentSessionStrategy

public class FragmentResumePauseSessionStrategy extends NoOpFragmentSessionStrategy
{

    private final SessionManager sessionManager;

    public FragmentResumePauseSessionStrategy(SessionManager sessionmanager)
    {
        sessionManager = sessionmanager;
    }

    public void onPause(Fragment fragment)
    {
        sessionManager.stopSession(fragment);
    }

    public void onResume(Fragment fragment)
    {
        sessionManager.startSession(fragment);
    }
}
