// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.h;
import com.cyberlink.beautycircle.i;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.model.MeTabItem;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            ObservableHorizontalScrollView, j

public class MeTabScrollView extends ObservableHorizontalScrollView
{

    private LinearLayout a;
    private HashMap b;
    private ArrayList c;
    private android.view.View.OnClickListener d;
    private View e;
    private View f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;
    private Runnable k;
    private android.view.View.OnLayoutChangeListener l;
    private android.view.View.OnClickListener m;

    public MeTabScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = new HashMap();
        c = new ArrayList();
        g = false;
        h = 0;
        i = 0;
        j = false;
        k = new Runnable() {

            final MeTabScrollView a;

            public void run()
            {
                MeTabScrollView.a(a, MeTabScrollView.a(a));
                MeTabScrollView.b(a, MeTabScrollView.a(a));
            }

            
            {
                a = MeTabScrollView.this;
                super();
            }
        };
        l = new android.view.View.OnLayoutChangeListener() {

            final MeTabScrollView a;

            public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                    int k2, int l2)
            {
                if (MeTabScrollView.b(a) != a.getWidth())
                {
                    MeTabScrollView.a(a, a.getWidth());
                    view.post(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            int l1 = MeTabScrollView.c(a.a).getChildCount();
                            if (l1 > 0)
                            {
                                int k1 = a.a.getWidth();
                                int i1 = k1;
                                if (MeTabScrollView.d(a.a).size() > 0)
                                {
                                    i1 = k1 / l1;
                                }
                                k1 = Math.max(i1, MeTabScrollView.e(a.a));
                                for (int j1 = 0; j1 < MeTabScrollView.d(a.a).size(); j1++)
                                {
                                    ((com.cyberlink.beautycircle.view.widgetpool.common.j)MeTabScrollView.c(a.a).getChildAt(j1)).setMinimumWidth(k1);
                                }

                                a.a.setVisibility(0);
                                if (MeTabScrollView.a(a.a) != null)
                                {
                                    MeTabScrollView.a(a.a).removeCallbacks(MeTabScrollView.f(a.a));
                                    MeTabScrollView.a(a.a).postDelayed(MeTabScrollView.f(a.a), 10L);
                                }
                            }
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                }
            }

            
            {
                a = MeTabScrollView.this;
                super();
            }
        };
        m = new android.view.View.OnClickListener() {

            final MeTabScrollView a;

            public void onClick(View view)
            {
                while (MeTabScrollView.a(a) != null && MeTabScrollView.a(a).equals(view) || MeTabScrollView.g(a) == null) 
                {
                    return;
                }
                MeTabScrollView.g(a).onClick(view);
            }

            
            {
                a = MeTabScrollView.this;
                super();
            }
        };
        a(context);
    }

    private int a(int i1, int j1, int k1)
    {
        int l1;
        if (j1 >= k1 || i1 < 0)
        {
            l1 = 0;
        } else
        {
            l1 = i1;
            if (j1 + i1 > k1)
            {
                return k1 - j1;
            }
        }
        return l1;
    }

    static int a(MeTabScrollView metabscrollview, int i1)
    {
        metabscrollview.h = i1;
        return i1;
    }

    static View a(MeTabScrollView metabscrollview)
    {
        return metabscrollview.f;
    }

    private void a(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(k.bc_widget_tab_srcoll_view, this);
        addOnLayoutChangeListener(l);
        setVisibility(4);
        a = (LinearLayout)findViewById(j.tab_container);
        e = findViewById(j.tab_selector);
        i = (int)getResources().getDimension(h.f72dp);
    }

    private void a(View view)
    {
        if (view == null || e == null)
        {
            return;
        } else
        {
            e.animate().cancel();
            e.setPivotX(0.0F);
            float f1 = (float)view.getWidth() / (float)e.getWidth();
            float f2 = view.getLeft();
            e.animate().scaleX(f1).translationX(f2).setDuration(300L).start();
            return;
        }
    }

    static void a(MeTabScrollView metabscrollview, View view)
    {
        metabscrollview.setCenter(view);
    }

    static int b(MeTabScrollView metabscrollview)
    {
        return metabscrollview.h;
    }

    static void b(MeTabScrollView metabscrollview, View view)
    {
        metabscrollview.a(view);
    }

    static LinearLayout c(MeTabScrollView metabscrollview)
    {
        return metabscrollview.a;
    }

    static ArrayList d(MeTabScrollView metabscrollview)
    {
        return metabscrollview.c;
    }

    static int e(MeTabScrollView metabscrollview)
    {
        return metabscrollview.i;
    }

    static Runnable f(MeTabScrollView metabscrollview)
    {
        return metabscrollview.k;
    }

    static android.view.View.OnClickListener g(MeTabScrollView metabscrollview)
    {
        return metabscrollview.d;
    }

    private void setCenter(View view)
    {
        Point point = new Point();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(point);
        int j1 = point.x;
        int i1 = view.getLeft();
        j1 /= 2;
        int k1 = view.getWidth() / 2;
        if (getChildCount() > 0)
        {
            view = getChildAt(0);
            i1 = a((i1 - j1) + k1, getWidth() - getPaddingRight() - getPaddingLeft(), view.getWidth());
            if (i1 != getScrollX())
            {
                super.smoothScrollTo(i1, 0);
            }
        }
    }

    public void a()
    {
        if (j)
        {
            j = false;
            if (f != null)
            {
                f.removeCallbacks(k);
                f.postDelayed(k, 10L);
            }
        }
    }

    public void a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode, int i1)
    {
        if (b.containsKey(melistmode))
        {
            melistmode = (com.cyberlink.beautycircle.view.widgetpool.common.j)b.get(melistmode);
            melistmode.getItem().count = Integer.valueOf(i1);
            com.cyberlink.beautycircle.view.widgetpool.common.j.a(melistmode);
        }
    }

    public void a(ArrayList arraylist)
    {
        boolean flag = false;
        if (!g && arraylist != null)
        {
            g = true;
            b.clear();
            c = arraylist;
            int i1;
            int k1;
            int i2;
            if (arraylist.size() > 5)
            {
                i1 = (int)getResources().getDimension(h.f80dp);
            } else
            {
                i1 = i;
            }
            i = i1;
            h = 0;
            k1 = getWidth();
            i1 = k1;
            if (c.size() > 0)
            {
                i1 = k1 / c.size();
            }
            i2 = Math.max(i1, i);
            i1 = ((flag) ? 1 : 0);
            while (i1 < c.size()) 
            {
                int l1 = i.bc_me_tab_with_sep;
                int j1 = l1;
                if (i1 == 0)
                {
                    j1 = l1;
                    if (a.getChildCount() == 0)
                    {
                        j1 = i.bc_me_tab;
                    }
                }
                arraylist = new com.cyberlink.beautycircle.view.widgetpool.common.j(this, getContext(), j1);
                arraylist.setLayoutParams(new android.widget.LinearLayout.LayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1)));
                arraylist.setMinimumWidth(i2);
                arraylist.setOrientation(1);
                arraylist.setOnClickListener(m);
                MeTabItem metabitem = (MeTabItem)c.get(i1);
                arraylist.setItem(metabitem);
                if (!b.containsKey(metabitem.listMode))
                {
                    b.put(metabitem.listMode, arraylist);
                }
                com.cyberlink.beautycircle.view.widgetpool.common.j.a(arraylist);
                a.addView(arraylist);
                i1++;
            }
        }
    }

    public boolean a(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        if (b.containsKey(melistmode))
        {
            return ((com.cyberlink.beautycircle.view.widgetpool.common.j)b.get(melistmode)).isSelected();
        } else
        {
            return false;
        }
    }

    public int b(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode, int i1)
    {
        int j1 = i1;
        if (b.containsKey(melistmode))
        {
            melistmode = ((com.cyberlink.beautycircle.view.widgetpool.common.j)b.get(melistmode)).getItem();
            j1 = i1;
            if (((MeTabItem) (melistmode)).count != null)
            {
                j1 = ((MeTabItem) (melistmode)).count.intValue();
            }
        }
        return j1;
    }

    public void setTabClickListener(android.view.View.OnClickListener onclicklistener)
    {
        d = onclicklistener;
    }

    public void setTabSelected(com.cyberlink.beautycircle.model.MeTabItem.MeListMode melistmode)
    {
        j = false;
        if (!melistmode.equals(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a))
        {
            int k1 = a.getChildCount();
            com.cyberlink.beautycircle.view.widgetpool.common.j j1 = null;
            int i1 = 0;
            while (i1 < k1) 
            {
                com.cyberlink.beautycircle.view.widgetpool.common.j j2 = (com.cyberlink.beautycircle.view.widgetpool.common.j)a.getChildAt(i1);
                if (j2.getItem().listMode.equals(melistmode))
                {
                    j2.setSelected(true);
                    j1 = j2;
                } else
                {
                    j2.setSelected(false);
                }
                i1++;
            }
            if (j1 != null && !j1.equals(f))
            {
                f = j1;
                j = true;
                return;
            }
        }
    }
}
