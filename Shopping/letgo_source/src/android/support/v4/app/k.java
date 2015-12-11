// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.ad;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.app:
//            i, m, Fragment

public abstract class k extends ad
{

    private final i a;
    private m b;
    private Fragment c;

    public k(i j)
    {
        b = null;
        c = null;
        a = j;
    }

    private static String a(int j, long l)
    {
        return (new StringBuilder()).append("android:switcher:").append(j).append(":").append(l).toString();
    }

    public Parcelable a()
    {
        return null;
    }

    public abstract Fragment a(int j);

    public Object a(ViewGroup viewgroup, int j)
    {
        if (b == null)
        {
            b = a.a();
        }
        long l = b(j);
        Object obj = a(viewgroup.getId(), l);
        obj = a.a(((String) (obj)));
        if (obj != null)
        {
            b.c(((Fragment) (obj)));
            viewgroup = ((ViewGroup) (obj));
        } else
        {
            Fragment fragment = a(j);
            b.a(viewgroup.getId(), fragment, a(viewgroup.getId(), l));
            viewgroup = fragment;
        }
        if (viewgroup != c)
        {
            viewgroup.e(false);
            viewgroup.f(false);
        }
        return viewgroup;
    }

    public void a(Parcelable parcelable, ClassLoader classloader)
    {
    }

    public void a(ViewGroup viewgroup)
    {
    }

    public void a(ViewGroup viewgroup, int j, Object obj)
    {
        if (b == null)
        {
            b = a.a();
        }
        b.b((Fragment)obj);
    }

    public boolean a(View view, Object obj)
    {
        return ((Fragment)obj).t() == view;
    }

    public long b(int j)
    {
        return (long)j;
    }

    public void b(ViewGroup viewgroup)
    {
        if (b != null)
        {
            b.b();
            b = null;
            a.b();
        }
    }

    public void b(ViewGroup viewgroup, int j, Object obj)
    {
        viewgroup = (Fragment)obj;
        if (viewgroup != c)
        {
            if (c != null)
            {
                c.e(false);
                c.f(false);
            }
            if (viewgroup != null)
            {
                viewgroup.e(true);
                viewgroup.f(true);
            }
            c = viewgroup;
        }
    }
}
