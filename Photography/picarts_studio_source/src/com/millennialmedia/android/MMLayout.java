// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, MMLog, MMSDK, AdCache, 
//            InlineVideoView, MMAdImpl, MMAdImplController, MMWebView, 
//            BridgeMMSpeechkit, RequestListener, MMRequest

abstract class MMLayout extends RelativeLayout
    implements InlineVideoView.TransparentFix, MMAd
{

    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    private static boolean b;
    private GestureDetector a;
    private View c;
    MMAdImpl e;
    boolean f;
    View g;
    RelativeLayout h;
    InlineVideoView i;

    protected MMLayout(Context context)
    {
        super(context);
        a(context);
    }

    protected MMLayout(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a(context);
    }

    private void a(Context context)
    {
        try
        {
            MMLog.c("MMLayout", "Initializing MMLayout.");
            MMSDK.d(context);
            MMSDK.e(context);
        }
        catch (Exception exception)
        {
            MMLog.a("MMLayout", "There was an exception initializing the MMAdView. ", exception);
            exception.printStackTrace();
        }
        a = new GestureDetector(context.getApplicationContext(), new LayoutGestureListener());
        if (!b)
        {
            MMLog.b("MMLayout", "********** Millennial Device Id *****************");
            MMLog.b("MMLayout", MMSDK.c(context));
            MMLog.b("MMLayout", "Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
            MMLog.b("MMLayout", "*************************************************");
            AdCache.b(context);
            b = true;
        }
    }

    static void a(MMLayout mmlayout, String s)
    {
        if (mmlayout.g != null) goto _L2; else goto _L1
_L1:
        android.widget.RelativeLayout.LayoutParams layoutparams;
        mmlayout.g = new View(mmlayout.getContext());
        float f1 = mmlayout.getContext().getResources().getDisplayMetrics().density;
        layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(50F * f1), (int)(f1 * 50F));
        if (!"top-right".equals(s)) goto _L4; else goto _L3
_L3:
        layoutparams.addRule(11);
_L6:
        mmlayout.g.setOnClickListener(mmlayout. new android.view.View.OnClickListener() {

            private MMLayout a;

            public void onClick(View view)
            {
                a.a();
            }

            
            {
                a = MMLayout.this;
                super();
            }
        });
        mmlayout.addView(mmlayout.g, layoutparams);
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

    void a()
    {
    }

    final void a(InlineVideoView.InlineParams inlineparams)
    {
        if (i != null)
        {
            ViewGroup viewgroup = (ViewGroup)i.getParent();
            if (viewgroup != null)
            {
                viewgroup.removeView(i);
            }
            if (i.isPlaying())
            {
                i.stopPlayback();
            }
            i = null;
        }
        i = new InlineVideoView(this);
        i.initInlineVideo(inlineparams);
        inlineparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        inlineparams.addRule(13, -1);
        i.setLayoutParams(inlineparams);
        c();
    }

    final void a(String s)
    {
        if (MMSDK.a(getContext()))
        {
            if (e.h != null)
            {
                MMAdImplController mmadimplcontroller = e.h;
                if (!TextUtils.isEmpty(s) && mmadimplcontroller.a != null)
                {
                    mmadimplcontroller.a.loadUrl(s);
                }
            }
            return;
        } else
        {
            MMLog.e("MMLayout", "No network available, can't load overlay.");
            return;
        }
    }

    public void addBlackView()
    {
        if (c != null)
        {
            android.view.ViewParent viewparent = c.getParent();
            if (viewparent != null && (viewparent instanceof ViewGroup))
            {
                ((ViewGroup)viewparent).removeView(c);
                c = null;
            }
        }
        c = new View(getContext());
        c.setBackgroundColor(0xff000000);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        c.setLayoutParams(layoutparams);
        if (h != null && c.getParent() == null)
        {
            h.addView(c);
        }
        if (c != null)
        {
            c.setVisibility(0);
        }
    }

    void c()
    {
        if (h != null && h.getParent() != null)
        {
            ((ViewGroup)h.getParent()).removeView(h);
        }
        h = new RelativeLayout(getContext());
        h.setId(0x35391858);
        if (i.getParent() != null)
        {
            ((ViewGroup)i.getParent()).removeView(i);
        }
        h.addView(i);
        if (c != null)
        {
            if (c.getParent() == null)
            {
                h.addView(c);
            }
            c.bringToFront();
        }
        addView(h, i.getCustomLayoutParams());
    }

    void e()
    {
    }

    void f()
    {
    }

    protected void finalize()
    {
        if (getId() == -1)
        {
            e.g = true;
            MMLog.b("MMLayout", (new StringBuilder("finalize() for ")).append(e).toString());
            MMAdImplController.d(e);
        }
    }

    final void g()
    {
        if (i != null)
        {
            i.removeVideo();
            i = null;
        }
    }

    public String getApid()
    {
        return e.getApid();
    }

    public boolean getIgnoresDensityScaling()
    {
        return e.getIgnoresDensityScaling();
    }

    public RequestListener getListener()
    {
        return e.getListener();
    }

    public MMRequest getMMRequest()
    {
        return e.getMMRequest();
    }

    final void h()
    {
        if (i != null)
        {
            i.pauseVideo();
        }
    }

    final void i()
    {
        if (i != null)
        {
            i.resumeVideo();
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!isInEditMode())
        {
            MMLog.b("MMLayout", (new StringBuilder("onAttachedToWindow for ")).append(e).toString());
            if (getId() == -1)
            {
                MMLog.d("MMLayout", "MMAd missing id from getId(). Performance will be affected for configuration changes.");
            }
            if (!f)
            {
                MMAdImplController.a(e);
            }
            if (h != null)
            {
                h.bringToFront();
            }
            if (e != null && e.h != null && e.h.a != null)
            {
                e.h.a.d = true;
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        MMLog.b("MMLayout", (new StringBuilder("onDetachedFromWindow for")).append(e).toString());
        Context context = getContext();
        if (e.e == "i" && context != null && (context instanceof Activity) && ((Activity)context).isFinishing())
        {
            e.g = true;
        }
        if (!f)
        {
            MMAdImplController.d(e);
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        parcelable = (Bundle)parcelable;
        long l = e.f;
        e.f = parcelable.getLong("MMAdImplId");
        e.j = parcelable.getLong("MMAdImplLinkedId");
        MMLog.b("MMLayout", (new StringBuilder("onRestoreInstanceState replacing adImpl-")).append(l).append(" with ").append(e).append(" id=").append(getId()).toString());
        String s = parcelable.getString("inlineVideoViewGson");
        if (s != null)
        {
            a(InlineVideoView.InlineParams.a(s));
        }
        super.onRestoreInstanceState(parcelable.getParcelable("super"));
    }

    protected Parcelable onSaveInstanceState()
    {
        super.onSaveInstanceState();
        MMLog.b("MMLayout", (new StringBuilder("onSaveInstanceState saving - ")).append(e).append(" id=").append(getId()).toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putLong("MMAdImplId", e.f);
        bundle.putLong("MMAdImplLinkedId", e.j);
        if (i != null)
        {
            if (i.isPlaying())
            {
                i.inlineParams.h = i.getCurrentPosition();
            }
            bundle.putString("inlineVideoViewGson", i.getGsonState());
        }
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent) || !isClickable() || super.onTouchEvent(motionevent);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        BridgeMMMedia.Audio audio;
        if (flag)
        {
            if (i != null)
            {
                i.resumeVideo();
            }
        } else
        if (i != null)
        {
            i.pauseVideo();
        }
        MMLog.b("MMLayout", String.format("Window Focus Changed. For %s, Window in focus?: %b Controllers: %s", new Object[] {
            e, Boolean.valueOf(flag), MMAdImplController.a()
        }));
        if (e != null && e.h != null && e.h.a != null)
        {
            if (flag)
            {
                e.h.a.onResumeWebView();
                e.h.a.m();
            } else
            {
                BridgeMMSpeechkit.a();
                e.h.a.l();
                e.h.a.onPauseWebView();
            }
        }
        if (!flag && (getContext() instanceof Activity))
        {
            Activity activity = (Activity)getContext();
            if (activity == null || activity.isFinishing() && e != null)
            {
                e.g = true;
                if (e.h != null && e.h.a != null)
                {
                    e.h.a.k();
                    MMAdImplController.d(e);
                }
            }
        }
        audio = BridgeMMMedia.Audio.a(getContext());
        if (audio == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        audio.b();
        this;
        JVM INSTR monitorexit ;
_L2:
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeBlackView()
    {
        if (c != null)
        {
            c.setVisibility(4);
        }
    }

    public void setApid(String s)
    {
        e.setApid(s);
    }

    public void setIgnoresDensityScaling(boolean flag)
    {
        e.setIgnoresDensityScaling(flag);
    }

    public void setListener(RequestListener requestlistener)
    {
        e.setListener(requestlistener);
    }

    public void setMMRequest(MMRequest mmrequest)
    {
        e.setMMRequest(mmrequest);
    }

    // Unreferenced inner class com/millennialmedia/android/MMLayout$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        private String a;
        private MMLayout b;

        public void run()
        {
            MMLayout.a(b, a);
        }

            
            {
                b = MMLayout.this;
                a = s;
                super();
            }
    }


    // Unreferenced inner class com/millennialmedia/android/MMLayout$3

/* anonymous class */
    class _cls3
        implements Runnable
    {

        private InlineVideoView.InlineParams a;
        private MMLayout b;

        public void run()
        {
            if (b.i != null)
            {
                b.i.adjustVideo(a);
            }
        }

            
            {
                b = MMLayout.this;
                a = inlineparams;
                super();
            }
    }


    private class LayoutGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        private WeakReference a;

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
        {
            while (motionevent == null || motionevent1 == null || Math.abs((int)(motionevent1.getX() - motionevent.getX())) <= 200 || Math.abs(f1) <= Math.abs(f2)) 
            {
                return false;
            }
            if (f1 <= 0.0F) goto _L2; else goto _L1
_L1:
            if (MMSDK.a == 0)
            {
                MMLog.c("MMLayout", "Enabling debug and verbose logging.");
                MMSDK.a = 3;
            } else
            {
                MMLog.c("MMLayout", "Disabling debug and verbose logging.");
                MMSDK.a = 0;
            }
_L4:
            return true;
_L2:
            motionevent = (MMLayout)a.get();
            if (motionevent != null)
            {
                MMSDK.a(((MMLayout) (motionevent)).e);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public LayoutGestureListener()
        {
            a = new WeakReference(MMLayout.this);
        }
    }

}
