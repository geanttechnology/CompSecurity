// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import aim;
import aiw;
import ajh;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.google.android.gms.maps.SupportMapFragment;

public class MapBaseFragment extends SupportMapFragment
    implements aiw
{

    private aim a;
    private BBYBaseFragment b;

    public MapBaseFragment()
    {
    }

    public static MapBaseFragment a(BBYBaseFragment bbybasefragment)
    {
        MapBaseFragment mapbasefragment = new MapBaseFragment();
        mapbasefragment.b = bbybasefragment;
        return mapbasefragment;
    }

    public void a()
    {
        a(((aiw) (this)));
    }

    public void a(aim aim1)
    {
        a = aim1;
        if (a != null)
        {
            a.c().a(false);
            a.a(false);
        }
        if (b != null)
        {
            b.b_();
        }
    }

    public aim b()
    {
        return a;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        a();
        return layoutinflater;
    }
}
