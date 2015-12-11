// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.follow;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.shazam.a.g;
import com.shazam.android.aw.a.a.a;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.k.b.e;
import com.shazam.android.k.b.i;
import com.shazam.android.util.q;
import com.shazam.android.util.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.h.b;
import com.shazam.g.c;
import com.shazam.i.d.d;
import java.util.List;

public class FollowingsActivity extends AutoToolbarBaseAppCompatActivity
    implements b, com.shazam.p.j.b
{

    private final g a = com.shazam.i.c.b.a();
    private final com.shazam.android.j.w.c b = com.shazam.i.b.n.b.E();
    private final com.shazam.b.a.a c = com.shazam.i.d.d.H();
    private final q d = r.b();
    private final s e = com.shazam.i.b.au.d.a();
    private AnimatorViewFlipper f;
    private com.shazam.android.a.e.a g;
    private com.shazam.l.h.b h;
    private boolean i;
    private boolean j;

    public FollowingsActivity()
    {
    }

    public final void a()
    {
        e.a(d);
        finish();
    }

    public final void a(List list)
    {
        com.shazam.android.a.e.a a1 = g;
        ((a) (a1)).d.clear();
        ((a) (a1)).d.addAll(list);
        ((android.support.v7.widget.RecyclerView.a) (a1)).a.a();
    }

    public final void a(boolean flag)
    {
        AnimatorViewFlipper animatorviewflipper = f;
        int k;
        if (flag)
        {
            k = 0x7f1100d4;
        } else
        {
            k = 0x7f1100d3;
        }
        animatorviewflipper.setDisplayedChildById(k);
    }

    public final void b()
    {
        j = false;
    }

    public final void b(List list)
    {
        com.shazam.android.a.e.a a1 = g;
        int k = ((a) (a1)).d.size();
        ((a) (a1)).d.addAll(list);
        a1.a(k, list.size());
    }

    public final void b(boolean flag)
    {
        j = flag;
    }

    public final void c(boolean flag)
    {
        i = flag;
    }

    public final boolean c()
    {
        return i;
    }

    public final boolean d()
    {
        return j;
    }

    public final void e()
    {
        j = true;
        com.shazam.l.h.b b1 = h;
        boolean flag;
        if (b1.e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b1.a.b(true);
            b1.c.a(b1.e);
            b1.c.a(new com.shazam.l.h.b.b(b1, (byte)0));
            b1.c.a();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030021);
        g = new com.shazam.android.a.e.a(this);
        h = new com.shazam.l.h.b(this, new com.shazam.android.k.b.a(getSupportLoaderManager(), 10023, this, new com.shazam.android.k.e.b.d(a, b), i.b), new e(getSupportLoaderManager(), this, new com.shazam.android.k.e.b.d(a, b), i.b), c);
        f = (AnimatorViewFlipper)findViewById(0x7f1100d2);
        bundle = (RecyclerView)findViewById(0x7f1100d3);
        bundle.setOnScrollListener(new com.shazam.android.widget.h.c(this));
        bundle.setLayoutManager(new LinearLayoutManager());
        bundle.setAdapter(g);
        bundle = h;
        ((com.shazam.l.h.b) (bundle)).a.a(true);
        ((com.shazam.l.h.b) (bundle)).b.a(new com.shazam.l.h.b.a(bundle, (byte)0));
        ((com.shazam.l.h.b) (bundle)).b.a();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            finish();
            break;
        }
        return true;
    }
}
