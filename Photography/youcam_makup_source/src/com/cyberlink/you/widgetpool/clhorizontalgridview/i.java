// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.clhorizontalgridview;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import android.widget.ListAdapter;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.you.widgetpool.clhorizontalgridview:
//            AbsListView, e, j

class i
{

    final AbsListView a;
    private j b;
    private int c;
    private View d[];
    private ArrayList e[];
    private int f;
    private ArrayList g;
    private ArrayList h;
    private SparseArrayCompat i;

    i(AbsListView abslistview)
    {
        a = abslistview;
        super();
        d = new View[0];
    }

    static j a(i k, j j1)
    {
        k.b = j1;
        return j1;
    }

    private void f()
    {
        int j1 = d.length;
        int k1 = f;
        ArrayList aarraylist[] = e;
        for (int k = 0; k < k1; k++)
        {
            ArrayList arraylist = aarraylist[k];
            int l1 = arraylist.size();
            int l = l1 - 1;
            for (int i1 = 0; i1 < l1 - j1;)
            {
                AbsListView.e(a, (View)arraylist.remove(l), false);
                i1++;
                l--;
            }

        }

    }

    public void a()
    {
        boolean flag = false;
        if (f == 1)
        {
            ArrayList arraylist = g;
            int j1 = arraylist.size();
            for (int k = 0; k < j1; k++)
            {
                ((View)arraylist.get(k)).forceLayout();
            }

        } else
        {
            int i2 = f;
            for (int l = 0; l < i2; l++)
            {
                ArrayList arraylist1 = e[l];
                int j2 = arraylist1.size();
                for (int k1 = 0; k1 < j2; k1++)
                {
                    ((View)arraylist1.get(k1)).forceLayout();
                }

            }

        }
        if (i != null)
        {
            int l1 = i.size();
            for (int i1 = ((flag) ? 1 : 0); i1 < l1; i1++)
            {
                ((View)i.valueAt(i1)).forceLayout();
            }

        }
    }

    public void a(int k)
    {
        if (k < 1)
        {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        ArrayList aarraylist[] = new ArrayList[k];
        for (int l = 0; l < k; l++)
        {
            aarraylist[l] = new ArrayList();
        }

        f = k;
        g = aarraylist[0];
        e = aarraylist;
    }

    void a(int k, int l)
    {
        if (d.length < k)
        {
            d = new View[k];
        }
        c = l;
        View aview[] = d;
        for (l = 0; l < k; l++)
        {
            View view = a.getChildAt(l);
            e e1 = (e)view.getLayoutParams();
            if (e1 != null && e1.a != -2)
            {
                aview[l] = view;
            }
        }

    }

    void a(View view, int k)
    {
        e e1 = (e)view.getLayoutParams();
        if (e1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        e1.c = k;
        k = e1.a;
        if (b(k))
        {
            break; /* Loop/switch isn't completed */
        }
        if (k != -2)
        {
            if (h == null)
            {
                h = new ArrayList();
            }
            h.add(view);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (f == 1)
        {
            g.add(view);
        } else
        {
            e[k].add(view);
        }
        if (b != null)
        {
            b.a(view);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    void b()
    {
        if (f == 1)
        {
            ArrayList arraylist = g;
            int i1 = arraylist.size();
            for (int k = 0; k < i1; k++)
            {
                AbsListView.a(a, (View)arraylist.remove(i1 - 1 - k), false);
            }

        } else
        {
            int k1 = f;
            for (int l = 0; l < k1; l++)
            {
                ArrayList arraylist1 = e[l];
                int l1 = arraylist1.size();
                for (int j1 = 0; j1 < l1; j1++)
                {
                    AbsListView.b(a, (View)arraylist1.remove(l1 - 1 - j1), false);
                }

            }

        }
        if (i != null)
        {
            i.clear();
        }
    }

    public boolean b(int k)
    {
        return k >= 0;
    }

    View c(int k)
    {
        k -= c;
        View aview[] = d;
        if (k >= 0 && k < aview.length)
        {
            View view = aview[k];
            aview[k] = null;
            return view;
        } else
        {
            return null;
        }
    }

    void c()
    {
        if (i != null)
        {
            i.clear();
        }
    }

    View d(int k)
    {
        if (i != null)
        {
            if ((k = i.indexOfKey(k)) >= 0)
            {
                View view = (View)i.valueAt(k);
                i.removeAt(k);
                return view;
            }
        }
        return null;
    }

    void d()
    {
        if (h == null)
        {
            return;
        }
        int l = h.size();
        for (int k = 0; k < l; k++)
        {
            AbsListView.c(a, (View)h.get(k), false);
        }

        h.clear();
    }

    View e(int k)
    {
        if (f == 1)
        {
            return AbsListView.a(g, k);
        }
        int l = a.g.getItemViewType(k);
        if (l >= 0 && l < e.length)
        {
            return AbsListView.a(e[l], k);
        } else
        {
            return null;
        }
    }

    void e()
    {
        View aview[] = d;
        Object obj;
        boolean flag;
        boolean flag1;
        int k;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (f > 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = g;
        k = aview.length - 1;
        while (k >= 0) 
        {
            View view = aview[k];
            Object obj1 = obj;
            if (view != null)
            {
                obj1 = (e)view.getLayoutParams();
                int l = ((e) (obj1)).a;
                aview[k] = null;
                if (!b(l))
                {
                    obj1 = obj;
                    if (l != -2)
                    {
                        AbsListView.d(a, view, false);
                        obj1 = obj;
                    }
                } else
                {
                    if (flag1)
                    {
                        obj = e[l];
                    }
                    obj1.c = c + k;
                    ((ArrayList) (obj)).add(view);
                    obj1 = obj;
                    if (flag)
                    {
                        b.a(view);
                        obj1 = obj;
                    }
                }
            }
            k--;
            obj = obj1;
        }
        f();
    }

    void f(int k)
    {
        if (f == 1)
        {
            ArrayList arraylist = g;
            int k1 = arraylist.size();
            for (int l = 0; l < k1; l++)
            {
                ((View)arraylist.get(l)).setDrawingCacheBackgroundColor(k);
            }

        } else
        {
            int j2 = f;
            for (int i1 = 0; i1 < j2; i1++)
            {
                ArrayList arraylist1 = e[i1];
                int k2 = arraylist1.size();
                for (int l1 = 0; l1 < k2; l1++)
                {
                    ((View)arraylist1.get(l1)).setDrawingCacheBackgroundColor(k);
                }

            }

        }
        View aview[] = d;
        int i2 = aview.length;
        for (int j1 = 0; j1 < i2; j1++)
        {
            View view = aview[j1];
            if (view != null)
            {
                view.setDrawingCacheBackgroundColor(k);
            }
        }

    }
}
