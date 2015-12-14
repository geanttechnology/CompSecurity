// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.VideoView;
import com.millennialmedia.google.gson.b;
import java.io.Serializable;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, MMAdImplController, VideoAd, MMLog

class InlineVideoView extends VideoView
    implements Serializable
{

    private static final String ANCHOR_IN_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=";
    private static final String ANCHOR_OUT_PNG = "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC";
    private static final String TAG = "InlineVideoView";
    static final int TIME_TO_UPDATE_SEEK_JS = 500;
    private int duration;
    InlineParams inlineParams;
    MediaController mediaController;
    WeakReference mmLayoutRef;
    TransparentFix transFix;
    TransparentHandler transparentHandler;
    Handler videoHandler;

    public InlineVideoView(MMLayout mmlayout)
    {
        super(mmlayout.getContext());
        transparentHandler = new TransparentHandler();
        setId(0x86c5ad);
        setFocusable(true);
        mmlayout.getContext();
        com.millennialmedia.android.MMAdImplController.b();
        mmLayoutRef = new WeakReference(mmlayout);
    }

    private android.media.MediaPlayer.OnCompletionListener createOnCompletionListener()
    {
        return new VideoCompletionListener();
    }

    private android.media.MediaPlayer.OnErrorListener createOnErrorListener()
    {
        return new VideoErrorListener();
    }

    private android.media.MediaPlayer.OnPreparedListener createOnPreparedListener()
    {
        return new VideoPreparedListener();
    }

    private android.view.View.OnTouchListener createOnTouchListener()
    {
        return new VideoTouchListener();
    }

    private Handler createVideoHandler()
    {
        return new VideoHandler();
    }

    private void downloadCacheVideo()
    {
        Utils.ThreadUtils.a(new DownloadRunnable());
    }

    private Uri getVideoUri()
    {
        if (hasCachedVideo() && !inlineParams.t)
        {
            inlineParams.t = false;
            return VideoAd.getVideoUri(getContext(), inlineParams.k);
        }
        if (!TextUtils.isEmpty(inlineParams.i))
        {
            inlineParams.t = true;
            return Uri.parse(inlineParams.i);
        } else
        {
            return null;
        }
    }

    private boolean hasCachedVideo()
    {
        return !TextUtils.isEmpty(inlineParams.k) && VideoAd.hasVideoFile(getContext(), inlineParams.k);
    }

    private void initInternalInlineVideo()
    {
        videoHandler = createVideoHandler();
        setVideoURI(getVideoUri());
        setBackgroundColor(0xff000000);
        setClickable(true);
        setOnErrorListener(createOnErrorListener());
        setOnCompletionListener(createOnCompletionListener());
        setOnPreparedListener(createOnPreparedListener());
        setOnTouchListener(createOnTouchListener());
        if (inlineParams.m)
        {
            seekTo(inlineParams.h);
            startInternal();
            if (videoHandler != null && !videoHandler.hasMessages(2))
            {
                videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
            }
        }
        if (inlineParams.n)
        {
            mediaController = new MediaController();
            setMediaController(mediaController);
            mediaController.show();
        }
        MMLog.e("InlineVideoView", "Finished inserting inlineVideo player");
    }

    private void makeTransparent()
    {
        if (!transparentHandler.hasMessages(4))
        {
            transparentHandler.sendEmptyMessage(4);
        }
    }

    private void removeFromParent()
    {
        ViewGroup viewgroup = (ViewGroup)getParent();
        if (viewgroup != null)
        {
            viewgroup.removeView(this);
        }
    }

    private void removeKeyboardFocusViewJira1642()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        requestFocus();
    }

    private void resumeInternal(boolean flag)
    {
        if (!inlineParams.r)
        {
            seekTo(inlineParams.h);
            if (flag || inlineParams.m)
            {
                startInternal();
                if (videoHandler != null && !videoHandler.hasMessages(2))
                {
                    videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
                }
            }
        }
    }

    private void setInlineVideoParams(InlineParams inlineparams)
    {
        inlineParams = inlineparams;
    }

    boolean adjustVideo(InlineParams inlineparams)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        setAdjustVideoParams(inlineparams);
        MMLog.e("InlineVideoView", "Called initInlineVideo inside reposition section code");
        flag = isPlaying();
        stopPlayback();
        inlineparams = (MMLayout)mmLayoutRef.get();
        if (inlineparams == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        inlineparams.c();
        resumeInternal(flag);
        this;
        JVM INSTR monitorexit ;
        return true;
        inlineparams;
        throw inlineparams;
    }

    void downloadVideo()
    {
        VideoAd.downloadVideoFile(getContext(), inlineParams.j, inlineParams.k);
    }

    public android.widget.RelativeLayout.LayoutParams getCustomLayoutParams()
    {
        if (inlineParams.b)
        {
            return new android.widget.RelativeLayout.LayoutParams(-1, -1);
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(inlineParams.p * (float)inlineParams.f), (int)(inlineParams.p * (float)inlineParams.g));
            layoutparams.topMargin = (int)(inlineParams.p * (float)inlineParams.c);
            layoutparams.leftMargin = (int)(inlineParams.p * (float)inlineParams.a);
            com.millennialmedia.android.MMLog.b("InlineVideoView", (new StringBuilder("lp height = ")).append(layoutparams.height).toString());
            return layoutparams;
        }
    }

    String getGsonState()
    {
        return (new b()).a(inlineParams);
    }

    void handleTransparentMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 4 5: default 28
    //                   4 29
    //                   5 69;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (isPlaying() && getCurrentPosition() > 0)
        {
            transparentHandler.sendEmptyMessageDelayed(5, 100L);
            return;
        } else
        {
            transparentHandler.sendEmptyMessageDelayed(4, 50L);
            return;
        }
_L3:
        if (isPlaying() && getCurrentPosition() > 0)
        {
            setBackgroundColor(0);
            if (mmLayoutRef != null && mmLayoutRef.get() != null)
            {
                ((MMLayout)mmLayoutRef.get()).removeBlackView();
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    void initInlineVideo(InlineParams inlineparams)
    {
        this;
        JVM INSTR monitorenter ;
        setInlineVideoParams(inlineparams);
        if (!TextUtils.isEmpty(inlineParams.j))
        {
            downloadCacheVideo();
        }
        if (!isValid()) goto _L2; else goto _L1
_L1:
        initInternalInlineVideo();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        MMLog.e("InlineVideoView", "The videoURI attribute was not specified on the video marker div.");
        if (true) goto _L4; else goto _L3
_L3:
        inlineparams;
        throw inlineparams;
    }

    boolean isPlayingStreaming()
    {
        return inlineParams != null && inlineParams.t;
    }

    boolean isValid()
    {
        return !TextUtils.isEmpty(inlineParams.i) || hasCachedVideo();
    }

    void onCompletion(MediaPlayer mediaplayer)
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        inlineParams.r = true;
        inlineParams.h = duration;
        if (inlineParams.h == -1)
        {
            inlineParams.h = 0;
        }
        updateVideoSeekTimeFinal();
    }

    boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        mediaplayer = (MMLayout)mmLayoutRef.get();
        if (mediaplayer == null)
        {
            MMLog.d("InlineVideoView", "MMLayout weak reference broken");
            return false;
        } else
        {
            mediaplayer.a((new StringBuilder("javascript:MMJS.setError(")).append(String.format("Error while playing, %d - %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            })).append(");").toString());
            return true;
        }
    }

    void onMediaControllerClick(View view)
    {
        view = (MMLayout)mmLayoutRef.get();
        if (view == null) goto _L2; else goto _L1
_L1:
        setBackgroundColor(0xff000000);
        if (isPlaying())
        {
            inlineParams.h = getCurrentPosition();
        }
        if (!inlineParams.b) goto _L4; else goto _L3
_L3:
        inlineParams.b = false;
        if (inlineParams.q != 1) goto _L6; else goto _L5
_L5:
        view = (Activity)getContext();
        if (view != null)
        {
            view.setRequestedOrientation(1);
        }
_L2:
        return;
_L6:
        boolean flag = isPlaying();
        stopPlayback();
        view.e();
        resumeInternal(flag);
        return;
_L4:
        inlineParams.q = getContext().getResources().getConfiguration().orientation;
        inlineParams.b = true;
        if (inlineParams.q != 2)
        {
            view = (Activity)getContext();
            if (view != null)
            {
                view.setRequestedOrientation(0);
                return;
            }
        } else
        {
            boolean flag1 = isPlaying();
            stopPlayback();
            view.f();
            resumeInternal(flag1);
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    void onPrepared(MediaPlayer mediaplayer)
    {
        if (inlineParams.m)
        {
            makeTransparent();
        }
        seekTo(inlineParams.h);
        if (inlineParams.m || !inlineParams.o)
        {
            getHeight();
        } else
        {
            inlineParams.o = false;
        }
        duration = getDuration();
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof AdViewOverlayView.SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        } else
        {
            Object obj = (AdViewOverlayView.SavedState)parcelable;
            super.onRestoreInstanceState(((AdViewOverlayView.SavedState) (obj)).getSuperState());
            parcelable = inlineParams;
            obj = ((AdViewOverlayView.SavedState) (obj)).a;
            InlineParams inlineparams = (InlineParams)(new b()).a(((String) (obj)), com/millennialmedia/android/InlineVideoView$InlineParams);
            parcelable.a = inlineparams.a;
            parcelable.c = inlineparams.c;
            parcelable.d = inlineparams.d;
            parcelable.e = inlineparams.e;
            parcelable.f = inlineparams.f;
            parcelable.g = inlineparams.g;
            parcelable.h = inlineparams.h;
            parcelable.i = inlineparams.i;
            parcelable.j = inlineparams.j;
            parcelable.k = inlineparams.k;
            parcelable.l = inlineparams.l;
            parcelable.m = inlineparams.m;
            parcelable.n = inlineparams.n;
            parcelable.o = inlineparams.o;
            parcelable.p = inlineparams.p;
            parcelable.b = inlineparams.b;
            parcelable.q = inlineparams.q;
            parcelable.r = inlineparams.r;
            com.millennialmedia.android.MMLog.b("InlineVideoView", (new StringBuilder("gson*****")).append(((String) (obj))).toString());
            com.millennialmedia.android.MMLog.b("InlineVideoView", (new StringBuilder("PARAMS*****")).append(inlineparams).toString());
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        AdViewOverlayView.SavedState savedstate = new AdViewOverlayView.SavedState(super.onSaveInstanceState());
        if (isPlaying())
        {
            inlineParams.h = getCurrentPosition();
        }
        savedstate.a = getGsonState();
        return savedstate;
    }

    boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            view = (MMLayout)mmLayoutRef.get();
            if (view == null)
            {
                MMLog.d("InlineVideoView", "MMLayout weak reference broken");
                return false;
            }
            if (!TextUtils.isEmpty(inlineParams.l))
            {
                view.a(String.format((new StringBuilder("javascript:")).append(inlineParams.l).append("(%f,%f)").toString(), new Object[] {
                    Float.valueOf(motionevent.getX()), Float.valueOf(motionevent.getY())
                }));
            }
            if (inlineParams.n && mediaController != null && !mediaController.isShowing())
            {
                mediaController.show();
                return true;
            }
        }
        return true;
    }

    void pauseVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.h = getCurrentPosition();
            pause();
        }
    }

    void playVideo()
    {
        if (isPlaying()) goto _L2; else goto _L1
_L1:
        if (!inlineParams.s || getVideoUri() == null) goto _L4; else goto _L3
_L3:
        inlineParams.s = false;
        setVideoURI(getVideoUri());
        seekTo(0);
_L6:
        inlineParams.r = false;
        startInternal();
_L2:
        if (videoHandler != null && !videoHandler.hasMessages(2))
        {
            videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
        }
        return;
_L4:
        if (inlineParams.r)
        {
            seekTo(0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    void removeVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            stopPlayback();
        }
        setOnCompletionListener(null);
        setOnErrorListener(null);
        setOnPreparedListener(null);
        setOnTouchListener(null);
        removeFromParent();
    }

    void resumeVideo()
    {
        if (!isPlaying() && !inlineParams.r)
        {
            startInternal();
            if (videoHandler != null && !videoHandler.hasMessages(2))
            {
                videoHandler.sendMessageDelayed(Message.obtain(videoHandler, 2), 500L);
            }
        }
    }

    void setAdjustVideoParams(InlineParams inlineparams)
    {
        inlineParams.a = inlineparams.a;
        inlineParams.c = inlineparams.c;
        inlineParams.f = inlineparams.f;
        inlineParams.g = inlineparams.g;
    }

    void setVideoSource(String s)
    {
        if (isPlaying())
        {
            stopPlayback();
        }
        inlineParams.h = 0;
        setBackgroundColor(0xff000000);
        setVideoURI(Uri.parse(s));
        startInternal();
    }

    public void start()
    {
        makeTransparent();
        removeKeyboardFocusViewJira1642();
        super.start();
    }

    public void startInternal()
    {
        if (((PowerManager)getContext().getSystemService("power")).isScreenOn())
        {
            start();
        }
    }

    public void stopPlayback()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.h = 0;
        }
        super.stopPlayback();
    }

    void stopVideo()
    {
        if (videoHandler != null && videoHandler.hasMessages(2))
        {
            videoHandler.removeMessages(2);
        }
        if (isPlaying())
        {
            inlineParams.s = true;
            inlineParams.h = 0;
            if (mmLayoutRef != null && mmLayoutRef.get() != null)
            {
                ((MMLayout)mmLayoutRef.get()).addBlackView();
            }
            stopPlayback();
        }
    }

    public String toString()
    {
        return inlineParams.toString();
    }

    void updateVideoSeekTime()
    {
        int i = getCurrentPosition();
        if (i >= 0)
        {
            com.millennialmedia.android.MMLog.b("InlineVideoView", (new StringBuilder("Time is ")).append(i).toString());
            updateVideoSeekTime(Math.floor((float)i / 1000F));
        }
    }

    void updateVideoSeekTime(double d)
    {
        MMLayout mmlayout = (MMLayout)mmLayoutRef.get();
        if (mmlayout == null)
        {
            MMLog.d("InlineVideoView", "MMLayout weak reference broken");
        }
        mmlayout.a((new StringBuilder("javascript:MMJS.inlineVideo.updateVideoSeekTime(")).append(d).append(");").toString());
    }

    void updateVideoSeekTimeFinal()
    {
        if (duration > 0)
        {
            com.millennialmedia.android.MMLog.b("InlineVideoView", (new StringBuilder("Time is ")).append(duration).toString());
            updateVideoSeekTime(Math.ceil((float)duration / 1000F));
        }
    }

    private class TransparentHandler extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                inlinevideoview.handleTransparentMessage(message);
            }
        }

        public TransparentHandler()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class VideoCompletionListener
        implements android.media.MediaPlayer.OnCompletionListener
    {

        private WeakReference a;

        public void onCompletion(MediaPlayer mediaplayer)
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                inlinevideoview.onCompletion(mediaplayer);
            }
        }

        public VideoCompletionListener()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class VideoErrorListener
        implements android.media.MediaPlayer.OnErrorListener
    {

        private WeakReference a;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                inlinevideoview.onError(mediaplayer, i, j);
            }
            return true;
        }

        public VideoErrorListener()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class VideoPreparedListener
        implements android.media.MediaPlayer.OnPreparedListener
    {

        private WeakReference a;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                inlinevideoview.onPrepared(mediaplayer);
            }
        }

        public VideoPreparedListener()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class VideoTouchListener
        implements android.view.View.OnTouchListener
    {

        private WeakReference a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                return inlinevideoview.onTouch(view, motionevent);
            } else
            {
                return true;
            }
        }

        public VideoTouchListener()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class VideoHandler extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 2 2: default 24
        //                       2 25;
               goto _L1 _L2
_L1:
            return;
_L2:
            if ((message = (InlineVideoView)a.get()) != null)
            {
                if (message.isPlaying())
                {
                    message.updateVideoSeekTime();
                }
                ((InlineVideoView) (message)).videoHandler.sendMessageDelayed(Message.obtain(((InlineVideoView) (message)).videoHandler, 2), 500L);
                return;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public VideoHandler()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class DownloadRunnable
        implements Runnable
    {

        private WeakReference a;

        public void run()
        {
            InlineVideoView inlinevideoview = (InlineVideoView)a.get();
            if (inlinevideoview != null)
            {
                inlinevideoview.downloadVideo();
            }
        }

        public DownloadRunnable()
        {
            a = new WeakReference(InlineVideoView.this);
        }
    }


    private class InlineParams
    {

        int a;
        boolean b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        String i;
        String j;
        String k;
        String l;
        boolean m;
        boolean n;
        boolean o;
        float p;
        int q;
        boolean r;
        boolean s;
        boolean t;

        static InlineParams a(String s1)
        {
            return (InlineParams)(new b()).a(s1, com/millennialmedia/android/InlineVideoView$InlineParams);
        }

        public String toString()
        {
            return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", new Object[] {
                k, Integer.valueOf(a), Integer.valueOf(c), Integer.valueOf(d), Integer.valueOf(e), Integer.valueOf(h), Boolean.valueOf(m)
            });
        }

        InlineParams(Map map, Context context)
        {
            o = true;
            if (map.get("x") != null)
            {
                a = (int)Float.parseFloat((String)map.get("x"));
            }
            if (map.get("y") != null)
            {
                c = (int)Float.parseFloat((String)map.get("y"));
            }
            if (map.get("width") != null)
            {
                f = (int)Float.parseFloat((String)map.get("width"));
            }
            if (map.get("height") != null)
            {
                g = (int)Float.parseFloat((String)map.get("height"));
            }
            i = (String)map.get("streamVideoURI");
            j = (String)map.get("cachedVideoURI");
            k = (String)map.get("cachedVideoID");
            if (map.get("autoPlay") != null)
            {
                m = Boolean.parseBoolean((String)map.get("autoPlay"));
            }
            if (map.get("showControls") != null)
            {
                n = Boolean.parseBoolean((String)map.get("showControls"));
            }
            if (map.get("bodyWidth") != null)
            {
                d = (int)Float.parseFloat((String)map.get("bodyWidth"));
            }
            if (map.get("bodyHeight") != null)
            {
                e = (int)Float.parseFloat((String)map.get("bodyHeight"));
            }
            l = (String)map.get("touchCallback");
            p = context.getResources().getDisplayMetrics().density;
        }
    }


    private class MediaController extends android.widget.MediaController
    {

        private BitmapDrawable a;
        private BitmapDrawable b;
        private WeakReference c;

        public void setAnchorView(View view)
        {
            super.setAnchorView(view);
            view = new Button(getContext());
            Object obj;
            if (a == null)
            {
                try
                {
                    a = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABOpJREFUeNrUmmtIY0cUgCfJ3VBXUXxR0dp2Ya0aBSFi6yOtFPGF1d1WavrAXy1YwVcLLaQpttsH+lcbirYq0a3Ptd0WpKi1P1SMaAitJNptalcQIwV/iI+o2ST39kx6I9cY3STcuSYHhjuTzD33fJk5M+fciWh9fR0tLCwgrhwfH6OcnBwkl8ur9vb2DIODg5aIiAjkq1itViQWi1FYWBgiKYmJiQhptdpzX6SlpSGz2fwRwzDHR0dH83V1dYn+KK6oqLjR19enQISluLgYof7+/jMfZmRkIIvFcoc5K783NTU95YvSsrKyFLvd/s/a2pqRNEBJSclZAJlMhra2tjyNP4Vobm5OukxhaWlpysnJyQPceXl5WS8SicgDDAwMuBrp6enY+M+Zy2UFIJ72pqy8vDwFfOcvd0ebzWYoLCwkD9DR0YFSU1Ox8W2Mb7IKEM+4lWBnHRoaSnM6nX97jhhAkQfQ6/XXNjY27jD+iamhoeFZiqLQyMhIOrQfeuljhCklJg4AD7rFBCA0Tf+h0+luQ9V80UgBAEUaQAzrvB7qk/7eDA6alZeXdx+qKRd0wb++hPRKJIZNaru+vv4NqP/Gs25sPEUcIDw8HHV1de2BY1bzDCFmC1kA91rd2dmJIV6D6nRIjQC3ARD7LMQvPOmWCArAQlhbWlqUPEBIrgQAC2xuh42NjUoI5O5BkwmpEXCLRqM5XFlZ+Qaq9qB2Yq9jL5HgHRaW+bzvoSkNZic+9wA2tnmxpqbmB2jGB7sPUB67KzZeAcb/CM24kHBi9z6Ar8PDwy8plcr7PBgvnBND9uSa82D8y2D8TzwZLxgAhRN4yF+zwfhfeX7gdSjXiANgp11cXDyCjOxr1ick7MojYQ2g2Cu3fvpZcnKyOCEhQcL5xd1XK+QLu8QB2GDuTyjvB6IgKSkJZWZmejouLrTBYLAJvoz6KxaLxVVYcbLljOTm5oqioqLwlHJw+jB4+s7NzQX8bIfDQX6jwdLb2/upTCZ7kzWcZouTHSUnZHd2tv2IvdrZ4vC4uuv09va2eXx8XCMIgNVqxXPsOW/fZWdnB6TTZrNp8egJAgByyKey/f19LeTD7+IFSCwQgINH47+rrKx8Z2lpyRkZGSkYwCM+lBwcHHwLxtfB1ME+hN+ohM4IsMa/B8YzPuUDwQSwu7urAePrZ2dnGd73AdJTCGK1n2traxvBeP8ysmAZAQhHXlCpVK/Ex8dfKUCgaSkO8xMKCgpGJycnb3uDCBUnvi6Xy4cA4lZcXFxIAmAJA4iRqamp12NjY0+TsJDaB0CeAIjB6enpmujo6P8PE0NtJ8Y5CEDcnZiYUOJQngpBACzS/Pz8u1lZWfSVr0I7OzufrK6uqgMZCUjG3qauEgDCgy+qqqq+woftsFGJIGf40g+dD+fn51XnzolJCCQtb3meP21ubn7GPcXE89lkMql9POFab21tTYVMDwkCMDMzo+Q+fXR0VI1DYW/5tdFoVD3G+AdtbW2uY62ioiJhAKqrq1/lGo9PNy8S/P8HgPjwEuNvuvueO6knDTA2NvbxZcY/BmKtvb39JrefC6Cnp4c4AMQyT3Z3d5f6cw9+3aPT6T7AlkNEalKr1Tc8+ygUCiSC7B7BMkYUgKZpnIQjqVTqeo3pYxjtGglY65+H+ib40b949Lj/v4iJiUH/CTAAFI2ZNCJ5irUAAAAASUVORK5CYII=")));
                }
                catch (Exception exception)
                {
                    MMLog.a("InlineVideoView", "Exception setting image anchorView inDrawable:", exception);
                }
            }
            if (b == null)
            {
                try
                {
                    b = new BitmapDrawable(new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAABEZJREFUeNrUml9IU1Ecx8+2uwnCrBlaGD2YEKiVla2ypAj8X+l8KYpkLxUFoT0VBT1YUYYP6ktQCGUQgQr+w0o3sgdDEv+AaBH9odicEq4XY25u7vY9dhe3m9N5d+8Z/uDHvRzPn+/nnN/5d6eG5/mNhJCjcAPcD18QngHhPSDxBVE+cfo/aXa7/afL5eKJipaSkkI4QfwzuBZOGwwKQoKS90jTqOvm5uZqrFbrYzUB8vPzFwEMgnhqGtq44LLN4/F8bmxsfEdUNo1GswjgF3peo0SlED9hsVhKbTbbV8LAtELMBhUSP1ZeXn6clXgxwEK0FSHmqfgTvb293whD45QAEMQfh3gHYWxa0eohy2ZmZt4i5o/19PQwFx8CmI9mBLq6umrQ804SI4t6BCoqKh5UVVWZYwVAsBMfhrv56GwKEPtYay8oKFgEyIH/4KO36crKyoOxADDTxnll7AcgDrEG2A2f5JUzCpHLEmAn3MEraxTiCCuAdPj3ZcR4ZEK4MbH3qw2w7FFidna2t6mpiU7M1zLqT8QSu43FMroV/vm/bvd47Dhvm2ge9OQGJL1ZTfc7nc77WVlZOhYhtAX+USLeVlhYaBJnXg0ExN/LyMhgNolT4B9CjeNg9hLiE5YqAAgTsthWEp+ens50Gd0If08b93q9r8KJF0GsR1Z7GPG3WfS8FCCBzgGfz/e6qKgoIZKCWCLXS0dicnKyOjMzk/1Roq+vj+AsfyA7OzthNYUBYYTuF/BALMT/BcDlW3YFubm58Qi5vampqTE5iFIATq/Xy66gv7/fg8eQ3PJ5eXmbdTrduqGhofdut1vOHZwQbFQx6b2GhoZMhN8n+K/h4eHypKSkiMvGxcXRsN9XXV29KSYA9fX1GRD+RbQGeAFxMhIIKr6zs/M0yvjh55gDQPx2ifiQ+QBxKjk5eSXxZwTx1C4xBYB4evL9tsw+6B0ZGVkSwmAwkI6ODip+XpT/MjOAurq6HSucev+OBCAqxBCCeKtEPLUrqgPQxtHzeyIUH7L50dHRs4mJiYt1tLe3W0VhI7arqgMUFxfHSw+LEZpvcHDwZHd39+kw4qnd4NQOnfHxcf/ExMQAdurV3g0MZrP5ufDROdyHZ71WbQCHw+HHjnkRIE9lfrda7qs5p2UxgV0ulxeXo3OAeKJw1TotqyV0enqajsR5hSEMzACoTU1NBXD4oxCNClXJMQUQwolCXMDEfqRAdXrmAAIETyf22NjYQ/Ln5621MwJiCIvFcjEQCAysuREI7dC1tbVVuA/simYEuFiJb2lpuVZaWlqz5iYxvQE2NzcrIZ59CHEYcPT89bKyshql+oMZAGKdtLa23oT4u0r2CRMAk8mkb2truwPxt5SeTpzf71cdIC0tzVhSUpKP1++hARFcu8RzqbSwBzoN1mOCXVFVgGAwSHJycuKMRmM8+fcfSqQg0jQuzN90Qj3O3wIMAN8Np0JgnxtnAAAAAElFTkSuQmCC")));
                }
                catch (Exception exception1)
                {
                    MMLog.a("InlineVideoView", "Exception setting image anchorView outDrawable:", exception1);
                }
            }
            obj = (InlineVideoView)c.get();
            if (obj != null)
            {
                class MediaClickListener
                    implements android.view.View.OnClickListener
                {

                    private WeakReference a;

                    public final void onClick(View view1)
                    {
                        InlineVideoView inlinevideoview = (InlineVideoView)a.get();
                        if (inlinevideoview != null)
                        {
                            inlinevideoview.onMediaControllerClick(view1);
                        }
                    }

                public MediaClickListener()
                {
                    a = new WeakReference(InlineVideoView.this);
                }
                }

                if (((InlineVideoView) (obj)).inlineParams.b)
                {
                    view.setBackgroundDrawable(a);
                } else
                {
                    view.setBackgroundDrawable(b);
                }
                view.setOnClickListener(((MediaClickListener) (obj)). new MediaClickListener());
            }
            obj = new android.widget.FrameLayout.LayoutParams(-2, -2, 5);
            ((android.widget.FrameLayout.LayoutParams) (obj)).setMargins(0, 20, 10, 0);
            addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
        }

        public MediaController()
        {
            super(getContext());
            c = new WeakReference(InlineVideoView.this);
        }
    }

}
