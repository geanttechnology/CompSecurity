// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ai

class a
    implements android.content.gInterface.OnKeyListener
{

    final ai a;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (!ai.f(a).isEnabled())
        {
            return true;
        }
        if (i == 4 && keyevent.getAction() == 1)
        {
            ai.f(a).performClick();
            return true;
        } else
        {
            return false;
        }
    }

    (ai ai1)
    {
        a = ai1;
        super();
    }
}
