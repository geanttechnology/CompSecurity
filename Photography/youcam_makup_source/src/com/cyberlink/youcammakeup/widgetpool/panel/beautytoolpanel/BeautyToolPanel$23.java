// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, k

class a
    implements android.view.r
{

    final BeautyToolPanel a;

    public void onClick(View view)
    {
        view = (String)view.getTag();
        a.a(view);
        a.c.a(view, new Float[0]);
    }

    (BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
