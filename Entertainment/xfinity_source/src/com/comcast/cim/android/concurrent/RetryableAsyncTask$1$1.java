// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.concurrent;

import android.app.Activity;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;

// Referenced classes of package com.comcast.cim.android.concurrent:
//            RetryableAsyncTask

class this._cls1
    implements com.comcast.cim.android.view.common.ainListener
{

    final is._cls0 this$1;

    public void tryAgain()
    {
        getNewInstance(activity).execute(RetryableAsyncTask.access$100(_fld0));
    }

    l.activity()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/android/concurrent/RetryableAsyncTask$1

/* anonymous class */
    class RetryableAsyncTask._cls1
        implements Runnable
    {

        final RetryableAsyncTask this$0;
        final Activity val$activity;

        public void run()
        {
            CALDialogFragment caldialogfragment = errorDialogFactory.createErrorDialogForThrowable(RetryableAsyncTask.access$000(RetryableAsyncTask.this), new RetryableAsyncTask._cls1._cls1());
            caldialogfragment.setOnCancelListener(RetryableAsyncTask.access$200(RetryableAsyncTask.this));
            caldialogfragment.show(activity.getFragmentManager(), "caldialogfragment");
        }

            
            {
                this$0 = final_retryableasynctask;
                activity = Activity.this;
                super();
            }
    }

}
