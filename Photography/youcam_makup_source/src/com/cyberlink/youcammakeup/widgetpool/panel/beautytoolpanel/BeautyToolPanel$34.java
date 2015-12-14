// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements android.view.r
{

    final BeautyToolPanel a;

    public void onClick(View view)
    {
        if (view.getId() == BeautyToolPanel.a(a).getId())
        {
            a.G();
        } else
        {
            if (view.getId() == BeautyToolPanel.b(a).getId())
            {
                a.F();
                return;
            }
            if (view.getId() == BeautyToolPanel.c(a).getId())
            {
                a.H();
                return;
            }
        }
    }

    (BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
