// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.h.f;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.m;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.u;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.pages.moreview.af;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            TemplateButton, p

public class BeautyToolPanelItemAdapter extends BaseAdapter
{

    protected Context a;
    protected boolean b;
    protected DeletableItemPosition c;
    protected List d;
    protected List e;
    protected List f;
    protected android.view.View.OnClickListener g;
    protected boolean h;
    private int i;
    private boolean j;
    private ag k;
    private az l;
    private String m;
    private BeautyMode n;

    public BeautyToolPanelItemAdapter(Context context, BeautyMode beautymode, String s, boolean flag, DeletableItemPosition deletableitemposition, az az1)
    {
        h = false;
        j = false;
        a = context;
        b = flag;
        c = deletableitemposition;
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        k = new ag(context);
        n = beautymode;
        m = s;
        l = az1;
        context = new k(a, null);
        context.g = false;
        context.a(0.15F);
        k.a(((Activity)a).getFragmentManager(), context);
        f();
    }

    private boolean a(int i1, View view)
    {
_L2:
        return false;
        if (view == null || !(view instanceof TemplateButton)) goto _L2; else goto _L1
_L1:
        view = (TemplateButton)view;
        if (i1 != 0 || !b)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (view.getLayoutType() != TemplateButton.LayoutType.a) goto _L2; else goto _L3
_L3:
        return true;
        if (view.getLayoutType() != TemplateButton.LayoutType.b) goto _L2; else goto _L4
_L4:
        return true;
    }

    private void f()
    {
        if (l != null) goto _L2; else goto _L1
_L1:
        if (m == null) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = (List)com.cyberlink.youcammakeup.h.n().a(m, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c.name());
        if (n == BeautyMode.n && ((List) (obj)).size() == 0 && StatusManager.j().d() != null && StatusManager.j().d().b() != null && m.equals(StatusManager.j().d().b().c()))
        {
            ((List) (obj)).add(0, StatusManager.j().d().b().b());
        }
        com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType asourcetype[] = new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[1];
        asourcetype[0] = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a;
        int k1 = asourcetype.length;
label0:
        for (int i1 = 0; i1 < k1; i1++)
        {
            Object obj1 = asourcetype[i1];
            obj1 = ((List)com.cyberlink.youcammakeup.h.n().a(m, ((com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType) (obj1)).name())).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    continue label0;
                }
                String s = (String)((Iterator) (obj1)).next();
                if (!((List) (obj)).contains(s))
                {
                    ((List) (obj)).add(s);
                }
            } while (true);
        }

_L6:
        for (int j1 = 0; j1 < ((List) (obj)).size(); j1++)
        {
            ax ax4 = PanelDataCenter.a().p((String)((List) (obj)).get(j1));
            if (ax4 != null)
            {
                e.add(new p(ax4.c(), ax4.a(), ax4.d(), ax4.e().booleanValue(), ax4.i()));
            }
        }

        break; /* Loop/switch isn't completed */
_L4:
        if (n == BeautyMode.l)
        {
            obj = PanelDataCenter.a().b(n);
        } else
        {
            obj = new ArrayList();
        }
        ((List) (obj)).addAll(PanelDataCenter.a().b(n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a));
        if (n == BeautyMode.s && StatusManager.j().d() != null && StatusManager.j().d().c() != null && PanelDataCenter.a().j(StatusManager.j().d().c().c()).k() != null && !"".equals(PanelDataCenter.a().j(StatusManager.j().d().c().c()).k()))
        {
            ((List) (obj)).add(StatusManager.j().d().c().b());
        } else
        if (n == BeautyMode.x && StatusManager.j().d() != null && StatusManager.j().d().u() != null && StatusManager.j().d().u().c() != null && PanelDataCenter.a().j(StatusManager.j().d().u().c()).k() != null && !"".equals(PanelDataCenter.a().j(StatusManager.j().d().u().c()).k()))
        {
            ((List) (obj)).add(StatusManager.j().d().u().b());
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (b)
        {
            d.add(new p("", "", null, false, null));
        }
        if (n != BeautyMode.s) goto _L8; else goto _L7
_L7:
        ax ax1 = PanelDataCenter.a().p("default_original_eye_contact");
        d.add(new p(ax1.c(), ax1.a(), ax1.d(), ax1.e().booleanValue(), ax1.i()));
_L9:
        a(n, m);
        return;
_L8:
        if (n == BeautyMode.x)
        {
            ax ax2 = PanelDataCenter.a().p("default_original_wig");
            d.add(new p(ax2.c(), ax2.a(), ax2.d(), ax2.e().booleanValue(), ax2.i()));
        } else
        if (n == BeautyMode.t)
        {
            ax ax3 = PanelDataCenter.a().p("default_original_double_eyelid");
            d.add(new p(ax3.c(), ax3.a(), ax3.d(), ax3.e().booleanValue(), ax3.i()));
        }
        if (true) goto _L9; else goto _L2
_L2:
        g();
        return;
    }

    private void g()
    {
        if (m != null)
        {
            Object obj = new ArrayList();
            com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType asourcetype[] = new com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType[1];
            asourcetype[0] = com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d;
            int j1 = asourcetype.length;
label0:
            for (int i1 = 0; i1 < j1; i1++)
            {
                Object obj3 = asourcetype[i1];
                obj3 = ((List)com.cyberlink.youcammakeup.h.n().a(m, ((com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType) (obj3)).name())).iterator();
                do
                {
                    if (!((Iterator) (obj3)).hasNext())
                    {
                        continue label0;
                    }
                    String s = (String)((Iterator) (obj3)).next();
                    if (!((List) (obj)).contains(s))
                    {
                        ((List) (obj)).add(s);
                    }
                } while (true);
            }

            if (((List) (obj)).size() == 0)
            {
                obj = PanelDataCenter.a().b(n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a);
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = (String)((Iterator) (obj)).next();
                obj1 = PanelDataCenter.a().p(((String) (obj1)));
                if (obj1 != null)
                {
                    e.add(new p(((ax) (obj1)).c(), ((ax) (obj1)).a(), ((ax) (obj1)).d(), ((ax) (obj1)).e().booleanValue(), ((ax) (obj1)).i()));
                }
            } while (true);
        } else
        {
            Iterator iterator = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(l.b(), l.a()).l().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj2 = (e)iterator.next();
                obj2 = PanelDataCenter.a().p(((e) (obj2)).a());
                if (obj2 != null)
                {
                    e.add(new p(((ax) (obj2)).c(), ((ax) (obj2)).a(), ((ax) (obj2)).d(), ((ax) (obj2)).e().booleanValue(), ((ax) (obj2)).i()));
                }
            } while (true);
        }
    }

    public p a(int i1)
    {
        List list2 = d;
        List list;
        List list1;
        if (c == DeletableItemPosition.a)
        {
            list = f;
        } else
        {
            list = e;
        }
        if (c == DeletableItemPosition.b)
        {
            list1 = f;
        } else
        {
            list1 = e;
        }
        if (i1 < list2.size())
        {
            if (list2.size() > 0)
            {
                return (p)list2.get(i1);
            }
        } else
        if (i1 - list2.size() < list.size())
        {
            if (list.size() > 0)
            {
                return (p)list.get(i1 - list2.size());
            }
        } else
        if (list1.size() > 0)
        {
            return (p)list1.get(i1 - list2.size() - list.size());
        }
        if (list2 != null && list2.size() > 0)
        {
            return (p)list2.get(0);
        } else
        {
            return new p("", "", null, false, null);
        }
    }

    public void a(int i1, boolean flag)
    {
        p p1 = a(i1);
        if (p1.d != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            return;
        } else
        {
            p1.e = false;
            PanelDataCenter.a().p(p1.c).a(Boolean.valueOf(flag));
            return;
        }
    }

    public void a(android.view.View.OnClickListener onclicklistener)
    {
        g = onclicklistener;
    }

    public void a(BeautyMode beautymode, String s)
    {
        f.clear();
        if (s == null || beautymode != BeautyMode.n) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = PanelDataCenter.a().a(s, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
        s = new ArrayList();
        obj = ((List) (obj)).iterator();
_L4:
        String s1;
        boolean flag;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)((Iterator) (obj)).next();
        Iterator iterator = e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_235;
            }
        } while (!s1.equals(((p)iterator.next()).c));
        flag = true;
_L6:
        if (!flag)
        {
            s.add(s1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (beautymode != BeautyMode.n)
        {
            Collections.reverse(s);
        }
        beautymode = s.iterator();
        do
        {
            if (!beautymode.hasNext())
            {
                break;
            }
            s = (String)beautymode.next();
            s = PanelDataCenter.a().p(s);
            if (s != null)
            {
                f.add(new p(s.c(), s.a(), s.d(), s.e().booleanValue(), s.i()));
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        s = PanelDataCenter.a().b(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
        if (true) goto _L3; else goto _L5
_L5:
        return;
        flag = false;
          goto _L6
    }

    public void a(az az1)
    {
        l = az1;
    }

    public void a(boolean flag)
    {
        h = flag;
        notifyDataSetChanged();
    }

    public boolean a()
    {
        return h;
    }

    public boolean a(String s)
    {
        if (s != null)
        {
            int i1 = 0;
            while (i1 < getCount()) 
            {
                if (s.equals(a(i1).c))
                {
                    return true;
                }
                i1++;
            }
        }
        return false;
    }

    public void b(String s)
    {
        m = s;
    }

    public void b(boolean flag)
    {
        j = flag;
    }

    public boolean b()
    {
        return f.size() > 0;
    }

    public boolean b(int i1)
    {
        return a(i1).e;
    }

    public int c()
    {
        return i;
    }

    public void c(boolean flag)
    {
        b = flag;
    }

    public boolean c(int i1)
    {
        return a(i1).d == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b;
    }

    public void d(int i1)
    {
        i = i1;
    }

    public boolean d()
    {
        return j;
    }

    public void e()
    {
        if (d != null)
        {
            d.clear();
            d = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
        if (f != null)
        {
            f.clear();
            f = null;
        }
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        f();
    }

    public int getCount()
    {
        return d.size() + e.size() + f.size();
    }

    public Object getItem(int i1)
    {
        return a(i1);
    }

    public long getItemId(int i1)
    {
        return -1L;
    }

    public int getItemViewType(int i1)
    {
        return i1 != 0 || !b ? 1 : 0;
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        boolean flag1 = true;
        p p1;
        boolean flag;
        if (a(i1).c != null && (a(i1).c.equals("Eyebrow_general") || a(i1).c.equals("default_original_double_eyelid")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (a(i1, view))
        {
            view = (TemplateButton)view;
        } else
        if (i1 == 0 && b)
        {
            view = new TemplateButton(a, TemplateButton.LayoutType.a, StatusManager.j().s());
        } else
        {
            view = new TemplateButton(a, TemplateButton.LayoutType.b, StatusManager.j().s());
            view.setOnItemDelete(g);
        }
        if (i1 == 0 && b)
        {
            long l1 = CategoryType.a(StatusManager.j().s());
            view.b(af.a(MoreMakeupActivity.a, l1));
            return view;
        }
        viewgroup = a(i1).c;
        p1 = (p)view.getTag();
        if (view.getTag() == null || !p1.c.equals(viewgroup))
        {
            viewgroup = PanelDataCenter.a().p(viewgroup);
            view.setTag(new p(viewgroup.c(), viewgroup.a(), viewgroup.d(), viewgroup.e().booleanValue(), viewgroup.i()));
        }
        viewgroup = a(i1).b;
        view.setName(a(i1).a());
        view.a(k, viewgroup);
        view.a(b(i1));
        view.d(flag);
        if (h && c(i1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.c(flag);
        if (c() == i1 && d())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.e(flag);
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    private class DeletableItemPosition extends Enum
    {

        public static final DeletableItemPosition a;
        public static final DeletableItemPosition b;
        private static final DeletableItemPosition c[];

        public static DeletableItemPosition valueOf(String s)
        {
            return (DeletableItemPosition)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanelItemAdapter$DeletableItemPosition, s);
        }

        public static DeletableItemPosition[] values()
        {
            return (DeletableItemPosition[])c.clone();
        }

        static 
        {
            a = new DeletableItemPosition("FRONT", 0);
            b = new DeletableItemPosition("REAR", 1);
            c = (new DeletableItemPosition[] {
                a, b
            });
        }

        private DeletableItemPosition(String s, int i1)
        {
            super(s, i1);
        }
    }

}
