// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            LDialogListBuilder, LDialogController

class val.position
    implements android.view.emAdapter._cls1
{

    final val.position this$1;
    private final int val$position;

    public void onClick(View view)
    {
        if (LDialogListBuilder.access$0(cess._mth0(this._cls1.this)) != null)
        {
            if (LDialogListBuilder.access$1(cess._mth0(this._cls1.this)) == null)
            {
                view = null;
            } else
            {
                view = LDialogListBuilder.access$1(cess._mth0(this._cls1.this)).getDialogInterface();
            }
            LDialogListBuilder.access$0(cess._mth0(this._cls1.this)).ck(view, val$position);
            if (view != null)
            {
                view.dismiss();
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
