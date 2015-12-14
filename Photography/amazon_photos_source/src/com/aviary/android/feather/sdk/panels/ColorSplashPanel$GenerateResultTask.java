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
//            ColorSplashPanel, BackgroundDrawThread

class xt extends AviaryAsyncTask
{

    ProgressDialog mProgress;
    final ColorSplashPanel this$0;

    protected transient MoaActionList doInBackground(Void avoid[])
    {
        avoid = MoaActionFactory.actionList();
        if (ColorSplashPanel.access$000(ColorSplashPanel.this) != null)
        {
            while (ColorSplashPanel.access$000(ColorSplashPanel.this) != null && !ColorSplashPanel.access$000(ColorSplashPanel.this).isCompleted()) 
            {
                mLogger._mth0((new StringBuilder()).append("waiting.... ").append(ColorSplashPanel.access$000(ColorSplashPanel.this).getQueueSize()).toString());
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
        avoid.add(ColorSplashPanel.access$100(ColorSplashPanel.this).getActions().get(0));
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
        ColorSplashPanel.access$200(ColorSplashPanel.this, mPreview, moaactionlist);
    }

    protected volatile void doPostExecute(Object obj)
    {
        doPostExecute((MoaActionList)obj);
    }

    protected void doPreExecute()
    {
        mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.seContext));
        mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.age));
        mProgress.setIndeterminate(true);
        mProgress.setCancelable(false);
        mProgress.show();
    }

    ()
    {
        this$0 = ColorSplashPanel.this;
        super();
        mProgress = new ProgressDialog(getContext().getBaseContext());
    }
}
