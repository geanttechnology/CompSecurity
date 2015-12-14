// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.picsart.profile.adapter.aw;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.cr.l;

public abstract class UserConnectionsFragment extends l
{

    protected aw c;
    protected boolean d;
    protected boolean m;
    protected boolean n;

    public UserConnectionsFragment()
    {
    }

    protected abstract a a(RecyclerViewAdapter recyclerviewadapter, long l1);

    public final void a(boolean flag)
    {
        d = flag;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 2)
        {
            a(false, true, true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        byte byte0 = 4;
        int i1 = 2;
        super.onCreate(bundle);
        aw aw1;
        int i;
        int j;
        int k;
        long l1;
        if (getArguments() != null)
        {
            i = getArguments().getInt("coverHeight", 0);
        } else
        {
            i = 0;
        }
        if (getArguments() != null)
        {
            j = getArguments().getInt("topScrollHeight", 0);
        } else
        {
            j = 0;
        }
        c = new aw(getActivity());
        c.setOnItemClickListener(new _cls1());
        bundle = c;
        aw1 = c;
        if (getArguments() != null)
        {
            l1 = getArguments().getLong("profileUserId");
        } else
        {
            l1 = 0L;
        }
        b(bundle, a(aw1, l1));
        k = getResources().getConfiguration().screenLayout & 0xf;
        if (k == 3 || k == 4)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (k != 0)
        {
            k = byte0;
        } else
        {
            k = 2;
            i1 = 1;
        }
        bundle = new h(getResources());
        bundle.f = i;
        bundle.g = j;
        bundle.h = false;
        bundle.e = getResources().getColor(0x7f0f009b);
        bundle.j = (int)getResources().getDimension(0x7f0b011f);
        bundle.d = k;
        bundle.k = false;
        bundle.b = i1;
        a(bundle.a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
        }).b());
    }

    /* member class not found */
    class _cls1 {}

}
