// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.fragment;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.thor.app.FeatureChecker;

public class ThorFragmentController extends FragmentController
{

    public ThorFragmentController(Activity activity, FragmentManager fragmentmanager, FeatureChecker featurechecker)
    {
        super(activity, fragmentmanager, featurechecker);
    }

    protected int getFragmentContainer()
    {
        return 0x7f0c0185;
    }
}
