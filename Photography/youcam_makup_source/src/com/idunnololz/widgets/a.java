// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.idunnololz.widgets;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

// Referenced classes of package com.idunnololz.widgets:
//            d, b, c, AnimatedExpandableListView

public abstract class a extends BaseExpandableListAdapter
{

    private SparseArray a;
    private AnimatedExpandableListView b;

    public a()
    {
        a = new SparseArray();
    }

    private d a(int i)
    {
        d d2 = (d)a.get(i);
        d d1 = d2;
        if (d2 == null)
        {
            d1 = new d(null);
            a.put(i, d1);
        }
        return d1;
    }

    private void a(AnimatedExpandableListView animatedexpandablelistview)
    {
        b = animatedexpandablelistview;
    }

    static void a(a a1, int i)
    {
        a1.c(i);
    }

    static void a(a a1, int i, int j)
    {
        a1.b(i, j);
    }

    static void a(a a1, AnimatedExpandableListView animatedexpandablelistview)
    {
        a1.a(animatedexpandablelistview);
    }

    private void b(int i, int j)
    {
        d d1 = a(i);
        d1.a = true;
        d1.c = j;
        d1.b = true;
    }

    static void b(a a1, int i, int j)
    {
        a1.c(i, j);
    }

    private void c(int i)
    {
        a(i).a = false;
    }

    private void c(int i, int j)
    {
        d d1 = a(i);
        d1.a = true;
        d1.c = j;
        d1.b = false;
    }

    public int a(int i, int j)
    {
        return 0;
    }

    public abstract View a(int i, int j, boolean flag, View view, ViewGroup viewgroup);

    public abstract int a_(int i);

    public int c()
    {
        return 1;
    }

    public void e(int i)
    {
        a(i).d = -1;
    }

    public final int getChildType(int i, int j)
    {
        if (a(i).a)
        {
            return 0;
        } else
        {
            return a(i, j) + 1;
        }
    }

    public final int getChildTypeCount()
    {
        return c() + 1;
    }

    public final View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        d d1;
        d1 = a(i);
        if (!d1.a)
        {
            break MISSING_BLOCK_LABEL_456;
        }
        if (view == null)
        {
            view = new b(viewgroup.getContext());
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, 0));
        }
        if (j >= d1.c) goto _L2; else goto _L1
_L1:
        view.getLayoutParams().height = 0;
_L4:
        return view;
_L2:
        b b1;
        ExpandableListView expandablelistview;
        View view1;
        int k;
        int k1;
        expandablelistview = (ExpandableListView)viewgroup;
        b1 = (b)view;
        b1.a();
        b1.a(expandablelistview.getDivider(), viewgroup.getMeasuredWidth(), expandablelistview.getDividerHeight());
        int l = android.view.View.MeasureSpec.makeMeasureSpec(viewgroup.getWidth(), 0x40000000);
        int i1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        j = 0;
        int j1 = viewgroup.getHeight();
        k1 = a_(i);
        k = d1.c;
        do
        {
label0:
            {
                if (k >= k1)
                {
                    break MISSING_BLOCK_LABEL_249;
                }
                if (k == k1 - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view1 = a(i, k, flag, null, viewgroup);
                view1.measure(l, i1);
                j += view1.getMeasuredHeight();
                if (j >= j1)
                {
                    break label0;
                }
                b1.a(view1);
                k++;
            }
        } while (true);
        b1.a(view1);
        j += (j / (k + 1)) * (k1 - k - 1);
        viewgroup = ((ViewGroup) (b1.getTag()));
        if (viewgroup == null)
        {
            k = 0;
        } else
        {
            k = ((Integer)viewgroup).intValue();
        }
        if (d1.b && k != 1)
        {
            viewgroup = new c(b1, 0, j, d1, null);
            viewgroup.setDuration(AnimatedExpandableListView.a(b));
            viewgroup.setAnimationListener(new android.view.animation.Animation.AnimationListener(i, b1) {

                final int a;
                final b b;
                final a c;

                public void onAnimationEnd(Animation animation)
                {
                    a.a(c, a);
                    c.notifyDataSetChanged();
                    b.setTag(Integer.valueOf(0));
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            
            {
                c = a.this;
                a = i;
                b = b1;
                super();
            }
            });
            b1.startAnimation(viewgroup);
            b1.setTag(Integer.valueOf(1));
            return view;
        }
        if (d1.b || k == 2) goto _L4; else goto _L3
_L3:
        if (d1.d == -1)
        {
            d1.d = j;
        }
        viewgroup = new c(b1, d1.d, 0, d1, null);
        viewgroup.setDuration(AnimatedExpandableListView.a(b));
        viewgroup.setAnimationListener(new android.view.animation.Animation.AnimationListener(i, expandablelistview, d1, b1) {

            final int a;
            final ExpandableListView b;
            final d c;
            final b d;
            final a e;

            public void onAnimationEnd(Animation animation)
            {
                a.a(e, a);
                b.collapseGroup(a);
                e.notifyDataSetChanged();
                c.d = -1;
                d.setTag(Integer.valueOf(0));
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                e = a.this;
                a = i;
                b = expandablelistview;
                c = d1;
                d = b1;
                super();
            }
        });
        b1.startAnimation(viewgroup);
        b1.setTag(Integer.valueOf(2));
        return view;
        return a(i, j, flag, view, viewgroup);
    }

    public final int getChildrenCount(int i)
    {
        d d1 = a(i);
        if (d1.a)
        {
            return d1.c + 1;
        } else
        {
            return a_(i);
        }
    }
}
