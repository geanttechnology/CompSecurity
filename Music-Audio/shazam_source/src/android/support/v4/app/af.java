// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            Fragment, k, m

public abstract class af extends t
{

    public final ArrayList a = new ArrayList();
    private final k c;
    private m d;
    private final ArrayList e = new ArrayList();
    private Fragment f;

    public af(k k1)
    {
        d = null;
        f = null;
        c = k1;
    }

    public abstract Fragment a(int i);

    public Object a(ViewGroup viewgroup, int i)
    {
        if (a.size() > i)
        {
            Fragment fragment = (Fragment)a.get(i);
            if (fragment != null)
            {
                return fragment;
            }
        }
        if (d == null)
        {
            d = c.a();
        }
        Fragment fragment1 = a(i);
        if (e.size() > i)
        {
            Fragment.SavedState savedstate = (Fragment.SavedState)e.get(i);
            if (savedstate != null)
            {
                fragment1.setInitialSavedState(savedstate);
            }
        }
        for (; a.size() <= i; a.add(null)) { }
        fragment1.setMenuVisibility(false);
        fragment1.setUserVisibleHint(false);
        a.set(i, fragment1);
        d.a(viewgroup.getId(), fragment1);
        return fragment1;
    }

    public final void a()
    {
        if (d != null)
        {
            d.b();
            d = null;
            c.b();
        }
    }

    public void a(Parcelable parcelable, ClassLoader classloader)
    {
        if (parcelable != null)
        {
            parcelable = (Bundle)parcelable;
            parcelable.setClassLoader(classloader);
            classloader = parcelable.getParcelableArray("states");
            e.clear();
            a.clear();
            if (classloader != null)
            {
                int l = classloader.length;
                for (int i = 0; i < l; i++)
                {
                    Object obj = classloader[i];
                    e.add((Fragment.SavedState)obj);
                }

            }
            classloader = parcelable.keySet().iterator();
            do
            {
                if (!classloader.hasNext())
                {
                    break;
                }
                Object obj1 = (String)classloader.next();
                if (((String) (obj1)).startsWith("f"))
                {
                    int j = Integer.parseInt(((String) (obj1)).substring(1));
                    obj1 = c.a(parcelable, ((String) (obj1)));
                    if (obj1 != null)
                    {
                        for (; a.size() <= j; a.add(null)) { }
                        ((Fragment) (obj1)).setMenuVisibility(false);
                        a.set(j, obj1);
                    }
                }
            } while (true);
        }
    }

    public void a(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (d == null)
        {
            d = c.a();
        }
        for (; e.size() <= i; e.add(null)) { }
        e.set(i, c.a(viewgroup));
        a.set(i, null);
        d.a(viewgroup);
    }

    public final void a(Object obj)
    {
        obj = (Fragment)obj;
        if (obj != f)
        {
            if (f != null)
            {
                f.setMenuVisibility(false);
                f.setUserVisibleHint(false);
            }
            if (obj != null)
            {
                ((Fragment) (obj)).setMenuVisibility(true);
                ((Fragment) (obj)).setUserVisibleHint(true);
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
        if (!e.isEmpty())
        {
            obj = new Bundle();
            Fragment.SavedState asavedstate[] = new Fragment.SavedState[e.size()];
            e.toArray(asavedstate);
            ((Bundle) (obj)).putParcelableArray("states", asavedstate);
        }
        for (int i = 0; i < a.size();)
        {
            Fragment fragment = (Fragment)a.get(i);
            Object obj1 = obj;
            if (fragment != null)
            {
                obj1 = obj;
                if (obj == null)
                {
                    obj1 = new Bundle();
                }
                obj = (new StringBuilder("f")).append(i).toString();
                c.a(((Bundle) (obj1)), ((String) (obj)), fragment);
            }
            i++;
            obj = obj1;
        }

        return ((Parcelable) (obj));
    }
}
