// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.p;
import com.cyberlink.youcammakeup.widgetpool.common.o;
import com.cyberlink.youcammakeup.widgetpool.d.c;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel, e, a

class a
    implements p
{

    final PalettesPanel a;

    public void a(AdapterView adapterview, View view, int i, long l)
    {
        EditViewActivity editviewactivity;
        if (PalettesPanel.b(a) != null && PalettesPanel.b(a).getCount() >= i + 1)
        {
            if ((adapterview = PalettesPanel.b(a).a(i)) != null && adapterview.a() != null && !adapterview.a().equalsIgnoreCase(com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.c(a)) && ((editviewactivity = (EditViewActivity)a.getActivity()) != null && !editviewactivity.isFinishing() && !editviewactivity.b()))
            {
                if (PalettesPanel.d(a).containsKey(adapterview))
                {
                    PalettesPanel.d(a).put(adapterview, Integer.valueOf(((Integer)PalettesPanel.d(a).get(adapterview)).intValue() + 1));
                } else
                {
                    PalettesPanel.d(a).put(adapterview, Integer.valueOf(1));
                }
                view = adapterview.a();
                PalettesPanel.b(a, view);
                com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.c(a, view);
                if (view.equalsIgnoreCase(PalettesPanel.h()))
                {
                    if (PalettesPanel.e(a).a == -1 || PalettesPanel.e(a).b == -1)
                    {
                        PalettesPanel.e(a).a = letteGroup.a(letteGroup.e);
                        PalettesPanel.e(a).b = 1;
                    }
                    adapterview = (aw)PalettesPanel.a(a, PalettesPanel.e(a).a).get(PalettesPanel.e(a).b);
                    PalettesPanel.f(a).a(PalettesPanel.e(a));
                    editviewactivity.a(null, adapterview.a());
                    return;
                }
                adapterview = (String)PalettesPanel.g(a).get(view);
                if (adapterview == null && PalettesPanel.h(a).containsKey(view))
                {
                    adapterview = (String)((List)PalettesPanel.h(a).get(view)).get(0);
                }
                String s = (String)PalettesPanel.i(a).get(adapterview);
                view = s;
                if (s == null)
                {
                    view = (String)PanelDataCenter.a().l(adapterview).get(0);
                }
                PalettesPanel.j(a).b(PalettesPanel.d(a, adapterview));
                editviewactivity.a(null, view);
                return;
            }
        }
    }

    letteGroup(PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
