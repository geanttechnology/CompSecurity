// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.groupon.view:
//            AutoDismissPopupWindow

class val.handler extends TimerTask
{

    final AutoDismissPopupWindow this$0;
    final Handler val$handler;

    public void run()
    {
        val$handler.post(new Runnable() {

            final AutoDismissPopupWindow._cls1 this$1;

            public void run()
            {
                dismiss();
            }

            
            {
                this$1 = AutoDismissPopupWindow._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_autodismisspopupwindow;
        val$handler = Handler.this;
        super();
    }
}
