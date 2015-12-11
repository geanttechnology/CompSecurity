// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.concurrent;

import android.app.Activity;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;

// Referenced classes of package com.comcast.cim.android.concurrent:
//            RetryableAsyncTask

class val.activity
    implements Runnable
{

    final RetryableAsyncTask this$0;
    final Activity val$activity;

    public void run()
    {
        CALDialogFragment caldialogfragment = errorDialogFactory.createErrorDialogForThrowable(RetryableAsyncTask.access$000(RetryableAsyncTask.this), new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

            final RetryableAsyncTask._cls1 this$1;

            public void tryAgain()
            {
                getNewInstance(activity).execute(RetryableAsyncTask.access$100(this$0));
            }

            
            {
                this$1 = RetryableAsyncTask._cls1.this;
                super();
            }
        });
        caldialogfragment.setOnCancelListener(RetryableAsyncTask.access$200(RetryableAsyncTask.this));
        caldialogfragment.show(val$activity.getFragmentManager(), "caldialogfragment");
    }

    _cls1.this._cls1()
    {
        this$0 = final_retryableasynctask;
        val$activity = Activity.this;
        super();
    }
}
