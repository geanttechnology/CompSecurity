// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public final class cm extends Fragment
{

    private int a;
    private View b;

    public cm()
    {
    }

    public static cm a(int i, View view)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("resource_id", i);
        cm cm1 = new cm();
        cm1.setArguments(bundle);
        cm1.b = view;
        return cm1;
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            bundle = getArguments();
        }
        if (bundle == null)
        {
            throw new IllegalArgumentException("Fragment arguments not provided.");
        } else
        {
            a = bundle.getInt("resource_id");
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == 0)
        {
            return null;
        }
        if (b != null)
        {
            return b;
        } else
        {
            b = layoutinflater.inflate(a, viewgroup, false);
            return b;
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("resource_id", a);
    }
}
