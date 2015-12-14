// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.socialin.android.picsart.profile.invite.f;
import com.socialin.android.picsart.profile.invite.i;
import java.util.ArrayList;
import java.util.List;

public final class l extends f
{

    private static List e = new ArrayList();

    public l()
    {
    }

    public final void a()
    {
        if (e != null)
        {
            e.clear();
        }
        e = null;
    }

    public final void a(List list)
    {
        if (e == null)
        {
            e = new ArrayList();
        }
        e.addAll(list);
    }

    public final List b()
    {
        return e;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        c = (EditText)getView().findViewById(0x7f1008e6);
        b = (RecyclerView)getView().findViewById(0x7f1008e9);
        super.a = false;
        i.i();
        super.onActivityCreated(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301f0, viewgroup, false);
    }

}
