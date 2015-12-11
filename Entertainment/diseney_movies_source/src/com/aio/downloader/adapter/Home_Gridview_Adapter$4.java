// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.view.View;
import com.aio.downloader.dialog.LianwangDialog;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

class val.dialog
    implements android.view.iew_Adapter._cls4
{

    final Home_Gridview_Adapter this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_home_gridview_adapter;
        val$dialog = LianwangDialog.this;
        super();
    }
}
