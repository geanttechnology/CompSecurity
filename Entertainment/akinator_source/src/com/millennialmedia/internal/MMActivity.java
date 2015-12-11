// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.TimedMemoryCache;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MMActivity extends Activity
{
    private static class ActivityState
    {

        MMActivityListener activityListener;
        MMActivityConfig configuration;
        CountDownLatch onCreateLatch;

        private ActivityState(MMActivityListener mmactivitylistener, MMActivityConfig mmactivityconfig)
        {
            onCreateLatch = new CountDownLatch(1);
            activityListener = mmactivitylistener;
            configuration = mmactivityconfig;
        }

    }

    public static class MMActivityConfig
    {

        private int audioSource;
        private Integer enterAnimationId;
        private Integer exitAnimationId;
        private boolean immersive;
        private int orientation;
        private boolean transparent;

        public MMActivityConfig setAudioSource(int i)
        {
            audioSource = i;
            return this;
        }

        public MMActivityConfig setImmersive(boolean flag)
        {
            immersive = flag;
            return this;
        }

        public MMActivityConfig setOrientation(int i)
        {
            orientation = i;
            return this;
        }

        public MMActivityConfig setTransitionAnimation(Integer integer, Integer integer1)
        {
            enterAnimationId = integer;
            exitAnimationId = integer1;
            return this;
        }

        public MMActivityConfig setTransparent(boolean flag)
        {
            transparent = flag;
            return this;
        }





/*
        static int access$302(MMActivityConfig mmactivityconfig, int i)
        {
            mmactivityconfig.orientation = i;
            return i;
        }

*/




        public MMActivityConfig()
        {
            audioSource = -1;
            orientation = -1;
        }
    }

    public static abstract class MMActivityListener
    {

        public boolean onBackPressed()
        {
            return true;
        }

        public void onCreate(MMActivity mmactivity)
        {
        }

        public void onDestroy(MMActivity mmactivity)
        {
        }

        public void onLaunchFailed()
        {
        }

        public void onPause(MMActivity mmactivity)
        {
        }

        public void onResume(MMActivity mmactivity)
        {
        }

        public MMActivityListener()
        {
        }
    }


    private static final String ACTIVITY_STATE_ID_KEY = "activity_state_id";
    private static final long ON_CREATE_TIMEOUT = 5000L;
    private static final String TAG = com/millennialmedia/internal/MMActivity.getSimpleName();
    private ActivityState activityState;
    private RelativeLayout rootView;

    public MMActivity()
    {
    }

    private void enableImmersiveMode()
    {
        View view = getWindow().getDecorView();
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Enabling immersive mode:\ndecorView = ").append(view).append("\nActivity = ").append(this).toString());
        }
        view.setSystemUiVisibility(5894);
    }

    public static void launch(Context context, MMActivityConfig mmactivityconfig, MMActivityListener mmactivitylistener)
    {
        if (mmactivitylistener == null)
        {
            MMLog.e(TAG, "Unable to launch MMActivity, provided MMActivityListener instance is null");
            return;
        }
        MMActivityConfig mmactivityconfig1 = mmactivityconfig;
        if (mmactivityconfig == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "No MMActivity Configuration specified, creating default activity Configuration.");
            }
            mmactivityconfig1 = new MMActivityConfig();
        }
        mmactivityconfig = new ActivityState(mmactivitylistener, mmactivityconfig1);
        int i = TimedMemoryCache.add(mmactivityconfig, Long.valueOf(5000L));
        if (i == 0)
        {
            MMLog.e(TAG, "Unable to launch MMActivity, failed to cache activity state");
            mmactivitylistener.onLaunchFailed();
            return;
        }
        mmactivitylistener = new Intent(context, com/millennialmedia/internal/MMActivity);
        mmactivitylistener.putExtra("activity_state_id", i);
        if (mmactivityconfig1.enterAnimationId != null || mmactivityconfig1.exitAnimationId != null)
        {
            int j = 0;
            if (mmactivityconfig1.enterAnimationId != null)
            {
                j = mmactivityconfig1.enterAnimationId.intValue();
            }
            int k = 0;
            if (mmactivityconfig1.exitAnimationId != null)
            {
                k = mmactivityconfig1.exitAnimationId.intValue();
            }
            context.startActivity(mmactivitylistener, ActivityOptions.makeCustomAnimation(context, j, k).toBundle());
        } else
        {
            context.startActivity(mmactivitylistener);
        }
        ThreadUtils.runOnWorkerThread(new Runnable(mmactivityconfig) {

            final ActivityState val$activityState;

            public void run()
            {
                try
                {
                    if (!activityState.onCreateLatch.await(5000L, TimeUnit.MILLISECONDS))
                    {
                        activityState.activityListener.onLaunchFailed();
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
    }

    private boolean loadActivityState()
    {
        Object obj = TimedMemoryCache.get(getIntent().getIntExtra("activity_state_id", 0));
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
        intent.removeExtra("activity_state_id");
        int i = TimedMemoryCache.add(activityState, null);
        if (i == 0)
        {
            return false;
        } else
        {
            intent.putExtra("activity_state_id", i);
            return true;
        }
    }

    public void finish()
    {
        super.finish();
        if (activityState != null && activityState.configuration != null && (activityState.configuration.enterAnimationId != null || activityState.configuration.exitAnimationId != null))
        {
            overridePendingTransition(activityState.configuration.enterAnimationId.intValue(), activityState.configuration.exitAnimationId.intValue());
        }
    }

    public ViewGroup getRootView()
    {
        return rootView;
    }

    public void onBackPressed()
    {
        if (activityState.activityListener.onBackPressed())
        {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (loadActivityState()) goto _L2; else goto _L1
_L1:
        MMLog.e(TAG, (new StringBuilder()).append("Failed to load activity state, aborting activity launch <").append(this).append(">").toString());
        finish();
_L4:
        return;
_L2:
        activityState.onCreateLatch.countDown();
        int i = getRequestedOrientation();
        int k = activityState.configuration.orientation;
        if (i == k)
        {
            break; /* Loop/switch isn't completed */
        }
        setRequestedOrientation(k);
        int l = EnvironmentUtils.getCurrentConfigOrientation();
        int i1 = EnvironmentUtils.getConfigOrientationFromRequestedOrientation(k);
        if (l == i1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Requested orientation will force orientation change:\n\tCurrent requested orientation: ").append(i).append("\n\tDesired requested orientation: ").append(k).append("\n\tCurrent config orientation: ").append(l).append("\n\tDesired config orientation: ").append(i1).toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("New activity created with orientation ").append(EnvironmentUtils.getCurrentConfigOrientationString()).toString());
        }
        if (activityState.configuration.audioSource != -1)
        {
            setVolumeControlStream(activityState.configuration.audioSource);
        }
        int j;
        if (android.os.Build.VERSION.SDK_INT >= 19 && activityState.configuration.immersive)
        {
            enableImmersiveMode();
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new android.view.View.OnSystemUiVisibilityChangeListener() {

                final MMActivity this$0;

                public void onSystemUiVisibilityChange(int j1)
                {
                    if ((j1 & 4) == 0)
                    {
                        enableImmersiveMode();
                    }
                }

            
            {
                this$0 = MMActivity.this;
                super();
            }
            });
        } else
        if (activityState.configuration.immersive)
        {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
        rootView = new RelativeLayout(this);
        if (activityState.configuration.transparent)
        {
            j = 0;
        } else
        {
            j = 160;
        }
        bundle = new ColorDrawable(0xff000000);
        bundle.setAlpha(j);
        rootView.setBackground(bundle);
        rootView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        setContentView(rootView);
        activityState.activityListener.onCreate(this);
        return;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (activityState == null || activityState.activityListener == null)
        {
            return;
        }
        if (!isFinishing() && !saveActivityState())
        {
            MMLog.e(TAG, (new StringBuilder()).append("Failed to save activity state <").append(this).append(">").toString());
        }
        activityState.activityListener.onDestroy(this);
    }

    public void onPause()
    {
        super.onPause();
        activityState.activityListener.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        activityState.activityListener.onResume(this);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("onWindowFocusChanged: hasFocus = ").append(flag).toString());
            if (activityState != null)
            {
                MMLog.d(TAG, (new StringBuilder()).append("activityState.configuration.immersive = ").append(activityState.configuration.immersive).toString());
            }
        }
        if (android.os.Build.VERSION.SDK_INT >= 19 && activityState != null && activityState.configuration.immersive && flag)
        {
            enableImmersiveMode();
        }
    }

    public void setOrientation(int i)
    {
        if (i != getRequestedOrientation())
        {
            activityState.configuration.orientation = i;
            setRequestedOrientation(i);
        }
    }


}
