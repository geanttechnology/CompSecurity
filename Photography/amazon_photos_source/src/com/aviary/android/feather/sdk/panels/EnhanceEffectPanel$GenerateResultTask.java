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
//            EnhanceEffectPanel

class  extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final EnhanceEffectPanel this$0;

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
        mLogger.doPostExecute("GenerateResultTask::doPostExecute");
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
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.Context));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.e));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    Q()
    {
        this$0 = EnhanceEffectPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
