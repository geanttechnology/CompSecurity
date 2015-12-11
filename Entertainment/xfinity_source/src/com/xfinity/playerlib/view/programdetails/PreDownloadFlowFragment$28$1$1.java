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

class this._cls2
    implements com.comcast.cim.android.view.common.ner
{

    final ._cls0 this$2;

    public void tryAgain()
    {
        PreDownloadFlowFragment.access$4500(_fld0);
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
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


    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1

/* anonymous class */
    class PreDownloadFlowFragment._cls28._cls1
        implements Provider
    {

        final PreDownloadFlowFragment._cls28 this$1;
        final Throwable val$t;

        public CALDialogFragment get()
        {
            CALDialogFragment caldialogfragment = PreDownloadFlowFragment.access$3100(this$0).createErrorDialogForThrowable(t, new PreDownloadFlowFragment._cls28._cls1._cls1());
            caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(this$0));
            return caldialogfragment;
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$1 = final__pcls28;
                t = Throwable.this;
                super();
            }
    }

}
