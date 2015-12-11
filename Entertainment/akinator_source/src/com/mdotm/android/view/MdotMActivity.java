// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mdotm.android.http.MdotMNetworkManager;
import com.mdotm.android.listener.InterstitialActionListener;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.listener.MdotMAdEventListener;
import com.mdotm.android.model.MdotMAdResponse;
import com.mdotm.android.utils.MdotMBase64;
import com.mdotm.android.utils.MdotMLogger;
import com.mdotm.android.utils.MdotMUtils;
import com.mdotm.android.vast.Companion;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.mdotm.android.view:
//            MdotMVideoView, MdotMInterstitialImageView, MdotMXhtmlView

public class MdotMActivity extends Activity
    implements MdotMAdActionListener, MdotMAdEventListener
{

    private boolean adClicked;
    private MdotMAdResponse adResponse;
    private WebView clickWebView;
    private RelativeLayout closeButton;
    boolean didDismissCalled;
    Drawable drawable;
    Handler handler;
    private MdotMInterstitialImageView imageView;
    private InterstitialActionListener interstitialActionListener;
    private long interstitialListenerId;
    private MdotMVideoView mVideoView;
    private int resourceIs;
    boolean videoAdSelectionInProgress;
    private MdotMXhtmlView webView;

    public MdotMActivity()
    {
        clickWebView = null;
        videoAdSelectionInProgress = false;
        didDismissCalled = false;
    }

    private RelativeLayout getCloseButtonView()
    {
        double d;
        RelativeLayout relativelayout;
        Object obj;
        String as[];
        int i;
        relativelayout = new RelativeLayout(this);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(0, 10, 10, 0);
        relativelayout.setId(11);
        relativelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.setBackgroundColor(0);
        obj = new ImageView(this);
        ((ImageView) (obj)).setImageBitmap(StringToBitMap("iVBORw0KGgoAAAANSUhEUgAAAIcAAACHCAYAAAA850oKAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDE0IDc5LjE1Njc5NywgMjAxNC8wOC8yMC0wOTo1MzowMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6M0M2QTk3ODQ5RjBDMTFFNDk1NEZCNDc0OEYwQTY1QjAiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6M0M2QTk3ODM5RjBDMTFFNDk1NEZCNDc0OEYwQTY1QjAiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo3Mjg4OEFFNTEyRDUxMUUwOEJDRTkxRUFFNEY5M0MxNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo3Mjg4OEFFNjEyRDUxMUUwOEJDRTkxRUFFNEY5M0MxNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PtHLAlcAABnxSURBVHja7J17dFNV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"));
        byte byte0 = 44;
        i = byte0;
        if (adResponse.getCompanion() == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        i = byte0;
        if (adResponse.getCompanion().closeBtnSize == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        as = adResponse.getCompanion().closeBtnSize.split("%");
        MdotMLogger.d(this, (new StringBuilder("CloseBtnArry")).append(as[0]).toString());
        i = byte0;
        if (as.length < 1)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        d = 44;
        i = byte0;
        int j = (int)(d * ((double)Integer.parseInt(as[0]) / 100D));
        i = j;
        MdotMLogger.d(this, (new StringBuilder("CloseBtnsize")).append(j).toString());
        i = j;
_L1:
        MdotMLogger.e(this, (new StringBuilder("Closebtn size")).append(adResponse.getCompanion()).toString());
        Object obj1 = new android.widget.RelativeLayout.LayoutParams(getPixels(i), getPixels(i));
        if (adResponse.getCompanion() != null && adResponse.getCompanion().getCloseLoc() != null)
        {
            String s = adResponse.getCompanion().getCloseLoc();
            if (s != null && s.equalsIgnoreCase("topleft"))
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
                MdotMLogger.i(this, "close btn top left");
            } else
            if (s != null && s.equalsIgnoreCase("bottomleft"))
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(9);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
                MdotMLogger.i(this, "close btn bottom left");
            } else
            if (s != null && s.equalsIgnoreCase("bottomright"))
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
                MdotMLogger.i(this, "close btn bottom right");
            } else
            {
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
                ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
                MdotMLogger.i(this, "close btn top right");
            }
        } else
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        }
        ((ImageView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final MdotMActivity this$0;

            public void onClick(View view)
            {
                onDismissScreen();
            }

            
            {
                this$0 = MdotMActivity.this;
                super();
            }
        });
        relativelayout.addView(((View) (obj)));
        return relativelayout;
        obj1;
        MdotMLogger.e(this, (new StringBuilder("Number format exe")).append(obj1).toString());
          goto _L1
    }

    private int getPixels(int i)
    {
        float f = getResources().getDisplayMetrics().density;
        MdotMLogger.i(this, (new StringBuilder("scale = ")).append(f).toString());
        i = (int)((float)i * f + 0.5F);
        MdotMLogger.i(this, (new StringBuilder("result px = ")).append(i).toString());
        return i;
    }

    private RelativeLayout getVideoLayout()
    {
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout relativelayout1 = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(3, 11);
        relativelayout1.setLayoutParams(layoutparams);
        relativelayout1.setGravity(17);
        relativelayout1.setId(2);
        relativelayout1.setBackgroundColor(0);
        relativelayout1.setOnTouchListener(new android.view.View.OnTouchListener() {

            final MdotMActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 && !adClicked)
                {
                    adClicked = true;
                    clicked();
                }
                return true;
            }

            
            {
                this$0 = MdotMActivity.this;
                super();
            }
        });
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mVideoView.setLayoutParams(layoutparams);
        relativelayout.addView(mVideoView);
        relativelayout.addView(getCloseButtonView());
        relativelayout.addView(relativelayout1);
        return relativelayout;
    }

    public Bitmap StringToBitMap(String s)
    {
        try
        {
            s = MdotMBase64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            return null;
        }
        return s;
    }

    public void adClicked()
    {
        adClicked = true;
        MdotMLogger.i(this, "clicked on ad");
        if (interstitialActionListener != null)
        {
            interstitialActionListener.onClick();
        }
        if (mVideoView != null)
        {
            mVideoView.stopVideo(handler);
        }
    }

    void clicked()
    {
        MdotMLogger.i(this, "  Selected to clicked  ");
        if (adResponse.getLandingUrl() != null)
        {
            if (!videoAdSelectionInProgress)
            {
                videoAdSelectionInProgress = true;
                (new Thread() {

                    final MdotMActivity this$0;
                    private final String val$clickedUrl;

                    public void run()
                    {
                        adClicked();
                        MdotMLogger.i(this, (new StringBuilder("Launch type is ")).append(adResponse.getLaunchType()).toString());
                        if (adResponse.getLaunchType() == 2)
                        {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(clickedUrl));
                            intent.addFlags(0x10000000);
                            try
                            {
                                startActivity(intent);
                            }
                            catch (Exception exception)
                            {
                                MdotMLogger.i(this, (new StringBuilder("Could not open browser on ad click to ")).append(exception).toString());
                            }
                            videoAdSelectionInProgress = false;
                            if (interstitialActionListener != null)
                            {
                                interstitialActionListener.onLeave();
                            }
                            return;
                        } else
                        {
                    /* block-local class not found */
                    class _cls1 {}

                            handler.post(new _cls1(clickedUrl));
                            return;
                        }
                    }


            
            {
                this$0 = MdotMActivity.this;
                clickedUrl = s;
                super();
            }
                }).start();
                return;
            } else
            {
                MdotMLogger.i(this, "ad selection under progress");
                return;
            }
        } else
        {
            MdotMLogger.e(this, "selected ads landing url is null");
            return;
        }
    }

    public void didShowInterstitial()
    {
    }

    public void leaveApplication()
    {
        if (interstitialActionListener != null)
        {
            interstitialActionListener.onLeave();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        MdotMLogger.i(this, "onCreate is called");
        super.onCreate(bundle);
        handler = new Handler();
        clickWebView = new WebView(this);
        clickWebView.getSettings().setJavaScriptEnabled(true);
        clickWebView.setWebViewClient(new WebViewClient() {

            Runnable run;
            final MdotMActivity this$0;
            boolean timeout;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                timeout = false;
                MdotMLogger.i(this, (new StringBuilder("Click page finished ")).append(s).toString());
                videoAdSelectionInProgress = false;
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                MdotMLogger.i(this, (new StringBuilder("started Loading url ")).append(s).toString());
                if (videoAdSelectionInProgress)
                {
                    timeout = true;
                    handler.removeCallbacks(run);
                    handler.postDelayed(run, 15000L);
                }
                super.onPageStarted(webview, s, bitmap);
            }

            public void onReceivedError(WebView webview, int j, String s, String s1)
            {
                super.onReceivedError(webview, j, s, s1);
                timeout = false;
                if (videoAdSelectionInProgress)
                {
                    MdotMLogger.e(this, (new StringBuilder("Unable to load landing url : ")).append(s).toString());
                }
                videoAdSelectionInProgress = false;
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                MdotMLogger.i(this, (new StringBuilder("returned url ")).append(s).toString());
                if (s != null && s.startsWith("market://"))
                {
                    try
                    {
                        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
                        webview.getContext().startActivity(s);
                        if (interstitialActionListener != null)
                        {
                            interstitialActionListener.onLeave();
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        MdotMLogger.e(this, "Google Play store app is not installed");
                        webview.printStackTrace();
                    }
                    videoAdSelectionInProgress = false;
                    timeout = false;
                    return true;
                } else
                {
                    MdotMLogger.i(this, (new StringBuilder("loading other url ")).append(s).toString());
                    return super.shouldOverrideUrlLoading(webview, s);
                }
            }


            
            {
                this$0 = MdotMActivity.this;
                super();
            /* block-local class not found */
            class _cls1 {}

                run = new _cls1();
            }
        });
        adResponse = (MdotMAdResponse)getIntent().getExtras().getSerializable("response");
        interstitialListenerId = getIntent().getExtras().getLong("InterstitialActionListenerId");
        MdotMLogger.i(this, (new StringBuilder("listener id ")).append(interstitialListenerId).toString());
        interstitialActionListener = MdotMUtils.getUtilsInstance().getInterstitialActionListener(interstitialListenerId);
        if (adResponse == null && Companion.htmlResource == null) goto _L2; else goto _L1
_L1:
        if (getIntent().getExtras().getInt("ScreenOrientation") != 1) goto _L4; else goto _L3
_L3:
        setRequestedOrientation(7);
_L6:
        if (adResponse != null)
        {
            resourceIs = adResponse.getResourceType();
        }
        bundle = new RelativeLayout(this);
        bundle.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        bundle.setBackgroundColor(0xff000000);
        MdotMLogger.i(this, (new StringBuilder("resource type ")).append(resourceIs).toString());
        MdotMLogger.i(this, (new StringBuilder("resource getAdType ")).append(adResponse).toString());
        MdotMLogger.i(this, (new StringBuilder("resource getAdType ")).append(adResponse.getAdType()).toString());
        if (resourceIs == MdotMNetworkManager.imageResource && adResponse.getAdType() == MdotMUtils.AD_WITH_BANNER_OR_XHTML_OR_VIDEO)
        {
            imageView = new MdotMInterstitialImageView(this, adResponse, this);
            if (!imageView.adLoadSuccess)
            {
                onLoadError();
                MdotMLogger.e(this, "Failed to load interstitial banner ad");
            } else
            {
                closeButton = getCloseButtonView();
                bundle.addView(imageView);
                bundle.addView(getCloseButtonView());
                MdotMLogger.i(this, "Call report impression imageresource");
                MdotMUtils.getUtilsInstance().reportImpression(adResponse.getImp_pixel(), this);
            }
        } else
        if (resourceIs == MdotMNetworkManager.htmlResource || adResponse.getResourceType() == MdotMNetworkManager.gifImageResource || adResponse.getResourceType() == MdotMNetworkManager.imageResource && adResponse.getAdType() == MdotMUtils.AD_ICON_WITH_TEXT_MESSAGE)
        {
            MdotMLogger.i(this, "loading html page");
            webView = new MdotMXhtmlView(this, adResponse, this);
            webView.setGravity(13);
            bundle.addView(webView);
            boolean flag = false;
            int i = ((flag) ? 1 : 0);
            if (adResponse.getCompanion() != null)
            {
                i = ((flag) ? 1 : 0);
                if (adResponse.getCompanion().getSkipOffset() != null)
                {
                    i = ((flag) ? 1 : 0);
                    if (adResponse.getCompanion().getSkipOffset().matches("[0-9]{2}:[0-9]{2}:[0-9]{2}[.]*[0-9]*"))
                    {
                        String as[] = adResponse.getCompanion().getSkipOffset().split(":");
                        i = Integer.parseInt(as[0]) * 3600 + Integer.parseInt(as[1]) * 60 + (int)Double.parseDouble(as[2]);
                        MdotMLogger.d(this, (new StringBuilder("skip offset")).append(i).toString());
                    }
                }
            }
            closeButton = getCloseButtonView();
            bundle.addView(closeButton);
            closeButton.setVisibility(4);
            (new Timer()).schedule(new TimerTask() {

                final MdotMActivity this$0;

                public void run()
                {
                /* block-local class not found */
                class _cls1 {}

                    runOnUiThread(new _cls1());
                }


            
            {
                this$0 = MdotMActivity.this;
                super();
            }
            }, i * 1000);
        } else
        if (resourceIs == MdotMNetworkManager.videoResource)
        {
            mVideoView = new MdotMVideoView(this, adResponse, this);
            bundle.addView(getVideoLayout());
        } else
        {
            MdotMLogger.e(this, (new StringBuilder("This format is not supported ")).append(adResponse.getImageUrl()).toString());
            onDismissScreen();
        }
        setContentView(bundle);
        return;
_L4:
        if (getIntent().getExtras().getInt("ScreenOrientation") == 2)
        {
            setRequestedOrientation(6);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        MdotMLogger.i(this, "Ad response is null");
        onDismissScreen();
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MdotMUtils.getUtilsInstance().removeInterstitialActionListener(interstitialListenerId);
        if (mVideoView != null && handler != null)
        {
            mVideoView.stopVideo(handler);
        }
    }

    public void onDismissScreen()
    {
        MdotMLogger.i(this, "onDismiss is called");
        didDismissCalled = true;
        if (interstitialActionListener != null)
        {
            interstitialActionListener.onDismiss();
        } else
        {
            MdotMLogger.e(this, "InterstitialActionListener is null. So ignoring the interstitial dismiss callback");
        }
        webView.loadblankview();
        finish();
    }

    public void onFailedToReceiveInterstitialAd()
    {
    }

    public void onInterstitialAdClick()
    {
    }

    public void onInterstitialDismiss()
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
label0:
        {
            MdotMLogger.i(this, (new StringBuilder("Key down ")).append(i).toString());
            if (i == 4)
            {
                if (closeButton == null || closeButton.getVisibility() != 0)
                {
                    break label0;
                }
                onDismissScreen();
            }
            return super.onKeyDown(i, keyevent);
        }
        return true;
    }

    public void onLeaveApplicationFromInterstitial()
    {
    }

    public void onLoadError()
    {
        MdotMLogger.e(this, "Error while loading the ad");
        onDismissScreen();
    }

    protected void onPause()
    {
        MdotMLogger.i(this, "onPause is called");
        super.onPause();
        if (mVideoView != null)
        {
            mVideoView.PauseVideo();
        }
        if (!adClicked && !didDismissCalled)
        {
            onDismissScreen();
        }
    }

    public void onPlayError()
    {
        MdotMLogger.i(this, "Error while palying video");
        if (interstitialActionListener != null)
        {
            interstitialActionListener.onFailed();
        }
        onDismissScreen();
    }

    public void onPlayStop()
    {
        MdotMLogger.i(this, "completed palying video");
    }

    public void onReceiveInterstitialAd()
    {
    }

    protected void onResume()
    {
        MdotMLogger.i(this, "onResume is called");
        if (!adClicked) goto _L2; else goto _L1
_L1:
        onDismissScreen();
        adClicked = false;
_L4:
        super.onResume();
        return;
_L2:
        if (mVideoView != null && mVideoView.isReadyToPlay())
        {
            mVideoView.playVideo();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onRewardedVideoComplete(boolean flag, String s)
    {
    }

    public void willShowInterstitial()
    {
    }






}
