// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.Util;

public class BaseActivity extends FragmentActivity
{

    public static final String ACTION_STARTUP_TASK = "actionStartupTask";
    public static final String INTENT_EXTRA_DATA_TASK_ID = "intentExtraDataTaskId";
    public static final String INTENT_EXTRA_DATA_TASK_RESULT = "intentExtraDataTaskResult";
    private String mStartupTaskId;
    private String mStartupTaskResult;

    public BaseActivity()
    {
        mStartupTaskResult = "taskResultSucceed";
    }

    private void bindStartupTask()
    {
        if ("actionStartupTask".equals(getIntent().getAction()))
        {
            mStartupTaskId = (String)getIntent().getCharSequenceExtra("intentDataStartupTaskId");
        }
    }

    private void clearBindStartupTask()
    {
        mStartupTaskId = null;
    }

    private void notifyStartupTask()
    {
        if ("actionStartupTask".equals(getIntent().getAction()) && hasBindStartupTask())
        {
            Intent intent = new Intent("actionStartupTask");
            intent.putExtra("intentExtraDataTaskId", mStartupTaskId);
            intent.putExtra("intentExtraDataTaskResult", mStartupTaskResult);
            setResult(-1, intent);
            clearBindStartupTask();
        }
    }

    public static void startActivityForStartup(Activity activity, Intent intent, String s)
    {
        if (Util.isEmpty(s) || activity == null || intent == null)
        {
            Log.i("startActivityForStartup", "invalid parameter");
            return;
        } else
        {
            intent.putExtra("intentDataStartupTaskId", s);
            intent.setAction("actionStartupTask");
            activity.startActivityForResult(intent, 16);
            return;
        }
    }

    protected void endStartupTask(String s)
    {
        if (hasBindStartupTask())
        {
            mStartupTaskResult = s;
        }
    }

    public void finish()
    {
        notifyStartupTask();
        super.finish();
    }

    public void finishIfNotFinishing()
    {
        if (isFinishing())
        {
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected boolean hasBindStartupTask()
    {
        return !Util.isEmpty(mStartupTaskId);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        LocaleUtils.ensureConfigLocale(configuration);
        super.onConfigurationChanged(configuration);
        LocaleUtils.ensureAppLocale(this);
    }

    protected void onCreate(Bundle bundle)
    {
        LocaleUtils.ensureAppLocale(this);
        super.onCreate(bundle);
        bindStartupTask();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if ("actionStartupTask".equals(getIntent().getAction()))
        {
            notifyStartupTask();
        }
    }

    protected void onStart()
    {
        LocaleUtils.ensureAppLocale(this);
        super.onStart();
    }
}
