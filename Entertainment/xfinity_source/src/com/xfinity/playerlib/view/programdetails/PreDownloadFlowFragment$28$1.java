// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.google.common.util.concurrent.FutureCallback;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.t
    implements Provider
{

    final get this$1;
    final Throwable val$t;

    public CALDialogFragment get()
    {
        CALDialogFragment caldialogfragment = PreDownloadFlowFragment.access$3100(_fld0).createErrorDialogForThrowable(val$t, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

            final PreDownloadFlowFragment._cls28._cls1 this$2;

            public void tryAgain()
            {
                PreDownloadFlowFragment.access$4500(this$0);
            }

            
            {
                this$2 = PreDownloadFlowFragment._cls28._cls1.this;
                super();
            }
        });
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(_fld0));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$t = Throwable.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28

/* anonymous class */
    class PreDownloadFlowFragment._cls28
        implements FutureCallback
    {

        final PreDownloadFlowFragment this$0;

        public void onFailure(Throwable throwable)
        {
            PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).error("Download submission failed", throwable);
            if (!isResumed())
            {
                abortFlow();
                return;
            } else
            {
                PreDownloadFlowFragment.access$3200(PreDownloadFlowFragment.this, throwable. new PreDownloadFlowFragment._cls28._cls1(), "submitDownload", false);
                return;
            }
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((Void)obj);
        }

        public void onSuccess(Void void1)
        {
            PreDownloadFlowFragment.access$100(PreDownloadFlowFragment.this).debug("Download submitted, completing flow");
            completeFlow();
        }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }
    }

}
