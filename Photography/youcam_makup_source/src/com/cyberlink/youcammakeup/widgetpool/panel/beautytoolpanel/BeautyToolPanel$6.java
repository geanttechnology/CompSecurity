// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements Runnable
{

    final int a;
    final BeautyToolPanel b;

    public void run()
    {
        if (a >= b.i.getLastVisiblePosition())
        {
            b.i.setSelection(a);
        }
    }

    (BeautyToolPanel beautytoolpanel, int i)
    {
        b = beautytoolpanel;
        a = i;
        super();
    }
}
