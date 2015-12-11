// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, InlineVideoView, MMSDK, MMAdImpl, 
//            MMAdImplController, AdCache, MMWebView, RequestListener, 
//            MMRequest, AdProperties

abstract class MMLayout extends RelativeLayout
    implements MMAd, InlineVideoView.TransparentFix
{
    class LayoutAdProperties extends AdProperties
    {

        final MMLayout this$0;

        String getAdDpiIndependentHeight()
        {
            float f = MMSDK.getDensity(getContext());
            return String.valueOf((int)((float)getHeight() / f));
        }

        String getAdDpiIndependentWidth()
        {
            float f = MMSDK.getDensity(getContext());
            return String.valueOf((int)((float)getWidth() / f));
        }

        LayoutAdProperties(Context context)
        {
            this$0 = MMLayout.this;
            super(context);
        }
    }

    class MMLayoutMMAdImpl extends MMAdImpl
    {

        final MMLayout this$0;

        public void addView(MMWebView mmwebview, android.widget.RelativeLayout.LayoutParams layoutparams)
        {
            MMSDK.Log.w((new StringBuilder()).append("MMLayout adding view (").append(mmwebview).append(") to ").append(this).toString());
            MMLayout.this.addView(mmwebview, layoutparams);
        }

        volatile MMAd getCallingAd()
        {
            return getCallingAd();
        }

        MMLayout getCallingAd()
        {
            return MMLayout.this;
        }

        int getId()
        {
            return MMLayout.this.getId();
        }

        public void removeView(MMWebView mmwebview)
        {
            MMLayout.this.removeView(mmwebview);
        }

        public void setBackgroundColor(int i)
        {
            MMLayout.this.setBackgroundColor(i);
        }

        public void setClickable(boolean flag)
        {
            MMLayout.this.setClickable(flag);
        }

        public MMLayoutMMAdImpl(Context context)
        {
            this$0 = MMLayout.this;
            super(context);
            adProperties = new LayoutAdProperties(getContext());
        }
    }


    static final String BOTTOM_CENTER = "bottom-center";
    static final String BOTTOM_LEFT = "bottom-left";
    static final String BOTTOM_RIGHT = "bottom-right";
    static final String CENTER = "center";
    private static final int CLOSE_AREA_SIZE = 50;
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    static final String TOP_CENTER = "top-center";
    static final String TOP_LEFT = "top-left";
    static final String TOP_RIGHT = "top-right";
    private static boolean appInit;
    MMAdImpl adImpl;
    View blackView;
    View closeAreaView;
    private GestureDetector diagnosticDetector;
    String goalId;
    RelativeLayout inlineVideoLayout;
    InlineVideoView inlineVideoView;
    boolean isResizing;

    protected MMLayout(Context context)
    {
        super(context);
        initLayout(context);
    }

    protected MMLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initLayout(context);
    }

    private void initInlineVideoTransparentFix()
    {
        if (blackView != null)
        {
            android.view.ViewParent viewparent = blackView.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(blackView);
                blackView = null;
            }
        }
        blackView = new View(getContext());
        blackView.setBackgroundColor(0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        blackView.setLayoutParams(layoutparams);
        if (inlineVideoLayout != null && blackView.getParent() == null)
        {
            inlineVideoLayout.addView(blackView);
        }
    }

    private void internalSetCloseArea(String s)
    {
        if (closeAreaView != null) goto _L2; else goto _L1
_L1:
        android.widget.RelativeLayout.LayoutParams layoutparams;
        closeAreaView = new View(getContext());
        float f = getContext().getResources().getDisplayMetrics().density;
        layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(50F * f), (int)(50F * f));
        if (!"top-right".equals(s)) goto _L4; else goto _L3
_L3:
        layoutparams.addRule(11);
_L6:
        closeAreaView.setOnClickListener(new android.view.View.OnClickListener() {

            final MMLayout this$0;

            public void onClick(View view)
            {
                closeAreaTouched();
            }

            
            {
                this$0 = MMLayout.this;
                super();
            }
        });
        addView(closeAreaView, layoutparams);
_L2:
        return;
_L4:
        if ("top-center".equals(s))
        {
            layoutparams.addRule(14);
        } else
        if ("bottom-left".equals(s))
        {
            layoutparams.addRule(12);
        } else
        if ("bottom-center".equals(s))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(14);
        } else
        if ("bottom-right".equals(s))
        {
            layoutparams.addRule(12);
            layoutparams.addRule(11);
        } else
        if ("center".equals(s))
        {
            layoutparams.addRule(13);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void addBlackView()
    {
        initInlineVideoTransparentFix();
        if (blackView != null)
        {
            blackView.setVisibility(0);
        }
    }

    void addInlineVideo()
    {
        if (inlineVideoLayout != null && inlineVideoLayout.getParent() != null)
        {
            ((ViewGroup)inlineVideoLayout.getParent()).removeView(inlineVideoLayout);
        }
        inlineVideoLayout = new RelativeLayout(getContext());
        inlineVideoLayout.setId(0x35391858);
        if (inlineVideoView.getParent() != null)
        {
            ((ViewGroup)inlineVideoView.getParent()).removeView(inlineVideoView);
        }
        inlineVideoLayout.addView(inlineVideoView);
        if (blackView != null)
        {
            if (blackView.getParent() == null)
            {
                inlineVideoLayout.addView(blackView);
            }
            blackView.bringToFront();
        }
        addView(inlineVideoLayout, inlineVideoView.getCustomLayoutParams());
    }

    boolean adjustVideo(final InlineVideoView.InlineParams params)
    {
        MMSDK.runOnUiThread(new Runnable() {

            final MMLayout this$0;
            final InlineVideoView.InlineParams val$params;

            public void run()
            {
                if (inlineVideoView != null)
                {
                    inlineVideoView.adjustVideo(params);
                }
            }

            
            {
                this$0 = MMLayout.this;
                params = inlineparams;
                super();
            }
        });
        return false;
    }

    void closeAreaTouched()
    {
    }

    protected void finalize()
        throws Throwable
    {
        if (getId() == -1)
        {
            adImpl.isFinishing = true;
            MMSDK.Log.d((new StringBuilder()).append("finalize() for ").append(adImpl).toString());
            MMAdImplController.removeAdViewController(adImpl);
        }
    }

    void fullScreenVideoLayout()
    {
    }

    public String getApid()
    {
        return adImpl.getApid();
    }

    public boolean getIgnoresDensityScaling()
    {
        return adImpl.getIgnoresDensityScaling();
    }

    public RequestListener getListener()
    {
        return adImpl.getListener();
    }

    public MMRequest getMMRequest()
    {
        return adImpl.getMMRequest();
    }

    void initInlineVideo(InlineVideoView.InlineParams inlineparams)
    {
        if (inlineVideoView != null)
        {
            ViewGroup viewgroup = (ViewGroup)inlineVideoView.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(inlineVideoView);
            }
            if (inlineVideoView.isPlaying())
            {
                inlineVideoView.stopPlayback();
            }
            inlineVideoView = null;
        }
        inlineVideoView = new InlineVideoView(this);
        inlineVideoView.initInlineVideo(inlineparams);
        inlineparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        inlineparams.addRule(13, -1);
        inlineVideoView.setLayoutParams(inlineparams);
        addInlineVideo();
    }

    protected final void initLayout(Context context)
    {
        try
        {
            MMSDK.Log.i("Initializing MMLayout.");
            MMSDK.checkPermissions(context);
            MMSDK.checkActivity(context);
        }
        catch (Exception exception)
        {
            MMSDK.Log.e("There was an exception initializing the MMAdView. %s", new Object[] {
                exception.getMessage()
            });
            exception.printStackTrace();
        }
        diagnosticDetector = new GestureDetector(new android.view.GestureDetector.SimpleOnGestureListener() {

            final MMLayout this$0;

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                while (motionevent == null || motionevent1 == null || Math.abs((int)(motionevent1.getX() - motionevent.getX())) <= 200 || Math.abs(f) <= Math.abs(f1)) 
                {
                    return false;
                }
                if (f > 0.0F)
                {
                    if (MMSDK.logLevel == 0)
                    {
                        MMSDK.Log.i("Enabling debug and verbose logging.");
                        MMSDK.logLevel = 3;
                    } else
                    {
                        MMSDK.Log.i("Disabling debug and verbose logging.");
                        MMSDK.logLevel = 0;
                    }
                } else
                {
                    MMSDK.printDiagnostics(adImpl);
                }
                return true;
            }

            
            {
                this$0 = MMLayout.this;
                super();
            }
        });
        if (!appInit)
        {
            MMSDK.Log.d("********** Millennial Device Id *****************");
            MMSDK.Log.d(MMSDK.getMMdid(context));
            MMSDK.Log.d("Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
            MMSDK.Log.d("*************************************************");
            AdCache.cleanCache(context);
            appInit = true;
        }
    }

    boolean isVideoPlayingStreaming()
    {
        return inlineVideoView != null && inlineVideoView.isPlayingStreaming();
    }

    void loadUrl(String s)
    {
        if (MMSDK.isConnected(getContext()))
        {
            if (adImpl.controller != null)
            {
                adImpl.controller.loadUrl(s);
            }
            return;
        } else
        {
            MMSDK.Log.e("No network available, can't load overlay.");
            return;
        }
    }

    void loadWebContent(String s, String s1)
    {
        if (MMSDK.isConnected(getContext()))
        {
            if (adImpl.controller != null)
            {
                adImpl.controller.loadWebContent(s, s1);
            }
            return;
        } else
        {
            MMSDK.Log.e("No network available, can't load overlay.");
            return;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!isInEditMode())
        {
            MMSDK.Log.d((new StringBuilder()).append("onAttachedToWindow for ").append(adImpl).toString());
            if (getId() == -1)
            {
                MMSDK.Log.w("MMAd missing id from getId(). Performance will be affected for configuration changes.");
            }
            if (!isResizing)
            {
                MMAdImplController.assignAdViewController(adImpl);
            }
            if (inlineVideoLayout != null)
            {
                inlineVideoLayout.bringToFront();
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        MMSDK.Log.d((new StringBuilder()).append("onDetachedFromWindow for").append(adImpl).toString());
        if (!isResizing)
        {
            MMAdImplController.removeAdViewController(adImpl);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (Bundle)parcelable;
        long l = adImpl.internalId;
        adImpl.internalId = parcelable.getLong("MMAdImplId");
        adImpl.linkForExpansionId = parcelable.getLong("MMAdImplLinkedId");
        MMSDK.Log.d((new StringBuilder()).append("onRestoreInstanceState replacing adImpl-").append(l).append(" with ").append(adImpl).append(" id=").append(getId()).toString());
        String s = parcelable.getString("inlineVideoViewGson");
        if (s != null)
        {
            initInlineVideo(InlineVideoView.InlineParams.getInlineParams(s));
        }
        super.onRestoreInstanceState(parcelable.getParcelable("super"));
    }

    protected Parcelable onSaveInstanceState()
    {
        super.onSaveInstanceState();
        MMSDK.Log.d((new StringBuilder()).append("onSaveInstanceState saving - ").append(adImpl).append(" id=").append(getId()).toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putLong("MMAdImplId", adImpl.internalId);
        bundle.putLong("MMAdImplLinkedId", adImpl.linkForExpansionId);
        if (inlineVideoView != null)
        {
            if (inlineVideoView.isPlaying())
            {
                inlineVideoView.inlineParams.currentPosition = inlineVideoView.getCurrentPosition();
            }
            bundle.putString("inlineVideoViewGson", inlineVideoView.getGsonState());
        }
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return diagnosticDetector.onTouchEvent(motionevent) || !isClickable() || super.onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            if (inlineVideoView != null)
            {
                inlineVideoView.resumeVideo();
            }
        } else
        if (inlineVideoView != null)
        {
            inlineVideoView.pauseVideo();
        }
        MMSDK.Log.d("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[] {
            adImpl, Boolean.valueOf(flag), MMAdImplController.controllersToString()
        });
        if (adImpl != null && adImpl.controller != null && adImpl.controller.webView != null)
        {
            if (flag)
            {
                adImpl.controller.webView.setMraidViewableVisible();
            } else
            {
                adImpl.controller.webView.setMraidViewableHidden();
            }
        }
        if (!flag && (getContext() instanceof Activity))
        {
            Activity activity = (Activity)getContext();
            if (activity == null || activity.isFinishing() && adImpl != null)
            {
                adImpl.isFinishing = true;
                MMSDK.Log.d((new StringBuilder()).append("Window Focus Changed.removing ").append(adImpl).toString());
                if (adImpl.controller != null && adImpl.controller.webView != null)
                {
                    adImpl.controller.webView.setMraidHidden();
                }
                MMAdImplController.removeAdViewController(adImpl);
            }
        }
        BridgeMMMedia.Audio.sharedAudio(getContext()).stop();
    }

    void pauseVideo()
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.pauseVideo();
        }
    }

    void playVideo()
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.playVideo();
        }
    }

    public void removeBlackView()
    {
        if (blackView != null)
        {
            blackView.setVisibility(4);
        }
    }

    void removeCloseTouchDelegate()
    {
        if (closeAreaView != null && closeAreaView.getParent() != null && (closeAreaView.getParent() instanceof ViewGroup))
        {
            ((ViewGroup)closeAreaView.getParent()).removeView(closeAreaView);
            closeAreaView = null;
        }
    }

    void removeVideo()
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.removeVideo();
            inlineVideoView = null;
        }
    }

    void repositionVideoLayout()
    {
    }

    void resumeVideo()
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.resumeVideo();
        }
    }

    public void setApid(String s)
    {
        adImpl.setApid(s);
    }

    void setCloseArea(final String position)
    {
        post(new Runnable() {

            final MMLayout this$0;
            final String val$position;

            public void run()
            {
                internalSetCloseArea(position);
            }

            
            {
                this$0 = MMLayout.this;
                position = s;
                super();
            }
        });
    }

    public void setIgnoresDensityScaling(boolean flag)
    {
        adImpl.setIgnoresDensityScaling(flag);
    }

    public void setListener(RequestListener requestlistener)
    {
        adImpl.setListener(requestlistener);
    }

    public void setMMRequest(MMRequest mmrequest)
    {
        adImpl.setMMRequest(mmrequest);
    }

    void setVideoSource(String s)
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.setVideoSource(s);
        }
    }

    void stopVideo()
    {
        if (inlineVideoView != null)
        {
            inlineVideoView.stopVideo();
        }
    }

}
