// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectBrushDialog

final class d extends PagerAdapter
{

    final SelectBrushDialog a;
    private List b;
    private View c;

    public d(SelectBrushDialog selectbrushdialog)
    {
        a = selectbrushdialog;
        super();
        b = new ArrayList();
        if (SelectBrushDialog.a(selectbrushdialog))
        {
            List list;
            for (selectbrushdialog = SelectBrushDialog.l(selectbrushdialog).iterator(); selectbrushdialog.hasNext(); b.add(list))
            {
                list = (List)selectbrushdialog.next();
            }

        } else
        {
            List list1;
            for (selectbrushdialog = SelectBrushDialog.m(selectbrushdialog).iterator(); selectbrushdialog.hasNext(); b.add(list1))
            {
                list1 = (List)selectbrushdialog.next();
            }

        }
    }

    static View a(d d1)
    {
        return d1.c;
    }

    static View a(d d1, View view)
    {
        d1.c = view;
        return view;
    }

    public final void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        if (obj != null && viewgroup != null && viewgroup.getChildCount() > 0)
        {
            viewgroup.removeView((View)obj);
        }
    }

    public final int getCount()
    {
        if (SelectBrushDialog.a(a))
        {
            return SelectBrushDialog.l(a).size();
        } else
        {
            return SelectBrushDialog.m(a).size();
        }
    }

    public final Object instantiateItem(ViewGroup viewgroup, int i)
    {
        FrameLayout framelayout = (FrameLayout)a.getLayoutInflater().inflate(0x7f030043, viewgroup, false);
        viewgroup.addView(framelayout);
        viewgroup = (List)b.get(i);
        i = 0;
        while (i < viewgroup.size()) 
        {
            int j = ((Integer)viewgroup.get(i)).intValue();
            int k = i / SelectBrushDialog.n(a);
            int l = SelectBrushDialog.n(a);
            Object obj = a.getResources().getDrawable(Brush.a(j));
            View view = a.getLayoutInflater().inflate(0x7f030044, framelayout, false);
            view.setTag(Integer.valueOf(j));
            ((ImageButton)view).setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
            if (SelectBrushDialog.b(a).getSelectedBrushId(SelectBrushDialog.a(a)) == j)
            {
                view.setSelected(true);
                c = view;
            } else
            {
                view.setSelected(false);
            }
            obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
            obj.leftMargin = (int)((float)(i - l * k) * (SelectBrushDialog.o(a) + SelectBrushDialog.p(a)));
            obj.topMargin = (int)((float)k * (SelectBrushDialog.q(a) + SelectBrushDialog.r(a)));
            if (SelectBrushDialog.a(a))
            {
                view.setId(0x7f10002a);
            } else
            {
                view.setId(0x7f10002b);
            }
            framelayout.addView(view);
            ((ImageButton)view).setOnClickListener(new android.view.View.OnClickListener(j) {

                private int a;
                private d b;

                public final void onClick(View view1)
                {
                    int i1 = SelectBrushDialog.b(b.a).getSelectedBrushId(SelectBrushDialog.a(b.a));
                    boolean flag;
                    if (a == i1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        SelectBrushDialog.a(b.a, a);
                        if (d.a(b) != null)
                        {
                            d.a(b).setSelected(false);
                            d.a(b).invalidate();
                        }
                        d.a(b, view1);
                        d.a(b).setSelected(true);
                        d.a(b).invalidate();
                    }
                    switch (a)
                    {
                    default:
                        return;

                    case 21: // '\025'
                        SelectBrushDialog.s(b.a);
                        return;

                    case 22: // '\026'
                        SelectBrushDialog.t(b.a);
                        break;
                    }
                }

            
            {
                b = d.this;
                a = i;
                super();
            }
            });
            framelayout.requestLayout();
            i++;
        }
        return framelayout;
    }

    public final boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
