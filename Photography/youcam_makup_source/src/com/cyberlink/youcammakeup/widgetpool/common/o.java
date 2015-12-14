// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.idunnololz.widgets.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            t, p

public class o extends a
{

    protected t a;
    protected int b;

    public o(Context context, t t1)
    {
        b = 0;
        a = t1;
        registerDataSetObserver(new DataSetObserver() {

            final o a;

            public void onChanged()
            {
                a.a.notifyDataSetChanged();
            }

            
            {
                a = o.this;
                super();
            }
        });
    }

    public View a(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        LinearLayout linearlayout;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (view == null)
        {
            view = new LinearLayout(viewgroup.getContext());
        }
        linearlayout = (LinearLayout)(LinearLayout)view;
        l = 0;
        k = 0;
        j1 = 0;
        i1 = 0;
        i2 = a.b(i);
        l2 = a.c(i);
        j2 = a.a(i);
        k2 = a.getChildrenCount(i);
        view = a.d(i);
        if (view != null)
        {
            l = ((Rect) (view)).left;
            k = ((Rect) (view)).right;
            j1 = ((Rect) (view)).top;
            i1 = ((Rect) (view)).bottom;
        }
        if (linearlayout.getLayoutParams() == null)
        {
            linearlayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2, -1));
            linearlayout.setGravity(17);
        }
        l1 = l2 / 2;
        k1 = l2 / 2;
        if (j == 0)
        {
            j1 += l2;
        } else
        {
            j1 = l1;
        }
        if ((j + 1) * j2 >= k2)
        {
            i1 += l2;
        } else
        {
            i1 = k1;
        }
        linearlayout.setPadding(l + i2 / 2, j1, k + i2 / 2, i1);
        linearlayout.setBackgroundColor(b);
        for (k = linearlayout.getChildCount(); k > a.a(i); k--)
        {
            linearlayout.removeViewAt(k - 1);
        }

        l = j2 * j;
        k = 0;
        while (l < (j + 1) * j2) 
        {
            if (k < linearlayout.getChildCount())
            {
                view = linearlayout.getChildAt(k);
            } else
            {
                view = null;
            }
            if (l < k2)
            {
                View view1 = view;
                if (view != null)
                {
                    view1 = view;
                    if (view.getTag(0x7f0c0000) == null)
                    {
                        ((ViewGroup)view.getParent()).removeView(view);
                        view1 = null;
                    }
                }
                view = a;
                if (l == k2 - 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view = view.getChildView(i, l, flag, view1, viewgroup);
                view.setTag(0x7f0c0000, a.getChild(i, l));
            } else
            {
                if (view != null && view.getTag(0x7f0c0000) != null)
                {
                    ((ViewGroup)view.getParent()).removeView(view);
                }
                view = new View(viewgroup.getContext());
                view.setTag(0x7f0c0000, null);
            }
            if (!(view.getLayoutParams() instanceof android.widget.LinearLayout.LayoutParams))
            {
                Object obj;
                if ((android.widget.LinearLayout.LayoutParams)view.getLayoutParams() == null)
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F);
                } else
                {
                    obj = new android.widget.LinearLayout.LayoutParams(-1, view.getLayoutParams().height, 1.0F);
                }
                obj.leftMargin = i2 / 2;
                obj.rightMargin = i2 / 2;
                view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            }
            if (linearlayout.getChildCount() < j2)
            {
                obj = (ViewGroup)view.getParent();
                if (obj != null)
                {
                    ((ViewGroup) (obj)).removeView(view);
                }
                linearlayout.addView(view, k);
            } else
            {
                view.invalidate();
            }
            l++;
            k++;
        }
        return linearlayout;
    }

    public void a(p p)
    {
        a.a(p);
        notifyDataSetChanged();
    }

    public void a(boolean flag)
    {
        a.a(flag);
        notifyDataSetChanged();
    }

    public int a_(int i)
    {
        int j = a.getChildrenCount(i);
        if (j > 0)
        {
            return ((j + a.a(i)) - 1) / a.a(i);
        } else
        {
            return 0;
        }
    }

    public Object b(int i, int j)
    {
        return a.a(i, j);
    }

    public Object getChild(int i, int j)
    {
        return a.getChild(i, j);
    }

    public long getChildId(int i, int j)
    {
        return 0L;
    }

    public Object getGroup(int i)
    {
        return a.e(i);
    }

    public int getGroupCount()
    {
        return a.getGroupCount();
    }

    public long getGroupId(int i)
    {
        return a.getGroupId(i);
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        return a.getGroupView(i, flag, view, viewgroup);
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return false;
    }
}
