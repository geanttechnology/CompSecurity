// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.aio.downloader.dialog.LianwangDialog;

// Referenced classes of package com.aio.downloader.adapter:
//            WidgetPaidGridviewAdapter

class val.dialog
    implements android.view.viewAdapter._cls5
{

    final WidgetPaidGridviewAdapter this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        WidgetPaidGridviewAdapter.access$0(WidgetPaidGridviewAdapter.this).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_widgetpaidgridviewadapter;
        val$dialog = LianwangDialog.this;
        super();
    }
}
