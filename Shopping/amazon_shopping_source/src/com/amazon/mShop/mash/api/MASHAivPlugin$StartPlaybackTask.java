// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.app.Activity;
import android.util.Log;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static class <init>
    implements Runnable
{

    private final Activity mActivity;
    private final String mAsin;
    private final CordovaPlugin mCordovaPlugin;
    private final int mTimecode;

    public void run()
    {
        boolean flag = mActivity instanceof CordovaInterface;
        if (flag)
        {
            ((CordovaInterface)mActivity).setActivityResultCallback(mCordovaPlugin);
        } else
        {
            Log.e("aiv.StartPlayback", "The activity in StartPlayback is not a CordovaInterface. Cannot delay callback.");
        }
        AmazonInstantVideoProxy.getInstance().startPlayback(mActivity, mAsin, mTimecode);
        if (!flag)
        {
            mCordovaPlugin.onActivityResult(1, -1, null);
        }
    }

    private (String s, int i, CordovaPlugin cordovaplugin)
    {
        mActivity = cordovaplugin.cordova.getActivity();
        mAsin = s;
        mTimecode = i;
        mCordovaPlugin = cordovaplugin;
    }

    mCordovaPlugin(String s, int i, CordovaPlugin cordovaplugin, mCordovaPlugin mcordovaplugin)
    {
        this(s, i, cordovaplugin);
    }
}
