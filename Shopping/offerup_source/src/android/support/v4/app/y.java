// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v4.g.l;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            z, ab, Fragment, aa, 
//            ax

public final class y
{

    private final z a;

    private y(z z1)
    {
        a = z1;
    }

    public static final y a(z z1)
    {
        return new y(z1);
    }

    public final aa a()
    {
        return a.b;
    }

    public final View a(View view, String s1, Context context, AttributeSet attributeset)
    {
        return a.b.onCreateView(view, s1, context, attributeset);
    }

    public final List a(List list)
    {
        if (a.b.b == null)
        {
            return null;
        } else
        {
            list.addAll(a.b.b);
            return list;
        }
    }

    public final void a(Configuration configuration)
    {
        a.b.a(configuration);
    }

    public final void a(Parcelable parcelable, List list)
    {
        a.b.a(parcelable, list);
    }

    public final void a(Fragment fragment)
    {
        a.b.a(a, a, null);
    }

    public final void a(l l1)
    {
        a.a(l1);
    }

    public final void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        a.b(s1, filedescriptor, printwriter, as);
    }

    public final void a(boolean flag)
    {
        a.a(flag);
    }

    public final boolean a(Menu menu)
    {
        return a.b.a(menu);
    }

    public final boolean a(Menu menu, MenuInflater menuinflater)
    {
        return a.b.a(menu, menuinflater);
    }

    public final boolean a(MenuItem menuitem)
    {
        return a.b.a(menuitem);
    }

    public final ax b()
    {
        return a.j();
    }

    public final void b(Menu menu)
    {
        a.b.b(menu);
    }

    public final boolean b(MenuItem menuitem)
    {
        return a.b.b(menuitem);
    }

    public final int c()
    {
        ArrayList arraylist = a.b.b;
        if (arraylist == null)
        {
            return 0;
        } else
        {
            return arraylist.size();
        }
    }

    public final void d()
    {
        a.b.k = false;
    }

    public final Parcelable e()
    {
        return a.b.g();
    }

    public final List f()
    {
        ab ab1 = a.b;
        ArrayList arraylist1 = null;
        ArrayList arraylist = null;
        if (ab1.b != null)
        {
            int i1 = 0;
            do
            {
                arraylist1 = arraylist;
                if (i1 >= ab1.b.size())
                {
                    break;
                }
                Fragment fragment = (Fragment)ab1.b.get(i1);
                arraylist1 = arraylist;
                if (fragment != null)
                {
                    arraylist1 = arraylist;
                    if (fragment.mRetainInstance)
                    {
                        arraylist1 = arraylist;
                        if (arraylist == null)
                        {
                            arraylist1 = new ArrayList();
                        }
                        arraylist1.add(fragment);
                        fragment.mRetaining = true;
                        int j1;
                        if (fragment.mTarget != null)
                        {
                            j1 = fragment.mTarget.mIndex;
                        } else
                        {
                            j1 = -1;
                        }
                        fragment.mTargetIndex = j1;
                    }
                }
                i1++;
                arraylist = arraylist1;
            } while (true);
        }
        return arraylist1;
    }

    public final void g()
    {
        a.b.h();
    }

    public final void h()
    {
        a.b.i();
    }

    public final void i()
    {
        a.b.j();
    }

    public final void j()
    {
        a.b.k();
    }

    public final void k()
    {
        a.b.a(4, false);
    }

    public final void l()
    {
        a.b.l();
    }

    public final void m()
    {
        a.b.a(2, false);
    }

    public final void n()
    {
        a.b.m();
    }

    public final void o()
    {
        a.b.n();
    }

    public final boolean p()
    {
        return a.b.f();
    }

    public final void q()
    {
        a.k();
    }

    public final void r()
    {
        a.l();
    }

    public final void s()
    {
        a.m();
    }

    public final l t()
    {
        return a.n();
    }
}
