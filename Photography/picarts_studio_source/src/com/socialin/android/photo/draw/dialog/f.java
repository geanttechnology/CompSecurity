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
import com.socialin.android.photo.draw.shape.c;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectShapeDialog

final class f extends PagerAdapter
{

    final SelectShapeDialog a;

    private f(SelectShapeDialog selectshapedialog)
    {
        a = selectshapedialog;
        super();
    }

    f(SelectShapeDialog selectshapedialog, byte byte0)
    {
        this(selectshapedialog);
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
        return SelectShapeDialog.h(a).size();
    }

    public final Object instantiateItem(ViewGroup viewgroup, int i)
    {
        FrameLayout framelayout = (FrameLayout)a.getLayoutInflater().inflate(0x7f0301c8, viewgroup, false);
        viewgroup.addView(framelayout);
        List list = (List)SelectShapeDialog.h(a).get(i);
        int j = 0;
        while (j < list.size()) 
        {
            Object obj = (String)list.get(j);
            int k = j / SelectShapeDialog.i(a);
            int l = SelectShapeDialog.i(a);
            android.graphics.drawable.Drawable drawable = a.getResources().getDrawable(c.a(((String) (obj))));
            View view = a.getLayoutInflater().inflate(0x7f0301c9, framelayout, false);
            view.setTag(obj);
            ((ImageButton)view).setImageDrawable(drawable);
            if (((String) (obj)).equals(SelectShapeDialog.g(a)))
            {
                view.setBackgroundResource(0x7f0200aa);
            } else
            {
                view.setBackgroundResource(0x7f0200be);
            }
            obj = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
            obj.leftMargin = (int)((float)(j - l * k) * (SelectShapeDialog.j(a) + SelectShapeDialog.k(a)));
            obj.topMargin = (int)((float)k * (SelectShapeDialog.l(a) + SelectShapeDialog.m(a)));
            view.setId(0x7f10003e);
            framelayout.addView(view);
            ((ImageButton)view).setOnClickListener(new android.view.View.OnClickListener(viewgroup, i, j) {

                private ViewGroup a;
                private int b;
                private int c;
                private f d;

                public final void onClick(View view1)
                {
                    View view2 = a.findViewWithTag(SelectShapeDialog.g(d.a));
                    if (view2 != null)
                    {
                        view2.setBackgroundResource(0x7f0200be);
                    }
                    view1.setBackgroundResource(0x7f0200aa);
                    SelectShapeDialog.a(d.a, b * SelectShapeDialog.n(d.a) * SelectShapeDialog.i(d.a) + c);
                }

            
            {
                d = f.this;
                a = viewgroup;
                b = i;
                c = j;
                super();
            }
            });
            framelayout.requestLayout();
            j++;
        }
        return framelayout;
    }

    public final boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }
}
