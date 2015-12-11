// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.view.View;
import android.view.Window;
import com.shazam.android.analytics.session.SessionManager;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            NoOpFragmentSessionStrategy

public class FragmentSelectedUnselectedFocusedUnfocusedSessionStrategy extends NoOpFragmentSessionStrategy
{

    private boolean hasSessionStarted;
    private boolean isSelected;
    private final SessionManager sessionManager;

    public FragmentSelectedUnselectedFocusedUnfocusedSessionStrategy(SessionManager sessionmanager)
    {
        sessionManager = sessionmanager;
    }

    private boolean hasWindowFocus(Fragment fragment)
    {
        fragment = fragment.getActivity();
        return fragment != null && fragment.getWindow().getDecorView().hasWindowFocus();
    }

    private void startSession(Fragment fragment)
    {
        sessionManager.startSession(fragment);
        hasSessionStarted = true;
    }

    private void stopSession(Fragment fragment)
    {
        sessionManager.stopSession(fragment);
        hasSessionStarted = false;
    }

    public void onSelected(Fragment fragment)
    {
        if (hasWindowFocus(fragment) && !hasSessionStarted)
        {
            startSession(fragment);
        }
        isSelected = true;
    }

    public void onUnselected(Fragment fragment)
    {
        isSelected = false;
        if (hasWindowFocus(fragment))
        {
            stopSession(fragment);
        }
    }

    public void onWindowFocused(Fragment fragment)
    {
        if (isSelected && !hasSessionStarted)
        {
            startSession(fragment);
        }
    }

    public void onWindowUnfocused(Fragment fragment)
    {
        if (isSelected)
        {
            stopSession(fragment);
        }
    }
}
