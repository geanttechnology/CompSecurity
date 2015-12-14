// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.q;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            c, PalettesItemView

class a
    implements android.view..OnClickListener
{

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

    ttesItemView(c c1)
    {
        a = c1;
        super();
    }
}
