// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            LookItemPopupMenu

class a
    implements android.content.yListener
{

    final LookItemPopupMenu a;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getAction() == 1)
        {
            LookItemPopupMenu.d(a);
            return true;
        } else
        {
            return false;
        }
    }

    (LookItemPopupMenu lookitempopupmenu)
    {
        a = lookitempopupmenu;
        super();
    }
}
