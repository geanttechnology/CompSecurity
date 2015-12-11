// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import com.smule.android.console.n;

public class v
    implements n
{

    private float a;
    private int b[] = {
        0x7f050025, 0x7f050027, 0x7f050028
    };
    private int c[];
    private int d[];
    private int e;
    private SoundPool f;

    public v(Context context)
    {
        int i = 0;
        super();
        a = 1.0F;
        c = new int[b.length];
        d = new int[b.length];
        f = new SoundPool(1, 3, 0);
        for (; i < b.length; i++)
        {
            MediaPlayer mediaplayer = MediaPlayer.create(context, b[i]);
            if (mediaplayer != null)
            {
                d[i] = mediaplayer.getDuration();
                mediaplayer.release();
                c[i] = f.load(context, b[i], 1);
            }
        }

    }

    private int a(SoundPool soundpool, int i, boolean flag)
    {
        int j = 0;
        if (i != 0)
        {
            float f1 = a;
            float f2 = a;
            if (flag)
            {
                j = -1;
            } else
            {
                j = 0;
            }
            j = soundpool.play(i, f1, f2, 0, j, 1.0F);
        }
        return j;
    }

    static int a(v v1)
    {
        return v1.e;
    }

    static int a(v v1, SoundPool soundpool, int i, boolean flag)
    {
        return v1.a(soundpool, i, flag);
    }

    static SoundPool b(v v1)
    {
        return v1.f;
    }

    static int[] c(v v1)
    {
        return v1.c;
    }

    static int[] d(v v1)
    {
        return v1.d;
    }

    public String a()
    {
        return "sound";
    }

    public String a(String as[])
    {
        if (as[1].equals("play"))
        {
            e = a(f, c[0], true);
            (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {

                final v a;

                public void run()
                {
                    if (v.a(a) != 0)
                    {
                        v.b(a).stop(v.a(a));
                    }
                    Handler handler = new Handler();
                    Runnable runnable = new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            v.a(a.a, v.b(a.a), v.c(a.a)[2], false);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    };
                    int i;
                    if (v.d(a)[1] != 0)
                    {
                        i = v.d(a)[1];
                    } else
                    {
                        i = 2000;
                    }
                    handler.postDelayed(runnable, i + 200);
                    v.a(a, v.b(a), v.c(a)[1], false);
                }

            
            {
                a = v.this;
                super();
            }
            }, 2100L);
        } else
        {
            a = (float)Math.max(Math.min(Integer.parseInt(as[2]), 100), 0) / 100F;
        }
        return "ok";
    }
}
