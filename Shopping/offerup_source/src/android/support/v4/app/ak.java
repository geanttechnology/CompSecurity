// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.bb;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.app:
//            aa, an, Fragment

public abstract class ak extends bb
{

    private final aa a;
    private an b;
    private Fragment c;

    public ak(aa aa1)
    {
        b = null;
        c = null;
        a = aa1;
    }

    private static String a(int i, long l)
    {
        return (new StringBuilder("android:switcher:")).append(i).append(":").append(l).toString();
    }

    public final Parcelable a()
    {
        return null;
    }

    public abstract Fragment a(int i);

    public final Object a(ViewGroup viewgroup, int i)
    {
        if (b == null)
        {
            b = a.a();
        }
        long l = i;
        Object obj = a(viewgroup.getId(), l);
        obj = a.a(((String) (obj)));
        if (obj != null)
        {
            b.e(((Fragment) (obj)));
            viewgroup = ((ViewGroup) (obj));
        } else
        {
            Fragment fragment = a(i);
            b.a(viewgroup.getId(), fragment, a(viewgroup.getId(), l));
            viewgroup = fragment;
        }
        if (viewgroup != c)
        {
            viewgroup.setMenuVisibility(false);
            viewgroup.setUserVisibleHint(false);
        }
        return viewgroup;
    }

    public final void a(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public final void a(ViewGroup viewgroup)
    {
        if (b != null)
        {
            b.c();
            b = null;
            a.b();
        }
    }

    public final void a(ViewGroup viewgroup, int i, Object obj)
    {
        if (b == null)
        {
            b = a.a();
        }
        b.d((Fragment)obj);
    }

    public final boolean a(View view, Object obj)
    {
        return ((Fragment)obj).getView() == view;
    }

    public final void b(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != c)
        {
            if (c != null)
            {
                c.setMenuVisibility(false);
                c.setUserVisibleHint(false);
            }
            if (viewgroup != null)
            {
                viewgroup.setMenuVisibility(true);
                viewgroup.setUserVisibleHint(true);
            }
            c = viewgroup;
        }
    }
}
