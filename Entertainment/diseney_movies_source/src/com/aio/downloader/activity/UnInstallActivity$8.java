// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.DialogInterface;

// Referenced classes of package com.aio.downloader.activity:
//            UnInstallActivity

class this._cls0
    implements android.content.ickListener
{

    final UnInstallActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        finish();
    }

    ()
    {
        this$0 = UnInstallActivity.this;
        super();
    }
}
