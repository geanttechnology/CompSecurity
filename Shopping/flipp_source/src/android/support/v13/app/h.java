// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.view.ae;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v13.app:
//            a

public abstract class h extends ae
{

    private final FragmentManager b;
    private FragmentTransaction c;
    private Fragment d;

    public h(FragmentManager fragmentmanager)
    {
        c = null;
        d = null;
        b = fragmentmanager;
    }

    private static String a(int i, long l)
    {
        return (new StringBuilder("android:switcher:")).append(i).append(":").append(l).toString();
    }

    public abstract Fragment a(int i);

    public final Object a(ViewGroup viewgroup, int i)
    {
        if (c == null)
        {
            c = b.beginTransaction();
        }
        long l = i;
        Object obj = a(viewgroup.getId(), l);
        obj = b.findFragmentByTag(((String) (obj)));
        if (obj != null)
        {
            c.attach(((Fragment) (obj)));
            viewgroup = ((ViewGroup) (obj));
        } else
        {
            Fragment fragment = a(i);
            c.add(viewgroup.getId(), fragment, a(viewgroup.getId(), l));
            viewgroup = fragment;
        }
        if (viewgroup != d)
        {
            android.support.v13.app.a.a(viewgroup, false);
            android.support.v13.app.a.b(viewgroup, false);
        }
        return viewgroup;
    }

    public final void a()
    {
        if (c != null)
        {
            c.commitAllowingStateLoss();
            c = null;
            b.executePendingTransactions();
        }
    }

    public final void a(int i, Object obj)
    {
        if (c == null)
        {
            c = b.beginTransaction();
        }
        c.detach((Fragment)obj);
    }

    public final void a(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public final void a(Object obj)
    {
        obj = (Fragment)obj;
        if (obj != d)
        {
            if (d != null)
            {
                android.support.v13.app.a.a(d, false);
                android.support.v13.app.a.b(d, false);
            }
            if (obj != null)
            {
                android.support.v13.app.a.a(((Fragment) (obj)), true);
                android.support.v13.app.a.b(((Fragment) (obj)), true);
            }
            d = ((Fragment) (obj));
        }
    }

    public final boolean a(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public final Parcelable b()
    {
        return null;
    }
}
