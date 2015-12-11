// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.app.Activity;
import com.poshmark.application.PMApplication;
import java.util.TimerTask;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMProgressDialog

public class parent extends TimerTask
{

    PMProgressDialog parent;
    final PMProgressDialog this$0;

    public void run()
    {
        com.poshmark.ui.PMActivity pmactivity = PMApplication.getApplicationObject().getTopActivity();
        if (pmactivity != null)
        {
            pmactivity.runOnUiThread(new Runnable() {

                final PMProgressDialog.AutoHideTimerTask this$1;

                public void run()
                {
                    bAutoHide = false;
                    dismiss();
                    if (dismissListener != null)
                    {
                        dismissListener.dialogDismissed();
                        dismissListener = null;
                    }
                }

            
            {
                this$1 = PMProgressDialog.AutoHideTimerTask.this;
                super();
            }
            });
        }
    }

    _cls1.this._cls1(PMProgressDialog pmprogressdialog1)
    {
        this$0 = PMProgressDialog.this;
        super();
        parent = pmprogressdialog1;
    }
}
