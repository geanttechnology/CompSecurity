// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.res.Resources;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.dialogs.y;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, r, BeautyToolPanelItemAdapter, p

class a
    implements Runnable
{

    final String a;
    final a b;

    public void run()
    {
        ((r)b.b.c).a(a, "default_original_wig");
    }

    b(b b1, String s)
    {
        b = b1;
        a = s;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$3

/* anonymous class */
    class BeautyToolPanel._cls3
        implements android.view.View.OnClickListener
    {

        final BeautyToolPanel a;

        private void a(int i, int j, String s)
        {
            if (i != j) goto _L2; else goto _L1
_L1:
            if (s != null) goto _L4; else goto _L3
_L3:
            j = i;
            if (i == a.h.getCount())
            {
                j = i - 1;
            }
            s = a.h.a(j).c;
_L8:
            StatusManager.j().b(s);
            StatusManager.j().a(s, false, new Float[0]);
            a.h.d(j);
_L6:
            return;
_L4:
            for (i = 0; i < a.h.getCount(); i++)
            {
                if (a.h.a(i) != null && a.h.a(i).c.equals(s))
                {
                    j = i;
                    continue; /* Loop/switch isn't completed */
                }
            }

            break; /* Loop/switch isn't completed */
_L2:
            if (i > j)
            {
                a.h.d(i - 1);
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
            j = 1;
            if (true) goto _L8; else goto _L7
_L7:
        }

        static void a(BeautyToolPanel._cls3 _pcls3, String s)
        {
            _pcls3.a(s);
        }

        private void a(String s)
        {
            BeautyMode beautymode = StatusManager.j().s();
            String s1 = StatusManager.j().g();
            PanelDataCenter.a().a(s, true);
            int i = a.h.c();
            int j = a.c(s);
            a.h.a(beautymode, s1);
            if (beautymode == BeautyMode.x && a.c != null && (a.c instanceof r))
            {
                ((r)a.c).e(s);
                a(i, j, "default_original_wig");
            } else
            {
                a(i, j, null);
            }
            if (!a.h.b())
            {
                o.c();
            }
            a.h.notifyDataSetChanged();
            if (beautymode == BeautyMode.x && a.c != null && (a.c instanceof r))
            {
                Globals.a(new BeautyToolPanel._cls3._cls2(this, s), 300L);
            }
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
                o1.a(new BeautyToolPanel._cls3._cls1(o1, view));
                return;
            } else
            {
                a(view);
                return;
            }
        }

            
            {
                a = beautytoolpanel;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$3$1

/* anonymous class */
        class BeautyToolPanel._cls3._cls1
            implements w
        {

            final o a;
            final String b;
            final BeautyToolPanel._cls3 c;

            public void a(boolean flag)
            {
                a.i(c.a.getActivity());
                BeautyToolPanel._cls3.a(c, b);
            }

            public void b(boolean flag)
            {
                a.i(c.a.getActivity());
            }

                    
                    {
                        c = BeautyToolPanel._cls3.this;
                        a = o1;
                        b = s;
                        super();
                    }
        }

    }

}
