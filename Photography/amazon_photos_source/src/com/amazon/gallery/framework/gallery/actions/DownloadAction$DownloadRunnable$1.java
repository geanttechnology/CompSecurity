// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.widget.Toast;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DownloadAction

class val.toastMessageId
    implements Runnable
{

    final val.toastMessageId this$1;
    final int val$toastMessageId;

    public void run()
    {
        Toast.makeText(DownloadAction.access$500(_fld0), val$toastMessageId, 0).show();
    }

    ()
    {
        this$1 = final_;
        val$toastMessageId = I.this;
        super();
    }
}
