// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.net.a;
import com.socialin.android.photo.h;
import com.socialin.android.photo.i;
import myobfuscated.cb.c;
import myobfuscated.cb.d;
import myobfuscated.f.m;

public abstract class j extends Fragment
    implements i, com.socialin.android.photo.j
{

    public int a;
    protected int b[][];
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    protected boolean h;
    public boolean i;
    public c j;
    public d k;
    public Intent l;
    a m;
    public h n;
    private boolean o;

    public j()
    {
        a = 0;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = true;
        h = false;
        i = false;
        l = null;
        o = false;
    }

    public abstract String a(int i1, int j1);

    public abstract String a(int i1, int j1, Context context);

    public void a(int i1)
    {
    }

    public abstract void a(Intent intent, c c1);

    public final String b(int i1)
    {
        return a(a, i1);
    }

    public final String c(int i1)
    {
        android.app.Activity activity = getActivity();
        if (activity == null)
        {
            return "";
        } else
        {
            return a(a, i1, activity);
        }
    }

    public abstract int d(int i1);

    public final View e(int i1)
    {
        return getView().findViewById(i1);
    }

    public final void f(int i1)
    {
        if (getActivity() == null)
        {
            return;
        }
        if (m == null)
        {
            m = myobfuscated.f.m.b(getActivity());
        }
        if (n == null)
        {
            o = true;
            return;
        } else
        {
            com.socialin.android.photo.h.a(this, i1, m);
            return;
        }
    }

    public final int getCount()
    {
        return d(a);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        AnalyticUtils.getInstance(getActivity()).trackLocalAction("SelectedCategoryBaseFragment:onActivityCreated");
        if (l != null)
        {
            a(l, ((c) (null)));
            l = null;
        }
        m = myobfuscated.f.m.b(getActivity());
        n = new h(getActivity(), this);
        if (o)
        {
            o = false;
            f(-1);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public void onStart()
    {
        super.onStart();
        if (m != null)
        {
            m.a(n);
        }
    }

    public void onStop()
    {
        super.onStop();
        if (m != null)
        {
            m.b();
        }
    }
}
