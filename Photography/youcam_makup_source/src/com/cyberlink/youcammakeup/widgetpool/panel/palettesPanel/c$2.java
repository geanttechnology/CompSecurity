// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;

import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.common.p;
import com.cyberlink.youcammakeup.widgetpool.common.s;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel:
//            c

class a
    implements android.view..OnLongClickListener
{

    final c a;

    public boolean onLongClick(View view)
    {
        if (c.b(a) == null)
        {
            return true;
        } else
        {
            p p1 = (p)view.getTag();
            c.b(a).a(view, p1.a, p1.b);
            return true;
        }
    }

    (c c1)
    {
        a = c1;
        super();
    }
}
