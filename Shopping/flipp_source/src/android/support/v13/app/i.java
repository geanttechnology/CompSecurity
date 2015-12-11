// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ae;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v13.app:
//            a

public abstract class i extends ae
{

    private final FragmentManager b;
    private FragmentTransaction c;
    private ArrayList d;
    private ArrayList e;
    private Fragment f;

    public i(FragmentManager fragmentmanager)
    {
        c = null;
        d = new ArrayList();
        e = new ArrayList();
        f = null;
        b = fragmentmanager;
    }

    public abstract Fragment a(int j);

    public Object a(ViewGroup viewgroup, int j)
    {
        if (e.size() > j)
        {
            Fragment fragment = (Fragment)e.get(j);
            if (fragment != null)
            {
                return fragment;
            }
        }
        if (c == null)
        {
            c = b.beginTransaction();
        }
        Fragment fragment1 = a(j);
        if (d.size() > j)
        {
            android.app.Fragment.SavedState savedstate = (android.app.Fragment.SavedState)d.get(j);
            if (savedstate != null)
            {
                fragment1.setInitialSavedState(savedstate);
            }
        }
        for (; e.size() <= j; e.add(null)) { }
        android.support.v13.app.a.a(fragment1, false);
        android.support.v13.app.a.b(fragment1, false);
        e.set(j, fragment1);
        c.add(viewgroup.getId(), fragment1);
        return fragment1;
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

    public final void a(int j, Object obj)
    {
        obj = (Fragment)obj;
        if (c == null)
        {
            c = b.beginTransaction();
        }
        for (; d.size() <= j; d.add(null)) { }
        d.set(j, b.saveFragmentInstanceState(((Fragment) (obj))));
        e.set(j, null);
        c.remove(((Fragment) (obj)));
    }

    public final void a(Parcelable parcelable, ClassLoader classloader)
    {
        if (parcelable != null)
        {
            parcelable = (Bundle)parcelable;
            parcelable.setClassLoader(classloader);
            classloader = parcelable.getParcelableArray("states");
            d.clear();
            e.clear();
            if (classloader != null)
            {
                for (int j = 0; j < classloader.length; j++)
                {
                    d.add((android.app.Fragment.SavedState)classloader[j]);
                }

            }
            classloader = parcelable.keySet().iterator();
            do
            {
                if (!classloader.hasNext())
                {
                    break;
                }
                String s = (String)classloader.next();
                if (s.startsWith("f"))
                {
                    int k = Integer.parseInt(s.substring(1));
                    Fragment fragment = b.getFragment(parcelable, s);
                    if (fragment != null)
                    {
                        for (; e.size() <= k; e.add(null)) { }
                        android.support.v13.app.a.a(fragment, false);
                        e.set(k, fragment);
                    } else
                    {
                        Log.w("FragmentStatePagerAdapter", (new StringBuilder("Bad fragment at key ")).append(s).toString());
                    }
                }
            } while (true);
        }
    }

    public final void a(Object obj)
    {
        obj = (Fragment)obj;
        if (obj != f)
        {
            if (f != null)
            {
                android.support.v13.app.a.a(f, false);
                android.support.v13.app.a.b(f, false);
            }
            if (obj != null)
            {
                android.support.v13.app.a.a(((Fragment) (obj)), true);
                android.support.v13.app.a.b(((Fragment) (obj)), true);
            }
            f = ((Fragment) (obj));
        }
    }

    public final boolean a(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public final Parcelable b()
    {
        Object obj = null;
        if (d.size() > 0)
        {
            obj = new Bundle();
            android.app.Fragment.SavedState asavedstate[] = new android.app.Fragment.SavedState[d.size()];
            d.toArray(asavedstate);
            ((Bundle) (obj)).putParcelableArray("states", asavedstate);
        }
        for (int j = 0; j < e.size();)
        {
            Fragment fragment = (Fragment)e.get(j);
            Object obj1 = obj;
            if (fragment != null)
            {
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = new Bundle();
                }
                obj = (new StringBuilder("f")).append(j).toString();
                b.putFragment(((Bundle) (obj1)), ((String) (obj)), fragment);
            }
            j++;
            obj = obj1;
        }

        return ((Parcelable) (obj));
    }
}
