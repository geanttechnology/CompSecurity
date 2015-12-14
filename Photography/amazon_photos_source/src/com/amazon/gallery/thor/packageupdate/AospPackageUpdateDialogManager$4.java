// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.content.DialogInterface;
import android.view.KeyEvent;

// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            AospPackageUpdateDialogManager

class this._cls0
    implements android.content.UpdateDialogManager._cls4
{

    final AospPackageUpdateDialogManager this$0;

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        return i == 84 && keyevent.getRepeatCount() == 0;
    }

    ()
    {
        this$0 = AospPackageUpdateDialogManager.this;
        super();
    }
}
