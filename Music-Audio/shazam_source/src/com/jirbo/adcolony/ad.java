// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import java.io.FileDescriptor;
import java.io.IOException;

// Referenced classes of package com.jirbo.adcolony:
//            q

final class ad extends SurfaceView
    implements android.widget.MediaController.MediaPlayerControl
{

    private android.media.MediaPlayer.OnCompletionListener A;
    private android.media.MediaPlayer.OnErrorListener B;
    private android.media.MediaPlayer.OnBufferingUpdateListener C;
    String a;
    Uri b;
    FileDescriptor c;
    int d;
    int e;
    int f;
    SurfaceHolder g;
    MediaPlayer h;
    int i;
    int j;
    int k;
    int l;
    MediaController m;
    android.media.MediaPlayer.OnCompletionListener n;
    android.media.MediaPlayer.OnPreparedListener o;
    int p;
    android.media.MediaPlayer.OnErrorListener q;
    int r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    int w;
    android.media.MediaPlayer.OnVideoSizeChangedListener x;
    android.media.MediaPlayer.OnPreparedListener y;
    android.view.SurfaceHolder.Callback z;

    ad(Context context)
    {
        super(context);
        a = "ADCCustomVideoView";
        e = 0;
        f = 0;
        g = null;
        h = null;
        x = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

            final ad a;

            public final void onVideoSizeChanged(MediaPlayer mediaplayer, int i1, int j1)
            {
                a.i = mediaplayer.getVideoWidth();
                a.j = mediaplayer.getVideoHeight();
                if (a.i != 0 && a.j != 0)
                {
                    a.getHolder().setFixedSize(a.i, a.j);
                }
            }

            
            {
                a = ad.this;
                super();
            }
        };
        y = new android.media.MediaPlayer.OnPreparedListener() {

            final ad a;

            public final void onPrepared(MediaPlayer mediaplayer)
            {
                int i1;
                a.e = 2;
                ad ad1 = a;
                ad ad2 = a;
                a.u = true;
                ad2.t = true;
                ad1.s = true;
                if (a.o != null)
                {
                    a.o.onPrepared(a.h);
                }
                if (a.m != null)
                {
                    a.m.setEnabled(true);
                }
                a.i = mediaplayer.getVideoWidth();
                a.j = mediaplayer.getVideoHeight();
                i1 = a.r;
                if (i1 != 0)
                {
                    a.seekTo(i1);
                }
                if (a.i == 0 || a.j == 0) goto _L2; else goto _L1
_L1:
                a.getHolder().setFixedSize(a.i, a.j);
                if (a.k != a.i || a.l != a.j) goto _L4; else goto _L3
_L3:
                if (a.f != 3) goto _L6; else goto _L5
_L5:
                a.start();
                if (a.m != null)
                {
                    a.m.show();
                }
_L4:
                return;
_L6:
                if (!a.isPlaying() && (i1 != 0 || a.getCurrentPosition() > 0) && a.m != null)
                {
                    a.m.show(0);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (a.f == 3)
                {
                    a.start();
                    return;
                }
                if (true) goto _L4; else goto _L7
_L7:
            }

            
            {
                a = ad.this;
                super();
            }
        };
        A = new android.media.MediaPlayer.OnCompletionListener() {

            final ad a;

            public final void onCompletion(MediaPlayer mediaplayer)
            {
                a.e = 5;
                a.f = 5;
                if (a.m != null)
                {
                    a.m.hide();
                }
                if (a.n != null)
                {
                    a.n.onCompletion(a.h);
                }
            }

            
            {
                a = ad.this;
                super();
            }
        };
        B = new android.media.MediaPlayer.OnErrorListener() {

            final ad a;

            public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                (new StringBuilder("Error: ")).append(i1).append(",").append(j1);
                a.e = -1;
                a.f = -1;
                if (a.m != null)
                {
                    a.m.hide();
                }
                while (a.q != null && a.q.onError(a.h, i1, j1) || a.getWindowToken() == null) 
                {
                    return true;
                }
                ad.b().getResources();
                if (i1 == 200)
                {
                    mediaplayer = "Invalid progressive playback";
                } else
                {
                    mediaplayer = "Unknown error";
                }
                (new android.app.AlertDialog.Builder(ad.b())).setTitle("ERROR").setMessage(mediaplayer).setPositiveButton("OKAY", new android.content.DialogInterface.OnClickListener(this) {

                    final _cls4 a;

                    public final void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (a.a.n != null)
                        {
                            a.a.n.onCompletion(a.a.h);
                        }
                    }

            
            {
                a = _pcls4;
                super();
            }
                }).setCancelable(false).show();
                return true;
            }

            
            {
                a = ad.this;
                super();
            }
        };
        C = new android.media.MediaPlayer.OnBufferingUpdateListener() {

            final ad a;

            public final void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
            {
                a.p = i1;
            }

            
            {
                a = ad.this;
                super();
            }
        };
        z = new android.view.SurfaceHolder.Callback() {

            final ad a;

            public final void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
            {
                boolean flag = true;
                a.k = j1;
                a.l = k1;
                if (a.f == 3)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (a.i == j1 && a.j == k1)
                {
                    j1 = ((flag) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
                if (a.h != null && i1 != 0 && j1 != 0)
                {
                    if (a.r != 0)
                    {
                        a.seekTo(a.r);
                    }
                    a.start();
                    if (a.m != null)
                    {
                        a.m.show();
                    }
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceholder)
            {
                a.g = surfaceholder;
                if (a.h == null || a.e != 6 || a.f != 7)
                {
                    break MISSING_BLOCK_LABEL_141;
                }
                a.h.setDisplay(a.g);
                surfaceholder = a;
                if (((ad) (surfaceholder)).g != null || ((ad) (surfaceholder)).e != 6) goto _L2; else goto _L1
_L1:
                surfaceholder.f = 7;
_L4:
                return;
_L2:
                if (((ad) (surfaceholder)).h != null && ((ad) (surfaceholder)).e == 6)
                {
                    ((ad) (surfaceholder)).h.start();
                    surfaceholder.e = ((ad) (surfaceholder)).w;
                    surfaceholder.f = ((ad) (surfaceholder)).w;
                    return;
                }
                if (((ad) (surfaceholder)).e != 8) goto _L4; else goto _L3
_L3:
                surfaceholder.c();
                return;
                ad.a(a);
                return;
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
                a.g = null;
                if (a.m != null)
                {
                    a.m.hide();
                }
                if (a.e != 6)
                {
                    ad.b(a);
                }
            }

            
            {
                a = ad.this;
                super();
            }
        };
        i = 0;
        j = 0;
        getHolder().addCallback(z);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (v)
        {
            requestFocus();
        }
        e = 0;
        f = 0;
    }

    static void a(ad ad1)
    {
        ad1.c();
    }

    private void a(boolean flag)
    {
        if (h != null)
        {
            h.reset();
            h.release();
            h = null;
            e = 0;
            if (flag)
            {
                f = 0;
            }
        }
    }

    static Activity b()
    {
        return com.jirbo.adcolony.q.b();
    }

    static void b(ad ad1)
    {
        ad1.a(true);
    }

    private void d()
    {
        if (m.isShowing())
        {
            m.hide();
            return;
        } else
        {
            m.show();
            return;
        }
    }

    private boolean e()
    {
        return h != null && e != -1 && e != 0 && e != 1;
    }

    public final void a()
    {
        if (h != null)
        {
            h.stop();
            h.release();
            h = null;
            e = 0;
            f = 0;
        }
    }

    final void c()
    {
        if ((b != null || c != null) && g != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        com.jirbo.adcolony.q.b().sendBroadcast(intent);
        a(false);
        h = new MediaPlayer();
        h.setOnPreparedListener(y);
        h.setOnVideoSizeChangedListener(x);
        d = -1;
        h.setOnCompletionListener(A);
        h.setOnErrorListener(B);
        h.setOnBufferingUpdateListener(C);
        p = 0;
        if (b == null) goto _L4; else goto _L3
_L3:
        h.setDataSource(com.jirbo.adcolony.q.b(), b);
_L6:
        h.setDisplay(g);
        h.setAudioStreamType(3);
        h.setScreenOnWhilePlaying(true);
        h.prepare();
        e = 1;
        if (h == null || m == null) goto _L1; else goto _L5
_L5:
        Object obj;
        m.setMediaPlayer(this);
        if (!(getParent() instanceof View))
        {
            break MISSING_BLOCK_LABEL_377;
        }
        obj = (View)getParent();
_L7:
        m.setAnchorView(((View) (obj)));
        m.setEnabled(e());
        return;
_L4:
        try
        {
            h.setDataSource(c);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (b != null)
            {
                (new StringBuilder("Unable to open content: ")).append(b);
            }
            e = -1;
            f = -1;
            B.onError(h, 1, 0);
            ((IOException) (obj)).printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (b != null)
            {
                (new StringBuilder("Unable to open content: ")).append(b);
            }
            e = -1;
            f = -1;
            B.onError(h, 1, 0);
            ((IllegalArgumentException) (obj)).printStackTrace();
            return;
        }
          goto _L6
        obj = this;
          goto _L7
    }

    public final boolean canPause()
    {
        return s;
    }

    public final boolean canSeekBackward()
    {
        return t;
    }

    public final boolean canSeekForward()
    {
        return u;
    }

    public final int getAudioSessionId()
    {
        return 0;
    }

    public final int getBufferPercentage()
    {
        if (h != null)
        {
            return p;
        } else
        {
            return 0;
        }
    }

    public final int getCurrentPosition()
    {
        if (e())
        {
            return h.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public final int getDuration()
    {
        if (e())
        {
            if (d > 0)
            {
                return d;
            } else
            {
                d = h.getDuration();
                return d;
            }
        } else
        {
            d = -1;
            return d;
        }
    }

    public final boolean isPlaying()
    {
        return e() && h.isPlaying();
    }

    public final boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        boolean flag;
        if (i1 != 4 && i1 != 24 && i1 != 25 && i1 != 82 && i1 != 5 && i1 != 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (e() && flag && m != null)
        {
            if (i1 == 79 || i1 == 85)
            {
                if (h.isPlaying())
                {
                    pause();
                    m.show();
                    return true;
                } else
                {
                    start();
                    m.hide();
                    return true;
                }
            }
            if (i1 == 86 && h.isPlaying())
            {
                pause();
                m.show();
            } else
            {
                d();
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected final void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        k1 = getDefaultSize(i, i1);
        l1 = getDefaultSize(j, j1);
        i1 = l1;
        j1 = k1;
        if (i <= 0) goto _L2; else goto _L1
_L1:
        i1 = l1;
        j1 = k1;
        if (j <= 0) goto _L2; else goto _L3
_L3:
        if (i * l1 <= j * k1) goto _L5; else goto _L4
_L4:
        i1 = (j * k1) / i;
        j1 = k1;
_L2:
        setMeasuredDimension(j1, i1);
        return;
_L5:
        i1 = l1;
        j1 = k1;
        if (i * l1 < j * k1)
        {
            j1 = (i * l1) / j;
            i1 = l1;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        if (e() && m != null)
        {
            d();
        }
        return false;
    }

    public final boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (e() && m != null)
        {
            d();
        }
        return false;
    }

    public final void pause()
    {
        if (e() && h.isPlaying())
        {
            h.pause();
            e = 4;
        }
        f = 4;
    }

    public final void seekTo(int i1)
    {
        if (e())
        {
            h.seekTo(i1);
            r = 0;
            return;
        } else
        {
            r = i1;
            return;
        }
    }

    public final void start()
    {
        if (e())
        {
            h.start();
            e = 3;
        }
        f = 3;
    }
}
