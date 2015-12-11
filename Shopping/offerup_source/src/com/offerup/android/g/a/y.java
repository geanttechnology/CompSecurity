// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.t;
import android.support.v4.b.a;
import android.support.v4.view.ViewPager;
import android.support.v4.view.bb;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.Item;
import com.offerup.android.e.b;
import com.offerup.android.e.f;
import com.offerup.android.views.MaxSizeTextView;
import com.squareup.otto.Bus;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.g.a:
//            h, z, aa, af, 
//            ad, ae, ab, ac

public final class y extends h
{

    private View b;
    private TextView c;
    private MaxSizeTextView d;
    private ImageView e;
    private ImageView f;
    private View g;
    private TextView h;
    private Animation i;
    private RelativeLayout j;
    private TextView k;
    private ViewPager l;
    private bb m;
    private int n;
    private boolean o;
    private af p;
    private ae q;
    private Animation r;
    private android.view.View.OnClickListener s;

    public y()
    {
        o = false;
        p = null;
        q = null;
    }

    static int a(y y1, int i1)
    {
        y1.n = i1;
        return i1;
    }

    static ae a(y y1)
    {
        return y1.q;
    }

    public static y a()
    {
        return new y();
    }

    private void a(int i1)
    {
        if (g != null)
        {
            g.clearAnimation();
            h.setText(i1);
            g.startAnimation(r);
        }
    }

    private void a(boolean flag)
    {
        if (e != null && (o != flag || e.getDrawable() == null))
        {
            o = flag;
            ImageView imageview = e;
            android.graphics.drawable.Drawable drawable;
            if (flag)
            {
                drawable = android.support.v4.b.a.a(getContext(), 0x7f02014d);
            } else
            {
                drawable = android.support.v4.b.a.a(getContext(), 0x7f02014c);
            }
            imageview.setImageDrawable(drawable);
        }
    }

    private void b()
    {
        m = new z(this, getChildFragmentManager());
        l.setAdapter(m);
        l.a(new aa(this));
    }

    static void b(y y1)
    {
        y1.c();
    }

    static void b(y y1, int i1)
    {
        y1.a(i1);
    }

    static View c(y y1)
    {
        return y1.g;
    }

    private void c()
    {
        if (a == null || a.getPhotos() == null || a.getPhotos().length < 2)
        {
            k.setVisibility(4);
            return;
        } else
        {
            k.setText(String.format("%s/%s", new Object[] {
                Integer.valueOf(n + 1), Integer.valueOf(a.getPhotos().length)
            }));
            k.setVisibility(0);
            return;
        }
    }

    static void d(y y1)
    {
        y1.e.setOnClickListener(null);
        boolean flag;
        if (y1.o)
        {
            y1.p.f();
        } else
        {
            y1.p.a();
        }
        if (!y1.o)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        y1.a(flag);
    }

    static boolean e(y y1)
    {
        return y1.o;
    }

    static void f(y y1)
    {
        try
        {
            y1.e.startAnimation(y1.i);
            return;
        }
        catch (Exception exception)
        {
            com.b.a.a.g.a(y1, exception);
        }
    }

    static ImageView g(y y1)
    {
        return y1.e;
    }

    static View h(y y1)
    {
        return y1.b;
    }

    protected final void a(Item item)
    {
        boolean flag = false;
        m.c();
        b();
        c();
        Object obj;
        int i1;
        if (item.getListingType() == 1)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (c != null)
        {
            if (i1 != 0)
            {
                c.setText(0x7f09012c);
            } else
            {
                c.setText(0x7f0900ce);
            }
        }
        obj = item.getPrice();
        if (d != null)
        {
            boolean flag1;
            if (d.getText() != null)
            {
                if (!d.getText().equals(obj))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                flag1 = StringUtils.isNotEmpty(((CharSequence) (obj)));
            }
            if (flag1)
            {
                d.setText(((CharSequence) (obj)));
                d.invalidate();
                b.requestLayout();
                if (b != null)
                {
                    b.setVisibility(4);
                    obj = AnimationUtils.loadAnimation(getActivity(), 0x7f050014);
                    ((Animation) (obj)).setAnimationListener(new ad(this));
                    b.startAnimation(((Animation) (obj)));
                }
            }
        }
        a(item.isWatched());
        if (com.offerup.android.utils.a.a(a))
        {
            f.setImageDrawable(android.support.v4.b.a.a(getActivity(), 0x7f020150));
            j.setVisibility(0);
        } else
        {
            f.setImageDrawable(android.support.v4.b.a.a(getActivity(), 0x7f02014f));
            j.setVisibility(8);
        }
        if (!item.isWatched())
        {
            item = com.b.a.a.j.a();
            if (item.v())
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = item.w();
                int j1 = item.x() + 1;
                if (j1 >= 30)
                {
                    i1++;
                    item.h(i1);
                    item.i(0);
                    if (i1 >= 10)
                    {
                        com.b.a.a.j.a().h(true);
                    }
                    i1 = 1;
                } else
                {
                    item.i(j1);
                    i1 = ((flag) ? 1 : 0);
                }
            }
            if (i1 != 0)
            {
                a(0x7f09021f);
            }
        }
    }

    public final void addedToWatchlist(com.offerup.android.e.a a1)
    {
        if (a != null && a.getId() == a1.a())
        {
            a(true);
            e.setOnClickListener(s);
        }
    }

    public final void failedWatchlist(b b1)
    {
        if (a != null && a.getId() == b1.c())
        {
            a(b1.b());
            e.setOnClickListener(s);
            a(b1.a());
        }
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 2)
        {
            e.setOnClickListener(s);
        }
        super.onActivityResult(i1, j1, intent);
    }

    public final void onAttach(Context context)
    {
        super.onAttach(context);
        com.offerup.android.b.a.getInstance().register(this);
        try
        {
            p = (af)context;
        }
        catch (Exception exception)
        {
            throw new ClassCastException((new StringBuilder()).append(context.toString()).append(" must implement ProfileFragmentListener").toString());
        }
        try
        {
            q = (ae)context;
            return;
        }
        catch (Exception exception1)
        {
            throw new ClassCastException((new StringBuilder()).append(context.toString()).append(" must implement ProfileFragmentListener").toString());
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f04008d, viewgroup, false);
        f = (ImageView)layoutinflater.findViewById(0x7f100212);
        b = layoutinflater.findViewById(0x7f100211);
        c = (TextView)layoutinflater.findViewById(0x7f100214);
        d = (MaxSizeTextView)layoutinflater.findViewById(0x7f100215);
        e = (ImageView)layoutinflater.findViewById(0x7f10020f);
        j = (RelativeLayout)layoutinflater.findViewById(0x7f10020b);
        k = (TextView)layoutinflater.findViewById(0x7f1000d8);
        g = layoutinflater.findViewById(0x7f100210);
        h = (TextView)g.findViewById(0x7f1002c1);
        r = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), 0x7f05001a);
        r.setAnimationListener(new ab(this));
        s = new ac(this);
        i = AnimationUtils.loadAnimation(getActivity(), 0x7f05000e);
        e.setOnClickListener(s);
        l = (ViewPager)layoutinflater.findViewById(0x7f1000d5);
        b();
        return layoutinflater;
    }

    public final void onDetach()
    {
        com.offerup.android.b.a.getInstance().unregister(this);
        p = null;
        q = null;
        super.onDetach();
    }

    public final void onPause()
    {
        if (g != null)
        {
            g.clearAnimation();
        }
        if (e != null)
        {
            e.clearAnimation();
        }
        super.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        e.setOnClickListener(s);
        q.b(n);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("photo_index", n);
        super.onSaveInstanceState(bundle);
    }

    public final void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        if (bundle != null)
        {
            n = bundle.getInt("photo_index", 0);
        }
    }

    public final void removedFromWatchlist(f f1)
    {
        if (a != null && a.getId() == f1.a())
        {
            a(false);
            e.setOnClickListener(s);
        }
    }
}
