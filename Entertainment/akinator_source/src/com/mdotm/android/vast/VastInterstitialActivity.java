// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mdotm.android.listener.InterstitialActionListener;
import com.mdotm.android.listener.InterstitialVideoListener;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.utils.MdotMBase64;
import com.mdotm.android.utils.MdotMLogger;
import com.mdotm.android.utils.MdotMUtils;
import java.util.ArrayList;

// Referenced classes of package com.mdotm.android.vast:
//            VastAd, BaseVastAd, LinearAd, VastVideoView, 
//            Companion

public class VastInterstitialActivity extends Activity
    implements MdotMAdActionListener, InterstitialVideoListener
{

    private static boolean isCompletedPlaying = false;
    private ArrayList adClickTrack;
    private ArrayList adClickUrl;
    private boolean adClicked;
    private VastAd adResponse;
    private RelativeLayout closeLayout;
    private FrameLayout companionImageLayout;
    private ImageView companionImgView;
    boolean didDismissCalled;
    private ArrayList impressionString;
    private InterstitialActionListener interstitialActionListener;
    private long interstitialListenerId;
    private boolean isRewarded;
    private boolean isShowingCompanionImage;
    private boolean isVideoClickable;
    private Handler mHandler;
    private VastVideoView mVideoView;
    private String reward;
    private boolean rewardCallbackCalled;
    private FrameLayout videoLayout;

    public VastInterstitialActivity()
    {
        adClicked = false;
        didDismissCalled = false;
        isShowingCompanionImage = false;
        isVideoClickable = true;
        rewardCallbackCalled = false;
    }

    private void clicked()
    {
        MdotMLogger.i(this, "  Ad clicked  ");
        if (adClickTrack == null || adClickTrack.size() <= 0 || adClickTrack.size() <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L8:
        if (i < adClickTrack.size()) goto _L3; else goto _L2
_L2:
        if (adClickUrl == null || adClickUrl.size() <= 0) goto _L5; else goto _L4
_L4:
        i = 0;
_L6:
        if (i >= adClickUrl.size())
        {
            return;
        }
        (new Thread() {

            final VastInterstitialActivity this$0;
            private final String val$clickedUrl;

            public void run()
            {
                adClicked();
                MdotMLogger.i(this, (new StringBuilder("Clicked to migrate url ")).append(clickedUrl).toString());
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
                if (interstitialActionListener != null)
                {
                    interstitialActionListener.onLeave();
                }
            }

            
            {
                this$0 = VastInterstitialActivity.this;
                clickedUrl = s;
                super();
            }
        }).start();
        i++;
        continue; /* Loop/switch isn't completed */
_L3:
        MdotMUtils.getUtilsInstance().reportImpression((String)adClickTrack.get(i), this);
        i++;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        MdotMLogger.e(this, "selected ads landing url is null");
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private RelativeLayout getCloseButtonView()
    {
        Object obj;
        Object obj1;
        Object obj2;
        ArrayList arraylist;
        int i;
        int j;
        j = 44;
        obj1 = null;
        arraylist = adResponse.getVastAds();
        i = ((BaseVastAd)arraylist.get(0)).getAdType();
        obj = null;
        obj2 = null;
        i;
        JVM INSTR tableswitch 1 1: default 56
    //                   1 343;
           goto _L1 _L2
_L1:
        obj = obj2;
_L3:
        double d;
        closeLayout = new RelativeLayout(this);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        closeLayout.setId(4);
        closeLayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        obj2 = new ImageView(this);
        ((ImageView) (obj2)).setImageBitmap(StringToBitMap("iVBORw0KGgoAAAANSUhEUgAAAIcAAACHCAYAAAA850oKAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDE0IDc5LjE1Njc5NywgMjAxNC8wOC8yMC0wOTo1MzowMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6M0M2QTk3ODQ5RjBDMTFFNDk1NEZCNDc0OEYwQTY1QjAiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6M0M2QTk3ODM5RjBDMTFFNDk1NEZCNDc0OEYwQTY1QjAiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNSBNYWNpbnRvc2giPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo3Mjg4OEFFNTEyRDUxMUUwOEJDRTkxRUFFNEY5M0MxNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo3Mjg4OEFFNjEyRDUxMUUwOEJDRTkxRUFFNEY5M0MxNiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PtHLAlcAABnxSURBVHja7J17dFNV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"));
        i = j;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj = ((String) (obj)).split("%");
        MdotMLogger.d(this, (new StringBuilder("CloseBtnArry")).append(obj[0]).toString());
        i = j;
        if (obj.length < 1)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        d = 44;
        i = j;
        j = (int)(d * ((double)Integer.parseInt(obj[0]) / 100D));
        i = j;
        MdotMLogger.d(this, (new StringBuilder("CloseBtnsize")).append(j).toString());
        i = j;
_L4:
        obj = new android.widget.RelativeLayout.LayoutParams(getPixels(i), getPixels(i));
        if (obj1 != null && ((String) (obj1)).equalsIgnoreCase("topleft"))
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        } else
        if (obj1 != null && ((String) (obj1)).equalsIgnoreCase("bottomleft"))
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            MdotMLogger.i(this, "close btn bottom left");
        } else
        if (obj1 != null && ((String) (obj1)).equalsIgnoreCase("bottomright"))
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        } else
        {
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        }
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(getPixels(6), getPixels(6), getPixels(6), getPixels(6));
        ((ImageView) (obj2)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((ImageView) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

            final VastInterstitialActivity this$0;

            public void onClick(View view)
            {
                mVideoView.skipVideo();
                if (!isShowingCompanionImage && adResponse.liniearAndCompanion)
                {
                    if (mVideoView.isPlaying())
                    {
                        mVideoView.stopVideo();
                    }
                    showCompanionAfterLinear();
                    if (isRewarded && !VastInterstitialActivity.isCompletedPlaying)
                    {
                        interstitialActionListener.onRewardedVideoComplete(true, reward);
                        rewardCallbackCalled = true;
                    }
                    return;
                }
                onDismissScreen();
                if (isRewarded && !VastInterstitialActivity.isCompletedPlaying && !rewardCallbackCalled)
                {
                    interstitialActionListener.onRewardedVideoComplete(true, reward);
                }
                finish();
            }

            
            {
                this$0 = VastInterstitialActivity.this;
                super();
            }
        });
        closeLayout.addView(((View) (obj2)));
        closeLayout.setVisibility(4);
        closeLayout.bringToFront();
        return closeLayout;
_L2:
        obj1 = (LinearAd)arraylist.get(0);
        if (((LinearAd) (obj1)).closeBtnSize != null)
        {
            obj = ((LinearAd) (obj1)).closeBtnSize;
        }
        obj1 = ((LinearAd) (obj1)).closeBtnLocation;
          goto _L3
        obj;
        MdotMLogger.e(this, (new StringBuilder("Number format exe")).append(obj).toString());
          goto _L4
    }

    private ImageView getImageView(Bitmap bitmap)
    {
        ImageView imageview = new ImageView(getApplicationContext());
        imageview.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        imageview.setImageBitmap(bitmap);
        return imageview;
    }

    private int getPixels(int i)
    {
        float f = getResources().getDisplayMetrics().density;
        MdotMLogger.i(this, (new StringBuilder("scale = ")).append(f).toString());
        i = (int)((float)i * f + 0.5F);
        MdotMLogger.i(this, (new StringBuilder("result px = ")).append(i).toString());
        return i;
    }

    private FrameLayout getVideoLayout()
    {
        MdotMLogger.i(this, "getVideoLayout");
        FrameLayout framelayout = new FrameLayout(this);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.gravity = 17;
        framelayout.setLayoutParams(layoutparams);
        mVideoView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final VastInterstitialActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (isVideoClickable)
                {
                    int i = motionevent.getAction();
                    MdotMLogger.i(this, (new StringBuilder("onTouch :: ")).append(i).toString());
                    if (i == 0 && !adClicked)
                    {
                        adClicked = true;
                        clicked();
                    }
                }
                return false;
            }

            
            {
                this$0 = VastInterstitialActivity.this;
                super();
            }
        });
        layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams.gravity = 17;
        if (getResources().getConfiguration().orientation == 2)
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            layoutparams.gravity = 17;
            MdotMLogger.i(this, "landscape");
        }
        mVideoView.setLayoutParams(layoutparams);
        mVideoView.setZOrderMediaOverlay(true);
        framelayout.addView(mVideoView);
        framelayout.addView(getCloseButtonView());
        return framelayout;
    }

    private void showCompanionAfterLinear()
    {
        if (Companion.companionImage != null)
        {
            isShowingCompanionImage = true;
            resetAdClickAndTrackURLS();
            videoLayout.setVisibility(4);
            companionImageLayout.setVisibility(0);
            int i = 0;
            do
            {
                if (i >= Companion.companionCreativeViewList.size())
                {
                    return;
                }
                MdotMUtils.getUtilsInstance().reportImpression((String)Companion.companionCreativeViewList.get(i), this);
                i++;
            } while (true);
        } else
        {
            isShowingCompanionImage = true;
            return;
        }
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
            mVideoView.stopVideo();
        }
    }

    public void changeCloseBtnSize()
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
        mHandler = new Handler();
        adResponse = (VastAd)getIntent().getExtras().getSerializable("response");
        isRewarded = getIntent().getBooleanExtra("isRewarded", false);
        reward = getIntent().getStringExtra("reward");
        interstitialListenerId = getIntent().getExtras().getLong("InterstitialActionListenerId");
        MdotMLogger.i(this, (new StringBuilder("listener id ")).append(interstitialListenerId).toString());
        interstitialActionListener = MdotMUtils.getUtilsInstance().getInterstitialActionListener(interstitialListenerId);
        if (isRewarded)
        {
            isVideoClickable = false;
        }
        if (Companion.companionImage == null)
        {
            isShowingCompanionImage = true;
        }
        if (adResponse == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        if (getIntent().getExtras().getInt("ScreenOrientation") == 1)
        {
            setRequestedOrientation(7);
        } else
        if (getIntent().getExtras().getInt("ScreenOrientation") == 2)
        {
            setRequestedOrientation(6);
        }
        bundle = new FrameLayout(this);
        bundle.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        bundle.setBackgroundColor(0xff444444);
        obj = adResponse.getVastAds();
        impressionString = adResponse.getImpression();
        i = ((BaseVastAd)((ArrayList) (obj)).get(0)).getAdType();
        MdotMLogger.i(this, (new StringBuilder("Vast ad type :: ")).append(i).toString());
        i;
        JVM INSTR tableswitch 1 1: default 280
    //                   1 325;
           goto _L3 _L4
_L3:
        MdotMLogger.e(this, "This format is not supported ");
        onDismissScreen();
_L6:
        MdotMLogger.i(this, "onCreate finish");
        return;
_L4:
        obj = (LinearAd)((ArrayList) (obj)).get(0);
        adClickUrl = ((LinearAd) (obj)).getVideoClicks();
        adClickTrack = ((LinearAd) (obj)).getVideoClickTrack();
        mVideoView = new VastVideoView(this, ((LinearAd) (obj)), this, this, mHandler, impressionString, isRewarded);
        videoLayout = getVideoLayout();
        bundle.addView(videoLayout);
        if (adResponse.liniearAndCompanion)
        {
            companionImageLayout = new FrameLayout(getApplicationContext());
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            companionImageLayout.setLayoutParams(layoutparams);
            MdotMLogger.i(this, "initialize companion view");
            companionImgView = new ImageView(getApplicationContext());
            layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            companionImgView.setLayoutParams(layoutparams);
            companionImgView.setImageBitmap(Companion.companionImage);
            companionImageLayout.addView(companionImgView);
            companionImageLayout.addView(getCloseButtonView());
            companionImgView.setOnTouchListener(new android.view.View.OnTouchListener() {

                final VastInterstitialActivity this$0;

                public boolean onTouch(View view, MotionEvent motionevent)
                {
                    int j = motionevent.getAction();
                    MdotMLogger.i(this, (new StringBuilder("onTouch Companoin:: ")).append(j).toString());
                    if (j == 0 && !adClicked)
                    {
                        adClicked = true;
                        clicked();
                    }
                    return false;
                }

            
            {
                this$0 = VastInterstitialActivity.this;
                super();
            }
            });
            bundle.addView(companionImageLayout);
            companionImageLayout.setVisibility(4);
            bundle.addView(getCloseButtonView());
        }
        setContentView(bundle);
        continue; /* Loop/switch isn't completed */
_L2:
        MdotMLogger.i(this, "Ad response is null");
        onDismissScreen();
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        MdotMUtils.getUtilsInstance().removeInterstitialActionListener(interstitialListenerId);
        if (mVideoView != null)
        {
            mVideoView.stopVideo();
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
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        MdotMLogger.i(this, (new StringBuilder("Key down ")).append(i).toString());
        if (i != 4)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        if (isShowingCompanionImage || !adResponse.liniearAndCompanion || closeLayout.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        if (mVideoView.isPlaying())
        {
            mVideoView.stopVideo();
        }
        showCompanionAfterLinear();
        if (isRewarded && !isCompletedPlaying && closeLayout.getVisibility() == 0)
        {
            interstitialActionListener.onRewardedVideoComplete(true, reward);
            rewardCallbackCalled = true;
        }
_L4:
        return true;
_L2:
        if (isRewarded && !isCompletedPlaying && !rewardCallbackCalled && closeLayout.getVisibility() == 0)
        {
            interstitialActionListener.onRewardedVideoComplete(true, reward);
        }
        if (closeLayout == null || closeLayout.getVisibility() != 0) goto _L4; else goto _L3
_L3:
        onDismissScreen();
        return super.onKeyDown(i, keyevent);
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
        isVideoClickable = true;
        if (adResponse.liniearAndCompanion)
        {
            MdotMLogger.i(this, "completed playing video");
            showCompanionAfterLinear();
        }
        if (isRewarded)
        {
            isCompletedPlaying = true;
            interstitialActionListener.onRewardedVideoComplete(false, reward);
            MdotMLogger.i(this, "call playback action listners");
        }
    }

    protected void onResume()
    {
        if (!adClicked) goto _L2; else goto _L1
_L1:
        adClicked = false;
        onDismissScreen();
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

    public void resetAdClickAndTrackURLS()
    {
        adClickUrl = null;
        adClickUrl = new ArrayList();
        adClickUrl.add(Companion.companionStaticImageClickThrough);
        adClickTrack = Companion.companionStaticImageClickTracking;
    }

    public void setPlayStart()
    {
    }

    public void showCloseButton()
    {
        MdotMLogger.i(this, "show close button");
        mHandler.post(new Runnable() {

            final VastInterstitialActivity this$0;

            public void run()
            {
                if (closeLayout != null)
                {
                    closeLayout.setVisibility(0);
                }
                closeLayout.bringToFront();
            }

            
            {
                this$0 = VastInterstitialActivity.this;
                super();
            }
        });
    }
















}
