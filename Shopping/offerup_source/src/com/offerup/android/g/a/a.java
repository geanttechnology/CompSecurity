// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.offerup.android.activities.LoginActivity;
import com.offerup.android.dto.Item;
import com.offerup.android.e.b;
import com.offerup.android.e.f;
import com.offerup.android.utils.ba;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.g.a:
//            h, af, f, g, 
//            e, d, c, b

public final class a extends h
{

    private com.offerup.android.g.a.f b;
    private af c;
    private g d;
    private boolean e;
    private String f;
    private String g;
    private View h;
    private View i;
    private View j;
    private TextView k;
    private android.view.View.OnClickListener l;

    public a()
    {
        e = false;
    }

    public static a a()
    {
        return new a();
    }

    static com.offerup.android.g.a.f a(a a1)
    {
        return a1.b;
    }

    private void a(boolean flag)
    {
        if (e != flag)
        {
            e = flag;
            k.setText(b(flag));
        }
    }

    static g b(a a1)
    {
        return a1.d;
    }

    private String b(boolean flag)
    {
        if (flag)
        {
            return g;
        } else
        {
            return f;
        }
    }

    static af c(a a1)
    {
        return a1.c;
    }

    static void d(a a1)
    {
        a1.j.setOnClickListener(null);
        boolean flag;
        if (a1.e)
        {
            a1.c.f();
        } else
        {
            a1.c.a();
        }
        if (!a1.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.a(flag);
    }

    static void e(a a1)
    {
        a1.j.setOnClickListener(null);
        a1.startActivityForResult(new Intent(a1.getActivity(), com/offerup/android/activities/LoginActivity), 2);
    }

    protected final void a(Item item)
    {
        a(item.isWatched());
        if (ba.a(item))
        {
            h.setVisibility(8);
            i.setVisibility(8);
            return;
        }
        if (com.offerup.android.utils.a.a(item))
        {
            h.setVisibility(0);
            i.setVisibility(8);
            return;
        } else
        {
            h.setVisibility(0);
            i.setVisibility(0);
            return;
        }
    }

    public final void addedToWatchlist(com.offerup.android.e.a a1)
    {
        if (a != null && a1.a() == a.getId())
        {
            a(true);
            j.setOnClickListener(l);
        }
    }

    public final void failedWatchlist(b b1)
    {
        if (a != null && b1.c() == a.getId())
        {
            a(b1.b());
            j.setOnClickListener(l);
        }
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        com.offerup.android.b.a.getInstance().register(this);
        try
        {
            b = (com.offerup.android.g.a.f)context;
        }
        catch (Exception exception)
        {
            throw new ClassCastException((new StringBuilder()).append(context.toString()).append(" must implement ActionFragmentListener").toString());
        }
        try
        {
            c = (af)context;
        }
        catch (Exception exception1)
        {
            throw new ClassCastException((new StringBuilder()).append(context.toString()).append(" must implement WatchListener").toString());
        }
        try
        {
            d = (g)context;
            return;
        }
        catch (Exception exception2)
        {
            throw new ClassCastException((new StringBuilder()).append(context.toString()).append(" must implement OnShareListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f040088, viewgroup, false);
        j = layoutinflater.findViewById(0x7f1001f9);
        viewgroup = j;
        f = getString(0x7f0900b0);
        g = getString(0x7f0900af);
        if (viewgroup != null)
        {
            k = (TextView)viewgroup.findViewById(0x7f1001fb);
            l = new e(this);
            viewgroup.setOnClickListener(l);
        }
        i = layoutinflater.findViewById(0x7f1001fc);
        viewgroup = i;
        if (viewgroup != null)
        {
            viewgroup.setOnClickListener(new d(this));
        }
        viewgroup = layoutinflater.findViewById(0x7f1001fe);
        if (viewgroup != null)
        {
            viewgroup.setOnClickListener(new c(this));
        }
        h = layoutinflater.findViewById(0x7f100200);
        viewgroup = h;
        if (viewgroup != null)
        {
            viewgroup.setOnClickListener(new com.offerup.android.g.a.b(this));
        }
        return layoutinflater;
    }

    public final void onDetach()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        super.onDetach();
    }

    public final void onResume()
    {
        super.onResume();
        j.setOnClickListener(l);
        k.setText(b(e));
    }

    public final void removedFromWatchlist(f f1)
    {
        if (a != null && f1.a() == a.getId())
        {
            a(false);
            j.setOnClickListener(l);
        }
    }
}
