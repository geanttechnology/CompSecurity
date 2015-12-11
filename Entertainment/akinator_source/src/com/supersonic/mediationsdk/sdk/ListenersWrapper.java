// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import android.os.Handler;
import android.os.Looper;
import com.supersonic.mediationsdk.EventsHandler;
import com.supersonic.mediationsdk.logger.SupersonicError;
import com.supersonic.mediationsdk.logger.SupersonicLoggerManager;

// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            RewardedVideoListener, InterstitialListener, OfferwallListener

public class ListenersWrapper
    implements RewardedVideoListener, InterstitialListener, OfferwallListener
{
    private class CallbackHandlerThread extends Thread
    {

        private Handler mCallbackHandler;
        final ListenersWrapper this$0;

        public Handler getCallbackHandler()
        {
            return mCallbackHandler;
        }

        public void run()
        {
            Looper.prepare();
            mCallbackHandler = new Handler();
            Looper.loop();
        }

        private CallbackHandlerThread()
        {
            this$0 = ListenersWrapper.this;
            super();
        }

    }


    private CallbackHandlerThread mCallbackHandlerThread;
    private InterstitialListener mInterstitialListener;
    private OfferwallListener mOfferwallListener;
    private RewardedVideoListener mRewardedVideoListener;

    public ListenersWrapper()
    {
        mCallbackHandlerThread = new CallbackHandlerThread();
        mCallbackHandlerThread.start();
    }

    private boolean canSendCallback(Object obj)
    {
        return obj != null && mCallbackHandlerThread != null;
    }

    private void sendCallback(Runnable runnable)
    {
        Handler handler;
        if (mCallbackHandlerThread != null)
        {
            if ((handler = mCallbackHandlerThread.getCallbackHandler()) != null)
            {
                handler.post(runnable);
                return;
            }
        }
    }

    public void onGetOfferwallCreditsFail(final SupersonicError supersonicError)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onGetOfferwallCreditsFail(").append(supersonicError).append(")").toString(), 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$supersonicError;

                public void run()
                {
                    mOfferwallListener.onGetOfferwallCreditsFail(supersonicError);
                }

            
            {
                this$0 = ListenersWrapper.this;
                supersonicError = supersonicerror;
                super();
            }
            });
        }
    }

    public void onInterstitialAdClicked()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mInterstitialListener.onInterstitialAdClicked();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onInterstitialAdClosed()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mInterstitialListener.onInterstitialAdClosed();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onInterstitialAvailability(final boolean available)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onInterstitialAvailability(available").append(available).append(")").toString(), 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final boolean val$available;

                public void run()
                {
                    mInterstitialListener.onInterstitialAvailability(available);
                }

            
            {
                this$0 = ListenersWrapper.this;
                available = flag;
                super();
            }
            });
        }
    }

    public void onInterstitialInitFail(final SupersonicError supersonicError)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onInterstitialInitFail(").append(supersonicError).append(")").toString(), 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$supersonicError;

                public void run()
                {
                    mInterstitialListener.onInterstitialInitFail(supersonicError);
                }

            
            {
                this$0 = ListenersWrapper.this;
                supersonicError = supersonicerror;
                super();
            }
            });
        }
    }

    public void onInterstitialInitSuccess()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onInterstitialInitSuccess()", 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mInterstitialListener.onInterstitialInitSuccess();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onInterstitialShowFail(final SupersonicError supersonicError)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onInterstitialShowFail(").append(supersonicError).append(")").toString(), 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$supersonicError;

                public void run()
                {
                    mInterstitialListener.onInterstitialShowFail(supersonicError);
                }

            
            {
                this$0 = ListenersWrapper.this;
                supersonicError = supersonicerror;
                super();
            }
            });
        }
    }

    public void onInterstitialShowSuccess()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onInterstitialShowSuccess()", 1);
        if (canSendCallback(mInterstitialListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mInterstitialListener.onInterstitialShowSuccess();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public boolean onOfferwallAdCredited(int i, int j, boolean flag)
    {
        boolean flag1 = false;
        if (mOfferwallListener != null)
        {
            flag1 = mOfferwallListener.onOfferwallAdCredited(i, j, flag);
        }
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onOfferwallAdCredited(credits:").append(i).append(", ").append("totalCredits:").append(j).append(", ").append("totalCreditsFlag:").append(flag).append("):").append(flag1).toString(), 1);
        return flag1;
    }

    public void onOfferwallClosed()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onOfferwallClosed()", 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mOfferwallListener.onOfferwallClosed();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onOfferwallInitFail(final SupersonicError supersonicError)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onOfferwallInitFail(").append(supersonicError).append(")").toString(), 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$supersonicError;

                public void run()
                {
                    mOfferwallListener.onOfferwallInitFail(supersonicError);
                }

            
            {
                this$0 = ListenersWrapper.this;
                supersonicError = supersonicerror;
                super();
            }
            });
        }
    }

    public void onOfferwallInitSuccess()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onOfferwallInitSuccess()", 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mOfferwallListener.onOfferwallInitSuccess();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onOfferwallOpened()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onOfferwallOpened()", 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mOfferwallListener.onOfferwallOpened();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onOfferwallShowFail(final SupersonicError supersonicError)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onOfferwallShowFail(").append(supersonicError).append(")").toString(), 1);
        if (canSendCallback(mOfferwallListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$supersonicError;

                public void run()
                {
                    mOfferwallListener.onOfferwallShowFail(supersonicError);
                }

            
            {
                this$0 = ListenersWrapper.this;
                supersonicError = supersonicerror;
                super();
            }
            });
        }
    }

    public void onRewardedVideoAdClosed()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        EventsHandler.getHandler().notifyVideoAdClosed("Mediation");
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mRewardedVideoListener.onRewardedVideoAdClosed();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onRewardedVideoAdOpened()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        EventsHandler.getHandler().notifyVideoAdOpened("Mediation");
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mRewardedVideoListener.onRewardedVideoAdOpened();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onRewardedVideoAdRewarded(final int amount)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onRewardedVideoAdRewarded(amount:").append(amount).append(")").toString(), 1);
        EventsHandler.getHandler().notifyVideoAdRewarded("Mediation");
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final int val$amount;

                public void run()
                {
                    mRewardedVideoListener.onRewardedVideoAdRewarded(amount);
                }

            
            {
                this$0 = ListenersWrapper.this;
                amount = i;
                super();
            }
            });
        }
    }

    public void onRewardedVideoInitFail(final SupersonicError error)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onRewardedVideoInitFail(").append(error.toString()).append(")").toString(), 1);
        EventsHandler.getHandler().notifyInitRewardedVideoResult("Mediation", false);
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final SupersonicError val$error;

                public void run()
                {
                    mRewardedVideoListener.onRewardedVideoInitFail(error);
                }

            
            {
                this$0 = ListenersWrapper.this;
                error = supersonicerror;
                super();
            }
            });
        }
    }

    public void onRewardedVideoInitSuccess()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onRewardedVideoInitSuccess()", 1);
        EventsHandler.getHandler().notifyInitRewardedVideoResult("Mediation", true);
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mRewardedVideoListener.onRewardedVideoInitSuccess();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onVideoAvailabilityChanged(final boolean available)
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, (new StringBuilder()).append("onVideoAvailabilityChanged(available:").append(available).append(")").toString(), 1);
        EventsHandler.getHandler().notifyVideoAvailabilityChanged("Mediation", available);
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;
                final boolean val$available;

                public void run()
                {
                    mRewardedVideoListener.onVideoAvailabilityChanged(available);
                }

            
            {
                this$0 = ListenersWrapper.this;
                available = flag;
                super();
            }
            });
        }
    }

    public void onVideoEnd()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onVideoEnd()", 1);
        EventsHandler.getHandler().notifyVideoEnd("Mediation");
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mRewardedVideoListener.onVideoEnd();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void onVideoStart()
    {
        SupersonicLoggerManager.getLogger().log(com.supersonic.mediationsdk.logger.SupersonicLogger.SupersonicTag.CALLBACK, "onVideoStart()", 1);
        EventsHandler.getHandler().notifyVideoStart("Mediation");
        if (canSendCallback(mRewardedVideoListener))
        {
            sendCallback(new Runnable() {

                final ListenersWrapper this$0;

                public void run()
                {
                    mRewardedVideoListener.onVideoStart();
                }

            
            {
                this$0 = ListenersWrapper.this;
                super();
            }
            });
        }
    }

    public void setInterstitialListener(InterstitialListener interstitiallistener)
    {
        mInterstitialListener = interstitiallistener;
    }

    public void setOfferwallListener(OfferwallListener offerwalllistener)
    {
        mOfferwallListener = offerwalllistener;
    }

    public void setRewardedVideoListener(RewardedVideoListener rewardedvideolistener)
    {
        mRewardedVideoListener = rewardedvideolistener;
    }



}
