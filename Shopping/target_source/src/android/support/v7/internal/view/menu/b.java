// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v4.view.ai;
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

    protected Context a;
    protected Context b;
    protected f c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected m f;
    private l.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int k, int i1)
    {
        a = context;
        d = LayoutInflater.from(context);
        h = k;
        i = i1;
    }

    public m a(ViewGroup viewgroup)
    {
        if (f == null)
        {
            f = (m)d.inflate(h, viewgroup, false);
            f.a(c);
            a(true);
        }
        return f;
    }

    public View a(h h1, View view, ViewGroup viewgroup)
    {
        if (view instanceof m.a)
        {
            view = (m.a)view;
        } else
        {
            view = b(viewgroup);
        }
        a(h1, ((m.a) (view)));
        return (View)view;
    }

    public void a(int k)
    {
        j = k;
    }

    public void a(Context context, f f1)
    {
        b = context;
        e = LayoutInflater.from(b);
        c = f1;
    }

    public void a(f f1, boolean flag)
    {
        if (g != null)
        {
            g.a(f1, flag);
        }
    }

    public abstract void a(h h1, m.a a1);

    public void a(l.a a1)
    {
        g = a1;
    }

    protected void a(View view, int k)
    {
        ViewGroup viewgroup = (ViewGroup)view.getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(view);
        }
        ((ViewGroup)f).addView(view, k);
    }

    public void a(boolean flag)
    {
        ViewGroup viewgroup = (ViewGroup)f;
        if (viewgroup != null)
        {
            int i1;
            if (c != null)
            {
                c.j();
                ArrayList arraylist = c.i();
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
                    h h2 = (h)arraylist.get(j1);
                    if (a(k, h2))
                    {
                        View view = viewgroup.getChildAt(k);
                        h h1;
                        View view1;
                        if (view instanceof m.a)
                        {
                            h1 = ((m.a)view).getItemData();
                        } else
                        {
                            h1 = null;
                        }
                        view1 = a(h2, view, viewgroup);
                        if (h2 != h1)
                        {
                            view1.setPressed(false);
                            ai.x(view1);
                        }
                        if (view1 != view)
                        {
                            a(view1, k);
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

    public boolean a()
    {
        return false;
    }

    public boolean a(int k, h h1)
    {
        return true;
    }

    public boolean a(f f1, h h1)
    {
        return false;
    }

    public boolean a(p p)
    {
        if (g != null)
        {
            return g.a_(p);
        } else
        {
            return false;
        }
    }

    protected boolean a(ViewGroup viewgroup, int k)
    {
        viewgroup.removeViewAt(k);
        return true;
    }

    public int b()
    {
        return j;
    }

    public m.a b(ViewGroup viewgroup)
    {
        return (m.a)d.inflate(i, viewgroup, false);
    }

    public boolean b(f f1, h h1)
    {
        return false;
    }

    public l.a d()
    {
        return g;
    }
}
