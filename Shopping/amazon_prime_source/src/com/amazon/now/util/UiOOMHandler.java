// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.now.platform.AndroidPlatform;
import java.lang.ref.WeakReference;

public class UiOOMHandler
{
    public static class UiRunnable
        implements Runnable
    {

        private boolean mNeedRetry;
        private int mRetryCounter;
        private Runnable mRunnable;

        public void run()
        {
            mRunnable.run();
_L1:
            return;
            Object obj;
            obj;
            System.gc();
            if (TextUtils.isEmpty(((OutOfMemoryError) (obj)).getMessage()))
            {
                obj = "OutOfMemory";
            } else
            {
                obj = ((OutOfMemoryError) (obj)).getMessage();
            }
            Log.e("OutOfMemory", ((String) (obj)));
            if (mNeedRetry)
            {
                int i = mRetryCounter;
                mRetryCounter = i + 1;
                if (i < 3)
                {
                    AndroidPlatform.getInstance().invokeLater(this, 230L);
                    return;
                }
            }
              goto _L1
        }

        public UiRunnable(Runnable runnable, boolean flag)
        {
            mRetryCounter = 0;
            mRunnable = runnable;
            mNeedRetry = flag;
        }
    }


    public static final String TAG = "OutOfMemory";
    private WeakReference mActivityWeakReference;
    private UiRunnable mUiRunnable;

    public UiOOMHandler(Activity activity, UiRunnable uirunnable)
    {
        mActivityWeakReference = new WeakReference(activity);
        mUiRunnable = uirunnable;
    }

    public void execute()
    {
        Activity activity = (Activity)mActivityWeakReference.get();
        if (activity != null)
        {
            activity.runOnUiThread(mUiRunnable);
        }
    }
}
