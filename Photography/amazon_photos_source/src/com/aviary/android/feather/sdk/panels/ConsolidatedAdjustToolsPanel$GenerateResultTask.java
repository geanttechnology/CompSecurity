// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.library.services.IAviaryController;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            ConsolidatedAdjustToolsPanel

class mProgress extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final ConsolidatedAdjustToolsPanel this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        mLogger.doInBackground("GenerateResultTask::doInBackground", new Object[] {
            Boolean.valueOf(mIsRendering)
        });
        while (mIsRendering) ;
        return null;
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Void)obj);
    }

    protected void doPostExecute(Void void1)
    {
        mLogger.doPostExecute("GenerateResultTask::PostExecute");
        if (getContext().getBaseActivity().isFinishing())
        {
            return;
        }
        if (mProgress.isShowing())
        {
            mProgress.dismiss();
        }
        onComplete(mPreview);
    }

    protected void doPreExecute()
    {
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.ltTask.mProgress));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.ltTask.mProgress));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    ()
    {
        this$0 = ConsolidatedAdjustToolsPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
