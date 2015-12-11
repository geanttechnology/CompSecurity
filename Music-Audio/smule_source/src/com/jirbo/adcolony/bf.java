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
import android.util.Log;
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

class bf extends SurfaceView
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

    bf(Context context)
    {
        super(context);
        a = "ADCCustomVideoView";
        e = 0;
        f = 0;
        g = null;
        h = null;
        x = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

            final bf a;

            public void onVideoSizeChanged(MediaPlayer mediaplayer, int i1, int j1)
            {
                a.i = mediaplayer.getVideoWidth();
                a.j = mediaplayer.getVideoHeight();
                if (a.i != 0 && a.j != 0)
                {
                    a.getHolder().setFixedSize(a.i, a.j);
                }
            }

            
            {
                a = bf.this;
                super();
            }
        };
        y = new android.media.MediaPlayer.OnPreparedListener() {

            final bf a;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                int i1;
                a.e = 2;
                bf bf1 = a;
                bf bf2 = a;
                a.u = true;
                bf2.t = true;
                bf1.s = true;
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
                a = bf.this;
                super();
            }
        };
        A = new android.media.MediaPlayer.OnCompletionListener() {

            final bf a;

            public void onCompletion(MediaPlayer mediaplayer)
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
                a = bf.this;
                super();
            }
        };
        B = new android.media.MediaPlayer.OnErrorListener() {

            final bf a;

            public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                Log.d(a.a, (new StringBuilder()).append("Error: ").append(i1).append(",").append(j1).toString());
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
                a.b().getResources();
                if (i1 == 200)
                {
                    mediaplayer = "Invalid progressive playback";
                } else
                {
                    mediaplayer = "Unknown error";
                }
                (new android.app.AlertDialog.Builder(a.b())).setTitle("ERROR").setMessage(mediaplayer).setPositiveButton("OKAY", new android.content.DialogInterface.OnClickListener(this) {

                    final _cls4 a;

                    public void onClick(DialogInterface dialoginterface, int i1)
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
                a = bf.this;
                super();
            }
        };
        C = new android.media.MediaPlayer.OnBufferingUpdateListener() {

            final bf a;

            public void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
            {
                a.p = i1;
            }

            
            {
                a = bf.this;
                super();
            }
        };
        z = new android.view.SurfaceHolder.Callback() {

            final bf a;

            public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
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

            public void surfaceCreated(SurfaceHolder surfaceholder)
            {
                a.g = surfaceholder;
                if (a.h != null && a.e == 6 && a.f == 7)
                {
                    a.h.setDisplay(a.g);
                    a.c();
                    return;
                } else
                {
                    bf.a(a);
                    return;
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
                a.g = null;
                if (a.m != null)
                {
                    a.m.hide();
                }
                if (a.e != 6)
                {
                    bf.a(a, true);
                }
            }

            
            {
                a = bf.this;
                super();
            }
        };
        d();
    }

    static void a(bf bf1)
    {
        bf1.e();
    }

    static void a(bf bf1, boolean flag)
    {
        bf1.a(flag);
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

    private void d()
    {
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

    private void e()
    {
        if (b == null && c == null || g == null)
        {
            return;
        }
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        b().sendBroadcast(intent);
        a(false);
        h = new MediaPlayer();
        h.setOnPreparedListener(y);
        h.setOnVideoSizeChangedListener(x);
        d = -1;
        h.setOnCompletionListener(A);
        h.setOnErrorListener(B);
        h.setOnBufferingUpdateListener(C);
        p = 0;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        h.setDataSource(b(), b);
_L1:
        Object obj;
        h.setDisplay(g);
        h.setAudioStreamType(3);
        h.setScreenOnWhilePlaying(true);
        h.prepare();
        e = 1;
        f();
        return;
        try
        {
            h.setDataSource(c);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (b != null)
            {
                Log.w(a, (new StringBuilder()).append("Unable to open content: ").append(b).toString(), ((Throwable) (obj)));
            } else
            {
                Log.w(a, "Unable to open content");
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
                Log.w(a, (new StringBuilder()).append("Unable to open content: ").append(b).toString(), ((Throwable) (obj)));
            } else
            {
                Log.w(a, "Unable to open content");
            }
            e = -1;
            f = -1;
            B.onError(h, 1, 0);
            ((IllegalArgumentException) (obj)).printStackTrace();
            return;
        }
          goto _L1
    }

    private void f()
    {
        if (h != null && m != null)
        {
            m.setMediaPlayer(this);
            Object obj;
            if (getParent() instanceof View)
            {
                obj = (View)getParent();
            } else
            {
                obj = this;
            }
            m.setAnchorView(((View) (obj)));
            m.setEnabled(h());
        }
    }

    private void g()
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

    private boolean h()
    {
        return h != null && e != -1 && e != 0 && e != 1;
    }

    public void a()
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

    public void a(android.media.MediaPlayer.OnCompletionListener oncompletionlistener)
    {
        n = oncompletionlistener;
    }

    public void a(android.media.MediaPlayer.OnErrorListener onerrorlistener)
    {
        q = onerrorlistener;
    }

    public void a(FileDescriptor filedescriptor)
    {
        c = filedescriptor;
        r = 0;
        e();
        requestLayout();
        invalidate();
    }

    Activity b()
    {
        return com.jirbo.adcolony.q.d();
    }

    public void c()
    {
        if (g == null && e == 6)
        {
            f = 7;
        } else
        {
            if (h != null && e == 6)
            {
                h.start();
                e = w;
                f = w;
                return;
            }
            if (e == 8)
            {
                e();
                return;
            }
        }
    }

    public boolean canPause()
    {
        return s;
    }

    public boolean canSeekBackward()
    {
        return t;
    }

    public boolean canSeekForward()
    {
        return u;
    }

    public int getAudioSessionId()
    {
        return 0;
    }

    public int getBufferPercentage()
    {
        if (h != null)
        {
            return p;
        } else
        {
            return 0;
        }
    }

    public int getCurrentPosition()
    {
        if (h())
        {
            return h.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public int getDuration()
    {
        if (h())
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

    public boolean isPlaying()
    {
        return h() && h.isPlaying();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        boolean flag;
        if (i1 != 4 && i1 != 24 && i1 != 25 && i1 != 82 && i1 != 5 && i1 != 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (h() && flag && m != null)
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
                g();
            }
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected void onMeasure(int i1, int j1)
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

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (h() && m != null)
        {
            g();
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionevent)
    {
        if (h() && m != null)
        {
            g();
        }
        return false;
    }

    public void pause()
    {
        if (h() && h.isPlaying())
        {
            h.pause();
            e = 4;
        }
        f = 4;
    }

    public void seekTo(int i1)
    {
        if (h())
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

    public void start()
    {
        if (h())
        {
            h.start();
            e = 3;
        }
        f = 3;
    }
}
