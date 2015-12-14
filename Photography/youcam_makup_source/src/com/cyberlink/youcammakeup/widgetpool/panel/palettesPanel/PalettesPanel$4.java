// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.content.DialogInterface;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesPanel

class a
    implements android.content.OnDismissListener
{

    final PalettesPanel a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!Globals.d().i().a())
        {
            PalettesPanel.a(a, false);
            PalettesPanel.f(a).a(false);
        }
    }

    (PalettesPanel palettespanel)
    {
        a = palettespanel;
        super();
    }
}
