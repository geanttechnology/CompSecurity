// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.foundations.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import com.google.inject.Injector;
import roboguice.RoboGuice;

public class BaseDialogFragment extends DialogFragment
{

    protected Injector injector;

    public BaseDialogFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (injector == null)
        {
            injector = RoboGuice.getInjector(getActivity());
            injector.injectMembers(this);
        }
    }

    public void onDestroy()
    {
        RoboGuice.destroyInjector(getActivity());
        super.onDestroy();
    }
}
