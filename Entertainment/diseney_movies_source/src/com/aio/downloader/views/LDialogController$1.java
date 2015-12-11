// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.os.Handler;
import android.os.Message;
import android.view.View;

// Referenced classes of package com.aio.downloader.views:
//            LDialogController

class this._cls0
    implements android.view.
{

    final LDialogController this$0;

    public void onClick(View view)
    {
        Object obj = null;
        Message message;
        if (view == LDialogController.access$0(LDialogController.this) && LDialogController.access$1(LDialogController.this) != null)
        {
            message = Message.obtain(LDialogController.access$1(LDialogController.this));
        } else
        {
            message = obj;
            if (view == LDialogController.access$2(LDialogController.this))
            {
                message = obj;
                if (LDialogController.access$3(LDialogController.this) != null)
                {
                    message = Message.obtain(LDialogController.access$3(LDialogController.this));
                }
            }
        }
        if (message != null)
        {
            message.sendToTarget();
        }
        if (!clickPositiveBtnDismiss && view == LDialogController.access$0(LDialogController.this))
        {
            return;
        } else
        {
            LDialogController.access$4(LDialogController.this).obtainMessage(1, LDialogController.access$5(LDialogController.this)).sendToTarget();
            return;
        }
    }

    ()
    {
        this$0 = LDialogController.this;
        super();
    }
}
