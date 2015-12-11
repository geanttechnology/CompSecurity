// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.t;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.a.aa;
import com.offerup.android.activities.MyOffersActivity;
import com.offerup.android.h.a;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.g:
//            f

public class ba extends Fragment
    implements a
{

    private RecyclerView a;
    private aa b;
    private StaggeredGridLayoutManager c;
    private View d;
    private List e;

    public ba()
    {
    }

    public final void a()
    {
        e = null;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        b.a();
        b.notifyDataSetChanged();
        return;
        Exception exception;
        exception;
        g.a(com/offerup/android/g/ba.getSimpleName(), exception);
        return;
    }

    public final void a(List list)
    {
        e = list;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        b.a();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (list.size() > 0)
        {
            j.a().h(true);
        }
        b.a(list);
        b.notifyDataSetChanged();
_L2:
        if (getActivity() != null)
        {
            getActivity();
        }
        return;
        list;
        g.a(com/offerup/android/g/f.getSimpleName(), list);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void b(int i)
    {
        ((MyOffersActivity)getActivity()).b(i);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        d = layoutinflater.inflate(0x7f0400a0, viewgroup, false);
        a = (RecyclerView)d.findViewById(0x7f1001e1);
        b = new aa(this, getActivity().getApplicationContext(), new ArrayList());
        c = new StaggeredGridLayoutManager(getResources().getInteger(0x7f0d0004), 1);
        a.setLayoutManager(c);
        a.setAdapter(b);
        if (e != null)
        {
            a(e);
        }
        return d;
    }
}
