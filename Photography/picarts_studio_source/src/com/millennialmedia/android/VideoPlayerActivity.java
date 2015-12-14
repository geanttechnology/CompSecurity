// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, MMLog, VideoImage, HttpRedirection

class VideoPlayerActivity extends MMBaseActivity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    private boolean a;
    protected boolean c;
    protected int d;
    protected boolean e;
    protected VideoView f;
    HttpRedirection.RedirectionListenerImpl g;
    Button h;
    boolean i;
    private boolean j;
    private boolean k;
    private RelativeLayout l;
    private ProgressBar m;
    private View n;
    private TransparentHandler o;
    private boolean p;

    VideoPlayerActivity()
    {
        k = true;
        c = true;
        d = 0;
        o = new TransparentHandler();
        i = false;
    }

    protected static void a(ImageButton imagebutton, float f1)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(f1, f1);
        alphaanimation.setDuration(0L);
        alphaanimation.setFillEnabled(true);
        alphaanimation.setFillBefore(true);
        alphaanimation.setFillAfter(true);
        imagebutton.startAnimation(alphaanimation);
    }

    protected static void a(VideoImage videoimage)
    {
        MMLog.b("VideoPlayerActivity", "Cached video button event logged");
        for (int i1 = 0; i1 < videoimage.eventLoggingUrls.length; i1++)
        {
            MMSDK.Event.a(videoimage.eventLoggingUrls[i1]);
        }

    }

    static boolean a(VideoPlayerActivity videoplayeractivity)
    {
        videoplayeractivity.k = true;
        return true;
    }

    static boolean a(VideoPlayerActivity videoplayeractivity, Uri uri)
    {
        if (uri.getScheme().equalsIgnoreCase("mmsdk"))
        {
            videoplayeractivity = uri.getHost();
            boolean flag;
            if (videoplayeractivity != null && (videoplayeractivity.equalsIgnoreCase("restartVideo") || videoplayeractivity.equalsIgnoreCase("endVideo")))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
            MMLog.a("VideoPlayerActivity", String.format("Unrecognized mmsdk:// URI %s.", new Object[] {
                uri
            }));
        }
        return false;
    }

    protected void a()
    {
        super.a();
        n.bringToFront();
        n.setVisibility(0);
        p = false;
        MMLog.a("VideoPlayerActivity", "VideoPlayer - onResume");
        if (j && !i)
        {
            g();
        }
    }

    protected void a(int i1)
    {
        String s;
        i = false;
        s = getIntent().getData().toString();
        MMLog.b("VideoPlayerActivity", String.format("playVideo path: %s", new Object[] {
            s
        }));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (s.length() != 0 && f != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        a("no name or null videoview");
        return;
        try
        {
            e = false;
            if (k && f != null)
            {
                f.setVideoURI(Uri.parse(s));
            }
            f.requestFocus();
            f.seekTo(i1);
            if (((PowerManager)getSystemService("power")).isScreenOn())
            {
                if (m != null)
                {
                    m.bringToFront();
                    m.setVisibility(0);
                }
                if (h != null)
                {
                    h.setBackgroundResource(0x1080023);
                }
                f.start();
                if (!o.hasMessages(4))
                {
                    o.sendEmptyMessage(4);
                    return;
                }
            }
        }
        catch (Exception exception)
        {
            MMLog.a("VideoPlayerActivity", "playVideo error: ", exception);
            a((new StringBuilder("error: ")).append(exception).toString());
        }
        return;
    }

    protected void a(Bundle bundle)
    {
        bundle.putInt("currentVideoPosition", d);
        bundle.putBoolean("isVideoCompleted", e);
        bundle.putBoolean("isVideoCompletedOnce", a);
        bundle.putBoolean("hasBottomBar", c);
        bundle.putBoolean("shouldSetUri", k);
        bundle.putBoolean("isUserPausing", i);
        bundle.putBoolean("isPaused", p);
        super.a(bundle);
    }

    final void a(Message message)
    {
        message.what;
        JVM INSTR tableswitch 4 5: default 28
    //                   4 29
    //                   5 90;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        if (f != null && f.isPlaying() && f.getCurrentPosition() > 0)
        {
            f.setBackgroundColor(0);
            o.sendEmptyMessageDelayed(5, 100L);
            return;
        } else
        {
            o.sendEmptyMessageDelayed(4, 50L);
            return;
        }
_L3:
        if (f != null && f.isPlaying() && f.getCurrentPosition() > 0)
        {
            n.setVisibility(4);
            m.setVisibility(4);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void a(String s)
    {
        Toast.makeText(b, "Sorry. There was a problem playing the video", 1).show();
        if (f != null)
        {
            f.stopPlayback();
        }
    }

    protected final void b()
    {
        super.b();
        p = true;
        MMLog.a("VideoPlayerActivity", "VideoPlayer - onPause");
        f();
    }

    protected void b(Bundle bundle)
    {
        d = bundle.getInt("currentVideoPosition");
        e = bundle.getBoolean("isVideoCompleted");
        a = bundle.getBoolean("isVideoCompletedOnce");
        c = bundle.getBoolean("hasBottomBar", c);
        k = bundle.getBoolean("shouldSetUri", k);
        i = bundle.getBoolean("isUserPausing", i);
        p = bundle.getBoolean("isPaused", p);
        super.b(bundle);
    }

    final void b(String s)
    {
        if (s != null)
        {
            MMLog.b("VideoPlayerActivity", String.format("Button Click with URL: %s", new Object[] {
                s
            }));
            g.a = s;
            g.b = new WeakReference(b);
            if (!g.isHandlingMMVideo(Uri.parse(s)))
            {
                HttpRedirection.a(g);
                return;
            }
        }
    }

    protected void c(Bundle bundle)
    {
        if (bundle != null)
        {
            e = bundle.getBoolean("videoCompleted");
            a = bundle.getBoolean("videoCompletedOnce");
            d = bundle.getInt("videoPosition");
            c = bundle.getBoolean("hasBottomBar");
            k = bundle.getBoolean("shouldSetUri");
        }
    }

    protected RelativeLayout e()
    {
        RelativeLayout relativelayout = new RelativeLayout(b);
        relativelayout.setId(400);
        relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        relativelayout.setBackgroundColor(0xff000000);
        l = new RelativeLayout(b);
        l.setBackgroundColor(0xff000000);
        l.setId(410);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        layoutparams1.addRule(13);
        f = new VideoView(b);
        f.setId(411);
        f.getHolder().setFormat(-2);
        f.setBackgroundColor(0xff000000);
        f.setOnCompletionListener(this);
        f.setOnPreparedListener(this);
        f.setOnErrorListener(this);
        l.addView(f, layoutparams);
        n = new View(b);
        n.setBackgroundColor(0xff000000);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        relativelayout.addView(l, layoutparams1);
        if (c)
        {
            layoutparams.addRule(2, 0x4fe0613);
            RelativeLayout relativelayout1 = new RelativeLayout(b);
            relativelayout1.setId(0x4fe0613);
            relativelayout1.setBackgroundColor(0xff000000);
            android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            relativelayout1.setLayoutParams(layoutparams2);
            layoutparams2.addRule(12);
            Button button = new Button(b);
            h = new Button(b);
            Button button1 = new Button(b);
            button.setBackgroundResource(0x1080025);
            android.widget.RelativeLayout.LayoutParams layoutparams3;
            android.widget.RelativeLayout.LayoutParams layoutparams4;
            android.widget.RelativeLayout.LayoutParams layoutparams5;
            if (f.isPlaying())
            {
                h.setBackgroundResource(0x1080023);
            } else
            {
                h.setBackgroundResource(0x1080024);
            }
            button1.setBackgroundResource(0x1080038);
            layoutparams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams3.addRule(14);
            relativelayout1.addView(h, layoutparams3);
            layoutparams5.addRule(0, h.getId());
            relativelayout1.addView(button);
            layoutparams4.addRule(11);
            relativelayout1.addView(button1, layoutparams4);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                private VideoPlayerActivity a;

                public void onClick(View view)
                {
                    if (a.f != null)
                    {
                        a.f.seekTo(0);
                    }
                }

            
            {
                a = VideoPlayerActivity.this;
                super();
            }
            });
            h.setOnClickListener(new android.view.View.OnClickListener() {

                private VideoPlayerActivity a;

                public void onClick(View view)
                {
label0:
                    {
                        if (a.f != null)
                        {
                            if (!a.f.isPlaying())
                            {
                                break label0;
                            }
                            a.m();
                            a.h.setBackgroundResource(0x1080024);
                        }
                        return;
                    }
                    if (a.e)
                    {
                        a.a(0);
                    } else
                    if (a.i && !a.e)
                    {
                        a.g();
                    } else
                    {
                        a.a(a.d);
                    }
                    a.h.setBackgroundResource(0x1080023);
                }

            
            {
                a = VideoPlayerActivity.this;
                super();
            }
            });
            button1.setOnClickListener(new android.view.View.OnClickListener() {

                private VideoPlayerActivity a;

                public void onClick(View view)
                {
                    if (a.f != null)
                    {
                        VideoPlayerActivity.a(a);
                        a.l();
                    }
                }

            
            {
                a = VideoPlayerActivity.this;
                super();
            }
            });
            relativelayout.addView(relativelayout1, layoutparams2);
        }
        n.setLayoutParams(layoutparams);
        relativelayout.addView(n);
        m = new ProgressBar(b);
        m.setIndeterminate(true);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        m.setLayoutParams(layoutparams);
        relativelayout.addView(m);
        m.setVisibility(4);
        return relativelayout;
    }

    protected void f()
    {
        if (f != null && f.isPlaying())
        {
            d = f.getCurrentPosition();
            f.pause();
            MMLog.a("VideoPlayerActivity", "Video paused");
        }
    }

    protected void g()
    {
        boolean flag;
        if (f != null && !f.isPlaying() && !e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(d);
        }
    }

    protected void h()
    {
        MMLog.b("VideoPlayerActivity", "Restart Video.");
        if (f != null)
        {
            a(0);
        }
    }

    protected void i()
    {
    }

    protected boolean j()
    {
        return !e;
    }

    protected final void k()
    {
        MMLog.b("VideoPlayerActivity", "End Video.");
        if (f != null)
        {
            k = true;
            l();
        }
    }

    protected final void l()
    {
        MMLog.b("VideoPlayerActivity", "Video ad player closed");
        if (f != null)
        {
            if (f.isPlaying())
            {
                f.stopPlayback();
            }
            f = null;
        }
        finish();
    }

    protected final void m()
    {
        i = true;
        f();
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a = true;
        e = true;
        if (h != null && !f.isPlaying())
        {
            h.setBackgroundResource(0x1080024);
        }
        MMLog.a("VideoPlayerActivity", "Video player on complete");
    }

    public void onCreate(Bundle bundle)
    {
        setTheme(0x1030005);
        super.onCreate(bundle);
        MMLog.b("VideoPlayerActivity", "Setting up the video player");
        requestWindowFeature(1);
        getWindow().clearFlags(2048);
        getWindow().addFlags(1024);
        c(bundle);
        g = new VideoRedirectionListener();
        setContentView(e());
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        return false;
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0 && !a)
        {
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        MMLog.b("VideoPlayerActivity", "Video Prepared");
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        j = flag;
        if (!p && flag && !i)
        {
            g();
        }
    }

    // Unreferenced inner class com/millennialmedia/android/VideoPlayerActivity$1

/* anonymous class */
    class _cls1
        implements Runnable
    {

        private String a;
        private VideoPlayerActivity b;

        public void run()
        {
            if (a.equalsIgnoreCase("restartVideo"))
            {
                b.h();
            } else
            if (a.equalsIgnoreCase("endVideo"))
            {
                b.k();
                return;
            }
        }

            
            {
                b = VideoPlayerActivity.this;
                a = s;
                super();
            }
    }


    private class TransparentHandler extends Handler
    {

        private WeakReference a;

        public void handleMessage(Message message)
        {
            VideoPlayerActivity videoplayeractivity = (VideoPlayerActivity)a.get();
            if (videoplayeractivity != null)
            {
                videoplayeractivity.a(message);
            }
        }

        public TransparentHandler()
        {
            a = new WeakReference(VideoPlayerActivity.this);
        }
    }


    private class VideoRedirectionListener extends HttpRedirection.RedirectionListenerImpl
    {

        private WeakReference f;

        public OverlaySettings getOverlaySettings()
        {
            f.get();
            return null;
        }

        public boolean isHandlingMMVideo(Uri uri)
        {
            VideoPlayerActivity videoplayeractivity = (VideoPlayerActivity)f.get();
            if (videoplayeractivity != null)
            {
                videoplayeractivity.runOnUiThread(videoplayeractivity. new Runnable() {

                    private VideoPlayerActivity a;

                    public void run()
                    {
                        a.i();
                    }

                
                {
                    a = VideoPlayerActivity.this;
                    super();
                }
                });
                if (uri != null && VideoPlayerActivity.a(videoplayeractivity, uri))
                {
                    videoplayeractivity.runOnUiThread(videoplayeractivity. new Runnable(uri.getHost())     class _cls1
        implements Runnable
    {

        private String a;
        private VideoPlayerActivity b;

        public void run()
        {
            if (a.equalsIgnoreCase("restartVideo"))
            {
                b.h();
            } else
            if (a.equalsIgnoreCase("endVideo"))
            {
                b.k();
                return;
            }
        }

            
            {
                b = VideoPlayerActivity.this;
                a = s;
                super();
            }
    });
                    return true;
                }
            }
            return false;
        }

        public VideoRedirectionListener()
        {
            if (VideoPlayerActivity.this != null)
            {
                f = new WeakReference(VideoPlayerActivity.this);
                if (b != null)
                {
                    e = b.b;
                }
            }
        }
    }

}
