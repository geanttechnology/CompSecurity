// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.services.IAviaryController;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BlemishPanel, BackgroundDrawThread

class ontext extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final BlemishPanel this$0;

    protected transient MoaActionList doInBackground(Void avoid[])
    {
        avoid = MoaActionFactory.actionList();
        if (BlemishPanel.access$200(BlemishPanel.this) != null)
        {
            while (BlemishPanel.access$200(BlemishPanel.this) != null && !BlemishPanel.access$200(BlemishPanel.this).isCompleted()) 
            {
                mLogger.((new StringBuilder()).append("waiting.... ").append(BlemishPanel.access$200(BlemishPanel.this).getQueueSize()).toString());
                try
                {
                    Thread.sleep(50L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
            }
        }
        avoid.add(BlemishPanel.access$300(BlemishPanel.this).getActions().get(0));
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void doPostExecute(MoaActionList moaactionlist)
    {
        if (getContext().getBaseActivity().isFinishing())
        {
            return;
        }
        if (mProgress.isShowing())
        {
            try
            {
                mProgress.dismiss();
            }
            catch (IllegalArgumentException illegalargumentexception) { }
        }
        BlemishPanel.access$400(BlemishPanel.this, mPreview, moaactionlist);
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((MoaActionList)obj);
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
        this$0 = BlemishPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
