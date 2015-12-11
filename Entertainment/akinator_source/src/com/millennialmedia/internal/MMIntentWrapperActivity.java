// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.TimedMemoryCache;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MMIntentWrapperActivity extends Activity
{
    private static class ActivityState
    {

        MMIntentWrapperListener intentWrapperListener;
        CountDownLatch onCreateLatch;
        Intent wrappedIntent;

        private ActivityState(MMIntentWrapperListener mmintentwrapperlistener, Intent intent)
        {
            onCreateLatch = new CountDownLatch(1);
            intentWrapperListener = mmintentwrapperlistener;
            wrappedIntent = intent;
        }

    }

    public static interface MMIntentWrapperListener
    {

        public abstract void onData(Intent intent);

        public abstract void onError(String s);
    }


    private static final String INTENT_WRAPPER_STATE_KEY = "intent_wrapper_state_id";
    private static final long ON_CREATE_TIMEOUT = 5000L;
    private static final String TAG = com/millennialmedia/internal/MMIntentWrapperActivity.getSimpleName();
    private ActivityState activityState;

    public MMIntentWrapperActivity()
    {
    }

    public static void launch(Context context, Intent intent, MMIntentWrapperListener mmintentwrapperlistener)
    {
        if (mmintentwrapperlistener == null)
        {
            MMLog.e(TAG, "Unable to launch MMIntentWrapperActivity, provided MMIntentWrapperListener instance is null");
            return;
        }
        intent = new ActivityState(mmintentwrapperlistener, intent);
        int i = TimedMemoryCache.add(intent, null);
        if (i == 0)
        {
            mmintentwrapperlistener.onError("Unable to launch MMIntentWrapperActivity, failed to cache activity state");
            return;
        } else
        {
            mmintentwrapperlistener = new Intent(context, com/millennialmedia/internal/MMIntentWrapperActivity);
            mmintentwrapperlistener.putExtra("intent_wrapper_state_id", i);
            context.startActivity(mmintentwrapperlistener);
            ThreadUtils.runOnWorkerThread(new Runnable(intent) {

                final ActivityState val$activityState;

                public void run()
                {
                    try
                    {
                        if (!activityState.onCreateLatch.await(5000L, TimeUnit.MILLISECONDS))
                        {
                            activityState.intentWrapperListener.onError("Failed to start activity");
                        }
                        return;
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        return;
                    }
                }

            
            {
                activityState = activitystate;
                super();
            }
            });
            return;
        }
    }

    private boolean loadActivityState()
    {
        Object obj = TimedMemoryCache.get(getIntent().getIntExtra("intent_wrapper_state_id", 0));
        if (!(obj instanceof ActivityState))
        {
            return false;
        } else
        {
            activityState = (ActivityState)obj;
            return true;
        }
    }

    private boolean saveActivityState()
    {
        Intent intent = getIntent();
        intent.removeExtra("intent_wrapper_state_id");
        int i = TimedMemoryCache.add(activityState, null);
        if (i == 0)
        {
            return false;
        } else
        {
            intent.putExtra("intent_wrapper_state_id", i);
            return true;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (activityState != null && activityState.intentWrapperListener != null)
        {
            if (j == -1)
            {
                activityState.intentWrapperListener.onData(intent);
            } else
            {
                activityState.intentWrapperListener.onError((new StringBuilder()).append("Activity failed with result code <").append(j).append(">").toString());
            }
        }
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!loadActivityState())
        {
            MMLog.e(TAG, (new StringBuilder()).append("Failed to load activity state, aborting activity launch <").append(this).append(">").toString());
            finish();
        } else
        if (bundle == null)
        {
            activityState.onCreateLatch.countDown();
            if (activityState.wrappedIntent != null && activityState.wrappedIntent.resolveActivity(getPackageManager()) != null)
            {
                startActivityForResult(activityState.wrappedIntent, 0);
                return;
            } else
            {
                activityState.intentWrapperListener.onError((new StringBuilder()).append("Failed to start activity, aborting activity launch <").append(this).append(">").toString());
                finish();
                return;
            }
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (!isFinishing() && !saveActivityState())
        {
            MMLog.e(TAG, (new StringBuilder()).append("Failed to save activity state <").append(this).append(">").toString());
        }
    }

}
