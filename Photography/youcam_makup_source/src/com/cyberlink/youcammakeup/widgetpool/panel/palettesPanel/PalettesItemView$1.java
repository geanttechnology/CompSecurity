// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            PalettesItemView

class a
    implements android.view.r
{

    final PalettesItemView a;

    public void onClick(View view)
    {
        if (PalettesItemView.a(a) != null)
        {
            PalettesItemView.a(a).onClick(a);
        }
    }

    (PalettesItemView palettesitemview)
    {
        a = palettesitemview;
        super();
    }
}
