// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.q;
import com.cyberlink.youcammakeup.widgetpool.common.r;
import com.cyberlink.youcammakeup.widgetpool.common.s;
import com.cyberlink.youcammakeup.widgetpool.common.t;
import com.cyberlink.youcammakeup.widgetpool.common.u;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            d, PalettesItemView, PalettesGroupView

public class c extends t
{

    private List b;
    private p c;
    private q d;
    private s e;
    private r f;
    private boolean g;
    private android.view.View.OnClickListener h;
    private android.view.View.OnLongClickListener i;

    c(List list, q q, s s, r r)
    {
        h = new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                if (c.a(a) == null)
                {
                    return;
                } else
                {
                    p p1 = (p)view.getTag();
                    ((PalettesItemView)view).c(false);
                    c.a(a).a(view, p1.a, p1.b);
                    a.a(p1.a, p1.b, false);
                    return;
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        i = new android.view.View.OnLongClickListener() {

            final c a;

            public boolean onLongClick(View view)
            {
                if (c.b(a) == null)
                {
                    return true;
                } else
                {
                    p p1 = (p)view.getTag();
                    c.b(a).a(view, p1.a, p1.b);
                    return true;
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        b = list;
        c = new p(-1, -1);
        d = q;
        e = s;
        f = r;
        g = false;
    }

    static q a(c c1)
    {
        return c1.d;
    }

    static s b(c c1)
    {
        return c1.e;
    }

    public int a(int j)
    {
        return f(j).a();
    }

    public Object a(int j, int k)
    {
        return c(j, k);
    }

    public void a(int j, int k, boolean flag)
    {
        aw aw1 = f(j).a(k);
        if (aw1.g() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            aw1.a(Boolean.valueOf(flag));
        }
    }

    public void a(p p1)
    {
        c = p1;
    }

    public void a(boolean flag)
    {
        g = flag;
    }

    public int b(int j)
    {
        return f(j).d();
    }

    public p b(int j, int k)
    {
        return new p(j, k);
    }

    public int c(int j)
    {
        return f(j).e();
    }

    public aw c(int j, int k)
    {
        return f(j).a(k);
    }

    public Rect d(int j)
    {
        return null;
    }

    public boolean d(int j, int k)
    {
        return f(j).a(k).h().booleanValue();
    }

    public u e(int j)
    {
        return f(j);
    }

    public d f(int j)
    {
        return (d)b.get(j);
    }

    public Object getChild(int j, int k)
    {
        return b(j, k);
    }

    public long getChildId(int j, int k)
    {
        return 0L;
    }

    public int getChildType(int j, int k)
    {
        return j;
    }

    public int getChildTypeCount()
    {
        return getGroupCount();
    }

    public View getChildView(int j, int k, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (PalettesItemView)view;
        } else
        {
            view = new PalettesItemView(viewgroup.getContext(), f(j).g());
            view.setOnClickListener(h);
            view.setOnLongClickListener(i);
            view.setOnDeleteListener(f);
        }
        viewgroup = c(j, k);
        view.setName(viewgroup.d());
        if (g)
        {
            view.setEnabled(false);
            if (viewgroup.g() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c || viewgroup.g() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
            {
                view.b(true);
            } else
            {
                view.b(false);
            }
        } else
        {
            view.b(false);
            view.setEnabled(true);
        }
        if (j == PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.e) && k == 0)
        {
            view.a(true);
            view.setEnabled(false);
        } else
        {
            view.a(false);
            view.setEnabled(true);
            if (j == c.a && k == c.b)
            {
                view.setSelected(true);
            } else
            {
                view.setSelected(false);
            }
            view.c(d(j, k));
            viewgroup = viewgroup.i();
            if (viewgroup.size() > 0)
            {
                view.setColorOne(((at)viewgroup.get(0)).e());
                view.setColorIsShimmerOne(((at)viewgroup.get(0)).k());
            }
            if (viewgroup.size() > 1)
            {
                view.setColorTwo(((at)viewgroup.get(1)).e());
                view.setColorIsShimmerTwo(((at)viewgroup.get(1)).k());
            }
            if (viewgroup.size() > 2)
            {
                view.setColorThree(((at)viewgroup.get(2)).e());
                view.setColorIsShimmerThree(((at)viewgroup.get(2)).k());
            }
            if (viewgroup.size() > 3)
            {
                view.setColorFour(((at)viewgroup.get(3)).e());
                view.setColorIsShimmerFour(((at)viewgroup.get(3)).k());
                return view;
            }
        }
        return view;
    }

    public int getChildrenCount(int j)
    {
        return f(j).c();
    }

    public Object getGroup(int j)
    {
        return f(j);
    }

    public int getGroupCount()
    {
        return b.size();
    }

    public long getGroupId(int j)
    {
        return 0L;
    }

    public View getGroupView(int j, boolean flag, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            view = (PalettesGroupView)view;
        } else
        {
            view = new PalettesGroupView(viewgroup.getContext());
        }
        viewgroup = f(j).f();
        if (viewgroup != null)
        {
            view.a();
        } else
        {
            view.b();
        }
        view.setText(viewgroup);
        return view;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int j, int k)
    {
        return false;
    }
}
