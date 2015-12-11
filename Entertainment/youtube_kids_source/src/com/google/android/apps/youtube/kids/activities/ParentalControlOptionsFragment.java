// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import xu;
import xv;
import xw;

public class ParentalControlOptionsFragment extends Fragment
{

    private View a;
    private View b;
    private View c;
    private View d;

    public ParentalControlOptionsFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f04004e, viewgroup, false);
        b = a.findViewById(0x7f10016d);
        c = a.findViewById(0x7f10016b);
        d = a.findViewById(0x7f10016c);
        b.setOnClickListener(new xu(this));
        c.setOnClickListener(new xv(this));
        d.setOnClickListener(new xw(this));
        return a;
    }
}
