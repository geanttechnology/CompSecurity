// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;
import com.aio.downloader.dialog.RestaryDownloadDialog;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class val.list
    implements android.view..MyAsyncTask._cls2
{

    final val.list this$1;
    private final ArrayList val$list;
    private final RestaryDownloadDialog val$restarydialog;

    public void onClick(View view)
    {
        val$restarydialog.dismiss();
        (new nit>(cess._mth2(this._cls1.this))).ecute(new Void[0]);
        VideoActivity.access$12(cess._mth2(this._cls1.this), val$list);
    }

    ()
    {
        this$1 = final_;
        val$restarydialog = restarydownloaddialog;
        val$list = ArrayList.this;
        super();
    }
}
