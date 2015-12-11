// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.os.AsyncTask;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager, FrameworkExperiments

class ionedState
    implements Runnable
{

    final is._cls0 this$1;
    final ionedState val$state;

    public void run()
    {
        ExperimentationDataManager.access$100(_fld0, val$state);
        ExperimentationDataManager.access$200(_fld0, FrameworkExperiments.getExperiments());
        if (ExperimentationDataManager.logger.logger)
        {
            ExperimentationDataManager.logger.logger("ExperimentationDataManager secondary initialization complete");
        }
        ExperimentationDataManager.access$302(_fld0, true);
        if (ExperimentationDataManager.access$400(_fld0))
        {
            requalify(false);
            return;
        } else
        {
            ((rver)ExperimentationDataManager.access$600(_fld0)).onTreatmentsAvailable(_fld0, ExperimentationDataManager.access$500(_fld0));
            return;
        }
    }

    ionedState()
    {
        this$1 = final_ionedstate;
        val$state = ionedState.this;
        super();
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$1

/* anonymous class */
    class ExperimentationDataManager._cls1 extends AsyncTask
    {

        final ExperimentationDataManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            ExperimentationDataManager.access$700(ExperimentationDataManager.access$000(ExperimentationDataManager.this). new ExperimentationDataManager._cls1._cls1());
            return null;
        }

            
            {
                this$0 = ExperimentationDataManager.this;
                super();
            }
    }

}
