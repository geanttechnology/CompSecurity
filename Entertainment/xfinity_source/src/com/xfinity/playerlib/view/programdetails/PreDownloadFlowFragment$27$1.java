// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.util.Date;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements Provider
{

    final get this$1;

    public CALDialogFragment get()
    {
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlgRetryable");
        caldialogfragment.setTryAgainListener(new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

            final PreDownloadFlowFragment._cls27._cls1 this$2;

            public void tryAgain()
            {
                PreDownloadFlowFragment.access$4100(this$0);
            }

            
            {
                this$2 = PreDownloadFlowFragment._cls27._cls1.this;
                super();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("description", getResources().getString(com.xfinity.playerlib.r_msg_connection_problem));
        caldialogfragment.addArguments(bundle);
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(_fld0));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    ingExecutionListener()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27

/* anonymous class */
    class PreDownloadFlowFragment._cls27 extends PreDownloadFlowFragment.RetryingExecutionListener
    {

        final PreDownloadFlowFragment this$0;

        public void onError(TaskExecutionException taskexecutionexception)
        {
            if (taskexecutionexception.getCause() instanceof com.xfinity.playerlib.downloads.MediaLicenseClient.LicenseAcquisitionTimeoutException)
            {
                PreDownloadFlowFragment.access$3200(PreDownloadFlowFragment.this, new PreDownloadFlowFragment._cls27._cls1(), "acquireMediaLicense", false);
                return;
            } else
            {
                super.onError(taskexecutionexception);
                return;
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((Date)obj);
        }

        public void onPostExecute(Date date)
        {
            PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Acquired media license");
            PreDownloadFlowFragment.access$4402(PreDownloadFlowFragment.this, date);
            PreDownloadFlowFragment.access$4500(PreDownloadFlowFragment.this);
        }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(PreDownloadFlowFragment.this, taskexecutor);
            }
    }

}
