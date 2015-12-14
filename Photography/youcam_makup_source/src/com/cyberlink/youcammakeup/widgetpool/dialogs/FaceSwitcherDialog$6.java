// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.a;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            FaceSwitcherDialog

class a
    implements android.content.Listener
{

    final FaceSwitcherDialog a;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getAction() == 1)
        {
            com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.a(a, com.cyberlink.youcammakeup.widgetpool.dialogs.smissType.a, com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.a(a).e);
            return true;
        } else
        {
            return false;
        }
    }

    smissType(FaceSwitcherDialog faceswitcherdialog)
    {
        a = faceswitcherdialog;
        super();
    }
}
