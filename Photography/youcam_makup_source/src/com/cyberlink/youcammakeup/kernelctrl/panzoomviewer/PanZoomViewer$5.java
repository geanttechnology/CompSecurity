// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class a
    implements r
{

    final EditViewActivity a;
    final PanZoomViewer b;

    public void a()
    {
        a.finish();
    }

    I(PanZoomViewer panzoomviewer, EditViewActivity editviewactivity)
    {
        b = panzoomviewer;
        a = editviewactivity;
        super();
    }
}
