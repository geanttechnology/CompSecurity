// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a
    implements Runnable
{

    final h a;
    final PalettesPanel b;

    public void run()
    {
        PalettesPanel palettespanel = b;
        String s;
        if (PalettesPanel.a(b) != null)
        {
            s = a.b("eye_shadow", PalettesPanel.a(b)).e();
        } else
        {
            s = null;
        }
        PalettesPanel.a(palettespanel, s);
    }

    (PalettesPanel palettespanel, h h1)
    {
        b = palettespanel;
        a = h1;
        super();
    }
}
