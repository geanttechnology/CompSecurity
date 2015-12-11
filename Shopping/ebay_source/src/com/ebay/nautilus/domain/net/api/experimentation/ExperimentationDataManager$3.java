// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.os.AsyncTask;
import java.io.File;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            ExperimentationDataManager

class this._cls0 extends AsyncTask
{

    final ExperimentationDataManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!ExperimentationDataManager.access$900(ExperimentationDataManager.this).delete() && ExperimentationDataManager.logger.logger)
        {
            ExperimentationDataManager.logger.logger("Unable to delete old EP cache");
        }
        return null;
    }

    ()
    {
        this$0 = ExperimentationDataManager.this;
        super();
    }
}
