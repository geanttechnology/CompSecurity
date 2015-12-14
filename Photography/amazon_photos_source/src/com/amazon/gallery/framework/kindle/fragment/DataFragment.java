// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.app.Fragment;
import android.os.Bundle;

public class DataFragment extends Fragment
{

    private Object savedState;

    public DataFragment()
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

    public void setSavedState(Object obj)
    {
        savedState = obj;
    }
}
