// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.os.AsyncTask;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager, FrameworkExperiments

class this._cls0 extends AsyncTask
{

    final ExperimentationDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        ExperimentationDataManager.access$700(new Runnable() {

            final ExperimentationDataManager._cls1 this$1;
            final ExperimentationDataManager.VersionedState val$state;

            public void run()
            {
                ExperimentationDataManager.access$100(this$0, state);
                ExperimentationDataManager.access$200(this$0, FrameworkExperiments.getExperiments());
                if (ExperimentationDataManager.logger.isLoggable)
                {
                    ExperimentationDataManager.logger.log("ExperimentationDataManager secondary initialization complete");
                }
                ExperimentationDataManager.access$302(this$0, true);
                if (ExperimentationDataManager.access$400(this$0))
                {
                    requalify(false);
                    return;
                } else
                {
                    ((ExperimentationDataManager.Observer)ExperimentationDataManager.access$600(this$0)).onTreatmentsAvailable(this$0, ExperimentationDataManager.access$500(this$0));
                    return;
                }
            }

            
            {
                this$1 = ExperimentationDataManager._cls1.this;
                state = versionedstate;
                super();
            }
        });
        return null;
    }

    _cls1.val.state()
    {
        this$0 = ExperimentationDataManager.this;
        super();
    }
}
