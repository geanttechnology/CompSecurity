// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.widget.RelativeLayout;
import com.video.adsdk.interfaces.JavascriptBridge;
import com.video.adsdk.interfaces.JavascriptBridgeListener;
import com.video.adsdk.interfaces.PrefetcherListener;
import com.video.adsdk.interfaces.VideoBridge;
import com.video.adsdk.interfaces.VideoBridgeListener;

// Referenced classes of package com.video.adsdk.internal:
//            Helper, VideoAdSDKControllerUsingActivity, Prefetcher, ADVideoFile

public class ADActivity extends Activity
    implements VideoBridgeListener, JavascriptBridgeListener, PrefetcherListener
{

    public static String PARAM_USE_FAKE = (new StringBuilder()).append("USE_FAKE").append(com/video/adsdk/internal/ADActivity).toString();
    private boolean advertisingIsFinished;
    private boolean useFake;
    private VideoBridge videoBridge;
    private ProgressDialog videoProgressDialog;
    private RelativeLayout view;
    private ProgressDialog webProgressDialog;

    public ADActivity()
    {
        useFake = false;
        advertisingIsFinished = false;
    }

    private void finishAdvertising()
    {
        if (videoBridge != null)
        {
            videoBridge.shutdown();
        }
        advertisingIsFinished = true;
        finish();
    }

    private void hideVideoLoader()
    {
        if (videoProgressDialog != null)
        {
            videoProgressDialog.dismiss();
        }
        videoProgressDialog = null;
    }

    private void hideWebLoader()
    {
        if (webProgressDialog != null)
        {
            webProgressDialog.dismiss();
        }
        webProgressDialog = null;
    }

    private void showVideoLoader()
    {
        if (videoProgressDialog != null)
        {
            return;
        } else
        {
            videoProgressDialog = new ProgressDialog(this);
            videoProgressDialog.setMessage("Prefetching video");
            videoProgressDialog.setProgressStyle(1);
            videoProgressDialog.show();
            return;
        }
    }

    private void showWebLoader()
    {
        if (webProgressDialog != null)
        {
            return;
        }
        try
        {
            webProgressDialog = new ProgressDialog(this);
            webProgressDialog.show();
        }
        catch (android.view.WindowManager.BadTokenException badtokenexception) { }
        webProgressDialog.setCancelable(false);
        webProgressDialog.setContentView(getApplicationContext().getResources().getIdentifier("empty_progress_dialog", "layout", getApplicationContext().getPackageName()));
    }

    public void fakeOnBackPressed()
    {
        fakeOnFinish();
        super.onBackPressed();
    }

    public void fakeOnCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        view = Helper.createFakeAdVideoView(getApplicationContext());
        view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        setContentView(view);
        findViewById(Helper.ID_BUTTONCLOSE).setOnClickListener(new android.view.View.OnClickListener() {

            final ADActivity this$0;

            public void onClick(View view1)
            {
                fakeOnFinish();
                finishAdvertising();
            }

            
            {
                this$0 = ADActivity.this;
                super();
            }
        });
        VideoAdSDKControllerUsingActivity.Instance.raiseFakeVideoPlayEvents(false);
    }

    protected void fakeOnFinish()
    {
        VideoAdSDKControllerUsingActivity.Instance.raiseFakeVideoPlayEvents(true);
    }

    protected void fakeOnPause()
    {
        super.onPause();
    }

    protected void fakeOnResume()
    {
        super.onResume();
    }

    public void onBackPressed()
    {
        if (useFake)
        {
            fakeOnBackPressed();
        } else
        if (VideoAdSDKControllerUsingActivity.Instance.isVideoPlaying())
        {
            if (VideoAdSDKControllerUsingActivity.Instance.isClosableByUI())
            {
                VideoAdSDKControllerUsingActivity.Instance.onSkipButtonClicked();
                finishAdvertising();
                return;
            }
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            useFake = getIntent().getBooleanExtra(PARAM_USE_FAKE, false);
        }
        catch (Exception exception) { }
        if (useFake)
        {
            fakeOnCreate(bundle);
            return;
        } else
        {
            advertisingIsFinished = false;
            view = new RelativeLayout(this);
            bundle = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            bundle.addRule(13);
            view.setLayoutParams(bundle);
            videoBridge = VideoAdSDKControllerUsingActivity.Instance.getVideoBridge();
            videoBridge.addListener(this);
            VideoAdSDKControllerUsingActivity.Instance.getJavascriptBridge().addListener(this);
            VideoAdSDKControllerUsingActivity.Instance.getPrefetcher().addPrefetcherListener(this);
            setContentView(view);
            return;
        }
    }

    protected void onDestroy()
    {
        if (VideoAdSDKControllerUsingActivity.Instance.getJavascriptBridge() != null)
        {
            VideoAdSDKControllerUsingActivity.Instance.getJavascriptBridge().removeListener(this);
        }
        if (VideoAdSDKControllerUsingActivity.Instance.getVideoBridge() != null)
        {
            VideoAdSDKControllerUsingActivity.Instance.getVideoBridge().removeListener(this);
        }
        if (VideoAdSDKControllerUsingActivity.Instance.getPrefetcher() != null)
        {
            VideoAdSDKControllerUsingActivity.Instance.getPrefetcher().removeListener(this);
        }
        super.onDestroy();
    }

    public void onDisplay()
    {
    }

    public void onFinish(int i)
    {
        finishAdvertising();
    }

    public void onOpenURLInBrowser(String s, boolean flag)
    {
    }

    public void onPageError(int i, String s, String s1)
    {
        hideWebLoader();
    }

    public void onPageLoaded(String s)
    {
        hideWebLoader();
    }

    public void onPageStartingLoad(String s)
    {
        showWebLoader();
    }

    public void onPageTimeOut(String s, String s1)
    {
        hideWebLoader();
    }

    protected void onPause()
    {
        if (useFake)
        {
            fakeOnPause();
            return;
        }
        try
        {
            videoBridge.pause();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        try
        {
            view.removeAllViews();
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
        if (advertisingIsFinished)
        {
            VideoAdSDKControllerUsingActivity.Instance.advertisingDidHide();
        }
        if (VideoAdSDKControllerUsingActivity.Instance.wasMovieClicked())
        {
            VideoAdSDKControllerUsingActivity.Instance.movieClick();
        }
        super.onPause();
    }

    public void onPlayMovie(String s)
    {
        hideWebLoader();
    }

    public void onPrefetchURL(String s, long l)
    {
    }

    public void onPrefetchedFile(ADVideoFile advideofile)
    {
        runOnUiThread(new Runnable() {

            final ADActivity this$0;

            public void run()
            {
                hideVideoLoader();
            }

            
            {
                this$0 = ADActivity.this;
                super();
            }
        });
    }

    public void onPrefetchingDidComplete()
    {
        runOnUiThread(new Runnable() {

            final ADActivity this$0;

            public void run()
            {
                hideVideoLoader();
            }

            
            {
                this$0 = ADActivity.this;
                super();
            }
        });
    }

    public void onPrefetchingFailed()
    {
        hideVideoLoader();
    }

    public void onPrefetchingStarted()
    {
        runOnUiThread(new Runnable() {

            final ADActivity this$0;

            public void run()
            {
                hideWebLoader();
                showVideoLoader();
            }

            
            {
                this$0 = ADActivity.this;
                super();
            }
        });
    }

    public void onProgress(double d)
    {
        if (d == 100D)
        {
            onPrefetchingDidComplete();
        }
        if (videoProgressDialog != null)
        {
            videoProgressDialog.setProgress((int)d);
        }
    }

    protected void onResume()
    {
        if (useFake)
        {
            fakeOnResume();
            return;
        } else
        {
            view.addView((View)videoBridge, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            videoBridge.play();
            super.onResume();
            return;
        }
    }

    public void onSetBackgroundColor(int i)
    {
    }

    public void onShowDialog(final String message, final JsResult result)
    {
        if (isFinishing())
        {
            return;
        } else
        {
            runOnUiThread(new Runnable() {

                final ADActivity this$0;
                final String val$message;
                final JsResult val$result;

                public void run()
                {
                /* block-local class not found */
                class _cls1 {}

                    (new android.app.AlertDialog.Builder(ADActivity.this)).setTitle("javaScript dialog").setMessage(message).setPositiveButton(0x104000a, new _cls1()).setCancelable(false).create().show();
                }

            
            {
                this$0 = ADActivity.this;
                message = s;
                result = jsresult;
                super();
            }
            });
            return;
        }
    }

    public void onShowSkip()
    {
    }

    public void onSkipButtonClicked()
    {
        finishAdvertising();
    }

    public void onTrack(String s)
    {
    }

    public void onVideoIsComplete()
    {
        finishAdvertising();
    }

    public void onVideoIsReadyToPlay(com.video.adsdk.interfaces.VideoBridge.MovieState moviestate, int i)
    {
    }

    public void onVideoPlaybackError(int i, int j)
    {
        finishAdvertising();
    }

    public void onVideoReportsCurrentState(com.video.adsdk.interfaces.VideoBridge.MovieState moviestate, long l)
    {
    }





}
