// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            ShareAlbumAction

class this._cls1 extends ShowDialogSyncTask
{

    final this._cls1 this$1;

    protected Dialog createDialog()
    {
        return cess._mth300(this._cls1.this);
    }

    (Activity activity)
    {
        this$1 = this._cls1.this;
        super(activity);
    }
}
