// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a;

import android.media.MediaPlayer;
import com.facebook.ads.a.g.a.a.b;

// Referenced classes of package com.facebook.ads.a.g.a:
//            a

final class a
    implements b
{

    final a a;
    final a b;

    public final void a(MediaPlayer mediaplayer)
    {
        MediaPlayer mediaplayer1 = mediaplayer;
        if (mediaplayer.isPlaying())
        {
            mediaplayer.stop();
            mediaplayer.release();
            mediaplayer1 = new MediaPlayer();
        }
        mediaplayer1.setVolume(b.getVolume(), b.getVolume());
        mediaplayer1.setLooping(false);
        if (a.getAutoplay())
        {
            a.();
            return;
        }
        try
        {
            a.c();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            mediaplayer.printStackTrace();
        }
        return;
    }

    (a a1, a a2)
    {
        b = a1;
        a = a2;
        super();
    }
}
