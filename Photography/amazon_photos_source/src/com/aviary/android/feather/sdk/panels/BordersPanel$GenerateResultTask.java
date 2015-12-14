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
//            BordersPanel

class ontext extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final BordersPanel this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        mLogger.doInBackground("GenerateResultTask::doInBackground", new Object[] {
            mIsRendering
        });
        for (; mIsRendering.booleanValue(); mLogger.doInBackground("waiting....")) { }
        return null;
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((Void)obj);
    }

    protected void doPostExecute(Void void1)
    {
        if (getContext().getBaseActivity().isFinishing())
        {
            return;
        }
        if (mProgress.isShowing())
        {
            mProgress.dismiss();
        }
        onGenerateFinalBitmap();
    }

    protected void doPreExecute()
    {
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.etBaseContext));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.message));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    ()
    {
        this$0 = BordersPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
