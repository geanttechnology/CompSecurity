// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.widgetpool.common.o;
import com.cyberlink.youcammakeup.widgetpool.common.s;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a
    implements s
{

    final PalettesPanel a;

    public void a(View view, int i, int j)
    {
        if (PalettesPanel.m(a) || ((aw)PalettesPanel.f(a).b(i, j)).g() == com.cyberlink.youcammakeup.utility.ourceType.a)
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.utility.o.a(a.getActivity().getFragmentManager(), PalettesPanel.n(a), com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel.PalettesPanel.o(a));
            PalettesPanel.a(a, true);
            PalettesPanel.f(a).a(true);
            return;
        }
    }

    (PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
