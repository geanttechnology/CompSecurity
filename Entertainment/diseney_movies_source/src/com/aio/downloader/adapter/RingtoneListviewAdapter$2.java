// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.view.View;
import com.aio.downloader.dialog.LianwangDialog;

// Referenced classes of package com.aio.downloader.adapter:
//            RingtoneListviewAdapter

class val.dialog
    implements android.view.viewAdapter._cls2
{

    final RingtoneListviewAdapter this$0;
    private final LianwangDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_ringtonelistviewadapter;
        val$dialog = LianwangDialog.this;
        super();
    }
}
