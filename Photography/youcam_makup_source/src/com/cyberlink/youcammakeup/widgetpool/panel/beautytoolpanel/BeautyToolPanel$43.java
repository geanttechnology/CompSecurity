// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, BeautyToolPanelItemAdapter

class a
    implements android.view.r
{

    final BeautyToolPanel a;

    public void onClick(View view)
    {
        a.k.setClickable(false);
        if (a.h != null && a.h.a())
        {
            o.c();
        }
    }

    Adapter(BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
