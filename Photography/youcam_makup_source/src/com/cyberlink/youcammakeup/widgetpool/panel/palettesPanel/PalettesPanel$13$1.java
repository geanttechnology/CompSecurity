// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.r;
import com.cyberlink.youcammakeup.widgetpool.common.u;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel, d

class c
    implements w
{

    final o a;
    final int b;
    final int c;
    final tivity d;

    public void a(boolean flag)
    {
        a.i(d.d.getActivity());
        tivity(d, b, c);
    }

    public void b(boolean flag)
    {
        a.i(d.d.getActivity());
    }

    teGroup(teGroup tegroup, o o1, int i, int j)
    {
        d = tegroup;
        a = o1;
        b = i;
        c = j;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/palettesPanel/PalettesPanel$13

/* anonymous class */
    class PalettesPanel._cls13
        implements r
    {

        final PalettesPanel a;

        private void a(int i, int j)
        {
            aw aw1 = (aw)PalettesPanel.f(a).b(i, j);
            List list = PalettesPanel.a(a, i);
            list.remove(j);
            PanelDataCenter.a().b(aw1.a(), true);
            ((d)PalettesPanel.q(a).get(PalettesPanel.PaletteGroup.a(PalettesPanel.PaletteGroup.a))).a(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.p(a));
            Object obj1 = a;
            Object obj;
            if (PalettesPanel.e(a).a == i && PalettesPanel.e(a).b > j)
            {
                obj = PalettesPanel.a(a, PalettesPanel.e(a).a, PalettesPanel.e(a).b - 1);
            } else
            {
                obj = PalettesPanel.a(a, PalettesPanel.e(a).a, PalettesPanel.e(a).b);
            }
            PalettesPanel.a(((PalettesPanel) (obj1)), ((p) (obj)));
            ((u)PalettesPanel.f(a).getGroup(i)).a(list);
            PalettesPanel.f(a).a(PalettesPanel.e(a));
            obj1 = Globals.d().t();
            list = null;
            obj = list;
            if (PalettesPanel.e(a).a >= 0)
            {
                obj = list;
                if (PalettesPanel.e(a).b >= 0)
                {
                    PalettesPanel.a(a, (aw)PalettesPanel.a(a, PalettesPanel.e(a).a).get(PalettesPanel.e(a).b));
                    obj = com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.r(a).a();
                }
            }
            if (obj1 != null && obj != null && !((String) (obj)).equals(aw1.a()))
            {
                ((EditViewActivity) (obj1)).a(((String) (obj)));
            }
            if (!PalettesPanel.s(a))
            {
                o.c();
            }
        }

        static void a(PalettesPanel._cls13 _pcls13, int i, int j)
        {
            _pcls13.a(i, j);
        }

        public void a(View view, int i, int j)
        {
            view = (aw)PalettesPanel.f(a).b(i, j);
            if (PanelDataCenter.a().h(view.a()))
            {
                view = Globals.d().i();
                view.c(a.getActivity());
                view.a(null, a.getResources().getString(0x7f070335));
                view.a(new y(true, true, true, true, a.getResources().getString(0x7f070366), a.getResources().getString(0x7f070365)));
                view.a(new PalettesPanel._cls13._cls1(this, view, i, j));
                return;
            } else
            {
                a(i, j);
                return;
            }
        }

            
            {
                a = palettespanel;
                super();
            }
    }

}
