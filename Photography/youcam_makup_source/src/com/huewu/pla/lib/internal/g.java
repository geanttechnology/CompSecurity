// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib.internal;

import android.view.View;
import android.widget.ListAdapter;
import com.huewu.pla.lib.a;
import java.util.Stack;

// Referenced classes of package com.huewu.pla.lib.internal:
//            PLA_AbsListView, c, h

class g
{

    final PLA_AbsListView a;
    private h b;
    private int c;
    private View d[];
    private Stack e[];
    private int f;
    private Stack g;

    g(PLA_AbsListView pla_abslistview)
    {
        a = pla_abslistview;
        super();
        d = new View[0];
    }

    static h a(g g1, h h1)
    {
        g1.b = h1;
        return h1;
    }

    private void d()
    {
        int l = d.length;
        int i1 = f;
        Stack astack[] = e;
        for (int i = 0; i < i1; i++)
        {
            Stack stack = astack[i];
            int j1 = stack.size();
            int j = j1 - 1;
            for (int k = 0; k < j1 - l;)
            {
                com.huewu.pla.lib.a.b("remove scarp views from pruneScrapViews");
                PLA_AbsListView.e(a, (View)stack.remove(j), false);
                k++;
                j--;
            }

        }

    }

    public void a()
    {
        int i = 0;
        if (f == 1)
        {
            Stack stack = g;
            for (int k = stack.size(); i < k; i++)
            {
                ((View)stack.get(i)).forceLayout();
            }

        } else
        {
            int i1 = f;
            for (int j = 0; j < i1; j++)
            {
                Stack stack1 = e[j];
                int j1 = stack1.size();
                for (int l = 0; l < j1; l++)
                {
                    ((View)stack1.get(l)).forceLayout();
                }

            }

        }
    }

    public void a(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }
        Stack astack[] = new Stack[i];
        for (int j = 0; j < i; j++)
        {
            astack[j] = new Stack();
        }

        f = i;
        g = astack[0];
        e = astack;
    }

    void a(int i, int j)
    {
        if (d.length < i)
        {
            d = new View[i];
        }
        c = j;
        View aview[] = d;
        for (j = 0; j < i; j++)
        {
            View view = a.getChildAt(j);
            c c1 = (c)view.getLayoutParams();
            if (c1 != null && c1.a != -2)
            {
                aview[j] = view;
            }
        }

    }

    void a(View view)
    {
        c c1;
        com.huewu.pla.lib.a.b("addToScrap");
        c1 = (c)view.getLayoutParams();
        if (c1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = c1.a;
        if (b(i))
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != -2)
        {
            PLA_AbsListView.c(a, view, false);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (f == 1)
        {
            com.huewu.pla.lib.internal.PLA_AbsListView.a(a, view);
            g.add(view);
        } else
        {
            com.huewu.pla.lib.internal.PLA_AbsListView.a(a, view);
            e[i].push(view);
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
            Stack stack = g;
            int k = stack.size();
            for (int i = 0; i < k; i++)
            {
                com.huewu.pla.lib.internal.PLA_AbsListView.a(a, (View)stack.remove(k - 1 - i), false);
            }

        } else
        {
            int i1 = f;
            for (int j = 0; j < i1; j++)
            {
                Stack stack1 = e[j];
                int j1 = stack1.size();
                for (int l = 0; l < j1; l++)
                {
                    PLA_AbsListView.b(a, (View)stack1.remove(j1 - 1 - l), false);
                }

            }

        }
    }

    public boolean b(int i)
    {
        return i >= 0;
    }

    View c(int i)
    {
        i -= c;
        View aview[] = d;
        if (i >= 0 && i < aview.length)
        {
            View view = aview[i];
            aview[i] = null;
            return view;
        } else
        {
            return null;
        }
    }

    void c()
    {
        View aview[] = d;
        Stack stack;
        boolean flag;
        boolean flag1;
        int i;
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
        stack = g;
        i = aview.length - 1;
        while (i >= 0) 
        {
            View view = aview[i];
            Stack stack1 = stack;
            if (view != null)
            {
                int j = ((c)view.getLayoutParams()).a;
                aview[i] = null;
                if (!b(j))
                {
                    stack1 = stack;
                    if (j != -2)
                    {
                        PLA_AbsListView.d(a, view, false);
                        stack1 = stack;
                    }
                } else
                {
                    if (flag1)
                    {
                        stack = e[j];
                    }
                    com.huewu.pla.lib.internal.PLA_AbsListView.a(a, view);
                    com.huewu.pla.lib.a.b("addToScrap from scrapActiveViews");
                    stack.add(view);
                    if (flag)
                    {
                        b.a(view);
                    }
                    stack1 = stack;
                }
            }
            i--;
            stack = stack1;
        }
        d();
    }

    View d(int i)
    {
        com.huewu.pla.lib.a.b((new StringBuilder()).append("getFromScrap: ").append(i).toString());
        if (a.getHeaderViewsCount() > i)
        {
            return null;
        }
        Stack stack;
        int k;
        if (f == 1)
        {
            stack = g;
        } else
        {
            j = a.e.getItemViewType(i);
            if (j >= 0 && j < e.length)
            {
                stack = e[j];
            } else
            {
                return null;
            }
        }
        k = stack.size();
        for (int j = k - 1; j >= 0; j--)
        {
            if (((c)((View)stack.get(j)).getLayoutParams()).b == i)
            {
                return (View)stack.remove(j);
            }
        }

        if (k > 0)
        {
            return (View)stack.remove(0);
        } else
        {
            return null;
        }
    }

    void e(int i)
    {
        if (f == 1)
        {
            Stack stack = g;
            int i1 = stack.size();
            for (int j = 0; j < i1; j++)
            {
                ((View)stack.get(j)).setDrawingCacheBackgroundColor(i);
            }

        } else
        {
            int l1 = f;
            for (int k = 0; k < l1; k++)
            {
                Stack stack1 = e[k];
                int i2 = stack1.size();
                for (int j1 = 0; j1 < i2; j1++)
                {
                    ((View)stack1.get(k)).setDrawingCacheBackgroundColor(i);
                }

            }

        }
        View aview[] = d;
        int k1 = aview.length;
        for (int l = 0; l < k1; l++)
        {
            View view = aview[l];
            if (view != null)
            {
                view.setDrawingCacheBackgroundColor(i);
            }
        }

    }
}
