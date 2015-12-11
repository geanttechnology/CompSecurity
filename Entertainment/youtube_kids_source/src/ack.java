// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;

public final class ack
{

    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final acd f;

    ack(acd acd1)
    {
        f = acd1;
        super();
        a = 1;
    }

    public void a(int i)
    {
        a = i;
        if (i == 3)
        {
            acd acd1 = f;
            if (!acd1.a.isPlaying() && acd1.b.requestAudioFocus(acd1.h, 3, 1) == 1)
            {
                acd1.a.start();
            }
        } else
        if (i == 4 || i == 5 || i == 6 || i == 1)
        {
            acd acd2 = f;
            if (acd2.a.isPlaying())
            {
                acd2.a.pause();
                acd2.b.abandonAudioFocus(acd2.h);
                return;
            }
        }
    }

    final void a(boolean flag)
    {
        e = flag;
        if (flag)
        {
            a(4);
            f.e = false;
        } else
        if (f.c.getBoolean("sound_effects", true))
        {
            f.e = true;
            return;
        }
    }
}
