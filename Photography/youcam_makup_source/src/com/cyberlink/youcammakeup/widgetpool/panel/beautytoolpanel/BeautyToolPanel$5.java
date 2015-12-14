// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.AdapterView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.q;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, BeautyToolPanelItemAdapter

class a
    implements q
{

    final android.content.DismissListener a;
    final BeautyToolPanel b;

    public boolean a(AdapterView adapterview, View view, int i, long l)
    {
        while (StatusManager.j().s() == BeautyMode.n || b.h == null || b.h.a() || !b.h.c(i)) 
        {
            return false;
        }
        b.i.setChoiceMode(0);
        b.h.a(true);
        if (b.i != null)
        {
            o.a(b.getFragmentManager(), b.i, a);
            if (b.k != null)
            {
                b.k.setClickable(true);
            }
        }
        return true;
    }

    mAdapter(BeautyToolPanel beautytoolpanel, android.content.DismissListener dismisslistener)
    {
        b = beautytoolpanel;
        a = dismisslistener;
        super();
    }
}
