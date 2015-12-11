// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ae, al, MMActivity, OverlaySettings

final class av extends ae
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    private static final class a extends Handler
    {

        private WeakReference a;

        public final void handleMessage(Message message)
        {
            av av1 = (av)a.get();
            if (av1 != null)
            {
                av1.a(message);
            }
        }

        public a(av av1)
        {
            a = new WeakReference(av1);
        }
    }

    static final class b extends x.a
    {

        WeakReference f;

        public final boolean a(Uri uri)
        {
            av av1 = (av)f.get();
            if (av1 != null)
            {
                av1.a(new Runnable(this, av1) {

                    final av a;
                    final b b;

                    public final void run()
                    {
                    }

            
            {
                b = b1;
                a = av1;
                super();
            }
                });
                if (uri != null && av.a(uri))
                {
                    av1.a(av1. new Runnable(uri.getHost()) {

                        final String a;
                        final av b;

                        public final void run()
                        {
                            if (a.equalsIgnoreCase("restartVideo"))
                            {
                                b.h();
                            } else
                            if (a.equalsIgnoreCase("endVideo"))
                            {
                                b.i();
                                return;
                            }
                        }

            
            {
                b = av.this;
                a = s;
                super();
            }
                    });
                    return true;
                }
            }
            return false;
        }

        public final OverlaySettings b()
        {
            av av1 = (av)f.get();
            if (av1 != null && av1.g != null)
            {
                OverlaySettings overlaysettings = new OverlaySettings();
                overlaysettings.g = av1.g;
                return overlaysettings;
            } else
            {
                return null;
            }
        }

        public b(av av1)
        {
            if (av1 != null)
            {
                f = new WeakReference(av1);
                if (av1.d != null)
                {
                    e = av1.d.b;
                }
            }
        }
    }


    protected boolean a;
    protected int b;
    protected boolean c;
    protected VideoView e;
    x.a f;
    String g;
    RelativeLayout h;
    ProgressBar i;
    Button j;
    View k;
    a l;
    boolean m;
    boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    av()
    {
        q = true;
        a = true;
        b = 0;
        l = new a(this);
        n = false;
    }

    static boolean a(Uri uri)
    {
        if (uri.getScheme().equalsIgnoreCase("mmsdk"))
        {
            String s = uri.getHost();
            boolean flag;
            if (s != null && (s.equalsIgnoreCase("restartVideo") || s.equalsIgnoreCase("endVideo")))
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
            String.format("Unrecognized mmsdk:// URI %s.", new Object[] {
                uri
            });
            al.a();
        }
        return false;
    }

    static boolean a(av av1)
    {
        av1.q = true;
        return true;
    }

    private void m()
    {
        Toast.makeText(d, "Sorry. There was a problem playing the video", 1).show();
        if (e != null)
        {
            e.stopPlayback();
        }
    }

    private void n()
    {
        if (e != null && e.isPlaying())
        {
            b = e.getCurrentPosition();
            e.pause();
            al.a();
        }
    }

    public final void a(Bundle bundle)
    {
        b(0x1030005);
        super.a(bundle);
        al.b();
        g();
        super.d.getWindow().clearFlags(2048);
        super.d.getWindow().addFlags(1024);
        if (bundle != null)
        {
            c = bundle.getBoolean("videoCompleted");
            o = bundle.getBoolean("videoCompletedOnce");
            b = bundle.getInt("videoPosition");
            a = bundle.getBoolean("hasBottomBar");
            q = bundle.getBoolean("shouldSetUri");
        }
        f = new b(this);
        bundle = new RelativeLayout(d);
        bundle.setId(400);
        bundle.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        bundle.setBackgroundColor(0xff000000);
        h = new RelativeLayout(d);
        h.setBackgroundColor(0xff000000);
        h.setId(410);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        layoutparams1.addRule(13);
        e = new VideoView(d);
        e.setId(411);
        e.getHolder().setFormat(-2);
        e.setBackgroundColor(0xff000000);
        e.setOnCompletionListener(this);
        e.setOnPreparedListener(this);
        e.setOnErrorListener(this);
        h.addView(e, layoutparams);
        k = new View(d);
        k.setBackgroundColor(0xff000000);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        bundle.addView(h, layoutparams1);
        if (a)
        {
            layoutparams.addRule(2, 0x4fe0613);
            RelativeLayout relativelayout = new RelativeLayout(d);
            relativelayout.setId(0x4fe0613);
            relativelayout.setBackgroundColor(0xff000000);
            android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            relativelayout.setLayoutParams(layoutparams2);
            layoutparams2.addRule(12);
            Button button = new Button(d);
            j = new Button(d);
            Button button1 = new Button(d);
            button.setBackgroundResource(0x1080025);
            android.widget.RelativeLayout.LayoutParams layoutparams3;
            android.widget.RelativeLayout.LayoutParams layoutparams4;
            android.widget.RelativeLayout.LayoutParams layoutparams5;
            if (e.isPlaying())
            {
                j.setBackgroundResource(0x1080023);
            } else
            {
                j.setBackgroundResource(0x1080024);
            }
            button1.setBackgroundResource(0x1080038);
            layoutparams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams4 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams3.addRule(14);
            relativelayout.addView(j, layoutparams3);
            layoutparams5.addRule(0, j.getId());
            relativelayout.addView(button);
            layoutparams4.addRule(11);
            relativelayout.addView(button1, layoutparams4);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final av a;

                public final void onClick(View view)
                {
                    if (a.e != null)
                    {
                        a.e.seekTo(0);
                    }
                }

            
            {
                a = av.this;
                super();
            }
            });
            j.setOnClickListener(new android.view.View.OnClickListener() {

                final av a;

                public final void onClick(View view)
                {
label0:
                    {
                        if (a.e != null)
                        {
                            if (!a.e.isPlaying())
                            {
                                break label0;
                            }
                            a.k();
                            a.j.setBackgroundResource(0x1080024);
                        }
                        return;
                    }
                    if (a.c)
                    {
                        a.c(0);
                    } else
                    if (a.n && !a.c)
                    {
                        a.l();
                    } else
                    {
                        a.c(a.b);
                    }
                    a.j.setBackgroundResource(0x1080023);
                }

            
            {
                a = av.this;
                super();
            }
            });
            button1.setOnClickListener(new android.view.View.OnClickListener() {

                final av a;

                public final void onClick(View view)
                {
                    if (a.e != null)
                    {
                        av.a(a);
                        a.j();
                    }
                }

            
            {
                a = av.this;
                super();
            }
            });
            bundle.addView(relativelayout, layoutparams2);
        }
        k.setLayoutParams(layoutparams);
        bundle.addView(k);
        i = new ProgressBar(d);
        i.setIndeterminate(true);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        i.setLayoutParams(layoutparams);
        bundle.addView(i);
        i.setVisibility(4);
        a(((View) (bundle)));
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
        if (e != null && e.isPlaying() && e.getCurrentPosition() > 0)
        {
            e.setBackgroundColor(0);
            l.sendEmptyMessageDelayed(5, 100L);
            return;
        } else
        {
            l.sendEmptyMessageDelayed(4, 50L);
            return;
        }
_L3:
        if (e != null && e.isPlaying() && e.getCurrentPosition() > 0)
        {
            k.setVisibility(4);
            i.setVisibility(4);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final boolean a(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0 && !o)
        {
            return true;
        } else
        {
            return super.a(i1, keyevent);
        }
    }

    protected final void b()
    {
        super.b();
        k.bringToFront();
        k.setVisibility(0);
        m = false;
        al.a();
        if (p && !n)
        {
            l();
        }
    }

    protected final void b(Bundle bundle)
    {
        bundle.putInt("currentVideoPosition", b);
        bundle.putBoolean("isVideoCompleted", c);
        bundle.putBoolean("isVideoCompletedOnce", o);
        bundle.putBoolean("hasBottomBar", a);
        bundle.putBoolean("shouldSetUri", q);
        bundle.putBoolean("isUserPausing", n);
        bundle.putBoolean("isPaused", m);
        super.b(bundle);
    }

    public final void b(boolean flag)
    {
        super.b(flag);
        p = flag;
        if (!m && flag && !n)
        {
            l();
        }
    }

    protected final void c()
    {
        super.c();
        m = true;
        al.a();
        n();
    }

    protected final void c(int i1)
    {
        String s;
        n = false;
        s = super.d.getIntent().getData().toString();
        String.format("playVideo path: %s", new Object[] {
            s
        });
        al.b();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (s.length() != 0 && e != null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        m();
        return;
        try
        {
            c = false;
            if (q && e != null)
            {
                e.setVideoURI(Uri.parse(s));
            }
            e.requestFocus();
            e.seekTo(i1);
            if (((PowerManager)super.d.getSystemService("power")).isScreenOn())
            {
                if (i != null)
                {
                    i.bringToFront();
                    i.setVisibility(0);
                }
                if (j != null)
                {
                    j.setBackgroundResource(0x1080023);
                }
                e.start();
                if (!l.hasMessages(4))
                {
                    l.sendEmptyMessage(4);
                    return;
                }
            }
        }
        catch (Exception exception)
        {
            al.a("VideoPlayerActivity", "playVideo error: ", exception);
            (new StringBuilder("error: ")).append(exception);
            m();
        }
        return;
    }

    protected final void c(Bundle bundle)
    {
        b = bundle.getInt("currentVideoPosition");
        c = bundle.getBoolean("isVideoCompleted");
        o = bundle.getBoolean("isVideoCompletedOnce");
        a = bundle.getBoolean("hasBottomBar", a);
        q = bundle.getBoolean("shouldSetUri", q);
        n = bundle.getBoolean("isUserPausing", n);
        m = bundle.getBoolean("isPaused", m);
        super.c(bundle);
    }

    public final void d()
    {
        super.d();
    }

    protected final void h()
    {
        al.b();
        if (e != null)
        {
            c(0);
        }
    }

    protected final void i()
    {
        al.b();
        if (e != null)
        {
            q = true;
            j();
        }
    }

    protected final void j()
    {
        al.b();
        if (e != null)
        {
            if (e.isPlaying())
            {
                e.stopPlayback();
            }
            e = null;
        }
        a();
    }

    protected final void k()
    {
        n = true;
        n();
    }

    protected final void l()
    {
        boolean flag;
        if (e != null && !e.isPlaying() && !c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            c(b);
        }
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        o = true;
        c = true;
        if (j != null && !e.isPlaying())
        {
            j.setBackgroundResource(0x1080024);
        }
        al.a();
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        return false;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        al.b();
    }
}
