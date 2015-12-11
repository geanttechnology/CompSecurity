// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.base.fragments;

import android.support.v7.a.f;
import android.util.Log;
import com.g.a.a;
import com.shazam.android.aspects.c.b.b;
import com.shazam.android.aspects.fragments.ShazamCustomFragmentAspect;
import com.shazam.android.fragment.c;
import java.util.Collection;
import java.util.Iterator;

public class BaseFragment extends b
    implements com.shazam.android.ad.b.b, c
{

    private final Collection aspects = getAspectProvider(com/shazam/android/aspects/fragments/ShazamCustomFragmentAspect).a();

    public BaseFragment()
    {
    }

    public android.support.v7.a.a getSupportActionBar()
    {
        if (getActivity() instanceof f)
        {
            return ((f)getActivity()).getSupportActionBar();
        } else
        {
            Log.e(com/shazam/android/base/fragments/BaseFragment.getName(), "Tried to getSupportActionBar without being attached to an actionbar-providing activity.");
            return null;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.shazam.i.o.b.a();
        a.a();
    }

    public void onSelected()
    {
        for (Iterator iterator = aspects.iterator(); iterator.hasNext(); ((ShazamCustomFragmentAspect)iterator.next()).onSelected(this)) { }
    }

    public void onUnselected()
    {
        for (Iterator iterator = aspects.iterator(); iterator.hasNext(); ((ShazamCustomFragmentAspect)iterator.next()).onUnselected(this)) { }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        for (Iterator iterator = aspects.iterator(); iterator.hasNext();)
        {
            ShazamCustomFragmentAspect shazamcustomfragmentaspect = (ShazamCustomFragmentAspect)iterator.next();
            if (flag)
            {
                shazamcustomfragmentaspect.onWindowFocused(this);
            } else
            {
                shazamcustomfragmentaspect.onWindowUnfocused(this);
            }
        }

    }
}
