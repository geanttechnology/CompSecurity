// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.sessionm.ui:
//            ProgressViewController

class this._cls0
    implements android.view.._cls1
{

    final ProgressViewController this$0;

    public void onClick(View view)
    {
        ProgressViewController.access$200(ProgressViewController.this).runOnUiThread(new Runnable() {

            final ProgressViewController._cls1 this$1;

            public void run()
            {
                if (ProgressViewController.access$000(this$0) == ProgressViewController.ReloadPromptState.UNAVAILABLE)
                {
                    ProgressViewController.access$100(this$0).onCancel();
                    return;
                } else
                {
                    setReloadPropmptState(ProgressViewController.ReloadPromptState.LOADING);
                    ProgressViewController.access$100(this$0).onReloadStarted();
                    return;
                }
            }

            
            {
                this$1 = ProgressViewController._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = ProgressViewController.this;
        super();
    }
}
