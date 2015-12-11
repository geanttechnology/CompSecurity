// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.Intent;
import android.view.View;
import com.aio.downloader.dialog.LianwangDialog;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity_Rub

class val.dialog
    implements android.view.tivity_Rub._cls10
{

    final ShowCleanActivity_Rub this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        val$dialog.dismiss();
    }

    _cls9()
    {
        this$0 = final_showcleanactivity_rub;
        val$dialog = LianwangDialog.this;
        super();
    }
}
