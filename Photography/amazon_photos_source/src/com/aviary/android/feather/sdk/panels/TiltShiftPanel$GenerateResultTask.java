// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.services.IAviaryController;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            TiltShiftPanel

class text extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final TiltShiftPanel this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (TiltShiftPanel.access$400(TiltShiftPanel.this) != null)
        {
            while (TiltShiftPanel.access$400(TiltShiftPanel.this) != null && !TiltShiftPanel.access$400(TiltShiftPanel.this).isCompleted()) 
            {
                mLogger.isCompleted((new StringBuilder()).append("waiting.... ").append(TiltShiftPanel.access$400(TiltShiftPanel.this).getQueueSize()).toString());
                try
                {
                    Thread.sleep(50L);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
            }
        }
        mActions.add(TiltShiftPanel.access$200(TiltShiftPanel.this).getActions().get(0));
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
            try
            {
                mProgress.dismiss();
            }
            // Misplaced declaration of an exception variable
            catch (Void void1) { }
        }
        onComplete(mPreview, mActions);
    }

    protected void doPreExecute()
    {
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.BaseContext));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.ssage));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    d()
    {
        this$0 = TiltShiftPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
