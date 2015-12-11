// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.settings;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.comcast.cim.android.view.launch.AuthenticatingPreferenceFragment;

public class SettingsFragment extends AuthenticatingPreferenceFragment
{

    public SettingsFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(getActivity().getResources().getIdentifier(getArguments().getString("resource"), "xml", getActivity().getPackageName()));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        viewgroup = (ListView)layoutinflater.findViewById(0x102000a);
        bundle = getActivity().getResources();
        if (getArguments().getBoolean(bundle.getString(com.comcast.cim.android.R.string.no_visible_footer_extra), false))
        {
            viewgroup.setOverscrollFooter(bundle.getDrawable(com.comcast.cim.android.R.color.transparent));
        }
        return layoutinflater;
    }
}
