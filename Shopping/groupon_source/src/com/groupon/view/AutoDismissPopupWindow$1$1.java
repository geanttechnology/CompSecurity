// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Handler;
import java.util.TimerTask;

// Referenced classes of package com.groupon.view:
//            AutoDismissPopupWindow

class this._cls1
    implements Runnable
{

    final iss this$1;

    public void run()
    {
        dismiss();
    }

    l.handler()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/view/AutoDismissPopupWindow$1

/* anonymous class */
    class AutoDismissPopupWindow._cls1 extends TimerTask
    {

        final AutoDismissPopupWindow this$0;
        final Handler val$handler;

        public void run()
        {
            handler.post(new AutoDismissPopupWindow._cls1._cls1());
        }

            
            {
                this$0 = final_autodismisspopupwindow;
                handler = Handler.this;
                super();
            }
    }

}
