// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            ck, ew

public final class cj extends FrameLayout
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{

    final ew a;
    final MediaController b;
    final ck c = new ck(this);
    final VideoView d;
    long e;
    String f;

    public cj(Context context, ew ew1)
    {
        super(context);
        a = ew1;
        d = new VideoView(context);
        ew1 = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
        addView(d, ew1);
        b = new MediaController(context);
        c.a();
        d.setOnCompletionListener(this);
        d.setOnPreparedListener(this);
        d.setOnErrorListener(this);
    }

    public static void a(ew ew1, String s, String s1)
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
        a(ew1, "error", ((Map) (hashmap)));
    }

    static void a(ew ew1, String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap(2);
        hashmap.put(s1, s2);
        a(ew1, s, ((Map) (hashmap)));
    }

    private static void a(ew ew1, String s, Map map)
    {
        map.put("event", s);
        ew1.a("onVideoEvent", map);
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        a(a, "ended", new HashMap(1));
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        a(a, String.valueOf(i), String.valueOf(j));
        return true;
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        float f1 = (float)d.getDuration() / 1000F;
        a(a, "canplaythrough", "duration", String.valueOf(f1));
    }
}
