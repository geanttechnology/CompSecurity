// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.content.DialogInterface;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, BeautyToolPanelItemAdapter

class a
    implements android.content.DismissListener
{

    final BeautyToolPanel a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (a.h != null && (!Globals.d().i().a() || Globals.d().i().b()))
        {
            a.i.setChoiceMode(1);
            a.i.a(a.h.c(), true);
            a.h.a(false);
            if (a.k != null)
            {
                a.k.setClickable(false);
            }
        }
    }

    mAdapter(BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
