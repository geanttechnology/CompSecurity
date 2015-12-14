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
import com.aviary.android.feather.library.vo.EditToolResultVO;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            DelayedSpotDrawPanel, BackgroundDrawThread

class mProgress extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final DelayedSpotDrawPanel this$0;

    protected transient MoaActionList doInBackground(Void avoid[])
    {
        avoid = MoaActionFactory.actionList();
        if (DelayedSpotDrawPanel.access$200(DelayedSpotDrawPanel.this) != null)
        {
            while (DelayedSpotDrawPanel.access$200(DelayedSpotDrawPanel.this) != null && !DelayedSpotDrawPanel.access$200(DelayedSpotDrawPanel.this).isCompleted()) 
            {
                mLogger._mth0((new StringBuilder()).append("waiting.... ").append(DelayedSpotDrawPanel.access$200(DelayedSpotDrawPanel.this).getQueueSize()).toString());
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
        avoid.add(DelayedSpotDrawPanel.access$300(DelayedSpotDrawPanel.this).getActions().get(0));
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
        mEditResult.setActionList(moaactionlist);
        mEditResult.setToolAction(DelayedSpotDrawPanel.access$400(DelayedSpotDrawPanel.this));
        onComplete(mPreview);
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((MoaActionList)obj);
    }

    protected void doPreExecute()
    {
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.ntext));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.ntext));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    ()
    {
        this$0 = DelayedSpotDrawPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
