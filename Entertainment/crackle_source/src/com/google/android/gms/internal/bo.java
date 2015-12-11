// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            cw, cs

public final class bo extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    private static final class a
    {

        private final Runnable ep;
        private volatile boolean gV;

        static boolean a(a a1)
        {
            return a1.gV;
        }

        public void ah()
        {
            cs.iI.postDelayed(ep, 250L);
        }

        public void cancel()
        {
            gV = true;
            cs.iI.removeCallbacks(ep);
        }

        public a(bo bo1)
        {
            gV = false;
            ep = new _cls1(this, bo1);
        }
    }


    private final MediaController gQ;
    private final a gR = new a(this);
    private final VideoView gS;
    private long gT;
    private String gU;
    private final cw gv;

    public bo(Context context, cw cw1)
    {
        super(context);
        gv = cw1;
        gS = new VideoView(context);
        cw1 = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        addView(gS, cw1);
        gQ = new MediaController(context);
        gR.ah();
        gS.setOnCompletionListener(this);
        gS.setOnPreparedListener(this);
        gS.setOnErrorListener(this);
    }

    private static void a(cw cw1, String s)
    {
        a(cw1, s, ((Map) (new HashMap(1))));
    }

    public static void a(cw cw1, String s, String s1)
    {
        HashMap hashmap;
        boolean flag;
        byte byte0;
        if (s1 == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 3;
        }
        hashmap = new HashMap(byte0);
        hashmap.put("what", s);
        if (!flag)
        {
            hashmap.put("extra", s1);
        }
        a(cw1, "error", ((Map) (hashmap)));
    }

    private static void a(cw cw1, String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put(s1, s2);
        a(cw1, s, ((Map) (hashmap)));
    }

    private static void a(cw cw1, String s, Map map)
    {
        map.put("event", s);
        cw1.a("onVideoEvent", map);
    }

    public void af()
    {
        if (!TextUtils.isEmpty(gU))
        {
            gS.setVideoPath(gU);
            return;
        } else
        {
            a(gv, "no_src", ((String) (null)));
            return;
        }
    }

    public void ag()
    {
        long l = gS.getCurrentPosition();
        if (gT != l)
        {
            float f = (float)l / 1000F;
            a(gv, "timeupdate", "time", String.valueOf(f));
            gT = l;
        }
    }

    public void b(MotionEvent motionevent)
    {
        gS.dispatchTouchEvent(motionevent);
    }

    public void destroy()
    {
        gR.cancel();
        gS.stopPlayback();
    }

    public void i(boolean flag)
    {
        if (flag)
        {
            gS.setMediaController(gQ);
            return;
        } else
        {
            gQ.hide();
            gS.setMediaController(null);
            return;
        }
    }

    public void n(String s)
    {
        gU = s;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a(gv, "ended");
    }

    public boolean onError(MediaPlayer mediaplayer, int j, int k)
    {
        a(gv, String.valueOf(j), String.valueOf(k));
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        float f = (float)gS.getDuration() / 1000F;
        a(gv, "canplaythrough", "duration", String.valueOf(f));
    }

    public void pause()
    {
        gS.pause();
    }

    public void play()
    {
        gS.start();
    }

    public void seekTo(int j)
    {
        gS.seekTo(j);
    }

    // Unreferenced inner class com/google/android/gms/internal/bo$a$1

/* anonymous class */
    class a._cls1
        implements Runnable
    {

        private final WeakReference gW;
        final bo gX;
        final a gY;

        public void run()
        {
            bo bo1 = (bo)gW.get();
            if (!a.a(gY) && bo1 != null)
            {
                bo1.ag();
                gY.ah();
            }
        }

            
            {
                gY = a1;
                gX = bo1;
                super();
                gW = new WeakReference(gX);
            }
    }

}
