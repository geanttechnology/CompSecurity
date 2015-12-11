// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aw.a.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shazam.android.base.fragments.BaseFragment;

public class b extends BaseFragment
{

    private final Handler a = new Handler();
    public ListAdapter b;
    AbsListView c;
    public View d;
    public View e;
    View f;
    boolean g;
    private final Runnable h = new _cls1();
    private final android.widget.AdapterView.OnItemClickListener i = new _cls2();

    public b()
    {
    }

    private void a()
    {
        if (c != null)
        {
            return;
        }
        if (!p())
        {
            throw new IllegalStateException("Content view not yet created");
        }
        Object obj = getView();
        if (obj instanceof AbsListView)
        {
            c = (AbsListView)obj;
        } else
        {
            d = ((View) (obj)).findViewById(0x1020004);
            e = ((View) (obj)).findViewById(0x7f110148);
            f = ((View) (obj)).findViewById(0x7f110149);
            obj = ((View) (obj)).findViewById(0x102000a);
            if (!(obj instanceof AbsListView))
            {
                if (obj == null)
                {
                    throw new RuntimeException("Your content must have a AbsListView whose id attribute is 'android.R.id.list'");
                } else
                {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a AbsListView class");
                }
            }
            c = (AbsListView)obj;
            c.setEmptyView(d);
        }
        g = true;
        c.setOnItemClickListener(i);
        if (b == null) goto _L2; else goto _L1
_L1:
        obj = b;
        b = null;
        a(((ListAdapter) (obj)));
_L4:
        a.post(h);
        return;
_L2:
        if (e != null)
        {
            a(false, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(ListAdapter listadapter)
    {
        boolean flag1 = false;
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = listadapter;
        if (c != null)
        {
            c.setAdapter(listadapter);
            if (!g && !flag)
            {
                if (getView().getWindowToken() != null)
                {
                    flag1 = true;
                }
                a(true, flag1);
            }
        }
    }

    public final void a(boolean flag, boolean flag1)
    {
        a();
        if (e == null)
        {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (g == flag)
        {
            return;
        }
        g = flag;
        if (flag)
        {
            if (flag1)
            {
                e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
                f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            } else
            {
                e.clearAnimation();
                f.clearAnimation();
            }
            e.setVisibility(8);
            f.setVisibility(0);
            return;
        }
        if (flag1)
        {
            e.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0000));
            f.startAnimation(AnimationUtils.loadAnimation(getActivity(), 0x10a0001));
        } else
        {
            e.clearAnimation();
            f.clearAnimation();
        }
        e.setVisibility(0);
        f.setVisibility(8);
    }

    public final AbsListView o()
    {
        a();
        return c;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = getActivity();
        layoutinflater = new FrameLayout(viewgroup);
        bundle = new LinearLayout(viewgroup);
        bundle.setId(0x7f110148);
        bundle.setOrientation(1);
        bundle.setVisibility(8);
        bundle.setGravity(17);
        bundle.addView(new ProgressBar(viewgroup, null, 0x101007a), new android.widget.FrameLayout.LayoutParams(-2, -2));
        layoutinflater.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        viewgroup = new FrameLayout(viewgroup);
        viewgroup.setId(0x7f110149);
        if (d == null)
        {
            bundle = new TextView(getActivity());
            bundle.setId(0x1020004);
            bundle.setGravity(17);
            d = bundle;
        } else
        {
            d.setId(0x1020004);
        }
        viewgroup.addView(d, new android.widget.FrameLayout.LayoutParams(-1, -1));
        bundle = new ListView(getActivity());
        bundle.setId(0x102000a);
        bundle.setDrawSelectorOnTop(false);
        viewgroup.addView(bundle, new android.widget.FrameLayout.LayoutParams(-1, -1));
        layoutinflater.addView(viewgroup, new android.widget.FrameLayout.LayoutParams(-1, -1));
        layoutinflater.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        return layoutinflater;
    }

    public void onDestroyView()
    {
        a.removeCallbacks(h);
        c = null;
        g = false;
        f = null;
        e = null;
        d = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (p())
        {
            bundle.putInt("com.shazam.android.betterListFragment.listPosition", o().getFirstVisiblePosition());
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a();
    }

    public final boolean p()
    {
        return getView() != null;
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
