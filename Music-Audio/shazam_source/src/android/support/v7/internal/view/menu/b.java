// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            l, m, f, h, 
//            p

public abstract class b
    implements l
{

    public Context a;
    public Context b;
    public f c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    public l.a f;
    public m g;
    public int h;
    private int i;
    private int j;

    public b(Context context, int k, int i1)
    {
        a = context;
        d = LayoutInflater.from(context);
        i = k;
        j = i1;
    }

    public m a(ViewGroup viewgroup)
    {
        if (g == null)
        {
            g = (m)d.inflate(i, viewgroup, false);
            g.a(c);
            b(true);
        }
        return g;
    }

    public View a(h h1, View view, ViewGroup viewgroup)
    {
        if (view instanceof m.a)
        {
            view = (m.a)view;
        } else
        {
            view = (m.a)d.inflate(j, viewgroup, false);
        }
        a(h1, ((m.a) (view)));
        return (View)view;
    }

    public void a(Context context, f f1)
    {
        b = context;
        e = LayoutInflater.from(b);
        c = f1;
    }

    public void a(f f1, boolean flag)
    {
        if (f != null)
        {
            f.a(f1, flag);
        }
    }

    public abstract void a(h h1, m.a a1);

    public boolean a()
    {
        return false;
    }

    public boolean a(h h1)
    {
        return true;
    }

    public boolean a(p p)
    {
        if (f != null)
        {
            return f.a(p);
        } else
        {
            return false;
        }
    }

    public boolean a(ViewGroup viewgroup, int k)
    {
        viewgroup.removeViewAt(k);
        return true;
    }

    public void b(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)g;
        if (viewgroup != null)
        {
            int i1;
            if (c != null)
            {
                c.i();
                ArrayList arraylist = c.h();
                int k1 = arraylist.size();
                int j1 = 0;
                int k = 0;
                do
                {
                    i1 = k;
                    if (j1 >= k1)
                    {
                        break;
                    }
                    h h1 = (h)arraylist.get(j1);
                    if (a(h1))
                    {
                        View view = viewgroup.getChildAt(k);
                        Object obj;
                        View view1;
                        if (view instanceof m.a)
                        {
                            obj = ((m.a)view).getItemData();
                        } else
                        {
                            obj = null;
                        }
                        view1 = a(h1, view, viewgroup);
                        if (h1 != obj)
                        {
                            view1.setPressed(false);
                            w.r(view1);
                        }
                        if (view1 != view)
                        {
                            obj = (ViewGroup)view1.getParent();
                            if (obj != null)
                            {
                                ((ViewGroup) (obj)).removeView(view1);
                            }
                            ((ViewGroup)g).addView(view1, k);
                        }
                        k++;
                    }
                    j1++;
                } while (true);
            } else
            {
                i1 = 0;
            }
            while (i1 < viewgroup.getChildCount()) 
            {
                if (!a(viewgroup, i1))
                {
                    i1++;
                }
            }
        }
    }

    public final boolean b(h h1)
    {
        return false;
    }

    public final boolean c(h h1)
    {
        return false;
    }
}
