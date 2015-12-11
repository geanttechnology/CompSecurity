// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.Map;
import xi;

// Referenced classes of package com.google.android.gms.internal:
//            gu

public final class dt extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    private final gu a;
    private final MediaController b;
    private final xi c = new xi(this);
    private final VideoView d;
    private long e;
    private String f;

    public dt(Context context, gu gu1)
    {
        super(context);
        a = gu1;
        d = new VideoView(context);
        gu1 = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        addView(d, gu1);
        b = new MediaController(context);
        c.b();
        d.setOnCompletionListener(this);
        d.setOnPreparedListener(this);
        d.setOnErrorListener(this);
    }

    private static void a(gu gu1, String s)
    {
        a(gu1, s, ((Map) (new HashMap(1))));
    }

    public static void a(gu gu1, String s, String s1)
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
        a(gu1, "error", ((Map) (hashmap)));
    }

    private static void a(gu gu1, String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put(s1, s2);
        a(gu1, s, ((Map) (hashmap)));
    }

    private static void a(gu gu1, String s, Map map)
    {
        map.put("event", s);
        gu1.a("onVideoEvent", map);
    }

    public void a()
    {
        c.a();
        d.stopPlayback();
    }

    public void a(int i)
    {
        d.seekTo(i);
    }

    public void a(MotionEvent motionevent)
    {
        d.dispatchTouchEvent(motionevent);
    }

    public void a(String s)
    {
        f = s;
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            d.setMediaController(b);
            return;
        } else
        {
            b.hide();
            d.setMediaController(null);
            return;
        }
    }

    public void b()
    {
        if (!TextUtils.isEmpty(f))
        {
            d.setVideoPath(f);
            return;
        } else
        {
            a(a, "no_src", ((String) (null)));
            return;
        }
    }

    public void c()
    {
        d.pause();
    }

    public void d()
    {
        d.start();
    }

    public void e()
    {
        long l = d.getCurrentPosition();
        if (e != l)
        {
            float f1 = (float)l / 1000F;
            a(a, "timeupdate", "time", String.valueOf(f1));
            e = l;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a(a, "ended");
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        a(a, String.valueOf(i), String.valueOf(j));
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        float f1 = (float)d.getDuration() / 1000F;
        a(a, "canplaythrough", "duration", String.valueOf(f1));
    }
}
