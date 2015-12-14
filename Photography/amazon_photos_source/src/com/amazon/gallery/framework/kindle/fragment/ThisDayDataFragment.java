// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ThisDayDataFragment extends Fragment
{

    private Object savedState;

    public ThisDayDataFragment()
    {
    }

    public Object getSavedState()
    {
        return savedState;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void saveState(Object obj)
    {
        savedState = obj;
    }
}
