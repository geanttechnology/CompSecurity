// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.os.Handler;
import android.os.Looper;
import org.apache.cordova.CordovaPlugin;

public class MASHCordovaPlugin extends CordovaPlugin
{

    protected static final String TAG = com/amazon/mobile/mash/api/MASHCordovaPlugin.getSimpleName();
    private Handler mHandler;

    public MASHCordovaPlugin()
    {
        mHandler = new Handler(Looper.getMainLooper());
    }

    protected void runOnUiThread(Runnable runnable)
    {
        mHandler.post(runnable);
    }

}
