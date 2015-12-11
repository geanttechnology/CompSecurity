// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

// Referenced classes of package com.facebook.internal:
//            Validate

public class FragmentWrapper
{

    private android.app.Fragment nativeFragment;
    private Fragment supportFragment;

    public FragmentWrapper(android.app.Fragment fragment)
    {
        Validate.notNull(fragment, "fragment");
        nativeFragment = fragment;
    }

    public FragmentWrapper(Fragment fragment)
    {
        Validate.notNull(fragment, "fragment");
        supportFragment = fragment;
    }

    public final Activity getActivity()
    {
        if (supportFragment != null)
        {
            return supportFragment.getActivity();
        } else
        {
            return nativeFragment.getActivity();
        }
    }

    public android.app.Fragment getNativeFragment()
    {
        return nativeFragment;
    }

    public Fragment getSupportFragment()
    {
        return supportFragment;
    }

    public void startActivityForResult(Intent intent, int i)
    {
        if (supportFragment != null)
        {
            supportFragment.startActivityForResult(intent, i);
            return;
        } else
        {
            nativeFragment.startActivityForResult(intent, i);
            return;
        }
    }
}
