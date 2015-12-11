// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.af;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.shazam.android.fragment.home.d;
import java.util.List;

public class c extends g
{

    protected final com.shazam.android.fragment.home.c c;
    private final Resources d;
    private final SparseArray e;

    public c(com.shazam.android.fragment.home.c c1, Resources resources, k k)
    {
        this(c1, resources, k, false);
    }

    public c(com.shazam.android.fragment.home.c c1, Resources resources, k k, boolean flag)
    {
        super(k);
        c = c1;
        d = resources;
        e = new SparseArray();
        if (flag)
        {
            c1 = d();
            for (int i = 0; i < c1.size(); i++)
            {
                d(i);
            }

        }
    }

    private Fragment d(int i)
    {
        Fragment fragment = e(i).a().a();
        e.put(i, fragment);
        return fragment;
    }

    private List d()
    {
        return c.b();
    }

    private d e(int i)
    {
        return (d)d().get(i);
    }

    public final Fragment a(int i)
    {
        Fragment fragment = (Fragment)e.get(i);
        if (fragment != null)
        {
            return fragment;
        } else
        {
            return d(i);
        }
    }

    public final void a(Parcelable parcelable, ClassLoader classloader)
    {
        super.a(parcelable, classloader);
        parcelable = super.a;
        e.clear();
        for (int i = 0; i < parcelable.size(); i++)
        {
            e.put(i, parcelable.get(i));
        }

    }

    public final void a(ViewGroup viewgroup, int i, Object obj)
    {
        super.a(viewgroup, i, obj);
        e.remove(i);
    }

    public final CharSequence b(int i)
    {
        return e(i).a(d);
    }

    public final int c()
    {
        return d().size();
    }

    public final Fragment c(int i)
    {
        return (Fragment)e.get(i);
    }
}
