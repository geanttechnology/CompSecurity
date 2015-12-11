// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.app.Activity;
import android.view.View;

// Referenced classes of package com.sessionm.ui:
//            ProgressViewController

class this._cls1
    implements Runnable
{

    final ener.onReloadStarted this$1;

    public void run()
    {
        if (ProgressViewController.access$000(_fld0) == adPromptState.UNAVAILABLE)
        {
            ProgressViewController.access$100(_fld0).onCancel();
            return;
        } else
        {
            setReloadPropmptState(adPromptState.LOADING);
            ProgressViewController.access$100(_fld0).onReloadStarted();
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/sessionm/ui/ProgressViewController$1

/* anonymous class */
    class ProgressViewController._cls1
        implements android.view.View.OnClickListener
    {

        final ProgressViewController this$0;

        public void onClick(View view)
        {
            ProgressViewController.access$200(ProgressViewController.this).runOnUiThread(new ProgressViewController._cls1._cls1());
        }

            
            {
                this$0 = ProgressViewController.this;
                super();
            }
    }

}
