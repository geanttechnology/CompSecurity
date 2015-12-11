// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.os.AsyncTask;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.voice.MShopVoicePackageProxy;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupSequenceMediator, StartupTask

private static class mTask extends AsyncTask
{

    private StartupTask mTask;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        AIVAvailabilityUtils.waitForAIVInitialize();
        CloudDriveAvailability.getInstance().waitForInitialization();
        MShopVoicePackageProxy.getInstance().waitForInitialization();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mTask.end("taskResultSucceed");
    }

    public (StartupTask startuptask)
    {
        mTask = startuptask;
    }
}
