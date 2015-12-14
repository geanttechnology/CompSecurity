// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.picsart.studio.view.g;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.picsart.shop:
//            r, o, f, g, 
//            s

public final class q extends PagerAdapter
    implements g
{

    int a;
    private List b;
    private Activity c;
    private Fragment d;
    private FragmentTransaction e;
    private FragmentManager f;
    private LayoutInflater g;
    private android.support.v7.widget.RecyclerView.OnScrollListener h;
    private s i;

    public q(Activity activity, FragmentManager fragmentmanager, android.support.v7.widget.RecyclerView.OnScrollListener onscrolllistener, s s, int j)
    {
        b = new ArrayList();
        d = null;
        g = null;
        h = null;
        i = null;
        a = 0;
        f = fragmentmanager;
        c = activity;
        g = c.getLayoutInflater();
        a = j;
        h = onscrolllistener;
        i = s;
    }

    public final Fragment a(int j)
    {
        Fragment fragment1 = f.findFragmentByTag(((r)b.get(j)).d);
        Fragment fragment = fragment1;
        if (fragment1 == null)
        {
            r r1 = (r)b.get(j);
            fragment = Fragment.instantiate(c, r1.a.getName(), r1.b);
            fragment.setRetainInstance(true);
            r1.d = (new StringBuilder("PagerFragment.")).append(j).toString();
        }
        if (fragment instanceof o)
        {
            o o1 = (o)fragment;
            o1.b = h;
            o1.e = i;
            o1.a(a, false);
        } else
        if (fragment instanceof f)
        {
            f f1 = (f)fragment;
            android.support.v7.widget.RecyclerView.OnScrollListener onscrolllistener = h;
            f1.c = onscrolllistener;
            if (f1.a != null)
            {
                f1.a.setOnScrollListener(onscrolllistener);
            }
            j = a;
            f1.b.a = j;
            return fragment;
        }
        return fragment;
    }

    public final View a(int j, ViewGroup viewgroup)
    {
        viewgroup = (TextView)g.inflate(0x7f030256, viewgroup, false);
        viewgroup.setText(c(j));
        viewgroup.setId(((r)b.get(j)).e);
        return viewgroup;
    }

    public final void a(CharSequence charsequence, Class class1, Bundle bundle, int j)
    {
        charsequence = new r(class1, bundle, charsequence, j);
        b.add(charsequence);
    }

    public final Fragment b(int j)
    {
        Fragment fragment;
        try
        {
            fragment = f.findFragmentByTag(((r)b.get(j)).d);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return fragment;
    }

    public final CharSequence c(int j)
    {
        return ((r)b.get(j)).c;
    }

    public final void destroyItem(ViewGroup viewgroup, int j, Object obj)
    {
        if (e == null)
        {
            e = f.beginTransaction();
        }
        e.detach((Fragment)obj);
    }

    public final void finishUpdate(ViewGroup viewgroup)
    {
        if (e != null)
        {
            e.commitAllowingStateLoss();
            e = null;
            f.executePendingTransactions();
        }
    }

    public final int getCount()
    {
        return b.size();
    }

    public final int getItemPosition(Object obj)
    {
        return super.getItemPosition(obj);
    }

    public final Object instantiateItem(ViewGroup viewgroup, int j)
    {
        if (e == null)
        {
            e = f.beginTransaction();
        }
        Object obj = ((r)b.get(j)).d;
        obj = f.findFragmentByTag(((String) (obj)));
        if (obj != null)
        {
            e.attach(((Fragment) (obj)));
            viewgroup = ((ViewGroup) (obj));
        } else
        {
            Fragment fragment = a(j);
            e.add(viewgroup.getId(), fragment, (new StringBuilder("PagerFragment.")).append(j).toString());
            viewgroup = fragment;
        }
        if (viewgroup != d)
        {
            viewgroup.setMenuVisibility(false);
            viewgroup.setUserVisibleHint(false);
        }
        return viewgroup;
    }

    public final boolean isViewFromObject(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public final Parcelable saveState()
    {
        return null;
    }

    public final void setPrimaryItem(ViewGroup viewgroup, int j, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != d)
        {
            d = viewgroup;
        }
    }

    public final void startUpdate(ViewGroup viewgroup)
    {
    }
}
