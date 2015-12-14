// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d, c

class b
    implements w
{

    final o a;
    final String b;
    final tivity c;

    public void a(boolean flag)
    {
        a.i(c.c.getActivity());
        tivity(c, b);
    }

    public void b(boolean flag)
    {
        a.i(c.c.getActivity());
    }

    nager(nager nager, o o1, String s)
    {
        c = nager;
        a = o1;
        b = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$18

/* anonymous class */
    class d._cls18
        implements android.view.View.OnClickListener
    {

        final d a;

        private void a(int i, int j, String s)
        {
            if (i != j) goto _L2; else goto _L1
_L1:
            if (s != null) goto _L4; else goto _L3
_L3:
            j = i;
            if (i == d.k(a).getCount())
            {
                j = i - 1;
            }
            s = d.k(a).a(j).c;
_L8:
            StatusManager.j().b(s);
            StatusManager.j().a(d.e(a).d(), false);
            d.k(a).d(j);
_L6:
            return;
_L4:
            for (i = 0; i < d.k(a).getCount(); i++)
            {
                if (d.k(a).a(i) != null && d.k(a).a(i).c.equals(s))
                {
                    j = i;
                    continue; /* Loop/switch isn't completed */
                }
            }

            break; /* Loop/switch isn't completed */
_L2:
            if (i > j)
            {
                d.k(a).d(i - 1);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
            j = 1;
            if (true) goto _L8; else goto _L7
_L7:
        }

        static void a(d._cls18 _pcls18, String s)
        {
            _pcls18.a(s);
        }

        private void a(String s)
        {
            String s1 = StatusManager.j().g();
            PanelDataCenter.a().a(s, true);
            int i = d.k(a).c();
            int j = d.a(a, s);
            d.k(a).a(a.a(), s1);
            a(i, j, null);
            if (!d.k(a).b())
            {
                o.c();
            }
            d.k(a).notifyDataSetChanged();
        }

        public void onClick(View view)
        {
            PanelDataCenter paneldatacenter = PanelDataCenter.a();
            view = ((View) (view.getTag()));
            if (!(view instanceof p))
            {
                return;
            }
            view = ((p)view).c;
            if (paneldatacenter.g(view))
            {
                o o1 = Globals.d().i();
                o1.c(a.getActivity());
                o1.a(null, a.getResources().getString(0x7f070335));
                o1.a(new y(true, true, true, true, a.getResources().getString(0x7f070366), a.getResources().getString(0x7f070365)));
                o1.a(new d._cls18._cls1(this, o1, view));
                return;
            } else
            {
                a(view);
                return;
            }
        }

            
            {
                a = d1;
                super();
            }
    }

}
