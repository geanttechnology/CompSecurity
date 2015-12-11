// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Fragment;
import android.os.Bundle;
import butterknife.ButterKnife;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class OnboardingFragment extends Fragment
{

    Boolean includeEmail;

    public OnboardingFragment()
    {
        includeEmail = Boolean.valueOf(false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
