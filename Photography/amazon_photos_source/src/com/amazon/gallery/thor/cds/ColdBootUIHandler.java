// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ChromeVisibilityEvent;
import com.amazon.gallery.foundation.utils.messaging.ColdBootProgressEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ColdBootUIHandler
{

    private static final String TAG = com/amazon/gallery/thor/cds/ColdBootUIHandler.getName();
    public static final boolean USE_JELLYBEAN_ANIMATIONS = Api.isAtLeastJellyBean();
    public static final boolean USE_KITKAT_ANIMATIONS = Api.isAtLeastKitkat();
    private final Interpolator INTERPOLATOR = new LinearInterpolator();
    private final long MAX_DURATION_PER_PERCENT_PROGRESS;
    private ScheduledExecutorService executorService;
    private volatile boolean hasNetworkConnectivity;
    private final AtomicBoolean isHiding = new AtomicBoolean(false);
    private final AtomicBoolean isRegistered = new AtomicBoolean(false);
    private final Activity mActivity;
    private ObjectAnimator mAnimator;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private long mLastTimeTaken;
    private long mLastUpdateTime;
    private int mPreviousProgress;
    private ProgressBar mProgressBar;
    private volatile int mProgressBarProgress;
    private RelativeLayout mProgressLayout;
    private TextView mProgressMessage;
    private final SharedPreferences mSharedPreferences;
    private long mTotalCount;
    private ScheduledFuture pollFuture;
    private final Runnable pollRunnable = new Runnable() {

        final ColdBootUIHandler this$0;

        public void run()
        {
            int i = mProgressBar.getProgress();
            if (mProgressBarProgress != i)
            {
                mProgressBarProgress = i;
                mHandler.post(i. new Runnable() {

                    final _cls2 this$1;
                    final int val$progress;

                    public void run()
                    {
                        updateProgressMessage(progress);
                    }

            
            {
                this$1 = final__pcls2;
                progress = I.this;
                super();
            }
                });
                mHandler.removeCallbacks(saveColdBootProgressRunnable);
                mHandler.postDelayed(saveColdBootProgressRunnable, 1000L);
                if (i == 100)
                {
                    hide();
                    return;
                }
            }
        }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }
    };
    private final Runnable saveColdBootProgressRunnable = new Runnable() {

        final ColdBootUIHandler this$0;

        public void run()
        {
            mSharedPreferences.edit().putInt("cold_boot_progress", mProgressBarProgress).apply();
        }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }
    };

    public ColdBootUIHandler(Activity activity)
    {
        pollFuture = null;
        executorService = null;
        MAX_DURATION_PER_PERCENT_PROGRESS = TimeUnit.SECONDS.toMillis(1L);
        mTotalCount = 0L;
        mLastUpdateTime = 0L;
        mLastTimeTaken = 0L;
        mPreviousProgress = 0;
        mProgressBarProgress = 0;
        hasNetworkConnectivity = true;
        mActivity = activity;
        mProgressLayout = (RelativeLayout)activity.findViewById(0x7f0c0119);
        mProgressBar = (ProgressBar)mProgressLayout.findViewById(0x7f0c011b);
        mProgressMessage = (TextView)mProgressLayout.findViewById(0x7f0c011a);
        mSharedPreferences = activity.getSharedPreferences("galleryKindleSharedPrefs", 0);
    }

    private void initExecutor()
    {
        if (executorService == null)
        {
            executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

                final ColdBootUIHandler this$0;

                public Thread newThread(Runnable runnable)
                {
                    runnable = new Thread(runnable, "ColdBootPollingThread");
                    runnable.setPriority(3);
                    return runnable;
                }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }
            });
        }
    }

    private void stopPolling()
    {
        if (pollFuture != null)
        {
            GLogger.i(TAG, "Stopping poll thread for ColdBoot progress", new Object[0]);
            pollFuture.cancel(true);
            pollFuture = null;
        }
        if (executorService != null)
        {
            executorService.shutdown();
            executorService = null;
        }
    }

    private void updateProgressMessage(int i)
    {
        if (!hasNetworkConnectivity)
        {
            return;
        }
        int j = i;
        if (i < 0)
        {
            j = 0;
        }
        String s = mActivity.getResources().getString(0x7f0e0080, new Object[] {
            Integer.valueOf(j)
        });
        SpannableString spannablestring = new SpannableString(s);
        i = s.indexOf(':');
        if (i >= 0)
        {
            spannablestring.setSpan(new ForegroundColorSpan(mActivity.getResources().getColor(0x7f090004)), i + 1, spannablestring.length(), 33);
        }
        mProgressMessage.setText(spannablestring);
    }

    public void hide()
    {
        GLogger.i(TAG, "Hiding cold boot progress bar", new Object[0]);
        if (isHiding.getAndSet(true))
        {
            return;
        } else
        {
            mHandler.post(new Runnable() {

                final ColdBootUIHandler this$0;

                public void run()
                {
                    Runnable runnable;
label0:
                    {
                        if (mProgressLayout.getVisibility() == 0)
                        {
                            updateProgressMessage(100);
                            runnable = new Runnable() {

                                final _cls5 this$1;

                                public void run()
                                {
                                    mActivity.findViewById(0x7f0c0119).setVisibility(8);
                                }

            
            {
                this$1 = _cls5.this;
                super();
            }
                            };
                            if (!ColdBootUIHandler.USE_JELLYBEAN_ANIMATIONS)
                            {
                                break label0;
                            }
                            mProgressLayout.animate().setDuration(400L).translationY(500F).withEndAction(runnable);
                        }
                        return;
                    }
                    int ai[] = new int[2];
                    mProgressLayout.getLocationOnScreen(ai);
                    TranslateAnimation translateanimation = new TranslateAnimation(ai[0], ai[0], ai[1], 500F);
                    translateanimation.setDuration(400L);
                    translateanimation.setFillAfter(true);
                    translateanimation.setAnimationListener(runnable. new android.view.animation.Animation.AnimationListener() {

                        final _cls5 this$1;
                        final Runnable val$onAnimationEnd;

                        public void onAnimationEnd(Animation animation)
                        {
                            onAnimationEnd.run();
                        }

                        public void onAnimationRepeat(Animation animation)
                        {
                        }

                        public void onAnimationStart(Animation animation)
                        {
                        }

            
            {
                this$1 = final__pcls5;
                onAnimationEnd = Runnable.this;
                super();
            }
                    });
                    mProgressLayout.startAnimation(translateanimation);
                }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }
            });
            shutdown();
            return;
        }
    }

    public void onChromeVisibilityEvent(ChromeVisibilityEvent chromevisibilityevent)
    {
        if (chromevisibilityevent.isShowing())
        {
            mProgressLayout.animate().alpha(1.0F).setDuration(450L).start();
            return;
        } else
        {
            mProgressLayout.animate().alpha(0.0F).setDuration(450L).start();
            return;
        }
    }

    protected void onNetworkChange(boolean flag)
    {
        if (flag)
        {
            if (!hasNetworkConnectivity)
            {
                hasNetworkConnectivity = true;
                updateProgressMessage(mSharedPreferences.getInt("cold_boot_progress", 0));
            }
            mProgressMessage.setVisibility(0);
            mProgressBar.setVisibility(0);
            return;
        }
        if (mAnimator != null)
        {
            mAnimator.cancel();
        }
        hasNetworkConnectivity = false;
        saveColdBootProgressRunnable.run();
        mProgressBar.setVisibility(4);
        mProgressMessage.setText(mActivity.getResources().getText(0x7f0e0081));
    }

    void setTotalCount(long l)
    {
        mTotalCount = l;
    }

    public void show(final int progress)
    {
        GLogger.i(TAG, "Showing cold boot progress bar", new Object[0]);
        if (!isRegistered.getAndSet(true))
        {
            GlobalMessagingBus.register(this);
        }
        initExecutor();
        isHiding.set(false);
        mHandler.post(new Runnable() {

            final ColdBootUIHandler this$0;
            final int val$progress;

            public void run()
            {
                mProgressBar.setProgress(progress);
                updateProgressMessage(progress);
                mProgressLayout.setVisibility(0);
            }

            
            {
                this$0 = ColdBootUIHandler.this;
                progress = i;
                super();
            }
        });
        mLastUpdateTime = SystemClock.uptimeMillis();
        if (pollFuture == null)
        {
            GLogger.i(TAG, "Scheduling poll thread for ColdBoot progress", new Object[0]);
            pollFuture = executorService.scheduleAtFixedRate(pollRunnable, 0L, 100L, TimeUnit.MILLISECONDS);
        }
    }

    public void shutdown()
    {
        if (isRegistered.getAndSet(false))
        {
            GlobalMessagingBus.unregister(this);
        }
        stopPolling();
        mHandler.removeCallbacks(saveColdBootProgressRunnable);
        saveColdBootProgressRunnable.run();
    }

    public void updateProgress(final int progress)
    {
        mHandler.post(new Runnable() {

            final ColdBootUIHandler this$0;
            final int val$progress;

            public void run()
            {
                if (progress < mProgressBar.getProgress())
                {
                    return;
                }
                if (mAnimator != null)
                {
                    mAnimator.cancel();
                }
                if (mTotalCount == 0L)
                {
                    mProgressBar.setProgress(progress);
                    return;
                }
                long l = (long)((float)mLastTimeTaken * ((float)mProgressBar.getProgress() / (float)mPreviousProgress));
                long l2 = SystemClock.uptimeMillis();
                long l1 = (l2 - mLastUpdateTime) + (mLastTimeTaken - l);
                int i = progress;
                int j = progress - mPreviousProgress;
                l = l1;
                if (l1 > 0L)
                {
                    l = l1;
                    if ((float)l1 / (float)j > (float)MAX_DURATION_PER_PERCENT_PROGRESS)
                    {
                        l = (long)j * MAX_DURATION_PER_PERCENT_PROGRESS;
                    }
                }
                l1 = l;
                if (l < 0L)
                {
                    l1 = 0L;
                }
                GLogger.v(ColdBootUIHandler.TAG, "Interpolating to %d with a duration of %d", new Object[] {
                    Integer.valueOf(i), Long.valueOf(l1)
                });
                GlobalMessagingBus.post(new ColdBootProgressEvent(i, l1));
                mAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", new int[] {
                    i
                });
                mAnimator.setDuration(l1);
                mAnimator.setInterpolator(INTERPOLATOR);
                mAnimator.start();
                mPreviousProgress = i;
                mLastTimeTaken = l1;
                mLastUpdateTime = l2;
            }

            
            {
                this$0 = ColdBootUIHandler.this;
                progress = i;
                super();
            }
        });
    }




/*
    static int access$002(ColdBootUIHandler coldbootuihandler, int i)
    {
        coldbootuihandler.mProgressBarProgress = i;
        return i;
    }

*/




/*
    static long access$1002(ColdBootUIHandler coldbootuihandler, long l)
    {
        coldbootuihandler.mLastTimeTaken = l;
        return l;
    }

*/



/*
    static int access$1102(ColdBootUIHandler coldbootuihandler, int i)
    {
        coldbootuihandler.mPreviousProgress = i;
        return i;
    }

*/



/*
    static long access$1202(ColdBootUIHandler coldbootuihandler, long l)
    {
        coldbootuihandler.mLastUpdateTime = l;
        return l;
    }

*/












/*
    static ObjectAnimator access$802(ColdBootUIHandler coldbootuihandler, ObjectAnimator objectanimator)
    {
        coldbootuihandler.mAnimator = objectanimator;
        return objectanimator;
    }

*/

}
