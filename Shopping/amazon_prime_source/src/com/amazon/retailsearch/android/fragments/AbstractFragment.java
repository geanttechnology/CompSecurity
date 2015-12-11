// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class AbstractFragment
{

    public AbstractFragment()
    {
    }

    public abstract View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();
}
